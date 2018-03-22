package com.huawei.android.pushselfshow.utils.p345a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;

public class C4200b extends SQLiteOpenHelper {
    private static C4200b f15808a = null;
    private static C4200b f15809b = null;

    private C4200b(Context context) {
        super(context, "push.db", null, 1);
        e.a("PushSelfShowLog", "DBHelper instance, version is 1");
    }

    private C4200b(Context context, String str) {
        super(context, str, null, 1);
        e.a("PushSelfShowLog", "DBHelper instance, version is 1");
    }

    public static synchronized C4200b m20398a(Context context) {
        C4200b c4200b;
        synchronized (C4200b.class) {
            if (f15808a != null) {
                c4200b = f15808a;
            } else {
                f15808a = new C4200b(context);
                c4200b = f15808a;
            }
        }
        return c4200b;
    }

    public static synchronized C4200b m20399a(Context context, String str) {
        C4200b c4200b;
        synchronized (C4200b.class) {
            if (f15809b != null) {
                c4200b = f15809b;
            } else {
                f15809b = new C4200b(context, str);
                c4200b = f15809b;
            }
        }
        return c4200b;
    }

    private void m20400a(SQLiteDatabase sQLiteDatabase) {
        e.a("PushSelfShowLog", "updateVersionFrom0To1");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(SNBConstant.FIELD_TOKEN, HwAccountConstants.BLANK.getBytes(GameManager.DEFAULT_CHARSET));
            sQLiteDatabase.update("pushmsg", contentValues, null, null);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private boolean m20401a(SQLiteDatabase sQLiteDatabase, String str) {
        Throwable e;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor query;
        try {
            query = sQLiteDatabase.query("sqlite_master", null, "(tbl_name='" + str + "')", null, null, null, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    boolean z = query.getCount() > 0;
                    if (query != null) {
                        query.close();
                    }
                    return z;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.c("PushSelfShowLog", e.toString(), e);
                        if (query != null) {
                            return false;
                        }
                        query.close();
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            } else if (query == null) {
                return false;
            } else {
                query.close();
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            e.c("PushSelfShowLog", e.toString(), e);
            if (query != null) {
                return false;
            }
            query.close();
            return false;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        e.a("PushSelfShowLog", "onCreate");
        if (m20401a(sQLiteDatabase, "pushmsg")) {
            e.a("PushSelfShowLog", "old table is exist");
            onUpgrade(sQLiteDatabase, 0, 1);
            return;
        }
        try {
            sQLiteDatabase.execSQL("create table notify(url  TEXT  PRIMARY KEY , bmp  BLOB );");
            sQLiteDatabase.execSQL("create table pushmsg( _id INTEGER PRIMARY KEY AUTOINCREMENT, url  TEXT  , token  BLOB ,msg  BLOB );");
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e.a("PushSelfShowLog", "onDowngrade,oldVersion:" + i + ",newVersion:" + i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e.a("PushSelfShowLog", "onUpgrade,oldVersion:" + i + ",newVersion:" + i2);
        if (i == 0) {
            m20400a(sQLiteDatabase);
        }
    }
}
