package com.huawei.wallet.ui.idencard.camera.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.b.c;
import com.huawei.b.f;
import com.huawei.b.h;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventType;
import com.huawei.wallet.ui.idencard.camera.base.BaseOverlayView.IEventListener;
import com.huawei.wallet.utils.UIUtil;
import com.huawei.wallet.utils.log.LogC;
import exocr.base.ExBaseCardInfo;

public abstract class BaseCaptureActivity extends BaseActivity implements Callback {
    private CheckBox f21504a;
    protected BaseCaptureActivityHandler f21505b;
    protected BaseOverlayView f21506c;
    protected ExBaseCardInfo f21507d;
    protected String f21508e = null;
    private SurfaceView f21509f;
    private boolean f21510g;

    class C61631 implements OnClickListener {
        final /* synthetic */ BaseCaptureActivity f21557a;

        C61631(BaseCaptureActivity baseCaptureActivity) {
            this.f21557a = baseCaptureActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f21557a.finish();
            dialogInterface.dismiss();
        }
    }

    class ButtonLightCheckChangedListener implements OnCheckedChangeListener {
        private ButtonLightCheckChangedListener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CameraManager.m28405a().m28414a(z);
        }
    }

    class OverlayViewEventListener implements IEventListener {
        private Handler f21558a;

        public OverlayViewEventListener(Handler handler) {
            this.f21558a = handler;
        }

        public void mo5182a() {
            if (this.f21558a != null) {
                Message.obtain(this.f21558a, 1).sendToTarget();
            }
        }
    }

    class SurfaceViewPreDrawListener implements OnPreDrawListener {
        private SurfaceView f21559a;

        public SurfaceViewPreDrawListener(SurfaceView surfaceView) {
            this.f21559a = surfaceView;
        }

        public boolean onPreDraw() {
            if (this.f21559a == null) {
                return false;
            }
            LayoutParams layoutParams = this.f21559a.getLayoutParams();
            layoutParams.height = (this.f21559a.getMeasuredWidth() * 4) / 3;
            this.f21559a.setLayoutParams(layoutParams);
            this.f21559a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public abstract BaseCaptureActivityHandler mo5166a(BaseCaptureActivity baseCaptureActivity);

    public abstract void mo5168a(Object obj, long j);

    protected abstract void mo5169b();

    public abstract Handler mo5171d();

    @TargetApi(19)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mo5172e()) {
            UIUtil.m28490b(this);
        }
        CameraManager.m28406a(getApplication());
        mo5167a();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m28334f();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void m28334f() {
        EventDispatchManager.m28051a().m28056a(this.f21508e, IEventType.TYPE_CAMERA_BACK_PRESSED, null);
        EventDispatchManager.m28051a().m28054a(this.f21508e);
        CardResultInfoManager.m28422d().m28427c();
        finish();
    }

    protected final void m28328a(int i) {
    }

    protected void mo5167a() {
        this.f21510g = false;
        mo5169b();
        this.f21504a = (CheckBox) findViewById(f.btn_light);
        if (!getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            this.f21504a.setVisibility(8);
        }
        this.f21504a.setChecked(false);
        this.f21504a.setOnCheckedChangeListener(new ButtonLightCheckChangedListener());
        this.f21509f = (SurfaceView) findViewById(f.preview_view);
        this.f21509f.getViewTreeObserver().addOnPreDrawListener(new SurfaceViewPreDrawListener(this.f21509f));
        this.f21506c = (BaseOverlayView) findViewById(f.overlayview);
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("exocr.bankcard.guideColor", 0);
            if (intExtra != 0) {
                this.f21506c.setGuideColor(intExtra | ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.f21506c.setGuideColor(getResources().getColor(c.brandcolor));
            }
        }
        this.f21506c.m28390a(new OverlayViewEventListener(this.f21505b));
    }

    protected void onResume() {
        super.onResume();
        m28335g();
    }

    protected void m28335g() {
        if (this.f21509f != null) {
            SurfaceHolder holder = this.f21509f.getHolder();
            if (this.f21510g) {
                m28324a(holder);
                return;
            }
            holder.addCallback(this);
            holder.setType(3);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f21504a != null) {
            this.f21504a.setChecked(m28336h());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CameraManager.m28405a().m28420f();
        mo5167a();
        m28335g();
    }

    protected void onPause() {
        super.onPause();
        if (this.f21504a != null) {
            this.f21504a.setChecked(false);
        }
        if (this.f21506c != null) {
            this.f21506c.m28391b();
        }
        if (this.f21505b != null) {
            this.f21505b.m28357b();
            this.f21505b = null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        CameraManager.m28405a().m28418d();
    }

    public boolean m28336h() {
        return CameraManager.m28405a().m28421g();
    }

    public void onBackPressed() {
        LogC.m28530b("onBackPressed()", false);
        EventDispatchManager.m28051a().m28056a(this.f21508e, IEventType.TYPE_CAMERA_BACK_PRESSED, null);
        EventDispatchManager.m28051a().m28054a(this.f21508e);
        CardResultInfoManager.m28422d().m28427c();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 13274385 || i2 == 13274386) {
            m28323a(i2, intent);
        } else if (this.f21506c != null) {
            this.f21506c.setScannerAlpha(4);
        }
    }

    private void m28323a(int i, Intent intent) {
        setResult(i, intent);
        CardResultInfoManager.m28422d().m28427c();
        EventDispatchManager.m28051a().m28056a(this.f21508e, IEventType.TYPE_CAMERA_IDENTIFY_CARD, intent);
        EventDispatchManager.m28051a().m28054a(this.f21508e);
        finish();
    }

    protected void m28337i() {
        setResult(0);
        EventDispatchManager.m28051a().m28056a(this.f21508e, IEventType.TYPE_CAMERA_SWITCH_INPUT, null);
        EventDispatchManager.m28051a().m28054a(this.f21508e);
        finish();
    }

    private void m28324a(SurfaceHolder surfaceHolder) {
        long currentTimeMillis = System.currentTimeMillis();
        if (CameraManager.m28405a().m28413a(surfaceHolder, (Activity) this)) {
            if (this.f21505b == null) {
                this.f21505b = mo5166a(this);
            } else {
                this.f21505b.m28356a();
            }
            mo5170c();
            LogC.m28530b("init camera : " + (System.currentTimeMillis() - currentTimeMillis), false);
            return;
        }
        m28325a(getString(h.wallet_camera_disable_tips));
    }

    protected void mo5170c() {
        if (this.f21506c != null) {
            int i;
            LayoutParams layoutParams = this.f21506c.getLayoutParams();
            int width = this.f21506c.getWidth();
            int height = this.f21506c.getHeight();
            if (width <= height) {
                layoutParams.height = width;
                i = width;
            } else {
                layoutParams.width = height;
                width = height;
                i = height;
            }
            this.f21506c.setLayoutParams(layoutParams);
            this.f21506c.m28389a(CameraManager.m28405a().m28415b().m28399a().x, CameraManager.m28405a().m28415b().m28399a().y, i, width, 0);
        }
    }

    private void m28325a(String str) {
        C4370a a = C4372a.m20997a((Context) this);
        a.mo4431b(str);
        a.mo4427a(getString(h.wallet_camera_confirm), new C61631(this));
        a.show();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f21510g) {
            this.f21510g = true;
            m28324a(surfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        mo5170c();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f21510g = false;
    }

    protected boolean mo5172e() {
        return false;
    }
}
