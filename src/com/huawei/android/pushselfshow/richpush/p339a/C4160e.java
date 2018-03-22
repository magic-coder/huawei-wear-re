package com.huawei.android.pushselfshow.richpush.p339a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.p345a.C4200b;

public class C4160e implements C4157a {
    private String f15632a;

    public C4160e() {
        this.f15632a = null;
        this.f15632a = null;
    }

    protected C4160e(String str) {
        this.f15632a = null;
        this.f15632a = str;
    }

    public Cursor mo4385a(Context context, Uri uri, String str, String[] strArr) throws Exception {
        SQLiteDatabase readableDatabase = m20308a(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                return readableDatabase.rawQuery(str, strArr);
            } catch (Throwable e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
        }
        return null;
    }

    C4200b m20308a(Context context) {
        return this.f15632a == null ? C4200b.m20398a(context) : C4200b.m20399a(context, this.f15632a);
    }
}
