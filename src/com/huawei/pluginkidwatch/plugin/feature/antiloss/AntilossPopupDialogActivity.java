package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.ui.view.PopupDialogActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;
import net.sqlcipher.database.SQLiteDatabase;

public class AntilossPopupDialogActivity extends PopupDialogActivity {
    private TextView f4909a;
    private Button f4910b;
    private Button f4911c;
    private BroadcastReceiver f4912d;
    private String f4913e;
    private C1723d f4914f;

    protected void mo2598a() {
        requestWindowFeature(1);
        C2538c.m12674b("AntilossPopupDialogActivity", "AntilossPopupDialogActivity initPopupView...");
        this.f4914f = C1743x.m8322a((Context) this).m8323a();
        setContentView(h.activity_popup_antiloss);
        setFinishOnTouchOutside(false);
        if (C1462f.m6748k() != null) {
            this.f4913e = C1462f.m6748k().f3083c;
        } else {
            this.f4913e = getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default);
        }
        this.f4909a = (TextView) findViewById(g.antiloss_tv_popup_message);
        this.f4910b = (Button) findViewById(g.antiloss_btn_popup_cancel);
        this.f4911c = (Button) findViewById(g.antiloss_btn_popup_radar);
        this.f4909a.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_rangeout_notice, new Object[]{this.f4913e}));
        this.f4911c.setText(C1680l.IDS_plugin_kidwatch_feature_antiloss_radar_call);
        this.f4910b.setOnClickListener(new C1795s(this));
        this.f4911c.setOnClickListener(new C1802t(this));
        this.f4912d = new C1803u(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("antiloss.popup.dialog.activity.destory.action");
        registerReceiver(this.f4912d, intentFilter, "com.huawei.bone.permission.LOCAL_BROADCAST", null);
    }

    private void m8544b() {
        C1773a.m8552a((Context) this).m8563g();
        if (C1773a.m8552a((Context) this) != null) {
            C1773a.m8552a((Context) this).m8561e();
        }
    }

    private void m8546c() {
        C2538c.m12674b("AntilossPopupDialogActivity", "=====Enter makeCall");
        m8548d();
        if (C1462f.m6748k() == null || "".equals(C1462f.m6748k().f3093m)) {
            C2538c.m12680e("AntilossPopupDialogActivity", "=====error to make call to watch,so call up the dial activity");
            startActivity(new Intent("android.intent.action.CALL_BUTTON"));
            return;
        }
        C2538c.m12674b("AntilossPopupDialogActivity", "=====Make Call To :", C1462f.m6748k().f3093m);
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse("tel://" + C1462f.m6748k().f3093m));
        startActivity(intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m8548d() {
        this.f4914f.m8292c(9);
        this.f4914f.m8288b(0);
        this.f4914f.m8301h();
    }

    private void m8549e() {
        C2538c.m12674b("AntilossPopupDialogActivity", "============Enter closeAntilossActivity");
        Intent intent = new Intent();
        intent.setAction("com.huawei.kone.broadcast.close.antilossactivity");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    protected void onDestroy() {
        C2538c.m12674b("AntilossPopupDialogActivity", "======onDestroy");
        unregisterReceiver(this.f4912d);
        super.onDestroy();
    }
}
