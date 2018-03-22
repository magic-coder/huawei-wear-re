package cn.com.xy.sms.sdk.p208d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2969l extends SQLiteOpenHelper {
    public C2969l(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 40);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            C2922b.m13151b(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "MyDbHelper onCreate error: " + th.getMessage(), th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_sdk_param");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_phone_info");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_public_info");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_public_menu_info");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_public_num_info");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_centernum_location_info");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_scene_config");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_res_download");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_scenerule_config");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_jar_list");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_count_scene");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_popup_action_scene");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_menu_action");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_button_action_scene");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_train6");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_air");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_menu_list");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_match_cache");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_update_task");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_xml_res_download");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_resourse_queue");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_phone_bubble_cache");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_netquery_time");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_num_name");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_sms_parse_recorder");
            sQLiteDatabase.execSQL(" DROP TABLE IF EXISTS tb_shard_data");
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyaun", "DBManager onDowngrade" + th.getMessage(), th);
        }
        C2922b.m13151b(sQLiteDatabase);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        try {
            super.onOpen(sQLiteDatabase);
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "MyDbHelper onOpen error: " + th.getMessage(), th);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2922b.m13151b(sQLiteDatabase);
    }
}
