package com.huawei.pluginkidwatch.plugin.setting.qrcode;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.zxing.a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding.C1966m;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding.CaptureActivityHandler;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a.C1947d;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.view.ViewfinderView;
import java.io.IOException;
import java.util.Vector;

public class QrCodeActivity extends KidWatchBaseActivity implements Callback {
    private static String f6738b = "QrCodeActivity";
    private CaptureActivityHandler f6739c;
    private ViewfinderView f6740d;
    private boolean f6741e;
    private Vector<a> f6742f;
    private String f6743g = "";
    private C1966m f6744h;
    private Button f6745i;
    private Button f6746j;
    private boolean f6747k;
    private OnClickListener f6748l = new C1950a(this);
    private OnClickListener f6749m = new C1951b(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        C2538c.m12674b(f6738b, "--initView---=====-");
        setContentView(h.activity_qrcode);
        C1947d.m10194a(getApplicationContext());
        this.f6740d = (ViewfinderView) findViewById(g.viewfinder_view);
        this.f6741e = false;
        this.f6744h = new C1966m(this);
        this.f6745i = (Button) findViewById(g.guide_btn_qrcode_Album);
        this.f6745i.setOnClickListener(this.f6748l);
        this.f6746j = (Button) findViewById(g.guide_btn_qcode_back);
        this.f6746j.setOnClickListener(this.f6749m);
    }

    protected void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(g.preview_view)).getHolder();
        if (this.f6741e) {
            m10173a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f6742f = null;
        this.f6743g = null;
    }

    protected void onPause() {
        super.onPause();
        if (this.f6739c != null) {
            this.f6739c.m10226a();
            this.f6739c = null;
        }
        C1947d.m10193a().m10198b();
        C1947d.m10193a().m10200c();
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    protected void onDestroy() {
        C0977d.m3575n(this);
        this.f6744h.m10231b();
        if (this.f6739c != null) {
            this.f6739c.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    private void m10173a(SurfaceHolder surfaceHolder) {
        try {
            C1947d.m10193a().m10197a(surfaceHolder);
            if (this.f6739c == null) {
                this.f6739c = new CaptureActivityHandler(this, this.f6744h, this.f6740d, this.f6742f, this.f6743g);
            }
        } catch (IOException e) {
            C2538c.m12680e(f6738b, "====  initCamera IOException e : " + e.getMessage());
            m10176d();
        } catch (RuntimeException e2) {
            C2538c.m12680e(f6738b, "====  initCamera RuntimeException e : " + e2.getMessage());
            m10176d();
        }
    }

    private void m10176d() {
        m10172a(C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_camera_broken, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_camera_broken_msg, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_setting);
    }

    private void m10172a(int i, int i2, int i3, int i4) {
        this.f6747k = false;
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(i);
        c1595v.m7348b(i2);
        c1595v.m7349b(i4, new C1952c(this));
        c1595v.m7340a(i3, new C1953d(this));
        CustomDialog a = c1595v.m7338a();
        a.setOnDismissListener(new C1969e(this));
        a.show();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f6741e) {
            this.f6741e = true;
            m10173a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f6741e = false;
    }
}
