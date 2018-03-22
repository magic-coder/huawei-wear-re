package com.huawei.hwid.core.p435d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: UIUtil */
public class C5183n {
    public static final boolean f18660a = (VERSION.SDK_INT >= 11);

    public static void m25067a(Context context, String str, int i) {
        if (C5166b.m24952g()) {
            Toast.makeText(context, str, i).show();
            return;
        }
        int b = C5183n.m25068b(context);
        if (b != 0) {
            context.setTheme(b);
        }
        Toast.makeText(context, str, i).show();
    }

    public static int m25066a(Context context) {
        if (context == null) {
            C5165e.m24906b("UIUtil", "getDialogThemeId, context is null");
            return 3;
        }
        int b = C5183n.m25068b(context);
        if (VERSION.SDK_INT < 16 || b == 0) {
            return 3;
        }
        return 0;
    }

    public static int m25068b(Context context) {
        if (C5173d.m24992a()) {
            return context.getResources().getIdentifier("androidhwext:style/Theme.Emui.Dark", null, null);
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public static void m25069c(Context context) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                context.startActivity(intent);
            } catch (Exception e) {
                C5165e.m24910d("UIUtil", e.getMessage());
            }
        }
    }
}
