package com.tencent.connect.p193b;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.tencent.open.p532d.C6396i;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6267e implements C6252b {
    C6252b f21796a;
    final /* synthetic */ C6263a f21797b;
    private final String f21798c = "sendinstall";
    private final String f21799d = "installwording";
    private final String f21800e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

    public C6267e(C6263a c6263a, C6252b c6252b) {
        this.f21797b = c6263a;
        this.f21796a = c6252b;
    }

    public void mo5288a(Object obj) {
        Object obj2 = null;
        if (obj != null) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null) {
                String string;
                Object obj3;
                Object obj4;
                String str = "";
                try {
                    if (jSONObject.getInt("sendinstall") == 1) {
                        obj2 = 1;
                    }
                    string = jSONObject.getString("installwording");
                    obj3 = obj2;
                } catch (JSONException e) {
                    obj4 = null;
                    C6367n.m29111d("FeedConfirm", "There is no value for sendinstall.");
                    String str2 = str;
                    obj3 = obj4;
                    string = str2;
                }
                obj4 = URLDecoder.decode(string);
                C6367n.m29107b("TAG", " WORDING = " + obj4 + "xx");
                if (obj3 != null && !TextUtils.isEmpty(obj4)) {
                    m28794a(obj4, this.f21796a, obj);
                } else if (this.f21796a != null) {
                    this.f21796a.mo5288a(obj);
                }
            }
        }
    }

    private void m28794a(String str, C6252b c6252b, Object obj) {
        PackageInfo packageInfo;
        Drawable drawable = null;
        Dialog dialog = new Dialog(this.f21797b.f21790m);
        dialog.requestWindowFeature(1);
        PackageManager packageManager = this.f21797b.f21790m.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(this.f21797b.f21790m.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            drawable = packageInfo.applicationInfo.loadIcon(packageManager);
        }
        OnClickListener c6269f = new C6269f(this, dialog, c6252b, obj);
        OnClickListener c6270g = new C6270g(this, dialog, c6252b, obj);
        Drawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(0);
        dialog.getWindow().setBackgroundDrawable(colorDrawable);
        dialog.setContentView(m28793a(this.f21797b.f21790m, drawable, str, c6269f, c6270g));
        dialog.setOnCancelListener(new C6271h(this, c6252b, obj));
        if (this.f21797b.f21790m != null && !this.f21797b.f21790m.isFinishing()) {
            dialog.show();
        }
    }

    private Drawable m28792a(String str, Context context) {
        IOException e;
        Drawable createFromStream;
        try {
            InputStream open = context.getApplicationContext().getAssets().open(str);
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                Bitmap decodeStream;
                try {
                    decodeStream = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                    decodeStream = null;
                }
                if (decodeStream == null) {
                    return null;
                }
                byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
                NinePatch.isNinePatchChunk(ninePatchChunk);
                return new NinePatchDrawable(decodeStream, ninePatchChunk, new Rect(), null);
            }
            createFromStream = Drawable.createFromStream(open, str);
            try {
                open.close();
                return createFromStream;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                return createFromStream;
            }
        } catch (IOException e4) {
            IOException iOException = e4;
            createFromStream = null;
            e = iOException;
            e.printStackTrace();
            return createFromStream;
        }
    }

    private View m28793a(Context context, Drawable drawable, String str, OnClickListener onClickListener, OnClickListener onClickListener2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        View relativeLayout = new RelativeLayout(context);
        View imageView = new ImageView(context);
        imageView.setImageDrawable(drawable);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setId(1);
        int i = (int) (14.0f * f);
        i = (int) (18.0f * f);
        int i2 = (int) (6.0f * f);
        int i3 = (int) (18.0f * f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (60.0f * f));
        layoutParams.addRule(9);
        layoutParams.setMargins(0, i, i2, i3);
        relativeLayout.addView(imageView, layoutParams);
        imageView = new TextView(context);
        imageView.setText(str);
        imageView.setTextSize(14.0f);
        imageView.setGravity(3);
        imageView.setIncludeFontPadding(false);
        imageView.setPadding(0, 0, 0, 0);
        imageView.setLines(2);
        imageView.setId(5);
        imageView.setMinWidth((int) (185.0f * f));
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, 1);
        layoutParams2.addRule(6, 1);
        int i4 = (int) (10.0f * f);
        layoutParams2.setMargins(0, 0, (int) (5.0f * f), 0);
        relativeLayout.addView(imageView, layoutParams2);
        imageView = new View(context);
        imageView.setBackgroundColor(Color.rgb(214, 214, 214));
        imageView.setId(3);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, 2);
        layoutParams2.addRule(3, 1);
        layoutParams2.addRule(5, 1);
        layoutParams2.addRule(7, 5);
        layoutParams2.setMargins(0, 0, 0, (int) (12.0f * f));
        relativeLayout.addView(imageView, layoutParams2);
        imageView = new LinearLayout(context);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(5, 1);
        layoutParams2.addRule(7, 5);
        layoutParams2.addRule(3, 3);
        View button = new Button(context);
        button.setText("跳过");
        button.setBackgroundDrawable(m28792a("buttonNegt.png", context));
        button.setTextColor(Color.rgb(36, 97, 131));
        button.setTextSize(20.0f);
        button.setOnClickListener(onClickListener2);
        button.setId(4);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, (int) (45.0f * f));
        layoutParams3.rightMargin = (int) (14.0f * f);
        layoutParams3.leftMargin = (int) (4.0f * f);
        layoutParams3.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        imageView.addView(button, layoutParams3);
        button = new Button(context);
        button.setText("确定");
        button.setTextSize(20.0f);
        button.setTextColor(Color.rgb(255, 255, 255));
        button.setBackgroundDrawable(m28792a("buttonPost.png", context));
        button.setOnClickListener(onClickListener);
        layoutParams3 = new LinearLayout.LayoutParams(0, (int) (45.0f * f));
        layoutParams3.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        layoutParams3.rightMargin = (int) (4.0f * f);
        imageView.addView(button, layoutParams3);
        relativeLayout.addView(imageView, layoutParams2);
        LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (163.0f * f));
        relativeLayout.setPadding((int) (14.0f * f), 0, (int) (12.0f * f), (int) (12.0f * f));
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
        Drawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
        paintDrawable.setCornerRadius(f * 5.0f);
        relativeLayout.setBackgroundDrawable(paintDrawable);
        return relativeLayout;
    }

    protected void m28798b() {
        C6396i.m29198a(this.f21797b.c, this.f21797b.f21790m, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", this.f21797b.m28714d(), HttpPost.METHOD_NAME, null);
    }

    public void mo5287a(C6494d c6494d) {
        if (this.f21796a != null) {
            this.f21796a.mo5287a(c6494d);
        }
    }

    public void mo5286a() {
        if (this.f21796a != null) {
            this.f21796a.mo5286a();
        }
    }
}
