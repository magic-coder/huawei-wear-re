package com.huawei.appmarket.sdk.foundation.p365d.p366a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.v4.util.ArrayMap;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4286c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.Field;
import java.util.Map;

public class C4273a {
    private static Map<String, String> DBTypeMap = new ArrayMap();
    public static final String tag = "RecordBean";
    public boolean isFiledCutUnderline = false;

    static {
        DBTypeMap.put("String", "TEXT");
        DBTypeMap.put("long", "INTEGER");
        DBTypeMap.put("int", "INTEGER");
        DBTypeMap.put("float", "REAL");
    }

    private String cutUnderline(String str) {
        return (this.isFiledCutUnderline && str.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) ? str.substring(0, str.length() - 1) : str;
    }

    public String getDefaultTableName() {
        return getClass().getSimpleName();
    }

    public String getInsertSqlStatement() {
        Field[] a = C4286c.m20691a(getClass());
        StringBuffer stringBuffer = new StringBuffer(255);
        stringBuffer.append("insert into ");
        stringBuffer.append(getDefaultTableName());
        StringBuffer stringBuffer2 = new StringBuffer(255);
        stringBuffer2.append(" (");
        StringBuffer stringBuffer3 = new StringBuffer(255);
        stringBuffer3.append(" (");
        for (int i = 0; i < a.length; i++) {
            a[i].setAccessible(true);
            String name = a[i].getName();
            if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) {
                stringBuffer2.append(cutUnderline(name) + ",");
                stringBuffer3.append("?,");
            }
        }
        if (stringBuffer2.charAt(stringBuffer2.length() - 1) == ',') {
            stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
        }
        stringBuffer2.append(") ");
        if (stringBuffer3.charAt(stringBuffer3.length() - 1) == ',') {
            stringBuffer3.deleteCharAt(stringBuffer3.length() - 1);
        }
        stringBuffer3.append(") ");
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append("values");
        stringBuffer.append(stringBuffer3.toString());
        return stringBuffer.toString();
    }

    public String getTableScheme() {
        return getTableScheme(getDefaultTableName());
    }

    public String getTableScheme(String str) {
        Field[] a = C4286c.m20691a(getClass());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ");
        stringBuilder.append(str);
        stringBuilder.append(" ( ");
        stringBuilder.append("_id INTEGER primary key autoincrement ");
        for (int i = 0; i < a.length; i++) {
            a[i].setAccessible(true);
            String name = a[i].getName();
            if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) {
                String str2 = (String) DBTypeMap.get(a[i].getType().getSimpleName());
                if (str2 != null) {
                    name = cutUnderline(name);
                    stringBuilder.append(" , ");
                    stringBuilder.append(name);
                    stringBuilder.append(HwAccountConstants.BLANK);
                    stringBuilder.append(str2);
                }
            }
        }
        stringBuilder.append(" ) ");
        return stringBuilder.toString();
    }

    public void toBean(Cursor cursor) {
        Field[] a = C4286c.m20691a(getClass());
        for (int i = 0; i < a.length; i++) {
            try {
                a[i].setAccessible(true);
                String name = a[i].getName();
                if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) {
                    String simpleName = a[i].getType().getSimpleName();
                    int columnIndex = cursor.getColumnIndex(cutUnderline(name));
                    if (columnIndex != -1) {
                        if (simpleName.equals("String")) {
                            a[i].set(this, cursor.getString(columnIndex));
                        } else if (simpleName.equals("int")) {
                            a[i].set(this, Integer.valueOf(cursor.getInt(columnIndex)));
                        } else if (simpleName.equals("long")) {
                            a[i].set(this, Long.valueOf(cursor.getLong(columnIndex)));
                        } else if (simpleName.equals("float")) {
                            a[i].set(this, Float.valueOf(cursor.getFloat(columnIndex)));
                        } else if (C4241a.m20531a()) {
                            C4241a.m20532b("RecordBean", "unsupport field type:" + simpleName + HwAccountConstants.BLANK + a[i].getName());
                        }
                    }
                }
            } catch (Throwable e) {
                C4241a.m20530a("RecordBean", "IllegalAccessException:", e);
            }
        }
    }

    public ContentValues toRecord() {
        Field[] a = C4286c.m20691a(getClass());
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < a.length; i++) {
            try {
                a[i].setAccessible(true);
                String name = a[i].getName();
                if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) {
                    Object obj = a[i].get(this);
                    if (obj != null) {
                        name = cutUnderline(name);
                        if (obj instanceof String) {
                            contentValues.put(name, (String) obj);
                        } else if (obj instanceof Integer) {
                            contentValues.put(name, (Integer) obj);
                        } else if (obj instanceof Long) {
                            contentValues.put(name, (Long) obj);
                        } else if (C4241a.m20531a()) {
                            C4241a.m20532b("RecordBean", "unsupport type, name:" + a[i].getName() + ", value:" + obj);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
            }
        }
        return contentValues;
    }

    public void toRecord(SQLiteStatement sQLiteStatement) {
        Field[] a = C4286c.m20691a(getClass());
        int i = 1;
        for (int i2 = 0; i2 < a.length; i2++) {
            try {
                a[i2].setAccessible(true);
                String name = a[i2].getName();
                if (name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE)) {
                    Object obj = a[i2].get(this);
                    if (obj == null) {
                        int i3 = i + 1;
                        sQLiteStatement.bindNull(i);
                        i = i3;
                    } else if (obj instanceof String) {
                        r3 = i + 1;
                        sQLiteStatement.bindString(i, (String) obj);
                        i = r3;
                    } else if (obj instanceof Integer) {
                        r3 = i + 1;
                        sQLiteStatement.bindLong(i, (long) ((Integer) obj).intValue());
                        i = r3;
                    } else if (obj instanceof Long) {
                        r3 = i + 1;
                        sQLiteStatement.bindLong(i, ((Long) obj).longValue());
                        i = r3;
                    } else if (C4241a.m20531a()) {
                        C4241a.m20532b("RecordBean", "unsupport type, name:" + name + ", value:" + obj);
                    }
                }
            } catch (IllegalAccessException e) {
            }
        }
    }
}
