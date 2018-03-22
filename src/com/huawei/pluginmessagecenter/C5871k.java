package com.huawei.pluginmessagecenter;

import android.text.TextUtils;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import java.util.Map;

/* compiled from: PluginMessageCenter */
class C5871k implements Runnable {
    final /* synthetic */ j f20144a;

    C5871k(j jVar) {
        this.f20144a = jVar;
    }

    public void run() {
        C4478x c4478x = (C4478x) this.f20144a.getAdapter();
        if (c4478x != null) {
            Object c = C5870i.m27069c(j.a(this.f20144a));
            C5861g.m27024c("PluginMessageCenter", "changeUserRunnable lastHUID=" + c);
            Map a = c4478x.mo4465a(new String[]{"getLoginInfo", "getUserInfo"});
            String str = (String) a.get("huid");
            C5861g.m27024c("PluginMessageCenter", "changeUserRunnable currentHUID=" + str);
            C5870i.m27066a(j.a(this.f20144a), str);
            if (!(TextUtils.isEmpty(c) || c.equals(str))) {
                C5862a.m27025a(j.a(this.f20144a)).m27039a();
            }
            C5870i.m27068b(j.a(this.f20144a), (String) a.get(UserInfo.LANGUAGECODE));
        }
    }
}
