package com.huawei.ui.device.activity.selectcontact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.views.selectcontact.C2214d;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ContactSelectNumberDialog extends BaseActivity {
    private String f7590a = "ContactSelectNumberDialog";
    private Context f7591b;
    private ListView f7592c;
    private C2214d f7593d;
    private CustomTitleBar f7594e;
    private String f7595f;
    private String f7596g;
    private ArrayList<String> f7597h;
    private ArrayList<String> f7598i;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_device_settings_contact_select_one_number_dialog_black);
        m11032a();
        m11033b();
    }

    private void m11032a() {
        this.f7591b = getApplicationContext();
        Intent intent = getIntent();
        this.f7595f = intent.getStringExtra(HwPayConstant.KEY_USER_NAME);
        this.f7596g = intent.getStringExtra("contactId");
        this.f7597h = intent.getStringArrayListExtra("userNumbers");
        this.f7598i = intent.getStringArrayListExtra("numberTypes");
        if (this.f7595f == null) {
            C2538c.m12674b(this.f7590a, " getIntent mUserName is null ! ");
            this.f7595f = "";
        }
        if (this.f7596g == null) {
            C2538c.m12674b(this.f7590a, " getIntent mContactId is null ! ");
            this.f7596g = "";
        }
        if (this.f7597h == null) {
            C2538c.m12674b(this.f7590a, " getIntent mUserNumbers is null ! ");
            this.f7597h = new ArrayList();
        }
        if (this.f7598i == null) {
            C2538c.m12674b(this.f7590a, " getIntent mNumberType is null ! ");
            this.f7598i = new ArrayList();
        }
        C2538c.m12674b(this.f7590a, "check mUserName=" + this.f7595f + ", mContactId=" + this.f7596g + ", mUserNumbers=" + this.f7597h + ", mNumberType=" + this.f7598i);
    }

    private void m11033b() {
        this.f7593d = new C2214d(this.f7591b, this.f7597h);
        this.f7592c = (ListView) d.a(this, e.contact_selectnumber_listview);
        this.f7592c.setSelector(com.huawei.ui.device.d.device_settings_contact_listview_item_selector_black);
        this.f7592c.setAdapter(this.f7593d);
        this.f7592c.setOnItemClickListener(new C2151l(this));
        this.f7594e = (CustomTitleBar) d.a(this, e.contact_select_number_titlebar);
        this.f7594e.setLeftButtonDrawable(getResources().getDrawable(g.ic_titlebar_back));
        this.f7594e.setLeftButtonOnClickListener(new C2152m(this));
        this.f7594e.setRightButtonOnClickListener(new C2153n(this));
    }

    private void m11035c() {
        C2538c.m12677c(this.f7590a, "handleCancelClick");
        finish();
    }

    private void m11037d() {
        C2538c.m12677c(this.f7590a, "handleSubmitClick");
        Intent intent = new Intent();
        intent.putExtra(HwPayConstant.KEY_USER_NAME, this.f7595f);
        intent.putExtra("contactId", this.f7596g);
        intent.putExtra("selectNumber", m11038e());
        intent.putExtra("numberType", m11039f());
        setResult(-1, intent);
        finish();
    }

    private String m11038e() {
        C2538c.m12677c(this.f7590a, "getSelectedNumber");
        if (this.f7597h == null || this.f7597h.size() <= m11040g()) {
            return null;
        }
        return (String) this.f7597h.get(m11040g());
    }

    private String m11039f() {
        C2538c.m12677c(this.f7590a, "getSelectedType");
        if (this.f7597h == null || this.f7598i.size() <= m11040g()) {
            return null;
        }
        return (String) this.f7598i.get(m11040g());
    }

    private int m11040g() {
        int intValue;
        for (Entry entry : C2214d.m11362a().entrySet()) {
            if (((Boolean) entry.getValue()).booleanValue()) {
                intValue = ((Integer) entry.getKey()).intValue();
                break;
            }
        }
        intValue = 0;
        C2538c.m12677c(this.f7590a, "selectedIndex=" + intValue);
        return intValue;
    }
}
