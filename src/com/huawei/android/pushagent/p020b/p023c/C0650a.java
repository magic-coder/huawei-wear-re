package com.huawei.android.pushagent.p020b.p023c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.c;
import com.huawei.android.pushagent.b.d.a;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0656a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.C0647a;
import com.huawei.android.pushagent.p020b.p021a.C0646a;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.android.pushagent.p020b.p022b.C0649c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.Serializable;
import java.util.List;

public class C0650a extends C0647a {
    int f1172a = -1;

    public C0650a(Context context) {
        try {
            this.f1172a = b.a(context);
            if (com.huawei.android.pushagent.b.e.b.b(context).size() != 0) {
                mo2116a(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV").setPackage(context.getPackageName()));
            } else {
                mo2116a(context, new Intent("com.huawei.action.CONNECT_PUSHSRV").setPackage(context.getPackageName()));
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", "call switchChannel cause Exception", e);
        }
    }

    private void m2469a(Context context, String str) {
        try {
            boolean a = C0649c.m2461a(context, "cloudpush_isNoDelayConnect", false);
            List b = com.huawei.android.pushagent.b.e.b.b(context);
            if (!a && b.size() == 0 && com.huawei.android.pushagent.b.e.b.a(context).a.size() == 0) {
                C0646a.m2431a(context).m2443b();
                C0657e.m2517b("PushLogAC2712", "no push client, stop push apk service");
                C0656a.m2507b(context, new Intent("com.huawei.intent.action.PUSH_OFF").setPackage(context.getPackageName()).putExtra("Remote_Package_Name", context.getPackageName()), C0648a.m2447a(context).m2388P() * 1000);
                return;
            }
            if (!C0648a.m2447a(context).m2394V()) {
                C0657e.m2517b("PushLogAC2712", "TRS is invalid, so need to query TRS");
                C0648a.m2447a(context).m2454c(false);
            }
            if ("com.huawei.android.push.intent.TRS_QUERY_SUCCESS".equals(str)) {
                C0646a.m2436f().e.f();
                C0646a.m2435e().e.f();
                a.c(context);
            }
            int a2 = b.a(context);
            if (-1 == a2 || a2 != this.f1172a) {
                if (-1 == a2) {
                    if (C0649c.m2461a(context, "cloudpush_isSupportCollectSocketInfo", false) && !C0646a.m2435e().a()) {
                        context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "no network.").setPackage(context.getPackageName()));
                    }
                    C0657e.m2512a("PushLogAC2712", "no network in ConnectMgrProcessor:connect, so close socket");
                } else {
                    if (C0649c.m2461a(context, "cloudpush_isSupportCollectSocketInfo", false) && !C0646a.m2435e().a()) {
                        context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "network switch.").setPackage(context.getPackageName()));
                    }
                    C0657e.m2512a("PushLogAC2712", "net work switch from:" + this.f1172a + " to " + a2);
                }
                try {
                    C0646a.m2431a(context).m2443b();
                } catch (Throwable e) {
                    C0657e.m2521c("PushLogAC2712", "call channel.close cause exceptino:" + e.toString(), e);
                } catch (c e2) {
                    C0657e.m2522d("PushLogAC2712", "call connectSrv cause Exceptino:" + e2.toString());
                }
            }
            Object obj = this.f1172a != a2 ? 1 : null;
            C0657e.m2517b("PushLogAC2712", "lastnetWorkType:" + this.f1172a + HwAccountConstants.BLANK + "curNetWorkType:" + a2);
            this.f1172a = a2;
            if (a) {
                C0646a.m2431a(context).m2441a(C0646a.a.a);
                C0646a.m2435e().a(true);
            } else if (("android.net.conn.CONNECTIVITY_CHANGE".equals(str) || "com.huawei.android.push.intent.TRS_QUERY_SUCCESS".equals(str)) && !C0646a.m2435e().a() && C0646a.m2433c() != C0646a.a.a && b.size() != 0) {
                C0657e.m2517b("PushLogAC2712", "received " + str + ", cur ConType:" + C0646a.m2433c() + ", but have need depose size:" + b.size());
                mo2116a(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV"));
            } else if ("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV".equals(str)) {
                C0657e.m2512a("PushLogAC2712", "get " + str + " so get a pushSrv to connect");
                if (b.size() != 0) {
                    C0646a.m2431a(context).m2441a(C0646a.a.a);
                }
                C0646a.m2435e().a(true);
            } else if ("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV".equals(str)) {
                C0657e.m2512a("PushLogAC2712", "get " + str + " so get a pollingSrv to connect");
                C0646a.m2436f().a(true);
            } else if (C0646a.m2431a(context).m2444d().a()) {
                C0657e.m2512a("PushLogAC2712", "pushChannel already connect, so needn't handle, nextSendHearBeatTime:" + C0660a.m2555a(C0646a.m2432b(context).e(), "yyyy-MM-dd HH:mm:ss SSS"));
            } else {
                C0657e.m2512a("PushLogAC2712", "get " + str + " so get a srv to connect");
                if (obj != null) {
                    com.huawei.android.pushagent.b.d.b.a(context).a(context, com.huawei.android.pushagent.b.d.b.b.d, new Bundle());
                }
                C0646a.m2431a(context).m2444d().a(false);
            }
        } catch (c e22) {
            C0657e.m2522d("PushLogAC2712", "call connectSrv cause Exceptino:" + e22.toString());
        } catch (Exception e3) {
            C0657e.m2522d("PushLogAC2712", "call connectSrv cause Exceptino:" + e3.toString());
        }
    }

    private boolean m2470a(Context context, Intent intent, String str, String str2) {
        return ("com.huawei.intent.action.PUSH".equals(str) && "com.huawei.android.push.intent.HEARTBEAT_REQ".equals(str2)) || "com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL".equals(str) || "android.intent.action.TIME_SET".equals(str) || "android.intent.action.TIMEZONE_CHANGED".equals(str);
    }

    private boolean m2471a(Context context, String str, String str2) {
        return "android.net.conn.CONNECTIVITY_CHANGE".equals(str) || "com.huawei.action.CONNECT_PUSHSRV".equals(str) || "com.huawei.action.CONNECT_PUSHSRV_PUSHSRV".equals(str) || "com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV".equals(str) || "com.huawei.android.push.intent.TRS_QUERY_SUCCESS".equals(str) || ("com.huawei.intent.action.PUSH".equals(str) && "com.huawei.intent.action.PUSH_ON".equals(str2));
    }

    public void mo2116a(Context context, Intent intent) {
        try {
            C0657e.m2512a("PushLogAC2712", "enter ConnectMgrProcessor:onReceive(intent:" + intent + " context:" + context);
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("EXTRA_INTENT_TYPE");
            if ("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT".equals(action)) {
                if (C0649c.m2461a(context, "cloudpush_isSupportCollectSocketInfo", false)) {
                    context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "heart beat time out.").setPackage(context.getPackageName()));
                }
                C0646a.m2431a(context).m2440a(intent);
            } else if (m2470a(context, intent, action, stringExtra)) {
                C0646a.m2431a(context).m2440a(intent);
            } else if (m2471a(context, action, stringExtra)) {
                m2469a(context, action);
            } else if ("com.huawei.android.push.intent.CHANNEL_CLOSED".equals(action)) {
                C0657e.m2517b("PushLogAC2712", "receive the channal closed action.");
                stringExtra = "";
                action = "";
                Serializable serializableExtra = intent.getSerializableExtra("push_exception");
                if (serializableExtra != null) {
                    action = serializableExtra.toString();
                }
                context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 0).putExtra("socket_next_connect_time", stringExtra).putExtra("socket_exception", action).setPackage(context.getPackageName()));
            } else if ("com.huawei.android.push.intent.CONNECTING".equals(action)) {
                context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 2).setPackage(context.getPackageName()));
            } else if ("com.huawei.android.push.intent.CONNECTED".equals(action)) {
                context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 1).setPackage(context.getPackageName()));
            } else if ("com.huawei.intent.action.PUSH_OFF".equals(action) || "com.huawei.android.push.intent.inner.STOP_SERVICE".equals(action)) {
                stringExtra = intent.getStringExtra("Remote_Package_Name");
                if (stringExtra == null || !stringExtra.equals(context.getPackageName())) {
                    C0657e.m2512a("PushLogAC2712", "need stop PkgName:" + stringExtra + " is not me, need not stop!");
                    return;
                }
                if (C0649c.m2461a(context, "cloudpush_isSupportCollectSocketInfo", false)) {
                    context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "receive push off action.").setPackage(context.getPackageName()));
                }
                C0646a.m2431a(context).m2443b();
                if ("com.huawei.intent.action.PUSH_OFF".equals(action)) {
                    PushService.m2359b();
                }
            } else if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("status", 1);
                C0646a.m2432b(context).a(intExtra);
                if (2 == intExtra || 5 == intExtra) {
                    C0657e.m2512a("PushLogAC2712", "current battery is charging!");
                } else {
                    C0657e.m2512a("PushLogAC2712", "current battery no charging :" + intExtra);
                }
            }
        } catch (Throwable e) {
            C0657e.m2513a("PushLogAC2712", e.toString(), e);
        }
    }
}
