package com.huawei.android.pushagent.p020b.p024e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.b.a;
import com.huawei.android.pushagent.a.b.d;
import com.huawei.android.pushagent.a.b.g;
import com.huawei.android.pushagent.a.b.h;
import com.huawei.android.pushagent.a.b.i;
import com.huawei.android.pushagent.a.b.l;
import com.huawei.android.pushagent.a.b.m;
import com.huawei.android.pushagent.a.b.n;
import com.huawei.android.pushagent.a.b.o;
import com.huawei.android.pushagent.a.b.p;
import com.huawei.android.pushagent.a.b.q;
import com.huawei.android.pushagent.b.e.c;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.c.e;
import com.huawei.android.pushagent.p017a.C0642a;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0656a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0658f;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.android.pushagent.p018c.p019a.p026a.C0655e;
import com.huawei.android.pushagent.p018c.p027c.C0662d;
import com.huawei.android.pushagent.p020b.C0647a;
import com.huawei.android.pushagent.p020b.p021a.C0646a;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.android.pushagent.p020b.p022b.C0649c;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.ui.swipe.QuickPayUtil;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class C0651d extends C0647a {
    private static List f1173a = new ArrayList();
    private static final Object f1174b = new Object();
    private String[] f1175c;
    private List f1176d = new ArrayList();
    private List f1177e = new ArrayList();

    public C0651d(Context context) {
        if (!e.c()) {
            C0657e.m2512a("PushLogAC2712", "not support ctrlsocket v2 ");
        } else if (1 == e.b()) {
            C0657e.m2512a("PushLogAC2712", "push is in socket ctrl model, only white packages app can use push");
            this.f1175c = e.a();
        } else {
            C0657e.m2512a("PushLogAC2712", "all apps can use push");
            this.f1175c = new String[0];
        }
    }

    private void m2473a(Context context) {
        if (-1 == b.a(context)) {
            C0657e.m2522d("PushLogAC2712", "sendAllMessagetoServer have no net work");
        } else if (C0646a.m2435e().a()) {
            C0657e.m2517b("PushLogAC2712", "sendAllMessagetoServer get the client");
            ArrayList b = com.huawei.android.pushagent.b.e.b.b(context);
            for (Entry key : new C0659h(context, "pclient_unRegist_info_v2").m2541b().entrySet()) {
                b.add(new p(f.b(context, (String) key.getKey())));
            }
            C0657e.m2512a("PushLogAC2712", "send all client registerToken message count to Sever is " + b.size());
            if (b.size() > 0) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    try {
                        C0646a.m2435e().a((com.huawei.android.pushagent.a.b.a.b) it.next());
                    } catch (Throwable e) {
                        C0657e.m2521c("PushLogAC2712", "call ChannelMgr.getPushChannel().send cause:" + e.toString(), e);
                    }
                }
                return;
            }
            C0657e.m2517b("PushLogAC2712", "no more client need register and unregister");
        } else {
            C0657e.m2522d("PushLogAC2712", "sendAllMessagetoServer have no channel or no connection");
        }
    }

    private void m2474a(Context context, l lVar) {
        byte b = (byte) 0;
        C0657e.m2517b("PushLogAC2712", "enter rspPushMessage");
        byte[] e = lVar.e();
        String str = "";
        if (e == null) {
            C0657e.m2522d("PushLogAC2712", "token is null, error!");
            return;
        }
        String str2;
        com.huawei.android.pushagent.a.b bVar;
        try {
            str = new String(e, GameManager.DEFAULT_CHARSET);
        } catch (Throwable e2) {
            C0657e.m2521c("PushLogAC2712", e2.toString(), e2);
        }
        String str3 = "";
        byte[] d = lVar.d();
        byte[] h = lVar.h();
        if (h == null || h.length <= 0) {
            if (com.huawei.android.pushagent.b.e.b.a(context).a != null) {
                str2 = (String) com.huawei.android.pushagent.b.e.b.a(context).a.get(str);
            }
            str2 = str3;
        } else {
            if (h.length == lVar.g()) {
                try {
                    str2 = new String(h, GameManager.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e3) {
                    C0657e.m2522d("PushLogAC2712", "UnsupportedEncodingException occur");
                    str2 = str3;
                }
                C0657e.m2512a("PushLogAC2712", "rspPushMessage from srv response pkgname is :" + str2);
            }
            str2 = str3;
        }
        String a = C0660a.m2558a(d);
        C0657e.m2512a("PushLogAC2712", "rspPushMessage token =" + C0655e.m2502a(str) + " pkgname=" + str2 + " msgId=" + a);
        m mVar = new m(d, (byte) 0);
        Object obj;
        if (C0660a.m2586i(context).equals(str)) {
            if (m2486b(a)) {
                C0657e.m2517b("PushLogAC2712", "msgId duplicate, do not show it");
                bVar = mVar;
            } else {
                m2482a(a);
                if (this.f1175c == null || this.f1175c.length <= 0) {
                    m2485b(context, e, lVar.f());
                    obj = mVar;
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        for (Object equals : this.f1175c) {
                            if (str2.equals(equals)) {
                                b = (byte) 1;
                                break;
                            }
                        }
                    }
                    if (b != (byte) 0) {
                        m2485b(context, e, lVar.f());
                    } else {
                        C0657e.m2512a("PushLogAC2712", "push message's owner is not white app, send it when screen on");
                        this.f1177e.add(new a(str2, e, lVar.f()));
                    }
                    obj = mVar;
                }
            }
        } else if (str2 == null || !C0662d.m2622a(context, str2)) {
            C0657e.m2522d("PushLogAC2712", "pkgName" + str2 + " is null or not exist in local");
            obj = new m(d, (byte) 2);
        } else if (m2486b(a)) {
            C0657e.m2517b("PushLogAC2712", "msgId duplicate, do not sent it to other apps");
            obj = mVar;
        } else {
            m2482a(a);
            if (this.f1175c == null || this.f1175c.length <= 0) {
                m2480a(context, str2, e, lVar.f());
                obj = mVar;
            } else {
                byte b2;
                for (Object equals2 : this.f1175c) {
                    if (str2.equals(equals2)) {
                        b2 = (byte) 1;
                        break;
                    }
                }
                b2 = (byte) 0;
                if (b2 != (byte) 0) {
                    m2480a(context, str2, e, lVar.f());
                } else {
                    C0657e.m2512a("PushLogAC2712", "push message's owner is not white app, send it when screen on");
                    this.f1176d.add(new a(str2, e, lVar.f()));
                }
                obj = mVar;
            }
        }
        try {
            C0646a.m2435e().a(bVar);
        } catch (Throwable e22) {
            C0657e.m2521c("PushLogAC2712", "call ChannelMgr.getPushChannel().send cause:" + e22.toString(), e22);
        }
        C0657e.m2517b("PushLogAC2712", "rspPushMessage the response msg is :" + bVar);
    }

    private void m2475a(Context context, o oVar) {
        if (oVar == null) {
            C0657e.m2522d("PushLogAC2712", "responseRegisterToken have a wrong parm");
            return;
        }
        C0659h c0659h = new C0659h(context, "pclient_request_info");
        if (!TextUtils.isEmpty(oVar.e())) {
            c0659h.m2546f(oVar.e());
        }
        if (oVar.f() == (byte) 1) {
            C0657e.m2522d("PushLogAC2712", "responseRegisterToken FAILED:" + oVar.f());
            return;
        }
        String d = oVar.d();
        String e = oVar.e();
        C0657e.m2512a("PushLogAC2712", "pushSrv response register token to " + e);
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(d)) {
            C0657e.m2522d("PushLogAC2712", "pushSrv response registerToken a invalid message ");
            return;
        }
        if (e.c()) {
            e.a(e);
        }
        com.huawei.android.pushagent.b.e.b.a(context, d, e);
        if (c0659h.m2541b().size() == 0) {
            C0656a.m2504a(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV").setPackage(context.getPackageName()));
            PushService.m2357a(new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV"));
        }
        C0651d.m2479a(context, e, d);
    }

    private void m2476a(Context context, q qVar) {
        C0657e.m2517b("PushLogAC2712", "unregister token from pushsrv success");
        if (qVar == null) {
            C0657e.m2522d("PushLogAC2712", "responseUnregisterToken have an wrong param");
            return;
        }
        String d = qVar.d();
        com.huawei.android.pushagent.b.e.b.c(context, d);
        C0658f.m2528b(context, d);
        PushService.m2357a(new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV"));
    }

    private void m2477a(Context context, String str) {
        C0657e.m2517b("PushLogAC2712", "begin to get token from pushSrv, packagename = " + str);
        String a = C0660a.m2556a(context);
        new C0659h(context, "pclient_request_info").m2539a(str, "true");
        if (C0646a.m2435e().a()) {
            try {
                C0646a.m2435e().a(new n(a, C0660a.m2581f(context, str)));
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", "call ChannelMgr.getPushChannel().send cause:" + e.toString(), e);
            }
            C0656a.m2507b(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV").setPackage(context.getPackageName()), C0648a.m2447a(context).m2378F() * 1000);
            return;
        }
        PushService.m2357a(new Intent("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV").setPackage(context.getPackageName()));
    }

    private synchronized void m2478a(Context context, String str, Boolean bool) {
        Editor edit = context.getSharedPreferences("pushConfig", 4).edit();
        edit.putBoolean("cloudpush_ConnectStatus", bool.booleanValue()).commit();
        edit.putLong(str, System.currentTimeMillis()).commit();
    }

    public static void m2479a(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Intent flags = new Intent("com.huawei.android.push.intent.REGISTRATION").setPackage(str).putExtra("device_token", str2.getBytes(GameManager.DEFAULT_CHARSET)).putExtra("belongId", C0648a.m2447a(context).m2403b()).setFlags(32);
                C0657e.m2512a("PushLogAC2712", "send registerToken to:" + str + " token:" + C0655e.m2502a(str2));
                context.sendBroadcast(flags);
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", e.toString(), e);
            }
        }
    }

    private void m2480a(Context context, String str, byte[] bArr, byte[] bArr2) {
        if (e.c()) {
            e.a(2, 180);
        } else {
            C0660a.m2549a(2, 180);
        }
        Intent intent = new Intent("com.huawei.android.push.intent.RECEIVE");
        intent.setPackage(str).putExtra("msg_data", bArr2).putExtra("device_token", bArr).setFlags(32);
        context.sendBroadcast(intent);
        PushService.m2357a(new Intent("com.huawei.android.push.intent.MSG_BROAD_TO_APP").putExtra(QuickPayUtil.STR_SOURCE_PKG_PARAM, str));
        C0657e.m2512a("PushLogAC2712", "broadcast pushDataRspMessage to " + str + " over");
    }

    private static void m2481a(SharedPreferences sharedPreferences, NetworkInfo networkInfo) {
        Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("cloudpush_arrayOfNetEventTime", "");
        String str = "";
        if (!TextUtils.isEmpty(string) || string.equals("null")) {
            String[] split = string.split("\\,");
            int length = split.length - 1;
            StringBuffer stringBuffer = new StringBuffer();
            if (length == 16) {
                for (int i = 0; i < 15; i++) {
                    stringBuffer.append(split[i + 1] + ",");
                }
                str = stringBuffer.toString();
            } else if (length < 16) {
                str = string + ",";
            }
        }
        string = Integer.toString(networkInfo.getType());
        string = (networkInfo.isConnected() || networkInfo.isConnectedOrConnecting()) ? string + "-1-" + Long.toString(System.currentTimeMillis()) : string + "-0-" + Long.toString(System.currentTimeMillis());
        edit.putString("cloudpush_arrayOfNetEventTime", str + string).commit();
    }

    private void m2482a(String str) {
        synchronized (f1174b) {
            if (f1173a.size() >= 10) {
                f1173a.remove(0);
            }
            f1173a.add(str);
        }
    }

    private void m2483b(Context context, Intent intent) {
        com.huawei.android.pushagent.a.b.a.b bVar = (com.huawei.android.pushagent.a.b.a.b) intent.getSerializableExtra("push_msg");
        if (bVar == null) {
            C0657e.m2517b("PushLogAC2712", "msg is null");
            return;
        }
        switch (bVar.a()) {
            case SdkConstants.STAT_VERIFY_CODE_ERROR /*-96*/:
                C0660a.m2561a(context, 10000);
                m2474a(context, (l) bVar);
                return;
            case (byte) -91:
                com.huawei.android.pushagent.b.e.a.a().a(context, (com.huawei.android.pushagent.a.b.b) bVar);
                return;
            case (byte) -90:
                try {
                    C0646a.m2435e().a(new com.huawei.android.pushagent.a.b.b(TagName.OPERATION_STEP));
                } catch (Throwable e) {
                    C0657e.m2521c("PushLogAC2712", "send serverToAgentMsgRsp error:" + e.getMessage(), e);
                }
                com.huawei.android.pushagent.b.e.a.a().a(context, (com.huawei.android.pushagent.a.b.b) bVar);
                return;
            case (byte) -45:
                d dVar = (d) bVar;
                if (dVar.d() == (byte) 0) {
                    C0657e.m2517b("PushLogAC2712", "PushCommandProcessor device register success");
                    C0649c.m2460a(context, new C0642a("cloudpush_arrayOfNetEventTime", String.class, ""));
                    C0646a.m2432b(context).a(false);
                    C0646a.m2432b(context).g();
                    m2473a(context);
                    return;
                }
                C0657e.m2522d("PushLogAC2712", "PushCommandProcessor device register fail:" + dVar.d());
                return;
            case ApplyAidResponse.RESULT_CODE_APPLYAID_EXCEED_LIMIT /*-41*/:
                m2476a(context, (q) bVar);
                return;
            case (byte) -37:
                return;
            case (byte) -35:
                C0660a.m2561a(context, 10000);
                m2475a(context, (o) bVar);
                return;
            case ActivateOrNullifyCardResponse.RESULT_CODE_AUTH_CODE_UNMATCH /*-33*/:
                i iVar = (i) bVar;
                if (iVar.d() == (byte) 0) {
                    C0657e.m2517b("PushLogAC2712", "PushCommandProcessor device register success");
                    C0649c.m2460a(context, new C0642a("cloudpush_arrayOfNetEventTime", String.class, ""));
                    C0646a.m2432b(context).a(false);
                    C0646a.m2432b(context).g();
                    m2473a(context);
                    return;
                }
                C0657e.m2522d("PushLogAC2712", "PushCommandProcessor device register fail:" + iVar.d());
                return;
            default:
                return;
        }
    }

    private void m2484b(Context context, String str) {
        C0657e.m2512a("PushLogAC2712", str + " will be unregister.");
        String str2 = "";
        Object d = com.huawei.android.pushagent.b.e.b.d(context, str);
        if (!TextUtils.isEmpty(d)) {
            try {
                C0646a.m2435e().a(new p(d));
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", "call ChannelMgr.getPushChannel().send cause:" + e.toString(), e);
            }
        }
    }

    private void m2485b(Context context, byte[] bArr, byte[] bArr2) {
        try {
            C0657e.m2517b("PushLogAC2712", "enter deposeMessageBySelf");
            if (bArr2 == null) {
                C0657e.m2522d("PushLogAC2712", "enter deposeMessageBySelf msg is null!");
                return;
            }
            String str = new String(bArr2, GameManager.DEFAULT_CHARSET);
            if (TextUtils.isEmpty(str)) {
                C0657e.m2522d("PushLogAC2712", "enter deposeMessageBySelf jsonStr is null!");
                return;
            }
            if (e.c()) {
                e.a(2, 180);
            } else {
                C0660a.m2549a(2, 180);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("app")) {
                    C0657e.m2512a("PushLogAC2712", "jsonStr has a mapping for app");
                    try {
                        int i = jSONObject.getInt("app");
                        if (1 == i) {
                            c.a(context, str);
                            return;
                        }
                        C0657e.m2517b("PushLogAC2712", "the app value is not 1! it is " + i);
                        C0657e.m2512a("PushLogAC2712", "send selfShow message");
                        m2493a(context, bArr, bArr2);
                    } catch (Throwable e) {
                        C0657e.m2521c("PushLogAC2712", e.toString(), e);
                    }
                } else {
                    C0657e.m2512a("PushLogAC2712", "jsonStr does not  have a mapping for app");
                    C0657e.m2512a("PushLogAC2712", "send selfShow message");
                    m2493a(context, bArr, bArr2);
                }
            } catch (JSONException e2) {
                C0657e.m2512a("PushLogAC2712", str + " depose failed, maybe old selfShow message");
            }
        } catch (Throwable e3) {
            C0657e.m2521c("PushLogAC2712", e3.toString(), e3);
        }
    }

    private boolean m2486b(String str) {
        boolean contains;
        synchronized (f1174b) {
            contains = f1173a.contains(str);
        }
        return contains;
    }

    private h m2487c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pushConfig", 0);
        int parseInt = Integer.parseInt(C0660a.m2583g(context));
        long j = sharedPreferences.getLong("cloudpush_off", 0);
        long j2 = sharedPreferences.getLong("cloudpush_on", 0);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        try {
            int i2;
            String string = sharedPreferences.getString("cloudpush_arrayOfNetEventTime", "");
            if (!TextUtils.isEmpty(string) || string.equals("null")) {
                i = string.split("\\,").length;
            }
            C0657e.m2512a("PushLogAC2712", "mDeviceTokenMgr.tokenMap.size:" + com.huawei.android.pushagent.b.e.b.a(context).a.size());
            if (com.huawei.android.pushagent.b.e.b.a(context).a.size() == 0) {
                i++;
            }
            if (i > 16) {
                i = 16;
            }
            C0657e.m2512a("PushLogAC2712", "netEventAccount is: " + i);
            g[] gVarArr = new g[i];
            if (!TextUtils.isEmpty(string) || string.equals("null")) {
                String[] split = string.split("\\,");
                for (i2 = 0; i2 < split.length; i2++) {
                    String[] split2 = split[i2].split("\\-");
                    gVarArr[i2] = new g();
                    gVarArr[i2].a((byte) Integer.parseInt(split2[0]));
                    gVarArr[i2].b((byte) Integer.parseInt(split2[1]));
                    gVarArr[i2].a(Long.parseLong(split2[2]));
                }
            }
            if (com.huawei.android.pushagent.b.e.b.a(context).a.size() == 0) {
                i2 = i - 1;
                C0657e.m2512a("PushLogAC2712", "syncPos is: " + i2);
                if (gVarArr[i2] == null) {
                    gVarArr[i2] = new g();
                }
                gVarArr[i2].a((byte) -1);
                gVarArr[i2].b((byte) 0);
                gVarArr[i2].a(System.currentTimeMillis());
            }
            return new h(str, (byte) b.a(context), parseInt, j, j2, currentTimeMillis, i, gVarArr);
        } catch (NumberFormatException e) {
            return new h(str, (byte) b.a(context), parseInt, j, j2, currentTimeMillis, 0, null);
        } catch (Exception e2) {
            return new h(str, (byte) b.a(context), parseInt, j, j2, currentTimeMillis, 0, null);
        }
    }

    private void m2488c(Context context, Intent intent) {
        C0656a.m2504a(context, new Intent("com.huawei.intent.action.PUSH_OFF").setPackage(context.getPackageName()).putExtra("Remote_Package_Name", context.getPackageName()));
        String stringExtra = intent.getStringExtra("pkg_name");
        C0657e.m2512a("PushLogAC2712", "PushCommandProcessor: get the packageName: " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            C0657e.m2522d("PushLogAC2712", "PushCommandProcessor: get the wrong package name from the Client!");
        } else if (C0662d.m2622a(context, stringExtra)) {
            C0659h c0659h = new C0659h(context, "pclient_unRegist_info_v2");
            for (Entry entry : c0659h.m2541b().entrySet()) {
                if (stringExtra.equals((String) entry.getValue())) {
                    C0657e.m2512a("PushLogAC2712", stringExtra + " need to register again");
                    c0659h.m2546f((String) entry.getKey());
                    break;
                }
            }
            if (com.huawei.android.pushagent.b.e.b.a(context, stringExtra)) {
                C0657e.m2512a("PushLogAC2712", "PushCommandProcessor: this package:" + stringExtra + " have already registered ");
                C0651d.m2479a(context, stringExtra, com.huawei.android.pushagent.b.e.b.d(context, stringExtra));
                return;
            }
            m2477a(context, stringExtra);
        } else {
            C0657e.m2522d("PushLogAC2712", "rec register toke request , but the packageName:" + stringExtra + " was not install !!");
        }
    }

    private void m2489d(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("pkg_name");
        if (TextUtils.isEmpty(stringExtra)) {
            C0657e.m2512a("PushLogAC2712", "packagename is null, cannot deregister");
            return;
        }
        C0657e.m2512a("PushLogAC2712", "responseClientUnRegistration: packagename = " + stringExtra);
        new C0659h(context, "pclient_request_info").m2546f(stringExtra);
        String stringExtra2 = intent.getStringExtra("device_token");
        if (intent.getBooleanExtra("isTokenEncrypt", false)) {
            stringExtra2 = f.b(context, stringExtra2);
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            C0657e.m2512a("PushLogAC2712", "token is null, cannot deregister");
            return;
        }
        String d = com.huawei.android.pushagent.b.e.b.d(context, stringExtra);
        if (stringExtra2.equals(d)) {
            if (e.c()) {
                e.b(stringExtra);
            }
            C0658f.m2530c(context, com.huawei.android.pushagent.b.e.b.d(context, stringExtra), stringExtra);
            m2484b(context, stringExtra);
            com.huawei.android.pushagent.b.e.b.b(context, stringExtra);
            return;
        }
        C0657e.m2517b("PushLogAC2712", "token not match, cannot deregister. token is " + C0655e.m2502a(stringExtra2) + ", local token is " + C0655e.m2502a(d));
    }

    private void m2490e(Context context, Intent intent) {
        String str = "";
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        C0657e.m2512a("PushLogAC2712", "responseAddPackage pkgName= " + str);
        if (!TextUtils.isEmpty(str)) {
            C0657e.m2512a("PushLogAC2712", "responseAddPackage,isRegistered:" + com.huawei.android.pushagent.b.e.b.a(context, str));
            if (!com.huawei.android.pushagent.b.e.b.a(context, str)) {
                return;
            }
            if (C0660a.m2575c(context, str)) {
                m2477a(context, str);
                return;
            }
            String d = com.huawei.android.pushagent.b.e.b.d(context, str);
            Intent intent2 = new Intent();
            intent2.putExtra("pkg_name", str);
            intent2.putExtra("device_token", d);
            m2489d(context, intent);
        }
    }

    private void m2491f(Context context, Intent intent) {
        String str = "";
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.DATA_REMOVED", true);
        C0657e.m2512a("PushLogAC2712", "ACTION_PACKAGE_REMOVED : isRemoveData=" + booleanExtra + " remove pkgName:" + str);
        if (booleanExtra) {
            C0657e.m2512a("PushLogAC2712", "responseRemovePackage pkgName= " + str);
            if (C0660a.m2575c(context, str)) {
                C0657e.m2512a("PushLogAC2712", "received pkgRemove action, but pkg:" + str + " is exist and have " + "com.huawei.android.push.intent.REGISTRATION" + ", register again");
                if (com.huawei.android.pushagent.b.e.b.a(context, str)) {
                    m2477a(context, str);
                    return;
                }
                return;
            }
            String d = com.huawei.android.pushagent.b.e.b.d(context, str);
            Intent intent2 = new Intent();
            intent2.putExtra("pkg_name", str);
            intent2.putExtra("device_token", d);
            m2489d(context, intent2);
        }
    }

    public void mo2116a(Context context, Intent intent) {
        C0657e.m2512a("PushLogAC2712", "enter PushCommandProcessor:onReceive(intent:" + intent + " context:" + context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pushConfig", 4);
            Editor edit = sharedPreferences.edit();
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    edit.putLong("cloudpush_net_on", System.currentTimeMillis()).commit();
                } else if (!networkInfo.isConnectedOrConnecting()) {
                    edit.putLong("cloudpush_net_off", System.currentTimeMillis()).commit();
                }
                C0651d.m2481a(sharedPreferences, networkInfo);
                return;
            }
            C0657e.m2512a("PushLogAC2712", "networkinfo is null");
        } else if ("com.huawei.android.push.intent.CONNECTED".equals(action)) {
            m2478a(context, "cloudpush_on", Boolean.valueOf(true));
            try {
                C0646a.m2435e().a(m2487c(context, C0660a.m2556a(context)));
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", "call ChannelMgr.getPushChannel().send cause:" + e.toString(), e);
            }
        } else if ("com.huawei.android.push.intent.CHANNEL_CLOSED".equals(action)) {
            m2478a(context, "cloudpush_off", Boolean.valueOf(false));
        } else if ("com.huawei.android.push.intent.MSG_RECEIVED".equals(action)) {
            m2483b(context, intent);
        } else if ("com.huawei.android.push.intent.REGISTER".equals(action)) {
            m2488c(context, intent);
        } else if ("com.huawei.android.push.intent.DEREGISTER".equals(action)) {
            m2489d(context, intent);
        } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            m2490e(context, intent);
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            m2491f(context, intent);
        } else if ("android.ctrlsocket.all.allowed".equals(action)) {
            this.f1175c = new String[0];
            C0657e.m2517b("PushLogAC2712", "all packages allow to use push, send cached messages to apps");
            for (a aVar : this.f1176d) {
                if (!(aVar.b() == null || aVar.c() == null)) {
                    m2480a(context, aVar.a(), aVar.b(), aVar.c());
                }
            }
            this.f1176d.clear();
            for (a aVar2 : this.f1177e) {
                if (!(aVar2.b() == null || aVar2.c() == null)) {
                    m2485b(context, aVar2.b(), aVar2.c());
                }
            }
            this.f1177e.clear();
        } else if (!"android.scroff.ctrlsocket.status".equals(action)) {
        } else {
            if (intent.getBooleanExtra("ctrl_socket_status", false)) {
                Object stringExtra = intent.getStringExtra("ctrl_socket_list");
                C0657e.m2517b("PushLogAC2712", "only whitepackages can use push:" + stringExtra);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f1175c = stringExtra.split("\t");
                    return;
                }
                return;
            }
            this.f1175c = new String[0];
            C0657e.m2512a("PushLogAC2712", "not support push in sleep model");
        }
    }

    public void m2493a(Context context, byte[] bArr, byte[] bArr2) {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr2, GameManager.DEFAULT_CHARSET));
            if (jSONObject.has("msgContent")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
                if (jSONObject2 != null && jSONObject2.has("dispPkgName")) {
                    str = jSONObject2.getString("dispPkgName");
                }
            }
            C0657e.m2512a("PushLogAC2712", "dispkgName is " + str);
            if (TextUtils.isEmpty(str)) {
                str = "com.huawei.android.pushagent";
            }
            Intent intent;
            if (context.getPackageName().equals(str.trim())) {
                C0657e.m2512a("PushLogAC2712", "need current package " + context.getPackageName() + " to depose selfshow msg");
                intent = new Intent("com.huawei.intent.action.PUSH");
                intent.putExtra("selfshow_info", bArr2);
                intent.putExtra("selfshow_token", bArr);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
            } else if (C0660a.m2559a(context, "com.huawei.android.push.intent.AD_INFO").contains(str)) {
                C0657e.m2512a("PushLogAC2712", "need old package " + str + " to depose selfshow msg");
                r1 = new Intent("com.huawei.android.push.intent.AD_INFO");
                r1.putExtra("ad_event_info", bArr2);
                r1.putExtra("ad_event_token", bArr);
                r1.setPackage(str);
                context.sendBroadcast(r1);
            } else if (C0660a.m2578d(context, str) || C0660a.m2575c(context, str)) {
                C0657e.m2512a("PushLogAC2712", "try to send selfshow msg to push client ,package " + str + " to depose selfshow msg");
                r1 = new Intent("com.huawei.intent.action.PUSH");
                r1.putExtra("selfshow_info", bArr2);
                r1.putExtra("selfshow_token", bArr);
                r1.setFlags(32);
                r1.setPackage(str);
                context.sendBroadcast(r1);
            } else {
                C0657e.m2512a("PushLogAC2712", "not find dispkgName " + str + " or is not pushclient");
                intent = new Intent("com.huawei.intent.action.PUSH");
                intent.putExtra("selfshow_info", bArr2);
                intent.putExtra("selfshow_token", bArr);
                intent.putExtra("selfshow_event_id", "5");
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
            }
        } catch (JSONException e) {
            C0657e.m2522d("PushLogAC2712", "deposeSelfShowMsg error:" + e.toString());
        } catch (IOException e2) {
            C0657e.m2522d("PushLogAC2712", "deposeSelfShowMsg error:" + e2.toString());
        } catch (Exception e3) {
            C0657e.m2522d("PushLogAC2712", "deposeSelfShowMsg error:" + e3.toString());
        }
    }
}
