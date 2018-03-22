package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.setting.activity.InviteManagerActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContactsListActivity */
class by implements OnItemLongClickListener {
    final /* synthetic */ ContactsListActivity f5985a;

    by(ContactsListActivity contactsListActivity) {
        this.f5985a = contactsListActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Map hashMap = new HashMap();
        if (C1462f.m6754n()) {
            hashMap.put("is_manager", "1");
        } else {
            hashMap.put("is_manager", "0");
        }
        hashMap.put("is_family_p", "1");
        c.a().a(BaseApplication.m2632b(), a.Z.a(), hashMap, 0);
        C2538c.m12674b("ContactsListActivity", "==ww== setManagerLongClick");
        UserInfo userInfo = (UserInfo) this.f5985a.f5589M.get(i);
        if ("addDeviceCode".equals(userInfo.deviceCode)) {
            Intent intent = new Intent();
            intent.setClass(this.f5985a, InviteManagerActivity.class);
            this.f5985a.startActivity(intent);
        } else if (!C1462f.m6754n()) {
            C1483c.m6824a(this.f5985a, C1680l.IDS_plugin_kidwatch_menu_only_main_option);
        } else if (C1462f.m6744i().equals(userInfo.huid)) {
            C1483c.m6824a(this.f5985a, C1680l.f4407x566cfa68);
        } else {
            if (this.f5985a.f5580D == null) {
                C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog");
                this.f5985a.f5580D = new C1507h(this.f5985a, h.dialog_useinfo_operate, m.servicedialog, false);
                this.f5985a.f5580D.setCanceledOnTouchOutside(true);
            }
            this.f5985a.f5580D.show();
            ((TextView) this.f5985a.f5580D.findViewById(g.usermanage_tv_transferprivilege)).setOnClickListener(new bz(this, i));
            ((TextView) this.f5985a.f5580D.findViewById(g.usermanage_tv_unbind)).setOnClickListener(new ca(this, i));
        }
        return true;
    }
}
