package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import android.util.Log;
import com.amap.api.mapcore.util.ay;
import com.amap.api.maps.AMapException;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(f12044a, f12045b);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int[] f12044a = new int[]{Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
    private static final float[] f12045b = new float[]{0.2f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT};
    private C3369c f12046c;
    private Collection<WeightedLatLng> f12047d;
    private ay f12048e;
    private int f12049f;
    private Gradient f12050g;
    private int[] f12051h;
    private double[] f12052i;
    private double f12053j;
    private double[] f12054k;

    public class Builder {
        private Collection<WeightedLatLng> f12040a;
        private int f12041b = 12;
        private Gradient f12042c = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double f12043d = HeatmapTileProvider.DEFAULT_OPACITY;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.m16457d(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.f12040a = collection;
            return this;
        }

        public Builder radius(int i) {
            this.f12041b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder gradient(Gradient gradient) {
            this.f12042c = gradient;
            return this;
        }

        public Builder transparency(double d) {
            this.f12043d = Math.max(0.0d, Math.min(d, WeightedLatLng.DEFAULT_INTENSITY));
            return this;
        }

        public HeatmapTileProvider build() {
            if (this.f12040a != null && this.f12040a.size() != 0) {
                return new HeatmapTileProvider();
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e(MapTilsCacheAndResManager.AUTONAVI_PATH, e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.f12047d = builder.f12040a;
        this.f12049f = builder.f12041b;
        this.f12050g = builder.f12042c;
        if (this.f12050g == null || !this.f12050g.isAvailable()) {
            this.f12050g = DEFAULT_GRADIENT;
        }
        this.f12053j = builder.f12043d;
        this.f12052i = m16453a(this.f12049f, ((double) this.f12049f) / 3.0d);
        m16451a(this.f12050g);
        m16456c(this.f12047d);
    }

    private void m16456c(Collection<WeightedLatLng> collection) {
        Collection arrayList = new ArrayList();
        for (WeightedLatLng weightedLatLng : collection) {
            if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                arrayList.add(weightedLatLng);
            }
        }
        this.f12047d = arrayList;
        this.f12048e = m16449a(this.f12047d);
        this.f12046c = new C3369c(this.f12048e);
        for (WeightedLatLng weightedLatLng2 : this.f12047d) {
            this.f12046c.m16476a(weightedLatLng2);
        }
        this.f12054k = m16452a(this.f12049f);
    }

    private static Collection<WeightedLatLng> m16457d(Collection<LatLng> collection) {
        Collection arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    public Tile getTile(int i, int i2, int i3) {
        double d;
        double pow = WeightedLatLng.DEFAULT_INTENSITY / Math.pow(2.0d, (double) i3);
        double d2 = (((double) this.f12049f) * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((double) ((this.f12049f * 2) + 256));
        double d4 = (((double) i) * pow) - d2;
        double d5 = (((double) (i + 1)) * pow) + d2;
        double d6 = (((double) i2) * pow) - d2;
        double d7 = (pow * ((double) (i2 + 1))) + d2;
        ArrayList arrayList = new ArrayList();
        Collection a;
        if (d4 < 0.0d) {
            a = this.f12046c.m16475a(new ay(WeightedLatLng.DEFAULT_INTENSITY + d4, WeightedLatLng.DEFAULT_INTENSITY, d6, d7));
            d = -1.0d;
        } else if (d5 > WeightedLatLng.DEFAULT_INTENSITY) {
            a = this.f12046c.m16475a(new ay(0.0d, d5 - WeightedLatLng.DEFAULT_INTENSITY, d6, d7));
            d = WeightedLatLng.DEFAULT_INTENSITY;
        } else {
            Object obj = arrayList;
            d = 0.0d;
        }
        ay ayVar = new ay(d4, d5, d6, d7);
        if (!ayVar.m15527a(new ay(this.f12048e.f11439a - d2, this.f12048e.f11441c + d2, this.f12048e.f11440b - d2, d2 + this.f12048e.f11442d))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> a2 = this.f12046c.m16475a(ayVar);
        if (a2.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{(this.f12049f * 2) + 256, (this.f12049f * 2) + 256});
        for (WeightedLatLng weightedLatLng : a2) {
            DPoint point = weightedLatLng.getPoint();
            int i4 = (int) ((point.f13250x - d4) / d3);
            int i5 = (int) ((point.f13251y - d6) / d3);
            double[] dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng.intensity;
        }
        for (WeightedLatLng weightedLatLng2 : r20) {
            point = weightedLatLng2.getPoint();
            i4 = (int) (((point.f13250x + d) - d4) / d3);
            i5 = (int) ((point.f13251y - d6) / d3);
            dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng2.intensity;
        }
        return m16450a(m16448a(m16454a(dArr, this.f12052i), this.f12051h, this.f12054k[i3]));
    }

    private void m16451a(Gradient gradient) {
        this.f12050g = gradient;
        this.f12051h = gradient.generateColorMap(this.f12053j);
    }

    private double[] m16452a(int i) {
        int i2 = 11;
        double[] dArr = new double[21];
        for (int i3 = 5; i3 < 11; i3++) {
            dArr[i3] = m16447a(this.f12047d, this.f12048e, i, (int) (1280.0d * Math.pow(2.0d, (double) i3)));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
        }
        while (i2 < 21) {
            dArr[i2] = dArr[10];
            i2++;
        }
        return dArr;
    }

    private static Tile m16450a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(256, 256, byteArrayOutputStream.toByteArray());
    }

    static ay m16449a(Collection<WeightedLatLng> collection) {
        Iterator it = collection.iterator();
        WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
        double d = weightedLatLng.getPoint().f13250x;
        double d2 = weightedLatLng.getPoint().f13250x;
        double d3 = weightedLatLng.getPoint().f13251y;
        double d4 = weightedLatLng.getPoint().f13251y;
        while (it.hasNext()) {
            weightedLatLng = (WeightedLatLng) it.next();
            double d5 = weightedLatLng.getPoint().f13250x;
            double d6 = weightedLatLng.getPoint().f13251y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new ay(d, d2, d3, d4);
    }

    static double[] m16453a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] m16454a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        int i3 = 0;
        while (i3 < length) {
            int i4;
            for (i4 = 0; i4 < length; i4++) {
                int i5;
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    int i6 = floor > i3 - floor ? floor : i3 - floor;
                    while (i6 < i5) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d);
                        i6++;
                    }
                }
            }
            i3++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{i, i});
        for (i = floor; i < i2 + 1; i++) {
            i3 = 0;
            while (i3 < length) {
                d = dArr3[i][i3];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    i4 = floor > i3 - floor ? floor : i3 - floor;
                    while (i4 < i5) {
                        dArr4 = dArr5[i - floor];
                        int i7 = i4 - floor;
                        dArr4[i7] = dArr4[i7] + (dArr2[i4 - (i3 - floor)] * d);
                        i4++;
                    }
                }
                i3++;
            }
        }
        return dArr5;
    }

    static Bitmap m16448a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static double m16447a(Collection<WeightedLatLng> collection, ay ayVar, int i, int i2) {
        double d = ayVar.f11439a;
        double d2 = ayVar.f11441c;
        double d3 = ayVar.f11440b;
        double d4 = ayVar.f11442d;
        double d5 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / (d2 - d > d4 - d3 ? d2 - d : d4 - d3);
        LongSparseArray longSparseArray = new LongSparseArray();
        d4 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            LongSparseArray longSparseArray2;
            int i3 = (int) ((weightedLatLng.getPoint().f13250x - d) * d5);
            int i4 = (int) ((weightedLatLng.getPoint().f13251y - d3) * d5);
            LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray.get((long) i3);
            if (longSparseArray3 == null) {
                longSparseArray3 = new LongSparseArray();
                longSparseArray.put((long) i3, longSparseArray3);
                longSparseArray2 = longSparseArray3;
            } else {
                longSparseArray2 = longSparseArray3;
            }
            Double d6 = (Double) longSparseArray2.get((long) i4);
            if (d6 == null) {
                d6 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(weightedLatLng.intensity + d6.doubleValue());
            longSparseArray2.put((long) i4, valueOf);
            if (valueOf.doubleValue() > d4) {
                d2 = valueOf.doubleValue();
            } else {
                d2 = d4;
            }
            d4 = d2;
        }
        return d4;
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }
}
