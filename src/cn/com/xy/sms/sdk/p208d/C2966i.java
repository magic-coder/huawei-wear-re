package cn.com.xy.sms.sdk.p208d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.Hashtable;

public final class C2966i {
    public static Object f10053a = new Object();
    private static C2967j f10054b = null;
    private static int f10055c = 1000;
    private static int f10056d = 100;
    private static Hashtable<SQLiteDatabase, Integer> f10057e = new Hashtable();

    public static void m13336a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                synchronized (f10057e) {
                    if (sQLiteDatabase.isOpen()) {
                        Integer num = (Integer) f10057e.get(sQLiteDatabase);
                        if (num == null) {
                            new StringBuilder("$$$$$ db close cnt is null ").append(sQLiteDatabase.hashCode());
                        } else {
                            num = Integer.valueOf(num.intValue() - 1);
                            if (num.intValue() == 0) {
                                f10057e.remove(sQLiteDatabase);
                                sQLiteDatabase.close();
                            } else {
                                f10057e.put(sQLiteDatabase, num);
                            }
                        }
                    } else {
                        f10057e.remove(sQLiteDatabase);
                    }
                }
                if (f10057e.size() != 0) {
                }
            } catch (Throwable th) {
                C2982a.m13414a("xiaoyuan", "DBManager close error: " + th.getMessage());
            }
        }
    }

    public static void m13337b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table  if not exists tb_base_value (id INTEGER PRIMARY KEY, msgId TEXT,phone TEXT,value TEXT,updateTime INTEGER DEFAULT '0',flag INTEGER DEFAULT '0',extend TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_conversation (id INTEGER PRIMARY KEY, msgId TEXT,phone TEXT,type INTEGER,value TEXT, updateTime INTEGER DEFAULT '0',extend TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists tb_key (id INTEGER PRIMARY KEY,cId TEXT, key TEXT, value TEXT,extend TEXT)");
            sQLiteDatabase.execSQL("create index if not exists indx_key_value on tb_key (key,value)");
            sQLiteDatabase.execSQL("create table  if not exists t_log (log_id TEXT,date_time DATETIME DEFAULT CURRENT_TIMESTAMP,cls_name TEXT,method_name TEXT,log_name TEXT,log_json TEXT)");
            sQLiteDatabase.execSQL("create table  if not exists t_log_exception (except_id  TEXT,date_time DATETIME DEFAULT CURRENT_TIMESTAMP,cls_name TEXT,method_name TEXT,log_name TEXT,log_exception TEXT)");
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "createDb=" + th.getMessage(), th);
        }
    }
}
