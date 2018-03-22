package com.huawei.android.pushagent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0658f;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.android.pushagent.p018c.p019a.p026a.C0655e;
import com.huawei.android.pushagent.p018c.p027c.C0662d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

public abstract class PushReceiver extends BroadcastReceiver {

    class EventThread extends Thread {
        final /* synthetic */ PushReceiver f1138a;
        private Context f1139b;
        private Bundle f1140c;

        public EventThread(PushReceiver pushReceiver, Context context, Bundle bundle) {
            this.f1138a = pushReceiver;
            super("EventRunable");
            this.f1139b = context;
            this.f1140c = bundle;
        }

        public void run() {
            try {
                if (this.f1140c != null) {
                    int i = this.f1140c.getInt(PushReceiver$BOUND_KEY.receiveTypeKey);
                    if (i < 0 || i >= ReceiveType.values().length) {
                        C0657e.m2522d("PushLogAC2712", "invalid receiverType:" + i);
                        return;
                    }
                    switch (1.a[ReceiveType.values()[i].ordinal()]) {
                        case 1:
                            this.f1138a.onToken(this.f1139b, this.f1140c.getString("deviceToken"), this.f1140c);
                            return;
                        case 2:
                            this.f1138a.onPushMsg(this.f1139b, this.f1140c.getByteArray(PushReceiver$BOUND_KEY.pushMsgKey), this.f1140c);
                            return;
                        case 3:
                            this.f1138a.onPushState(this.f1139b, this.f1140c.getBoolean(PushReceiver$BOUND_KEY.pushStateKey));
                            return;
                        case 4:
                            this.f1138a.onEvent(this.f1139b, Event.NOTIFICATION_OPENED, this.f1140c);
                            return;
                        case 5:
                            this.f1138a.onEvent(this.f1139b, Event.NOTIFICATION_CLICK_BTN, this.f1140c);
                            return;
                        case 6:
                            this.f1138a.onEvent(this.f1139b, Event.PLUGINRSP, this.f1140c);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", "call EventThread(ReceiveType cause:" + e.toString(), e);
            }
        }
    }

    class HandlePushTokenThread extends Thread {
        Context f1141a;
        String f1142b;

        public HandlePushTokenThread(Context context, String str) {
            this.f1141a = context;
            this.f1142b = str;
        }

        public void run() {
            C0659h c0659h = new C0659h(this.f1141a, "push_client_self_info");
            c0659h.m2534a("hasRequestToken", false);
            c0659h.m2546f("token_info");
            C0658f.m2527a(this.f1141a, "push_client_self_info", "token_info", this.f1142b);
        }
    }

    enum ReceiveType {
        ReceiveType_Init,
        ReceiveType_Token,
        ReceiveType_Msg,
        ReceiveType_PushState,
        ReceiveType_NotifyClick,
        ReceiveType_PluginRsp,
        ReceiveType_ClickBtn
    }

    private static int m2345a() {
        int intValue;
        try {
            Class cls = Class.forName("android.os.UserHandle");
            intValue = ((Integer) cls.getDeclaredMethod("myUserId", new Class[0]).invoke(cls, new Object[0])).intValue();
            try {
                C0657e.m2512a("PushLogAC2712", "getUserId:" + intValue);
            } catch (ClassNotFoundException e) {
                C0657e.m2512a("PushLogAC2712", " getUserId wrong");
                return intValue;
            } catch (NoSuchMethodException e2) {
                C0657e.m2512a("PushLogAC2712", " getUserId wrong");
                return intValue;
            } catch (IllegalAccessException e3) {
                C0657e.m2512a("PushLogAC2712", " getUserId wrong");
                return intValue;
            } catch (IllegalArgumentException e4) {
                C0657e.m2512a("PushLogAC2712", " getUserId wrong");
                return intValue;
            } catch (InvocationTargetException e5) {
                C0657e.m2512a("PushLogAC2712", " getUserId wrong");
                return intValue;
            }
        } catch (ClassNotFoundException e6) {
            intValue = HwAccountConstants.NO_SUBID;
            C0657e.m2512a("PushLogAC2712", " getUserId wrong");
            return intValue;
        } catch (NoSuchMethodException e7) {
            intValue = HwAccountConstants.NO_SUBID;
            C0657e.m2512a("PushLogAC2712", " getUserId wrong");
            return intValue;
        } catch (IllegalAccessException e8) {
            intValue = HwAccountConstants.NO_SUBID;
            C0657e.m2512a("PushLogAC2712", " getUserId wrong");
            return intValue;
        } catch (IllegalArgumentException e9) {
            intValue = HwAccountConstants.NO_SUBID;
            C0657e.m2512a("PushLogAC2712", " getUserId wrong");
            return intValue;
        } catch (InvocationTargetException e10) {
            intValue = HwAccountConstants.NO_SUBID;
            C0657e.m2512a("PushLogAC2712", " getUserId wrong");
            return intValue;
        }
        return intValue;
    }

    private void m2346b(Context context, Intent intent) throws UnsupportedEncodingException {
        m2351g(context, intent);
        boolean a = new C0659h(context, "push_switch").m2537a("normal_msg_enable");
        C0657e.m2512a("PushLogAC2712", "closePush_Normal:" + a);
        if (a) {
            C0657e.m2517b("PushLogAC2712", "close switch is true, message not dispatch");
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("msg_data");
        String str = new String(intent.getByteArrayExtra("device_token"), GameManager.DEFAULT_CHARSET);
        C0657e.m2512a("PushLogAC2712", "PushReceiver receive a message success");
        Bundle bundle = new Bundle();
        bundle.putString("deviceToken", str);
        bundle.putByteArray(PushReceiver$BOUND_KEY.pushMsgKey, byteArrayExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_Msg.ordinal());
        new EventThread(this, context, bundle).start();
    }

    private void m2347c(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("click");
        Bundle bundle = new Bundle();
        bundle.putString(PushReceiver$BOUND_KEY.pushMsgKey, stringExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_NotifyClick.ordinal());
        new EventThread(this, context, bundle).start();
    }

    private void m2348d(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("clickBtn");
        int intExtra = intent.getIntExtra("notifyId", 0);
        Bundle bundle = new Bundle();
        bundle.putString(PushReceiver$BOUND_KEY.pushMsgKey, stringExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.pushNotifyId, intExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_ClickBtn.ordinal());
        new EventThread(this, context, bundle).start();
    }

    private void m2349e(Context context, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("push_state", false);
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushReceiver$BOUND_KEY.pushStateKey, booleanExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_PushState.ordinal());
        new EventThread(this, context, bundle).start();
    }

    private void m2350f(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(PushReceiver$BOUND_KEY.PLUGINREPORTTYPE, -1);
        boolean booleanExtra = intent.getBooleanExtra(PushReceiver$BOUND_KEY.PLUGINREPORTRESULT, false);
        Bundle bundleExtra = intent.getBundleExtra("reportExtra");
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushReceiver$BOUND_KEY.PLUGINREPORTRESULT, booleanExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.PLUGINREPORTTYPE, intExtra);
        bundle.putBundle("reportExtra", bundleExtra);
        bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_PluginRsp.ordinal());
        new EventThread(this, context, bundle).start();
    }

