package com.huawei.feedback.p033a.p034a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.huawei.feedback.bean.C4410d;
import com.huawei.phoneserviceuni.common.d.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NewFeedbackTableAdvanced */
public final class C4404e implements BaseColumns {
    public static void m21110a(SQLiteDatabase sQLiteDatabase) {
        String str = "CREATE TABLE IF NOT EXISTS t_feedback_advanced(_id INTEGER PRIMARY KEY AUTOINCREMENT, questionId varchar(256), questionType varchar(256), recordType integer, content varchar(4000), questionDate varchar(256), picUrl varchar(256), picType varchar(256), pQuestionId varchar(256),col1 varchar(256),col2 varchar(256),col3 varchar(256),col4 varchar(4000),taskID varchar(256),filePath varchar(256),taskStatus varchar(256),col5 varchar(256)isLogcat Integer(1),isReport Integer(1),email varchar(256))";
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_feedback_advanced(_id INTEGER PRIMARY KEY AUTOINCREMENT, questionId varchar(256), questionType varchar(256), recordType integer, content varchar(4000), questionDate varchar(256), picUrl varchar(256), picType varchar(256), pQuestionId varchar(256),col1 varchar(256),col2 varchar(256),col3 varchar(256),col4 varchar(4000),taskID varchar(256),filePath varchar(256),taskStatus varchar(256),col5 varchar(256)isLogcat Integer(1),isReport Integer(1),email varchar(256))");
            } catch (SQLException e) {
                c.d("NewFeedbackTableAdvanced", "createTable(SQLiteDatabase db):create table t_feedback_advanced SQLException");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21112a(com.huawei.feedback.p033a.p034a.C4402c r4) {
        /*
        r0 = 0;
        r0 = r4.getReadableDatabase();	 Catch:{ SQLiteException -> 0x0014, SQLException -> 0x0022, all -> 0x0030 }
        r1 = "CREATE TABLE IF NOT EXISTS t_feedback_advanced(_id INTEGER PRIMARY KEY AUTOINCREMENT, questionId varchar(256), questionType varchar(256), recordType integer, content varchar(4000), questionDate varchar(256), picUrl varchar(256), picType varchar(256), pQuestionId varchar(256),col1 varchar(256),col2 varchar(256),col3 varchar(256),col4 varchar(4000),taskID varchar(256),filePath varchar(256),taskStatus varchar(256),col5 varchar(256),isLogcat Integer(1),isReport Integer(1),email varchar(256))";
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r1 = "CREATE TABLE IF NOT EXISTS t_feedback_advanced(_id INTEGER PRIMARY KEY AUTOINCREMENT, questionId varchar(256), questionType varchar(256), recordType integer, content varchar(4000), questionDate varchar(256), picUrl varchar(256), picType varchar(256), pQuestionId varchar(256),col1 varchar(256),col2 varchar(256),col3 varchar(256),col4 varchar(4000),taskID varchar(256),filePath varchar(256),taskStatus varchar(256),col5 varchar(256),isLogcat Integer(1),isReport Integer(1),email varchar(256))";
        r0.execSQL(r1);	 Catch:{ SQLiteException -> 0x0014, SQLException -> 0x0022 }
    L_0x000e:
        if (r0 == 0) goto L_0x0013;
    L_0x0010:
        r0.close();
    L_0x0013:
        return;
    L_0x0014:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "createTable(DatabaseHelper dbHelper):create table t_feedback_advanced SQLiteException";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0013;
    L_0x001e:
        r0.close();
        goto L_0x0013;
    L_0x0022:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "create table t_feedback_advanced SQLException";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0013;
    L_0x002c:
        r0.close();
        goto L_0x0013;
    L_0x0030:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0034:
        if (r1 == 0) goto L_0x0039;
    L_0x0036:
        r1.close();
    L_0x0039:
        throw r0;
    L_0x003a:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.a(com.huawei.feedback.a.a.c):void");
    }

    public static long m21107a(C4402c c4402c, C4410d c4410d) {
        SQLiteDatabase sQLiteDatabase = null;
        long j = -1;
        try {
            sQLiteDatabase = c4402c.getWritableDatabase();
            j = C4404e.m21106a(sQLiteDatabase, c4410d);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (SQLiteException e) {
            c.d("NewFeedbackTableAdvanced", "insert table t_feedback_advanced Error" + e.getMessage());
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        }
        return j;
    }

    private static long m21106a(SQLiteDatabase sQLiteDatabase, C4410d c4410d) {
        if (sQLiteDatabase == null || c4410d == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("questionId", c4410d.m21218l());
        contentValues.put("questionType", c4410d.m21220m());
        contentValues.put("content", c4410d.m21226p());
        contentValues.put("recordType", Integer.valueOf(c4410d.m21224o()));
        contentValues.put("questionDate", c4410d.m21222n());
        contentValues.put("picUrl", c4410d.m21228q());
        contentValues.put("picType", c4410d.m21232u());
        contentValues.put("pQuestionId", c4410d.m21229r());
        contentValues.put("col1", c4410d.m21233v());
        contentValues.put("col2", c4410d.m21234w());
        contentValues.put("col4", c4410d.m21216k());
        contentValues.put("taskID", c4410d.m21212i());
        contentValues.put("filePath", c4410d.m21210h());
        contentValues.put("taskStatus", Integer.valueOf(c4410d.m21214j()));
        contentValues.put("col5", c4410d.m21192b());
        if (c4410d.m21201d()) {
            contentValues.put("isReport", Integer.valueOf(1));
        } else {
            contentValues.put("isReport", Integer.valueOf(0));
        }
        if (c4410d.m21198c()) {
            contentValues.put("isLogcat", Integer.valueOf(1));
        } else {
            contentValues.put("isLogcat", Integer.valueOf(0));
        }
        contentValues.put("email", c4410d.m21202e());
        long insert = sQLiteDatabase.insert("t_feedback_advanced", null, contentValues);
        if (-1 != insert) {
            return insert;
        }
        c.d("NewFeedbackTableAdvanced", "insert error");
        return insert;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21118b(com.huawei.feedback.p033a.p034a.C4402c r4, com.huawei.feedback.bean.C4410d r5) {
        /*
        r0 = 0;
        r0 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x000e, all -> 0x001d }
        com.huawei.feedback.p033a.p034a.C4404e.m21117b(r0, r5);	 Catch:{ SQLiteException -> 0x000e }
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0.close();
    L_0x000d:
        return;
    L_0x000e:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "updateNew :update table t_feedback_advanced Error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x000d;
    L_0x0019:
        r0.close();
        goto L_0x000d;
    L_0x001d:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0021:
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1.close();
    L_0x0026:
        throw r0;
    L_0x0027:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.b(com.huawei.feedback.a.a.c, com.huawei.feedback.bean.d):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21122c(com.huawei.feedback.p033a.p034a.C4402c r4, com.huawei.feedback.bean.C4410d r5) {
        /*
        r0 = 0;
        r0 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x000e, all -> 0x001d }
        com.huawei.feedback.p033a.p034a.C4404e.m21120c(r0, r5);	 Catch:{ SQLiteException -> 0x000e }
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0.close();
    L_0x000d:
        return;
    L_0x000e:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "update: update table t_feedback_advanced Error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x000d;
    L_0x0019:
        r0.close();
        goto L_0x000d;
    L_0x001d:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0021:
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1.close();
    L_0x0026:
        throw r0;
    L_0x0027:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.c(com.huawei.feedback.a.a.c, com.huawei.feedback.bean.d):void");
    }

    private static void m21117b(SQLiteDatabase sQLiteDatabase, C4410d c4410d) {
        if (sQLiteDatabase != null && c4410d != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("questionId", c4410d.m21218l());
            contentValues.put("questionType", c4410d.m21220m());
            contentValues.put("recordType", Integer.valueOf(c4410d.m21224o()));
            contentValues.put("pQuestionId", c4410d.m21229r());
            contentValues.put("col1", c4410d.m21233v());
            contentValues.put("col2", c4410d.m21234w());
            contentValues.put("content", c4410d.m21226p());
            contentValues.put("questionDate", c4410d.m21222n());
            contentValues.put("picUrl", c4410d.m21228q());
            contentValues.put("picType", c4410d.m21232u());
            contentValues.put("col3", Integer.valueOf(c4410d.m21235x()));
            contentValues.put("col4", c4410d.m21216k());
            contentValues.put("taskID", c4410d.m21212i());
            contentValues.put("filePath", c4410d.m21210h());
            contentValues.put("taskStatus", Integer.valueOf(c4410d.m21214j()));
            contentValues.put("col5", c4410d.m21192b());
            if (c4410d.m21198c()) {
                contentValues.put("isLogcat", Integer.valueOf(1));
            } else {
                contentValues.put("isLogcat", Integer.valueOf(0));
            }
            if (c4410d.m21201d()) {
                contentValues.put("isReport", Integer.valueOf(1));
            } else {
                contentValues.put("isReport", Integer.valueOf(0));
            }
            contentValues.put("email", c4410d.m21202e());
            if (-1 == sQLiteDatabase.update("t_feedback_advanced", contentValues, "_id=?", new String[]{Integer.toString(c4410d.m21231t())})) {
                c.d("NewFeedbackTableAdvanced", "updateNew error");
            }
        }
    }

    private static void m21120c(SQLiteDatabase sQLiteDatabase, C4410d c4410d) {
        if (sQLiteDatabase != null && c4410d != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c4410d.m21226p());
            contentValues.put("questionDate", c4410d.m21222n());
            contentValues.put("picUrl", c4410d.m21228q());
            contentValues.put("picType", c4410d.m21232u());
            contentValues.put("col3", Integer.valueOf(c4410d.m21235x()));
            contentValues.put("col4", c4410d.m21216k());
            contentValues.put("taskID", c4410d.m21212i());
            contentValues.put("filePath", c4410d.m21210h());
            contentValues.put("taskStatus", Integer.valueOf(c4410d.m21214j()));
            if (-1 == sQLiteDatabase.update("t_feedback_advanced", contentValues, "_id=?", new String[]{Integer.toString(c4410d.m21231t())})) {
                c.d("NewFeedbackTableAdvanced", "update error");
            }
        }
    }

    private static void m21111a(SQLiteDatabase sQLiteDatabase, String str, int i) {
        c.a("NewFeedbackTableAdvanced", "id" + str);
        c.a("NewFeedbackTableAdvanced", "type" + i);
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("taskID", str);
            contentValues.put("taskStatus", String.valueOf(i));
            if (-1 == sQLiteDatabase.update("t_feedback_advanced", contentValues, "taskID=?", new String[]{str})) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("TASK_ID = ");
                stringBuilder.append(str);
                c.d("NewFeedbackTableAdvanced", stringBuilder.toString());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21114a(com.huawei.feedback.p033a.p034a.C4402c r4, java.lang.String r5, int r6) {
        /*
        r0 = 0;
        r0 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x000e, all -> 0x001d }
        com.huawei.feedback.p033a.p034a.C4404e.m21111a(r0, r5, r6);	 Catch:{ SQLiteException -> 0x000e }
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0.close();
    L_0x000d:
        return;
    L_0x000e:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "updateTypeById:update table t_feedback_advanced Error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x000d;
    L_0x0019:
        r0.close();
        goto L_0x000d;
    L_0x001d:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0021:
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1.close();
    L_0x0026:
        throw r0;
    L_0x0027:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.a(com.huawei.feedback.a.a.c, java.lang.String, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.huawei.feedback.bean.C4410d> m21115b(com.huawei.feedback.p033a.p034a.C4402c r26) {
        /*
        r4 = 0;
        r3 = 0;
        r2 = new java.util.ArrayList;
        r5 = 20;
        r2.<init>(r5);
        r5 = r26.getReadableDatabase();	 Catch:{ SQLiteException -> 0x025f, all -> 0x0254 }
        if (r5 != 0) goto L_0x001a;
    L_0x000f:
        if (r3 == 0) goto L_0x0014;
    L_0x0011:
        r3.close();
    L_0x0014:
        if (r5 == 0) goto L_0x0019;
    L_0x0016:
        r5.close();
    L_0x0019:
        return r2;
    L_0x001a:
        r4 = "select _id ,lastid,questionId,taskID,filePath,taskStatus,questionType,recordType,content,questionDate,tablea.pQuestionId,replyCount,isLogcat,isReport,email,col5,evaluationCount,commitRecordType from (select _id ,max(_id) as lastId ,questionId,taskID,filePath,taskStatus,questionType ,recordType,content,questionDate,pQuestionId,isLogcat,isReport,email,col5 from  t_feedback_advanced  group by pQuestionId ) tablea left outer join (select count(_id) as replyCount ,pQuestionId from t_feedback_advanced  where recordType = '2' group by pQuestionId ) tableb on tablea.pQuestionId = tableb.pQuestionId left outer join (select count(_id) as evaluationCount ,pQuestionId from t_feedback_advanced  where recordType = '2' and (col3 = '-1' or col3 ='1') group by pQuestionId ) tablec on tablea.pQuestionId = tablec.pQuestionId left outer join (select recordType as commitRecordType ,pQuestionId from t_feedback_advanced where taskStatus != '4' and (recordType = '2' or recordType = '1') group by pQuestionId order by max(_id) desc) tabled on tablea.pQuestionId = tabled.pQuestionId where tablea.taskStatus != '4' order by lastid desc";
        r6 = 0;
        r4 = r5.rawQuery(r4, r6);	 Catch:{ SQLiteException -> 0x0262, all -> 0x0258 }
        if (r4 == 0) goto L_0x0248;
    L_0x0024:
        r3 = "questionId";
        r6 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "_id";
        r7 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "questionType";
        r8 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "recordType";
        r9 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "content";
        r10 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "questionDate";
        r11 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "pQuestionId";
        r12 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "replyCount";
        r13 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "taskID";
        r14 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "filePath";
        r15 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "taskStatus";
        r16 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "isLogcat";
        r17 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "isReport";
        r18 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "email";
        r19 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "evaluationCount";
        r20 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "commitRecordType";
        r21 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = "col5";
        r22 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r3 = -1;
        if (r3 == r6) goto L_0x00a1;
    L_0x008f:
        r3 = -1;
        if (r3 == r8) goto L_0x00a1;
    L_0x0092:
        r3 = -1;
        if (r3 == r9) goto L_0x00a1;
    L_0x0095:
        r3 = -1;
        if (r3 == r10) goto L_0x00a1;
    L_0x0098:
        r3 = -1;
        if (r3 == r11) goto L_0x00a1;
    L_0x009b:
        r3 = -1;
        if (r3 == r12) goto L_0x00a1;
    L_0x009e:
        r3 = -1;
        if (r3 != r13) goto L_0x00ad;
    L_0x00a1:
        if (r4 == 0) goto L_0x00a6;
    L_0x00a3:
        r4.close();
    L_0x00a6:
        if (r5 == 0) goto L_0x0019;
    L_0x00a8:
        r5.close();
        goto L_0x0019;
    L_0x00ad:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r23 = 20;
        r0 = r23;
        r3.<init>(r0);	 Catch:{ SQLiteException -> 0x0266, all -> 0x021f }
        r2 = r4.moveToNext();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
    L_0x00ba:
        if (r2 == 0) goto L_0x0247;
    L_0x00bc:
        r2 = r4.getString(r12);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        if (r2 == 0) goto L_0x00cb;
    L_0x00c6:
        r2 = r4.moveToNext();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x00ba;
    L_0x00cb:
        r23 = new com.huawei.feedback.bean.d;	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r23.<init>();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getInt(r7);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21203e(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r6);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21211h(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r8);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21213i(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getInt(r9);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21196c(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r10);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21217k(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r11);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21215j(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r12);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21221m(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r23.m21218l();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        if (r2 == 0) goto L_0x01e2;
    L_0x0119:
        r2 = r23.m21229r();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r2.length();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = 14;
        r0 = r24;
        if (r2 != r0) goto L_0x01e2;
    L_0x0127:
        r2 = r4.getString(r14);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21207f(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r4.getString(r15);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21204e(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r16;
        r2 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21193b(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
    L_0x0144:
        r2 = r4.getInt(r13);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21199d(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r17;
        r2 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = 1;
        r0 = r24;
        if (r2 != r0) goto L_0x0232;
    L_0x0159:
        r2 = 1;
    L_0x015a:
        r0 = r23;
        r0.m21191a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r18;
        r2 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = 1;
        r0 = r24;
        if (r2 != r0) goto L_0x0235;
    L_0x016b:
        r2 = 1;
    L_0x016c:
        r0 = r23;
        r0.m21195b(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r19;
        r2 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21194b(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r22;
        r2 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21190a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r23.m21224o();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = r23.m21224o();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r25 = 3;
        r0 = r24;
        r1 = r25;
        if (r0 != r1) goto L_0x019d;
    L_0x0197:
        r0 = r21;
        r2 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
    L_0x019d:
        r24 = r23.m21230s();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        if (r24 <= 0) goto L_0x023f;
    L_0x01a3:
        r24 = 2;
        r0 = r24;
        if (r2 != r0) goto L_0x023f;
    L_0x01a9:
        r2 = 1;
        r0 = r23;
        r0.m21188a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r20;
        r2 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = r23.m21230s();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r24;
        if (r2 != r0) goto L_0x0238;
    L_0x01bd:
        r2 = 2;
        r0 = r23;
        r0.m21188a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
    L_0x01c3:
        r0 = r23;
        r3.add(r0);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x00c6;
    L_0x01ca:
        r2 = move-exception;
        r2 = r3;
        r3 = r4;
        r4 = r5;
    L_0x01ce:
        r5 = "NewFeedbackTableAdvanced";
        r6 = "search:query table t_feedback_new all cols Error";
        com.huawei.phoneserviceuni.common.d.c.d(r5, r6);	 Catch:{ all -> 0x025b }
        if (r3 == 0) goto L_0x01db;
    L_0x01d8:
        r3.close();
    L_0x01db:
        if (r4 == 0) goto L_0x0019;
    L_0x01dd:
        r4.close();
        goto L_0x0019;
    L_0x01e2:
        r2 = r23.m21229r();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r26;
        r2 = com.huawei.feedback.p033a.p034a.C4404e.m21109a(r0, r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = r2.iterator();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
    L_0x01f0:
        r2 = r24.hasNext();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        if (r2 == 0) goto L_0x0144;
    L_0x01f6:
        r2 = r24.next();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = (com.huawei.feedback.bean.C4410d) r2;	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r25 = r2.m21212i();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r25 = android.text.TextUtils.isEmpty(r25);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        if (r25 != 0) goto L_0x022b;
    L_0x0206:
        r24 = r2.m21212i();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r23.m21207f(r24);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r24 = r2.m21214j();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r23.m21193b(r24);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r2 = r2.m21210h();	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        r0 = r23;
        r0.m21204e(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x0144;
    L_0x021f:
        r2 = move-exception;
    L_0x0220:
        if (r4 == 0) goto L_0x0225;
    L_0x0222:
        r4.close();
    L_0x0225:
        if (r5 == 0) goto L_0x022a;
    L_0x0227:
        r5.close();
    L_0x022a:
        throw r2;
    L_0x022b:
        r2 = 0;
        r0 = r23;
        r0.m21193b(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x01f0;
    L_0x0232:
        r2 = 0;
        goto L_0x015a;
    L_0x0235:
        r2 = 0;
        goto L_0x016c;
    L_0x0238:
        r2 = 1;
        r0 = r23;
        r0.m21188a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x01c3;
    L_0x023f:
        r2 = 0;
        r0 = r23;
        r0.m21188a(r2);	 Catch:{ SQLiteException -> 0x01ca, all -> 0x021f }
        goto L_0x01c3;
    L_0x0247:
        r2 = r3;
    L_0x0248:
        if (r4 == 0) goto L_0x024d;
    L_0x024a:
        r4.close();
    L_0x024d:
        if (r5 == 0) goto L_0x0019;
    L_0x024f:
        r5.close();
        goto L_0x0019;
    L_0x0254:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        goto L_0x0220;
    L_0x0258:
        r2 = move-exception;
        r4 = r3;
        goto L_0x0220;
    L_0x025b:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        goto L_0x0220;
    L_0x025f:
        r5 = move-exception;
        goto L_0x01ce;
    L_0x0262:
        r4 = move-exception;
        r4 = r5;
        goto L_0x01ce;
    L_0x0266:
        r3 = move-exception;
        r3 = r4;
        r4 = r5;
        goto L_0x01ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.b(com.huawei.feedback.a.a.c):java.util.List<com.huawei.feedback.bean.d>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.huawei.feedback.bean.C4410d> m21109a(com.huawei.feedback.p033a.p034a.C4402c r21, java.lang.String r22) {
        /*
        r1 = 0;
        r10 = 0;
        r9 = new java.util.ArrayList;
        r2 = 20;
        r9.<init>(r2);
        r1 = r21.getReadableDatabase();	 Catch:{ SQLiteException -> 0x0166, all -> 0x017e }
        if (r1 != 0) goto L_0x001b;
    L_0x000f:
        if (r10 == 0) goto L_0x0014;
    L_0x0011:
        r10.close();
    L_0x0014:
        if (r1 == 0) goto L_0x0019;
    L_0x0016:
        r1.close();
    L_0x0019:
        r1 = r9;
    L_0x001a:
        return r1;
    L_0x001b:
        r2 = 13;
        r3 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 0;
        r4 = "questionId";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 1;
        r4 = "taskID";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 2;
        r4 = "filePath";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 3;
        r4 = "taskStatus";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 4;
        r4 = "pQuestionId";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 5;
        r4 = "questionType";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 6;
        r4 = "recordType";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 7;
        r4 = "content";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 8;
        r4 = "questionDate";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 9;
        r4 = "isLogcat";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 10;
        r4 = "isReport";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 11;
        r4 = "email";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = 12;
        r4 = "col5";
        r3[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r2 = "t_feedback_advanced";
        r4 = "pQuestionId = ?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r6 = 0;
        r5[r6] = r22;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r3 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0190 }
        if (r3 == 0) goto L_0x0158;
    L_0x007b:
        r2 = "questionId";
        r5 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "questionType";
        r6 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "recordType";
        r7 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "content";
        r8 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "questionDate";
        r10 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "pQuestionId";
        r11 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "taskID";
        r12 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "filePath";
        r13 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "taskStatus";
        r14 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "isLogcat";
        r15 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "isReport";
        r16 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "email";
        r17 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = "col5";
        r18 = r3.getColumnIndex(r2);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r2 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r4 = 20;
        r2.<init>(r4);	 Catch:{ SQLiteException -> 0x01ab, all -> 0x0198 }
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
    L_0x00d6:
        if (r4 == 0) goto L_0x0159;
    L_0x00d8:
        r9 = new com.huawei.feedback.bean.d;	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.<init>();	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21211h(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21213i(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getInt(r7);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21196c(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r8);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21217k(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21215j(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r11);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21221m(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r12);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21207f(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getString(r13);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21204e(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getInt(r14);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21193b(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.getInt(r15);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r19 = 1;
        r0 = r19;
        if (r4 != r0) goto L_0x0154;
    L_0x0126:
        r4 = 1;
    L_0x0127:
        r9.m21191a(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r0 = r16;
        r4 = r3.getInt(r0);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r19 = 1;
        r0 = r19;
        if (r4 != r0) goto L_0x0156;
    L_0x0136:
        r4 = 1;
    L_0x0137:
        r9.m21195b(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r0 = r17;
        r4 = r3.getString(r0);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21194b(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r0 = r18;
        r4 = r3.getString(r0);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r9.m21190a(r4);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r2.add(r9);	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x01b0, all -> 0x0198 }
        goto L_0x00d6;
    L_0x0154:
        r4 = 0;
        goto L_0x0127;
    L_0x0156:
        r4 = 0;
        goto L_0x0137;
    L_0x0158:
        r2 = r9;
    L_0x0159:
        if (r3 == 0) goto L_0x015e;
    L_0x015b:
        r3.close();
    L_0x015e:
        if (r1 == 0) goto L_0x01b8;
    L_0x0160:
        r1.close();
        r1 = r2;
        goto L_0x001a;
    L_0x0166:
        r2 = move-exception;
        r2 = r10;
        r3 = r1;
        r1 = r9;
    L_0x016a:
        r4 = "NewFeedbackTableAdvanced";
        r5 = "search1:query table t_feedback_new all cols Error";
        com.huawei.phoneserviceuni.common.d.c.d(r4, r5);	 Catch:{ all -> 0x019f }
        if (r2 == 0) goto L_0x0177;
    L_0x0174:
        r2.close();
    L_0x0177:
        if (r3 == 0) goto L_0x001a;
    L_0x0179:
        r3.close();
        goto L_0x001a;
    L_0x017e:
        r2 = move-exception;
        r3 = r10;
        r20 = r2;
        r2 = r1;
        r1 = r20;
    L_0x0185:
        if (r3 == 0) goto L_0x018a;
    L_0x0187:
        r3.close();
    L_0x018a:
        if (r2 == 0) goto L_0x018f;
    L_0x018c:
        r2.close();
    L_0x018f:
        throw r1;
    L_0x0190:
        r2 = move-exception;
        r3 = r10;
        r20 = r2;
        r2 = r1;
        r1 = r20;
        goto L_0x0185;
    L_0x0198:
        r2 = move-exception;
        r20 = r2;
        r2 = r1;
        r1 = r20;
        goto L_0x0185;
    L_0x019f:
        r1 = move-exception;
        r20 = r2;
        r2 = r3;
        r3 = r20;
        goto L_0x0185;
    L_0x01a6:
        r2 = move-exception;
        r2 = r10;
        r3 = r1;
        r1 = r9;
        goto L_0x016a;
    L_0x01ab:
        r2 = move-exception;
        r2 = r3;
        r3 = r1;
        r1 = r9;
        goto L_0x016a;
    L_0x01b0:
        r4 = move-exception;
        r20 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r20;
        goto L_0x016a;
    L_0x01b8:
        r1 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.a(com.huawei.feedback.a.a.c, java.lang.String):java.util.List<com.huawei.feedback.bean.d>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.huawei.feedback.bean.C4410d> m21116b(com.huawei.feedback.p033a.p034a.C4402c r26, java.lang.String r27) {
        /*
        r2 = 0;
        r11 = 0;
        r10 = new java.util.ArrayList;
        r3 = 20;
        r10.<init>(r3);
        r2 = r26.getReadableDatabase();	 Catch:{ SQLiteException -> 0x01e6, all -> 0x01fd }
        if (r2 != 0) goto L_0x001b;
    L_0x000f:
        if (r11 == 0) goto L_0x0014;
    L_0x0011:
        r11.close();
    L_0x0014:
        if (r2 == 0) goto L_0x0019;
    L_0x0016:
        r2.close();
    L_0x0019:
        r2 = r10;
    L_0x001a:
        return r2;
    L_0x001b:
        r3 = "t_feedback_advanced";
        r4 = 16;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 0;
        r6 = "_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 1;
        r6 = "questionId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 2;
        r6 = "questionType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 3;
        r6 = "recordType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 4;
        r6 = "content";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 5;
        r6 = "questionDate";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 6;
        r6 = "pQuestionId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 7;
        r6 = "picUrl";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 8;
        r6 = "picType";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 9;
        r6 = "col1";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 10;
        r6 = "col2";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 11;
        r6 = "col3";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 12;
        r6 = "col4";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 13;
        r6 = "taskID";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 14;
        r6 = "taskStatus";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = 15;
        r6 = "filePath";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r5 = "pQuestionId=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r7 = 0;
        r6[r7] = r27;	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        r7 = 0;
        r8 = 0;
        r9 = "_id";
        r4 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0225, all -> 0x020f }
        if (r4 == 0) goto L_0x01d8;
    L_0x008e:
        r3 = "_id";
        r6 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "questionId";
        r7 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "questionType";
        r8 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "recordType";
        r9 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "content";
        r11 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "questionDate";
        r12 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "pQuestionId";
        r13 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "picUrl";
        r14 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "picType";
        r15 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "col1";
        r16 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "col2";
        r17 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "col3";
        r18 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "col4";
        r19 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "taskID";
        r20 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "filePath";
        r21 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = "taskStatus";
        r22 = r4.getColumnIndex(r3);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r3 = -1;
        if (r3 == r7) goto L_0x011f;
    L_0x00f3:
        r3 = -1;
        if (r3 == r6) goto L_0x011f;
    L_0x00f6:
        r3 = -1;
        if (r3 == r8) goto L_0x011f;
    L_0x00f9:
        r3 = -1;
        if (r3 == r9) goto L_0x011f;
    L_0x00fc:
        r3 = -1;
        if (r3 == r11) goto L_0x011f;
    L_0x00ff:
        r3 = -1;
        if (r3 == r12) goto L_0x011f;
    L_0x0102:
        r3 = -1;
        if (r3 == r13) goto L_0x011f;
    L_0x0105:
        r3 = -1;
        if (r3 == r15) goto L_0x011f;
    L_0x0108:
        r3 = -1;
        if (r3 == r14) goto L_0x011f;
    L_0x010b:
        r3 = -1;
        r0 = r16;
        if (r3 == r0) goto L_0x011f;
    L_0x0110:
        r3 = -1;
        r0 = r17;
        if (r3 == r0) goto L_0x011f;
    L_0x0115:
        r3 = -1;
        r0 = r18;
        if (r3 == r0) goto L_0x011f;
    L_0x011a:
        r3 = -1;
        r0 = r19;
        if (r3 != r0) goto L_0x012c;
    L_0x011f:
        if (r4 == 0) goto L_0x0124;
    L_0x0121:
        r4.close();
    L_0x0124:
        if (r2 == 0) goto L_0x0129;
    L_0x0126:
        r2.close();
    L_0x0129:
        r2 = r10;
        goto L_0x001a;
    L_0x012c:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r5 = 20;
        r3.<init>(r5);	 Catch:{ SQLiteException -> 0x022a, all -> 0x0217 }
        r5 = r4.moveToNext();	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
    L_0x0137:
        if (r5 == 0) goto L_0x01d9;
    L_0x0139:
        r5 = new com.huawei.feedback.bean.d;	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.<init>();	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getInt(r6);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21203e(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r7);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21211h(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r8);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21213i(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getInt(r9);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21196c(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r11);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21217k(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r12);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21215j(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r13);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21221m(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r14);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21219l(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r4.getString(r15);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21223n(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r10 = r5.m21228q();	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r23 = 0;
        r24 = 0;
        r0 = r23;
        r1 = r24;
        r10 = com.huawei.phoneserviceuni.common.d.f.a(r10, r0, r1);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21189a(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r16;
        r10 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21225o(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r17;
        r10 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21227p(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r18;
        r10 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21206f(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r19;
        r10 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21209g(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r20;
        r10 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21207f(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r21;
        r10 = r4.getString(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21204e(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r0 = r22;
        r10 = r4.getInt(r0);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5.m21193b(r10);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r3.add(r5);	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        r5 = r4.moveToNext();	 Catch:{ SQLiteException -> 0x022f, all -> 0x0217 }
        goto L_0x0137;
    L_0x01d8:
        r3 = r10;
    L_0x01d9:
        if (r4 == 0) goto L_0x01de;
    L_0x01db:
        r4.close();
    L_0x01de:
        if (r2 == 0) goto L_0x0237;
    L_0x01e0:
        r2.close();
        r2 = r3;
        goto L_0x001a;
    L_0x01e6:
        r3 = move-exception;
        r3 = r11;
        r4 = r2;
        r2 = r10;
    L_0x01ea:
        r5 = "NewFeedbackTableAdvanced";
        r6 = "[queryById] query table t_feedback_advanced  Error";
        com.huawei.phoneserviceuni.common.d.c.d(r5, r6);	 Catch:{ all -> 0x021e }
        if (r3 == 0) goto L_0x01f6;
    L_0x01f3:
        r3.close();
    L_0x01f6:
        if (r4 == 0) goto L_0x001a;
    L_0x01f8:
        r4.close();
        goto L_0x001a;
    L_0x01fd:
        r3 = move-exception;
        r4 = r11;
        r25 = r3;
        r3 = r2;
        r2 = r25;
    L_0x0204:
        if (r4 == 0) goto L_0x0209;
    L_0x0206:
        r4.close();
    L_0x0209:
        if (r3 == 0) goto L_0x020e;
    L_0x020b:
        r3.close();
    L_0x020e:
        throw r2;
    L_0x020f:
        r3 = move-exception;
        r4 = r11;
        r25 = r3;
        r3 = r2;
        r2 = r25;
        goto L_0x0204;
    L_0x0217:
        r3 = move-exception;
        r25 = r3;
        r3 = r2;
        r2 = r25;
        goto L_0x0204;
    L_0x021e:
        r2 = move-exception;
        r25 = r3;
        r3 = r4;
        r4 = r25;
        goto L_0x0204;
    L_0x0225:
        r3 = move-exception;
        r3 = r11;
        r4 = r2;
        r2 = r10;
        goto L_0x01ea;
    L_0x022a:
        r3 = move-exception;
        r3 = r4;
        r4 = r2;
        r2 = r10;
        goto L_0x01ea;
    L_0x022f:
        r5 = move-exception;
        r25 = r3;
        r3 = r4;
        r4 = r2;
        r2 = r25;
        goto L_0x01ea;
    L_0x0237:
        r2 = r3;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.b(com.huawei.feedback.a.a.c, java.lang.String):java.util.List<com.huawei.feedback.bean.d>");
    }

    public static C4410d m21119c(C4402c c4402c, String str) {
        C4410d c4410d;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Object obj;
        Throwable th;
        Throwable th2;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase readableDatabase = c4402c.getReadableDatabase();
            if (readableDatabase == null) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (readableDatabase == null) {
                    return cursor2;
                }
                readableDatabase.close();
                return cursor2;
            }
            try {
                Cursor query = readableDatabase.query("t_feedback_advanced", new String[]{"questionId", "questionType", "recordType", "content", "questionDate", "pQuestionId", "picUrl", "picType", "col1", "col2", "col3", "col4", "taskID", "taskStatus", "filePath", "col5"}, "questionId=? and recordType=1", new String[]{str}, null, null, null);
                try {
                    C4410d a = C4404e.m21108a(query);
                    if (query != null) {
                        query.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                        c4410d = a;
                    } else {
                        c4410d = a;
                    }
                } catch (SQLiteException e) {
                    sQLiteDatabase = readableDatabase;
                    cursor = query;
                    try {
                        c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            obj = cursor2;
                        } else {
                            obj = cursor2;
                        }
                        return c4410d;
                    } catch (Throwable th3) {
                        cursor2 = cursor;
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    cursor2 = query;
                    th2 = th4;
                    sQLiteDatabase = readableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                sQLiteDatabase = readableDatabase;
                cursor = cursor2;
                c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    obj = cursor2;
                } else {
                    obj = cursor2;
                }
                return c4410d;
            } catch (Throwable th42) {
                th2 = th42;
                sQLiteDatabase = readableDatabase;
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
            return c4410d;
        } catch (SQLiteException e3) {
            cursor = cursor2;
            sQLiteDatabase = cursor2;
            c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                obj = cursor2;
            } else {
                sQLiteDatabase.close();
                obj = cursor2;
            }
            return c4410d;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = cursor2;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21113a(com.huawei.feedback.p033a.p034a.C4402c r7, int r8) {
        /*
        r0 = 0;
        r0 = r7.getWritableDatabase();	 Catch:{ SQLiteException -> 0x001d, all -> 0x003c }
        r1 = "t_feedback_advanced";
        r2 = "_id=?";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x001d }
        r4 = 0;
        r5 = java.lang.Integer.toString(r8);	 Catch:{ SQLiteException -> 0x001d }
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x001d }
        r0.delete(r1, r2, r3);	 Catch:{ SQLiteException -> 0x001d }
        if (r0 == 0) goto L_0x001c;
    L_0x0019:
        r0.close();
    L_0x001c:
        return;
    L_0x001d:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0046 }
        r2.<init>();	 Catch:{ all -> 0x0046 }
        r3 = "[delete] delete feedback  Error, feedback dbId = ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0046 }
        r2 = r2.append(r8);	 Catch:{ all -> 0x0046 }
        r2 = r2.toString();	 Catch:{ all -> 0x0046 }
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x0046 }
        if (r0 == 0) goto L_0x001c;
    L_0x0038:
        r0.close();
        goto L_0x001c;
    L_0x003c:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0040:
        if (r1 == 0) goto L_0x0045;
    L_0x0042:
        r1.close();
    L_0x0045:
        throw r0;
    L_0x0046:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.a(com.huawei.feedback.a.a.c, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21124d(com.huawei.feedback.p033a.p034a.C4402c r6, java.lang.String r7) {
        /*
        r0 = 0;
        r0 = r6.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0019, all -> 0x0038 }
        r1 = "t_feedback_advanced";
        r2 = "pQuestionId=?";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0019 }
        r4 = 0;
        r3[r4] = r7;	 Catch:{ SQLiteException -> 0x0019 }
        r0.delete(r1, r2, r3);	 Catch:{ SQLiteException -> 0x0019 }
        if (r0 == 0) goto L_0x0018;
    L_0x0015:
        r0.close();
    L_0x0018:
        return;
    L_0x0019:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0042 }
        r2.<init>();	 Catch:{ all -> 0x0042 }
        r3 = "[delete] delete feedback  Error, feedback pquestionId = ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0042 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0042 }
        r2 = r2.toString();	 Catch:{ all -> 0x0042 }
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x0042 }
        if (r0 == 0) goto L_0x0018;
    L_0x0034:
        r0.close();
        goto L_0x0018;
    L_0x0038:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        throw r0;
    L_0x0042:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.d(com.huawei.feedback.a.a.c, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21121c(com.huawei.feedback.p033a.p034a.C4402c r5) {
        /*
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0033, all -> 0x0041 }
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x0033 }
        r2 = 0;
        r3 = 3;
        r3 = java.lang.String.valueOf(r3);	 Catch:{ SQLiteException -> 0x0033 }
        r1[r2] = r3;	 Catch:{ SQLiteException -> 0x0033 }
        r2 = "t_feedback_advanced";
        r3 = "taskStatus=?";
        r0.delete(r2, r3, r1);	 Catch:{ SQLiteException -> 0x0033 }
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x0033 }
        r2 = 0;
        r3 = 0;
        r3 = java.lang.String.valueOf(r3);	 Catch:{ SQLiteException -> 0x0033 }
        r1[r2] = r3;	 Catch:{ SQLiteException -> 0x0033 }
        r2 = "t_feedback_advanced";
        r3 = "taskStatus=?";
        r0.delete(r2, r3, r1);	 Catch:{ SQLiteException -> 0x0033 }
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return;
    L_0x0033:
        r1 = move-exception;
        r1 = "NewFeedbackTableAdvanced";
        r2 = "[delete] deleteFeedbackSuccess:delete table t_feedback_new  Error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0032;
    L_0x003d:
        r0.close();
        goto L_0x0032;
    L_0x0041:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0045:
        if (r1 == 0) goto L_0x004a;
    L_0x0047:
        r1.close();
    L_0x004a:
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.e.c(com.huawei.feedback.a.a.c):void");
    }

    public static List<String> m21123d(C4402c c4402c) {
        SQLiteDatabase writableDatabase;
        int i;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Cursor cursor = null;
        c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds start");
        List<String> arrayList = new ArrayList();
        try {
            writableDatabase = c4402c.getWritableDatabase();
            try {
                cursor = writableDatabase.rawQuery("select questionId from t_feedback_advanced where questionId not in (select questionId from t_feedback_advanced where recordType = 2) order by _id desc limit 0,30", null);
                if (cursor != null) {
                    int columnIndex = cursor.getColumnIndex("questionId");
                    for (boolean moveToNext = cursor.moveToNext(); moveToNext; moveToNext = cursor.moveToNext()) {
                        arrayList.add(cursor.getString(columnIndex));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                for (i = 0; i < arrayList.size(); i++) {
                    c.b("NewFeedbackTableAdvanced", "questionIds = " + ((String) arrayList.get(i)));
                }
                c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds over");
            } catch (SQLiteException e) {
                try {
                    c.d("NewFeedbackTableAdvanced", "[delete] queryBatchQuestionIds:delete table t_feedback_new  Error");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    for (i = 0; i < arrayList.size(); i++) {
                        c.b("NewFeedbackTableAdvanced", "questionIds = " + ((String) arrayList.get(i)));
                    }
                    c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds over");
                    return arrayList;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    sQLiteDatabase = writableDatabase;
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    for (i = 0; i < arrayList.size(); i++) {
                        c.b("NewFeedbackTableAdvanced", "questionIds = " + ((String) arrayList.get(i)));
                    }
                    c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds over");
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            writableDatabase = cursor;
            c.d("NewFeedbackTableAdvanced", "[delete] queryBatchQuestionIds:delete table t_feedback_new  Error");
            if (cursor != null) {
                cursor.close();
            }
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            for (i = 0; i < arrayList.size(); i++) {
                c.b("NewFeedbackTableAdvanced", "questionIds = " + ((String) arrayList.get(i)));
            }
            c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds over");
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = cursor;
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            for (i = 0; i < arrayList.size(); i++) {
                c.b("NewFeedbackTableAdvanced", "questionIds = " + ((String) arrayList.get(i)));
            }
            c.b("NewFeedbackTableAdvanced", "queryBatchQuestionIds over");
            throw th;
        }
        return arrayList;
    }

    public static C4410d m21125e(C4402c c4402c, String str) {
        C4410d c4410d;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Object obj;
        Throwable th;
        Throwable th2;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase readableDatabase = c4402c.getReadableDatabase();
            if (readableDatabase == null) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (readableDatabase == null) {
                    return cursor2;
                }
                readableDatabase.close();
                return cursor2;
            }
            try {
                Cursor query = readableDatabase.query("t_feedback_advanced", new String[]{"questionId", "questionType", "recordType", "content", "questionDate", "pQuestionId", "picUrl", "picType", "col1", "col2", "col3", "col4", "taskID", "taskStatus", "filePath", "col5"}, "questionId=? and recordType=2", new String[]{str}, null, null, null);
                try {
                    C4410d a = C4404e.m21108a(query);
                    if (query != null) {
                        query.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                        c4410d = a;
                    } else {
                        c4410d = a;
                    }
                } catch (SQLiteException e) {
                    sQLiteDatabase = readableDatabase;
                    cursor = query;
                    try {
                        c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            obj = cursor2;
                        } else {
                            obj = cursor2;
                        }
                        return c4410d;
                    } catch (Throwable th3) {
                        cursor2 = cursor;
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    cursor2 = query;
                    th2 = th4;
                    sQLiteDatabase = readableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                sQLiteDatabase = readableDatabase;
                cursor = cursor2;
                c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    obj = cursor2;
                } else {
                    obj = cursor2;
                }
                return c4410d;
            } catch (Throwable th42) {
                th2 = th42;
                sQLiteDatabase = readableDatabase;
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
            return c4410d;
        } catch (SQLiteException e3) {
            cursor = cursor2;
            sQLiteDatabase = cursor2;
            c.d("NewFeedbackTableAdvanced", "[queryById] query table t_feedback_new  Error");
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                obj = cursor2;
            } else {
                sQLiteDatabase.close();
                obj = cursor2;
            }
            return c4410d;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = cursor2;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    private static C4410d m21108a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("questionId");
        int columnIndex2 = cursor.getColumnIndex("questionType");
        int columnIndex3 = cursor.getColumnIndex("recordType");
        int columnIndex4 = cursor.getColumnIndex("content");
        int columnIndex5 = cursor.getColumnIndex("questionDate");
        int columnIndex6 = cursor.getColumnIndex("pQuestionId");
        int columnIndex7 = cursor.getColumnIndex("picUrl");
        int columnIndex8 = cursor.getColumnIndex("picType");
        int columnIndex9 = cursor.getColumnIndex("col1");
        int columnIndex10 = cursor.getColumnIndex("col2");
        int columnIndex11 = cursor.getColumnIndex("col3");
        int columnIndex12 = cursor.getColumnIndex("col4");
        int columnIndex13 = cursor.getColumnIndex("taskID");
        int columnIndex14 = cursor.getColumnIndex("filePath");
        int columnIndex15 = cursor.getColumnIndex("taskStatus");
        int columnIndex16 = cursor.getColumnIndex("col5");
        if (-1 == columnIndex || -1 == columnIndex2 || -1 == columnIndex3 || -1 == columnIndex4 || -1 == columnIndex5 || -1 == columnIndex6 || -1 == columnIndex7 || -1 == columnIndex8 || -1 == columnIndex9 || -1 == columnIndex10 || -1 == columnIndex11 || -1 == columnIndex12) {
            return null;
        }
        if (!cursor.moveToNext()) {
            return null;
        }
        C4410d c4410d = new C4410d();
        c4410d.m21211h(cursor.getString(columnIndex));
        c4410d.m21213i(cursor.getString(columnIndex2));
        c4410d.m21196c(cursor.getInt(columnIndex3));
        c4410d.m21217k(cursor.getString(columnIndex4));
        c4410d.m21215j(cursor.getString(columnIndex5));
        c4410d.m21221m(cursor.getString(columnIndex6));
        c4410d.m21219l(cursor.getString(columnIndex7));
        c4410d.m21223n(cursor.getString(columnIndex8));
        c4410d.m21225o(cursor.getString(columnIndex9));
        c4410d.m21227p(cursor.getString(columnIndex10));
        c4410d.m21206f(cursor.getInt(columnIndex11));
        c4410d.m21209g(cursor.getString(columnIndex12));
        c4410d.m21207f(cursor.getString(columnIndex13));
        c4410d.m21204e(cursor.getString(columnIndex14));
        c4410d.m21193b(cursor.getInt(columnIndex15));
        c4410d.m21190a(cursor.getString(columnIndex16));
        return c4410d;
    }
}
