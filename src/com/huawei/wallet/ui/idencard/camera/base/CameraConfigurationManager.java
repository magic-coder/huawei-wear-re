package com.huawei.wallet.ui.idencard.camera.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CameraConfigurationManager {
    List<Size> f21565a;
    private final Context f21566b;
    private Point f21567c;
    private Point f21568d = new Point();
    private int f21569e;

    public CameraConfigurationManager(Context context) {
        this.f21566b = context;
    }

    public Point m28399a() {
        return this.f21568d;
    }

    public int m28402b() {
        return this.f21569e;
    }

    public void m28401a(Camera camera) {
        this.f21569e = camera.getParameters().getPreviewFormat();
        this.f21567c = m28398c();
        LogC.m28530b("Screen resolution: " + this.f21567c, false);
        this.f21565a = camera.getParameters().getSupportedPreviewSizes();
        if (this.f21567c.y > this.f21567c.x) {
            this.f21568d = m28397a(this.f21565a, (this.f21567c.x * 4) / 3, this.f21567c.x);
        } else {
            this.f21568d = m28397a(this.f21565a, (this.f21567c.y * 4) / 3, this.f21567c.y);
        }
    }

    private Point m28398c() {
        int intValue;
        int i;
        Display defaultDisplay = ((WindowManager) this.f21566b.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        if (VERSION.SDK_INT >= 14 && VERSION.SDK_INT < 17) {
            try {
                i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i3 = i2;
            } catch (IllegalArgumentException e) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (IllegalAccessException e2) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (InvocationTargetException e3) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (NoSuchMethodException e4) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            }
        } else if (VERSION.SDK_INT >= 17) {
            Point point = new Point();
            try {
                Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                i2 = point.y;
                intValue = point.x;
                i3 = i2;
            } catch (IllegalArgumentException e5) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (IllegalAccessException e6) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (InvocationTargetException e7) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            } catch (NoSuchMethodException e8) {
                intValue = i2;
                LogC.m28532c("getRealScreenSize exception", false);
                i = i3;
                i3 = intValue;
                intValue = i;
            }
        } else {
            intValue = i3;
            i3 = i2;
        }
        return new Point(intValue, i3);
    }

    private Point m28397a(List<Size> list, int i, int i2) {
        double d = ((double) i) / ((double) i2);
        if (list == null) {
            return null;
        }
        Size size;
        double abs;
        Size size2 = null;
        double d2 = Double.MAX_VALUE;
        for (Size size3 : list) {
            if (Math.abs((((double) size3.width) / ((double) size3.height)) - d) <= 0.1d) {
                if (((double) Math.abs(size3.height - i2)) < d2) {
                    size = size3;
                    abs = (double) Math.abs(size3.height - i2);
                } else {
                    double d3 = d2;
                    size = size2;
                    abs = d3;
                }
                size2 = size;
                d2 = abs;
            }
        }
        if (size2 == null) {
            d2 = Double.MAX_VALUE;
            for (Size size32 : list) {
                if (((double) Math.abs(size32.height - i2)) < d2) {
                    size = size32;
                    abs = (double) Math.abs(size32.height - i2);
                } else {
                    d3 = d2;
                    size = size2;
                    abs = d3;
                }
                size2 = size;
                d2 = abs;
            }
        }
        if (size2 != null) {
            return new Point(size2.width, size2.height);
        }
        return null;
    }

    public void m28403b(Camera camera) {
        Parameters parameters = camera.getParameters();
        LogC.m28530b("Setting preview size: " + this.f21568d, false);
        parameters.setPreviewSize(this.f21568d.x, this.f21568d.y);
        camera.setParameters(parameters);
    }

    public void m28400a(Activity activity, int i, Camera camera) {
        int i2 = 0;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((i2 + cameraInfo.orientation) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        camera.setDisplayOrientation(i2);
    }

    public int m28404c(Camera camera) {
        return ((ImageFormat.getBitsPerPixel(camera.getParameters().getPreviewFormat()) / 8) * (this.f21568d.x * this.f21568d.y)) * 3;
    }
}
