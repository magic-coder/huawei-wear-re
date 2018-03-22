package com.huawei.android.pushselfshow.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.C4148a;
import com.huawei.android.pushselfshow.utils.C4203a;
import java.util.ArrayList;
import java.util.Arrays;

public class RequestPermissionsActivity extends Activity {
    private static final String[] f15622a = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private Intent f15623b = null;
    private String[] f15624c = new String[0];

    public static void m20290a(Context context, Intent intent) {
        e.b("PushSelfShowLog", "enter startPermissionActivity");
        if (context != null) {
            Intent intent2 = new Intent(context.getApplicationContext(), RequestPermissionsActivity.class);
            intent2.addFlags(276824064);
            if (intent != null) {
                intent2.putExtra("previous_intent", intent);
            }
            try {
                context.startActivity(intent2);
            } catch (Throwable e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
        }
    }

    public static boolean m20291a(Context context) {
        return VERSION.SDK_INT >= 23 && !m20292a(context, f15622a);
    }

    protected static boolean m20292a(Context context, String[] strArr) {
        if (context == null || strArr == null || strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (context.checkSelfPermission(str) != 0) {
                e.a("PushSelfShowLog", str + " need request");
                return false;
            }
        }
        return true;
    }

    private boolean m20293a(String str) {
        return Arrays.asList(m20298a()).contains(str);
    }

    private boolean m20294a(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            if (checkSelfPermission(strArr[i]) == 0 || !m20293a(strArr[i])) {
                i++;
            } else {
                e.b("PushSelfShowLog", "request permissions failed:" + strArr[i]);
                return false;
            }
        }
        e.b("PushSelfShowLog", "request all permissions success:");
        return true;
    }

    private boolean m20295a(String[] strArr, int[] iArr) {
        int i = 0;
        while (i < strArr.length) {
            if (iArr[i] == 0 || !m20293a(strArr[i])) {
                i++;
            } else {
                e.a("PushSelfShowLog", "request permissions failed:" + strArr[i]);
                return false;
            }
        }
        e.a("PushSelfShowLog", "request all permissions success:");
        return true;
    }

    private void m20296b(String[] strArr) {
        try {
            Intent intent = new Intent("huawei.intent.action.REQUEST_PERMISSIONS");
            intent.setPackage("com.huawei.systemmanager");
            intent.putExtra("KEY_HW_PERMISSION_ARRAY", strArr);
            intent.putExtra("KEY_HW_PERMISSION_PKG", getPackageName());
            if (C4203a.m20418a((Context) this, "com.huawei.systemmanager", intent).booleanValue()) {
                try {
                    e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is exist");
                    startActivityForResult(intent, 1357);
                    return;
                } catch (Throwable e) {
                    e.c("PushSelfShowLog", "checkAndRequestPermission: Exception", e);
                    requestPermissions(strArr, 1357);
                    return;
                }
            }
            e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is not exist");
            requestPermissions(strArr, 1357);
        } catch (Throwable e2) {
            e.c("PushSelfShowLog", e2.toString(), e2);
        }
    }

    private void m20297c() {
        ArrayList arrayList = new ArrayList();
        for (String str : m20299b()) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() != 0) {
            this.f15624c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            m20296b(this.f15624c);
            return;
        }
        e.a("PushSelfShowLog", "unsatisfiedPermissions size is 0, finish");
        finish();
    }

    protected String[] m20298a() {
        return f15622a;
    }

    protected String[] m20299b() {
        return f15622a;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1357 == i) {
            if (i2 == 0) {
                try {
                    e.b("PushSelfShowLog", "onActivityResult: RESULT_CANCELED");
                } catch (Throwable e) {
                    e.c("PushSelfShowLog", e.toString(), e);
                    return;
                }
            } else if (-1 == i2) {
                e.b("PushSelfShowLog", "onActivityResult: RESULT_OK");
                if (!(this.f15624c == null || this.f15624c.length == 0 || !m20294a(this.f15624c))) {
                    e.b("PushSelfShowLog", "onActivityResult: Permission is granted");
                    new C4148a().m20255a(this, this.f15623b);
                }
            }
        }
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a(this);
        e.b("PushSelfShowLog", "enter RequestPermissionsActivity onCreate");
        requestWindowFeature(1);
        Intent intent = getIntent();
        if (intent == null) {
            e.b("PushSelfShowLog", "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
        } else if (VERSION.SDK_INT < 23) {
            e.b("PushSelfShowLog", "enter RequestPermissionsActivity onCreate, SDK version is less than 23, finish");
            finish();
        } else {
            try {
                if (intent.getExtras() != null) {
                    this.f15623b = (Intent) intent.getExtras().get("previous_intent");
                }
            } catch (Throwable e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
            e.a("PushSelfShowLog", "savedInstanceState is " + bundle);
            if (bundle == null) {
                m20297c();
            }
        }
    }

    protected void onDestroy() {
        e.a("PushSelfShowLog", "enter RequestPermissionsActivity onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        e.a("PushSelfShowLog", "enter RequestPermissionsActivity onNewIntent");
        super.onNewIntent(intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.b("PushSelfShowLog", "RequestPermissionsActivity onRequestPermissionsResult");
        if (1357 == i && strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0 && m20295a(strArr, iArr) && this.f15623b != null) {
            new C4148a().m20255a(this, this.f15623b);
        }
        finish();
    }
}
