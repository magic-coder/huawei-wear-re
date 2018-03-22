package com.google.zxing.client.android.p286a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: CameraConfigurationManager */
final class C3773c {
    private final Context f14691a;
    private Point f14692b;
    private Point f14693c;

    C3773c(Context context) {
        this.f14691a = context;
    }

    void m18982a(Camera camera) {
        Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f14691a.getSystemService("window")).getDefaultDisplay();
        this.f14692b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.i("CameraConfiguration", "Screen resolution: " + this.f14692b);
        Point point = new Point();
        point.x = this.f14692b.x;
        point.y = this.f14692b.y;
        if (this.f14692b.x < this.f14692b.y) {
            point.x = this.f14692b.y;
            point.y = this.f14692b.x;
        }
        this.f14693c = m18977a(parameters, point);
        Log.i("CameraConfiguration", "Camera resolution: " + this.f14693c);
    }

    void m18983a(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f14691a);
        m18979a(parameters, defaultSharedPreferences, z);
        String str = null;
        if (defaultSharedPreferences.getBoolean("preferences_auto_focus", true)) {
            if (z || defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", false)) {
                str = C3773c.m18978a(parameters.getSupportedFocusModes(), "auto");
            } else {
                str = C3773c.m18978a(parameters.getSupportedFocusModes(), "continuous-picture", "continuous-video", "auto");
            }
        }
        if (!z && r0 == null) {
            str = C3773c.m18978a(parameters.getSupportedFocusModes(), "macro", "edof");
        }
        if (str != null) {
            parameters.setFocusMode(str);
        }
        if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
            str = C3773c.m18978a(parameters.getSupportedColorEffects(), "negative");
            if (str != null) {
                parameters.setColorEffect(str);
            }
        }
        parameters.setPreviewSize(this.f14693c.x, this.f14693c.y);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    Point m18981a() {
        return this.f14693c;
    }

    Point m18984b() {
        return this.f14692b;
    }

    boolean m18986b(Camera camera) {
        if (camera == null || camera.getParameters() == null) {
            return false;
        }
        String flashMode = camera.getParameters().getFlashMode();
        if (flashMode == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    void m18985b(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        m18980a(parameters, z, false);
        camera.setParameters(parameters);
    }

    private void m18979a(Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        m18980a(parameters, C3776f.m18999a(sharedPreferences) == C3776f.f14707a, z);
    }

    private void m18980a(Parameters parameters, boolean z, boolean z2) {
        String a;
        if (z) {
            a = C3773c.m18978a(parameters.getSupportedFlashModes(), "torch", "on");
        } else {
            a = C3773c.m18978a(parameters.getSupportedFlashModes(), "off");
        }
        if (a != null) {
            parameters.setFlashMode(a);
        }
    }

    private Point m18977a(Parameters parameters, Point point) {
        Collection supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        List<Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new C3774d(this));
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Size previewSize2 : arrayList) {
                stringBuilder.append(previewSize2.width).append('x').append(previewSize2.height).append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + stringBuilder);
        }
        float f = ((float) point.x) / ((float) point.y);
        Point point2 = null;
        float f2 = Float.POSITIVE_INFINITY;
        for (Size previewSize22 : arrayList) {
            int i = previewSize22.width;
            int i2 = previewSize22.height;
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 1024000) {
                int i4;
                Object obj = i < i2 ? 1 : null;
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i;
                }
                if (obj != null) {
                    i3 = i;
                } else {
                    i3 = i2;
                }
                if (i4 == point.x && i3 == point.y) {
                    point2 = new Point(i, i2);
                    Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
                float abs = Math.abs((((float) i4) / ((float) i3)) - f);
                if (abs < f2) {
                    point2 = new Point(i, i2);
                    f2 = abs;
                }
            }
        }
        if (point2 == null) {
            previewSize22 = parameters.getPreviewSize();
            point2 = new Point(previewSize22.width, previewSize22.height);
            Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point2);
        }
        Log.i("CameraConfiguration", "Found best approximate preview size: " + point2);
        return point2;
    }

    private static String m18978a(Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Supported values: " + collection);
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    break;
                }
            }
        }
        String str2 = null;
        Log.i("CameraConfiguration", "Settable value: " + str2);
        return str2;
    }
}
