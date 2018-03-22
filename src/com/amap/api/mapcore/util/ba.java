package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.mapcore.util.de.C3312a;
import com.amap.api.mapcore.util.de.C3313b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* compiled from: ImageCache */
public class ba {
    private static final CompressFormat f11475a = CompressFormat.PNG;
    private de f11476b;
    private bg<String, Bitmap> f11477c;
    private C3288a f11478d;
    private final Object f11479e = new Object();
    private boolean f11480f = true;
    private HashMap<String, WeakReference<Bitmap>> f11481g;

    /* compiled from: ImageCache */
    public class C3288a {
        public int f11467a = 5242880;
        public int f11468b = 10485760;
        public File f11469c;
        public CompressFormat f11470d = ba.f11475a;
        public int f11471e = 100;
        public boolean f11472f = true;
        public boolean f11473g = true;
        public boolean f11474h = false;

        public C3288a(Context context, String str) {
            this.f11469c = ba.m15568a(context, str);
        }

        public void m15559a(int i) {
            this.f11467a = i;
        }

        public void m15562b(int i) {
            if (i <= 0) {
                this.f11473g = false;
            }
            this.f11468b = i;
        }

        public void m15560a(String str) {
            this.f11469c = new File(str);
        }

        public void m15561a(boolean z) {
            this.f11472f = z;
        }

        public void m15563b(boolean z) {
            this.f11473g = z;
        }
    }

    private ba(C3288a c3288a) {
        m15571b(c3288a);
    }

    public static ba m15566a(C3288a c3288a) {
        return new ba(c3288a);
    }

