package com.huawei.ui.device.activity.selectcontact;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.datatype.Contact;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.views.selectcontact.dragsortlistview.C2215a;
import com.huawei.ui.device.views.selectcontact.dragsortlistview.DragListView;
import java.util.List;

public class ContactOrderbyActivity extends BaseActivity {
    private String f7583a = "ContactOrderbyActivity";
    private Context f7584b;
    private CustomTitleBar f7585c;
    private C2215a f7586d = null;
    private List<Contact> f7587e = null;
    private C1990r f7588f;
    private Handler f7589g = new C2150k(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_device_settings_contact_orderby_activity);
        m11021a();
        m11022b();
    }

    private void m11021a() {
        this.f7584b = getApplicationContext();
        this.f7588f = C1990r.m10400a(this.f7584b);
        this.f7587e = this.f7588f.m10432c(this.f7584b);
        if (this.f7587e == null || this.f7587e.size() == 0) {
            C2538c.m12680e(this.f7583a, "get null DBdata, the activity will be shut down!");
            return;
        }
        C2538c.m12677c(this.f7583a, "mContactTables size = " + this.f7587e.size());
    }

    private void m11022b() {
        this.f7585c = (CustomTitleBar) d.a(this, e.contact_orderby_titlebar);
        this.f7585c.setRightButtonOnClickListener(new C2148i(this));
        DragListView dragListView = (DragListView) d.a(this, e.contact_orderby_drag_list);
        this.f7586d = new C2215a(this, this.f7587e);
        dragListView.setAdapter(this.f7586d);
    }

    private void m11025c() {
        C2538c.m12674b(this.f7583a, "saveData() delete data mContactTables = " + this.f7587e);
        if (this.f7588f == null) {
            C2538c.m12680e(this.f7583a, "mDeviceSettingsInteractors of saveData error null!");
            return;
        }
        if (C1988p.m10381a(this.f7584b).m10396d() != 2) {
            a.b(this.f7584b, i.IDS_device_not_connect);
        }
        this.f7588f.m10416a(this.f7584b, this.f7587e, new C2149j(this));
    }

    private void m11027d() {
        this.f7585c.setRightButtonClickable(true);
        finish();
    }

    private void m11028e() {
        a.b(this.f7584b, i.IDS_settings_mult_alarm_clock_synchroFailed_dialog);
        this.f7585c.setRightButtonClickable(true);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f7589g != null) {
            this.f7589g.removeMessages(1);
            this.f7589g.removeMessages(2);
            this.f7589g = null;
        }
    }
}
