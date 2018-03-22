package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.common.C4800b;
import com.huawei.hwdatamigrate.common.h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4977l;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.p190v.C2538c;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DataBaseHelper */
public class C4780m extends SQLiteOpenHelper {
    private static C4780m f17635c;
    SQLiteDatabase f17636a;
    private AtomicInteger f17637b = new AtomicInteger();
    private Context f17638d;

    public static C4780m m22870a(Context context) {
        C4780m c4780m;
        synchronized (C4780m.class) {
            if (f17635c == null) {
                f17635c = new C4780m(BaseApplication.b());
            }
            c4780m = f17635c;
        }
        return c4780m;
    }

    private C4780m(Context context) {
        super(context, "SportDatas.db", null, 29);
        this.f17638d = context;
    }

    protected synchronized SQLiteDatabase m22886a() {
        C2538c.b("DataBaseHelper_m", new Object[]{"Enter getDatabase mOpenCounter"});
        if (1 == this.f17637b.incrementAndGet()) {
            C2538c.b("DataBaseHelper_m", new Object[]{"mOpenCounter.incrementAndGet() is 1"});
            this.f17636a = getWritableDatabase();
        } else {
            C2538c.b("DataBaseHelper_m", new Object[]{"mOpenCounter.incrementAndGet() not 1"});
            if (this.f17636a == null) {
                C2538c.b("DataBaseHelper_m", new Object[]{"db is still null"});
            } else {
                C2538c.b("DataBaseHelper_m", new Object[]{"db is not null"});
            }
        }
        return this.f17636a;
    }

