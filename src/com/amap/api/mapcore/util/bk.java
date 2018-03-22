package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.mapcore.C3264r;
import com.amap.api.mapcore.aa;
import com.amap.api.mapcore.util.bv.C3299a;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* compiled from: Util */
public class bk {
    static final int[] f11502a = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    static final double[] f11503b = new double[]{7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};
    public static Handler f11504c = new Handler();

    public static Bitmap m15648a(Context context, String str) {
        try {
            InputStream open = bi.m15630a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            ca.m15831a(th, "Util", "fromAsset");
            return null;
        }
    }

    public static void m15662a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static String m15657a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float m15641a(float f, float f2) {
        if (f <= 40.0f) {
            return f;
        }
        if (f2 <= 15.0f) {
            return 40.0f;
        }
        if (f2 <= 16.0f) {
            return 50.0f;
        }
        if (f2 <= 17.0f) {
            return 54.0f;
        }
        if (f2 <= 18.0f) {
            return 57.0f;
        }
        return 60.0f;
    }

    public static float m15640a(float f) {
        if (f > 19.0f) {
            return 19.0f;
        }
        if (f < 3.0f) {
            return 3.0f;
        }
        return f;
    }

    public static FloatBuffer m15659a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            ca.m15831a(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static FloatBuffer m15660a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            ca.m15831a(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static int m15645a(GL10 gl10, Bitmap bitmap) {
        return m15646a(gl10, bitmap, false);
    }

    public static int m15646a(GL10 gl10, Bitmap bitmap, boolean z) {
        return m15644a(gl10, 0, bitmap, z);
    }

    public static int m15643a(GL10 gl10, int i, Bitmap bitmap) {
        return m15644a(gl10, i, bitmap, false);
    }

    public static int m15644a(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        int b = m15671b(gl10, i, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return b;
    }

    public static int m15671b(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = new int[]{0};
            gl10.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        gl10.glEnable(3553);
        gl10.glBindTexture(3553, i);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            gl10.glTexParameterf(3553, 10242, 10497.0f);
            gl10.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            gl10.glTexParameterf(3553, 10242, 33071.0f);
            gl10.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        gl10.glDisable(3553);
        return i;
    }

    public static int m15642a(int i) {
        int log = (int) (Math.log((double) i) / Math.log(2.0d));
        if ((1 << log) >= i) {
            return 1 << log;
        }
        return 1 << (log + 1);
    }

    public static String m15658a(String... strArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    public static int m15647a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap m15650a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap m15649a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static String m15654a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getCacheDir().toString() + File.separator;
        }
        File file;
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals("")) {
            file = new File(Environment.getExternalStorageDirectory(), MapTilsCacheAndResManager.AUTONAVI_PATH);
        } else {
            file = new File(MapsInitializer.sdcardDir);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "data");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.toString() + File.separator;
    }

    public static String m15673b(Context context) {
        String a = m15654a(context);
        if (a == null) {
            return null;
        }
        File file = new File(a, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String m15672b(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static boolean m15679c(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        State state = activeNetworkInfo.getState();
        if (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    public static boolean m15665a() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean m15675b() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean m15678c() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean m15680d() {
        return VERSION.SDK_INT >= 12;
    }

    public static void m15664a(GL10 gl10, int i) {
        gl10.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static String m15656a(InputStream inputStream) {
        try {
            return new String(m15677b(inputStream), "utf-8");
        } catch (Throwable th) {
            ca.m15831a(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] m15677b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String m15655a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable e;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e = th;
                        bufferedReader2 = bufferedReader;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e422) {
                        e422.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                try {
                    ca.m15831a(e, "Util", "readFile fileNotFound");
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4222) {
                            e4222.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e42222) {
                                    e42222.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e52) {
                                    e52.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e422222) {
                            e422222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th4) {
                    e = th4;
                    fileInputStream = fileInputStream2;
                    bufferedReader2 = bufferedReader;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222) {
                                    e5222.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e52222) {
                                    e52222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e522222) {
                            e522222.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                try {
                    ca.m15831a(e, "Util", "readFile io");
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4222222) {
                            e4222222.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e42222222) {
                                    e42222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222222) {
                                    e5222222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e422222222) {
                            e422222222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th7) {
                    e = th7;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw e;
                }
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            bufferedReader = null;
            ca.m15831a(e, "Util", "readFile fileNotFound");
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer.toString();
        } catch (IOException e9) {
            e = e9;
            fileInputStream = null;
            ca.m15831a(e, "Util", "readFile io");
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return stringBuffer.toString();
        } catch (Throwable th8) {
            e = th8;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw e;
        }
        return stringBuffer.toString();
    }

    public static void m15663a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("E6008")) {
                    throw new AMapException("key为空");
                } else if (string.equals("E6012")) {
                    throw new AMapException("key不存在");
                } else if (string.equals("E6018")) {
                    throw new AMapException("key被锁定");
                }
            }
        } catch (Throwable e) {
            ca.m15831a(e, "Util", "paseAuthFailurJson");
            e.printStackTrace();
        }
    }

    public static boolean m15667a(LatLng latLng, List<LatLng> list) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!((LatLng) list.get(0)).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = ((LatLng) list.get(i)).longitude;
            double d5 = ((LatLng) list.get(i)).latitude;
            double d6 = ((LatLng) list.get(i + 1)).longitude;
            double d7 = ((LatLng) list.get(i + 1)).latitude;
            if (m15676b(d, d2, d4, d5, d6, d7)) {
                return true;
            }
            int i3;
            if (Math.abs(d7 - d5) < 1.0E-9d) {
                i3 = i2;
            } else {
                if (m15676b(d4, d5, d, d2, 180.0d, d3)) {
                    if (d5 > d7) {
                        i3 = i2 + 1;
                    }
                } else if (m15676b(d6, d7, d, d2, 180.0d, d3)) {
                    if (d7 > d5) {
                        i3 = i2 + 1;
                    }
                } else if (m15666a(d4, d5, d6, d7, d, d2, 180.0d, d3)) {
                    i3 = i2 + 1;
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2 % 2 != 0;
    }

    public static double m15638a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static boolean m15676b(double d, double d2, double d3, double d4, double d5, double d6) {
        if (Math.abs(m15638a(d, d2, d3, d4, d5, d6)) >= 1.0E-9d || (d - d3) * (d - d5) > 0.0d || (d2 - d4) * (d2 - d6) > 0.0d) {
            return false;
        }
        return true;
    }

    public static boolean m15666a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = ((d3 - d) * (d8 - d6)) - ((d4 - d2) * (d7 - d5));
        if (d9 == 0.0d) {
            return false;
        }
        double d10 = (((d2 - d6) * (d7 - d5)) - ((d - d5) * (d8 - d6))) / d9;
        d9 = (((d2 - d6) * (d3 - d)) - ((d - d5) * (d4 - d2))) / d9;
        if (d10 < 0.0d || d10 > WeightedLatLng.DEFAULT_INTENSITY || d9 < 0.0d || d9 > WeightedLatLng.DEFAULT_INTENSITY) {
            return false;
        }
        return true;
    }

    public static List<FPoint> m15661a(aa aaVar, List<FPoint> list) {
        List arrayList = new ArrayList();
        List<FPoint> arrayList2 = new ArrayList(list);
        FPoint[] a = m15670a(aaVar);
        int i = 0;
        while (i < 4) {
            arrayList.clear();
            for (int i2 = 0; i2 < arrayList2.size() - 1; i2++) {
                FPoint fPoint = (FPoint) arrayList2.get(i2);
                FPoint fPoint2 = (FPoint) arrayList2.get(i2 + 1);
                if (i2 == 0 && m15668a(fPoint, a[i], a[(i + 1) % 4])) {
                    arrayList.add(fPoint);
                }
                if (m15668a(fPoint, a[i], a[(i + 1) % 4])) {
                    if (m15668a(fPoint2, a[i], a[(i + 1) % 4])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(m15653a(a[i], a[(i + 1) % 4], fPoint, fPoint2));
                    }
                } else if (m15668a(fPoint2, a[i], a[(i + 1) % 4])) {
                    arrayList.add(m15653a(a[i], a[(i + 1) % 4], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
            }
            arrayList2.clear();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList2.add(arrayList.get(i3));
            }
            byte b = (byte) (i + 1);
        }
        return arrayList2;
    }

    private static FPoint[] m15670a(aa aaVar) {
        FPoint[] fPointArr = new FPoint[4];
        FPoint fPoint = new FPoint();
        aaVar.mo3772a(-100, -100, fPoint);
        fPointArr[0] = fPoint;
        fPoint = new FPoint();
        aaVar.mo3772a(aaVar.mo3827k() + 100, -100, fPoint);
        fPointArr[1] = fPoint;
        fPoint = new FPoint();
        aaVar.mo3772a(aaVar.mo3827k() + 100, aaVar.mo3829l() + 100, fPoint);
        fPointArr[2] = fPoint;
        fPoint = new FPoint();
        aaVar.mo3772a(-100, aaVar.mo3829l() + 100, fPoint);
        fPointArr[3] = fPoint;
        return fPointArr;
    }

    private static FPoint m15653a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint fPoint5 = new FPoint(0.0f, 0.0f);
        double d = (double) (((fPoint2.f13253y - fPoint.f13253y) * (fPoint.f13252x - fPoint3.f13252x)) - ((fPoint2.f13252x - fPoint.f13252x) * (fPoint.f13253y - fPoint3.f13253y)));
        double d2 = (double) (((fPoint2.f13253y - fPoint.f13253y) * (fPoint4.f13252x - fPoint3.f13252x)) - ((fPoint2.f13252x - fPoint.f13252x) * (fPoint4.f13253y - fPoint3.f13253y)));
        fPoint5.f13252x = (float) (((double) fPoint3.f13252x) + ((((double) (fPoint4.f13252x - fPoint3.f13252x)) * d) / d2));
        fPoint5.f13253y = (float) (((d * ((double) (fPoint4.f13253y - fPoint3.f13253y))) / d2) + ((double) fPoint3.f13253y));
        return fPoint5;
    }

    private static boolean m15668a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        if (((double) (((fPoint3.f13252x - fPoint2.f13252x) * (fPoint.f13253y - fPoint2.f13253y)) - ((fPoint.f13252x - fPoint2.f13252x) * (fPoint3.f13253y - fPoint2.f13253y)))) >= 0.0d) {
            return true;
        }
        return false;
    }

    public static float m15639a(double d, double d2, double d3, double d4) {
        if (d > 0.0d) {
            float a = (float) m15637a(d, d3);
            if (d2 > 0.0d) {
                return (float) Math.min((double) a, m15637a(d2, d4));
            }
            return a;
        } else if (d2 > 0.0d) {
            return (float) m15637a(d2, d4);
        } else {
            return 0.0f;
        }
    }

    public static double m15637a(double d, double d2) {
        if (d2 > 0.0d) {
            return Math.log((1048576.0d * d) / d2) / Math.log(2.0d);
        }
        return 0.0d;
    }

    public static bv m15681e() {
        try {
            if (C3264r.f11370f != null) {
                return C3264r.f11370f;
            }
            return new C3299a(C3264r.f11366b, "3.2.0.1", C3264r.f11368d).m15789a(new String[]{"com.amap.api.maps"}).m15790a();
        } catch (Throwable th) {
            return null;
        }
    }

    private static void m15674b(View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                m15674b(((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static Bitmap m15651a(View view) {
        try {
            m15674b(view);
            view.destroyDrawingCache();
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap copy = view.getDrawingCache().copy(Config.ARGB_8888, false);
            view.destroyDrawingCache();
            return copy;
        } catch (Throwable th) {
            ca.m15831a(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint m15652a(LatLng latLng) {
        double d = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new DPoint(d * WeightedLatLng.DEFAULT_INTENSITY, (((Math.log((WeightedLatLng.DEFAULT_INTENSITY + sin) / (WeightedLatLng.DEFAULT_INTENSITY - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * WeightedLatLng.DEFAULT_INTENSITY);
    }

    public static float[] m15669a(aa aaVar, int i, FPoint fPoint, float f, int i2, int i3, float f2, float f3) throws RemoteException {
        float f4 = fPoint.f13252x;
        float f5 = fPoint.f13253y;
        float[] fArr = new float[12];
        float a = aaVar.mo3737A().mo3916a(i2);
        float a2 = aaVar.mo3737A().mo3916a(i3);
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[4];
        Matrix.setIdentityM(fArr2, 0);
        if (i == 3) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, aaVar.mo3809c().getMapAngle(), 0.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
            Matrix.translateM(fArr2, 0, f4 - (a / 2.0f), f5 - (a2 / 2.0f), 0.0f);
            Matrix.rotateM(fArr2, 0, -aaVar.mo3809c().getCameraHeaderAngle(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, 0.0f);
            Matrix.translateM(fArr2, 0, (a / 2.0f) - f4, (a2 / 2.0f) - f5, 0.0f);
        } else if (i == 1) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        } else {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, aaVar.mo3809c().getMapAngle(), 0.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            Matrix.rotateM(fArr2, 0, -aaVar.mo3809c().getCameraHeaderAngle(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        }
        float[] fArr4 = new float[]{f4 - (a * f2), ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f3) * a2) + f5, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT};
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[0] = fArr4[0];
        fArr[1] = fArr4[1];
        fArr[2] = fArr4[2];
        fArr3[0] = ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * a) + f4;
        fArr3[1] = ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f3) * a2) + f5;
        fArr3[2] = 0.0f;
        fArr3[3] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[3] = fArr4[0];
        fArr[4] = fArr4[1];
        fArr[5] = fArr4[2];
        fArr3[0] = ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * a) + f4;
        fArr3[1] = f5 - (a2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[6] = fArr4[0];
        fArr[7] = fArr4[1];
        fArr[8] = fArr4[2];
        fArr3[0] = f4 - (a * f2);
        fArr3[1] = f5 - (a2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[9] = fArr4[0];
        fArr[10] = fArr4[1];
        fArr[11] = fArr4[2];
        return fArr;
    }
}
