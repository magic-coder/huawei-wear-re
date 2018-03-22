package com.huawei.hwdatamigrate.p407a;

import com.sina.weibo.sdk.constant.WBConstants;

/* compiled from: PushAbilityDB */
public class af {
    public static final String f17391a;
    private static final String[] f17392b = new String[]{"_id", "kitwatch", WBConstants.ACTION_LOG_TYPE_MESSAGE};

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS pushAbility(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("kitwatch INT ");
        stringBuilder.append("message INT ");
        stringBuilder.append(")");
        f17391a = stringBuilder.toString();
    }
}
