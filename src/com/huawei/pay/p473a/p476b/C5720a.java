package com.huawei.pay.p473a.p476b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.pay.e.c.a;
import com.huawei.pay.ui.PermissionsActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PermissionsManager */
public class C5720a {
    private static volatile C5720a f19492f;
    private static final byte[] f19493h = new byte[0];
    private int f19494a;
    private Context f19495b;
    private final Map<Integer, C5587b> f19496c = new HashMap();
    private final Map<Integer, Map<String, Integer>> f19497d = new HashMap();
    private final Map<String, Integer> f19498e = new HashMap();
    private final byte[] f19499g = new byte[0];

    private C5720a() {
    }

    public void m26370a(Context context) {
        if (this.f19495b != null) {
            a.a("initBackGround applicationContext init not null!", false);
        } else if (context != null) {
            this.f19495b = context.getApplicationContext();
        } else {
            a.d("initBackGround applicationContext init failed! context==null", false);
        }
    }

    public static C5720a m26366a() {
        C5720a c5720a;
        synchronized (f19493h) {
            if (f19492f == null) {
                f19492f = new C5720a();
            }
            c5720a = f19492f;
        }
        return c5720a;
    }

    private synchronized int m26368b() {
        int i;
        i = this.f19494a + 1;
        this.f19494a = i;
        return i;
    }

    public void m26372a(C5587b c5587b, String... strArr) {
        m26371a(c5587b, null, strArr);
    }

    public void m26371a(C5587b c5587b, Activity activity, String... strArr) {
        String[] b;
        synchronized (this.f19499g) {
            Map a = C5721c.m26374a(this.f19495b, strArr);
            b = C5721c.m26379b(a);
            int b2 = m26368b();
            a.b("requestPermissions, requestId:" + b2, false);
            this.f19496c.put(Integer.valueOf(b2), c5587b);
            this.f19497d.put(Integer.valueOf(b2), a);
        }
        String[] a2 = m26367a(b);
        if (a2 == null || a2.length == 0) {
            a.b("PermissionsManager permissionsArray has a permission requesting or null", false);
            m26369a(b2, a2, new int[0]);
            return;
        }
        for (String str : a2) {
            a.b("PermissionsManager permission === " + str + " is requesting", false);
            this.f19498e.put(str, Integer.valueOf(b2));
        }
        if (activity != null) {
            a.b("PermissionsManager requestPermissions startActivityForResult", false);
            Intent intent = new Intent(activity, PermissionsActivity.class);
            intent.putExtra(PermissionsActivity.EXTRA_PERMISSION_REQUESTED_PERMISSIONS, a2);
            intent.putExtra(PermissionsActivity.EXTRA_PERMISSION_REQUEST_CODE, b2);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            activity.startActivityForResult(intent, ApplyPayOrderCallback.RETURN_FAILED_APPLY_ORDER_INNER_ERROR);
            return;
        }
        synchronized (this.f19499g) {
            a.b("PermissionsActivity.run(mApplicationContext, requestId, permissionsArray)", false);
            PermissionsActivity.run(this.f19495b, b2, a2);
        }
    }

    private String[] m26367a(String[] strArr) {
        if (strArr == null) {
            return strArr;
        }
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            if (!this.f19498e.containsKey(obj)) {
                arrayList.add(obj);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void m26369a(int i, String[] strArr, int[] iArr) {
        a.b("PermissionsManager onRequestPermissionsResult, requestCode:" + i, false);
        synchronized (this.f19499g) {
            Map map = (Map) this.f19497d.get(Integer.valueOf(i));
            if (map != null) {
                Map a = C5721c.m26373a(this.f19495b, map);
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    a.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                iArr = C5721c.m26378a(a);
                for (String str : a.keySet()) {
                    if (this.f19498e.containsKey(str) && i == ((Integer) this.f19498e.get(str)).intValue()) {
                        a.b("PermissionsManager key === " + str + " remove !", false);
                        this.f19498e.remove(str);
                    }
                }
            }
            C5587b c5587b = (C5587b) this.f19496c.get(Integer.valueOf(i));
        }
        if (c5587b == null) {
            a.b("onRequestPermissionsResult permissionsResultsCallback null", false);
            return;
        }
        synchronized (this.f19499g) {
            a.b("callback remove:" + this.f19496c.remove(Integer.valueOf(i)), false);
            a.b("requestMap remove:" + this.f19497d.remove(Integer.valueOf(i)), false);
            c5587b.onRequestPermissionsResult(iArr);
        }
    }
}
