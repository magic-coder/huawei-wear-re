package com.huawei.feedback.p033a.p034a;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: NewFeedbackTable */
public final class C4403d implements BaseColumns {
    public static void m21105a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_feedback_new(_id INTEGER PRIMARY KEY AUTOINCREMENT, questionId varchar(256), questionType varchar(256), recordType integer, content varchar(4000), questionDate varchar(256), picUrl varchar(256), picType varchar(256), pQuestionId varchar(256),col1 varchar(256),col2 varchar(256),col3 varchar(256),col4 varchar(4000),col5 varchar(256))");
            } catch (SQLException e) {
                c.d("NewFeedbackTable", "create table t_feedback_new Error");
            }
        }
    }
}
