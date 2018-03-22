package com.huawei.hwcloudmodel.mgr;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.gson.Gson;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.hwcloudmodel.callback.C0971c;
import com.huawei.hwcloudmodel.callback.IPushBase;
import com.huawei.hwcloudmodel.model.push.PushBeanBase;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushReceiver;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HwWearPushReceiver extends PushReceiver {
    private static Gson f1628a = new Gson();
    private static HashMap<String, String> f1629b = new HashMap();
    private static List<String> f1630c = new ArrayList();
    private static DynamicPushReceiver f1631d = new DynamicPushReceiver();
    private static boolean f1632e = false;

    static {
        f1629b.put("", "com.huawei.pluginkidwatch.home.push.KonePush");
        f1629b.put("0", "com.huawei.pluginkidwatch.home.push.KonePush");
        f1629b.put("1", "com.huawei.pluginkidwatch.home.push.KonePush");
        f1629b.put("2", "com.huawei.pluginmessagecenter.service.MessagePushReceiver");
        f1629b.put("3", "com.huawei.hihealthservice.sync.util.HiSyncMsgReceiver");
        f1629b.put("5", "com.huawei.ui.main.stories.messagecenter.interactors.AccountMigratePushReceiver");
        f1630c.add("personizedPush");
        f1630c.add("UnionPayPush");
        f1630c.add("reportloss");
        f1630c.add("consume");
        f1630c.add("clearese");
        f1630c.add("delaccount");
    }

    public void onPushMsg(Context context, byte[] bArr, String str) {
        String str2;
        PushBeanBase pushBeanBase;
        UnsupportedEncodingException e;
        Class cls;
        if (context != null) {
            String str3 = "";
            PushBeanBase pushBeanBase2 = new PushBeanBase();
            try {
                str2 = new String(bArr, GameManager.DEFAULT_CHARSET);
                try {
                    C2538c.m12674b("HwWearPushReceiver", "onPushMsg receive a new message" + str2);
                    if ("messagecenter".equals(str2)) {
                        pushBeanBase2.pushType = "2";
                        pushBeanBase = pushBeanBase2;
                    } else if (m3495a(str2).booleanValue()) {
                        m3498a(context, bArr, str);
                        return;
                    } else {
                        pushBeanBase = (PushBeanBase) f1628a.fromJson(str2, PushBeanBase.class);
                    }
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    C2538c.m12674b("HwWearPushReceiver", "UnsupportedEncodingException ERROR!!!" + e.getMessage());
                    pushBeanBase = pushBeanBase2;
                    if (pushBeanBase == null) {
                        try {
                            C2538c.m12674b("HwWearPushReceiver", "bean.pushType:", pushBeanBase.pushType + "");
                            cls = Class.forName((String) f1629b.get(pushBeanBase.pushType));
                            cls.getMethod(IPushBase.class.getMethods()[0].getName(), new Class[]{Context.class, String.class}).invoke(cls.newInstance(), new Object[]{context, str2});
                        } catch (ClassNotFoundException e3) {
                            C2538c.m12680e("HwWearPushReceiver", "processData error catch ClassNotFoundException" + e3.getMessage());
                            return;
                        } catch (NoSuchMethodException e4) {
                            C2538c.m12680e("HwWearPushReceiver", "processData error catch NoSuchMethodException" + e4.getMessage());
                            return;
                        } catch (IllegalAccessException e5) {
                            C2538c.m12680e("HwWearPushReceiver", "processData error catch IllegalAccessException" + e5.getMessage());
                            return;
                        } catch (InvocationTargetException e6) {
                            C2538c.m12680e("HwWearPushReceiver", "processData error catch InvocationTargetException" + e6.getMessage());
                            return;
                        } catch (InstantiationException e7) {
                            C2538c.m12680e("HwWearPushReceiver", "processData error catch InstantiationException" + e7.getMessage());
                            return;
                        }
                    }
                }
            } catch (UnsupportedEncodingException e8) {
                e = e8;
                str2 = str3;
                C2538c.m12674b("HwWearPushReceiver", "UnsupportedEncodingException ERROR!!!" + e.getMessage());
                pushBeanBase = pushBeanBase2;
                if (pushBeanBase == null) {
                    C2538c.m12674b("HwWearPushReceiver", "bean.pushType:", pushBeanBase.pushType + "");
                    cls = Class.forName((String) f1629b.get(pushBeanBase.pushType));
                    cls.getMethod(IPushBase.class.getMethods()[0].getName(), new Class[]{Context.class, String.class}).invoke(cls.newInstance(), new Object[]{context, str2});
                }
            }
            if (pushBeanBase == null) {
                C2538c.m12674b("HwWearPushReceiver", "bean.pushType:", pushBeanBase.pushType + "");
                cls = Class.forName((String) f1629b.get(pushBeanBase.pushType));
                cls.getMethod(IPushBase.class.getMethods()[0].getName(), new Class[]{Context.class, String.class}).invoke(cls.newInstance(), new Object[]{context, str2});
            }
        }
    }

    public void onPushState(Context context, boolean z) {
        super.onPushState(context, z);
        C2538c.m12674b("HwWearPushReceiver", "===pushstate:" + z);
    }

    public static void m3497a(Context context, String str, C0971c c0971c) {
        if (C0969i.m3482a(41) && !C0970w.m3489b()) {
            PushReceiver.getToken(context);
            DynamicPushReceiver.m3494a(str, c0971c);
            C2538c.m12680e("HwWearPushReceiver", "getPushToken isRegistered:" + f1632e);
            if (!f1632e) {
                f1632e = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
                intentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
                context.getApplicationContext().registerReceiver(f1631d, intentFilter);
            }
        }
    }

    public static void m3496a(Context context) {
        if (context == null) {
            C2538c.m12680e("HwWearPushReceiver", "unRegisterDynamicPushReceiver is null ,return");
        } else if (C0969i.m3482a(41) && !C0970w.m3489b()) {
            C2538c.m12674b("HwWearPushReceiver", "unRegisterDynamicPushReceiver current isRegistered:" + f1632e);
            if (f1632e) {
                f1632e = false;
                try {
                    context.getApplicationContext().unregisterReceiver(f1631d);
                } catch (Exception e) {
                    C2538c.m12680e("HwWearPushReceiver", "unRegisterDynamicPushReceiver error:" + e.getMessage());
                }
            }
        }
    }

    private Boolean m3495a(String str) {
        C2538c.m12674b("HwWearPushReceiver", "== wallet push responseStr : " + str);
        if (str == null) {
            return Boolean.valueOf(false);
        }
        try {
            String string = new JSONObject(str).getString("msg");
            C2538c.m12674b("HwWearPushReceiver", "== wallet push walletPushMsg : " + string);
            if (string == null || string.equals("")) {
                return Boolean.valueOf(false);
            }
            if (f1630c.contains(string)) {
                return Boolean.valueOf(true);
            }
            return Boolean.valueOf(false);
        } catch (JSONException e) {
            C2538c.m12674b("HwWearPushReceiver", "== wallet push JSONException e :" + e.getMessage());
            return Boolean.valueOf(false);
        }
    }

    private void m3498a(Context context, byte[] bArr, String str) {
        C2538c.m12677c("HwWearPushReceiver", "== wallet push onPushMsg");
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(NFCPushReceiver.ACTION_RECEIVE_PUSH_MSG);
        intent.putExtra(NFCPushReceiver.EXTRA_PUSH_MSG, bArr);
        intent.putExtra(NFCPushReceiver.EXTRA_PUSH_TOKEN, str);
        context.sendBroadcast(intent, C0976c.f1642a);
    }
}
