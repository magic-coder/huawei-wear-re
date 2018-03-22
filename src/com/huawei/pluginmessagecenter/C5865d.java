package com.huawei.pluginmessagecenter;

import android.content.Context;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.pluginmessagecenter.p499a.C5855a;
import com.huawei.pluginmessagecenter.p499a.C5858d;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.service.PullMessageCallBack;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.config.ParseConfig;
import java.util.Map;

/* compiled from: MessagePuller */
public class C5865d {
    private static volatile C5865d f20132a = null;

    private C5865d() {
        C2538c.c("MessagePuller", new Object[]{"MessagePuller"});
    }

    private String m27052a(Context context, long j) {
        C5861g.m27024c("MessagePuller", "Enter getBody");
        StringBuffer stringBuffer = new StringBuffer();
        C4478x c4478x = (C4478x) j.a(context).getAdapter();
        if (c4478x == null) {
            C5861g.m27024c("MessagePuller", "adapter is null return null");
            return stringBuffer.toString();
        }
        Map a = c4478x.mo4465a(new String[]{"getUserInfo", "getPhoneInfo", "getAppInfo", "getDeviceInfo", "getLoginInfo"});
        String str = "";
        String valueOf = String.valueOf(Integer.MAX_VALUE);
        String str2 = (String) a.get("deviceType");
        String str3 = (String) a.get("version");
        String str4 = (String) a.get("severToken");
        String str5 = (String) a.get("appType");
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        String str6 = (String) a.get("iversion");
        String str7 = (String) a.get(UserInfo.LANGUAGECODE);
        String str8 = (String) a.get("deviceId");
        String str9 = (String) a.get("sysVersion");
        String str10 = (String) a.get(AppOpenOrDownHelper.APP_ID_PARAM);
        String str11 = "1";
        String str12 = (String) a.get("deviceModel");
        String str13 = (String) a.get("productType");
        String str14 = (String) a.get(ParseConfig.CFG_ENVIRONMENT);
        String a2 = C5855a.m27001a(str13);
        if (a2 == null) {
            a2 = "";
        }
        stringBuffer.append("token=" + str4);
        stringBuffer.append("&deviceType=" + str12);
        stringBuffer.append("&appType=" + str5);
        stringBuffer.append("&phoneType=" + str2);
        stringBuffer.append("&timestamp=" + String.valueOf(j));
        stringBuffer.append("&version=" + str3);
        stringBuffer.append("&ts=" + valueOf2);
        stringBuffer.append("&healthType=" + str);
        stringBuffer.append("&recordNumber=" + valueOf);
        stringBuffer.append("&tokenType=" + str11);
        stringBuffer.append("&appId=" + str10);
        stringBuffer.append("&deviceId=" + str8);
        stringBuffer.append("&sysVersion=" + str9);
        stringBuffer.append("&bindDeviceType=" + str13);
        stringBuffer.append("&iVersion=" + str6);
        stringBuffer.append("&language=" + str7);
        stringBuffer.append("&environment=" + str14);
        stringBuffer.append("&wearType=" + a2);
        C5861g.m27024c("MessagePuller", "getBody body = " + stringBuffer.toString());
        C5861g.m27024c("MessagePuller", "Leave getBody");
        return stringBuffer.toString();
    }

    public void m27053a(Context context, long j, PullMessageCallBack pullMessageCallBack) {
        C5861g.m27024c("MessagePuller", "pullMessage() time = " + j);
        if (pullMessageCallBack == null) {
            C5861g.m27024c("MessagePuller", "pullMessage() PullMessageCallBack = null");
        } else if (j < 0) {
            C5861g.m27024c("MessagePuller", "pullMessage() time < 0  time = " + j);
            pullMessageCallBack.pullMessageResult(-1, null);
        } else {
            String str = "https://messagecenter.hicloud.com/messageCenter/getMessages";
            if (i.a(40)) {
                C4478x c4478x = (C4478x) j.a(context).getAdapter();
                if (c4478x == null) {
                    C5861g.m27024c("MessagePuller", "adapter is null");
                    return;
                }
                C5858d.m27011a(str, m27052a(context, j), c4478x.mo4465a(new String[]{"getLoginInfo", "getAppInfo"}), new C5866e(this, context, pullMessageCallBack));
                return;
            }
            pullMessageCallBack.pullMessageResult(-1, null);
        }
    }

    public static C5865d m27051a() {
        if (f20132a == null) {
            synchronized (C5865d.class) {
                if (f20132a == null) {
                    f20132a = new C5865d();
                }
            }
        }
        return f20132a;
    }
}
