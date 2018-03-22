package com.huawei.pluginkidwatch.plugin.chat;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1745b;
import java.util.Iterator;

/* compiled from: ChatActivity */
class C1757k extends Handler {
    final /* synthetic */ ChatActivity f4849a;

    C1757k(ChatActivity chatActivity) {
        this.f4849a = chatActivity;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1000:
                    C2538c.m12674b("ChatActivity", "=====MSG_DOWNLOAD_FAILED_VOICE");
                    if (this.f4849a.f4723g != null) {
                        C1745b c1745b = new C1745b(this.f4849a.f4709Q);
                        Iterator it = this.f4849a.f4723g.iterator();
                        while (it.hasNext()) {
                            ab abVar = (ab) it.next();
                            if (!(abVar.f2997h == null || "".equals(abVar.f2997h))) {
                                C2538c.m12674b("ChatActivity", "=====try  to download the failed voice message:" + abVar.f2991b);
                                c1745b.m8480a(this.f4849a.f4709Q, abVar);
                            }
                        }
                        break;
                    }
                    return;
                case 1002:
                    C2538c.m12674b("ChatActivity", "=====MSG_REFERSH_UI");
                    if (this.f4849a.f4720d.size() == 0) {
                        this.f4849a.f4700H.setVisibility(0);
                    } else {
                        this.f4849a.f4700H.setVisibility(8);
                    }
                    this.f4849a.m8386a(false);
                    this.f4849a.f4705M.m8494a(this.f4849a.ae);
                    if (this.f4849a.f4720d.size() <= 40) {
                        this.f4849a.m8370a(this.f4849a.f4725i);
                    }
                    C1506g.m6979b();
                    break;
                case 1003:
                    C2538c.m12674b("ChatActivity", "=====MSG_RECORD_TIME_REACHED");
                    this.f4849a.ai = this.f4849a.ai < 0 ? 0 : this.f4849a.ai;
                    this.f4849a.f4736t.setText(this.f4849a.ai + " \"");
                    this.f4849a.ai = this.f4849a.ai - 1;
                    break;
                case 1004:
                    C2538c.m12674b("ChatActivity", "=====MSG_NEW_WORK_ERROR");
                    if (!C1492l.m6916b(this.f4849a.f4709Q)) {
                        C1483c.m6824a(this.f4849a.f4709Q, C1680l.IDS_plugin_kidwatch_common_network_disable);
                        break;
                    }
                    break;
                case 1005:
                    C2538c.m12674b("ChatActivity", "=====MSG_HIDE_KEYBORD");
                    this.f4849a.m8334E();
                    break;
                case 1006:
                    if (this.f4849a.ae == 1 && this.f4849a.f4719c != null && this.f4849a.f4719c.size() > 0) {
                        this.f4849a.m8429i();
                        break;
                    }
            }
            super.handleMessage(message);
        }
    }
}
