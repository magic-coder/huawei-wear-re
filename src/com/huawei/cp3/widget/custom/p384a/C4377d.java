package com.huawei.cp3.widget.custom.p384a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.cp3.C4366c;
import com.huawei.cp3.C4367d;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import java.text.NumberFormat;

/* compiled from: HwProgressDialogCustom */
public class C4377d extends Dialog implements C4371b {
    private boolean f16249A;
    private boolean f16250B;
    private Handler f16251C;
    private boolean f16252D = false;
    private boolean f16253a = false;
    private boolean f16254b = false;
    private Context f16255c;
    private Button f16256d;
    private Button f16257e;
    private TextView f16258f;
    private TextView f16259g;
    private LinearLayout f16260h;
    private LinearLayout f16261i;
    private LinearLayout f16262j;
    private ProgressBar f16263k;
    private TextView f16264l;
    private LayoutInflater f16265m;
    private int f16266n = 0;
    private TextView f16267o;
    private String f16268p;
    private TextView f16269q;
    private NumberFormat f16270r;
    private int f16271s;
    private int f16272t;
    private int f16273u;
    private int f16274v;
    private int f16275w;
    private Drawable f16276x;
    private Drawable f16277y;
    private CharSequence f16278z;

    public C4377d(Context context, int i) {
        super(context, i);
        Log.i("HwProgressDialog", "HwProgressDialog ");
        this.f16255c = context;
        this.f16265m = (LayoutInflater) context.getSystemService("layout_inflater");
        requestWindowFeature(1);
        m21020a();
        m21024c();
    }

    private void m21020a() {
        setContentView(C4367d.cp3_custom_dialog_layout);
        this.f16260h = (LinearLayout) findViewById(C4366c.dialog_layout);
        this.f16258f = (TextView) findViewById(C4366c.title);
        this.f16262j = (LinearLayout) findViewById(C4366c.content);
        this.f16259g = (TextView) findViewById(C4366c.msg);
        this.f16261i = (LinearLayout) findViewById(C4366c.button_layout);
        this.f16256d = (Button) findViewById(C4366c.ok);
        this.f16257e = (Button) findViewById(C4366c.cancel);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("HwProgressDialog", "onCreate ");
        m21022b();
    }

    public void onStart() {
        super.onStart();
        this.f16250B = true;
    }

    protected void onStop() {
        super.onStop();
        this.f16250B = false;
    }

    public void onContentChanged() {
        super.onContentChanged();
        Window window = getWindow();
        if (window != null) {
            LayoutParams attributes = window.getAttributes();
            int a = C4379f.m21040a(getContext());
            int b = C4379f.m21041b(getContext());
            if (a > b) {
                attributes.width = (int) (((double) b) * 0.85d);
            } else {
                attributes.width = (int) (((double) a) * 0.85d);
            }
            window.setAttributes(attributes);
        }
    }

    private void m21022b() {
        View inflate;
        if (this.f16266n == 1) {
            this.f16251C = new C4378e(this);
            inflate = this.f16265m.inflate(C4367d.cp3_custom_alert_progress_dlg, null);
            this.f16263k = (ProgressBar) inflate.findViewById(C4366c.progress);
            this.f16267o = (TextView) inflate.findViewById(C4366c.progress_number);
            this.f16269q = (TextView) inflate.findViewById(C4366c.progress_percent);
            m21030a(inflate);
        } else {
            inflate = this.f16265m.inflate(C4367d.cp3_custom_progress_dlg, null);
            this.f16263k = (ProgressBar) inflate.findViewById(C4366c.progress);
            this.f16264l = (TextView) inflate.findViewById(C4366c.message);
            m21030a(inflate);
        }
        if (this.f16271s > 0) {
            m21037d(this.f16271s);
        }
        if (this.f16272t > 0) {
            m21034b(this.f16272t);
        }
        if (this.f16273u > 0) {
            m21036c(this.f16273u);
        }
        if (this.f16274v > 0) {
            m21038e(this.f16274v);
        }
        if (this.f16275w > 0) {
            m21039f(this.f16275w);
        }
        if (this.f16276x != null) {
            m21029a(this.f16276x);
        }
        if (this.f16277y != null) {
            m21035b(this.f16277y);
        }
        if (this.f16278z != null) {
            mo4439a(this.f16278z);
        }
        m21033a(this.f16249A);
        m21026d();
    }

