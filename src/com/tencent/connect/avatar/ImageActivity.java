package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.tencent.connect.C6246a;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6412y;
import com.tencent.tauth.C6252b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public class ImageActivity extends Activity {
    RelativeLayout f21732a;
    private C6284w f21733b;
    private String f21734c;
    private Handler f21735d;
    private C6260m f21736e;
    private Button f21737f;
    private Button f21738g;
    private C6259l f21739h;
    private TextView f21740i;
    private ProgressBar f21741j;
    private int f21742k = 0;
    private boolean f21743l = false;
    private long f21744m = 0;
    private int f21745n = 0;
    private final int f21746o = 640;
    private final int f21747p = 640;
    private Rect f21748q = new Rect();
    private String f21749r;
    private Bitmap f21750s;
    private final OnClickListener f21751t = new C6248b(this);
    private final OnClickListener f21752u = new C6250d(this);
    private final C6252b f21753v = new C6253f(this);
    private final C6252b f21754w = new C6254g(this);

    private Bitmap m28717a(String str) throws IOException {
        int i = 1;
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream != null) {
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
            openInputStream.close();
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            while (i2 * i3 > 4194304) {
                i2 /= 2;
                i3 /= 2;
                i *= 2;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return bitmap;
    }

    private Drawable m28729b(String str) {
        Drawable createFromStream;
        IOException e;
        try {
            InputStream open = getAssets().open(str);
            createFromStream = Drawable.createFromStream(open, str);
            try {
                open.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return createFromStream;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            createFromStream = null;
            e = iOException;
            e.printStackTrace();
            return createFromStream;
        }
        return createFromStream;
    }

    private View m28720a() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        this.f21732a = new RelativeLayout(this);
        this.f21732a.setLayoutParams(layoutParams);
        this.f21732a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams3);
        this.f21732a.addView(relativeLayout);
        this.f21736e = new C6260m(this);
        this.f21736e.setLayoutParams(layoutParams2);
        this.f21736e.setScaleType(ScaleType.MATRIX);
        relativeLayout.addView(this.f21736e);
        this.f21739h = new C6259l(this);
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f21739h.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f21739h);
        relativeLayout = new LinearLayout(this);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, C6258k.m28766a(this, 80.0f));
        layoutParams2.addRule(14, -1);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setOrientation(0);
        relativeLayout.setGravity(17);
        this.f21732a.addView(relativeLayout);
        View imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C6258k.m28766a(this, 24.0f), C6258k.m28766a(this, 24.0f)));
        imageView.setImageDrawable(m28729b("com.tencent.plus.logo.png"));
        relativeLayout.addView(imageView);
        this.f21740i = new TextView(this);
        layoutParams2 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams2.leftMargin = C6258k.m28766a(this, 7.0f);
        this.f21740i.setLayoutParams(layoutParams2);
        this.f21740i.setEllipsize(TruncateAt.END);
        this.f21740i.setSingleLine();
        this.f21740i.setTextColor(-1);
        this.f21740i.setTextSize(24.0f);
        this.f21740i.setVisibility(8);
        relativeLayout.addView(this.f21740i);
        relativeLayout = new RelativeLayout(this);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, C6258k.m28766a(this, 60.0f));
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(9, -1);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setBackgroundDrawable(m28729b("com.tencent.plus.bar.png"));
        int a = C6258k.m28766a(this, 10.0f);
        relativeLayout.setPadding(a, a, a, 0);
        this.f21732a.addView(relativeLayout);
        C6257j c6257j = new C6257j(this, this);
        int a2 = C6258k.m28766a(this, 14.0f);
        int a3 = C6258k.m28766a(this, 7.0f);
        this.f21738g = new Button(this);
        this.f21738g.setLayoutParams(new RelativeLayout.LayoutParams(C6258k.m28766a(this, 78.0f), C6258k.m28766a(this, 45.0f)));
        this.f21738g.setText("取消");
        this.f21738g.setTextColor(-1);
        this.f21738g.setTextSize(18.0f);
        this.f21738g.setPadding(a2, a3, a2, a3);
        c6257j.m28765b(this.f21738g);
        relativeLayout.addView(this.f21738g);
        this.f21737f = new Button(this);
        LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(C6258k.m28766a(this, 78.0f), C6258k.m28766a(this, 45.0f));
        layoutParams5.addRule(11, -1);
        this.f21737f.setLayoutParams(layoutParams5);
        this.f21737f.setTextColor(-1);
        this.f21737f.setTextSize(18.0f);
        this.f21737f.setPadding(a2, a3, a2, a3);
        this.f21737f.setText("选取");
        c6257j.m28764a(this.f21737f);
        relativeLayout.addView(this.f21737f);
        imageView = new TextView(this);
        layoutParams4 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams4.addRule(13, -1);
        imageView.setLayoutParams(layoutParams4);
        imageView.setText("移动和缩放");
        imageView.setPadding(0, C6258k.m28766a(this, 3.0f), 0, 0);
        imageView.setTextSize(18.0f);
        imageView.setTextColor(-1);
        relativeLayout.addView(imageView);
        this.f21741j = new ProgressBar(this);
        layoutParams = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.f21741j.setLayoutParams(layoutParams);
        this.f21741j.setVisibility(8);
        this.f21732a.addView(this.f21741j);
        return this.f21732a;
    }

    private void m28730b() {
        try {
            this.f21750s = m28717a(this.f21749r);
            if (this.f21750s == null) {
                throw new IOException("cannot read picture: '" + this.f21749r + "'!");
            }
            this.f21736e.setImageBitmap(this.f21750s);
            this.f21737f.setOnClickListener(this.f21751t);
            this.f21738g.setOnClickListener(this.f21752u);
            this.f21732a.getViewTreeObserver().addOnGlobalLayoutListener(new C6247a(this));
        } catch (IOException e) {
            e.printStackTrace();
            String str = "图片读取失败，请检查该图片是否有效";
            m28733b(str, 1);
            m28722a(-5, null, str, e.getMessage());
            m28739d();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        setContentView(m28720a());
        this.f21735d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra("key_params");
        this.f21749r = bundleExtra.getString("picture");
        this.f21734c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f21745n = bundleExtra.getInt("exitAnim");
        this.f21733b = new C6284w(string);
        this.f21733b.m28847a(string2, ((j - System.currentTimeMillis()) / 1000) + "");
        this.f21733b.m28850b(string3);
        m28730b();
        m28741e();
        this.f21744m = System.currentTimeMillis();
        m28752a("10653", 0);
    }

    public void onBackPressed() {
        setResult(0);
        m28739d();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f21736e.setImageBitmap(null);
        if (this.f21750s != null && !this.f21750s.isRecycled()) {
            this.f21750s.recycle();
        }
    }

    private void m28735c() {
        float width = (float) this.f21748q.width();
        Matrix imageMatrix = this.f21736e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        width = 640.0f / width;
        int i = (int) ((((float) this.f21748q.left) - f) / f3);
        int i2 = (int) ((((float) this.f21748q.top) - f2) / f3);
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i3 = (int) (650.0f / f3);
        Bitmap createBitmap = Bitmap.createBitmap(this.f21750s, i, i2, Math.min(this.f21750s.getWidth() - i, i3), Math.min(this.f21750s.getHeight() - i2, i3), matrix, true);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
        createBitmap.recycle();
        m28723a(createBitmap2);
    }

    private void m28723a(Bitmap bitmap) {
        new C6256i(this, this.f21733b).m28763a(bitmap, this.f21753v);
    }

    private void m28726a(String str, int i) {
        this.f21735d.post(new C6251e(this, str, i));
    }

    private void m28733b(String str, int i) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        View imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C6258k.m28766a(this, 16.0f), C6258k.m28766a(this, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(m28729b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(m28729b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    private void m28722a(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        setResult(-1, intent);
    }

    private void m28739d() {
        finish();
        if (this.f21745n != 0) {
            overridePendingTransition(0, this.f21745n);
        }
    }

    private void m28741e() {
        this.f21742k++;
        new C6246a(this, this.f21733b).m28716a(this.f21754w);
    }

    private void m28736c(String str) {
        CharSequence d = m28738d(str);
        if (!"".equals(d)) {
            this.f21740i.setText(d);
            this.f21740i.setVisibility(0);
        }
    }

    private String m28738d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", SNBConstant.FILTER);
    }

    public void m28752a(String str, long j) {
        C6412y.m29245a((Context) this, str, j, this.f21733b.m28849b());
    }
}
