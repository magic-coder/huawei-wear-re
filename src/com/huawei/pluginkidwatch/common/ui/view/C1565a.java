package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.widget.ImageView;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: AsyncImageLoader */
public class C1565a {
    private static Map<String, WeakReference<Bitmap>> f3825a = new HashMap();
    private ExecutorService f3826b = Executors.newFixedThreadPool(1);
    private final Handler f3827c = new Handler();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m7214a(java.lang.String r13) {
        /*
        r12 = this;
        r0 = "AsyncImageLoader";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "==============Enter loadRmoteImage";
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r1 = 0;
        r0 = 32;
        r0 = r13.substring(r0);
        r2 = 0;
        r3 = 0;
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x0031 }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0031 }
        r0 = r4.openConnection();	 Catch:{ IOException -> 0x0031 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0031 }
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ IOException -> 0x0178 }
        r0.connect();	 Catch:{ IOException -> 0x0178 }
        r2 = r0.getInputStream();	 Catch:{ IOException -> 0x0178 }
        r4 = r2;
    L_0x002d:
        if (r0 != 0) goto L_0x0057;
    L_0x002f:
        r1 = 0;
    L_0x0030:
        return r1;
    L_0x0031:
        r0 = move-exception;
    L_0x0032:
        r4 = "AsyncImageLoader";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Exception err1 = ";
        r7 = r7.append(r8);
        r0 = r0.getMessage();
        r0 = r7.append(r0);
        r0 = r0.toString();
        r5[r6] = r0;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        r4 = r3;
        r0 = r2;
        goto L_0x002d;
    L_0x0057:
        r0 = r0.getContentLength();
        r2 = -1;
        if (r0 == r2) goto L_0x00d5;
    L_0x005e:
        r5 = new byte[r0];
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r6 = new byte[r0];
        r0 = 0;
        r3 = 0;
        r2 = 0;
        if (r4 != 0) goto L_0x006b;
    L_0x0069:
        r1 = 0;
        goto L_0x0030;
    L_0x006b:
        r7 = r4.read(r6);	 Catch:{ IOException -> 0x00fa }
        if (r7 <= 0) goto L_0x0077;
    L_0x0071:
        r8 = 0;
        java.lang.System.arraycopy(r6, r8, r5, r0, r7);	 Catch:{ IOException -> 0x00fa }
        r0 = r0 + r7;
        goto L_0x006b;
    L_0x0077:
        r0 = 0;
        r6 = 16;
        r3 = r13.substring(r0, r6);	 Catch:{ IOException -> 0x00fa }
        r0 = 16;
        r6 = 32;
        r2 = r13.substring(r0, r6);	 Catch:{ IOException -> 0x00fa }
        r0 = "AsyncImageLoader";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ IOException -> 0x00fa }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00fa }
        r8.<init>();	 Catch:{ IOException -> 0x00fa }
        r9 = "==ww== key= ";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x00fa }
        r8 = r8.append(r3);	 Catch:{ IOException -> 0x00fa }
        r9 = "      iv =";
        r8 = r8.append(r9);	 Catch:{ IOException -> 0x00fa }
        r8 = r8.append(r2);	 Catch:{ IOException -> 0x00fa }
        r8 = r8.toString();	 Catch:{ IOException -> 0x00fa }
        r6[r7] = r8;	 Catch:{ IOException -> 0x00fa }
        com.huawei.p190v.C2538c.m12674b(r0, r6);	 Catch:{ IOException -> 0x00fa }
        r4.close();	 Catch:{ IOException -> 0x00e4 }
    L_0x00b1:
        if (r3 == 0) goto L_0x017e;
    L_0x00b3:
        if (r2 == 0) goto L_0x017e;
    L_0x00b5:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        r4 = "UTF-8";
        r0.<init>(r5, r4);	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        r4 = "UTF-8";
        r3 = r3.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        r0 = com.huawei.pluginkidwatch.common.lib.utils.C1481a.m6816d(r0, r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        if (r0 == 0) goto L_0x017e;
    L_0x00ce:
        r2 = 0;
        r3 = r0.length;	 Catch:{ UnsupportedEncodingException -> 0x0153 }
        r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x0153 }
    L_0x00d4:
        r1 = r0;
    L_0x00d5:
        r0 = "AsyncImageLoader";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "==============Leave loadRmoteImage";
        r2[r3] = r4;
        com.huawei.p190v.C2538c.m12674b(r0, r2);
        goto L_0x0030;
    L_0x00e4:
        r0 = move-exception;
        r4 = "AsyncImageLoader";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "Exception err = ";
        r6[r7] = r8;
        r7 = 1;
        r0 = r0.getMessage();
        r6[r7] = r0;
        com.huawei.p190v.C2538c.m12680e(r4, r6);
        goto L_0x00b1;
    L_0x00fa:
        r0 = move-exception;
        r6 = "AsyncImageLoader";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0138 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0138 }
        r9.<init>();	 Catch:{ all -> 0x0138 }
        r10 = "Exception err2 = ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0138 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0138 }
        r0 = r9.append(r0);	 Catch:{ all -> 0x0138 }
        r0 = r0.toString();	 Catch:{ all -> 0x0138 }
        r7[r8] = r0;	 Catch:{ all -> 0x0138 }
        com.huawei.p190v.C2538c.m12680e(r6, r7);	 Catch:{ all -> 0x0138 }
        r4.close();	 Catch:{ IOException -> 0x0121 }
        goto L_0x00b1;
    L_0x0121:
        r0 = move-exception;
        r4 = "AsyncImageLoader";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "Exception err = ";
        r6[r7] = r8;
        r7 = 1;
        r0 = r0.getMessage();
        r6[r7] = r0;
        com.huawei.p190v.C2538c.m12680e(r4, r6);
        goto L_0x00b1;
    L_0x0138:
        r0 = move-exception;
        r4.close();	 Catch:{ IOException -> 0x013d }
    L_0x013c:
        throw r0;
    L_0x013d:
        r1 = move-exception;
        r2 = "AsyncImageLoader";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "Exception err = ";
        r3[r4] = r5;
        r4 = 1;
        r1 = r1.getMessage();
        r3[r4] = r1;
        com.huawei.p190v.C2538c.m12680e(r2, r3);
        goto L_0x013c;
    L_0x0153:
        r0 = move-exception;
        r2 = "AsyncImageLoader";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Exception err3 = ";
        r5 = r5.append(r6);
        r0 = r0.getMessage();
        r0 = r5.append(r0);
        r0 = r0.toString();
        r3[r4] = r0;
        com.huawei.p190v.C2538c.m12680e(r2, r3);
        goto L_0x00d5;
    L_0x0178:
        r2 = move-exception;
        r11 = r2;
        r2 = r0;
        r0 = r11;
        goto L_0x0032;
    L_0x017e:
        r0 = r1;
        goto L_0x00d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.common.ui.view.a.a(java.lang.String):android.graphics.Bitmap");
    }

    public Bitmap m7220a(Context context, String str, C1569i c1569i) {
        if (str == null) {
            return null;
        }
        C2538c.m12674b("AsyncImageLoader", "==============Enter loadBitmapByServer");
        if (f3825a.containsKey(str)) {
            WeakReference weakReference = (WeakReference) f3825a.get(str);
            if (weakReference.get() != null) {
                this.f3827c.post(new C1566b(this, c1569i, weakReference));
                return (Bitmap) weakReference.get();
            }
        }
        C2538c.m12674b("AsyncImageLoader", "==============AAA2");
        Bitmap a = ac.m7222a(context, str);
        if (a != null) {
            f3825a.put(str, new WeakReference(a));
            if (c1569i == null) {
                return a;
            }
            C2538c.m12674b("AsyncImageLoader", "==============从文件中找到图片");
            c1569i.mo2545a(a);
            return a;
        }
        C2538c.m12674b("AsyncImageLoader", "==============AAA3");
        this.f3826b.submit(new C1567c(this, str, context, c1569i));
        return null;
    }

    public boolean m7221a(Context context, ImageView imageView, String str) {
        C2538c.m12674b("AsyncImageLoader", "========= Enter loadDefaultAvatar");
        if (str == null || str.length() == 0) {
            C2538c.m12674b("AsyncImageLoader", "=========url is NULL");
            return true;
        }
        C2538c.m12674b("AsyncImageLoader", "=========url != null && url.length() != 0");
        Bitmap a = m7220a(context, str, new C1570e(this, imageView));
        if (a != null) {
            imageView.setImageBitmap(C1565a.m7212a(a));
            return false;
        }
        C2538c.m12674b("AsyncImageLoader", "========= bitmap is null");
        return true;
    }

    public Bitmap m7218a(Context context, String str) {
        C2538c.m12674b("AsyncImageLoader", "========= Enter loadDefaultAvatar");
        if (str == null || str.length() == 0) {
            return null;
        }
        C2538c.m12674b("AsyncImageLoader", "=========url != null && url.length() != 0");
        Bitmap a = m7220a(context, str, new C1571f(this));
        if (a == null) {
            return a;
        }
        C2538c.m12674b("AsyncImageLoader", "========= bitmap != null");
        return C1565a.m7212a(a);
    }

    public Bitmap m7219a(Context context, String str, Handler handler) {
        C2538c.m12674b("AsyncImageLoader", "========= Enter loadDefaultAvatar  final Context context, String url,final Handler handler ");
        if (str == null || str.length() == 0) {
            return null;
        }
        C2538c.m12674b("AsyncImageLoader", "=========url != null && url.length() != 0");
        Bitmap a = m7220a(context, str, new C1572g(this, handler));
        if (a == null) {
            return a;
        }
        C2538c.m12674b("AsyncImageLoader", "========= bitmap != null");
        return C1565a.m7212a(a);
    }

    public static Bitmap m7212a(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f = (float) width;
            f2 = (float) width;
            f3 = (float) width;
            f4 = (float) width;
            f5 = ((float) width) / 2.0f;
            height = width;
            f6 = 0.0f;
        } else {
            f5 = ((float) height) / 2.0f;
            f6 = ((float) (width - height)) / 2.0f;
            f2 = ((float) width) - f6;
            f = (float) height;
            f3 = (float) height;
            f4 = (float) height;
            width = height;
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, width, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f6, (int) null, (int) f2, (int) f);
        Rect rect2 = new Rect((int) null, (int) null, (int) f3, (int) f4);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f5, f5, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static void m7217a(C1574j c1574j, String str, Context context) {
        new C1573h(str, context, c1574j).execute(new String[0]);
    }
}
