package com.huawei.sim.esim.qrcode.p506a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.p190v.C2538c;
import com.huawei.sim.esim.p504a.C5899a;

import java.util.regex.Pattern;

/* compiled from: CameraConfigurationManager */
final class C5904b {
    private static final String f20224a = C5904b.class.getSimpleName();
    private static final Pattern f20225e = Pattern.compile(",");
    private final Context f20226b;
    private Point f20227c;
    private Point f20228d;
    private String f20229f;
    private int f20230g;

    C5904b(Context context) {
        this.f20226b = context;
    }

    void m27153a(Camera camera) {
        Parameters parameters = camera.getParameters();
        this.f20230g = parameters.getPreviewFormat();
        this.f20229f = parameters.get("preview-format");
        Display defaultDisplay = ((WindowManager) this.f20226b.getSystemService("window")).getDefaultDisplay();
        this.f20227c = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Point point = new Point();
        point.y = this.f20227c.y;
        point.x = this.f20227c.x;
        if (this.f20227c.x < this.f20227c.y) {
            point.x = this.f20227c.y;
            point.y = this.f20227c.x;
        }
        this.f20228d = C5904b.m27148a(parameters, point);
    }

    Point m27152a() {
        return this.f20228d;
    }

    Point m27155b() {
        return this.f20227c;
    }

    void m27156b(Camera camera) {
        Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f20228d.x, this.f20228d.y);
        m27150a(parameters);
        m27151b(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    String m27157c() {
        return this.f20229f;
    }

    int m27158d() {
        return this.f20230g;
    }

    private static Point m27148a(Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            CharSequence charSequence = parameters.get("preview-size-value");
        } else {
            Object obj = str;
        }
        Point point2 = null;
        if (charSequence != null) {
            point2 = C5904b.m27149a(charSequence, point);
        }
        if (point2 == null) {
            return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return point2;
    }

    private static Point m27149a(CharSequence charSequence, Point point) {
        float f;
        if (point.x == 0 || point.y == 0) {
            f = 0.0f;
        } else {
            f = Math.min((float) point.x, (float) point.y) / Math.max((float) point.x, (float) point.y);
        }
        String[] split = f20225e.split(charSequence);
        int length = split.length;
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i < length) {
            float f5;
            String trim = split[i].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                f5 = f2;
                f2 = f3;
            } else {
                try {
                    float parseFloat = Float.parseFloat(trim.substring(0, indexOf));
                    f5 = Float.parseFloat(trim.substring(indexOf + 1));
                    float min = Math.min(parseFloat, f5) / Math.max(parseFloat, f5);
                    if (f3 == 0.0f) {
                        f4 = f5;
                        f2 = min;
                        f5 = parseFloat;
                    } else if (f3 == 0.0f || Math.abs(min - r0) >= Math.abs(f3 - r0)) {
                        f5 = f2;
                        f2 = f3;
                    } else {
                        f4 = f5;
                        f2 = min;
                        f5 = parseFloat;
                    }
                } catch (NumberFormatException e) {
                    f5 = f2;
                    f2 = f3;
                }
            }
            i++;
            f3 = f2;
            f2 = f5;
        }
        if (f2 <= 0.0f || f4 <= 0.0f) {
            return null;
        }
        return new Point((int) f2, (int) f4);
    }

    private static int m27147a(CharSequence charSequence, int i) {
        String[] split = f20225e.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(((double) i) - parseDouble) >= ((double) Math.abs(i - i3))) {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            } catch (NumberFormatException e) {
            }
        }
        return i3;
    }

    private void m27150a(Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && C5905c.f20231a == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    void m27154a(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        if (z) {
            parameters.setFlashMode("torch");
        } else {
            parameters.setFlashMode("off");
        }
        try {
            camera.setParameters(parameters);
        } catch (Exception e) {
            C2538c.e(f20224a, new Object[]{"Exception e = " + e.getMessage()});
        }
    }

    private void m27151b(Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int parseDouble;
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 <= parseDouble) {
                        parseDouble = 27;
                    }
                    i = parseDouble;
                } catch (NumberFormatException e) {
                    C2538c.e(f20224a, new Object[]{"Exception nfe = " + e.getMessage()});
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    parseDouble = C5899a.m27105a(str3);
                    if (i > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException e2) {
                    C2538c.e(f20224a, new Object[]{"Exception nfe = " + e2.getMessage()});
                }
            }
            CharSequence charSequence = parameters.get("mot-zoom-values");
            if (charSequence != null) {
                i = C5904b.m27147a(charSequence, i);
            }
            str = parameters.get("mot-zoom-step");
            if (str != null) {
                try {
                    parseDouble = (int) (Double.parseDouble(str.trim()) * 10.0d);
                    if (parseDouble > 1) {
                        i -= i % parseDouble;
                    }
                } catch (NumberFormatException e22) {
                    C2538c.e(f20224a, new Object[]{"Exception nfe = " + e22.getMessage()});
                }
            }
            if (!(str2 == null && charSequence == null)) {
                parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}
