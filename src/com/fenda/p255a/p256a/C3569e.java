package com.fenda.p255a.p256a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import com.fenda.hwbracelet.mode.C3629l;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: DBUtils */
public class C3569e {
    private static C3569e f13658c = null;
    private static final Object f13659d = new Object();
    private C3570f f13660a;
    private SQLiteDatabase f13661b = this.f13660a.getWritableDatabase();

    public C3569e(Context context) {
        this.f13660a = new C3570f(context);
        m17923d();
    }

    public static C3569e m17917a(Context context) {
        C3569e c3569e;
        synchronized (f13659d) {
            if (f13658c == null && context != null) {
                f13658c = new C3569e(context);
            }
            c3569e = f13658c;
        }
        return c3569e;
    }

    public void m17920a(ArrayList<C3629l> arrayList, long j, long j2) {
        synchronized (f13659d) {
            if (m17918e()) {
                C2538c.e("DBUtils", new Object[]{"Database insert error!  db == null"});
                return;
            }
            this.f13661b.execSQL("delete from " + C3570f.f13662a + " where " + C3570f.f13663b + " between " + j + " and " + j2);
            this.f13661b.beginTransaction();
            for (int i = 0; i < arrayList.size(); i++) {
                C3629l c3629l = (C3629l) arrayList.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put(C3570f.f13663b, Long.valueOf(c3629l.m18198a()));
                contentValues.put(C3570f.f13664c, Integer.valueOf(c3629l.m18199b()));
                contentValues.put(C3570f.f13665d, Integer.valueOf(c3629l.m18200c()));
                long insert = this.f13661b.insert(C3570f.f13662a, null, contentValues);
                C2538c.c("DBUtils", new Object[]{"uid: " + insert});
            }
            this.f13661b.setTransactionSuccessful();
            this.f13661b.endTransaction();
            m17923d();
        }
    }

    public void m17919a() {
        synchronized (f13659d) {
            if (m17918e()) {
                C2538c.e("DBUtils", new Object[]{"Database delete error!  db == null"});
                return;
            }
            int delete = this.f13661b.delete(C3570f.f13662a, null, null);
            C2538c.c("DBUtils", new Object[]{"数据库delete_result: " + delete});
            m17923d();
        }
    }

    public ArrayList<C3629l> m17921b() {
        ArrayList<C3629l> arrayList;
        synchronized (f13659d) {
            if (m17918e()) {
                C2538c.e("DBUtils", new Object[]{"Database query error!  db == null"});
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                Cursor c = m17922c();
                if (c != null) {
                    while (c.moveToNext()) {
                        arrayList.add(new C3629l(c.getLong(c.getColumnIndex(C3570f.f13663b)), c.getInt(c.getColumnIndex(C3570f.f13664c)), c.getInt(c.getColumnIndex(C3570f.f13665d))));
                    }
                    c.close();
                }
                m17923d();
            }
        }
        return arrayList;
    }

    private boolean m17918e() {
        synchronized (f13659d) {
            if (this.f13661b == null) {
                try {
                    this.f13661b = this.f13660a.getWritableDatabase();
                } catch (SQLiteDiskIOException e) {
                    C2538c.c("DBUtils", new Object[]{"dbIsNull ERROR :" + e.getMessage()});
                }
                if (this.f13661b == null) {
                    C2538c.c("DBUtils", new Object[]{"null == db"});
                    return true;
                }
            }
            return false;
        }
    }

    public Cursor m17922c() {
        Cursor cursor = null;
        if (m17918e()) {
            C2538c.e("DBUtils", new Object[]{"Database close error!  db == null"});
        } else {
            synchronized (f13659d) {
                cursor = this.f13661b.rawQuery("SELECT * FROM sync_data", null);
            }
        }
        return cursor;
    }

    public void m17923d() {
        synchronized (f13659d) {
            if (this.f13661b == null) {
                C2538c.e("DBUtils", new Object[]{"Database close error!  db == null"});
                return;
            }
            this.f13661b.close();
            this.f13661b = null;
        }
    }
}
