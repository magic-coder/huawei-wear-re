package com.huawei.pluginaf500.ui;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.mode.C3626i;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.utils.C5826i;

public class ResetBraceletActivity extends AF500BaseActivity {
    private final int f19809a = 200;
    private OnClickListener f19810b = new be(this);
    private OnClickListener f19811c = new bf(this);
    private final BroadcastReceiver f19812d = new bi(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.reset_setting);
        registerReceiver(this.f19812d, new IntentFilter("com.fenda.hwbracelet.INTENT_FACTORY_RESET"), "com.af500.permission.MYBRODCAST", null);
        ((Button) findViewById(e.btn_reset)).setOnClickListener(new bd(this));
    }

    private void m26787j() {
        C5826i.m26921a(this, h.reset_setting, h.reset_setting_message, h.sure, h.cancel, this.f19810b, this.f19811c);
    }

    private void m26788k() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.no_connect);
        c5823f.m26919b(h.no_connect_note);
        c5823f.m26916a(h.sure, new bg(this));
        c5823f.m26914a().show();
    }

    private void m26789l() {
        C5823f c5823f = new C5823f(this);
        c5823f.m26915a(h.unbind_fail);
        c5823f.m26919b(h.unbind_fail_tip);
        c5823f.m26916a(h.sure, new bh(this));
        c5823f.m26914a().show();
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 101:
                if (3 != C3596n.m18054a()) {
                    m26788k();
                    return;
                } else if (m26514e() != null) {
                    m26514e().m26559a(C3626i.m18164a());
                    return;
                } else {
                    return;
                }
            case 102:
                m26512c();
                m26789l();
                return;
            default:
                return;
        }
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
    }

    protected void onDestroy() {
        d.n(this);
        super.onDestroy();
        if (this.f19812d != null) {
            unregisterReceiver(this.f19812d);
        }
    }

    protected int mo5104a() {
        return f.act_reset_bralecet_setting;
    }
}
