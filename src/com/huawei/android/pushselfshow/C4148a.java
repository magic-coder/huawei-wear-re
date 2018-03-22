package com.huawei.android.pushselfshow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p336a.C4147a;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.p338c.C4153b;
import com.huawei.android.pushselfshow.p338c.C4156e;
import com.huawei.android.pushselfshow.permission.RequestPermissionsActivity;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.p346b.C4205b;
import java.io.File;
import org.json.JSONArray;

public class C4148a {
    public void m20255a(Context context, Intent intent) {
        int i = 0;
        if (context == null || intent == null) {
            try {
                e.a("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
                return;
            } catch (Throwable e) {
                e.a("PushSelfShowLog", e.toString(), e);
                return;
            }
        }
        e.a(context);
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            Uri data = intent.getData();
            if (data != null) {
                Object schemeSpecificPart = data.getSchemeSpecificPart();
                e.e("PushSelfShowLog", "receive package add ,the pkgName is " + schemeSpecificPart);
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    new C4151b(context, schemeSpecificPart).start();
                }
            }
        } else if (!"com.huawei.intent.action.PUSH".equals(action)) {
        } else {
            if (RequestPermissionsActivity.m20291a(context)) {
                e.b("PushSelfShowLog", "needStartPermissionActivity");
                RequestPermissionsActivity.m20290a(context, intent);
                return;
            }
            String str = null;
            if (intent.hasExtra("selfshow_info")) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                if (intent.hasExtra("selfshow_token")) {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                    if (intent.hasExtra("selfshow_event_id")) {
                        str = intent.getStringExtra("selfshow_event_id");
                    }
                    if (intent.hasExtra("selfshow_notify_id")) {
                        i = intent.getIntExtra("selfshow_notify_id", 0);
                        e.b("PushSelfShowLog", "get notifyId:" + i);
                    }
                    C4149a c4149a = new C4149a(byteArrayExtra, byteArrayExtra2);
                    if (c4149a.m20261b()) {
                        e.a("PushSelfShowLog", " onReceive the msg id = " + c4149a.f15590l + ",and cmd is" + c4149a.f15593o + ",and the eventId is " + str);
                        if (str == null) {
                            m20256a(context, intent, c4149a);
                        } else {
                            m20257a(context, intent, str, c4149a, i);
                        }
                        C4203a.m20430b(new File(C4205b.m20446a(context)));
                        return;
                    }
                    e.a("PushSelfShowLog", "parseMessage failed");
                }
            }
        }
    }

    public void m20256a(Context context, Intent intent, C4149a c4149a) {
        e.a("PushSelfShowLog", "receive a selfshow message ,the type is" + c4149a.f15593o);
        if (C4147a.m20247a(c4149a.f15593o)) {
            long b = C4203a.m20427b(c4149a.f15589k);
            if (b == 0) {
                new C4156e(context, c4149a).start();
                return;
            }
            e.a("PushSelfShowLog", "waiting ……");
            intent.setPackage(context.getPackageName());
            C4203a.m20423a(context, intent, b);
            return;
        }
        C4203a.m20424a(context, "3", c4149a);
    }

    public void m20257a(Context context, Intent intent, String str, C4149a c4149a, int i) {
        e.a("PushSelfShowLog", "receive a selfshow userhandle message");
        if ("-1".equals(str)) {
            C4153b.m20267a(context, i);
        } else {
            C4153b.m20268a(context, intent);
        }
        if ("1".equals(str)) {
            new C4147a(context, c4149a).m20254a();
            if (c4149a.f15592n != null) {
                try {
                    JSONArray jSONArray = new JSONArray(c4149a.f15592n);
                    Intent intent2 = new Intent("com.huawei.android.push.intent.CLICK");
                    intent2.putExtra("click", jSONArray.toString()).setPackage(context.getPackageName()).setFlags(32);
                    context.sendBroadcast(intent2);
                } catch (Exception e) {
                    e.d("PushSelfShowLog", "message.extras is not a json format,err info " + e.toString());
                }
            }
        }
        C4203a.m20424a(context, str, c4149a);
    }
}
