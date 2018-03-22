package com.fenda.p255a.p256a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fenda.hwbracelet.mode.C3623f;
import com.huawei.p190v.C2538c;

/* compiled from: DBDevInfoManager */
public class C3566b {
    String f13593a = "device";
    String f13594b = "name";
    String f13595c = "mac";
    String f13596d = "firmware";
    String f13597e = "stware";
    private C3567c f13598f;
    private SQLiteDatabase f13599g;
    private final Object f13600h = new Object();

    public C3566b(Context context) {
        this.f13598f = C3567c.m17910a(context);
    }

    public void m17906a(C3623f c3623f) {
        synchronized (this.f13600h) {
            try {
                if (m17903b()) {
                    return;
                }
                this.f13599g.execSQL("delete from " + this.f13593a);
                ContentValues contentValues = new ContentValues();
                contentValues.put(this.f13594b, c3623f.m18156b());
                contentValues.put(this.f13595c, c3623f.m18154a());
                contentValues.put(this.f13596d, c3623f.m18158c());
                contentValues.put(this.f13597e, c3623f.m18160d());
                long insert = this.f13599g.insert(this.f13593a, null, contentValues);
                C2538c.c("DBSettingInfoManager", new Object[]{"insert devInfo：" + insert});
                m17904c();
            } catch (Exception e) {
            }
        }
    }

    public C3623f m17905a() {
        C3623f c3623f = null;
        synchronized (this.f13600h) {
            try {
                if (m17903b()) {
                } else {
                    C3623f c3623f2 = new C3623f();
                    try {
                        Cursor rawQuery = this.f13599g.rawQuery("SELECT * FROM " + this.f13593a, null);
                        if (rawQuery.getCount() == 0) {
                            C2538c.e("DBSettingInfoManager", new Object[]{"deviceinfo is null in the database"});
                            rawQuery.close();
                            m17904c();
                        } else {
                            while (rawQuery.moveToNext()) {
                                c3623f2.m18157b(rawQuery.getString(rawQuery.getColumnIndex(this.f13594b)));
                                c3623f2.m18155a(rawQuery.getString(rawQuery.getColumnIndex(this.f13595c)));
                                c3623f2.m18159c(rawQuery.getString(rawQuery.getColumnIndex(this.f13596d)));
                                c3623f2.m18161d(rawQuery.getString(rawQuery.getColumnIndex(this.f13597e)));
                            }
                            rawQuery.close();
                            m17904c();
                            c3623f = c3623f2;
                        }
                    } catch (Exception e) {
                        c3623f = c3623f2;
                    }
                }
            } catch (Exception e2) {
            }
        }
        return c3623f;
    }

    public void m17907a(String str) {
        synchronized (this.f13600h) {
            C3623f a = m17905a();
            if (a == null) {
                a = new C3623f();
            }
            a.m18155a(str);
            m17906a(a);
        }
    }

    public void m17908b(String str) {
        synchronized (this.f13600h) {
            C3623f a = m17905a();
            if (a == null) {
                return;
            }
            a.m18159c(str);
            m17906a(a);
        }
    }

    public void m17909c(String str) {
        synchronized (this.f13600h) {
            C3623f a = m17905a();
            if (a == null) {
                return;
            }
            a.m18161d(str);
            m17906a(a);
        }
    }

    private boolean m17903b() {
        boolean z;
        synchronized (this.f13600h) {
            if (this.f13599g == null) {
                this.f13599g = this.f13598f.m17911a();
                if (this.f13599g == null) {
                    Log.e("DBSettingInfoManager", "Error occur, db == null");
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private void m17904c() {
        synchronized (this.f13600h) {
            this.f13598f.m17912b();
            this.f13599g = null;
        }
    }
}
