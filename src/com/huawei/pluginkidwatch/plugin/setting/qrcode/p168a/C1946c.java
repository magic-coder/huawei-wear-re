package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.util.regex.Pattern;

/* compiled from: CameraConfigurationManager */
final class C1946c {
    private static final String f6754a = C1946c.class.getSimpleName();
    private static final Pattern f6755b = Pattern.compile(",");
    private final Context f6756c;
    private Point f6757d;
    private Point f6758e;
    private int f6759f;
    private String f6760g;

    C1946c(Context context) {
        this.f6756c = context;
    }

    void m10187a(Camera camera) {
        Parameters parameters = camera.getParameters();
        this.f6759f = parameters.getPreviewFormat();
        this.f6760g = parameters.get("preview-format");
        Display defaultDisplay = ((WindowManager) this.f6756c.getSystemService("window")).getDefaultDisplay();
        this.f6757d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Point point = new Point();
        point.x = this.f6757d.x;
        point.y = this.f6757d.y;
        if (this.f6757d.x < this.f6757d.y) {
            point.x = this.f6757d.y;
            point.y = this.f6757d.x;
        }
        this.f6758e = C1946c.m10182a(parameters, point);
    }

    void m10190b(Camera camera) {
        Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f6758e.x, this.f6758e.y);
        m10184a(parameters);
        m10185b(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    Point m10186a() {
        return this.f6758e;
    }

    Point m10189b() {
        return this.f6757d;
    }

    int m10191c() {
        return this.f6759f;
    }

    String m10192d() {
        return this.f6760g;
    }

    private static Point m10182a(Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            CharSequence charSequence = parameters.get("preview-size-value");
        } else {
            Object obj = str;
        }
        Point point2 = null;
        if (charSequence != null) {
            point2 = C1946c.m10183a(charSequence, point);
        }
        if (point2 == null) {
            return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return point2;
    }

    private static Point m10183a(CharSequence charSequence, Point point) {
        float f;
        if (point.x == 0 || point.y == 0) {
            f = 0.0f;
        } else {
            f = Math.min((float) point.x, (float) point.y) / Math.max((float) point.x, (float) point.y);
        }
        String[] split = f6755b.split(charSequence);
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
                    float parseFloat2 = Float.parseFloat(trim.substring(indexOf + 1));
                    f5 = Math.min(parseFloat, parseFloat2) / Math.max(parseFloat, parseFloat2);
                    if (f4 == 0.0f) {
                        f4 = f5;
                        f2 = parseFloat;
                        f5 = parseFloat2;
                    } else if (f4 == 0.0f || Math.abs(f5 - r0) >= Math.abs(f4 - r0)) {
                        f5 = f2;
                        f2 = f3;
                    } else {
                        f4 = f5;
                        f2 = parseFloat;
                        f5 = parseFloat2;
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
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        return new Point((int) f3, (int) f2);
    }

    private static int m10181a(CharSequence charSequence, int i) {
        String[] split = f6755b.split(charSequence);
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
                return i;
            }
        }
        return i3;
    }

    private void m10184a(Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && C1947d.f6761a == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    void m10188a(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        if (z) {
            parameters.setFlashMode("torch");
        } else {
            parameters.setFlashMode("off");
        }
        try {
            camera.setParameters(parameters);
        } catch (Exception e) {
            C2538c.m12680e(f6754a, "Exception e = " + e.getMessage());
        }
    }

    private void m10185b(Parameters parameters) {
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
                    C2538c.m12680e(f6754a, "Exception nfe = " + e.getMessage());
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    parseDouble = C1492l.m6920d(str3);
                    if (i > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException e2) {
                    C2538c.m12680e(f6754a, "Exception nfe = " + e2.getMessage());
                }
            }
            CharSequence charSequence = parameters.get("mot-zoom-values");
            if (charSequence != null) {
                i = C1946c.m10181a(charSequence, i);
            }
            str = parameters.get("mot-zoom-step");
            if (str != null) {
                try {
                    parseDouble = (int) (Double.parseDouble(str.trim()) * 10.0d);
                    if (parseDouble > 1) {
                        i -= i % parseDouble;
                    }
                } catch (NumberFormatException e22) {
                    C2538c.m12680e(f6754a, "Exception nfe = " + e22.getMessage());
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
