package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.p190v.C2538c;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: AppInstallThread */
public class C5379a implements Runnable {
    private Context f19140a;
    private String f19141b;
    private String f19142c;

    public C5379a(Context context, String str, String str2) {
        this.f19140a = context;
        this.f19141b = str;
        this.f19142c = str2;
    }

    public void run() {
        C2538c.b("AppInstallThread", new Object[]{"path=" + this.f19141b + " ,packageName=" + this.f19142c});
        m25863a(this.f19141b);
    }

    private void m25863a(String str) {
        C2538c.b("AppInstallThread", new Object[]{"path=" + str});
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
        this.f19140a.startActivity(intent);
    }
}
