package com.fenda.p255a.p256a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fenda.hwbracelet.mode.C3627j;
import com.huawei.p190v.C2538c;

/* compiled from: DBSettingInfoManager */
public class C3568d {
    String f13638a = "settingInfo";
    String f13639b = "sportremindstatus";
    String f13640c = "sptremindtime";
    String f13641d = "sptremindamstarttime";
    String f13642e = "sptremindamendtime";
    String f13643f = "sptremindpmstarttime";
    String f13644g = "sptremindpmendtime";
    String f13645h = "sptremindday";
    String f13646i = "sleepremindstarttime";
    String f13647j = "sleepremindendtime";
    String f13648k = "callstatus";
    String f13649l = "callremindstarttime";
    String f13650m = "callremindendtime";
    String f13651n = "antiloststatus";
    String f13652o = "lostdistance";
    String f13653p = "highlightstatus";
    String f13654q = "remotehandstatus";
    private C3567c f13655r;
    private SQLiteDatabase f13656s;
    private final Object f13657t = new Object();

    public C3568d(Context context) {
        this.f13655r = C3567c.m17910a(context);
    }

    public void m17916a(C3627j c3627j) {
        synchronized (this.f13657t) {
            try {
                if (m17913b()) {
                    return;
                }
                this.f13656s.execSQL("delete from " + this.f13638a);
                ContentValues contentValues = new ContentValues();
                contentValues.put(this.f13639b, Integer.valueOf(c3627j.m18165a()));
                contentValues.put(this.f13640c, Integer.valueOf(c3627j.m18168b()));
                contentValues.put(this.f13641d, c3627j.m18171c());
                contentValues.put(this.f13642e, c3627j.m18174d());
                contentValues.put(this.f13643f, c3627j.m18177e());
                contentValues.put(this.f13644g, c3627j.m18180f());
                contentValues.put(this.f13645h, Integer.valueOf(c3627j.m18189i()));
                contentValues.put(this.f13646i, c3627j.m18183g());
                contentValues.put(this.f13647j, c3627j.m18186h());
                contentValues.put(this.f13648k, Integer.valueOf(c3627j.m18190j()));
                contentValues.put(this.f13649l, c3627j.m18191k());
                contentValues.put(this.f13650m, c3627j.m18192l());
                contentValues.put(this.f13651n, Integer.valueOf(c3627j.m18193m()));
                contentValues.put(this.f13652o, Integer.valueOf(c3627j.m18194n()));
                contentValues.put(this.f13653p, Integer.valueOf(c3627j.m18195o()));
                contentValues.put(this.f13654q, Integer.valueOf(c3627j.m18196p()));
                long insert = this.f13656s.insert(this.f13638a, null, contentValues);
                C2538c.b("DBSettingInfoManager", new Object[]{"the return value " + insert});
                m17914c();
            } catch (Exception e) {
                C2538c.b("DBSettingInfoManager", new Object[]{"the Exception " + e.getMessage()});
            }
        }
    }

    public C3627j m17915a() {
        Exception e;
        C3627j c3627j = null;
        synchronized (this.f13657t) {
            C3627j c3627j2;
            try {
                if (m17913b()) {
                } else {
                    c3627j2 = new C3627j();
                    try {
                        Cursor rawQuery = this.f13656s.rawQuery("SELECT * FROM " + this.f13638a, null);
                        if (rawQuery.getCount() == 0) {
                            C2538c.e("DBSettingInfoManager", new Object[]{"setting info is null in the database"});
                            rawQuery.close();
                            m17914c();
                        } else {
                            while (rawQuery.moveToNext()) {
                                c3627j2.m18166a(rawQuery.getInt(rawQuery.getColumnIndex(this.f13639b)));
                                c3627j2.m18169b(rawQuery.getInt(rawQuery.getColumnIndex(this.f13640c)));
                                c3627j2.m18167a(rawQuery.getString(rawQuery.getColumnIndex(this.f13641d)));
                                c3627j2.m18170b(rawQuery.getString(rawQuery.getColumnIndex(this.f13642e)));
                                c3627j2.m18173c(rawQuery.getString(rawQuery.getColumnIndex(this.f13643f)));
                                c3627j2.m18176d(rawQuery.getString(rawQuery.getColumnIndex(this.f13644g)));
                                c3627j2.m18172c(rawQuery.getInt(rawQuery.getColumnIndex(this.f13645h)));
                                c3627j2.m18179e(rawQuery.getString(rawQuery.getColumnIndex(this.f13646i)));
                                c3627j2.m18182f(rawQuery.getString(rawQuery.getColumnIndex(this.f13647j)));
                                c3627j2.m18175d(rawQuery.getInt(rawQuery.getColumnIndex(this.f13648k)));
                                c3627j2.m18185g(rawQuery.getString(rawQuery.getColumnIndex(this.f13649l)));
                                c3627j2.m18188h(rawQuery.getString(rawQuery.getColumnIndex(this.f13650m)));
                                c3627j2.m18178e(rawQuery.getInt(rawQuery.getColumnIndex(this.f13651n)));
                                c3627j2.m18181f(rawQuery.getInt(rawQuery.getColumnIndex(this.f13652o)));
                                c3627j2.m18184g(rawQuery.getInt(rawQuery.getColumnIndex(this.f13653p)));
                                c3627j2.m18187h(rawQuery.getInt(rawQuery.getColumnIndex(this.f13654q)));
                            }
                            rawQuery.close();
                            m17914c();
                            c3627j = c3627j2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            } catch (Exception e3) {
                Exception exception = e3;
                c3627j2 = null;
                e = exception;
                C2538c.b("DBSettingInfoManager", new Object[]{"the Exception " + e.getMessage()});
                c3627j = c3627j2;
                return c3627j;
            }
        }
        return c3627j;
    }

    private boolean m17913b() {
        boolean z;
        synchronized (this.f13657t) {
            if (this.f13656s == null) {
                this.f13656s = this.f13655r.m17911a();
                if (this.f13656s == null) {
                    Log.e("DBSettingInfoManager", "Error occur, db == null");
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private void m17914c() {
        synchronized (this.f13657t) {
            this.f13655r.m17912b();
            this.f13656s = null;
        }
    }
}
