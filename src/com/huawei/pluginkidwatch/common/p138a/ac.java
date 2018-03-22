package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: WatchStatusDB */
public class ac {
    public static final String f3013a;
    private static final String[] f3014e = new String[]{"huid", "deviceCode", "lat", "lng", "watchstatus", "buildingname", "streetname", "data1", "data2", "data3"};
    private SQLiteDatabase f3015b;
    private C1393i f3016c;
    private Context f3017d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS watchstatustable(");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode integer,");
        stringBuilder.append("lat NVARCHAR(300) ,");
        stringBuilder.append("lng NVARCHAR(300) ,");
        stringBuilder.append("watchstatus NVARCHAR(300) not null,");
        stringBuilder.append("buildingname NVARCHAR(300) not null,");
        stringBuilder.append("streetname NVARCHAR(300) not null,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append(" primary key(huid,deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("WatchStatusDB", "===createTableSQL", stringBuilder.toString());
        f3013a = stringBuilder.toString();
    }

    public ac(Context context) {
        this.f3017d = context;
        this.f3016c = C1393i.m6319a(context);
    }

    public void m6221a() {
        if (this.f3015b == null) {
            this.f3015b = this.f3016c.m6327a();
        }
    }

    public void m6224b() {
        this.f3016c.m6328b();
        this.f3015b = null;
    }

    public long m6219a(ad adVar) {
        try {
            m6221a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", adVar.m6229b());
            contentValues.put("deviceCode", Integer.valueOf(adVar.m6225a()));
            contentValues.put("lat", C1392h.m6317j(this.f3017d, adVar.m6232c() + ""));
            contentValues.put("lng", C1392h.m6317j(this.f3017d, adVar.m6234d() + ""));
            contentValues.put("watchstatus", C1392h.m6317j(this.f3017d, adVar.m6236e()));
            contentValues.put("buildingname", C1392h.m6317j(this.f3017d, adVar.m6238f()));
            contentValues.put("streetname", C1392h.m6317j(this.f3017d, adVar.m6240g()));
            contentValues.put("data1", C1392h.m6317j(this.f3017d, adVar.m6242h()));
            contentValues.put("data2", C1392h.m6317j(this.f3017d, adVar.m6243i()));
            contentValues.put("data3", C1392h.m6317j(this.f3017d, adVar.m6244j()));
            long insert = this.f3015b.insert("watchstatustable", null, contentValues);
            if (-1 == insert) {
                C2538c.m12680e("WatchStatusDB", "watchStatusDB insert() failed");
            }
            String str = "WatchStatusDB";
            Object[] objArr = new Object[1];
            objArr[0] = "watchStatusDB insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + adVar + ",   values = " + contentValues.toString();
            C2538c.m12674b(str, objArr);
            m6224b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("WatchStatusDB", "watchStatusDB insert() Exception=" + e.getMessage());
            return -1;
        }
    }

    public int m6223b(ad adVar) {
        try {
            m6221a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", adVar.m6229b());
            contentValues.put("deviceCode", Integer.valueOf(adVar.m6225a()));
            contentValues.put("lat", C1392h.m6317j(this.f3017d, adVar.m6232c() + ""));
            contentValues.put("lng", C1392h.m6317j(this.f3017d, adVar.m6234d() + ""));
            contentValues.put("watchstatus", C1392h.m6317j(this.f3017d, adVar.m6236e()));
            contentValues.put("buildingname", C1392h.m6317j(this.f3017d, adVar.m6238f()));
            contentValues.put("streetname", C1392h.m6317j(this.f3017d, adVar.m6240g()));
            contentValues.put("data1", C1392h.m6317j(this.f3017d, adVar.m6242h()));
            contentValues.put("data2", C1392h.m6317j(this.f3017d, adVar.m6243i()));
            contentValues.put("data3", C1392h.m6317j(this.f3017d, adVar.m6244j()));
            int update = this.f3015b.update("watchstatustable", contentValues, "deviceCode= ? and huid like ?", new String[]{String.valueOf(adVar.m6225a()), adVar.m6229b()});
            if (update == 0) {
                C2538c.m12680e("WatchStatusDB", "update() failed");
            }
            String str = "WatchStatusDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + adVar + ", values=" + adVar.toString();
            C2538c.m12674b(str, objArr);
            m6224b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("WatchStatusDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    public ad m6220a(String str, int i) {
        try {
            m6221a();
            String[] strArr = new String[]{String.valueOf(i), str};
            C2538c.m12674b("WatchStatusDB", "================selection:", "deviceCode= ? and huid like ?");
            Cursor query = this.f3015b.query("watchstatustable", f3014e, "deviceCode= ? and huid like ?", strArr, null, null, null);
            if (query == null) {
                m6224b();
                return null;
            }
            ad adVar;
            if (query.moveToFirst()) {
                adVar = new ad();
                adVar.m6227a(query.getInt(query.getColumnIndex("deviceCode")));
                adVar.m6228a(query.getString(query.getColumnIndex("huid")));
                adVar.m6226a(C1492l.m6921e(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("lat")))));
                adVar.m6230b(C1492l.m6921e(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("lng")))));
                adVar.m6231b(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("watchstatus"))));
                adVar.m6233c(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("buildingname"))));
                adVar.m6235d(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("streetname"))));
                adVar.m6237e(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("data1"))));
                adVar.m6239f(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("data2"))));
                adVar.m6241g(C1392h.m6318k(this.f3017d, query.getString(query.getColumnIndex("data3"))));
            } else {
                C2538c.m12674b("WatchStatusDB", "============cursor.moveToFirst() --> else");
                adVar = null;
            }
            if (adVar != null) {
                C2538c.m12674b("WatchStatusDB", "get() DeviceCode=" + i + ", result=" + adVar);
            }
            query.close();
            m6224b();
            C2538c.m12674b("WatchStatusDB", "=========查到结果");
            return adVar;
        } catch (Exception e) {
            C2538c.m12680e("WatchStatusDB", "get() Exception=" + e.getMessage());
            return null;
        }
    }

    public boolean m6222a(String str) {
        try {
            m6221a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("WatchStatusDB", "================ delete all watchStatus associated with current huid,  sql:", "DELETE FROM watchstatustable Where huid like ?");
            this.f3015b.execSQL("DELETE FROM watchstatustable Where huid like ?", strArr);
            m6224b();
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("WatchStatusDB", "deleteAll SQLException e = " + e.getMessage());
            m6224b();
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("WatchStatusDB", "deleteAll Exception e = " + e2.getMessage());
            m6224b();
            return false;
        }
    }
}
