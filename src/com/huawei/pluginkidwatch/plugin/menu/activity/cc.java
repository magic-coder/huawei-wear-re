package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.plugin.setting.activity.InviteManagerActivity;

/* compiled from: ContactsListActivity */
class cc implements OnItemClickListener {
    final /* synthetic */ ContactsListActivity f5992a;

    cc(ContactsListActivity contactsListActivity) {
        this.f5992a = contactsListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f5992a.f5597U != null && this.f5992a.f5597U.size() > 0 && i < this.f5992a.f5597U.size()) {
            UserInfo userInfo = (UserInfo) this.f5992a.f5597U.get(i);
            if (userInfo.deviceCode.equals("addDeviceCode")) {
                Intent intent = new Intent();
                intent.setClass(this.f5992a, InviteManagerActivity.class);
                this.f5992a.startActivity(intent);
            } else if (!userInfo.deviceCode.equals("notice")) {
                Intent intent2;
                if (C1462f.m6754n()) {
                    if (userInfo.huid.equals(C1462f.m6744i())) {
                        intent2 = new Intent(this.f5992a, ContactInfoActivity.class);
                        intent2.putExtra("ttyy", "mainSelf");
                        this.f5992a.m9207a(intent2, userInfo);
                        this.f5992a.startActivity(intent2);
                        return;
                    }
                    intent2 = new Intent(this.f5992a, ContactInfoActivity.class);
                    intent2.putExtra("ttyy", "mainNotSelf");
                    this.f5992a.m9207a(intent2, userInfo);
                    this.f5992a.startActivity(intent2);
                } else if (userInfo.huid.equals(C1462f.m6744i())) {
                    intent2 = new Intent(this.f5992a, ContactInfoActivity.class);
                    intent2.putExtra("ttyy", "notMain");
                    this.f5992a.m9207a(intent2, userInfo);
                    this.f5992a.startActivity(intent2);
                }
            }
        }
    }
}