    private void m15571b(C3288a c3288a) {
        this.f11478d = c3288a;
        if (this.f11478d.f11472f) {
            bf.m15627a("ImageCache", "Memory cache created (size = " + this.f11478d.f11467a + ")", 111);
            if (bk.m15678c()) {
                this.f11481g = new HashMap();
            }
            this.f11477c = new bg<String, Bitmap>(this, this.f11478d.f11467a) {
                final /* synthetic */ ba f11466a;

                protected void m15558a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (bk.m15678c() && this.f11466a.f11481g != null && bitmap != null && !bitmap.isRecycled()) {
                        this.f11466a.f11481g.put(str, new WeakReference(bitmap));
                    }
                }

                protected int m15556a(String str, Bitmap bitmap) {
                    int a = ba.m15564a(bitmap);
                    return a == 0 ? 1 : a;
                }
            };
        }
        if (c3288a.f11474h) {
            m15577a();
        }
    }

    public void m15577a() {
        synchronized (this.f11479e) {
            if (this.f11476b == null || this.f11476b.m16048a()) {
                File file = this.f11478d.f11469c;
                if (this.f11478d.f11473g && file != null) {
                    try {
                        if (file.exists()) {
                            m15572b(file);
                        }
                        file.mkdir();
                    } catch (Exception e) {
                    }
                    if (m15565a(file) > ((long) this.f11478d.f11468b)) {
                        try {
                            this.f11476b = de.m16026a(file, 1, 1, (long) this.f11478d.f11468b);
                            bf.m15627a("ImageCache", "Disk cache initialized", 111);
                        } catch (IOException e2) {
                            this.f11478d.f11469c = null;
                            bf.m15627a("ImageCache", "initDiskCache - " + e2, 112);
                        }
                    }
                }
            }
            this.f11480f = false;
            this.f11479e.notifyAll();
        }
    }

    private void m15572b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m15572b(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public void m15578a(String str, Bitmap bitmap) {
        IOException iOException;
        OutputStream outputStream;
        Object obj;
        Throwable th;
        Throwable th2;
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.f11477c != null) {
                this.f11477c.m15554b(str, bitmap);
            }
            synchronized (this.f11479e) {
                if (this.f11476b != null) {
                    String c = m15573c(str);
                    OutputStream outputStream2 = null;
                    try {
                        C3313b a = this.f11476b.m16046a(c);
                        if (a == null) {
                            C3312a b = this.f11476b.m16049b(c);
                            if (b != null) {
                                outputStream2 = b.m16006a(0);
                                try {
                                    bitmap.compress(this.f11478d.f11470d, this.f11478d.f11471e, outputStream2);
                                    b.m16007a();
                                    outputStream2.close();
                                } catch (IOException e) {
                                    iOException = e;
                                    outputStream = outputStream2;
                                    IOException iOException2 = iOException;
                                    try {
                                        bf.m15627a("ImageCache", "addBitmapToCache - " + obj, 112);
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    outputStream = outputStream2;
                                    th = th2;
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            a.m16009a(0).close();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        outputStream = null;
                        obj = iOException;
                        bf.m15627a("ImageCache", "addBitmapToCache - " + obj, 112);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return;
                    } catch (Throwable th42) {
                        th2 = th42;
                        outputStream = null;
                        th = th2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
            }
            return;
        }
        return;
    }

    public Bitmap m15576a(String str) {
        Bitmap bitmap;
        if (bk.m15678c() && this.f11481g != null) {
            WeakReference weakReference = (WeakReference) this.f11481g.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.f11481g.remove(str);
                if (bitmap == null && this.f11477c != null) {
                    bitmap = (Bitmap) this.f11477c.m15550a((Object) str);
                }
                if (bitmap == null && !bitmap.isRecycled()) {
                    bf.m15627a("ImageCache", "Memory cache hit", 111);
                    return bitmap;
                }
            }
        }
        bitmap = null;
        bitmap = (Bitmap) this.f11477c.m15550a((Object) str);
        return bitmap == null ? null : null;
    }

    public Bitmap m15579b(String str) {
        Object e;
        Throwable th;
        Bitmap bitmap = null;
        String c = m15573c(str);
        synchronized (this.f11479e) {
            while (this.f11480f) {
                try {
                    this.f11479e.wait();
                } catch (InterruptedException e2) {
                }
            }
            if (this.f11476b != null) {
                InputStream a;
                try {
                    C3313b a2 = this.f11476b.m16046a(c);
                    if (a2 != null) {
                        bf.m15627a("ImageCache", "Disk cache hit", 111);
                        a = a2.m16009a(0);
                        if (a != null) {
                            try {
                                bitmap = bc.m15605a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    bf.m15627a("ImageCache", "getBitmapFromDiskCache - " + e, 112);
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    return bitmap;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    Object obj = bitmap;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    a = bitmap;
                    bf.m15627a("ImageCache", "getBitmapFromDiskCache - " + e, 112);
                    if (a != null) {
                        a.close();
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    a = bitmap;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    public void m15580b() {
        if (bk.m15678c() && this.f11481g != null) {
            this.f11481g.clear();
        }
        if (this.f11477c != null) {
            this.f11477c.m15551a();
            bf.m15627a("ImageCache", "Memory cache cleared", 111);
        }
        synchronized (this.f11479e) {
            this.f11480f = true;
            if (!(this.f11476b == null || this.f11476b.m16048a())) {
                try {
                    this.f11476b.m16051c();
                    bf.m15627a("ImageCache", "Disk cache cleared", 111);
                } catch (IOException e) {
                    bf.m15627a("ImageCache", "clearCache - " + e, 112);
                }
                this.f11476b = null;
                m15577a();
            }
        }
    }

    public void m15581c() {
        synchronized (this.f11479e) {
            if (this.f11476b != null) {
                try {
                    this.f11476b.m16050b();
                    bf.m15627a("ImageCache", "Disk cache flushed", 111);
                } catch (IOException e) {
                    bf.m15627a("ImageCache", "flush - " + e, 112);
                }
            }
        }
    }

    public void m15582d() {
        if (bk.m15678c() && this.f11481g != null) {
            this.f11481g.clear();
        }
        if (this.f11477c != null) {
            this.f11477c.m15551a();
            bf.m15627a("ImageCache", "Memory cache cleared", 111);
        }
        synchronized (this.f11479e) {
            if (this.f11476b != null) {
                try {
                    if (!this.f11476b.m16048a()) {
                        this.f11476b.m16051c();
                        this.f11476b = null;
                        bf.m15627a("ImageCache", "Disk cache closed", 111);
                    }
                } catch (IOException e) {
                    bf.m15627a("ImageCache", "close - " + e, 112);
                }
            }
        }
    }

    public static File m15568a(Context context, String str) {
        String path;
        File a = m15567a(context);
        if (("mounted".equals(Environment.getExternalStorageState()) || !m15574e()) && a != null) {
            path = a.getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        bf.m15627a("ImageCache", "Disk cachePath: " + path, 111);
        return new File(path + File.separator + str);
    }

    public static String m15573c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            return m15569a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        } catch (UnsupportedEncodingException e2) {
            return String.valueOf(str.hashCode());
        }
    }

    private static String m15569a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static int m15564a(Bitmap bitmap) {
        if (bk.m15680d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static boolean m15574e() {
        if (bk.m15675b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    public static File m15567a(Context context) {
        if (bk.m15665a()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    public static long m15565a(File file) {
        if (bk.m15675b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
