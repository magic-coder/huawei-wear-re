package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4977l;
import com.huawei.p190v.C2538c;

/* compiled from: MDataBaseUtil */
public class C4793z {
    private static C4793z f17717a;
    private Context f17718b;

    public static C4793z m22920a() {
        C4793z c4793z;
        synchronized (C4793z.class) {
            if (f17717a == null) {
                f17717a = new C4793z(BaseApplication.b());
            }
            c4793z = f17717a;
        }
        return c4793z;
    }

    private C4793z(Context context) {
        this.f17718b = context;
    }

    public void m22921a(SQLiteDatabase sQLiteDatabase) {
        String str = "sportdatas_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table sportdatas rename to " + str);
        C4977l.m23909a(sQLiteDatabase, am.f17457b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                an anVar = new an();
                anVar.a = rawQuery.getString(rawQuery.getColumnIndex("stepsDataDetailInMin"));
                anVar.b = rawQuery.getString(rawQuery.getColumnIndex("metersDataDetailInMin"));
                anVar.c = rawQuery.getString(rawQuery.getColumnIndex("caloriesDataDetailInMin"));
                anVar.d = rawQuery.getString(rawQuery.getColumnIndex("runStepsDataDetailInMin"));
                anVar.e = rawQuery.getString(rawQuery.getColumnIndex("runMetersDataDetailInMin"));
                anVar.f = rawQuery.getString(rawQuery.getColumnIndex("runCaloriesDataDetailInMin"));
                anVar.g = rawQuery.getString(rawQuery.getColumnIndex("rideStepsDataDetailInMin"));
                anVar.h = rawQuery.getString(rawQuery.getColumnIndex("rideMetersDataDetailInMin"));
                anVar.i = rawQuery.getString(rawQuery.getColumnIndex("rideCaloriesDataDetailInMin"));
                anVar.j = rawQuery.getString(rawQuery.getColumnIndex("climbStepsDataDetailInMin"));
                anVar.k = rawQuery.getString(rawQuery.getColumnIndex("climbMetersDataDetailInMin"));
                anVar.l = rawQuery.getString(rawQuery.getColumnIndex("climbCaloriesDataDetailInMin"));
                anVar.m = rawQuery.getInt(rawQuery.getColumnIndex("RunTimeTotal"));
                anVar.n = rawQuery.getInt(rawQuery.getColumnIndex("RidingTimeTotal"));
                anVar.o = rawQuery.getInt(rawQuery.getColumnIndex("ClimbTimeTotal"));
                anVar.p = rawQuery.getInt(rawQuery.getColumnIndex("WalkTimeTotal"));
                anVar.q = rawQuery.getString(rawQuery.getColumnIndex("steps"));
                anVar.r = rawQuery.getString(rawQuery.getColumnIndex("meters"));
                anVar.s = rawQuery.getString(rawQuery.getColumnIndex("calories"));
                anVar.t = rawQuery.getInt(rawQuery.getColumnIndex("totalSteps"));
                anVar.u = rawQuery.getInt(rawQuery.getColumnIndex("totalDistance"));
                anVar.v = rawQuery.getInt(rawQuery.getColumnIndex("totalCalories"));
                anVar.w = rawQuery.getInt(rawQuery.getColumnIndex("sportduration"));
                anVar.x = rawQuery.getInt(rawQuery.getColumnIndex("RunStepTotal"));
                anVar.y = rawQuery.getInt(rawQuery.getColumnIndex("RunDistanceTotal"));
                anVar.z = rawQuery.getInt(rawQuery.getColumnIndex("RunCalorieTotal"));
                anVar.A = rawQuery.getInt(rawQuery.getColumnIndex("RidingDistanceTotal"));
                anVar.B = rawQuery.getInt(rawQuery.getColumnIndex("RidingCalorieTotal"));
                anVar.C = rawQuery.getInt(rawQuery.getColumnIndex("ClimbStepTotal"));
                anVar.E = rawQuery.getInt(rawQuery.getColumnIndex("ClimbCalorieTotal"));
                anVar.F = rawQuery.getInt(rawQuery.getColumnIndex("WalkStepTotal"));
                anVar.G = rawQuery.getInt(rawQuery.getColumnIndex("WalkDistanceTotal"));
                anVar.H = rawQuery.getInt(rawQuery.getColumnIndex("WalkCalorieTotal"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new am(this.f17718b).m22808a(anVar)));
                contentValues.put("isUpload", rawQuery.getString(rawQuery.getColumnIndex("isUpload")));
                contentValues.put("sportcurTime", rawQuery.getString(rawQuery.getColumnIndex("sportcurTime")));
                sQLiteDatabase.insert("sportdatas", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22922b(SQLiteDatabase sQLiteDatabase) {
        String str = "sporttotal_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table sporttotal rename to " + str);
        C4977l.m23909a(sQLiteDatabase, ar.f17487b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                an anVar = new an();
                anVar.q = rawQuery.getString(rawQuery.getColumnIndex("steps"));
                anVar.r = rawQuery.getString(rawQuery.getColumnIndex("meters"));
                anVar.s = rawQuery.getString(rawQuery.getColumnIndex("calories"));
                anVar.t = rawQuery.getInt(rawQuery.getColumnIndex("totalSteps"));
                anVar.u = rawQuery.getInt(rawQuery.getColumnIndex("totalDistance"));
                anVar.v = rawQuery.getInt(rawQuery.getColumnIndex("totalCalories"));
                anVar.w = rawQuery.getInt(rawQuery.getColumnIndex("sportduration"));
                anVar.x = rawQuery.getInt(rawQuery.getColumnIndex("totalRunSteps"));
                anVar.y = rawQuery.getInt(rawQuery.getColumnIndex("totalRunDistance"));
                anVar.z = rawQuery.getInt(rawQuery.getColumnIndex("totalRunCalories"));
                anVar.A = rawQuery.getInt(rawQuery.getColumnIndex("totalRideDistance"));
                anVar.B = rawQuery.getInt(rawQuery.getColumnIndex("totalRideCalories"));
                anVar.C = rawQuery.getInt(rawQuery.getColumnIndex("totalClimbSteps"));
                anVar.E = rawQuery.getInt(rawQuery.getColumnIndex("totalClimbCalories"));
                anVar.F = rawQuery.getInt(rawQuery.getColumnIndex("totalWalkSteps"));
                anVar.G = rawQuery.getInt(rawQuery.getColumnIndex("totalWalkDistance"));
                anVar.H = rawQuery.getInt(rawQuery.getColumnIndex("totalWalkCalories"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new ar(this.f17718b).m22819a(anVar)));
                contentValues.put("isUpload", rawQuery.getString(rawQuery.getColumnIndex("isUpload")));
                contentValues.put("sportcurTime", rawQuery.getString(rawQuery.getColumnIndex("sportcurTime")));
                sQLiteDatabase.insert("sporttotal", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22923c(SQLiteDatabase sQLiteDatabase) {
        String str = "sleepdatas_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table sleepdatas rename to " + str);
        C4977l.m23909a(sQLiteDatabase, ai.f17404c);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                aj ajVar = new aj();
                ajVar.a = rawQuery.getString(rawQuery.getColumnIndex("sleeps"));
                ajVar.b = rawQuery.getInt(rawQuery.getColumnIndex("totalMinutes"));
                ajVar.c = rawQuery.getInt(rawQuery.getColumnIndex("deepMinutes"));
                ajVar.d = rawQuery.getInt(rawQuery.getColumnIndex("lightMinutes"));
                ajVar.e = rawQuery.getInt(rawQuery.getColumnIndex("awakeMinutes"));
                ajVar.f = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail"));
                ajVar.g = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetailInMin"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new ai(this.f17718b).m22797a(ajVar)));
                contentValues.put("isUpload", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("isUpload"))));
                contentValues.put("sleepCurTime", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("sleepCurTime"))));
                sQLiteDatabase.insert("sleepdatas", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22924d(SQLiteDatabase sQLiteDatabase) {
        String str = "sleeptotal_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table sleeptotal rename to " + str);
        C4977l.m23909a(sQLiteDatabase, ak.f17418b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                aj ajVar = new aj();
                ajVar.a = rawQuery.getString(rawQuery.getColumnIndex("sleeps"));
                ajVar.b = rawQuery.getInt(rawQuery.getColumnIndex("totalMinutes"));
                ajVar.c = rawQuery.getInt(rawQuery.getColumnIndex("deepMinutes"));
                ajVar.d = rawQuery.getInt(rawQuery.getColumnIndex("lightMinutes"));
                ajVar.e = rawQuery.getInt(rawQuery.getColumnIndex("awakeMinutes"));
                ajVar.f = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new ak(this.f17718b).m22804a(ajVar)));
                contentValues.put("isUpload", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("isUpload"))));
                contentValues.put("sleepCurTime", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("sleepCurTime"))));
                sQLiteDatabase.insert("sleeptotal", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22925e(SQLiteDatabase sQLiteDatabase) {
        String str = "devicedatas_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table devicedatas rename to " + str);
        C4977l.m23909a(sQLiteDatabase, C4783p.f17647b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4784q c4784q = new C4784q();
                c4784q.a = rawQuery.getString(rawQuery.getColumnIndex("TypeDetailInMin"));
                c4784q.b = rawQuery.getString(rawQuery.getColumnIndex("TotalStepDetailInMin"));
                c4784q.c = rawQuery.getString(rawQuery.getColumnIndex("TotalDistanceDetailInMin"));
                c4784q.d = rawQuery.getString(rawQuery.getColumnIndex("TotalCalorieDetailInMin"));
                c4784q.e = rawQuery.getString(rawQuery.getColumnIndex("SleepStatusDetailInMin"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new C4783p(this.f17718b).m22898a(c4784q)));
                contentValues.put("CurDate", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("CurDate"))));
                sQLiteDatabase.insert("devicedatas", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22926f(SQLiteDatabase sQLiteDatabase) {
        String str = "userconfig_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table userconfig rename to " + str);
        C4977l.m23909a(sQLiteDatabase, az.f17525b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                ba baVar = new ba();
                baVar.a = rawQuery.getInt(rawQuery.getColumnIndex("opencloud"));
                baVar.b = rawQuery.getString(rawQuery.getColumnIndex("accessToken"));
                baVar.c = rawQuery.getInt(rawQuery.getColumnIndex("login_type"));
                baVar.d = rawQuery.getInt(rawQuery.getColumnIndex("login_time"));
                baVar.e = rawQuery.getInt(rawQuery.getColumnIndex("expire_time"));
                baVar.f = rawQuery.getString(rawQuery.getColumnIndex("userID_Login"));
                baVar.g = rawQuery.getString(rawQuery.getColumnIndex("accessToken_Login"));
                baVar.h = rawQuery.getString(rawQuery.getColumnIndex("userName_Login"));
                contentValues.put("data", C4775h.m22867d(this.f17718b, new az(this.f17718b).m22827a(baVar)));
                sQLiteDatabase.insert("userconfig", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22927g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, as.f17491a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22928h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, aa.f17376b);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22929i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, ag.f17393a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22930j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS geminicontact");
            C4977l.m23909a(sQLiteDatabase, C4785r.f17689a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22931k(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, ab.f17377a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22932l(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("geminicontact", C4785r.m22899d(), null, null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int i = query.getInt(query.getColumnIndex("_id"));
                    String string = query.getString(query.getColumnIndex("username"));
                    String string2 = query.getString(query.getColumnIndex("userid"));
                    String string3 = query.getString(query.getColumnIndex("usernumber"));
                    String string4 = query.getString(query.getColumnIndex("numbertype"));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("userid", string2);
                    contentValues.put("username", C4775h.m22867d(this.f17718b, string));
                    contentValues.put("usernumber", C4775h.m22867d(this.f17718b, string3));
                    contentValues.put("numbertype", C4775h.m22867d(this.f17718b, string4));
                    String[] strArr = new String[]{String.valueOf(i)};
                    sQLiteDatabase.update("geminicontact", contentValues, "_id= ?", strArr);
                }
            }
            if (query != null) {
                query.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{"SQLException Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22933m(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE sporttrack");
            C4977l.m23909a(sQLiteDatabase, ab.f17377a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22934n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, af.f17391a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("MDataBaseUtil", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
