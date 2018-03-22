package com.fenda.p255a.p256a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.p190v.C2538c;

/* compiled from: DBHelper */
public class C3567c extends SQLiteOpenHelper {
    private static String f13601J = "FENDA_HEALTH_ADAPTER.db";
    private static C3567c f13602K;
    public static int f13603a = 2;
    static SQLiteDatabase f13604b;
    String f13605A = "_thu";
    String f13606B = "_fri";
    String f13607C = "_sta";
    String f13608D = "_onoff";
    String f13609E = "device";
    String f13610F = "name";
    String f13611G = "mac";
    String f13612H = "firmware";
    String f13613I = "stware";
    String f13614c = "settingInfo";
    String f13615d = "sportremindstatus";
    String f13616e = "sptremindtime";
    String f13617f = "sptremindamstarttime";
    String f13618g = "sptremindamendtime";
    String f13619h = "sptremindpmstarttime";
    String f13620i = "sptremindpmendtime";
    String f13621j = "sptremindday";
    String f13622k = "sleepremindstarttime";
    String f13623l = "sleepremindendtime";
    String f13624m = "callstatus";
    String f13625n = "callremindstarttime";
    String f13626o = "callremindendtime";
    String f13627p = "antiloststatus";
    String f13628q = "lostdistance";
    String f13629r = "highlightstatus";
    String f13630s = "remotehandstatus";
    String f13631t = "alarm";
    String f13632u = "_name";
    String f13633v = "_time";
    String f13634w = "_sun";
    String f13635x = "_mon";
    String f13636y = "_tue";
    String f13637z = "_wed";

    public static C3567c m17910a(Context context) {
        C3567c c3567c;
        synchronized (C3567c.class) {
            if (f13602K == null) {
                f13602K = new C3567c(context);
            }
            c3567c = f13602K;
        }
        return c3567c;
    }

    private C3567c(Context context) {
        super(context, f13601J, null, f13603a);
    }

    public SQLiteDatabase m17911a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (C3567c.class) {
            if (f13604b == null || !f13604b.isOpen()) {
                f13604b = getWritableDatabase();
                sQLiteDatabase = f13604b;
            } else {
                sQLiteDatabase = f13604b;
            }
        }
        return sQLiteDatabase;
    }

    public void m17912b() {
        synchronized (C3567c.class) {
            if (!(f13604b == null || !f13604b.isOpen() || f13604b.isDbLockedByCurrentThread())) {
                f13604b.close();
                f13604b = null;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2538c.c("DBHelper", new Object[]{"onCreate"});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS ").append(this.f13614c).append("(").append(this.f13615d).append(" INT, ").append(this.f13616e).append(" INT, ").append(this.f13617f).append(" VARCHAR(5), ").append(this.f13618g).append(" VARCHAR(5), ").append(this.f13619h).append(" VARCHAR(5), ").append(this.f13620i).append(" VARCHAR(5), ").append(this.f13621j).append(" INT, ").append(this.f13622k).append(" VARCHAR(5), ").append(this.f13623l).append(" VARCHAR(5), ").append(this.f13624m).append(" INT, ").append(this.f13625n).append(" VARCHAR(5), ").append(this.f13626o).append(" VARCHAR(5), ").append(this.f13629r).append(" INT, ").append(this.f13630s).append(" INT, ").append(this.f13627p).append(" INT, ").append(this.f13628q).append(" INT ); ");
        sQLiteDatabase.execSQL(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS ").append(this.f13631t).append("(").append("id").append(" INTEGER PRIMARY KEY AUTOINCREMENT ,").append(this.f13632u).append(" VARCHAR(30), ").append(this.f13633v).append(" VARCHAR(5), ").append(this.f13634w).append(" INT, ").append(this.f13635x).append(" INT, ").append(this.f13636y).append(" INT, ").append(this.f13637z).append(" INT, ").append(this.f13605A).append(" INT, ").append(this.f13606B).append(" INT, ").append(this.f13607C).append(" INT, ").append(this.f13608D).append(" INT ); ");
        sQLiteDatabase.execSQL(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS ").append(this.f13609E).append("(").append(this.f13610F).append(" VARCHAR(20), ").append(this.f13611G).append(" VARCHAR(30), ").append(this.f13612H).append(" VARCHAR(20), ").append(this.f13613I).append(" VARCHAR(20) ); ");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE " + this.f13614c + " ADD COLUMN " + this.f13629r + " INT");
                sQLiteDatabase.execSQL("ALTER TABLE " + this.f13614c + " ADD COLUMN " + this.f13630s + " INT");
                return;
            default:
                return;
        }
    }
}
