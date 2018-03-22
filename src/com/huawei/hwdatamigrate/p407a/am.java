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

/* compiled from: SportDatasDB */
public class am {
    public static final String f17456a;
    public static final String f17457b;
    private static final String[] f17458g = new String[]{"_id", "userid", "mac", "data", "isUpload", "sportcurTime"};
    Cursor f17459c = null;
    private SQLiteDatabase f17460d;
    private C4780m f17461e;
    private Context f17462f;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sportdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("data varchar(60000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sportcurTime DATETIME not null");
        stringBuilder.append(")");
        f17457b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sportdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("steps NVARCHAR(1000) not null,");
        stringBuilder.append("meters NVARCHAR(1000) not null,");
        stringBuilder.append("calories NVARCHAR(1000) not null,");
        stringBuilder.append("totalSteps integer not null,");
        stringBuilder.append("totalDistance integer not null,");
        stringBuilder.append("totalCalories integer not null,");
        stringBuilder.append("sportduration integer not null,");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sportcurTime DATETIME  not null");
        stringBuilder.append(")");
        f17456a = stringBuilder.toString();
    }

    public am(Context context) {
        this.f17462f = context.getApplicationContext();
        this.f17461e = C4780m.m22870a(context);
    }

    public void m22809a() {
        if (this.f17460d == null) {
            this.f17460d = this.f17461e.m22886a();
        }
    }

    public void m22811b() {
        this.f17461e.m22888b();
        this.f17460d = null;
    }

    public String m22808a(an anVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stepsDataDetailInMin", anVar.a);
            jSONObject.put("metersDataDetailInMin", anVar.b);
            jSONObject.put("caloriesDataDetailInMin", anVar.c);
            jSONObject.put("runStepsDataDetailInMin", anVar.d);
            jSONObject.put("runMetersDataDetailInMin", anVar.e);
            jSONObject.put("runCaloriesDataDetailInMin", anVar.f);
            jSONObject.put("rideStepsDataDetailInMin", anVar.g);
            jSONObject.put("rideMetersDataDetailInMin", anVar.h);
            jSONObject.put("rideCaloriesDataDetailInMin", anVar.i);
            jSONObject.put("climbStepsDataDetailInMin", anVar.j);
            jSONObject.put("climbMetersDataDetailInMin", anVar.k);
            jSONObject.put("climbCaloriesDataDetailInMin", anVar.l);
            jSONObject.put("totalRunTime", anVar.m);
            jSONObject.put("totalRideTime", anVar.n);
            jSONObject.put("totalClimbTime", anVar.o);
            jSONObject.put("totalWalkTime", anVar.p);
            jSONObject.put("steps", anVar.q);
            jSONObject.put("meters", anVar.r);
            jSONObject.put("calories", anVar.s);
            jSONObject.put("totalSteps", anVar.t);
            jSONObject.put("totalDistance", anVar.u);
            jSONObject.put("totalCalories", anVar.v);
            jSONObject.put("sportDuration", anVar.w);
            jSONObject.put("totalRunSteps", anVar.x);
            jSONObject.put("totalRunDistance", anVar.y);
            jSONObject.put("totalRunCalories", anVar.z);
            jSONObject.put("totalRideDistance", anVar.A);
            jSONObject.put("totalRideCalories", anVar.B);
            jSONObject.put("totalClimbSteps", anVar.C);
            jSONObject.put("totalClimbHeight", anVar.D);
            jSONObject.put("totalClimbCalories", anVar.E);
            jSONObject.put("totalWalkSteps", anVar.F);
            jSONObject.put("totalWalkDistance", anVar.G);
            jSONObject.put("totalWalkCalories", anVar.H);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b("SportDatasDB", new Object[]{"DataToJson Exception=" + e.getMessage()});
            return "";
        }
    }

    private an m22806a(String str) {
        an anVar = new an();
        try {
            JSONObject jSONObject = new JSONObject(str);
            anVar.a = m22807b(jSONObject, "stepsDataDetailInMin");
            anVar.b = m22807b(jSONObject, "metersDataDetailInMin");
            anVar.c = m22807b(jSONObject, "caloriesDataDetailInMin");
            anVar.d = m22807b(jSONObject, "runStepsDataDetailInMin");
            anVar.e = m22807b(jSONObject, "runMetersDataDetailInMin");
            anVar.f = m22807b(jSONObject, "runCaloriesDataDetailInMin");
            anVar.g = m22807b(jSONObject, "rideStepsDataDetailInMin");
            anVar.h = m22807b(jSONObject, "rideMetersDataDetailInMin");
            anVar.i = m22807b(jSONObject, "rideCaloriesDataDetailInMin");
            anVar.j = m22807b(jSONObject, "climbStepsDataDetailInMin");
            anVar.k = m22807b(jSONObject, "climbMetersDataDetailInMin");
            anVar.l = m22807b(jSONObject, "climbCaloriesDataDetailInMin");
            anVar.m = m22805a(jSONObject, "totalRunTime");
            anVar.n = m22805a(jSONObject, "totalRideTime");
            anVar.o = m22805a(jSONObject, "totalClimbTime");
            anVar.p = m22805a(jSONObject, "totalWalkTime");
            anVar.q = m22807b(jSONObject, "steps");
            anVar.r = m22807b(jSONObject, "meters");
            anVar.s = m22807b(jSONObject, "calories");
            anVar.t = m22805a(jSONObject, "totalSteps");
            anVar.u = m22805a(jSONObject, "totalDistance");
            anVar.v = m22805a(jSONObject, "totalCalories");
            anVar.w = m22805a(jSONObject, "sportDuration");
            anVar.x = m22805a(jSONObject, "totalRunSteps");
            anVar.y = m22805a(jSONObject, "totalRunDistance");
            anVar.z = m22805a(jSONObject, "totalRunCalories");
            anVar.A = m22805a(jSONObject, "totalRideDistance");
            anVar.B = m22805a(jSONObject, "totalRideCalories");
            anVar.C = m22805a(jSONObject, "totalClimbSteps");
            anVar.D = m22805a(jSONObject, "totalClimbHeight");
            anVar.E = m22805a(jSONObject, "totalClimbCalories");
            anVar.F = m22805a(jSONObject, "totalWalkSteps");
            anVar.G = m22805a(jSONObject, "totalWalkDistance");
            anVar.H = m22805a(jSONObject, "totalWalkCalories");
        } catch (JSONException e) {
            C2538c.e("SportDatasDB", new Object[]{"JsonToData error message:" + e.getMessage()});
        }
        return anVar;
    }

    public void m22810a(String str, String str2) {
        C2538c.c("SportDatasDB", new Object[]{"initMigrationData() lastDay ==", str2});
        try {
            m22809a();
            String[] strArr = new String[]{str, str2, String.valueOf(0), String.valueOf(1)};
            this.f17459c = this.f17460d.query("sportdatas", f17458g, "userid= ? and (sportcurTime> ? or isUpload= ? or isUpload = ?)", strArr, null, null, "sportcurTime DESC");
        } catch (Exception e) {
            C2538c.e("SportDatasDB", new Object[]{"initMigrationData() Exception ==" + e.getMessage()});
        }
    }

    public ArrayList<an> m22812c() {
        C2538c.c("SportDatasDB", new Object[]{"getMigrateDatas() "});
        try {
            if (this.f17459c == null) {
                m22811b();
                return null;
            }
            ArrayList<an> arrayList = new ArrayList();
            Cursor cursor = this.f17459c;
            int i = 0;
            while (cursor.moveToNext()) {
                int i2 = i + 1;
                an a = m22806a(C4775h.m22868e(this.f17462f, cursor.getString(cursor.getColumnIndex("data"))));
                a.f17463I = cursor.getInt(cursor.getColumnIndex("_id"));
                a.f17464J = cursor.getString(cursor.getColumnIndex("userid"));
                a.f17467M = C4799a.m22981b(this.f17462f, cursor.getString(cursor.getColumnIndex("mac")));
                a.f17465K = cursor.getInt(cursor.getColumnIndex("isUpload")) == 1;
                a.f17466L = cursor.getString(cursor.getColumnIndex("sportcurTime"));
                a.f17468N = cursor.getInt(cursor.getColumnIndex("isUpload"));
                arrayList.add(a);
                if (!i.a(57)) {
                    C2538c.c("SportDatasDB", new Object[]{"getMigrateDatas() oversea !"});
                } else if (i2 == 7) {
                    return arrayList;
                }
                i = i2;
            }
            return arrayList;
        } catch (Exception e) {
            C2538c.e("SportDatasDB", new Object[]{"getDatas() Exception ==" + e.getMessage()});
            return null;
        }
    }

    private int m22805a(JSONObject jSONObject, String str) {
        int i = 0;
        try {
            if (!jSONObject.isNull(str)) {
                i = jSONObject.getInt(str);
            }
        } catch (JSONException e) {
            C2538c.e("SportDatasDB", new Object[]{"JsonToData " + str + "error message:" + e.getMessage()});
        }
        return i;
    }

    public void m22813d() {
        C2538c.c("SportDatasDB", new Object[]{"uninitMigrationData() '"});
        if (this.f17459c != null) {
            this.f17459c.close();
        }
        m22811b();
    }

    private String m22807b(JSONObject jSONObject, String str) {
        String str2 = null;
        try {
            if (!jSONObject.isNull(str)) {
                str2 = jSONObject.getString(str);
            }
        } catch (JSONException e) {
            C2538c.e("SportDatasDB", new Object[]{"JsonToData " + str + "error message:" + e.getMessage()});
        }
        return str2;
    }
}
