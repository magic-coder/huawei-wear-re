package com.huawei.ui.device.activity.selectcontact;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.datatype.Contact;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.b;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.h;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.views.selectcontact.C2211a;
import java.util.List;

public class ContactDeleteActivity extends BaseActivity implements OnClickListener {
    List<Contact> f7549a;
    C2211a f7550b;
    C1990r f7551c;
    ai f7552d;
    private String f7553e = "ContactDeleteActivity";
    private Context f7554f;
    private LinearLayout f7555g;
    private LinearLayout f7556h;
    private TextView f7557i;
    private ImageView f7558j;
    private ListView f7559k;
    private CustomTitleBar f7560l;
    private long f7561m = 0;
    private final int f7562n = 1000;
    private int f7563o;
    private Handler f7564p = new C2144e(this, this);

    private void m10967a() {
        C2538c.m12677c(this.f7553e, "enter handleSetSuccess");
        finish();
    }

    private void m10968b() {
        C2538c.m12677c(this.f7553e, "enter handleSetFail");
        a.b(this.f7554f, i.IDS_settings_mult_alarm_clock_synchroFailed_dialog);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_device_settings_contact_delete_activity_black);
        m10970c();
        m10973d();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f7564p != null) {
            this.f7564p.removeMessages(1);
            this.f7564p.removeMessages(2);
            this.f7564p = null;
        }
    }

    private void m10970c() {
        this.f7554f = getApplicationContext();
        this.f7563o = 0;
        this.f7551c = C1990r.m10400a(this.f7554f);
        this.f7549a = this.f7551c.m10432c(this.f7554f);
        if (this.f7549a == null || this.f7549a.size() == 0) {
            C2538c.m12680e(this.f7553e, "error ContactDB-------------->>>get null DB, the activity will be finished!");
            return;
        }
        C2538c.m12677c(this.f7553e, "mContactTables size = " + this.f7549a.size());
    }

    private void m10973d() {
        this.f7555g = (LinearLayout) d.a(this, e.contact_delete_bottom_delete_layout);
        this.f7555g.setOnClickListener(this);
        this.f7556h = (LinearLayout) d.a(this, e.contact_delete_bottom_seleteall_layout);
        this.f7556h.setOnClickListener(this);
        this.f7558j = (ImageView) d.a(this, e.contact_delete_bottom_seleteall_img);
        this.f7557i = (TextView) d.a(this, e.contact_delete_bottom_seleteall_textview);
        this.f7560l = (CustomTitleBar) d.a(this, e.contact_delete_titlebar);
        this.f7560l.setTitleCountBg(getResources().getDrawable(g.bg_number));
        this.f7560l.setTitleCountColor(getResources().getColor(b.common_white_90alpha));
        this.f7560l.setCountNumVisibility(0);
        this.f7560l.setTitleCountNum(0);
        this.f7559k = (ListView) d.a(this, e.contact_delete_listview);
        this.f7559k.setSelector(com.huawei.ui.device.d.device_settings_contact_listview_item_selector_black);
        this.f7550b = new C2211a(this.f7554f, this.f7549a);
        this.f7559k.setAdapter(this.f7550b);
        this.f7559k.setOnItemClickListener(new C2140a(this));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == e.contact_delete_bottom_delete_layout) {
            C2538c.m12677c(this.f7553e, "contact_delete_bottom_delete_layout");
            if (!m10988l()) {
                if (this.f7563o == 0) {
                    C2538c.m12677c(this.f7553e, "onClick() contact_delete_bottom_delete_layout if (mcheckNum == 0)");
                    return;
                }
                m10984j();
            }
        } else if (id == e.contact_delete_bottom_seleteall_layout) {
            C2538c.m12677c(this.f7553e, "contact_delete_bottom_seleteall_layout");
            m10975e();
        } else {
            C2538c.m12677c(this.f7553e, "i = " + id);
        }
    }

    private void m10975e() {
        C2538c.m12677c(this.f7553e, "handleSelectAll mcheckNum=" + this.f7563o);
        if (this.f7563o == this.f7549a.size()) {
            m10977f();
            this.f7560l.setTitleCountNum(0);
            return;
        }
        m10979g();
        this.f7560l.setTitleCountNum(this.f7563o);
    }

    private void m10977f() {
        for (int i = 0; i < this.f7549a.size(); i++) {
            C2211a.m11359a().put(Integer.valueOf(i), Boolean.valueOf(false));
        }
        this.f7563o = 0;
        this.f7550b.notifyDataSetChanged();
        m10980h();
    }

    private void m10979g() {
        for (int i = 0; i < this.f7549a.size(); i++) {
            C2211a.m11359a().put(Integer.valueOf(i), Boolean.valueOf(true));
        }
        this.f7563o = this.f7549a.size();
        this.f7550b.notifyDataSetChanged();
        m10982i();
    }

    private void m10980h() {
        this.f7557i.setText(i.IDS_contact_delete_select_all);
        this.f7558j.setImageDrawable(getResources().getDrawable(g.ic_selectall_toolbar));
    }

    private void m10982i() {
        this.f7557i.setText(i.IDS_contact_delete_uncheck_all);
        this.f7558j.setImageDrawable(getResources().getDrawable(g.ic_disselectall_toolbar));
    }

    private void m10984j() {
        String quantityString = getResources().getQuantityString(h.IDS_settings_gemini_contact_delete_confirm, this.f7563o, new Object[]{C0956c.m3344a((double) this.f7563o, 1, 0)});
        this.f7552d = new ak(this).a(quantityString).b(i.IDS_settings_button_cancal, new C2142c(this)).a(getResources().getString(i.IDS_music_management_delete).toUpperCase(), b.common_dialog_red_btn_color, new C2141b(this)).a();
        this.f7552d.show();
    }

    private void m10987k() {
        C2538c.m12674b(this.f7553e, "saveData() delete data before mContactTables = " + this.f7549a);
        int size = this.f7549a.size();
        C2538c.m12677c(this.f7553e, "map=" + C2211a.m11359a());
        for (int i = size - 1; i >= 0; i--) {
            C2538c.m12677c(this.f7553e, "mContactTables i=" + i);
            if (((Boolean) C2211a.m11359a().get(Integer.valueOf(i))).booleanValue()) {
                C2538c.m12677c(this.f7553e, "getIsSelected i=" + i + " is selected!");
                this.f7549a.remove(i);
            }
        }
        C2538c.m12674b(this.f7553e, "saveData() delete data after mContactTables = " + this.f7549a);
        if (this.f7551c == null) {
            C2538c.m12680e(this.f7553e, "mDeviceSettingsInteractors of saveData error null!");
            return;
        }
        if (C1988p.m10381a(this.f7554f).m10396d() != 2) {
            a.b(this.f7554f, i.IDS_device_not_connect);
        }
        this.f7551c.m10416a(this.f7554f, this.f7549a, new C2143d(this));
    }

    private boolean m10988l() {
        long currentTimeMillis = System.currentTimeMillis();
        if (1000 > currentTimeMillis - this.f7561m) {
            C2538c.m12677c(this.f7553e, "onClick", ">_< >_< click too much");
            this.f7561m = currentTimeMillis;
            return true;
        }
        this.f7561m = currentTimeMillis;
        return false;
    }
}
