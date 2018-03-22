package com.huawei.crowdtestsdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.uploadlog.p188c.C2511g;

public class FeedBackDatabean extends SQLiteOpenHelper {
    public FeedBackDatabean(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, 38);
        C2511g.m12481b("BETACLUB_SDK", "[FeedBackDatabean.onCreate]DATABASE——>crowdtestsdk.db  is created!");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feedback_history (_id INTEGER PRIMARY KEY,type INTEGER,description TEXT,date TEXT,state TEXT,probability INTEGER default 0,log_id INTEGER,log_path varchar(100) default '',only_log_path varchar(100) default '',is_draft INTEGER,activity_id TEXT,activity_name TEXT,device BLOB,tbdts_no TEXT,create_type INTEGER,send_type INTEGER,send_status TEXT,occurrence_time INTEGER,audio_attach TEXT,camera_attach_list varchar(400) default '',other_attach_list varchar(400) default '',issue_maker_id INTEGER,reserve1 TEXT,reserve2 TEXT,reserve3 TEXT '');");
        C2511g.m12481b("BETACLUB_SDK", "[FeedBackDatabean.onCreate]table——>feedback_history is created!");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feedback_project (_id INTEGER PRIMARY KEY,project_id TEXT UNIQUE,project_name TEXT,total_issue_count INTEGER default 0,total_unhandle_issue_count INTEGER default 0,date INTEGER,version_list TEXT,device BLOB,group_id TEXT,group_member TEXT,product_type TEXT,reserve1 TEXT,reserve2 TEXT,reserve3 TEXT '');");
        C2511g.m12481b("BETACLUB_SDK", "[FeedBackDatabean.onCreate]table——>feedback_project is created!");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feedback_issue (_id INTEGER PRIMARY KEY,project_id TEXT,issue_id TEXT,ques_id TEXT,issue_state TEXT,issue_description TEXT,create_time TEXT,current_handler TEXT,issue_creater TEXT,reserve1 TEXT,reserve2 TEXT,reserve3 TEXT '');");
        C2511g.m12481b("BETACLUB_SDK", "[FeedBackDatabean.onCreate]table——>feedback_issue is created!");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2511g.m12483c("BETACLUB_SDK", "Upgrading database from version " + i + " to " + i2);
        onCreate(sQLiteDatabase);
    }
}
