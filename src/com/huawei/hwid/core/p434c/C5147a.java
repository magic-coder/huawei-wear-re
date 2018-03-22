package com.huawei.hwid.core.p434c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.huawei.hwid.core.encrypt.C5201e;

/* compiled from: AccountInfoPreferences */
public class C5147a {
    private static C5147a f18581b;
    private SharedPreferences f18582a;
    private Context f18583c;

    public C5147a(Context context) {
        this.f18582a = context.getSharedPreferences("HwAccount", 0);
        this.f18583c = context.getApplicationContext();
    }

    public static synchronized C5147a m24824a(Context context) {
        C5147a c5147a;
        synchronized (C5147a.class) {
            if (f18581b == null) {
                f18581b = new C5147a(context);
            }
            c5147a = f18581b;
        }
        return c5147a;
    }

    public String m24827a(String str, String str2) {
        if (this.f18582a != null) {
            str2 = this.f18582a.getString(str, str2);
        }
        if (str.equals("rkey")) {
            return str2;
        }
        CharSequence c = C5201e.m25308c(this.f18583c, str2);
        if (TextUtils.isEmpty(c)) {
            return str2;
        }
        return c;
    }

    public int m24825a(String str, int i) {
        return this.f18582a != null ? this.f18582a.getInt(str, i) : i;
    }

    public long m24826a(String str, long j) {
        return this.f18582a != null ? this.f18582a.getLong(str, j) : j;
    }

    public void m24831b(String str, String str2) {
        Editor edit = this.f18582a.edit();
        if (edit != null) {
            edit.putString(str, C5201e.m25307b(this.f18583c, str2)).commit();
        }
    }

    public void m24830b(String str, long j) {
        Editor edit = this.f18582a.edit();
        if (edit != null) {
            edit.putLong(str, j).commit();
        }
    }

    public boolean m24829a(String str, Object obj) {
        Editor edit = this.f18582a.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            edit.putInt(str, Integer.valueOf(String.valueOf(obj)).intValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putFloat(str, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public void m24828a(String str) {
        Editor edit = this.f18582a.edit();
        if (edit != null) {
            edit.remove(str).commit();
        }
    }
}
