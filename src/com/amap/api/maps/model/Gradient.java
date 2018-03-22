package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.util.HashMap;

public class Gradient {
    private int f12023a;
    private int[] f12024b;
    private float[] f12025c;
    private boolean f12026d;

    class C3366a {
        final /* synthetic */ Gradient f12019a;
        private final int f12020b;
        private final int f12021c;
        private final float f12022d;

        private C3366a(Gradient gradient, int i, int i2, float f) {
            this.f12019a = gradient;
            this.f12020b = i;
            this.f12021c = i2;
            this.f12022d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        int i2 = 1;
        this.f12026d = true;
        if (iArr == null || fArr == null) {
            try {
                throw new AMapException("colors and startPoints should not be null");
            } catch (AMapException e) {
                this.f12026d = false;
                Log.e(MapTilsCacheAndResManager.AUTONAVI_PATH, e.getErrorMessage());
                e.printStackTrace();
            }
        } else if (iArr.length != fArr.length) {
            throw new AMapException("colors and startPoints should be same length");
        } else if (iArr.length == 0) {
            throw new AMapException("No colors have been defined");
        } else {
            while (i2 < fArr.length) {
                if (fArr[i2] <= fArr[i2 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
                i2++;
            }
            this.f12023a = i;
            this.f12024b = new int[iArr.length];
            this.f12025c = new float[fArr.length];
            System.arraycopy(iArr, 0, this.f12024b, 0, iArr.length);
            System.arraycopy(fArr, 0, this.f12025c, 0, fArr.length);
            this.f12026d = true;
        }
    }

    private HashMap<Integer, C3366a> m16441a() {
        HashMap<Integer, C3366a> hashMap = new HashMap();
        if (this.f12025c[0] != 0.0f) {
            int argb = Color.argb(0, Color.red(this.f12024b[0]), Color.green(this.f12024b[0]), Color.blue(this.f12024b[0]));
            hashMap.put(Integer.valueOf(0), new C3366a(argb, this.f12024b[0], this.f12025c[0] * ((float) this.f12023a)));
        }
        for (int i = 1; i < this.f12024b.length; i++) {
            hashMap.put(Integer.valueOf((int) (((float) this.f12023a) * this.f12025c[i - 1])), new C3366a(this.f12024b[i - 1], this.f12024b[i], (this.f12025c[i] - this.f12025c[i - 1]) * ((float) this.f12023a)));
        }
        if (this.f12025c[this.f12025c.length - 1] != DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            int length = this.f12025c.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.f12023a) * this.f12025c[length])), new C3366a(this.f12024b[length], this.f12024b[length], ((float) this.f12023a) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f12025c[length])));
        }
        return hashMap;
    }

    protected int[] generateColorMap(double d) {
        int i = 0;
        HashMap a = m16441a();
        int[] iArr = new int[this.f12023a];
        int i2 = 0;
        C3366a c3366a = (C3366a) a.get(Integer.valueOf(0));
        int i3 = 0;
        while (i2 < this.f12023a) {
            int i4;
            C3366a c3366a2;
            if (a.containsKey(Integer.valueOf(i2))) {
                i4 = i2;
                c3366a2 = (C3366a) a.get(Integer.valueOf(i2));
            } else {
                c3366a2 = c3366a;
                i4 = i3;
            }
            iArr[i2] = m16440a(c3366a2.f12020b, c3366a2.f12021c, ((float) (i2 - i4)) / c3366a2.f12022d);
            i2++;
            i3 = i4;
            c3366a = c3366a2;
        }
        if (d != WeightedLatLng.DEFAULT_INTENSITY) {
            while (i < this.f12023a) {
                i3 = iArr[i];
                iArr[i] = Color.argb((int) (((double) Color.alpha(i3)) * d), Color.red(i3), Color.green(i3), Color.blue(i3));
                i++;
            }
        }
        return iArr;
    }

    static int m16440a(int i, int i2, float f) {
        int i3 = 0;
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > BitmapDescriptorFactory.HUE_CYAN) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > BitmapDescriptorFactory.HUE_CYAN) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        while (i3 < 3) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
            i3++;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    protected boolean isAvailable() {
        return this.f12026d;
    }
}
