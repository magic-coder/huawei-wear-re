package com.huawei.hwid.update.p452c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwid.activity.BridgeActivity;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5209d;
import com.huawei.hwid.p075d.C5211f;
import com.huawei.hwid.update.p453d.C5291f;
import com.huawei.hwid.update.p453d.C5304i;
import com.huawei.hwid.update.p453d.C5305j;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: UpdateManager */
public class C5276a {
    public static void m25548a(Context context, int i) {
        if (C5211f.m25346a()) {
            if (C5276a.m25549a(context)) {
                C5165e.m24906b("UpdateManager", "startBridgeActivitySilentOta");
                C5276a.m25550b(context, i);
                return;
            }
            C5165e.m24906b("UpdateManager", "startBridgeActivityOta");
            C5276a.m25551c(context, i);
        } else if (C5276a.m25549a(context)) {
            C5165e.m24906b("UpdateManager", "startBridgeActivitySilentGoogle");
            C5276a.m25552d(context, i);
        } else {
            C5165e.m24906b("UpdateManager", "startBridgeActivityGoogle");
            C5276a.m25553e(context, i);
        }
    }

    private static void m25550b(Context context, int i) {
        if (context == null) {
            C5165e.m24910d("UpdateManager", "context is null.");
            return;
        }
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C5304i.class.getName());
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME, C5305j.class.getName());
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            C5165e.m24906b("UpdateManager", "Silent not start from Activity");
            context.startActivity(intent);
        } catch (Exception e) {
            C5165e.m24910d("UpdateManager", "Silent can not start activity:" + e.getMessage());
        }
    }

    private static void m25551c(Context context, int i) {
        if (context == null) {
            C5165e.m24910d("UpdateManager", "context is null.");
            return;
        }
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C5305j.class.getName());
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            C5165e.m24906b("UpdateManager", "ota not start from Activity");
            context.startActivity(intent);
        } catch (Exception e) {
            C5165e.m24910d("UpdateManager", "ota can not start activity:" + e.getMessage());
        }
    }

    private static void m25552d(Context context, int i) {
        if (context == null) {
            C5165e.m24910d("UpdateManager", "context is null.");
            return;
        }
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C5304i.class.getName());
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME, C5291f.class.getName());
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            C5165e.m24906b("UpdateManager", "SilentGoogle not start from Activity");
            context.startActivity(intent);
        } catch (Exception e) {
            C5165e.m24910d("UpdateManager", "Silent can not start activity:" + e.getMessage());
        }
    }

    private static void m25553e(Context context, int i) {
        if (context == null) {
            C5165e.m24910d("UpdateManager", "context is null.");
            return;
        }
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, C5291f.class.getName());
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            C5165e.m24906b("UpdateManager", "Google not start from Activity");
            context.startActivity(intent);
        } catch (Exception e) {
            C5165e.m24910d("UpdateManager", "ota can not start activity:" + e.getMessage());
        }
    }

    private static boolean m25549a(Context context) {
        if (((long) new C5209d(context).m25339b("com.huawei.appmarket")) >= 70203000) {
            return true;
        }
        return false;
    }
}