    private void m2351g(Context context, Intent intent) {
        if (context != null && intent != null) {
            Object stringExtra = intent.getStringExtra("msgIdStr");
            if (!TextUtils.isEmpty(stringExtra) && C0660a.m2592o(context)) {
                Intent intent2 = new Intent("com.huawei.android.push.intent.MSG_RESPONSE");
                intent2.putExtra("msgIdStr", stringExtra);
                intent2.setPackage("android");
                intent2.setFlags(32);
                C0657e.m2512a("PushLogAC2712", "send msg response broadcast to frameworkPush");
                context.sendBroadcast(intent2);
            }
        }
    }

    public static void getPushState(Context context) {
        C0657e.m2512a("PushLogAC2712", "enter PushEntity:getPushState() pkgName" + context.getPackageName());
        if (TextUtils.isEmpty(C0660a.m2595r(context))) {
            if (C0660a.m2592o(context)) {
                C0657e.m2512a("PushLogAC2712", "votedPackage is null, getPushState from frameworkPush");
                String str = "android";
            } else {
                C0657e.m2512a("PushLogAC2712", "votedPackage is null and not exist frameworkPush, can not getPushState");
                return;
            }
        }
        Intent intent = new Intent("com.huawei.android.push.intent.GET_PUSH_STATE");
        intent.putExtra("pkg_name", context.getPackageName());
        intent.setFlags(32);
        C0662d.m2619a(context, intent);
    }

