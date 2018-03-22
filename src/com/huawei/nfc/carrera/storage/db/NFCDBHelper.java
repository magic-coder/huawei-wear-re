package com.huawei.nfc.carrera.storage.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.nfc.carrera.storage.db.DataModel.CardProductInfoColumns;
import com.huawei.nfc.carrera.util.LogX;

public class NFCDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wallet_nfc.db";
    private static final int DATABASE_VERSION = 24;
    private static final String TAG = "NFCDBHelper";

    public NFCDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 24);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            createCardProductInfosTable(sQLiteDatabase);
            createIssuerInfosTable(sQLiteDatabase);
            createReportStatusInfosTable(sQLiteDatabase);
            createCardOrderTable(sQLiteDatabase);
            createRFConfInfoTable(sQLiteDatabase);
        } catch (SQLException e) {
            LogX.m5470e(TAG, "SQLException e ： " + e.getMessage());
        } catch (Exception e2) {
            LogX.m5470e(TAG, "Exception e : " + e2.getMessage());
        }
    }

    private void createCardProductInfosTable(SQLiteDatabase sQLiteDatabase) {
        LogX.m5466d(TAG, "createCardProductInfosTable begin");
        sQLiteDatabase.execSQL("CREATE TABLE card_product_info (product_id TEXT PRIMARY KEY NOT NULL,name TEXT,pic_url TEXT,description TEXT,card_type INTEGER,timestamp LONG,version TEXT,issuer_id TEXT,mkt_info TEXT,reserved_info TEXT,font_color TEXT,reserved_1 TEXT,reserved_2 TEXT,reserved_3 TEXT,reserved_4 TEXT,reserved_5 TEXT,reserved_6 TEXT);");
        LogX.m5466d(TAG, "createCardProductInfosTable end");
    }

    private void createIssuerInfosTable(SQLiteDatabase sQLiteDatabase) {
        LogX.m5466d(TAG, "createCardProductInfosTable begin");
        sQLiteDatabase.execSQL("CREATE TABLE issuer_info (issuer_id TEXT PRIMARY KEY NOT NULL,name TEXT,description TEXT,logo_url TEXT,issuer_type INTEGER,support_card_type INTEGER,mode INTEGER,wallet_version TEXT,contact_num TEXT,debit_callcenter_num TEXT,credit_call_center_num TEXT,debit_tcurl TEXT,credit_tcurl TEXT,debit_website_url TEXT,credit_website_url TEXT,app_info TEXT,timestamp LONG,sn INTEGER ,reserved_info TEXT);");
        LogX.m5466d(TAG, "createIssuerInfosTable end");
    }

    private void createReportStatusInfosTable(SQLiteDatabase sQLiteDatabase) {
        LogX.m5466d(TAG, "createReportCardInfosTable begin");
        sQLiteDatabase.execSQL("CREATE TABLE report_status_info (aid TEXT PRIMARY KEY NOT NULL,user_id TEXT,status TEXT,extra INTEGER,dpanid TEXT,card_name TEXT,card_number TEXT,issuserid TEXT,card_type INTEGER);");
        LogX.m5466d(TAG, "createReportCardInfosTable end");
    }

    private void createCardOrderTable(SQLiteDatabase sQLiteDatabase) {
        LogX.m5466d(TAG, "createCardOrderTable begin");
        sQLiteDatabase.execSQL("CREATE TABLE card_order_info (reference_id TEXT PRIMARY KEY NOT NULL,timestamp LONG);");
        LogX.m5466d(TAG, "createCardOrderTable end");
    }

    private void createRFConfInfoTable(SQLiteDatabase sQLiteDatabase) {
        LogX.m5466d(TAG, "createRFConfInfoTable begin");
        sQLiteDatabase.execSQL("CREATE TABLE rf_conf_info (issuer_id TEXT PRIMARY KEY NOT NULL,model TEXT,rom_version TEXT,rf_conf_url TEXT,timestamp LONG);");
        LogX.m5466d(TAG, "createRFConfInfoTable end");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            LogX.m5465d("NFCDBHelper onUpgrade.");
            if (i < 16) {
                upgradeDBToVer16(sQLiteDatabase);
            }
            if (i < 17) {
                upgradeDBToVer17(sQLiteDatabase);
            }
            if (i < 18) {
                upgradeDBToVer18(sQLiteDatabase);
            }
            if (i < 19) {
                upgradeDBToVer19(sQLiteDatabase);
            }
            if (i < 20) {
                upgradeDBToVer20(sQLiteDatabase);
            }
            if (i < 21) {
                upgradeDBToVer21(sQLiteDatabase);
            }
            if (i < 22) {
                upgradeDBToVer22(sQLiteDatabase);
            }
            if (i < 23) {
                upgradeDBToVer23(sQLiteDatabase);
            }
            if (i < 24) {
                upgradeDBToVer24(sQLiteDatabase);
            }
        } catch (SQLException e) {
            LogX.m5465d("OnUpgrade : Update db failed.");
        } catch (Exception e2) {
            LogX.m5465d("OnUpgrade : Exception Update db failed.");
        }
    }

    private void upgradeDBToVer16(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        createCardProductInfosTable(sQLiteDatabase);
        createIssuerInfosTable(sQLiteDatabase);
        sQLiteDatabase.execSQL("drop table user_card_info;");
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer17(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("alter table report_status_info add extra INTEGER");
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer18(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        createCardOrderTable(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer19(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("alter table report_status_info add dpanid TEXT");
        sQLiteDatabase.execSQL("alter table report_status_info add card_name TEXT");
        sQLiteDatabase.execSQL("alter table report_status_info add card_number TEXT");
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer20(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("drop table issuer_info");
        createIssuerInfosTable(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer21(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("alter table report_status_info add issuserid TEXT");
        sQLiteDatabase.execSQL("alter table report_status_info add card_type INTEGER");
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer22(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("alter table issuer_info add sn INTEGER");
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void upgradeDBToVer23(SQLiteDatabase sQLiteDatabase) {
        LogX.m5476i(TAG, " enter upgradeDBToVer23");
        if (!isExistField(sQLiteDatabase, CardProductInfoColumns.TABLE_NAME, CardProductInfoColumns.COLUMN_NAME_FONT_COLOR)) {
            LogX.m5476i(TAG, " upgradeDBToVer23 begin ");
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("alter table card_product_info add font_color TEXT");
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
        LogX.m5476i(TAG, " upgradeDBToVer23 end ");
    }

    private void upgradeDBToVer24(SQLiteDatabase sQLiteDatabase) {
        LogX.m5475i("NFCDBHelper upgradeDBToVer24");
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS card_product_info");
        createCardProductInfosTable(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        LogX.m5475i("NFCDBHelper upgradeDBToVer24 end");
    }

    private boolean isExistField(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name = '").append(str).append("' AND sql LIKE '%").append(str2).append("%'");
        try {
            Cursor query = sQLiteDatabase.query("sqlite_master", null, stringBuilder.toString(), null, null, null, null);
            try {
                boolean z = query.getCount() > 0;
                if (query == null) {
                    return z;
                }
                query.close();
                return z;
            } catch (SQLException e) {
                cursor = query;
                try {
                    LogX.m5475i("DB does not contain file : " + str2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLException e2) {
            cursor = null;
            LogX.m5475i("DB does not contain file : " + str2);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
