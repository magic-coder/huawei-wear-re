package com.huawei.hwdataaccessmodel.db;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.db.backup.C4765b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.o.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

/* compiled from: DataBaseHelper */
public class C4764b extends SQLiteOpenHelper {
    private static String f17350a = "";
    private static Context f17351b;
    private static String f17352c = "";
    private static Map<String, C4764b> f17353e = new HashMap();
    private static String f17354f;
    private static int f17355g;
    private static byte[] f17356h = new byte[1];
    private SQLiteDatabase f17357d;

    public static C4764b m22772a(Context context, String str) {
        C4764b c4764b;
        synchronized (f17356h) {
            f17351b = context;
            f17352c = str;
            if (TextUtils.isEmpty(f17354f)) {
                try {
                    f17354f = new String(c.a(14), GameManager.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e) {
                    C2538c.e("DataBaseHelper", new Object[]{"UnsupportedEncodingException : " + e.getMessage()});
                    throw new RuntimeException("UnsupportedEncodingException");
                } catch (Exception e2) {
                    C2538c.e("DataBaseHelper", new Object[]{"getSecurityKey Exception: " + e2.getMessage()});
                }
            }
            if (f17353e.get(str) == null) {
                SQLiteDatabase.loadLibs(BaseApplication.b());
                f17350a = BaseApplication.b().getPackageName();
                if (TextUtils.isEmpty(f17350a)) {
                    f17350a = "SportDatas.db";
                } else {
                    f17350a = f17350a.replaceAll("\\.", HwAccountConstants.SPLIIT_UNDERLINE) + str + ".db";
                }
                f17353e.put(str, new C4764b(BaseApplication.b(), f17350a));
            }
            c4764b = (C4764b) f17353e.get(str);
        }
        return c4764b;
    }

    private C4764b(Context context, String str) {
        super(context, str, null, 103);
    }

    public static int m22771a() {
        int i;
        synchronized (f17356h) {
            i = f17355g;
        }
        return i;
    }

    public static void m22773a(int i) {
        synchronized (f17356h) {
            f17355g = i;
        }
    }

    public SQLiteDatabase m22774b() {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (f17356h) {
            try {
                if (this.f17357d != null) {
                    sQLiteDatabase = this.f17357d;
                } else if (TextUtils.isEmpty(f17354f)) {
                    C2538c.b("DataBaseHelper", new Object[]{"xxxxyyy null"});
                } else {
                    C2538c.b("DataBaseHelper", new Object[]{"xxxxyyy maha:", f17354f});
                    this.f17357d = getWritableDatabase(f17354f);
                    sQLiteDatabase = this.f17357d;
                }
            } catch (SQLiteException e) {
                C2538c.b("DataBaseHelper", new Object[]{"xxxxyyy Exception "});
                try {
                    this.f17357d = C4765b.m22777a(f17351b, f17352c).m22778a();
                    sQLiteDatabase = this.f17357d;
                } catch (Exception e2) {
                    C2538c.b("DataBaseHelper", new Object[]{"xxxxyyy Exception2 "});
                }
            } catch (Exception e3) {
                C2538c.b("DataBaseHelper", new Object[]{"xxxxyyy Exception3 "});
            }
        }
        return sQLiteDatabase;
    }

    public void m22775c() {
        synchronized (f17356h) {
            if (this.f17357d == null) {
                this.f17357d = m22774b();
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (f17356h) {
            try {
                C2538c.c("DataBaseHelper", new Object[]{"onUpgrade enter oldVersion=" + i + ",newVersion" + i2 + ",dbName=" + f17350a});
                C4764b.m22773a(i);
                Intent intent = new Intent();
                intent.setAction("com.huawei.dbhelper.database.upgrade");
                BaseApplication.b().sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
                C2538c.c("DataBaseHelper", new Object[]{"onUpgrade sendBroadcast ACTION_DBDATABASE_UPGRADE LocalBroadcast.PERMISSION_LOCAL_BROADCAST!"});
                if (101 == i && "com_huawei_bone8.db".equals(f17350a)) {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                    while (rawQuery.moveToNext()) {
                        C2538c.c("DataBaseHelper", new Object[]{"table name = " + rawQuery.getString(0)});
                    }
                    rawQuery.close();
                    sQLiteDatabase.execSQL("ALTER TABLE module_8_event_alarm RENAME TO module_8_event_alarm_temp");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS module_8_event_alarm(event_alarm_index integer,event_alarm_enable integer,event_alarm_time varchar(50),event_alarm_cycle integer,event_alarm_name varchar(50),User_ID varchar(50))");
                    sQLiteDatabase.execSQL("insert into module_8_event_alarm(event_alarm_index,event_alarm_enable,event_alarm_time,event_alarm_cycle,event_alarm_name,User_ID) select event_alarm_index,event_alarm_enable,event_alarm_time,event_alarm_cycle,event_alarm_name,User_ID from module_8_event_alarm_temp");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS module_8_event_alarm_temp");
                    sQLiteDatabase.execSQL("ALTER TABLE module_8_smart_alarm RENAME TO module_8_smart_alarm_temp");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS module_8_smart_alarm(smart_alarm_index integer,smart_alarm_enable integer,smart_alarm_time varchar(50),smart_alarm_cycle integer,smart_alarm_ahead_time integer,User_ID varchar(50))");
                    sQLiteDatabase.execSQL("insert into module_8_smart_alarm(smart_alarm_index,smart_alarm_enable,smart_alarm_time,smart_alarm_cycle,smart_alarm_ahead_time,User_ID) select     smart_alarm_index,smart_alarm_enable,smart_alarm_time,smart_alarm_cycle,smart_alarm_ahead_time,User_ID from module_8_smart_alarm_temp");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS module_8_smart_alarm_temp");
                    C2538c.c("DataBaseHelper", new Object[]{"alarm db upgrade"});
                }
            } catch (Exception e) {
                C2538c.e("DataBaseHelper", new Object[]{"enter onUpgrade Exception;", e.getMessage()});
            }
        }
    }

    public void m22776d() {
        synchronized (C4764b.class) {
            C2538c.b("DataBaseHelper", new Object[]{"hwdataaccessmodel closeDatabase, make db null"});
            if (this.f17357d != null) {
                this.f17357d.close();
                this.f17357d = null;
            }
        }
    }
}
