package com.huawei.sim.esim.qrcode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.google.zxing.C3709a;
import com.google.zxing.C3934m;
import com.google.zxing.client.p285a.C3741u;
import com.google.zxing.client.p285a.C3743q;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.esim.p505b.C5901b;
import com.huawei.sim.esim.qrcode.decoding.C5916e;
import com.huawei.sim.esim.qrcode.decoding.CaptureActivityHandler;
import com.huawei.sim.esim.qrcode.p506a.C5905c;
import com.huawei.sim.esim.qrcode.view.ViewfinderView;
import com.huawei.sim.esim.view.EsimProfileBTFailActivity;
import com.huawei.sim.esim.view.EsimProflieAuthenticationFail;
import com.huawei.sim.esim.view.ScanFailActivity;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Vector;

public class QrCodeActivity extends BaseActivity implements Callback {
    private static String f20205a = "QrCodeActivity";
    private CaptureActivityHandler f20206b;
    private ViewfinderView f20207c;
    private boolean f20208d;
    private Vector<C3709a> f20209e;
    private String f20210f = "";
    private C5916e f20211g;
    private C6002a f20212h = null;
    private C4501b f20213i;
    private int f20214j;
    private C3743q f20215k = null;
    private boolean f20216l = false;
    private IBaseResponseCallback f20217m = new C5908a(this);
    private IBaseResponseCallback f20218n = new C5910c(this);
    private IBaseResponseCallback f20219o = new C5911d(this);
    private Handler f20220p = new Handler();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m27141a();
        this.f20213i = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20213i == null) {
            C2538c.e(f20205a, new Object[]{"mHWDeviceConfigManager is null"});
            return;
        }
        this.f20214j = new SecureRandom().nextInt();
        this.f20213i.mo4468a(this.f20219o);
        C2538c.b(f20205a, new Object[]{"mRankData " + this.f20214j});
    }

    protected void m27141a() {
        requestWindowFeature(1);
        C2538c.c(f20205a, new Object[]{"--initView---=====-"});
        setContentView(h.activity_sim_qrcode);
        C5905c.m27160a(getApplicationContext());
        this.f20207c = (ViewfinderView) findViewById(g.viewfinder);
        this.f20208d = false;
        this.f20211g = new C5916e(this);
    }

    protected void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(g.preview_view)).getHolder();
        if (this.f20208d) {
            m27133a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f20209e = null;
        this.f20210f = null;
    }

    protected void onPause() {
        super.onPause();
        if (this.f20206b != null) {
            this.f20206b.m27177a();
            this.f20206b = null;
        }
        C5905c.m27159a().m27164b();
        C5905c.m27159a().m27166c();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        if (this.f20213i != null) {
            this.f20213i.mo4475b(this.f20219o);
        }
        this.f20211g.m27182b();
        m27140f();
        if (this.f20220p != null) {
            this.f20220p.removeCallbacksAndMessages(null);
            this.f20220p = null;
        }
        super.onDestroy();
    }

    private void m27133a(SurfaceHolder surfaceHolder) {
        try {
            C5905c.m27159a().m27163a(surfaceHolder);
            if (this.f20206b == null) {
                this.f20206b = new CaptureActivityHandler(this, this.f20209e, this.f20210f);
            }
        } catch (IOException e) {
            C2538c.e(f20205a, new Object[]{"====  initCamera IOException e : " + e.getMessage()});
        } catch (RuntimeException e2) {
            C2538c.e(f20205a, new Object[]{"====  initCamera RuntimeException e : " + e2.getMessage()});
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f20208d) {
            this.f20208d = true;
            m27133a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f20208d = false;
    }

    public ViewfinderView m27143b() {
        return this.f20207c;
    }

    public Handler m27144c() {
        return this.f20206b;
    }

    public void m27145d() {
        this.f20207c.m27183a();
    }

    public boolean m27142a(C3934m c3934m, Bitmap bitmap) {
        this.f20211g.m27182b();
        if (c3934m != null) {
            this.f20215k = C3741u.m18832d(c3934m);
        }
        C2538c.e(f20205a, new Object[]{"====  handleDecode : " + this.f20215k.toString()});
        if (new C5901b().m27120a(this.f20215k)) {
            C2538c.e(f20205a, new Object[]{"二维码不可用"});
            startActivity(new Intent(this, ScanFailActivity.class));
            finish();
            return false;
        }
        int i = 3;
        if (this.f20213i == null) {
            C2538c.e(f20205a, new Object[]{"null == pluginSimAdapter"});
        } else {
            i = this.f20213i.mo4474b();
        }
        if (2 == i) {
            C2538c.e(f20205a, new Object[]{"蓝牙连接"});
            m27132a(i.IDS_plugin_sim_loading_profile);
            this.f20213i.mo4470a(this.f20215k.toString(), this.f20218n, this.f20217m);
        } else {
            startActivity(new Intent(this, EsimProfileBTFailActivity.class));
            finish();
        }
        return true;
    }

    private void m27132a(int i) {
        C2538c.c(f20205a, new Object[]{"showLoadingDialog()"});
        if (!isFinishing()) {
            if (this.f20212h == null) {
                C6002a c6002a = new C6002a(this, j.common_dialog21);
                this.f20212h = C6002a.m27468a((Context) this);
                this.f20212h.m27476a(getResources().getString(i));
                this.f20212h.setCancelable(false);
            } else {
                this.f20212h.m27476a(getResources().getString(i));
            }
            if (this.f20212h != null) {
                this.f20212h.m27474a();
                C2538c.c(f20205a, new Object[]{"mLoadingUserInformationDialog.show()"});
            }
        }
    }

    private void m27140f() {
        if (!isFinishing()) {
            C2538c.c(f20205a, new Object[]{"enter dismissLoadingDialog()"});
            if (this.f20212h != null && this.f20212h.isShowing()) {
                C2538c.c(f20205a, new Object[]{"dismissLoadingDialog()!"});
                this.f20212h.cancel();
                this.f20212h = null;
            }
        }
    }

    private void m27135b(int i) {
        Intent intent = new Intent(this, EsimProflieAuthenticationFail.class);
        intent.putExtra("mata_report", i);
        startActivity(intent);
        finish();
        m27140f();
    }
}
