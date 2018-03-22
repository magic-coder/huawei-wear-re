package com.huawei.openalliance.ad.utils.db.bean;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.openalliance.ad.utils.C1362f;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class C1359a {
    private static Map<String, String> DBTypeMap = new HashMap(4);
    public static final String tag = "RecordBean";
    private boolean isFiledCutUnderline = true;

    static {
        DBTypeMap.put("String", "TEXT");
        DBTypeMap.put("long", "INTEGER");
        DBTypeMap.put("int", "INTEGER");
        DBTypeMap.put("float", "REAL");
    }

    private String mo2463a(String str) {
        return (this.isFiledCutUnderline && str.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) ? str.substring(0, str.length() - 1) : str;
    }

    public void m6001a(Cursor cursor) {
        Field[] a = C1362f.m6071a(getClass());
        for (int i = 0; i < a.length; i++) {
            try {
                a[i].setAccessible(true);
                String name = a[i].getName();
                if ("_id".equals(name)) {
                    a[i].set(this, cursor.getString(cursor.getColumnIndex(name)));
                } else if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE) && !name.contains("$")) {
                    String simpleName = a[i].getType().getSimpleName();
                    int columnIndex = cursor.getColumnIndex(mo2463a(name));
                    if (columnIndex != -1) {
                        if ("String".equals(simpleName)) {
                            a[i].set(this, cursor.getString(columnIndex));
                        } else if ("int".equals(simpleName)) {
                            a[i].set(this, Integer.valueOf(cursor.getInt(columnIndex)));
                        } else if ("long".equals(simpleName)) {
                            a[i].set(this, Long.valueOf(cursor.getLong(columnIndex)));
                        } else if ("float".equals(simpleName)) {
                            a[i].set(this, Float.valueOf(cursor.getFloat(columnIndex)));
                        } else {
                            C1336d.m5888c("RecordBean", "unsupport field type:", simpleName, HwAccountConstants.BLANK, a[i].getName());
                        }
                    }
                }
            } catch (Throwable e) {
                C1336d.m5883a("RecordBean", "IllegalAccessException", e);
            }
        }
    }

    public String m6002n(String str) {
        Field[] a = C1362f.m6071a(getClass());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ");
        stringBuilder.append(str);
        stringBuilder.append(" ( ");
        stringBuilder.append("_id INTEGER primary key autoincrement ");
        for (int i = 0; i < a.length; i++) {
            a[i].setAccessible(true);
            String name = a[i].getName();
            if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE) && !name.contains("$")) {
                String str2 = (String) DBTypeMap.get(a[i].getType().getSimpleName());
                if (str2 != null) {
                    name = mo2463a(name);
                    stringBuilder.append(" , ");
                    stringBuilder.append(name);
                    stringBuilder.append(HwAccountConstants.BLANK);
                    stringBuilder.append(str2);
                    if (mo2464r() != null && mo2464r().equals(name)) {
                        stringBuilder.append(" unique");
                    }
                }
            }
        }
        stringBuilder.append(" ) ");
        return stringBuilder.toString();
    }

    public String mo2464r() {
        return "";
    }

    public ContentValues m6004u() {
        Field[] a = C1362f.m6071a(getClass());
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < a.length; i++) {
            try {
                a[i].setAccessible(true);
                String name = a[i].getName();
                if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE) && !name.contains("$")) {
                    Object obj = a[i].get(this);
                    if (obj != null) {
                        name = mo2463a(name);
                        if (obj instanceof String) {
                            contentValues.put(name, (String) obj);
                        } else if (obj instanceof Integer) {
                            contentValues.put(name, (Integer) obj);
                        } else if (obj instanceof Long) {
                            contentValues.put(name, (Long) obj);
                        } else {
                            C1336d.m5888c("RecordBean", "unsupport type, name:", a[i].getName());
                        }
                    }
                }
            } catch (IllegalAccessException e) {
            }
        }
        return contentValues;
    }

    public String m6005v() {
        return m6002n(m6006w());
    }

    public String m6006w() {
        return getClass().getSimpleName();
    }
}