    private void m21024c() {
        this.f16268p = "%1d/%2d";
        this.f16270r = NumberFormat.getPercentInstance();
        this.f16270r.setMaximumFractionDigits(0);
    }

    public void m21032a(String str) {
        if (this.f16258f != null) {
            this.f16258f.setVisibility(0);
            this.f16258f.setText(str);
        }
    }

    public void setTitle(int i) {
        m21032a(this.f16255c.getResources().getString(i));
    }

    public void mo4439a(CharSequence charSequence) {
        if (this.f16263k == null) {
            this.f16278z = charSequence;
        } else if (this.f16266n == 1) {
            this.f16259g.setVisibility(0);
            this.f16259g.setText(charSequence);
        } else {
            this.f16264l.setVisibility(0);
            this.f16264l.setText(charSequence);
        }
    }

    public void mo4438a(int i) {
        Log.i("HwProgressDialog", "setProgressStyle ");
        this.f16266n = i;
    }

    public void m21033a(boolean z) {
        Log.i("HwProgressDialog", "setIndeterminate ");
        if (this.f16263k != null) {
            this.f16263k.setIndeterminate(z);
        } else {
            this.f16249A = z;
        }
    }

    public void m21034b(int i) {
        if (this.f16250B) {
            Log.i("HwProgressDialog", "setProgress ");
            this.f16263k.setProgress(i);
            m21026d();
            return;
        }
        this.f16272t = i;
    }

    public void m21036c(int i) {
        if (this.f16263k != null) {
            this.f16263k.setSecondaryProgress(i);
            m21026d();
            return;
        }
        this.f16273u = i;
    }

    public void m21037d(int i) {
        if (this.f16263k != null) {
            this.f16263k.setMax(i);
            m21026d();
            return;
        }
        this.f16271s = i;
    }

    public void m21038e(int i) {
        if (this.f16263k != null) {
            this.f16263k.incrementProgressBy(i);
            m21026d();
            return;
        }
        this.f16274v += i;
    }

    public void m21039f(int i) {
        if (this.f16263k != null) {
            this.f16263k.incrementSecondaryProgressBy(i);
            m21026d();
            return;
        }
        this.f16275w += i;
    }

    public void m21029a(Drawable drawable) {
        if (this.f16263k != null) {
            this.f16263k.setProgressDrawable(drawable);
        } else {
            this.f16276x = drawable;
        }
    }

    public void m21035b(Drawable drawable) {
        if (this.f16263k != null) {
            this.f16263k.setIndeterminateDrawable(drawable);
        } else {
            this.f16277y = drawable;
        }
    }

    public void m21030a(View view) {
        this.f16260h.setPadding(0, 0, 0, 0);
        if (this.f16262j != null) {
            this.f16262j.setPadding(0, 0, 0, 0);
            this.f16262j.removeAllViews();
            this.f16262j.addView(view);
            this.f16262j.setVisibility(0);
        }
    }

    private void m21026d() {
        Log.i("HwProgressDialog", " onProgressChanged.");
        if (this.f16266n == 1 && this.f16251C != null && !this.f16251C.hasMessages(0)) {
            this.f16251C.sendEmptyMessage(0);
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            Log.e("HwProgressDialog", "showDialog failed.", e);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable e) {
            Log.e("HwProgressDialog", "dismiss failed.", e);
        }
    }

    public void cancel() {
        try {
            super.cancel();
        } catch (Throwable e) {
            Log.e("HwProgressDialog", "cancel failed.", e);
        }
    }

    public Window getWindow() {
        return super.getWindow();
    }

    public boolean onSearchRequested() {
        if (this.f16253a) {
            return this.f16254b;
        }
        return super.onSearchRequested();
    }
}
