package com.huawei.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.wallet.utils.log.LogC;
import net.sqlcipher.database.SQLiteDatabase;

public class BaseLibUtil {
    public static void jumpToSettings(Context context) {
        if (context != null) {
            Intent intent = new Intent("android.settings.SETTINGS");
            if (!(context instanceof Activity)) {
                LogC.m28527a("context is not Activity", false);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(intent);
            return;
        }
        LogC.m28532c("jumpToSettings but context is null", false);
    }
}
