package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.database.SQLException;
import com.huawei.p190v.C2538c;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: MigrateSqlUtil */
public class C4977l {
    public static void m23911a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"doExecSQL2 SQLException:" + e.getMessage() + "  sql:" + str});
        } catch (Exception e2) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"doExecSQL2 Exception:" + e2.getMessage() + "  sql:" + str});
        }
    }

    public static void m23909a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLException e) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"doExecSQL1 SQLException:" + e.getMessage() + "  sql:" + str});
        } catch (Exception e2) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"doExecSQL1 Exception:" + e2.getMessage() + "  sql:" + str});
        }
    }

    public static void m23910a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        try {
            sQLiteDatabase.execSQL(str, objArr);
        } catch (SQLException e) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"SQLException:" + e.getMessage() + "  sql:" + str});
        } catch (Exception e2) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"Exception:" + e2.getMessage() + "  sql:" + str});
        }
    }
}
