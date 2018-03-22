package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1488h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

public class CropImage extends MonitoredActivity {
    boolean f3650a;
    boolean f3651b;
    C1554o f3652c;
    Runnable f3653d = new C1552m(this);
    private CompressFormat f3654e = CompressFormat.JPEG;
    private Uri f3655f = null;
    private boolean f3656g = true;
    private boolean f3657h = false;
    private final Handler f3658i = new Handler();
    private int f3659j;
    private int f3660k;
    private int f3661l;
    private int f3662m;
    private boolean f3663n;
    private CropImageView f3664o;
    private ContentResolver f3665p;
    private Bitmap f3666q;
    private String f3667r;
    private boolean f3668s = true;
    private final C1543d f3669t = new C1543d();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3665p = getContentResolver();
        requestWindowFeature(1);
        setContentView(h.cropimage);
        m7077a();
        m7079a((Activity) this);
        m7088b();
        if (this.f3666q == null) {
            finish();
            return;
        }
        getWindow().addFlags(1024);
        m7091c();
    }

    private void m7077a() {
        this.f3664o = (CropImageView) findViewById(g.image);
        findViewById(g.discard).setOnClickListener(new C1545f(this));
        findViewById(g.save).setOnClickListener(new C1546g(this));
        findViewById(g.rotateLeft).setOnClickListener(new C1547h(this));
        findViewById(g.rotateRight).setOnClickListener(new C1548i(this));
    }

    private void m7088b() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString("circleCrop") != null) {
                if (VERSION.SDK_INT > 11) {
                    this.f3664o.setLayerType(1, null);
                }
                this.f3657h = true;
                this.f3659j = 1;
                this.f3660k = 1;
            }
            this.f3667r = extras.getString("image-path");
            this.f3655f = m7074a(this.f3667r);
            this.f3666q = m7087b(this.f3667r);
            int a = C1562y.m7177a(this.f3667r);
            if (!(a == 0 || this.f3666q == null)) {
                this.f3666q = C1562y.m7178a(this.f3666q, (float) a);
            }
            if (extras.containsKey("aspectX") && (extras.get("aspectX") instanceof Integer)) {
                this.f3659j = extras.getInt("aspectX");
                if (extras.containsKey("aspectY") && (extras.get("aspectY") instanceof Integer)) {
                    this.f3660k = extras.getInt("aspectY");
                    this.f3661l = extras.getInt("outputX");
                    this.f3662m = extras.getInt("outputY");
                    this.f3663n = extras.getBoolean("scale", true);
                    this.f3668s = extras.getBoolean("scaleUpIfNeeded", true);
                    return;
                }
                throw new IllegalArgumentException("aspect_y must be integer");
            }
            throw new IllegalArgumentException("aspect_x must be integer");
        }
    }

    private Uri m7074a(String str) {
        return Uri.fromFile(new File(str));
    }

    private Bitmap m7087b(String str) {
        Uri a = m7074a(str);
        try {
            int pow;
            InputStream openInputStream = this.f3665p.openInputStream(a);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
            if (options.outHeight > 1024 || options.outWidth > 1024) {
                pow = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(1024.0d / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
            } else {
                pow = 1;
            }
            options = new Options();
            options.inSampleSize = pow;
            InputStream openInputStream2 = this.f3665p.openInputStream(a);
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
            openInputStream2.close();
            return decodeStream;
        } catch (FileNotFoundException e) {
            C2538c.m12680e("CropImage", "EXCEPTION E = " + e.getMessage());
            return null;
        } catch (IOException e2) {
            C2538c.m12680e("CropImage", "EXCEPTION E = " + e2.getMessage());
            return null;
        }
    }

    private void m7091c() {
        if (!isFinishing()) {
            this.f3664o.mo2535a(this.f3666q, true);
            C1562y.m7180a((MonitoredActivity) this, null, "Please wait…", m7094d(), this.f3658i);
        }
    }

    @NonNull
    private Runnable m7094d() {
        return new C1549j(this);
    }

    @NonNull
    private Runnable m7076a(CountDownLatch countDownLatch, Bitmap bitmap) {
        return new C1550k(this, bitmap, countDownLatch);
    }

    private void m7082a(Bitmap bitmap, CountDownLatch countDownLatch) {
        if (!(bitmap == null || bitmap == this.f3666q)) {
            this.f3664o.mo2535a(bitmap, true);
            this.f3666q.recycle();
            this.f3666q = bitmap;
        }
        if (this.f3664o.getScale() == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            this.f3664o.m7113a(true, true);
        }
        countDownLatch.countDown();
    }

    private void m7095e() throws Exception {
        if (!this.f3651b && this.f3652c != null) {
            this.f3651b = true;
            Rect b = this.f3652c.m7154b();
            int width = b.width();
            int height = b.height();
            Bitmap a = m7072a(width, height);
            if (a != null) {
                new Canvas(a).drawBitmap(this.f3666q, b, new Rect(0, 0, width, height), null);
                m7078a(width, height, a);
                m7081a(m7085b(a));
            }
        }
    }

    private void m7081a(Bitmap bitmap) {
        Bundle extras = getIntent().getExtras();
        if (extras == null || (extras.getParcelable("data") == null && !extras.getBoolean("return-data"))) {
            C1562y.m7180a((MonitoredActivity) this, null, getString(C1680l.IDS_plugin_kidwatch_common_ui_saving_image), new C1551l(this, bitmap), this.f3658i);
            return;
        }
        extras = new Bundle();
        extras.putParcelable("data", bitmap);
        setResult(-1, new Intent().setAction("inline-data").putExtras(extras));
        finish();
    }

    private Bitmap m7085b(Bitmap bitmap) {
        if (this.f3661l == 0 || this.f3662m == 0) {
            return bitmap;
        }
        if (this.f3663n) {
            Bitmap a;
            a = C1562y.m7179a(new Matrix(), bitmap, this.f3661l, this.f3662m, this.f3668s);
            if (bitmap != a) {
                bitmap.recycle();
            }
            return a;
        }
        a = Bitmap.createBitmap(this.f3661l, this.f3662m, Config.RGB_565);
        Canvas canvas = new Canvas(a);
        Rect b = this.f3652c.m7154b();
        Rect rect = new Rect(0, 0, this.f3661l, this.f3662m);
        int width = (b.width() - rect.width()) / 2;
        int height = (b.height() - rect.height()) / 2;
        b.inset(Math.max(0, width), Math.max(0, height));
        rect.inset(Math.max(0, -width), Math.max(0, -height));
        canvas.drawBitmap(this.f3666q, b, rect, null);
        bitmap.recycle();
        return a;
    }

    private void m7078a(int i, int i2, Bitmap bitmap) {
        if (this.f3657h) {
            Canvas canvas = new Canvas(bitmap);
            Path path = new Path();
            path.addCircle(((float) i) / 2.0f, ((float) i2) / 2.0f, ((float) i) / 2.0f, Direction.CW);
            canvas.clipPath(path, Op.DIFFERENCE);
            canvas.drawColor(0, Mode.CLEAR);
        }
    }

    private Bitmap m7072a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, this.f3657h ? Config.ARGB_8888 : Config.RGB_565);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7092c(android.graphics.Bitmap r5) {
        /*
        r4 = this;
        r0 = r4.f3655f;
        if (r0 == 0) goto L_0x0040;
    L_0x0004:
        r0 = 0;
        r1 = r4.f3665p;	 Catch:{ IOException -> 0x0047, all -> 0x0053 }
        r2 = r4.f3655f;	 Catch:{ IOException -> 0x0047, all -> 0x0053 }
        r0 = r1.openOutputStream(r2);	 Catch:{ IOException -> 0x0047, all -> 0x0053 }
        if (r0 == 0) goto L_0x0016;
    L_0x000f:
        r1 = r4.f3654e;	 Catch:{ IOException -> 0x0047 }
        r2 = 90;
        r5.compress(r1, r2, r0);	 Catch:{ IOException -> 0x0047 }
    L_0x0016:
        com.huawei.pluginkidwatch.common.ui.simplecropimage.C1562y.m7181a(r0);
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = new android.content.Intent;
        r2 = r4.f3655f;
        r2 = r2.toString();
        r1.<init>(r2);
        r1.putExtras(r0);
        r0 = "image-path";
        r2 = r4.f3667r;
        r1.putExtra(r0, r2);
        r0 = "orientation_in_degrees";
        r2 = com.huawei.pluginkidwatch.common.ui.simplecropimage.C1562y.m7176a(r4);
        r1.putExtra(r0, r2);
        r0 = -1;
        r4.setResult(r0, r1);
    L_0x0040:
        r5.recycle();
        r4.finish();
    L_0x0046:
        return;
    L_0x0047:
        r1 = move-exception;
        r1 = 0;
        r4.setResult(r1);	 Catch:{ all -> 0x005b }
        r4.finish();	 Catch:{ all -> 0x005b }
        com.huawei.pluginkidwatch.common.ui.simplecropimage.C1562y.m7181a(r0);
        goto L_0x0046;
    L_0x0053:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0057:
        com.huawei.pluginkidwatch.common.ui.simplecropimage.C1562y.m7181a(r1);
        throw r0;
    L_0x005b:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.common.ui.simplecropimage.CropImage.c(android.graphics.Bitmap):void");
    }

    protected void onPause() {
        super.onPause();
        C1540a.m7128a().m7130a(this.f3669t);
    }

    protected void onDestroy() {
        m7098f();
        super.onDestroy();
    }

    private void m7098f() {
        if (this.f3666q != null) {
            this.f3666q.recycle();
        }
    }

    public static void m7079a(Activity activity) {
        m7080a(activity, C1488h.m6880a(activity));
    }

    public static void m7080a(Activity activity, int i) {
        String str = null;
        if (i == -1) {
            if (Environment.getExternalStorageState().equals("checking")) {
                str = activity.getString(C1680l.IDS_plugin_kidwatch_common_ui_preparing_card);
            } else {
                str = activity.getString(C1680l.IDS_plugin_kidwatch_common_ui_no_storage_card);
            }
        } else if (i < 1) {
            str = activity.getString(C1680l.IDS_plugin_kidwatch_common_ui_not_enough_space);
        }
        if (str != null) {
            C1483c.m6832c(activity, str);
        }
    }
}
