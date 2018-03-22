package com.huawei.android.pushselfshow.richpush.p339a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class C4159c implements C4157a {
    public Cursor mo4385a(Context context, Uri uri, String str, String[] strArr) throws Exception {
        return context.getContentResolver().query(uri, null, null, strArr, null);
    }
}
