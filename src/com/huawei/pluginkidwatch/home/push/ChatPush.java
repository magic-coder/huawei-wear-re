package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1397m;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.ChatBean;
import com.huawei.pluginkidwatch.plugin.chat.ChatActivity;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1745b;

public class ChatPush implements IPushProcess {
    private static final String TAG = "ChatPush";
    private static final long TIMElIMITED = 604800000;
    private static final int TYPE_TEXT = 1;
    private static final int TYPE_VIOCE = 0;
    private Gson gson = new Gson();
    ChatBean mChatBean = new ChatBean();
    private boolean support = true;

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(TAG, "====== ChatPush == process start=======strMsg:" + str);
        if (this.support) {
            if (str != null && str.length() > 0) {
                if (!paraseChatBean(str)) {
                    C2538c.m12674b(TAG, "====== ChatPush == chatBean:" + this.mChatBean);
                    ab abVar = new ab();
                    if (C1492l.m6922f(this.mChatBean.time) <= 0) {
                        abVar.f2996g = System.currentTimeMillis() + "";
                    } else if (Math.abs(System.currentTimeMillis() - C1492l.m6922f(this.mChatBean.time)) > 604800000) {
                        C2538c.m12674b(TAG, "======More then 7 days ,not download");
                        return;
                    } else {
                        abVar.f2996g = this.mChatBean.time;
                    }
                    abVar.f2990a = this.mChatBean.deviceCode;
                    abVar.f2993d = this.mChatBean.data.fromId;
                    abVar.f2991b = this.mChatBean.data.url;
                    abVar.f3007r = this.mChatBean.data.createTime + "";
                    abVar.f3008s = this.mChatBean.data.serverTime + "";
                    setRelationTypeAddHeadUrl(context, abVar);
                    C1745b c1745b = new C1745b(context);
                    String str2 = "";
                    String a = c1745b.m8479a(context, C1492l.m6920d(this.mChatBean.deviceCode), this.mChatBean.data.fromId);
                    C2538c.m12674b(TAG, "======filePath:" + a);
                    abVar.f2997h = a;
                    if (this.mChatBean.data.messageType == 0) {
                        abVar.f3002m = 4;
                        abVar.f3003n = false;
                    } else if (1 == this.mChatBean.data.messageType) {
                        abVar.f3002m = 0;
                        abVar.f3003n = true;
                    }
                    abVar.f2998i = this.mChatBean.data.headUrl;
                    abVar.f3004o = this.mChatBean.data.key;
                    abVar.f3005p = this.mChatBean.data.iv;
                    abVar.f2992c = this.mChatBean.name;
                    abVar.f2995f = this.mChatBean.data.text;
                    abVar.f2999j = C1492l.m6920d(this.mChatBean.deviceCode);
                    abVar.f2994e = this.mChatBean.data.messageType + "";
                    abVar.f3009t = System.currentTimeMillis() + "";
                    if ("".equals(C1462f.m6744i())) {
                        str2 = C1093a.m4739a(context).m4750c();
                        C1462f.m6729c(str2);
                        abVar.f3000k = str2;
                    } else {
                        abVar.f3000k = C1462f.m6744i();
                    }
                    C2538c.m12674b(TAG, "======table:" + abVar.toString());
                    C1392h.m6277a(context, abVar);
                    processChatMessage(context, z, abVar, c1745b, a);
                } else {
                    return;
                }
            }
            C2538c.m12674b(TAG, "====== ChatPush == process end=======");
        }
    }

    private void processChatMessage(Context context, boolean z, ab abVar, C1745b c1745b, String str) {
        if (!abVar.f2993d.equals(abVar.f2990a)) {
            C1462f.m6712A().put(abVar.f2993d, abVar.f2998i);
        }
        if (this.mChatBean.data.messageType == 0) {
            c1745b.m8481a(context, abVar, HomeActivity.class, z);
            return;
        }
        String format = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_chat_receive_message), new Object[]{abVar.f2992c});
        if (abVar.f2990a.equals(C1462f.m6746j())) {
            C2538c.m12674b(TAG, "============和当前devicecode相同");
            if (ChatActivity.class.getName().equals(C1492l.m6907a(context))) {
                C2538c.m12674b(TAG, "============K1Util.getCurrentActivityClassName is ChatActivity freshChatActivityUI");
                freshChatActivityUI(context, str);
            } else if (z) {
                C2538c.m12674b(TAG, "============K1Util.getCurrentActivityClassName is not ChatActivity freshChatActivityUI");
                freshChatActivityUI(context, str);
                C1497q.m6943a(context, "chat_group_id", abVar.f2990a);
                C1495o.m6930a(context, ChatActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 11, new int[0]);
            }
        } else if (z) {
            C1497q.m6943a(context, "chat_group_id", abVar.f2990a);
            Context context2 = context;
            C1495o.m6930a(context2, HomeActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 11, C1492l.m6920d(abVar.f2990a));
        }
    }

    private void setRelationTypeAddHeadUrl(Context context, ab abVar) {
        if ("".equals(this.mChatBean.data.headUrl)) {
            C1397m g = C1392h.m6313g(context, this.mChatBean.data.fromId);
            if (g != null) {
                abVar.f3006q = g.f3119k;
                return;
            }
            C2538c.m12674b(TAG, "====== memberTable is null");
            return;
        }
        abVar.f2998i = this.mChatBean.data.headUrl;
        abVar.f3006q = "";
    }

    private boolean paraseChatBean(String str) {
        try {
            this.mChatBean = (ChatBean) this.gson.fromJson(str, ChatBean.class);
        } catch (JsonSyntaxException e) {
            C2538c.m12674b(TAG, "======ERROR!!! " + e.getMessage());
        }
        if (this.mChatBean != null && C1492l.m6920d(this.mChatBean.deviceCode) > 0) {
            return false;
        }
        C2538c.m12674b(TAG, "======return 1");
        return true;
    }

    private void freshChatActivityUI(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.chat.refresh");
        intent.putExtra("chat_voice_path", str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
