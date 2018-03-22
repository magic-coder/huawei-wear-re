package com.huawei.hwbtsdk.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.huawei.hwbtsdk.*;
import com.huawei.hwbtsdk.C6698c;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.hwbtsdk.C6700e;
import com.huawei.hwbtsdk.p399a.C4616s;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;

public class BTDeviceScanListActivity extends BaseActivity {
    private ViewSwitcher f17057a;
    private TextView f17058b;
    private ListView f17059c;
    private ImageView f17060d;
    private Animation f17061e;
    private C4616s f17062f;
    private LinearLayout f17063g;
    private LinearLayout f17064h;
    private Context f17065i;
    private Handler f17066j = new C4662a(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17065i = BaseApplication.b();
        setContentView(C6699d.devices_scan_list_layout);
        m22392a();
    }

    private void m22392a() {
        this.f17061e = AnimationUtils.loadAnimation(this.f17065i, C6697b.device_scan_anim);
        this.f17057a = (ViewSwitcher) findViewById(C6698c.scan_status_switcher);
        this.f17058b = (TextView) findViewById(C6698c.scan_tip);
        this.f17059c = (ListView) findViewById(C6698c.device_list);
        this.f17060d = (ImageView) findViewById(C6698c.blite_scan_arc);
        this.f17060d.setAnimation(this.f17061e);
        this.f17061e.start();
        this.f17062f = new C4616s(this.f17065i);
        this.f17059c.setAdapter(this.f17062f);
        BTSDKApi.a(this.f17065i).a(this.f17062f);
        this.f17059c.setOnItemClickListener(new C4663b(this));
        this.f17063g = (LinearLayout) findViewById(C6698c.bt_cancel_layout);
        this.f17063g.setOnClickListener(new C4664c(this));
        this.f17064h = (LinearLayout) findViewById(C6698c.bt_rescan_layout);
        this.f17064h.setOnClickListener(new C4665d(this));
        int intExtra = getIntent().getIntExtra("device_type", -1);
        BTSDKApi.a(this.f17065i).b(this.f17066j);
        if (m22394a(intExtra)) {
            BTSDKApi.a(this.f17065i).b();
        }
    }

    private void m22396b() {
        this.f17061e.cancel();
        this.f17064h.setClickable(true);
        this.f17058b.setText(C6700e.IDS_blite_guide_scan_completed);
        if (this.f17062f.getCount() == 0) {
            this.f17057a.setDisplayedChild(1);
        }
    }

    public void onDestroy() {
        BTSDKApi.a(this.f17065i).d();
        this.f17061e.cancel();
        m22397c();
        super.onDestroy();
    }

    private void m22397c() {
        BTSDKApi.a(this.f17065i).f();
        finish();
    }

    private boolean m22394a(int i) {
        if (1 != i && 2 != i) {
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        if ((2 != i && com.huawei.hwcommonmodel.d.d.a()) || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 1:
                boolean z;
                if (iArr[0] == 0) {
                    z = true;
                } else {
                    z = false;
                }
                C2538c.a("01", 1, "BTDeviceScanListActivity", new Object[]{"----grant result:" + z});
                if (z) {
                    BTSDKApi.a(this.f17065i).b();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
