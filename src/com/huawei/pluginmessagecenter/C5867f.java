package com.huawei.pluginmessagecenter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.callback.IPushBase;
import com.huawei.hwcloudmodel.callback.c;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.pluginmessagecenter.p499a.C5858d;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.MessageCenterPushBean;
import com.snowballtech.business.config.ParseConfig;
import java.util.Map;

/* compiled from: MessagePushReceiver */
public class C5867f implements IPushBase, c {
    private static int f20136b = -2;
    private static int f20137c = 1002;
    private C5885y f20138a = null;
    private final Handler f20139d = new C5869h(this);

    private void m27059b(Context context, String str) {
        C5861g.m27024c("MessagePushReceiver", "onToken()  ==> saveToken token = " + str);
        C4478x c4478x = (C4478x) j.a(context).getAdapter();
        if (c4478x != null) {
            String str2 = (String) c4478x.mo4465a(new String[]{"getLoginInfo"}).get("huid");
            C5861g.m27024c("MessagePushReceiver", "saveToken==========currentHuid:" + str2);
            String a = C5870i.m27065a(context);
            C5861g.m27024c("MessagePushReceiver", "saveToken==========pushHUID:" + a);
            if (a != null && str2 != null && !a.equals(str2) && !TextUtils.isEmpty(str)) {
                C5861g.m27024c("MessagePushReceiver", "saveToken==>doSaveToken!");
                m27060c(context, str);
            }
        }
    }

    private void m27060c(Context context, String str) {
        C5861g.m27024c("MessagePushReceiver", "Enter doSaveToken");
        if (i.a(40)) {
            C4478x c4478x = (C4478x) j.a(context).getAdapter();
            if (c4478x == null) {
                C5861g.m27024c("MessagePushReceiver", "adapter is null");
                return;
            }
            C5858d.m27011a("https://messagecenter.hicloud.com/messageCenter/savePushToken", m27061d(context, str), c4478x.mo4465a(new String[]{"getLoginInfo", "getAppInfo"}), new C5868g(this, context, str));
            C5861g.m27024c("MessagePushReceiver", "Leave doSaveToken");
        }
    }

    private String m27061d(Context context, String str) {
        C5861g.m27024c("MessagePushReceiver", "Enter getBodyWithToken");
        StringBuffer stringBuffer = new StringBuffer();
        C4478x c4478x = (C4478x) j.a(context).getAdapter();
        if (c4478x == null) {
            return stringBuffer.toString();
        }
        Map a = c4478x.mo4465a(new String[]{"getUserInfo", "getPhoneInfo", "getAppInfo", "getDeviceInfo", "getLoginInfo"});
        String str2 = (String) a.get("severToken");
        String str3 = (String) a.get("appType");
        String str4 = (String) a.get("deviceType");
        String str5 = (String) a.get("version");
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str6 = (String) a.get("deviceId");
        String str7 = (String) a.get("sysVersion");
        String str8 = (String) a.get("iversion");
        String str9 = (String) a.get(UserInfo.LANGUAGECODE);
        String str10 = (String) a.get(AppOpenOrDownHelper.APP_ID_PARAM);
        String str11 = (String) a.get("deviceSn");
        String str12 = (String) a.get("deviceModel");
        String str13 = (String) a.get("productType");
        String str14 = (String) a.get(ParseConfig.CFG_ENVIRONMENT);
        stringBuffer.append("tokenType=" + "1");
        stringBuffer.append("&token=" + str2);
        stringBuffer.append("&appId=" + str10);
        stringBuffer.append("&deviceId=" + str6);
        stringBuffer.append("&sysVersion=" + str7);
        stringBuffer.append("&appType=" + str3);
        stringBuffer.append("&iVersion=" + str8);
        stringBuffer.append("&language=" + str9);
        stringBuffer.append("&version=" + str5);
        stringBuffer.append("&pushToken=" + str);
        stringBuffer.append("&phoneType=" + str4);
        stringBuffer.append("&sn=" + str11);
        stringBuffer.append("&ts=" + valueOf);
        stringBuffer.append("&deviceType=" + str12);
        stringBuffer.append("&bindDeviceType=" + str13);
        stringBuffer.append("&environment=" + str14);
        C5861g.m27024c("MessagePushReceiver", "Leave getBodyWithToken getBody====>" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public void processPushMsg(Context context, String str) {
        if (str == null || "".equals(str) || str.length() < 1) {
            C5861g.m27023b("MessagePushReceiver", "processPushMsg  Error PushMsg is Empty");
            return;
        }
        C5861g.m27024c("MessagePushReceiver", "processPushMsg():msg=" + str);
        if (str.equals("messagecenter")) {
            j.a(context).c();
        } else {
            C5861g.m27024c("MessagePushReceiver", "processReceive ==> list = null or list.size() <= 0");
        }
        try {
            MessageCenterPushBean messageCenterPushBean = (MessageCenterPushBean) new Gson().fromJson(str, MessageCenterPushBean.class);
            if ("2".equals(messageCenterPushBean.pushType) && "messagecenter".equals(messageCenterPushBean.pushContent)) {
                j.a(context).c();
            } else {
                C5861g.m27024c("MessagePushReceiver", "processReceive ==> list = null or list.size() <= 0");
            }
        } catch (JsonSyntaxException e) {
            C5861g.m27023b("MessagePushReceiver", "processPushMsg JsonSyntaxException:" + e.getMessage());
        }
    }

    public void m27062a(Context context, String str) {
        m27059b(context, str);
    }
}
