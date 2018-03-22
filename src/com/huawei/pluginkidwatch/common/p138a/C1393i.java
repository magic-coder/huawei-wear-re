package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DataBaseHelper */
public class C1393i extends SQLiteOpenHelper {
    private static C1393i f3071c;
    private SQLiteDatabase f3072a;
    private AtomicInteger f3073b = new AtomicInteger();
    private Context f3074d;

    public static C1393i m6319a(Context context) {
        C1393i c1393i;
        synchronized (C1393i.class) {
            if (f3071c == null && context != null) {
                f3071c = new C1393i(BaseApplication.m2632b());
            }
            c1393i = f3071c;
        }
        return c1393i;
    }

    private C1393i(Context context) {
        super(context, "KidWatch.db", null, 9);
        this.f3074d = context;
    }

    public SQLiteDatabase m6327a() {
        if (1 == this.f3073b.incrementAndGet()) {
            C2538c.m12674b("DataBaseHelper", "==========getDatabase");
            synchronized (C1393i.class) {
                this.f3072a = getWritableDatabase();
            }
        }
        if (this.f3072a == null) {
            C2538c.m12674b("DataBaseHelper", "==========getDatabase, db is null");
        }
        return this.f3072a;
    }

    public void m6328b() {
        synchronized (C1393i.class) {
            if (this.f3073b.decrementAndGet() == 0) {
                C2538c.m12674b("DataBaseHelper", "==========closeDatabase, make db null");
                this.f3072a.close();
                this.f3072a = null;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2538c.m12674b("DataBaseHelper", "onCreate() DATABASE_VERSION=9");
        try {
            sQLiteDatabase.execSQL(C1394j.f3075a);
            sQLiteDatabase.execSQL(ac.f3013a);
            sQLiteDatabase.execSQL(C1400p.f3140a);
            sQLiteDatabase.execSQL(C1391g.f3065a);
            sQLiteDatabase.execSQL(C1407w.f3181a);
            sQLiteDatabase.execSQL(C1405u.f3174a);
            sQLiteDatabase.execSQL(C1406v.f3180b);
            sQLiteDatabase.execSQL(C1398n.f3120a);
            sQLiteDatabase.execSQL(C1409y.f3205a);
            sQLiteDatabase.execSQL(C1389e.f3054a);
            sQLiteDatabase.execSQL(C1385a.f2980a);
            sQLiteDatabase.execSQL(aa.f2984a);
            sQLiteDatabase.execSQL(C1396l.f3104a);
            sQLiteDatabase.execSQL(C1387c.f3035a);
            sQLiteDatabase.execSQL(C1402r.f3157a);
        } catch (SQLiteException e) {
            C2538c.m12674b("DataBaseHelper", "onCreate() SQLiteException e !!!");
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "onCreate Exception e = " + e2.getMessage());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3;
        C2538c.m12674b("DataBaseHelper", "onUpgrade: oldVersion = " + i + ", newVersion = " + i2);
        C2538c.m12674b("DataBaseHelper", "=========Aversion:", i + "");
        if (2 == i) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "2");
            m6320a(sQLiteDatabase);
            i3 = 3;
        } else {
            i3 = i;
        }
        if (3 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "3");
            m6321b(sQLiteDatabase);
            i3 = 4;
        }
        if (4 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "4");
            m6322c(sQLiteDatabase);
            i3 = 5;
        }
        if (5 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "5");
            m6323d(sQLiteDatabase);
            i3 = 6;
        }
        if (6 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "6");
            m6324e(sQLiteDatabase);
            i3 = 7;
        }
        if (7 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "7");
            m6325f(sQLiteDatabase);
            i3 = 8;
        }
        if (8 == i3) {
            C2538c.m12674b("DataBaseHelper", "=========Aversion:", "8");
            m6326g(sQLiteDatabase);
        }
    }

    private void m6320a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS deviceinfo");
            sQLiteDatabase.execSQL(C1394j.f3075a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS watchstatustable");
            sQLiteDatabase.execSQL(ac.f3013a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS trackinfo");
            sQLiteDatabase.execSQL(C1407w.f3181a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom2To3 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom2To3 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6321b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            String str = "rewardreach_temp";
            sQLiteDatabase.execSQL("alter table rewardreach rename to " + str);
            sQLiteDatabase.execSQL(C1405u.f3174a);
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    C2538c.m12674b("DataBaseHelper", "=========A");
                    C1404t c1404t = new C1404t();
                    c1404t.m6405a(rawQuery.getString(rawQuery.getColumnIndex("deviceCode")));
                    c1404t.m6407b(rawQuery.getString(rawQuery.getColumnIndex("hope")));
                    c1404t.m6409c(rawQuery.getString(rawQuery.getColumnIndex("goalnum")));
                    c1404t.m6411d(rawQuery.getString(rawQuery.getColumnIndex("name")));
                    c1404t.m6413e("");
                    c1404t.m6415f(rawQuery.getString(rawQuery.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                    c1404t.m6417g(rawQuery.getString(rawQuery.getColumnIndex("data1")));
                    c1404t.m6419h(rawQuery.getString(rawQuery.getColumnIndex("data2")));
                    c1404t.m6421i(rawQuery.getString(rawQuery.getColumnIndex("data3")));
                    c1404t.m6424k(rawQuery.getString(rawQuery.getColumnIndex("data5")));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("deviceCode", c1404t.m6404a());
                    contentValues.put("goalnum", C1392h.m6317j(this.f3074d, c1404t.m6408c()));
                    contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1404t.m6412e());
                    contentValues.put("name", C1392h.m6317j(this.f3074d, c1404t.m6410d()));
                    contentValues.put("hope", C1392h.m6317j(this.f3074d, c1404t.m6406b()));
                    contentValues.put("data1", C1392h.m6317j(this.f3074d, c1404t.m6414f()));
                    contentValues.put("data2", C1392h.m6317j(this.f3074d, c1404t.m6416g()));
                    contentValues.put("data3", C1392h.m6317j(this.f3074d, c1404t.m6418h()));
                    contentValues.put("data4", C1392h.m6317j(this.f3074d, c1404t.m6420i()));
                    contentValues.put("data5", C1392h.m6317j(this.f3074d, c1404t.m6422j()));
                    sQLiteDatabase.insert("rewardreach", null, contentValues);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notificationhistory");
            sQLiteDatabase.execSQL(C1400p.f3140a);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS NewSportTotalDatas");
            sQLiteDatabase.execSQL(C1398n.f3120a);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS allcontact");
            sQLiteDatabase.execSQL(C1391g.f3065a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom3To4 SQLException", e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom3To4 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6322c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS trackinfo");
            sQLiteDatabase.execSQL(C1407w.f3181a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom4To5 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom4To5 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6323d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS checkversiontable");
            sQLiteDatabase.execSQL(C1389e.f3054a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom5To6 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom5To6 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6324e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(C1385a.f2980a);
            sQLiteDatabase.execSQL(aa.f2984a);
            sQLiteDatabase.execSQL(C1396l.f3104a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS ability_set_table");
            sQLiteDatabase.execSQL(C1385a.f2980a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS voice_table_1");
            sQLiteDatabase.execSQL(aa.f2984a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS family_memberdb");
            sQLiteDatabase.execSQL(C1396l.f3104a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom6To7 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom6To7 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6325f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS billinfo");
            sQLiteDatabase.execSQL(C1387c.f3035a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom7To8 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom7To8 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void m6326g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS voice_table_1");
            sQLiteDatabase.execSQL(aa.f2984a);
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS pushAbility");
            sQLiteDatabase.execSQL(C1402r.f3157a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom8To9 SQLException ex = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("DataBaseHelper", "changeDbFrom8To9 Exception e = " + e2.getMessage());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
