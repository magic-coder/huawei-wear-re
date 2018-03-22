package com.huawei.operation;

import android.content.Context;
import android.content.Intent;
import com.huawei.ah.a;
import com.huawei.operation.activity.WebViewActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: PluginOperation */
public class C5708a extends a {
    private static volatile C5708a f19458a;
    private Context f19459b;

    public static C5708a m26333a(Context context) {
        if (f19458a == null) {
            synchronized (C5708a.class) {
                if (f19458a == null) {
                    f19458a = new C5708a(context);
                }
            }
        }
        return f19458a;
    }

    private C5708a(Context context) {
        this.f19459b = context;
    }

    public void m26334a(String str) {
        Intent intent = new Intent(this.f19459b, WebViewActivity.class);
        intent.putExtra("url", str);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f19459b.startActivity(intent);
    }
}
