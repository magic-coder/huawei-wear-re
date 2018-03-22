package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: UpdateDB */
public class C1409y {
    public static final String f3205a;
    private static final String[] f3206d = new String[]{"huid", "deviceCode", "isClickedFlag", "stutus", LightCloudConstants.RESPONSE_RESULT_SUCCESS, "versionBefore", "versionAfter", "data1", "data2", "data3"};
    private SQLiteDatabase f3207b;
    private C1393i f3208c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS updatetable(");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode integer,");
        stringBuilder.append("isClickedFlag integer,");
        stringBuilder.append("stutus NVARCHAR(300) not null,");
        stringBuilder.append("success integer,");
        stringBuilder.append("versionBefore NVARCHAR(300) not null,");
        stringBuilder.append("versionAfter NVARCHAR(300) not null,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append(" primary key(huid,deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("UpdateDB", "===createTableSQL", stringBuilder.toString());
        f3205a = stringBuilder.toString();
    }

    public C1409y(Context context) {
        this.f3208c = C1393i.m6319a(context);
    }

    public void m6444a() {
        if (this.f3207b == null) {
            this.f3207b = this.f3208c.m6327a();
        }
    }

    public void m6446b() {
        this.f3208c.m6328b();
        this.f3207b = null;
    }

    public long m6442a(C1410z c1410z) {
        try {
            m6444a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", c1410z.f3209a);
            contentValues.put("deviceCode", Integer.valueOf(c1410z.f3215g));
            contentValues.put("isClickedFlag", Boolean.valueOf(c1410z.f3210b));
            contentValues.put("stutus", Integer.valueOf(c1410z.f3211c));
            contentValues.put(LightCloudConstants.RESPONSE_RESULT_SUCCESS, Integer.valueOf(c1410z.f3212d ? 1 : 0));
            contentValues.put("versionBefore", c1410z.f3213e);
            contentValues.put("versionAfter", c1410z.f3214f);
            contentValues.put("data1", c1410z.f3216h);
            contentValues.put("data2", c1410z.f3217i);
            contentValues.put("data3", c1410z.f3218j);
            long insert = this.f3207b.insert("updatetable", null, contentValues);
            if (-1 == insert) {
                C2538c.m12680e("UpdateDB", "UpdateDB insert() failed");
            }
            String str = "UpdateDB";
            Object[] objArr = new Object[1];
            objArr[0] = "UpdateDB insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1410z + ", values=" + contentValues.toString();
            C2538c.m12674b(str, objArr);
            m6446b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("UpdateDB", "UpdateDB insert() Exception=" + e.getMessage());
            return -1;
        }
    }

    public int m6445b(C1410z c1410z) {
        try {
            m6444a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", c1410z.f3209a);
            contentValues.put("deviceCode", Integer.valueOf(c1410z.f3215g));
            contentValues.put("isClickedFlag", Boolean.valueOf(c1410z.f3210b));
            contentValues.put("stutus", Integer.valueOf(c1410z.f3211c));
            contentValues.put(LightCloudConstants.RESPONSE_RESULT_SUCCESS, Integer.valueOf(c1410z.f3212d ? 1 : 0));
            contentValues.put("versionBefore", c1410z.f3213e);
            contentValues.put("versionAfter", c1410z.f3214f);
            contentValues.put("data1", c1410z.f3216h);
            contentValues.put("data2", c1410z.f3217i);
            contentValues.put("data3", c1410z.f3218j);
            int update = this.f3207b.update("updatetable", contentValues, "deviceCode= ? and huid like ?", new String[]{String.valueOf(c1410z.f3215g), c1410z.f3209a});
            if (update == 0) {
                C2538c.m12680e("UpdateDB", "update() failed");
            }
            String str = "UpdateDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1410z + ", values=" + c1410z.toString();
            C2538c.m12674b(str, objArr);
            m6446b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("UpdateDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    public C1410z m6443a(String str, int i) {
        try {
            m6444a();
            String[] strArr = new String[]{String.valueOf(i), str};
            C2538c.m12674b("UpdateDB", "================selection:", "deviceCode= ? and huid like ?");
            Cursor query = this.f3207b.query("updatetable", f3206d, "deviceCode= ? and huid like ?", strArr, null, null, null);
            if (query == null) {
                m6446b();
                return null;
            }
            C1410z c1410z;
            Object obj;
            if (query.moveToFirst()) {
                boolean z;
                c1410z = new C1410z();
                c1410z.f3215g = query.getInt(query.getColumnIndex("deviceCode"));
                c1410z.f3209a = query.getString(query.getColumnIndex("huid"));
                c1410z.f3210b = query.getInt(query.getColumnIndex("isClickedFlag")) == 1;
                c1410z.f3211c = query.getInt(query.getColumnIndex("stutus"));
                if (query.getInt(query.getColumnIndex(LightCloudConstants.RESPONSE_RESULT_SUCCESS)) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                c1410z.f3212d = z;
                c1410z.f3214f = query.getString(query.getColumnIndex("versionAfter"));
                c1410z.f3213e = query.getString(query.getColumnIndex("versionBefore"));
                c1410z.f3216h = query.getString(query.getColumnIndex("data1"));
                c1410z.f3217i = query.getString(query.getColumnIndex("data2"));
                c1410z.f3218j = query.getString(query.getColumnIndex("data3"));
            } else {
                c1410z = null;
            }
            String str2 = "UpdateDB";
            Object[] objArr = new Object[1];
            StringBuilder append = new StringBuilder().append("get() DeviceCode=").append(i).append(", result=");
            if (c1410z == null) {
                obj = "null";
            } else {
                C1410z c1410z2 = c1410z;
            }
            objArr[0] = append.append(obj).toString();
            C2538c.m12674b(str2, objArr);
            query.close();
            m6446b();
            C2538c.m12674b("UpdateDB", "=========查到结果");
            return c1410z;
        } catch (Exception e) {
            C2538c.m12680e("UpdateDB", "get() Exception=" + e.getMessage());
            return null;
        }
    }

    public boolean m6447b(String str, int i) {
        try {
            m6444a();
            String[] strArr = new String[]{String.valueOf(i), str};
            C2538c.m12674b("UpdateDB", "================ delete all deviceinfo   sql:", "DELETE FROM updatetable Where deviceCode = ? and huid like ?");
            this.f3207b.execSQL("DELETE FROM updatetable Where deviceCode = ? and huid like ?", strArr);
            m6446b();
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("UpdateDB", "deleteById SQLException e = " + e.getMessage());
            m6446b();
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("UpdateDB", "deleteById Exception e = " + e2.getMessage());
            m6446b();
            return false;
        }
    }
}