    public static final void getToken(Context context) {
        C0657e.m2512a("PushLogAC2712", "enter PushEntity:getToken() pkgName" + context.getPackageName());
        new C0659h(context, "push_client_self_info").m2534a("hasRequestToken", true);
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra("pkg_name", context.getPackageName());
        int a = m2345a();
        if (HwAccountConstants.NO_SUBID != a) {
            intent.putExtra("userid", String.valueOf(a));
        }
        intent.setFlags(32);
        C0662d.m2619a(context, intent);
    }

    protected void m2352a(Context context, Intent intent) throws UnsupportedEncodingException {
        String str = new String(intent.getByteArrayExtra("device_token"), GameManager.DEFAULT_CHARSET);
        C0657e.m2512a("PushLogAC2712", "get a deviceToken:" + C0655e.m2502a(str));
        if (TextUtils.isEmpty(str)) {
            C0657e.m2520c("PushLogAC2712", "get a deviceToken, but it is null");
            return;
        }
        boolean a = new C0659h(context, "push_client_self_info").m2537a("hasRequestToken");
        String a2 = C0658f.m2526a(context, "push_client_self_info", "token_info");
        C0657e.m2512a("PushLogAC2712", "my oldtoken is :" + C0655e.m2502a(a2));
        if (a || !str.equals(a2)) {
            C0657e.m2517b("PushLogAC2712", "push client begin to receive the token");
            new HandlePushTokenThread(context, str).start();
            Bundle bundle = new Bundle();
            bundle.putString("deviceToken", str);
            bundle.putByteArray(PushReceiver$BOUND_KEY.pushMsgKey, null);
            bundle.putInt(PushReceiver$BOUND_KEY.receiveTypeKey, ReceiveType.ReceiveType_Token.ordinal());
            if (intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            new EventThread(this, context, bundle).start();
            return;
        }
        C0657e.m2520c("PushLogAC2712", "get a deviceToken, but do not requested token, and new token is equals old token");
    }

    public void onEvent(Context context, Event event, Bundle bundle) {
    }

    public void onPushMsg(Context context, byte[] bArr, String str) {
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        String str = "";
        if (bundle != null) {
            str = bundle.getString("deviceToken");
        }
        onPushMsg(context, bArr, str);
        return true;
    }

    public void onPushState(Context context, boolean z) {
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            C0657e.m2512a("PushLogAC2712", "enter PushMsgReceiver:onReceive(Intent:" + intent.getAction() + " pkgName:" + context.getPackageName() + ")");
            String action = intent.getAction();
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action) && intent.hasExtra("device_token")) {
                m2352a(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action) && intent.hasExtra("msg_data")) {
                m2346b(context, intent);
            } else if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra("click")) {
                m2347c(context, intent);
            } else if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra("clickBtn")) {
                m2348d(context, intent);
            } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                m2349e(context, intent);
            } else if ("com.huawei.android.push.plugin.RESPONSE".equals(action)) {
                m2350f(context, intent);
            } else {
                C0657e.m2517b("PushLogAC2712", "message can't be recognised:" + intent.toUri(0));
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogAC2712", "call onReceive(intent:" + intent + ") cause:" + e.toString(), e);
        }
    }

    public void onToken(Context context, String str) {
    }

    public void onToken(Context context, String str, Bundle bundle) {
        onToken(context, str);
    }
}
