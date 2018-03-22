package com.huawei.hwdatamigrate.hihealth.p409b.p410a;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;

/* compiled from: HiHealthDBHelper */
final class C4806b implements SQLiteDatabaseHook {
    C4806b() {
    }

    public void preKey(SQLiteDatabase sQLiteDatabase) {
    }

    public void postKey(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.rawExecSQL("PRAGMA journal_mode = WAL;");
    }
}
