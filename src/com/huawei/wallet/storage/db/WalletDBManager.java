package com.huawei.wallet.storage.db;

import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.ReentrantLock;

public final class WalletDBManager {
    private static volatile WalletDBHelper f21330a;
    private static volatile SQLiteDatabase f21331b;
    private static ReentrantLock f21332c = new ReentrantLock();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.sqlite.SQLiteDatabase m28129a() {
        /*
        r0 = f21331b;
        if (r0 != 0) goto L_0x001a;
    L_0x0004:
        r0 = f21332c;
        r0.lock();
        r0 = f21331b;	 Catch:{ SQLiteException -> 0x001d }
        if (r0 != 0) goto L_0x0015;
    L_0x000d:
        r0 = f21330a;	 Catch:{ SQLiteException -> 0x001d }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x001d }
        f21331b = r0;	 Catch:{ SQLiteException -> 0x001d }
    L_0x0015:
        r0 = f21332c;
        r0.unlock();
    L_0x001a:
        r0 = f21331b;
        return r0;
    L_0x001d:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r1.<init>();	 Catch:{ all -> 0x003b }
        r2 = "getDB SQLiteException:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x003b }
        r0 = r1.append(r0);	 Catch:{ all -> 0x003b }
        r0 = r0.toString();	 Catch:{ all -> 0x003b }
        r1 = 0;
        com.huawei.wallet.utils.log.LogC.m28530b(r0, r1);	 Catch:{ all -> 0x003b }
        r0 = f21332c;
        r0.unlock();
        goto L_0x001a;
    L_0x003b:
        r0 = move-exception;
        r1 = f21332c;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wallet.storage.db.WalletDBManager.a():android.database.sqlite.SQLiteDatabase");
    }

    private WalletDBManager() {
    }
}
