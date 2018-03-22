package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.BuildConfig;

/* compiled from: AlarmClockDB */
public class C4770c {
    public static final String f17600a;
    private static final String[] f17601d = new String[]{"_id", "userid", "name", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "week", "check_interval", "check_open", BuildConfig.sdk_log_switch};
    private C4780m f17602b;
    private SQLiteDatabase f17603c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS alarmclock(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("name NVARCHAR(100) not null,");
        stringBuilder.append("time integer not null,");
        stringBuilder.append("week integer not null,");
        stringBuilder.append("check_interval integer not null,");
        stringBuilder.append("check_open integer not null,");
        stringBuilder.append("open integer not null");
        stringBuilder.append(")");
        f17600a = stringBuilder.toString();
    }

    public C4770c(Context context) {
        this.f17602b = C4780m.m22870a(context);
    }

    public void m22850a() {
        if (this.f17603c == null) {
            this.f17603c = this.f17602b.m22886a();
        }
    }

    public void m22851b() {
        this.f17602b.m22888b();
        this.f17603c = null;
    }

    public C4771d m22849a(String str) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        Exception e2;
        try {
            m22850a();
            String[] strArr = new String[]{str};
            query = this.f17603c.query("alarmclock", f17601d, "userid= ?", strArr, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                m22851b();
                return null;
            }
            try {
                C4771d c4771d;
                if (query.moveToFirst()) {
                    boolean z;
                    c4771d = new C4771d();
                    c4771d.f17604a = query.getInt(query.getColumnIndex("_id"));
                    c4771d.f17605b = query.getString(query.getColumnIndex("userid"));
                    c4771d.f17606c = query.getString(query.getColumnIndex("name"));
                    c4771d.f17607d = query.getInt(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                    c4771d.f17608e = query.getInt(query.getColumnIndex("week"));
                    c4771d.f17609f = query.getInt(query.getColumnIndex("check_interval"));
                    c4771d.f17610g = query.getInt(query.getColumnIndex("check_open"));
                    if (query.getInt(query.getColumnIndex(BuildConfig.sdk_log_switch)) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c4771d.f17611h = z;
                } else {
                    c4771d = null;
                }
                if (query != null) {
                    query.close();
                }
                m22851b();
                return c4771d;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    C2538c.e("AlarmClockDB", new Object[]{"get() Exception=" + e.getMessage()});
                    if (query != null) {
                        query.close();
                    }
                    m22851b();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    m22851b();
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                C2538c.e("AlarmClockDB", new Object[]{"get() Exception=" + e2.getMessage()});
                if (query != null) {
                    query.close();
                }
                m22851b();
                return null;
            }
        } catch (SQLiteException e5) {
            e = e5;
            query = null;
            C2538c.e("AlarmClockDB", new Object[]{"get() Exception=" + e.getMessage()});
            if (query != null) {
                query.close();
            }
            m22851b();
            return null;
        } catch (Exception e6) {
            e2 = e6;
            query = null;
            C2538c.e("AlarmClockDB", new Object[]{"get() Exception=" + e2.getMessage()});
            if (query != null) {
                query.close();
            }
            m22851b();
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            m22851b();
            throw th;
        }
    }
}
