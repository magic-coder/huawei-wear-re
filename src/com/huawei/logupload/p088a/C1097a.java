package com.huawei.logupload.p088a;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.logupload.LogUpload;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;

/* compiled from: LoguploadTable */
public final class C1097a implements BaseColumns {
    public static void m4845a(SQLiteDatabase sQLiteDatabase) {
        String str = "CREATE TABLE IF NOT EXISTS t_logupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, transactionId LONG, sendType varchar(4), filePath varchar(256), fileSize LONG, encrypt varchar(4), privacy varchar(4), uploadFlags INTEGER, policy varchar(256), token varchar(256), secret varchar(256), uploadPath varchar(256), timeStamp varchar(256), callBackAddress varchar(256), uploadAddress varchar(256), uploadType INTEGER, contentRange varchar(256), refresh varchar(4), encryptFilePath varchar(256), channelId INTEGER, feedBackPackageName varchar(256), feedBackClassName varchar(256), userType INTEGER, zipTime varchar(256), logDetailInfo varchar(1024), productName varchar(256), romVersion varchar(256), isPause varchar(4), taskCreateTime LONG)";
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_logupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, transactionId LONG, sendType varchar(4), filePath varchar(256), fileSize LONG, encrypt varchar(4), privacy varchar(4), uploadFlags INTEGER, policy varchar(256), token varchar(256), secret varchar(256), uploadPath varchar(256), timeStamp varchar(256), callBackAddress varchar(256), uploadAddress varchar(256), uploadType INTEGER, contentRange varchar(256), refresh varchar(4), encryptFilePath varchar(256), channelId INTEGER, feedBackPackageName varchar(256), feedBackClassName varchar(256), userType INTEGER, zipTime varchar(256), logDetailInfo varchar(1024), productName varchar(256), romVersion varchar(256), isPause varchar(4), taskCreateTime LONG)");
            } catch (SQLException e) {
                C1103f.m4881e("LoguploadTable", "create table t_logupload Error");
            }
        }
    }

    public static synchronized long m4842a(C1098c c1098c, LogUpload logUpload) {
        long j;
        synchronized (C1097a.class) {
            SQLiteDatabase sQLiteDatabase = null;
            j = -1;
            try {
                sQLiteDatabase = c1098c.getWritableDatabase();
                j = C1097a.m4841a(sQLiteDatabase, logUpload);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e) {
                C1103f.m4881e("LoguploadTable", "insert table t_logupload Error!");
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m4847a(com.huawei.logupload.p088a.C1098c r5, com.huawei.logupload.LogUpload r6, boolean r7) {
        /*
        r2 = com.huawei.logupload.p088a.C1097a.class;
        monitor-enter(r2);
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0012, all -> 0x0024 }
        com.huawei.logupload.p088a.C1097a.m4846a(r0, r6, r7);	 Catch:{ SQLiteException -> 0x0012 }
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.close();	 Catch:{ all -> 0x0021 }
    L_0x0010:
        monitor-exit(r2);
        return;
    L_0x0012:
        r1 = move-exception;
        r1 = "LoguploadTable";
        r3 = "update table t_logupload Error!";
        com.huawei.logupload.p090c.C1103f.m4881e(r1, r3);	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0010;
    L_0x001d:
        r0.close();	 Catch:{ all -> 0x0021 }
        goto L_0x0010;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0024:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0028:
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1.close();	 Catch:{ all -> 0x0021 }
    L_0x002d:
        throw r0;	 Catch:{ all -> 0x0021 }
    L_0x002e:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.a.a.a(com.huawei.logupload.a.c, com.huawei.logupload.LogUpload, boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m4850b(com.huawei.logupload.p088a.C1098c r5, com.huawei.logupload.LogUpload r6) {
        /*
        r2 = com.huawei.logupload.p088a.C1097a.class;
        monitor-enter(r2);
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0012, all -> 0x0023 }
        com.huawei.logupload.p088a.C1097a.m4849b(r0, r6);	 Catch:{ SQLiteException -> 0x0012 }
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.close();	 Catch:{ all -> 0x0020 }
    L_0x0010:
        monitor-exit(r2);
        return;
    L_0x0012:
        r1 = move-exception;
        r1 = "LoguploadTable";
        r3 = "delete table t_logupload Error!";
        com.huawei.logupload.p090c.C1103f.m4881e(r1, r3);	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x0010;
    L_0x001c:
        r0.close();	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0023:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0027:
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();	 Catch:{ all -> 0x0020 }
    L_0x002c:
        throw r0;	 Catch:{ all -> 0x0020 }
    L_0x002d:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.a.a.b(com.huawei.logupload.a.c, com.huawei.logupload.LogUpload):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String m4843a(com.huawei.logupload.p088a.C1098c r11, java.lang.String r12) {
        /*
        r0 = 0;
        r9 = com.huawei.logupload.p088a.C1097a.class;
        monitor-enter(r9);
        r8 = "";
        r0 = r11.getReadableDatabase();	 Catch:{ SQLiteException -> 0x007a, all -> 0x0069 }
        if (r0 != 0) goto L_0x0015;
    L_0x000c:
        if (r0 == 0) goto L_0x0011;
    L_0x000e:
        r0.close();	 Catch:{ all -> 0x0066 }
    L_0x0011:
        r0 = "";
    L_0x0013:
        monitor-exit(r9);
        return r0;
    L_0x0015:
        r1 = "t_logupload";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r3 = 0;
        r4 = "isPause";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r3 = "transactionId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        if (r2 == 0) goto L_0x0082;
    L_0x0030:
        r1 = "isPause";
        r3 = r2.getColumnIndex(r1);	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r2.moveToFirst();	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r2.moveToFirst();	 Catch:{ SQLiteException -> 0x007e, all -> 0x0073 }
        r1 = r8;
    L_0x003d:
        r4 = r2.isAfterLast();	 Catch:{ SQLiteException -> 0x0055, all -> 0x0073 }
        if (r4 == 0) goto L_0x004d;
    L_0x0043:
        r2.close();	 Catch:{ SQLiteException -> 0x0055, all -> 0x0073 }
    L_0x0046:
        if (r0 == 0) goto L_0x004b;
    L_0x0048:
        r0.close();	 Catch:{ all -> 0x0066 }
    L_0x004b:
        r0 = r1;
        goto L_0x0013;
    L_0x004d:
        r1 = r2.getString(r3);	 Catch:{ SQLiteException -> 0x0055, all -> 0x0073 }
        r2.moveToNext();	 Catch:{ SQLiteException -> 0x0055, all -> 0x0073 }
        goto L_0x003d;
    L_0x0055:
        r2 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x0059:
        r2 = "LoguploadTable";
        r3 = "getPauseStauts Error";
        com.huawei.logupload.p090c.C1103f.m4880d(r2, r3);	 Catch:{ all -> 0x0078 }
        if (r1 == 0) goto L_0x0013;
    L_0x0062:
        r1.close();	 Catch:{ all -> 0x0066 }
        goto L_0x0013;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0069:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x006d:
        if (r1 == 0) goto L_0x0072;
    L_0x006f:
        r1.close();	 Catch:{ all -> 0x0066 }
    L_0x0072:
        throw r0;	 Catch:{ all -> 0x0066 }
    L_0x0073:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x006d;
    L_0x0078:
        r0 = move-exception;
        goto L_0x006d;
    L_0x007a:
        r1 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x0059;
    L_0x007e:
        r1 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x0059;
    L_0x0082:
        r1 = r8;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.a.a.a(com.huawei.logupload.a.c, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List<com.huawei.logupload.LogUpload> m4844a(com.huawei.logupload.p088a.C1098c r43) {
        /*
        r13 = com.huawei.logupload.p088a.C1097a.class;
        monitor-enter(r13);
        r4 = 0;
        r12 = new java.util.ArrayList;	 Catch:{ all -> 0x0348 }
        r5 = 100;
        r12.<init>(r5);	 Catch:{ all -> 0x0348 }
        r4 = r43.getReadableDatabase();	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b, all -> 0x035a }
        if (r4 != 0) goto L_0x0019;
    L_0x0011:
        if (r4 == 0) goto L_0x0016;
    L_0x0013:
        r4.close();	 Catch:{ all -> 0x0348 }
    L_0x0016:
        r4 = r12;
    L_0x0017:
        monitor-exit(r13);
        return r4;
    L_0x0019:
        r5 = "t_logupload";
        r6 = 29;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 0;
        r8 = "_id";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 1;
        r8 = "transactionId";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 2;
        r8 = "sendType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 3;
        r8 = "filePath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 4;
        r8 = "fileSize";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 5;
        r8 = "encrypt";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 6;
        r8 = "privacy";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 7;
        r8 = "uploadFlags";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 8;
        r8 = "policy";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 9;
        r8 = "token";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 10;
        r8 = "secret";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 11;
        r8 = "uploadPath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 12;
        r8 = "timeStamp";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 13;
        r8 = "callBackAddress";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 14;
        r8 = "uploadAddress";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 15;
        r8 = "uploadType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 16;
        r8 = "contentRange";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 17;
        r8 = "refresh";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 18;
        r8 = "encryptFilePath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 19;
        r8 = "channelId";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 20;
        r8 = "feedBackPackageName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 21;
        r8 = "feedBackClassName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 22;
        r8 = "userType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 23;
        r8 = "taskCreateTime";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 24;
        r8 = "zipTime";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 25;
        r8 = "logDetailInfo";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 26;
        r8 = "productName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 27;
        r8 = "romVersion";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 28;
        r8 = "isPause";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = "fileSize ASC";
        r6 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r6 == 0) goto L_0x0194;
    L_0x00d7:
        r5 = "_id";
        r7 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "transactionId";
        r8 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "sendType";
        r9 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "filePath";
        r10 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "fileSize";
        r11 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "encrypt";
        r14 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "privacy";
        r15 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "uploadFlags";
        r16 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "policy";
        r17 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "token";
        r18 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "secret";
        r19 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "uploadPath";
        r20 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "timeStamp";
        r21 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "callBackAddress";
        r22 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "uploadAddress";
        r23 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "uploadType";
        r24 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "contentRange";
        r25 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "encryptFilePath";
        r26 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "refresh";
        r27 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "channelId";
        r28 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "feedBackPackageName";
        r29 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "feedBackClassName";
        r30 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "userType";
        r31 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "taskCreateTime";
        r32 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "zipTime";
        r33 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "logDetailInfo";
        r34 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "productName";
        r35 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "romVersion";
        r36 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = "isPause";
        r37 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x018f:
        if (r5 != 0) goto L_0x019c;
    L_0x0191:
        r6.close();	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x0194:
        if (r4 == 0) goto L_0x0199;
    L_0x0196:
        r4.close();	 Catch:{ all -> 0x0348 }
    L_0x0199:
        r4 = r12;
        goto L_0x0017;
    L_0x019c:
        r38 = new com.huawei.logupload.LogUpload;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r38.<init>();	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = r6.getInt(r7);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = (long) r5;	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r40 = r0;
        r0 = r38;
        r1 = r40;
        r0.m4768a(r1);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r40 = r6.getLong(r8);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r1 = r40;
        r0.m4774b(r1);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x01d4;
    L_0x01c0:
        r5 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x032e;
    L_0x01ce:
        r5 = 1;
    L_0x01cf:
        r0 = r38;
        r0.m4771a(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x01d4:
        r5 = r6.getString(r10);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4793f(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r40 = r6.getLong(r11);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r1 = r40;
        r0.m4779c(r1);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x0202;
    L_0x01ee:
        r5 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x0331;
    L_0x01fc:
        r5 = 1;
    L_0x01fd:
        r0 = r38;
        r0.m4776b(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x0202:
        r5 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x021c;
    L_0x0208:
        r5 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x0334;
    L_0x0216:
        r5 = 1;
    L_0x0217:
        r0 = r38;
        r0.m4781c(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x021c:
        r0 = r16;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4767a(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r17;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4796g(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r18;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4799h(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r19;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4801i(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r20;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4803j(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r21;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4804k(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r22;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4807l(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r23;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4809m(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r24;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4773b(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r25;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4811n(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r26;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4813o(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r28;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4783d(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r29;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4815p(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r30;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4816q(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r31;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4788e(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r33;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4785d(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r34;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4789e(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r35;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4770a(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r36;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4775b(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r37;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r0.m4780c(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r27;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x0316;
    L_0x0300:
        r0 = r27;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        if (r5 == 0) goto L_0x0337;
    L_0x0310:
        r5 = 1;
    L_0x0311:
        r0 = r38;
        r0.m4786d(r5);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
    L_0x0316:
        r0 = r32;
        r40 = r6.getLong(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r1 = r40;
        r0.m4784d(r1);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r0 = r38;
        r12.add(r0);	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        r5 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x0339, Exception -> 0x034b }
        goto L_0x018f;
    L_0x032e:
        r5 = 0;
        goto L_0x01cf;
    L_0x0331:
        r5 = 0;
        goto L_0x01fd;
    L_0x0334:
        r5 = 0;
        goto L_0x0217;
    L_0x0337:
        r5 = 0;
        goto L_0x0311;
    L_0x0339:
        r5 = move-exception;
        r5 = "LoguploadTable";
        r6 = "query table t_logupload all cols Error";
        com.huawei.logupload.p090c.C1103f.m4881e(r5, r6);	 Catch:{ all -> 0x0366 }
        if (r4 == 0) goto L_0x0199;
    L_0x0343:
        r4.close();	 Catch:{ all -> 0x0348 }
        goto L_0x0199;
    L_0x0348:
        r4 = move-exception;
        monitor-exit(r13);
        throw r4;
    L_0x034b:
        r5 = move-exception;
        r5 = "LoguploadTable";
        r6 = "query table t_logupload all cols Error";
        com.huawei.logupload.p090c.C1103f.m4881e(r5, r6);	 Catch:{ all -> 0x0366 }
        if (r4 == 0) goto L_0x0199;
    L_0x0355:
        r4.close();	 Catch:{ all -> 0x0348 }
        goto L_0x0199;
    L_0x035a:
        r5 = move-exception;
        r42 = r5;
        r5 = r4;
        r4 = r42;
    L_0x0360:
        if (r5 == 0) goto L_0x0365;
    L_0x0362:
        r5.close();	 Catch:{ all -> 0x0348 }
    L_0x0365:
        throw r4;	 Catch:{ all -> 0x0348 }
    L_0x0366:
        r5 = move-exception;
        r42 = r5;
        r5 = r4;
        r4 = r42;
        goto L_0x0360;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.a.a.a(com.huawei.logupload.a.c):java.util.List<com.huawei.logupload.LogUpload>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.huawei.logupload.LogUpload m4848b(com.huawei.logupload.p088a.C1098c r41, java.lang.String r42) {
        /*
        r11 = com.huawei.logupload.p088a.C1097a.class;
        monitor-enter(r11);
        r2 = 0;
        r10 = 0;
        r2 = r41.getReadableDatabase();	 Catch:{ SQLiteException -> 0x02f6, all -> 0x030a }
        if (r2 != 0) goto L_0x0013;
    L_0x000b:
        if (r2 == 0) goto L_0x0010;
    L_0x000d:
        r2.close();	 Catch:{ all -> 0x0307 }
    L_0x0010:
        r2 = 0;
    L_0x0011:
        monitor-exit(r11);
        return r2;
    L_0x0013:
        r3 = "t_logupload";
        r4 = 29;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 0;
        r6 = "_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 1;
        r6 = "transactionId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 2;
        r6 = "sendType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 3;
        r6 = "filePath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 4;
        r6 = "fileSize";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 5;
        r6 = "encrypt";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 6;
        r6 = "privacy";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 7;
        r6 = "uploadFlags";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 8;
        r6 = "policy";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 9;
        r6 = "token";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 10;
        r6 = "secret";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 11;
        r6 = "uploadPath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 12;
        r6 = "timeStamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 13;
        r6 = "callBackAddress";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 14;
        r6 = "uploadAddress";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 15;
        r6 = "uploadType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 16;
        r6 = "contentRange";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 17;
        r6 = "refresh";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 18;
        r6 = "encryptFilePath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 19;
        r6 = "channelId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 20;
        r6 = "feedBackPackageName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 21;
        r6 = "feedBackClassName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 22;
        r6 = "userType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 23;
        r6 = "taskCreateTime";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 24;
        r6 = "zipTime";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 25;
        r6 = "logDetailInfo";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 26;
        r6 = "productName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 27;
        r6 = "romVersion";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = 28;
        r6 = "isPause";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r5 = "transactionId=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r7 = 0;
        r6[r7] = r42;	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r5 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        if (r5 == 0) goto L_0x032e;
    L_0x00d6:
        r3 = "_id";
        r6 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "transactionId";
        r7 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "sendType";
        r8 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "filePath";
        r9 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "fileSize";
        r12 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "encrypt";
        r13 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "privacy";
        r14 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "uploadFlags";
        r15 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "policy";
        r16 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "token";
        r17 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "secret";
        r18 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "uploadPath";
        r19 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "timeStamp";
        r20 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "callBackAddress";
        r21 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "uploadAddress";
        r22 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "uploadType";
        r23 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "contentRange";
        r24 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "encryptFilePath";
        r25 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "refresh";
        r26 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "channelId";
        r27 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "feedBackPackageName";
        r28 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "feedBackClassName";
        r29 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "userType";
        r30 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "taskCreateTime";
        r31 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "zipTime";
        r32 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "logDetailInfo";
        r33 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "productName";
        r34 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "romVersion";
        r35 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = "isPause";
        r36 = r5.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r3 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x031f, all -> 0x0316 }
        r4 = r10;
    L_0x018f:
        if (r3 != 0) goto L_0x019d;
    L_0x0191:
        r5.close();	 Catch:{ SQLiteException -> 0x032a, all -> 0x0316 }
        r3 = r4;
    L_0x0195:
        if (r2 == 0) goto L_0x019a;
    L_0x0197:
        r2.close();	 Catch:{ all -> 0x0307 }
    L_0x019a:
        r2 = r3;
        goto L_0x0011;
    L_0x019d:
        r3 = new com.huawei.logupload.LogUpload;	 Catch:{ SQLiteException -> 0x032a, all -> 0x0316 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x032a, all -> 0x0316 }
        r4 = r5.getInt(r6);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = (long) r4;	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r38 = r0;
        r0 = r38;
        r3.m4768a(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r38 = r5.getLong(r7);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r38;
        r3.m4774b(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r4 = r5.getString(r8);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x01cd;
    L_0x01bd:
        r4 = r5.getString(r8);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r10 = "1";
        r4 = r4.endsWith(r10);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x02eb;
    L_0x01c9:
        r4 = 1;
    L_0x01ca:
        r3.m4771a(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
    L_0x01cd:
        r4 = r5.getString(r9);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4793f(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r38 = r5.getLong(r12);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r38;
        r3.m4779c(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r4 = r5.getString(r13);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x01f3;
    L_0x01e3:
        r4 = r5.getString(r13);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r10 = "1";
        r4 = r4.endsWith(r10);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x02ee;
    L_0x01ef:
        r4 = 1;
    L_0x01f0:
        r3.m4776b(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
    L_0x01f3:
        r4 = r5.getString(r14);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x0209;
    L_0x01f9:
        r4 = r5.getString(r14);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r10 = "1";
        r4 = r4.endsWith(r10);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x02f1;
    L_0x0205:
        r4 = 1;
    L_0x0206:
        r3.m4781c(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
    L_0x0209:
        r4 = r5.getInt(r15);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4767a(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r16;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4796g(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r17;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4799h(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r18;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4801i(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r19;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4803j(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r20;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4804k(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r21;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4807l(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r22;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4809m(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r23;
        r4 = r5.getInt(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4773b(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r24;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4811n(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r25;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4813o(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r27;
        r4 = r5.getInt(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4783d(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r28;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4815p(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r29;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4816q(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r30;
        r4 = r5.getInt(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4788e(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r32;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4785d(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r33;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4789e(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r34;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4770a(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r35;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4775b(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r36;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r3.m4780c(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r26;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x02d5;
    L_0x02c3:
        r0 = r26;
        r4 = r5.getString(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r10 = "1";
        r4 = r4.endsWith(r10);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        if (r4 == 0) goto L_0x02f4;
    L_0x02d1:
        r4 = 1;
    L_0x02d2:
        r3.m4786d(r4);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
    L_0x02d5:
        r0 = r31;
        r38 = r5.getLong(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r0 = r38;
        r3.m4784d(r0);	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r4 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x0323, all -> 0x0316 }
        r40 = r4;
        r4 = r3;
        r3 = r40;
        goto L_0x018f;
    L_0x02eb:
        r4 = 0;
        goto L_0x01ca;
    L_0x02ee:
        r4 = 0;
        goto L_0x01f0;
    L_0x02f1:
        r4 = 0;
        goto L_0x0206;
    L_0x02f4:
        r4 = 0;
        goto L_0x02d2;
    L_0x02f6:
        r3 = move-exception;
        r3 = r2;
        r2 = r10;
    L_0x02f9:
        r4 = "LoguploadTable";
        r5 = "query table t_logupload all cols Error";
        com.huawei.logupload.p090c.C1103f.m4876a(r4, r5);	 Catch:{ all -> 0x031d }
        if (r3 == 0) goto L_0x0011;
    L_0x0302:
        r3.close();	 Catch:{ all -> 0x0307 }
        goto L_0x0011;
    L_0x0307:
        r2 = move-exception;
        monitor-exit(r11);
        throw r2;
    L_0x030a:
        r3 = move-exception;
        r40 = r3;
        r3 = r2;
        r2 = r40;
    L_0x0310:
        if (r3 == 0) goto L_0x0315;
    L_0x0312:
        r3.close();	 Catch:{ all -> 0x0307 }
    L_0x0315:
        throw r2;	 Catch:{ all -> 0x0307 }
    L_0x0316:
        r3 = move-exception;
        r40 = r3;
        r3 = r2;
        r2 = r40;
        goto L_0x0310;
    L_0x031d:
        r2 = move-exception;
        goto L_0x0310;
    L_0x031f:
        r3 = move-exception;
        r3 = r2;
        r2 = r10;
        goto L_0x02f9;
    L_0x0323:
        r4 = move-exception;
        r40 = r3;
        r3 = r2;
        r2 = r40;
        goto L_0x02f9;
    L_0x032a:
        r3 = move-exception;
        r3 = r2;
        r2 = r4;
        goto L_0x02f9;
    L_0x032e:
        r3 = r10;
        goto L_0x0195;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.logupload.a.a.b(com.huawei.logupload.a.c, java.lang.String):com.huawei.logupload.LogUpload");
    }

    private static long m4841a(SQLiteDatabase sQLiteDatabase, LogUpload logUpload) {
        if (sQLiteDatabase == null || logUpload == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("transactionId", Long.valueOf(logUpload.m4800i()));
        contentValues.put("sendType", logUpload.m4797g() ? "1" : "0");
        contentValues.put("filePath", logUpload.m4798h());
        contentValues.put("fileSize", Long.valueOf(logUpload.m4802j()));
        contentValues.put("encrypt", logUpload.m4805k() ? "1" : "0");
        contentValues.put("privacy", logUpload.m4817q() ? "1" : "0");
        contentValues.put("uploadFlags", Integer.valueOf(logUpload.m4806l()));
        contentValues.put(UploadFile.SYS_ID_CHANNEL, Integer.valueOf(logUpload.m4758A()));
        contentValues.put("feedBackPackageName", logUpload.m4760C());
        contentValues.put("feedBackClassName", logUpload.m4761D());
        contentValues.put("userType", Integer.valueOf(logUpload.m4763F()));
        contentValues.put(UploadFile.ZIP_TIME, logUpload.m4782d());
        contentValues.put(UploadFile.LOG_DETAIL_INFO, logUpload.m4787e());
        contentValues.put("productName", logUpload.m4766a());
        contentValues.put("romVersion", logUpload.m4772b());
        contentValues.put("isPause", logUpload.m4777c());
        if (logUpload.m4812o() != null) {
            contentValues.put("secret", logUpload.m4812o());
        }
        contentValues.put("taskCreateTime", Long.valueOf(System.currentTimeMillis()));
        long insert = sQLiteDatabase.insert("t_logupload", null, contentValues);
        if (-1 == insert) {
            return -1;
        }
        return insert;
    }

    private static void m4846a(SQLiteDatabase sQLiteDatabase, LogUpload logUpload, boolean z) {
        if (sQLiteDatabase != null && logUpload != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("policy", logUpload.m4808m());
            contentValues.put(SNBConstant.FIELD_TOKEN, logUpload.m4810n());
            contentValues.put("secret", logUpload.m4812o());
            contentValues.put("uploadPath", logUpload.m4814p());
            contentValues.put("timeStamp", logUpload.m4818r());
            contentValues.put("callBackAddress", logUpload.m4819s());
            contentValues.put("uploadAddress", logUpload.m4820t());
            contentValues.put("uploadType", Integer.valueOf(logUpload.m4821u()));
            contentValues.put("contentRange", logUpload.m4822v());
            contentValues.put(UploadFile.REFRESH_LABEL, logUpload.m4823w() ? "1" : "0");
            contentValues.put("encryptFilePath", logUpload.m4824x());
            contentValues.put(UploadFile.ZIP_TIME, logUpload.m4782d());
            contentValues.put(UploadFile.LOG_DETAIL_INFO, logUpload.m4787e());
            contentValues.put("productName", logUpload.m4766a());
            contentValues.put("romVersion", logUpload.m4772b());
            if (z) {
                contentValues.put("isPause", logUpload.m4777c());
            }
            sQLiteDatabase.update("t_logupload", contentValues, "_ID = ?", new String[]{logUpload.m4791f()});
        }
    }

    private static void m4849b(SQLiteDatabase sQLiteDatabase, LogUpload logUpload) {
        if (sQLiteDatabase != null && logUpload != null) {
            if (-1 == sQLiteDatabase.delete("t_logupload", "_ID = ?", new String[]{logUpload.m4791f()}) && C1103f.m4877a(4)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DELETE ");
                stringBuilder.append("t_logupload");
                stringBuilder.append(" where ");
                stringBuilder.append("_ID = ");
                stringBuilder.append(logUpload.m4791f());
                C1103f.m4880d("LoguploadTable", stringBuilder.toString());
            }
        }
    }
}
