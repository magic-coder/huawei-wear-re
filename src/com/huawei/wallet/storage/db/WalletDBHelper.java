package com.huawei.wallet.storage.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.model.unicard.BankAppInfo;
import com.huawei.wallet.model.unicard.UniCardInfo;

public final class WalletDBHelper extends SQLiteOpenHelper {
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(TbScript.m28127a("bankapp", BankAppInfo.class));
            sQLiteDatabase.execSQL(TbScript.m28127a("unicard", UniCardInfo.class));
        } catch (SQLException e) {
            C2538c.e("WalletDBHelper", new Object[]{"SQLException e ： " + e.getMessage()});
        } catch (Exception e2) {
            C2538c.e("WalletDBHelper", new Object[]{"Exception e ： " + e2.getMessage()});
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(TbScript.m28126a("bankapp"));
            sQLiteDatabase.execSQL(TbScript.m28126a("unicard"));
            sQLiteDatabase.execSQL(TbScript.m28127a("bankapp", BankAppInfo.class));
            sQLiteDatabase.execSQL(TbScript.m28127a("unicard", UniCardInfo.class));
        } catch (SQLException e) {
            C2538c.e("WalletDBHelper", new Object[]{"SQLException e ： " + e.getMessage()});
        } catch (Exception e2) {
            C2538c.e("WalletDBHelper", new Object[]{"Exception e ： " + e2.getMessage()});
        }
    }
}
