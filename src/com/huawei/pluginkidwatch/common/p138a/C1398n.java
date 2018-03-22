package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NewSportDatasDB */
public class C1398n {
    public static final String f3120a;
    private static final String[] f3121f = new String[]{"deviceCode", "date", "steps", "sportType", "totalSteps", "totalCalories", "totalDurationTime", "totalDistance", "data1", "data2", "data3", "data4", "data5"};
    private Context f3122b;
    private Gson f3123c = new Gson();
    private SQLiteDatabase f3124d;
    private C1393i f3125e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table IF NOT EXISTS NewSportTotalDatas(");
        stringBuilder.append("deviceCode integer not null,");
        stringBuilder.append("date NVARCHAR(300) not null,");
        stringBuilder.append("steps TEXT not null,");
        stringBuilder.append("sportType integer not null,");
        stringBuilder.append("totalSteps NVARCHAR(300) not null,");
        stringBuilder.append("totalCalories NVARCHAR(300) not null,");
        stringBuilder.append("totalDurationTime NVARCHAR(300) not null,");
        stringBuilder.append("totalDistance NVARCHAR(300) not null,");
        stringBuilder.append("data1 TEXT not null,");
        stringBuilder.append("data2 TEXT not null,");
        stringBuilder.append("data3 TEXT not null,");
        stringBuilder.append("data4 TEXT not null,");
        stringBuilder.append("data5 TEXT not null,");
        stringBuilder.append(" primary key(deviceCode,date,sportType)");
        stringBuilder.append(")");
        C2538c.m12674b("NewSportDatasDB", "===createTableSQL", stringBuilder.toString());
        f3120a = stringBuilder.toString();
    }

    public C1398n(Context context) {
        this.f3122b = context;
        this.f3125e = C1393i.m6319a(context);
    }

    public void m6356a() {
        if (this.f3124d == null) {
            this.f3124d = this.f3125e.m6327a();
        }
    }

    public void m6358b() {
        this.f3125e.m6328b();
        this.f3124d = null;
    }

    public long m6354a(C1399o c1399o) {
        try {
            m6356a();
            ContentValues contentValues = new ContentValues();
            m6353a(c1399o, contentValues);
            long insert = this.f3124d.insert("NewSportTotalDatas", null, contentValues);
            String str = "NewSportDatasDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1399o + ", values=" + contentValues.toString();
            C2538c.m12674b(str, objArr);
            m6358b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("NewSportDatasDB", "insert() Exception=" + e.getMessage());
            m6358b();
            return -1;
        }
    }

    public String m6355a(String str, String str2) {
        String str3 = "";
        m6356a();
        String str4 = FeedbackHistoryConstants.DEFAULT_SORT_ORDER;
        String[] strArr = new String[]{str, str2};
        Cursor query = this.f3124d.query("NewSportTotalDatas", f3121f, "deviceCode = ? and date <= ?", strArr, null, null, str4);
        if (query == null) {
            m6358b();
            return str3;
        }
        String string;
        if (query.moveToFirst()) {
            string = query.getString(query.getColumnIndex("date"));
        } else {
            string = str3;
        }
        C2538c.m12674b("NewSportDatasDB", "=========selectLastDate=======strLastDate:", string);
        query.close();
        m6358b();
        return string;
    }

