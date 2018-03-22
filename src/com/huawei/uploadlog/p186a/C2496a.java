package com.huawei.uploadlog.p186a;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.uploadlog.LogUpload;
import com.huawei.uploadlog.p188c.C2511g;

/* compiled from: LoguploadTable */
public final class C2496a implements BaseColumns {
    public static void m12416a(SQLiteDatabase sQLiteDatabase) {
        String str = "CREATE TABLE IF NOT EXISTS t_logupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, transactionId LONG, sendType varchar(4), filePath varchar(256), fileSize LONG, encrypt varchar(4), privacy varchar(4), uploadFlags INTEGER, policy varchar(256), token varchar(256), secret varchar(256), uploadPath varchar(256), timeStamp varchar(256), callBackAddress varchar(256), uploadAddress varchar(256), uploadType INTEGER, contentRange varchar(256), refresh varchar(4), encryptFilePath varchar(256), channelId INTEGER, feedBackPackageName varchar(256), feedBackClassName varchar(256), userType INTEGER, zipTime varchar(256), logDetailInfo varchar(1024), productName varchar(256), romVersion varchar(256), isPaused varchar(4), taskCreateTime LONG)";
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_logupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, transactionId LONG, sendType varchar(4), filePath varchar(256), fileSize LONG, encrypt varchar(4), privacy varchar(4), uploadFlags INTEGER, policy varchar(256), token varchar(256), secret varchar(256), uploadPath varchar(256), timeStamp varchar(256), callBackAddress varchar(256), uploadAddress varchar(256), uploadType INTEGER, contentRange varchar(256), refresh varchar(4), encryptFilePath varchar(256), channelId INTEGER, feedBackPackageName varchar(256), feedBackClassName varchar(256), userType INTEGER, zipTime varchar(256), logDetailInfo varchar(1024), productName varchar(256), romVersion varchar(256), isPaused varchar(4), taskCreateTime LONG)");
            } catch (SQLException e) {
                C2511g.m12484d("BETACLUB_SDK", "create table t_logupload Error");
            }
        }
    }

    public static synchronized long m12413a(C2497b c2497b, LogUpload logUpload) {
        long j;
        synchronized (C2496a.class) {
            SQLiteDatabase sQLiteDatabase = null;
            j = -1;
            try {
                sQLiteDatabase = c2497b.getWritableDatabase();
                j = C2496a.m12412a(sQLiteDatabase, logUpload);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e) {
                C2511g.m12484d("BETACLUB_SDK", "insert table t_logupload Error!");
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
    public static synchronized void m12418a(com.huawei.uploadlog.p186a.C2497b r5, com.huawei.uploadlog.LogUpload r6, boolean r7) {
        /*
        r2 = com.huawei.uploadlog.p186a.C2496a.class;
        monitor-enter(r2);
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0012, all -> 0x0024 }
        com.huawei.uploadlog.p186a.C2496a.m12417a(r0, r6, r7);	 Catch:{ SQLiteException -> 0x0012 }
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.close();	 Catch:{ all -> 0x0021 }
    L_0x0010:
        monitor-exit(r2);
        return;
    L_0x0012:
        r1 = move-exception;
        r1 = "BETACLUB_SDK";
        r3 = "update table t_logupload Error!";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r1, r3);	 Catch:{ all -> 0x002e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.a.a.a(com.huawei.uploadlog.a.b, com.huawei.uploadlog.LogUpload, boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m12421b(com.huawei.uploadlog.p186a.C2497b r5, com.huawei.uploadlog.LogUpload r6) {
        /*
        r2 = com.huawei.uploadlog.p186a.C2496a.class;
        monitor-enter(r2);
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0012, all -> 0x0023 }
        com.huawei.uploadlog.p186a.C2496a.m12420b(r0, r6);	 Catch:{ SQLiteException -> 0x0012 }
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.close();	 Catch:{ all -> 0x0020 }
    L_0x0010:
        monitor-exit(r2);
        return;
    L_0x0012:
        r1 = move-exception;
        r1 = "BETACLUB_SDK";
        r3 = "delete table t_logupload Error!";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r1, r3);	 Catch:{ all -> 0x002d }
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.a.a.b(com.huawei.uploadlog.a.b, com.huawei.uploadlog.LogUpload):void");
    }

    public static synchronized java.lang.String m12415a(com.huawei.uploadlog.p186a.C2497b r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.huawei.uploadlog.a.a.a(com.huawei.uploadlog.a.b, java.lang.String):java.lang.String. bs: [B:8:0x000c, B:21:0x003e]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r9 = com.huawei.uploadlog.p186a.C2496a.class;
        monitor-enter(r9);
        r8 = "";	 Catch:{ all -> 0x005d }
        r0 = r11.getReadableDatabase();	 Catch:{ SQLiteException -> 0x007b, all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x000c:
        r1 = "";	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        if (r0 == 0) goto L_0x0013;
    L_0x0010:
        r0.close();	 Catch:{ all -> 0x005d }
    L_0x0013:
        r0 = r1;
    L_0x0014:
        monitor-exit(r9);
        return r0;
    L_0x0016:
        r1 = "t_logupload";	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2 = 1;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r3 = 0;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r4 = "isPaused";	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r3 = "transactionId=?";	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r4 = 1;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r5 = 0;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r5 = 0;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r6 = 0;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r7 = 0;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        if (r2 == 0) goto L_0x0085;	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
    L_0x0031:
        r1 = "isPaused";	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r3 = r2.getColumnIndex(r1);	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2.moveToFirst();	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r2.moveToFirst();	 Catch:{ SQLiteException -> 0x007f, all -> 0x0074 }
        r1 = r8;
    L_0x003e:
        r4 = r2.isAfterLast();	 Catch:{ SQLiteException -> 0x004c, all -> 0x0074 }
        if (r4 != 0) goto L_0x0060;	 Catch:{ SQLiteException -> 0x004c, all -> 0x0074 }
    L_0x0044:
        r1 = r2.getString(r3);	 Catch:{ SQLiteException -> 0x004c, all -> 0x0074 }
        r2.moveToNext();	 Catch:{ SQLiteException -> 0x004c, all -> 0x0074 }
        goto L_0x003e;
    L_0x004c:
        r2 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x0050:
        r2 = "BETACLUB_SDK";	 Catch:{ all -> 0x0079 }
        r3 = "getPauseStauts Error";	 Catch:{ all -> 0x0079 }
        com.huawei.uploadlog.p188c.C2511g.m12484d(r2, r3);	 Catch:{ all -> 0x0079 }
        if (r1 == 0) goto L_0x0014;
    L_0x0059:
        r1.close();	 Catch:{ all -> 0x005d }
        goto L_0x0014;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0060:
        r2.close();	 Catch:{ SQLiteException -> 0x004c, all -> 0x0074 }
    L_0x0063:
        if (r0 == 0) goto L_0x0083;
    L_0x0065:
        r0.close();	 Catch:{ all -> 0x005d }
        r0 = r1;	 Catch:{ all -> 0x005d }
        goto L_0x0014;	 Catch:{ all -> 0x005d }
    L_0x006a:
        r1 = move-exception;	 Catch:{ all -> 0x005d }
        r10 = r1;	 Catch:{ all -> 0x005d }
        r1 = r0;	 Catch:{ all -> 0x005d }
        r0 = r10;	 Catch:{ all -> 0x005d }
    L_0x006e:
        if (r1 == 0) goto L_0x0073;	 Catch:{ all -> 0x005d }
    L_0x0070:
        r1.close();	 Catch:{ all -> 0x005d }
    L_0x0073:
        throw r0;	 Catch:{ all -> 0x005d }
    L_0x0074:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x006e;
    L_0x0079:
        r0 = move-exception;
        goto L_0x006e;
    L_0x007b:
        r1 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x0050;
    L_0x007f:
        r1 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x0050;
    L_0x0083:
        r0 = r1;
        goto L_0x0014;
    L_0x0085:
        r1 = r8;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.a.a.a(com.huawei.uploadlog.a.b, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.util.LongSparseArray<com.huawei.uploadlog.LogUpload> m12414a(com.huawei.uploadlog.p186a.C2497b r43) {
        /*
        r13 = com.huawei.uploadlog.p186a.C2496a.class;
        monitor-enter(r13);
        r4 = 0;
        r12 = new android.util.LongSparseArray;	 Catch:{ all -> 0x0373 }
        r12.<init>();	 Catch:{ all -> 0x0373 }
        r4 = r43.getReadableDatabase();	 Catch:{ SQLiteException -> 0x0365, all -> 0x0376 }
        if (r4 != 0) goto L_0x0017;
    L_0x000f:
        if (r4 == 0) goto L_0x0014;
    L_0x0011:
        r4.close();	 Catch:{ all -> 0x0373 }
    L_0x0014:
        r4 = r12;
    L_0x0015:
        monitor-exit(r13);
        return r4;
    L_0x0017:
        r5 = "t_logupload";
        r6 = 29;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 0;
        r8 = "_id";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 1;
        r8 = "transactionId";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 2;
        r8 = "sendType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 3;
        r8 = "filePath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 4;
        r8 = "fileSize";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 5;
        r8 = "encrypt";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 6;
        r8 = "privacy";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 7;
        r8 = "uploadFlags";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 8;
        r8 = "policy";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 9;
        r8 = "token";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 10;
        r8 = "secret";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 11;
        r8 = "uploadPath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 12;
        r8 = "timeStamp";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 13;
        r8 = "callBackAddress";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 14;
        r8 = "uploadAddress";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 15;
        r8 = "uploadType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 16;
        r8 = "contentRange";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 17;
        r8 = "refresh";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 18;
        r8 = "encryptFilePath";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 19;
        r8 = "channelId";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 20;
        r8 = "feedBackPackageName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 21;
        r8 = "feedBackClassName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 22;
        r8 = "userType";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 23;
        r8 = "taskCreateTime";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 24;
        r8 = "zipTime";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 25;
        r8 = "logDetailInfo";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 26;
        r8 = "productName";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 27;
        r8 = "romVersion";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 28;
        r8 = "isPaused";
        r6[r7] = r8;	 Catch:{ SQLiteException -> 0x0365 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = "fileSize ASC";
        r6 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x0365 }
        if (r6 == 0) goto L_0x035d;
    L_0x00d5:
        r5 = "_id";
        r7 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "transactionId";
        r8 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "sendType";
        r9 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "filePath";
        r10 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "fileSize";
        r11 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "encrypt";
        r14 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "privacy";
        r15 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "uploadFlags";
        r16 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "policy";
        r17 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "token";
        r18 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "secret";
        r19 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "uploadPath";
        r20 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "timeStamp";
        r21 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "callBackAddress";
        r22 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "uploadAddress";
        r23 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "uploadType";
        r24 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "contentRange";
        r25 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "encryptFilePath";
        r26 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "refresh";
        r27 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "channelId";
        r28 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "feedBackPackageName";
        r29 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "feedBackClassName";
        r30 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "userType";
        r31 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "taskCreateTime";
        r32 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "zipTime";
        r33 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "logDetailInfo";
        r34 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "productName";
        r35 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "romVersion";
        r36 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "isPaused";
        r37 = r6.getColumnIndex(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x0365 }
    L_0x018d:
        if (r5 == 0) goto L_0x035a;
    L_0x018f:
        r38 = new com.huawei.uploadlog.LogUpload;	 Catch:{ SQLiteException -> 0x0365 }
        r38.<init>();	 Catch:{ SQLiteException -> 0x0365 }
        r5 = r6.getInt(r7);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = (long) r5;	 Catch:{ SQLiteException -> 0x0365 }
        r40 = r0;
        r0 = r38;
        r1 = r40;
        r0.setTaskId(r1);	 Catch:{ SQLiteException -> 0x0365 }
        r40 = r6.getLong(r8);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r1 = r40;
        r0.setId(r1);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x01c7;
    L_0x01b3:
        r5 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x034f;
    L_0x01c1:
        r5 = 1;
    L_0x01c2:
        r0 = r38;
        r0.setVisible(r5);	 Catch:{ SQLiteException -> 0x0365 }
    L_0x01c7:
        r5 = r6.getString(r10);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setFilePath(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r40 = r6.getLong(r11);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r1 = r40;
        r0.setSize(r1);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x01f5;
    L_0x01e1:
        r5 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x0352;
    L_0x01ef:
        r5 = 1;
    L_0x01f0:
        r0 = r38;
        r0.setEncrypt(r5);	 Catch:{ SQLiteException -> 0x0365 }
    L_0x01f5:
        r5 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x020f;
    L_0x01fb:
        r5 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x0355;
    L_0x0209:
        r5 = 1;
    L_0x020a:
        r0 = r38;
        r0.setPrivacy(r5);	 Catch:{ SQLiteException -> 0x0365 }
    L_0x020f:
        r5 = "BETACLUB_SDK";
        r39 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0365 }
        r39.<init>();	 Catch:{ SQLiteException -> 0x0365 }
        r40 = "logDetailInfo";
        r39 = r39.append(r40);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r34;
        r40 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = r39.append(r40);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = r39.toString();	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r39;
        com.huawei.uploadlog.p188c.C2511g.m12481b(r5, r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r16;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setFlags(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r17;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setPolicy(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r18;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setAccessToken(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r19;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setSecret(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r20;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setUploadPath(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r21;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setTimeStamp(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r22;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setCallbackAddress(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r23;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setUploadAddress(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r24;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setType(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r25;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setContentRange(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r28;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setChannelId(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r26;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setEncryptedFile(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r29;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setFeedBackPackageName(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r30;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setFeedBackClassName(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r31;
        r5 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setUserType(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r33;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setZipTime(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r34;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setLogDetailInfo(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r35;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setProductName(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r36;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setRomVersion(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = "1";
        r0 = r37;
        r39 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r39;
        r5 = r5.equals(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r0.setPaused(r5);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r27;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x0331;
    L_0x031b:
        r0 = r27;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r39 = "1";
        r0 = r39;
        r5 = r5.endsWith(r0);	 Catch:{ SQLiteException -> 0x0365 }
        if (r5 == 0) goto L_0x0358;
    L_0x032b:
        r5 = 1;
    L_0x032c:
        r0 = r38;
        r0.setRefresh(r5);	 Catch:{ SQLiteException -> 0x0365 }
    L_0x0331:
        r0 = r32;
        r40 = r6.getLong(r0);	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r38;
        r1 = r40;
        r0.setStartTime(r1);	 Catch:{ SQLiteException -> 0x0365 }
        r40 = r38.getId();	 Catch:{ SQLiteException -> 0x0365 }
        r0 = r40;
        r2 = r38;
        r12.put(r0, r2);	 Catch:{ SQLiteException -> 0x0365 }
        r5 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x0365 }
        goto L_0x018d;
    L_0x034f:
        r5 = 0;
        goto L_0x01c2;
    L_0x0352:
        r5 = 0;
        goto L_0x01f0;
    L_0x0355:
        r5 = 0;
        goto L_0x020a;
    L_0x0358:
        r5 = 0;
        goto L_0x032c;
    L_0x035a:
        r6.close();	 Catch:{ SQLiteException -> 0x0365 }
    L_0x035d:
        if (r4 == 0) goto L_0x0362;
    L_0x035f:
        r4.close();	 Catch:{ all -> 0x0373 }
    L_0x0362:
        r4 = r12;
        goto L_0x0015;
    L_0x0365:
        r5 = move-exception;
        r5 = "BETACLUB_SDK";
        r6 = "query table t_logupload all cols Error";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r5, r6);	 Catch:{ all -> 0x0382 }
        if (r4 == 0) goto L_0x0362;
    L_0x036f:
        r4.close();	 Catch:{ all -> 0x0373 }
        goto L_0x0362;
    L_0x0373:
        r4 = move-exception;
        monitor-exit(r13);
        throw r4;
    L_0x0376:
        r5 = move-exception;
        r42 = r5;
        r5 = r4;
        r4 = r42;
    L_0x037c:
        if (r5 == 0) goto L_0x0381;
    L_0x037e:
        r5.close();	 Catch:{ all -> 0x0373 }
    L_0x0381:
        throw r4;	 Catch:{ all -> 0x0373 }
    L_0x0382:
        r5 = move-exception;
        r42 = r5;
        r5 = r4;
        r4 = r42;
        goto L_0x037c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.a.a.a(com.huawei.uploadlog.a.b):android.util.LongSparseArray<com.huawei.uploadlog.LogUpload>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.huawei.uploadlog.LogUpload m12419b(com.huawei.uploadlog.p186a.C2497b r41, java.lang.String r42) {
        /*
        r11 = com.huawei.uploadlog.p186a.C2496a.class;
        monitor-enter(r11);
        r3 = 0;
        r10 = 0;
        r2 = r41.getReadableDatabase();	 Catch:{ SQLiteException -> 0x02fb, Exception -> 0x0310 }
        if (r2 != 0) goto L_0x0014;
    L_0x000b:
        r3 = 0;
        if (r2 == 0) goto L_0x0011;
    L_0x000e:
        r2.close();	 Catch:{ all -> 0x030d }
    L_0x0011:
        r2 = r3;
    L_0x0012:
        monitor-exit(r11);
        return r2;
    L_0x0014:
        r3 = "t_logupload";
        r4 = 29;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 0;
        r6 = "_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 1;
        r6 = "transactionId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 2;
        r6 = "sendType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 3;
        r6 = "filePath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 4;
        r6 = "fileSize";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 5;
        r6 = "encrypt";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 6;
        r6 = "privacy";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 7;
        r6 = "uploadFlags";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 8;
        r6 = "policy";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 9;
        r6 = "token";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 10;
        r6 = "secret";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 11;
        r6 = "uploadPath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 12;
        r6 = "timeStamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 13;
        r6 = "callBackAddress";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 14;
        r6 = "uploadAddress";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 15;
        r6 = "uploadType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 16;
        r6 = "contentRange";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 17;
        r6 = "refresh";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 18;
        r6 = "encryptFilePath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 19;
        r6 = "channelId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 20;
        r6 = "feedBackPackageName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 21;
        r6 = "feedBackClassName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 22;
        r6 = "userType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 23;
        r6 = "taskCreateTime";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 24;
        r6 = "zipTime";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 25;
        r6 = "logDetailInfo";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 26;
        r6 = "productName";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 27;
        r6 = "romVersion";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = 28;
        r6 = "isPaused";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = "transactionId=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r7 = 0;
        r6[r7] = r42;	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r6 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        if (r6 == 0) goto L_0x034f;
    L_0x00d7:
        r3 = "_id";
        r7 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "transactionId";
        r8 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "sendType";
        r9 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "filePath";
        r12 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "fileSize";
        r13 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "encrypt";
        r14 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "privacy";
        r15 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "uploadFlags";
        r16 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "policy";
        r17 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "token";
        r18 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "secret";
        r19 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "uploadPath";
        r20 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "timeStamp";
        r21 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "callBackAddress";
        r22 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "uploadAddress";
        r23 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "uploadType";
        r24 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "contentRange";
        r25 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "encryptFilePath";
        r26 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "refresh";
        r27 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "channelId";
        r28 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "feedBackPackageName";
        r29 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "feedBackClassName";
        r30 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "userType";
        r31 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "taskCreateTime";
        r32 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "zipTime";
        r33 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "logDetailInfo";
        r34 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "productName";
        r35 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "romVersion";
        r36 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = "isPaused";
        r37 = r6.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r3 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x033d, Exception -> 0x0331, all -> 0x0327 }
        r5 = r10;
    L_0x0190:
        if (r3 == 0) goto L_0x02ef;
    L_0x0192:
        r4 = new com.huawei.uploadlog.LogUpload;	 Catch:{ SQLiteException -> 0x0348, Exception -> 0x0339, all -> 0x0327 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0348, Exception -> 0x0339, all -> 0x0327 }
        r3 = r6.getInt(r7);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = (long) r3;	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r38 = r0;
        r0 = r38;
        r4.setTaskId(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r38 = r6.getLong(r8);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r38;
        r4.setId(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r3 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x01c2;
    L_0x01b2:
        r3 = r6.getString(r9);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r5 = "1";
        r3 = r3.endsWith(r5);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x02e4;
    L_0x01be:
        r3 = 1;
    L_0x01bf:
        r4.setVisible(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
    L_0x01c2:
        r3 = r6.getString(r12);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setFilePath(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r38 = r6.getLong(r13);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r38;
        r4.setSize(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r3 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x01e8;
    L_0x01d8:
        r3 = r6.getString(r14);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r5 = "1";
        r3 = r3.endsWith(r5);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x02e7;
    L_0x01e4:
        r3 = 1;
    L_0x01e5:
        r4.setEncrypt(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
    L_0x01e8:
        r3 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x01fe;
    L_0x01ee:
        r3 = r6.getString(r15);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r5 = "1";
        r3 = r3.endsWith(r5);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x02ea;
    L_0x01fa:
        r3 = 1;
    L_0x01fb:
        r4.setPrivacy(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
    L_0x01fe:
        r0 = r16;
        r3 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setFlags(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r17;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setPolicy(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r18;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setAccessToken(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r19;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setSecret(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r20;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setUploadPath(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r21;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setTimeStamp(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r22;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setCallbackAddress(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r23;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setUploadAddress(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r24;
        r3 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setType(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r25;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setContentRange(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r26;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setEncryptedFile(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r28;
        r3 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setChannelId(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r29;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setFeedBackPackageName(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r30;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setFeedBackClassName(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r31;
        r3 = r6.getInt(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setUserType(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r33;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setZipTime(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r34;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setLogDetailInfo(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r35;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setProductName(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r36;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setRomVersion(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r3 = "1";
        r0 = r37;
        r5 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r3 = r3.equals(r5);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r4.setPaused(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r27;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x02d2;
    L_0x02c0:
        r0 = r27;
        r3 = r6.getString(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r5 = "1";
        r3 = r3.endsWith(r5);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        if (r3 == 0) goto L_0x02ed;
    L_0x02ce:
        r3 = 1;
    L_0x02cf:
        r4.setRefresh(r3);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
    L_0x02d2:
        r0 = r32;
        r38 = r6.getLong(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r0 = r38;
        r4.setStartTime(r0);	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r3 = r6.moveToNext();	 Catch:{ SQLiteException -> 0x0341, Exception -> 0x0335, all -> 0x0327 }
        r5 = r4;
        goto L_0x0190;
    L_0x02e4:
        r3 = 0;
        goto L_0x01bf;
    L_0x02e7:
        r3 = 0;
        goto L_0x01e5;
    L_0x02ea:
        r3 = 0;
        goto L_0x01fb;
    L_0x02ed:
        r3 = 0;
        goto L_0x02cf;
    L_0x02ef:
        r6.close();	 Catch:{ SQLiteException -> 0x0348, Exception -> 0x0339, all -> 0x0327 }
        r3 = r5;
    L_0x02f3:
        if (r2 == 0) goto L_0x034c;
    L_0x02f5:
        r2.close();	 Catch:{ all -> 0x030d }
        r2 = r3;
        goto L_0x0012;
    L_0x02fb:
        r2 = move-exception;
        r4 = r3;
        r3 = r2;
        r2 = r10;
    L_0x02ff:
        r5 = "BETACLUB_SDK";
        r6 = "query table t_logupload all cols Error";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r5, r6, r3);	 Catch:{ all -> 0x032e }
        if (r4 == 0) goto L_0x0012;
    L_0x0308:
        r4.close();	 Catch:{ all -> 0x030d }
        goto L_0x0012;
    L_0x030d:
        r2 = move-exception;
        monitor-exit(r11);
        throw r2;
    L_0x0310:
        r2 = move-exception;
        r2 = r10;
    L_0x0312:
        r4 = "BETACLUB_SDK";
        r5 = "query table t_logupload all cols Error";
        com.huawei.uploadlog.p188c.C2511g.m12484d(r4, r5);	 Catch:{ all -> 0x0320 }
        if (r3 == 0) goto L_0x0012;
    L_0x031b:
        r3.close();	 Catch:{ all -> 0x030d }
        goto L_0x0012;
    L_0x0320:
        r2 = move-exception;
    L_0x0321:
        if (r3 == 0) goto L_0x0326;
    L_0x0323:
        r3.close();	 Catch:{ all -> 0x030d }
    L_0x0326:
        throw r2;	 Catch:{ all -> 0x030d }
    L_0x0327:
        r3 = move-exception;
        r40 = r3;
        r3 = r2;
        r2 = r40;
        goto L_0x0321;
    L_0x032e:
        r2 = move-exception;
        r3 = r4;
        goto L_0x0321;
    L_0x0331:
        r3 = move-exception;
        r3 = r2;
        r2 = r10;
        goto L_0x0312;
    L_0x0335:
        r3 = move-exception;
        r3 = r2;
        r2 = r4;
        goto L_0x0312;
    L_0x0339:
        r3 = move-exception;
        r3 = r2;
        r2 = r5;
        goto L_0x0312;
    L_0x033d:
        r3 = move-exception;
        r4 = r2;
        r2 = r10;
        goto L_0x02ff;
    L_0x0341:
        r3 = move-exception;
        r40 = r4;
        r4 = r2;
        r2 = r40;
        goto L_0x02ff;
    L_0x0348:
        r3 = move-exception;
        r4 = r2;
        r2 = r5;
        goto L_0x02ff;
    L_0x034c:
        r2 = r3;
        goto L_0x0012;
    L_0x034f:
        r3 = r10;
        goto L_0x02f3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.a.a.b(com.huawei.uploadlog.a.b, java.lang.String):com.huawei.uploadlog.LogUpload");
    }

    private static long m12412a(SQLiteDatabase sQLiteDatabase, LogUpload logUpload) {
        if (sQLiteDatabase == null || logUpload == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("transactionId", Long.valueOf(logUpload.getId()));
        contentValues.put("sendType", logUpload.isVisible() ? "1" : "0");
        contentValues.put("filePath", logUpload.getFilePath());
        contentValues.put("fileSize", Long.valueOf(logUpload.getSize()));
        contentValues.put("encrypt", logUpload.isEncrypt() ? "1" : "0");
        contentValues.put("privacy", logUpload.isPrivacy() ? "1" : "0");
        contentValues.put("uploadFlags", Integer.valueOf(logUpload.getFlags()));
        contentValues.put(UploadFile.SYS_ID_CHANNEL, Integer.valueOf(logUpload.getChannelId()));
        contentValues.put("feedBackPackageName", logUpload.getFeedBackPackageName());
        contentValues.put("feedBackClassName", logUpload.getFeedBackClassName());
        contentValues.put("userType", Integer.valueOf(logUpload.getUserType()));
        contentValues.put(UploadFile.ZIP_TIME, logUpload.getZipTime());
        contentValues.put(UploadFile.LOG_DETAIL_INFO, logUpload.getLogDetailInfo());
        contentValues.put("productName", logUpload.getProductName());
        contentValues.put("romVersion", logUpload.getRomVersion());
        contentValues.put("isPaused", logUpload.isPaused() ? "1" : "0");
        if (logUpload.getSecret() != null) {
            contentValues.put("secret", logUpload.getSecret());
        }
        long currentTimeMillis = System.currentTimeMillis();
        contentValues.put("taskCreateTime", Long.valueOf(currentTimeMillis));
        long insert = sQLiteDatabase.insert("t_logupload", null, contentValues);
        if (-1 != insert) {
            return insert;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ");
        stringBuilder.append("t_logupload");
        stringBuilder.append(" failed ");
        stringBuilder.append("transactionId = ");
        stringBuilder.append(logUpload.getId());
        stringBuilder.append("taskCreateTime = ");
        stringBuilder.append(currentTimeMillis);
        C2511g.m12484d("BETACLUB_SDK", stringBuilder.toString());
        C2511g.m12484d("BETACLUB_SDK", logUpload.toString());
        return -1;
    }

    private static void m12417a(SQLiteDatabase sQLiteDatabase, LogUpload logUpload, boolean z) {
        if (sQLiteDatabase != null && logUpload != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("policy", logUpload.getPolicy());
            contentValues.put(SNBConstant.FIELD_TOKEN, logUpload.getAccessToken());
            contentValues.put("secret", logUpload.getSecret());
            contentValues.put("uploadPath", logUpload.getUploadPath());
            contentValues.put("timeStamp", logUpload.getTimeStamp());
            contentValues.put("callBackAddress", logUpload.getCallbackAddress());
            contentValues.put("uploadAddress", logUpload.getUploadAddress());
            contentValues.put("uploadType", Integer.valueOf(logUpload.getType()));
            contentValues.put("contentRange", logUpload.getContentRange());
            contentValues.put(UploadFile.REFRESH_LABEL, logUpload.isRefresh() ? "1" : "0");
            contentValues.put("encryptFilePath", logUpload.getEncryptedFile());
            contentValues.put(UploadFile.ZIP_TIME, logUpload.getZipTime());
            contentValues.put(UploadFile.LOG_DETAIL_INFO, logUpload.getLogDetailInfo());
            contentValues.put("productName", logUpload.getProductName());
            contentValues.put("romVersion", logUpload.getRomVersion());
            if (z) {
                contentValues.put("isPaused", logUpload.isPaused() ? "1" : "0");
            }
            if (-1 == sQLiteDatabase.update("t_logupload", contentValues, "_ID = ?", new String[]{"" + logUpload.getTaskId()})) {
                C2511g.m12484d("BETACLUB_SDK", logUpload.toString());
            }
        }
    }

    private static void m12420b(SQLiteDatabase sQLiteDatabase, LogUpload logUpload) {
        if (sQLiteDatabase != null && logUpload != null) {
            if (-1 == sQLiteDatabase.delete("t_logupload", "_ID = ?", new String[]{"" + logUpload.getTaskId()})) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DELETE ");
                stringBuilder.append("t_logupload");
                stringBuilder.append(" where ");
                stringBuilder.append("_ID = ");
                stringBuilder.append(logUpload.getTaskId());
                C2511g.m12484d("BETACLUB_SDK", stringBuilder.toString());
            }
        }
    }
}
