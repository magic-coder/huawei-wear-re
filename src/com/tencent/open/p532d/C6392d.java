package com.tencent.open.p532d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import com.tencent.open.p541a.C6367n;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public class C6392d {
    private static String f22220c;
    private String f22221a;
    private C6295g f22222b;
    private long f22223d;
    private Handler f22224e;
    private Runnable f22225f = new C6394f(this);

    public C6392d(Activity activity) {
        this.f22224e = new C6393e(this, activity.getMainLooper());
    }

    public void m29182a(String str, C6295g c6295g) {
        C6367n.m29104a("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            c6295g.mo5300a(1, null);
        } else if (C6412y.m29253b()) {
            f22220c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.f22223d = System.currentTimeMillis();
            this.f22221a = str;
            this.f22222b = c6295g;
            new Thread(this.f22225f).start();
        } else {
            c6295g.mo5300a(2, null);
        }
    }

    public boolean m29183a(Bitmap bitmap, String str) {
        IOException e;
        OutputStream outputStream;
        Throwable th;
        String str2 = f22220c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            str2 = str2 + str;
            C6367n.m29104a("AsynLoadImg", "saveFile:" + str);
            OutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2)));
            try {
                bitmap.compress(CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e2 = e3;
                outputStream = bufferedOutputStream2;
                try {
                    e2.printStackTrace();
                    C6367n.m29104a("AsynLoadImg", "saveFile bmp fail---");
                    if (bufferedOutputStream != null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e42) {
                            e42.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e2 = e5;
            e2.printStackTrace();
            C6367n.m29104a("AsynLoadImg", "saveFile bmp fail---");
            if (bufferedOutputStream != null) {
                return false;
            }
            bufferedOutputStream.close();
            return false;
        }
    }

    public static Bitmap m29176a(String str) {
        C6367n.m29104a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            C6367n.m29104a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            C6367n.m29104a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            C6367n.m29104a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