    public List<C1399o> m6357b(C1399o c1399o) {
        JsonSyntaxException e;
        Cursor query;
        try {
            m6356a();
            List<C1399o> arrayList = new ArrayList();
            String[] strArr = new String[]{String.valueOf(c1399o.m6360a()), c1399o.m6363b()};
            C2538c.m12674b("NewSportDatasDB", "================selection:", "deviceCode = ? and date like ?".toString());
            query = this.f3124d.query("NewSportTotalDatas", f3121f, "deviceCode = ? and date like ?", strArr, null, null, null);
            if (query == null) {
                try {
                    C2538c.m12674b("NewSportDatasDB", "================cursor: null");
                    c1399o.m6361a(0);
                    m6358b();
                    return null;
                } catch (JsonSyntaxException e2) {
                    e = e2;
                    C2538c.m12680e("NewSportDatasDB", "select() JsonSyntaxException=" + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    m6358b();
                    return null;
                }
            }
            while (query.moveToNext()) {
                C1399o c1399o2 = new C1399o();
                c1399o2.m6361a(query.getInt(query.getColumnIndex("deviceCode")));
                c1399o2.m6362a(query.getString(query.getColumnIndex("date")));
                c1399o2.m6365b(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("steps"))));
                c1399o2.m6364b(query.getInt(query.getColumnIndex("sportType")));
                c1399o2.m6367c(((Integer) this.f3123c.fromJson(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("totalSteps"))), Integer.class)).intValue());
                c1399o2.m6370d(((Integer) this.f3123c.fromJson(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("totalCalories"))), Integer.class)).intValue());
                c1399o2.m6373e(((Integer) this.f3123c.fromJson(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("totalDurationTime"))), Integer.class)).intValue());
                c1399o2.m6376f(((Integer) this.f3123c.fromJson(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("totalDistance"))), Integer.class)).intValue());
                c1399o2.m6368c(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("data1"))));
                c1399o2.m6371d(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("data2"))));
                c1399o2.m6374e(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("data3"))));
                c1399o2.m6377f(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("data4"))));
                c1399o2.m6379g(C1392h.m6318k(this.f3122b, query.getString(query.getColumnIndex("data5"))));
                C2538c.m12674b("NewSportDatasDB", "================cursor:", c1399o.toString());
                arrayList.add(c1399o2);
            }
            query.close();
            m6358b();
            return arrayList;
        } catch (JsonSyntaxException e3) {
            e = e3;
            query = null;
            C2538c.m12680e("NewSportDatasDB", "select() JsonSyntaxException=" + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6358b();
            return null;
        }
    }

    public int m6359c(C1399o c1399o) {
        try {
            m6356a();
            ContentValues contentValues = new ContentValues();
            m6353a(c1399o, contentValues);
            String[] strArr = new String[]{String.valueOf(c1399o.m6360a()), c1399o.m6363b(), String.valueOf(c1399o.m6369d())};
            int update = this.f3124d.update("NewSportTotalDatas", contentValues, "deviceCode = ? and date like ? and sportType = ?", strArr);
            if (update == -1) {
                C2538c.m12680e("NewSportDatasDB", "update() Exception count:" + update);
                return update;
            }
            C2538c.m12674b("NewSportDatasDB", "update() ===ok====");
            m6358b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("NewSportDatasDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    private void m6353a(C1399o c1399o, ContentValues contentValues) {
        contentValues.put("deviceCode", Integer.valueOf(c1399o.m6360a()));
        contentValues.put("date", c1399o.m6363b());
        contentValues.put("steps", C1392h.m6317j(this.f3122b, c1399o.m6366c()));
        contentValues.put("sportType", Integer.valueOf(c1399o.m6369d()));
        contentValues.put("totalSteps", C1392h.m6317j(this.f3122b, this.f3123c.toJson(Integer.valueOf(c1399o.m6372e()))));
        contentValues.put("totalCalories", C1392h.m6317j(this.f3122b, this.f3123c.toJson(Integer.valueOf(c1399o.m6375f()))));
        contentValues.put("totalDurationTime", C1392h.m6317j(this.f3122b, this.f3123c.toJson(Integer.valueOf(c1399o.m6378g()))));
        contentValues.put("totalDistance", C1392h.m6317j(this.f3122b, this.f3123c.toJson(Integer.valueOf(c1399o.m6380h()))));
        contentValues.put("data1", C1392h.m6317j(this.f3122b, c1399o.m6381i()));
        contentValues.put("data2", C1392h.m6317j(this.f3122b, c1399o.m6382j()));
        contentValues.put("data3", C1392h.m6317j(this.f3122b, c1399o.m6383k()));
        contentValues.put("data4", C1392h.m6317j(this.f3122b, c1399o.m6384l()));
        contentValues.put("data5", C1392h.m6317j(this.f3122b, c1399o.m6385m()));
    }
}
