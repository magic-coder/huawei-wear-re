package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: ContactsListActivity */
class cs extends Handler {
    final /* synthetic */ ContactsListActivity f6013a;

    cs(ContactsListActivity contactsListActivity) {
        this.f6013a = contactsListActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f6013a.isFinishing()) {
            switch (message.what) {
                case 3:
                    C2538c.m12674b("ContactsListActivity", "==ww== HANDLER_DELETE_SUCCESS");
                    this.f6013a.f5605d = this.f6013a.f5605d - 1;
                    this.f6013a.m9254m();
                    return;
                case 6:
                    C2538c.m12674b("ContactsListActivity", "==ww== HANDLER_UPDATA_UI");
                    if (this.f6013a.f5590N || ContactsListActivity.aa) {
                        C2538c.m12674b("ContactsListActivity", "==ww== HANDLER_UPDATA_UI 获取网路普通联系人并更新数据库 ");
                        this.f6013a.m9246i();
                        this.f6013a.f5590N = false;
                        if (ContactsListActivity.aa) {
                            ContactsListActivity.aa = false;
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