    protected synchronized void m22888b() {
        C2538c.b("DataBaseHelper_m", new Object[]{"Enter closeDatabase"});
        if (this.f17637b.decrementAndGet() == 0 && this.f17636a != null) {
            C2538c.b("DataBaseHelper_m", new Object[]{"Enter closeDatabase true"});
            this.f17636a.close();
            this.f17636a = null;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2538c.b("DataBaseHelper_m", new Object[]{"===www===onCreate() DATABASE_VERSION=29"});
        C4781n.m22889a().m22893a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2538c.b("DataBaseHelper_m", new Object[]{"onUpgrade: oldVersion = " + i + ", newVersion = " + i2});
        m22871a(i);
    }

    private void m22871a(int i) {
        int i2;
        if (1 == i) {
            C2538c.b("DataBaseHelper_m", new Object[]{"Destroying all old sleep data."});
            C4977l.m23909a(this.f17636a, "DROP TABLE IF EXISTS sleepdatas");
            C4977l.m23909a(this.f17636a, ai.f17402a);
            i2 = 2;
        } else {
            i2 = i;
        }
        if (2 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"Destroying all old sport data."});
            C4977l.m23909a(this.f17636a, "DROP TABLE IF EXISTS sportdatas");
            C4977l.m23909a(this.f17636a, am.f17456a);
            C2538c.b("DataBaseHelper_m", new Object[]{"create userid db."});
            C4977l.m23909a(this.f17636a, bc.f17551a);
            C2538c.b("DataBaseHelper_m", new Object[]{"init userid db."});
            m22887a(this.f17638d, this.f17636a);
            C2538c.b("DataBaseHelper_m", new Object[]{"reset user_id as default."});
            C4792y.m22919a(this.f17638d, "default_userid");
            i2 = 3;
        }
        if (3 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=3."});
            i2 = 4;
        }
        if (4 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=4."});
            C4977l.m23909a(this.f17636a, "DROP TABLE IF EXISTS sleeptotal");
            C2538c.b("DataBaseHelper_m", new Object[]{"create sleep-total table to record sleep data of band."});
            C4977l.m23909a(this.f17636a, ak.f17417a);
            C2538c.b("DataBaseHelper_m", new Object[]{"create sport-total table to record sport data of band."});
            C4977l.m23909a(this.f17636a, ar.f17486a);
            i2 = 5;
        }
        if (5 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=5."});
            m22872a(this.f17636a);
            C2538c.b("DataBaseHelper_m", new Object[]{"create ClearCommandFailedDB."});
            C4977l.m23909a(this.f17636a, C4777j.f17627b);
            i2 = 6;
        }
        m22873b(i2);
    }

    private void m22873b(int i) {
        int i2;
        if (6 == i) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=6."});
            m22876c(this.f17636a);
            i2 = 7;
        } else {
            i2 = i;
        }
        if (7 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=7."});
            m22874b(this.f17636a);
            m22878d(this.f17636a);
            i2 = 8;
        }
        if (8 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version=8."});
            C2538c.b("DataBaseHelper_m", new Object[]{"create MultAlarmClockDB."});
            C4977l.m23909a(this.f17636a, ac.f17379a);
            i2 = 9;
        }
        if (9 == i2) {
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN runStepsDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN runMetersDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN runCaloriesDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN rideStepsDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN rideMetersDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN rideCaloriesDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN climbStepsDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN climbMetersDataDetailInMin varchar(7500);");
            C4977l.m23909a(this.f17636a, "ALTER TABLE sportdatas ADD COLUMN climbCaloriesDataDetailInMin varchar(7500);");
            i2 = 10;
        }
        if (10 == i2) {
            m22880e(this.f17636a);
            i2 = 11;
        }
        m22875c(i2);
    }

    private void m22875c(int i) {
        int i2;
        if (11 == i) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 12 , create DeviceDatasDB."});
            C4977l.m23909a(this.f17636a, C4783p.f17646a);
            C4781n.m22889a().m22894b(this.f17636a);
            i2 = 12;
        } else {
            i2 = i;
        }
        if (12 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 13 , sporttarget add two column."});
            m22882f(this.f17636a);
            i2 = 13;
        }
        if (13 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 14 , recreate deviceDatasDB."});
            m22883g(this.f17636a);
            i2 = 14;
        }
        if (14 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 14, convert the sleep data"});
            C4781n.m22889a().m22895c(this.f17636a);
            i2 = 15;
        }
        if (15 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 15+ , HeartDatasDB add"});
            C4977l.m23909a(this.f17636a, C4789v.f17706a);
            i2 = 16;
        }
        m22877d(i2);
    }

    private void m22877d(int i) {
        int i2;
        if (16 == i) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 16+ , AltitudeDatasDB add"});
            C4977l.m23909a(this.f17636a, C4773f.f17614a);
            i2 = 17;
        } else {
            i2 = i;
        }
        if (17 == i2) {
            m22884h(this.f17636a);
            i2 = 18;
        }
        if (18 == i2) {
            C4977l.m23909a(this.f17636a, aw.f17511a);
            i2 = 19;
        }
        if (19 == i2) {
            m22885i(this.f17636a);
            i2 = 20;
        }
        if (20 == i2) {
            C4793z.m22920a().m22927g(this.f17636a);
            i2 = 21;
        }
        m22879e(i2);
    }

    private void m22879e(int i) {
        int i2;
        if (21 == i) {
            C4781n.m22889a().m22896d(this.f17636a);
            i2 = 22;
        } else {
            i2 = i;
        }
        if (22 == i2) {
            C4781n.m22889a().m22897e(this.f17636a);
            i2 = 23;
        }
        if (23 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 23+ , MemberDatasDB add"});
            C4793z.m22920a().m22928h(this.f17636a);
            i2 = 24;
        }
        if (24 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 24+ , QQHealthDB add"});
            C4793z.m22920a().m22929i(this.f17636a);
            i2 = 25;
        }
        if (25 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 25+ , GeminiContact add"});
            C4793z.m22920a().m22930j(this.f17636a);
            i2 = 26;
        }
        m22881f(i2);
    }

    private void m22881f(int i) {
        int i2;
        if (26 == i) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 26+ , MotionPathDB add"});
            C4793z.m22920a().m22931k(this.f17636a);
            C4793z.m22920a().m22932l(this.f17636a);
            i2 = 27;
        } else {
            i2 = i;
        }
        if (27 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 27+ , recreate MotionPathDB"});
            C4793z.m22920a().m22933m(this.f17636a);
            i2 = 28;
        }
        if (28 == i2) {
            C2538c.b("DataBaseHelper_m", new Object[]{"version = 28+ , create MotionPathDB"});
            C4793z.m22920a().m22934n(this.f17636a);
        }
    }

    public void m22887a(Context context, SQLiteDatabase sQLiteDatabase) {
        bd bdVar = new bd();
        bdVar.f17556a = -1;
        bdVar.f17557b = "default_userid";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("userid", bdVar.f17557b);
            if (-1 == sQLiteDatabase.insert("userid", null, contentValues)) {
                C2538c.e("DataBaseHelper_m", new Object[]{"initUseridDB() failed"});
                return;
            }
            C2538c.b("DataBaseHelper_m", new Object[]{"initUseridDB() ok"});
        } catch (Exception e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"initUseridDB() Exception=" + e.getMessage()});
        }
    }

    private void m22872a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN mac NVARCHAR(128);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN stepsDataDetailInMin varchar(7500);");
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sportdatas", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    C4977l.m23910a(sQLiteDatabase, "update sportdatas set stepsDataDetailInMin=? where _id=?", new Object[]{C4800b.m22988c(rawQuery.getString(rawQuery.getColumnIndex("steps"))), Integer.valueOf(i)});
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sleepdatas ADD COLUMN mac NVARCHAR(128);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sleepdatas ADD COLUMN sleepsDataDetailInMin varchar(7500);");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"upgradeDB2Version6 Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22874b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN metersDataDetailInMin varchar(7500);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN caloriesDataDetailInMin varchar(7500);");
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sportdatas", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    C4977l.m23910a(sQLiteDatabase, "update sportdatas set metersDataDetailInMin=? where _id=?", new Object[]{C4800b.m22988c(rawQuery.getString(rawQuery.getColumnIndex("meters"))), Integer.valueOf(i)});
                    C4977l.m23910a(sQLiteDatabase, "update sportdatas set caloriesDataDetailInMin=? where _id=?", new Object[]{C4800b.m22989d(rawQuery.getString(rawQuery.getColumnIndex("calories"))), Integer.valueOf(i)});
                }
                rawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"upgradeDB2Version8 Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22876c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from userinfo", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    String str = "update userinfo set gender=? where _id=?";
                    if (1 == rawQuery.getInt(rawQuery.getColumnIndex(UserInfo.GENDER))) {
                        C4977l.m23910a(sQLiteDatabase, str, new Object[]{Integer.valueOf(0), String.valueOf(i)});
                    } else {
                        C4977l.m23910a(sQLiteDatabase, str, new Object[]{Integer.valueOf(1), String.valueOf(i)});
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"updateUserInfoGender Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22878d(SQLiteDatabase sQLiteDatabase) {
        C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() enter"});
        sQLiteDatabase.beginTransaction();
        try {
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() insert columns..."});
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN portrait NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN nick NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN email NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN mobile NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN birthday integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN unit_type integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN location NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN hobby NVARCHAR(300);");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE userinfo ADD COLUMN description NVARCHAR(300);");
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() update columns value..."});
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from userinfo", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    int i2 = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                    int i3 = rawQuery.getInt(rawQuery.getColumnIndex("height_type"));
                    C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() while() id=" + i + ", iAge=" + i2 + ", iHeightType=" + i3});
                    C4977l.m23910a(sQLiteDatabase, "update userinfo set birthday=? , unit_type=?  where _id=?", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)});
                }
                rawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() finally..."});
            sQLiteDatabase.endTransaction();
        } catch (SQLException e) {
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() SQLException=" + e.getMessage()});
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage() + e.getMessage()});
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() finally..."});
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() finally..."});
            sQLiteDatabase.endTransaction();
        }
        C2538c.b("DataBaseHelper_m", new Object[]{"updateUserInfoDB2Version8() leave"});
    }

    private void m22880e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalWalkSteps integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalWalkDistance integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalWalkCalories integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRunSteps integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRunDistance integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRunCalories integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRideSteps integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRideDistance integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalRideCalories integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalClimbSteps integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalClimbDistance integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttotal ADD COLUMN totalClimbCalories integer;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"upgradeDB2Version11 Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22882f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttarget ADD COLUMN targetCalorie integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sporttarget ADD COLUMN targetDistance integer;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"upgradeDB2Version13 Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22883g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE devicedatas");
            C4977l.m23909a(sQLiteDatabase, C4783p.f17646a);
            h.a(this.f17638d, 0);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22884h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS userconfig");
            C4977l.m23909a(sQLiteDatabase, az.f17524a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m22885i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4793z.m22920a().m22921a(sQLiteDatabase);
            C4793z.m22920a().m22922b(sQLiteDatabase);
            C4793z.m22920a().m22923c(sQLiteDatabase);
            C4793z.m22920a().m22924d(sQLiteDatabase);
            C4793z.m22920a().m22925e(sQLiteDatabase);
            C4793z.m22920a().m22926f(sQLiteDatabase);
            ae.m22789a().m22790a(sQLiteDatabase);
            ae.m22789a().m22791b(sQLiteDatabase);
            ae.m22789a().m22792c(sQLiteDatabase);
            ae.m22789a().m22793d(sQLiteDatabase);
            ae.m22789a().m22794e(sQLiteDatabase);
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS exceptionfiles");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
