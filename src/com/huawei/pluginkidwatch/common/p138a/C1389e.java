package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;

/* compiled from: CheckVersionDB */
public class C1389e {
    public static final String f3054a;
    private static final String[] f3055d = new String[]{"huid", "deviceCode", "lastTime", "data1", "data2", "data3", "data4"};
    private SQLiteDatabase f3056b;
    private C1393i f3057c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS checkversiontable(");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode integer,");
        stringBuilder.append("lastTime NVARCHAR(300) ,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append("data4 NVARCHAR(300) ,");
        stringBuilder.append(" primary key(huid,deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("CheckVersionDB", "===createTableSQL", stringBuilder.toString());
        f3054a = stringBuilder.toString();
    }

    public C1389e(Context context) {
        this.f3057c = C1393i.m6319a(context);
    }

    public void m6254a() {
        if (this.f3056b == null) {
            this.f3056b = this.f3057c.m6327a();
        }
    }

    public void m6256b() {
        this.f3057c.m6328b();
        this.f3056b = null;
    }

    public long m6252a(C1390f c1390f) {
        m6254a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("huid", c1390f.f3058a);
        contentValues.put("deviceCode", Integer.valueOf(c1390f.f3059b));
        contentValues.put("lastTime", c1390f.f3060c);
        contentValues.put("data1", c1390f.f3061d);
        contentValues.put("data2", c1390f.f3062e);
        contentValues.put("data3", c1390f.f3063f);
        contentValues.put("data4", c1390f.f3064g);
        long insert = this.f3056b.insert("checkversiontable", null, contentValues);
        String str = "CheckVersionDB";
        Object[] objArr = new Object[1];
        objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1390f + ", values=" + contentValues.toString();
        C2538c.m12674b(str, objArr);
        m6256b();
        return insert;
    }

    public int m6255b(C1390f c1390f) {
        m6254a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("huid", c1390f.f3058a);
        contentValues.put("deviceCode", Integer.valueOf(c1390f.f3059b));
        contentValues.put("lastTime", c1390f.f3060c);
        contentValues.put("data1", c1390f.f3061d);
        contentValues.put("data2", c1390f.f3062e);
        contentValues.put("data3", c1390f.f3063f);
        contentValues.put("data4", c1390f.f3064g);
        int update = this.f3056b.update("checkversiontable", contentValues, "deviceCode= ? and huid = ?", new String[]{String.valueOf(c1390f.f3059b), c1390f.f3058a});
        String str = "CheckVersionDB";
        Object[] objArr = new Object[1];
        objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1390f + ", values=" + c1390f.toString();
        C2538c.m12674b(str, objArr);
        m6256b();
        return update;
    }

    public C1390f m6253a(String str, int i) {
        C1390f c1390f = null;
        m6254a();
        String[] strArr = new String[]{String.valueOf(i), str};
        C2538c.m12674b("CheckVersionDB", "================selection:", "deviceCode= ? and huid = ?");
        Cursor query = this.f3056b.query("checkversiontable", f3055d, "deviceCode= ? and huid = ?", strArr, null, null, null);
        if (query == null) {
            m6256b();
        } else {
            if (query.moveToFirst()) {
                c1390f = new C1390f();
                c1390f.f3059b = query.getInt(query.getColumnIndex("deviceCode"));
                c1390f.f3058a = query.getString(query.getColumnIndex("huid"));
                c1390f.f3060c = query.getString(query.getColumnIndex("lastTime"));
                c1390f.f3061d = query.getString(query.getColumnIndex("data1"));
                c1390f.f3062e = query.getString(query.getColumnIndex("data2"));
                c1390f.f3063f = query.getString(query.getColumnIndex("data3"));
                c1390f.f3064g = query.getString(query.getColumnIndex("data4"));
            }
            query.close();
            m6256b();
            C2538c.m12674b("CheckVersionDB", "=========查到结果");
        }
        return c1390f;
    }
}
