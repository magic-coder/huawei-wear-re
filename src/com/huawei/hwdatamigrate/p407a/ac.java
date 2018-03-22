package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultAlarmClockDB */
public class ac {
    public static final String f17379a;
    private static final String[] f17380d = new String[]{"_id", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "week", "info", BuildConfig.sdk_log_switch, "infoSize"};
    private C4780m f17381b;
    private SQLiteDatabase f17382c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS multalarmclock(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("time integer not null,");
        stringBuilder.append("week integer not null,");
        stringBuilder.append("info NVARCHAR(100) not null,");
        stringBuilder.append("open integer not null,");
        stringBuilder.append("infoSize integer not null");
        stringBuilder.append(")");
        f17379a = stringBuilder.toString();
    }

    public ac(Context context) {
        this.f17381b = C4780m.m22870a(context);
    }

    public void m22782a() {
        if (this.f17382c == null) {
            this.f17382c = this.f17381b.m22886a();
        }
    }

    public void m22783b() {
        if (this.f17381b != null) {
            this.f17381b.m22888b();
            this.f17382c = null;
        }
    }

    public List<ad> m22784c() {
        try {
            m22782a();
            List<ad> arrayList = new ArrayList();
            Cursor query = this.f17382c.query("multalarmclock", f17380d, null, null, null, null, "time asc");
            if (query == null) {
                C2538c.b("MultAlarmClockDB", new Object[]{"Cursor == null"});
                m22783b();
                return null;
            }
            while (query.moveToNext()) {
                ad adVar = new ad();
                adVar.f17383a = query.getInt(query.getColumnIndex("_id"));
                adVar.f17384b = query.getInt(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                adVar.f17385c = query.getInt(query.getColumnIndex("week"));
                adVar.f17386d = query.getString(query.getColumnIndex("info"));
                adVar.f17387e = query.getInt(query.getColumnIndex(BuildConfig.sdk_log_switch)) == 1;
                adVar.f17388f = query.getInt(query.getColumnIndex("infoSize"));
                arrayList.add(adVar);
            }
            query.close();
            m22783b();
            return arrayList;
        } catch (Exception e) {
            C2538c.e("MultAlarmClockDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }
}
