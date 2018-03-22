package com.huawei.pluginaf500.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwcommonmodel.p064d.p406a.C4718b;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5821d;

public class AF500IntroduceActivity extends Activity implements OnRequestPermissionsResultCallback, OnClickListener {
    private ViewPager f19667a;
    private Button f19668b;
    private Button f19669c;
    private int[] f19670d = new int[]{f.startup_af500_introduce_first_view, f.startup_af500_introduce_second_view};
    private View[] f19671e = new View[this.f19670d.length];
    private boolean f19672f = false;
    private Context f19673g;
    private PagerAdapter f19674h = new C5798g(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19673g = BaseApplication.b();
        this.f19672f = getIntent().getBooleanExtra("isStartupGuide", false);
        setContentView(f.startup_af500_guidance_common);
        this.f19668b = (Button) findViewById(e.btn_introduce_last);
        this.f19669c = (Button) findViewById(e.btn_af500_paired);
        this.f19668b.setOnClickListener(this);
        this.f19669c.setOnClickListener(this);
        this.f19667a = (ViewPager) findViewById(e.vp_common_guide);
        this.f19667a.setAdapter(this.f19674h);
        if (!C5821d.m26904a((Context) this, C5821d.m26906b())) {
            C5821d.m26902a((Activity) this, C5821d.m26906b());
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f19671e = null;
        d.n(this.f19673g);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && 2 == i2) {
            finish();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == e.btn_introduce_last) {
            Intent intent = new Intent();
            intent.setClassName(this.f19673g, "com.huawei.ui.device.activity.adddevice.AddDeviceActivity");
            startActivity(intent);
            finish();
        } else if (id != e.btn_af500_paired) {
        } else {
            if (m26624b(this.f19673g)) {
                m26622a(true);
            } else {
                m26621a((Context) this);
            }
        }
    }

    private void m26622a(boolean z) {
        C2538c.c("AF500IntroduceActivity", new Object[]{"Start to active AF500GuideActivity"});
        Intent intent = new Intent(this.f19673g, AF500GuideActivity.class);
        intent.putExtra("isStartupGuide", this.f19672f);
        startActivityForResult(intent, 1);
    }

    private void m26621a(Context context) {
        new Builder(context).setTitle(h.startup_introduce_dailog_title).setMessage(h.startup_introduce_af500_dailog_content).setPositiveButton(h.settings_button_ok, new C5799h(this)).create().show();
    }

    private boolean m26624b(Context context) {
        if (VERSION.SDK_INT < 18) {
            return false;
        }
        boolean hasSystemFeature;
        if (context != null) {
            hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        } else {
            hasSystemFeature = false;
        }
        if (context == null || !r1) {
            return false;
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.c("AF500IntroduceActivity", new Object[]{"Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()"});
        C4718b.m22594a().m22602a(strArr, iArr);
    }
}
