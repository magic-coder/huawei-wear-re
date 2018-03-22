package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;

/* compiled from: VoidDisturbDB */
public class bh {
    public static final String f17588a;
    private static final String[] f17589d = new String[]{"_id", "listIndex", JoinConstants.ENABLE, "intervalEnable", "type", "startTime", "endTime", JoinConstants.CYCLE};
    private C4780m f17590b;
    private SQLiteDatabase f17591c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS voiddisturb(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("listIndex integer not null,");
        stringBuilder.append("enable integer not null,");
        stringBuilder.append("intervalEnable integer not null,");
        stringBuilder.append("type integer not null,");
        stringBuilder.append("startTime NVARCHAR(100) not null,");
        stringBuilder.append("endTime NVARCHAR(100) not null,");
        stringBuilder.append("cycle integer not null");
        stringBuilder.append(")");
        f17588a = stringBuilder.toString();
    }

    public bh(Context context) {
        this.f17590b = C4780m.m22870a(context);
    }

    public void m22847a() {
        if (this.f17591c == null) {
            this.f17591c = this.f17590b.m22886a();
        }
    }

    public void m22848b() {
        if (this.f17590b != null) {
            this.f17590b.m22888b();
            this.f17591c = null;
        }
    }

    public bi m22846a(int i) {
        try {
            m22847a();
            Cursor query = this.f17591c.query("voiddisturb", f17589d, "listIndex= ?", new String[]{String.valueOf(i)}, null, null, null);
            if (query == null) {
                m22848b();
                return null;
            }
            bi biVar;
            if (query.moveToFirst()) {
                boolean z;
                biVar = new bi();
                biVar.f17592a = query.getInt(query.getColumnIndex("_id"));
                biVar.f17593b = query.getInt(query.getColumnIndex("listIndex"));
                biVar.f17594c = query.getInt(query.getColumnIndex(JoinConstants.ENABLE)) == 1;
                if (query.getInt(query.getColumnIndex("intervalEnable")) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                biVar.f17595d = z;
                biVar.f17596e = query.getInt(query.getColumnIndex("type"));
                biVar.f17597f = query.getString(query.getColumnIndex("startTime"));
                biVar.f17598g = query.getString(query.getColumnIndex("endTime"));
                biVar.f17599h = query.getInt(query.getColumnIndex(JoinConstants.CYCLE));
            } else {
                biVar = null;
            }
            query.close();
            m22848b();
            if (biVar != null) {
                return biVar;
            }
            C2538c.b("VoidDisturbDB", new Object[]{"get() mod is null "});
            return biVar;
        } catch (Exception e) {
            C2538c.e("VoidDisturbDB", new Object[]{"getByIndex() Exception=" + e.getMessage()});
            return null;
        }
    }
}
