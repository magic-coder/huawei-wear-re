package com.huawei.ui.main.stories.account.activity;

import android.os.Looper;
import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.account.interactor.C2353b;

/* compiled from: ThirdPartyLoginActivity */
class C2352p extends a<ThirdPartyLoginActivity> {
    public C2352p(Looper looper, ThirdPartyLoginActivity thirdPartyLoginActivity) {
        super(looper, thirdPartyLoginActivity);
    }

    protected void m11929a(ThirdPartyLoginActivity thirdPartyLoginActivity, Message message) {
        switch (message.what) {
            case 10:
                com.huawei.ui.commonui.c.a.a(thirdPartyLoginActivity.f8473g, thirdPartyLoginActivity.f8473g.getResources().getString(j.IDS_migrage_other_login_same_account));
                return;
            case 11:
                thirdPartyLoginActivity.m11915c();
                return;
            case 12:
                C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: MSG_SHOW_DATA_MIGRATE_CLOUD_CANCLE_KID_WATCH_DIALOG");
                if (message.obj != null) {
                    thirdPartyLoginActivity.m11897a((C2353b) message.obj, message.arg1, message.arg2);
                    return;
                }
                return;
            case 14:
                thirdPartyLoginActivity.m11914b();
                return;
            case 4009:
                thirdPartyLoginActivity.m11911a();
                return;
            case TradeCode.QUERY_TERMINAL_BACK /*4011*/:
                thirdPartyLoginActivity.m11916d();
                return;
            case 4012:
                com.huawei.ui.commonui.c.a.b(thirdPartyLoginActivity.f8473g, thirdPartyLoginActivity.f8473g.getResources().getString(j.IDS_hw_show_other_account_login_failed));
                return;
            case 40091:
                com.huawei.ui.commonui.c.a.b(thirdPartyLoginActivity.f8473g, thirdPartyLoginActivity.f8473g.getResources().getString(j.IDS_hw_show_other_account_migrate_failed));
                return;
            default:
                return;
        }
    }
}
