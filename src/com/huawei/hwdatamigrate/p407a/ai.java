package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwdatamigrate.common.C4799a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SleepDatasDB */
public class ai {
    public static final String f17402a;
    public static final String f17403b;
    public static final String f17404c;
    private static final String[] f17405h = new String[]{"_id", "userid", "mac", "data", "isUpload", "sleepCurTime"};
    Cursor f17406d = null;
    private SQLiteDatabase f17407e;
    private C4780m f17408f;
    private Context f17409g;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sleepdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("sleeps NVARCHAR(1000) not null,");
        stringBuilder.append("totalMinutes integer not null,");
        stringBuilder.append("deepMinutes integer not null,");
        stringBuilder.append("lightMinutes integer not null,");
        stringBuilder.append("awakeMinutes integer not null,");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sleepCurTime DATETIME  not null,");
        stringBuilder.append("sleepsDataDetail NVARCHAR(3000)  not null");
        stringBuilder.append(")");
        f17402a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sleepdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("sleeps NVARCHAR(1000) not null,");
        stringBuilder.append("totalMinutes integer not null,");
        stringBuilder.append("deepMinutes integer not null,");
        stringBuilder.append("lightMinutes integer not null,");
        stringBuilder.append("awakeMinutes integer not null,");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sleepCurTime DATETIME  not null,");
        stringBuilder.append("sleepsDataDetail NVARCHAR(3000) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("sleepsDataDetailInMin varchar(7500)");
        stringBuilder.append(")");
        f17403b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sleepdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("data varchar(30000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sleepCurTime DATETIME  not null");
        stringBuilder.append(")");
        f17404c = stringBuilder.toString();
    }

    public ai(Context context) {
        this.f17409g = context.getApplicationContext();
        this.f17408f = C4780m.m22870a(context);
    }

    public void m22798a() {
        this.f17408f.m22888b();
        this.f17407e = null;
    }

    public void m22800b() {
        if (this.f17407e == null) {
            this.f17407e = this.f17408f.m22886a();
        }
    }

    private void m22796b(aj ajVar) {
        if (ajVar == null) {
            C2538c.e("SleepDatasDB", new Object[]{"resetAwakeTime() error with mod = null"});
        } else if (ajVar.e > 0) {
            ajVar.e = 0;
            ajVar.b = ajVar.c + ajVar.d;
        }
    }

    public String m22797a(aj ajVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sleeps", ajVar.a);
            jSONObject.put("totalMinutes", ajVar.b);
            jSONObject.put("deepMinutes", ajVar.c);
            jSONObject.put("lightMinutes", ajVar.d);
            jSONObject.put("awakeMinutes", ajVar.e);
            jSONObject.put("sleepsDataDetail", ajVar.f);
            jSONObject.put("sleepsDataDetailInMin", ajVar.g);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b("SleepDatasDB", new Object[]{"DataToJson Exception=" + e.getMessage()});
            return "";
        }
    }

    private aj m22795a(String str) {
        aj ajVar = new aj();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("sleeps")) {
                ajVar.a = jSONObject.getString("sleeps");
            }
            if (!jSONObject.isNull("totalMinutes")) {
                ajVar.b = jSONObject.getInt("totalMinutes");
            }
            if (!jSONObject.isNull("deepMinutes")) {
                ajVar.c = jSONObject.getInt("deepMinutes");
            }
            if (!jSONObject.isNull("lightMinutes")) {
                ajVar.d = jSONObject.getInt("lightMinutes");
            }
            if (!jSONObject.isNull("awakeMinutes")) {
                ajVar.e = jSONObject.getInt("awakeMinutes");
            }
            if (!jSONObject.isNull("sleepsDataDetail")) {
                ajVar.f = jSONObject.getString("sleepsDataDetail");
            }
            if (!jSONObject.isNull("sleepsDataDetailInMin")) {
                ajVar.g = jSONObject.getString("sleepsDataDetailInMin");
            }
        } catch (JSONException e) {
            C2538c.e("SleepDatasDB", new Object[]{"JsonToData error message:" + e.getMessage()});
        }
        return ajVar;
    }

    public void m22799a(String str, String str2) {
        C2538c.c("SleepDatasDB", new Object[]{"initMigrationData() lastDay=", str2});
        try {
            m22800b();
            String[] strArr = new String[]{str, str2, String.valueOf(0), String.valueOf(1)};
            this.f17406d = this.f17407e.query("sleepdatas", f17405h, "userid= ? and (sleepCurTime> ? or isUpload= ? or isUpload = ?)", strArr, null, null, "sleepCurTime DESC");
        } catch (Exception e) {
            C2538c.e("SleepDatasDB", new Object[]{"initMigrationData() Exception=" + e.getMessage()});
        }
    }

    public ArrayList<aj> m22801c() {
        C2538c.c("SleepDatasDB", new Object[]{"getMigrateDatas() "});
        try {
            if (this.f17406d == null) {
                return null;
            }
            Cursor cursor = this.f17406d;
            ArrayList<aj> arrayList = new ArrayList();
            int i = 0;
            while (cursor.moveToNext()) {
                int i2 = i + 1;
                aj a = m22795a(C4775h.m22868e(this.f17409g, cursor.getString(cursor.getColumnIndex("data"))));
                a.f17410h = cursor.getInt(cursor.getColumnIndex("_id"));
                a.f17411i = cursor.getString(cursor.getColumnIndex("userid"));
                a.f17414l = C4799a.m22981b(this.f17409g, cursor.getString(cursor.getColumnIndex("mac")));
                a.f17412j = cursor.getInt(cursor.getColumnIndex("isUpload")) == 1;
                a.f17413k = cursor.getString(cursor.getColumnIndex("sleepCurTime"));
                a.f17415m = cursor.getInt(cursor.getColumnIndex("isUpload"));
                m22796b(a);
                arrayList.add(a);
                if (!i.a(57)) {
                    C2538c.c("SleepDatasDB", new Object[]{"getMigrateDatas() oversea "});
                } else if (i2 == 7) {
                    return arrayList;
                }
                i = i2;
            }
            return arrayList;
        } catch (Exception e) {
            C2538c.e("SleepDatasDB", new Object[]{"getDatas() Exception=" + e.getMessage()});
            return null;
        }
    }

    public void m22802d() {
        C2538c.c("SleepDatasDB", new Object[]{"uninitMigrationData() '"});
        if (this.f17406d != null) {
            this.f17406d.close();
        }
        m22798a();
    }
}
