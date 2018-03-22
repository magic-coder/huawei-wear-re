package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.huawei.p190v.C2538c;

/* compiled from: AbilityDB */
public class C1385a {
    public static final String f2980a;
    private static final String[] f2981d = new String[]{"version", "deviceCode", "lastTime", "data1", "data2", "data3", "data4"};
    private SQLiteDatabase f2982b;
    private C1393i f2983c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS ability_set_table(");
        stringBuilder.append("version NVARCHAR(300) ,");
        stringBuilder.append("deviceCode integer,");
        stringBuilder.append("lastTime NVARCHAR(1500) ,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append("data4 NVARCHAR(300) ,");
        stringBuilder.append(" primary key(deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("CheckVersionDB", "===createTableSQL", stringBuilder.toString());
        f2980a = stringBuilder.toString();
    }

    public C1385a(Context context) {
        this.f2983c = C1393i.m6319a(context);
    }

    public void m6199a() {
        if (this.f2982b == null) {
            this.f2982b = this.f2983c.m6327a();
        }
    }

    public void m6201b() {
        this.f2983c.m6328b();
        this.f2982b = null;
    }

    public long m6197a(C1386b c1386b) {
        try {
            m6199a();
            ContentValues d = m6196d(c1386b);
            long insert = this.f2982b.insert("ability_set_table", null, d);
            String str = "CheckVersionDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1386b + ", values=" + d.toString();
            C2538c.m12674b(str, objArr);
            m6201b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("CheckVersionDB", "Exception e = " + e.getMessage());
            return 0;
        }
    }

    @NonNull
    private ContentValues m6196d(C1386b c1386b) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("version", c1386b.f3028a);
        contentValues.put("deviceCode", Integer.valueOf(c1386b.f3029b));
        contentValues.put("lastTime", c1386b.f3030c);
        contentValues.put("data1", c1386b.f3031d);
        contentValues.put("data2", c1386b.f3032e);
        contentValues.put("data3", c1386b.f3033f);
        contentValues.put("data4", c1386b.f3034g);
        return contentValues;
    }

    public int m6200b(C1386b c1386b) {
        try {
            m6199a();
            int update = this.f2982b.update("ability_set_table", m6196d(c1386b), "deviceCode= ?", new String[]{String.valueOf(c1386b.f3029b)});
            String str = "CheckVersionDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1386b + ", values=" + c1386b.toString();
            C2538c.m12674b(str, objArr);
            m6201b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("CheckVersionDB", "Exception e = " + e.getMessage());
            return 0;
        }
    }

    public void m6202c(C1386b c1386b) {
        if (c1386b != null) {
            try {
                if (c1386b.f3029b > 0) {
                    if (m6198a(c1386b.f3029b) == null) {
                        C2538c.m12674b("CheckVersionDB", "===== res is null,insert");
                        m6197a(c1386b);
                        return;
                    }
                    C2538c.m12674b("CheckVersionDB", "===== res is not null,update");
                    m6200b(c1386b);
                }
            } catch (Exception e) {
                C2538c.m12680e("CheckVersionDB", "=====ERROR:" + e.getMessage());
            }
        }
    }

    public C1386b m6198a(int i) {
        try {
            m6199a();
            String[] strArr = new String[]{String.valueOf(i)};
            C2538c.m12674b("CheckVersionDB", "================selection:", "deviceCode= ?");
            Cursor query = this.f2982b.query("ability_set_table", f2981d, "deviceCode= ?", strArr, null, null, null);
            if (query == null) {
                m6201b();
                return null;
            }
            C1386b c1386b;
            if (query.moveToFirst()) {
                c1386b = new C1386b();
                c1386b.f3029b = query.getInt(query.getColumnIndex("deviceCode"));
                c1386b.f3028a = query.getString(query.getColumnIndex("version"));
                c1386b.f3030c = query.getString(query.getColumnIndex("lastTime"));
                c1386b.f3031d = query.getString(query.getColumnIndex("data1"));
                c1386b.f3032e = query.getString(query.getColumnIndex("data2"));
                c1386b.f3033f = query.getString(query.getColumnIndex("data3"));
                c1386b.f3034g = query.getString(query.getColumnIndex("data4"));
            } else {
                c1386b = null;
            }
            if (c1386b != null) {
                C2538c.m12674b("CheckVersionDB", "result = " + c1386b);
            }
            query.close();
            m6201b();
            C2538c.m12674b("CheckVersionDB", "=========查到结果");
            return c1386b;
        } catch (Exception e) {
            C2538c.m12680e("CheckVersionDB", "Exception e = " + e.getMessage());
            return null;
        }
    }
}
