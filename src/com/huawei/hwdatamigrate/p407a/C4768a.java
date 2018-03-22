package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.BuildConfig;

/* compiled from: ActivityRemindDB */
public class C4768a {
    public static final String f17371a;
    private static final String[] f17372d = new String[]{"_id", "userid", LogBuilder.KEY_START_TIME, LogBuilder.KEY_END_TIME, "interval", "week", BuildConfig.sdk_log_switch};
    private SQLiteDatabase f17373b;
    private C4780m f17374c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS activityremind(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("starttime DATETIME not null,");
        stringBuilder.append("endtime DATETIME not null,");
        stringBuilder.append("interval integer not null,");
        stringBuilder.append("week integer not null,");
        stringBuilder.append("open integer not null");
        stringBuilder.append(")");
        f17371a = stringBuilder.toString();
    }

    public C4768a(Context context) {
        this.f17374c = C4780m.m22870a(context);
    }

    public void m22780a() {
        if (this.f17373b == null) {
            this.f17373b = this.f17374c.m22886a();
        }
    }

    public void m22781b() {
        this.f17374c.m22888b();
        this.f17373b = null;
    }

    public C4769b m22779a(String str) {
        try {
            m22780a();
            Cursor query = this.f17373b.query("activityremind", f17372d, "userid= ?", new String[]{str}, null, null, null);
            if (query == null) {
                m22781b();
                return null;
            }
            C4769b c4769b;
            if (query.moveToFirst()) {
                c4769b = new C4769b();
                c4769b.f17530a = query.getInt(query.getColumnIndex("_id"));
                c4769b.f17531b = query.getString(query.getColumnIndex("userid"));
                c4769b.f17532c = query.getString(query.getColumnIndex(LogBuilder.KEY_START_TIME));
                c4769b.f17533d = query.getString(query.getColumnIndex(LogBuilder.KEY_END_TIME));
                c4769b.f17534e = query.getInt(query.getColumnIndex("interval"));
                c4769b.f17535f = query.getInt(query.getColumnIndex("week"));
                c4769b.f17536g = query.getInt(query.getColumnIndex(BuildConfig.sdk_log_switch)) == 1;
            } else {
                c4769b = null;
            }
            query.close();
            m22781b();
            return c4769b;
        } catch (Exception e) {
            C2538c.e("ActivityRemindDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }
}
