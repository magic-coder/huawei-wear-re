package com.huawei.android.pushagent.p018c.p019a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C0659h {
    protected SharedPreferences f1190a;

    public C0659h(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        this.f1190a = context.getSharedPreferences(str, 4);
    }

    public ContentValues m2531a() {
        if (this.f1190a == null) {
            return null;
        }
        Map all = this.f1190a.getAll();
        if (all == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Entry entry : all.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(str, String.valueOf(value));
            } else if ((value instanceof Integer) || (value instanceof Short) || (value instanceof Byte)) {
                contentValues.put(str, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(str, (Long) value);
            } else if (value instanceof Float) {
                contentValues.put(str, (Float) value);
            } else if (value instanceof Double) {
                contentValues.put(str, Float.valueOf((float) ((Double) value).doubleValue()));
            } else if (value instanceof Boolean) {
                contentValues.put(str, (Boolean) value);
            }
        }
        return contentValues;
    }

    public void m2532a(String str, Integer num) {
        if (this.f1190a != null) {
            Editor edit = this.f1190a.edit();
            if (edit != null) {
                edit.putInt(str, num.intValue()).commit();
            }
        }
    }

    public void m2533a(String str, Long l) {
        if (this.f1190a != null) {
            Editor edit = this.f1190a.edit();
            if (edit != null) {
                edit.putLong(str, l.longValue()).commit();
            }
        }
    }

    public void m2534a(String str, boolean z) {
        if (this.f1190a != null) {
            Editor edit = this.f1190a.edit();
            if (edit != null) {
                edit.putBoolean(str, z).commit();
            }
        }
    }

    public void m2535a(Map map) {
        for (Entry entry : map.entrySet()) {
            m2538a((String) entry.getKey(), entry.getValue());
        }
    }

    public boolean m2536a(ContentValues contentValues) {
        if (this.f1190a == null || contentValues == null) {
            return false;
        }
        boolean z = true;
        for (Entry entry : contentValues.valueSet()) {
            z = !m2538a((String) entry.getKey(), entry.getValue()) ? false : z;
        }
        return z;
    }

    public boolean m2537a(String str) {
        return this.f1190a != null ? this.f1190a.getBoolean(str, false) : false;
    }

    public boolean m2538a(String str, Object obj) {
        Editor edit = this.f1190a.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            edit.putInt(str, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            edit.putInt(str, ((Byte) obj).byteValue());
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

    public boolean m2539a(String str, String str2) {
        if (this.f1190a == null) {
            return false;
        }
        Editor edit = this.f1190a.edit();
        return edit != null ? edit.putString(str, str2).commit() : false;
    }

    public String m2540b(String str) {
        return this.f1190a != null ? this.f1190a.getString(str, "") : "";
    }

    public Map m2541b() {
        return this.f1190a != null ? this.f1190a.getAll() : new HashMap();
    }

    public int m2542c(String str) {
        return this.f1190a != null ? this.f1190a.getInt(str, 0) : 0;
    }

    public boolean m2543c() {
        return this.f1190a != null ? this.f1190a.edit().clear().commit() : false;
    }

    public long m2544d(String str) {
        return this.f1190a != null ? this.f1190a.getLong(str, 0) : 0;
    }

    public boolean m2545e(String str) {
        return this.f1190a != null && this.f1190a.contains(str);
    }

    public boolean m2546f(String str) {
        if (this.f1190a == null || !this.f1190a.contains(str)) {
            return false;
        }
        Editor remove = this.f1190a.edit().remove(str);
        remove.commit();
        return remove.commit();
    }
}
