package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContactsListActivity */
class cg implements OnItemLongClickListener {
    final /* synthetic */ ContactsListActivity f5996a;

    cg(ContactsListActivity contactsListActivity) {
        this.f5996a = contactsListActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Map hashMap = new HashMap();
        if (C1462f.m6754n()) {
            hashMap.put("is_manager", "1");
        } else {
            hashMap.put("is_manager", "0");
        }
        hashMap.put("is_family_p", "0");
        c.a().a(BaseApplication.m2632b(), a.Z.a(), hashMap, 0);
        if (this.f5996a.f5588L != null && this.f5996a.f5588L.size() > 0 && i < this.f5996a.f5588L.size()) {
            this.f5996a.f5582F = (Contact) this.f5996a.f5588L.get(i);
            if (String.valueOf(this.f5996a.f5582F.getContactId()).equals(C1462f.m6742h())) {
                this.f5996a.f5578B = new C1507h(this.f5996a, SdkConstants.REQUEST_CAMERA_VIDEO, 60, h.dialog_contact_longtouch_delete, m.servicedialog, true);
                this.f5996a.f5578B.show();
                ((TextView) this.f5996a.f5578B.findViewById(g.menu_tv_delete)).setOnClickListener(new ch(this));
            } else {
                this.f5996a.f5578B = new C1507h(this.f5996a, SdkConstants.REQUEST_CAMERA_VIDEO, 60, h.dialog_contact_longtouch_delete, m.servicedialog, true);
                this.f5996a.f5578B.show();
                ((TextView) this.f5996a.f5578B.findViewById(g.menu_tv_delete)).setOnClickListener(new ch(this));
            }
        }
        return true;
    }
}
