package com.huawei.ui.device.activity.goldmember;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;
import com.huawei.ui.device.p170a.C1998z;

public class VIPMemberActivationActivity extends BaseActivity implements OnClickListener {
    private static String f7291e = "VIPMemberActivationActivity";
    DataDeviceInfo f7292a = null;
    C1998z f7293b;
    private Button f7294c;
    private Context f7295d;
    private int f7296f;
    private C2085f f7297g = new C2085f();
    private a f7298h;
    private C2084e f7299i = null;
    private TextView f7300j;
    private TextView f7301k;

    protected void onCreate(Bundle bundle) {
        C2538c.m12677c(f7291e, "enter onCreate()");
        super.onCreate(bundle);
        this.f7295d = this;
        this.f7292a = new DataDeviceInfo();
        this.f7293b = new C1998z(this.f7295d);
        this.f7296f = getIntent().getFlags();
        m10777c();
        this.f7299i = new C2084e(this, Looper.getMainLooper());
    }

    protected void onResume() {
        C2538c.m12677c(f7291e, "enter onResume()");
        super.onResume();
    }

    public void onClick(View view) {
        C2538c.m12677c(f7291e, "enter onClick()");
        if (view.getId() != e.vip_activation_Ok) {
            return;
        }
        if (C0977d.m3555e(this.f7295d)) {
            this.f7299i.sendEmptyMessage(0);
            m10775b();
            return;
        }
        C2538c.m12677c(f7291e, "Network is not Connected ");
        com.huawei.ui.commonui.c.a.a(this.f7295d, i.IDS_confirm_network_whether_connected);
    }

    private void m10775b() {
        C2538c.m12677c(f7291e, "enter activation");
        this.f7293b.m10472a(this.f7295d, new C2083d(this));
    }

    protected void m10783a(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    private void m10777c() {
        C2538c.m12677c(f7291e, "enter initView()");
        setContentView(f.activity_vip_member_rights_activation);
        a aVar = new a(this.f7295d, j.app_update_dialogActivity);
        this.f7298h = a.a(this.f7295d);
        this.f7294c = (Button) d.a(this, e.vip_activation_Ok);
        this.f7294c.setOnClickListener(this);
        this.f7300j = (TextView) d.a(this, e.Member_Free_machine_protection);
        this.f7301k = (TextView) d.a(this, e.Member_Free_Extended_warranty);
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || 10 != c.getProductType()) {
            this.f7300j.setVisibility(0);
            this.f7301k.setVisibility(0);
            return;
        }
        C2538c.m12677c(f7291e, "current device is LEO !");
        this.f7300j.setVisibility(8);
        this.f7301k.setVisibility(8);
    }

    protected void onDestroy() {
        C2538c.m12677c(f7291e, "enter onDestroy()");
        super.onDestroy();
        if (this.f7299i != null) {
            this.f7299i.removeMessages(2);
            this.f7299i.removeMessages(3);
            this.f7299i.removeMessages(4);
            this.f7299i.removeMessages(0);
            this.f7299i.removeMessages(1);
        }
        if (this.f7298h != null) {
            this.f7298h.dismiss();
            this.f7298h = null;
        }
        finish();
    }

    private void m10779d() {
        if (this.f7298h != null) {
            if (this.f7298h.isShowing()) {
                this.f7298h.dismiss();
            }
            this.f7298h = null;
        }
        if (this.f7297g != null) {
            this.f7299i.removeCallbacks(this.f7297g);
        }
    }
}
