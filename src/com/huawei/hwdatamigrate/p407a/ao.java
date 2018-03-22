package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;

/* compiled from: SportTargetDB */
public class ao {
    public static final String f17470a;
    private static final String[] f17471d = new String[]{"_id", "userid", "targettype", "targetValue", "targetCalorie", "targetDistance"};
    private SQLiteDatabase f17472b;
    private C4780m f17473c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sporttarget(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("targettype integer not null,");
        stringBuilder.append("targetValue integer not null,");
        stringBuilder.append("targetCalorie integer not null,");
        stringBuilder.append("targetDistance integer not null");
        stringBuilder.append(")");
        f17470a = stringBuilder.toString();
    }

    public ao(Context context) {
        this.f17473c = C4780m.m22870a(context);
    }

    public void m22816a() {
        if (this.f17472b == null) {
            this.f17472b = this.f17473c.m22886a();
        }
    }

    public void m22817b() {
        this.f17473c.m22888b();
        this.f17472b = null;
    }

    public ap m22815a(String str) {
        try {
            m22816a();
            String[] strArr = new String[]{str};
            Cursor query = this.f17472b.query("sporttarget", f17471d, "userid= ?", strArr, null, null, null);
            if (query == null) {
                m22817b();
                return null;
            }
            ap apVar;
            if (query.moveToFirst()) {
                apVar = new ap();
                apVar.f17475a = query.getInt(query.getColumnIndex("_id"));
                apVar.f17476b = query.getString(query.getColumnIndex("userid"));
                apVar.f17477c = query.getInt(query.getColumnIndex("targettype"));
                apVar.f17478d = query.getInt(query.getColumnIndex("targetValue"));
                apVar.f17479e = query.getInt(query.getColumnIndex("targetCalorie"));
                apVar.f17480f = query.getInt(query.getColumnIndex("targetDistance"));
            } else {
                apVar = null;
            }
            query.close();
            m22817b();
            return apVar;
        } catch (Exception e) {
            C2538c.e("SportTargetDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }
}
