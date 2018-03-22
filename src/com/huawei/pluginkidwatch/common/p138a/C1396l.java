package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import java.util.ArrayList;

/* compiled from: FamilyMemberDB */
public class C1396l {
    public static final String f3104a;
    private static final String[] f3105e = new String[]{"bigheadicon", "deviceCode", "headicon", "huid", "id", "nikename", "phoneNum", "privilege", "shortphoneNum", "type", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3106b;
    private C1393i f3107c;
    private Context f3108d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS family_memberdb(");
        stringBuilder.append("bigheadicon NVARCHAR(1500) ,");
        stringBuilder.append("deviceCode  NVARCHAR(300) not null,");
        stringBuilder.append("headicon NVARCHAR(1500) ,");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("id NVARCHAR(300) ,");
        stringBuilder.append("nikename NVARCHAR(300) not null,");
        stringBuilder.append("phoneNum NVARCHAR(300) ,");
        stringBuilder.append("privilege NVARCHAR(300) ,");
        stringBuilder.append("shortphoneNum NVARCHAR(300) ,");
        stringBuilder.append("type NVARCHAR(300) not null,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append("data4 NVARCHAR(300) ,");
        stringBuilder.append("data5 NVARCHAR(300) ,");
        stringBuilder.append("primary key(huid)");
        stringBuilder.append(")");
        C2538c.m12674b("FamilyMemberDB", "===createTableSQL", stringBuilder.toString());
        f3104a = stringBuilder.toString();
    }

    public C1396l(Context context) {
        this.f3107c = C1393i.m6319a(context);
        this.f3108d = context;
    }

    public void m6347a() {
        if (this.f3106b == null) {
            this.f3106b = this.f3107c.m6327a();
        }
    }

    public void m6348b() {
        this.f3107c.m6328b();
        this.f3106b = null;
    }

    public C1397m m6346a(String str) {
        Exception e;
        Cursor query;
        try {
            m6347a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("FamilyMemberDB", "================selection:", "huid like ?");
            if (this.f3106b != null) {
                query = this.f3106b.query("family_memberdb", f3105e, r3, strArr, null, null, null);
            } else {
                query = null;
            }
            if (query == null) {
                try {
                    m6348b();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    C2538c.m12680e("FamilyMemberDB", "get() Exception=" + e.getMessage());
                    if (query != null) {
                        query.close();
                        m6348b();
                    }
                    return null;
                }
            }
            C1397m c1397m;
            if (query.moveToFirst()) {
                c1397m = new C1397m();
                c1397m.f3109a = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("bigheadicon")));
                c1397m.f3111c = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("headicon")));
                c1397m.f3119k = query.getString(query.getColumnIndex("type"));
                c1397m.f3112d = query.getString(query.getColumnIndex("huid"));
                c1397m.f3114f = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("nikename")));
            } else {
                c1397m = null;
            }
            query.close();
            m6348b();
            return c1397m;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C2538c.m12680e("FamilyMemberDB", "get() Exception=" + e.getMessage());
            if (query != null) {
                query.close();
                m6348b();
            }
            return null;
        }
    }

    public long m6345a(UserInfo userInfo, String str) {
        try {
            long insert;
            m6347a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", userInfo.huid);
            contentValues.put("bigheadicon", C1392h.m6317j(this.f3108d, userInfo.bigHeadIcon));
            contentValues.put("headicon", C1392h.m6317j(this.f3108d, userInfo.headIcon));
            contentValues.put("deviceCode", userInfo.deviceCode);
            contentValues.put("id", Integer.valueOf(userInfo.id));
            contentValues.put("nikename", C1392h.m6317j(this.f3108d, userInfo.nickname));
            contentValues.put("phoneNum", C1392h.m6317j(this.f3108d, userInfo.phoneNum));
            contentValues.put("privilege", userInfo.privilege);
            contentValues.put("type", userInfo.type);
            contentValues.put("shortphoneNum", "");
            contentValues.put("data1", "");
            contentValues.put("data2", "");
            contentValues.put("data3", "");
            contentValues.put("data4", "");
            contentValues.put("data5", "");
            if (this.f3106b != null) {
                insert = this.f3106b.insert("family_memberdb", null, contentValues);
            } else {
                insert = -1;
            }
            if (-1 == insert) {
                C2538c.m12680e("FamilyMemberDB", "insert() failed");
            }
            String str2 = "FamilyMemberDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + userInfo + ", values=" + contentValues.toString();
            C2538c.m12674b(str2, objArr);
            m6348b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("FamilyMemberDB", "insert() Exception=" + e.getMessage());
            m6348b();
            return -1;
        }
    }

    public void m6349b(UserInfo userInfo, String str) {
        if (userInfo != null) {
            if (m6346a(userInfo.huid) != null) {
                m6351c(userInfo.huid);
            }
            m6345a(userInfo, str);
        }
    }

    public boolean m6350b(String str) {
        try {
            m6347a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("FamilyMemberDB", "================ delete all voice   sql:", "DELETE FROM family_memberdb Where deviceCode like ?");
            if (this.f3106b != null) {
                this.f3106b.execSQL(r2, strArr);
            }
            m6348b();
            return true;
        } catch (SQLException e) {
            C2538c.m12674b("FamilyMemberDB", "===========ERROR:" + e.getMessage());
            m6348b();
            return false;
        }
    }

    public boolean m6351c(String str) {
        try {
            m6347a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("FamilyMemberDB", "================ delete all voice   sql:", "DELETE FROM family_memberdb Where huid like ?");
            if (this.f3106b != null) {
                this.f3106b.execSQL(r2, strArr);
            }
            m6348b();
            return true;
        } catch (SQLException e) {
            C2538c.m12674b("FamilyMemberDB", "===========ERROR:" + e.getMessage());
            m6348b();
            return false;
        }
    }

    public ArrayList<C1397m> m6352d(String str) {
        Cursor query;
        Object obj = null;
        m6347a();
        String[] strArr = new String[]{str};
        C2538c.m12674b("FamilyMemberDB", "================getAll selection:", "deviceCode= ?");
        if (this.f3106b != null) {
            query = this.f3106b.query("family_memberdb", f3105e, r3, strArr, null, null, null);
        } else {
            query = null;
        }
        if (query == null) {
            m6348b();
            return null;
        }
        ArrayList<C1397m> arrayList = new ArrayList();
        while (query.moveToNext()) {
            obj = new C1397m();
            obj.f3109a = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("bigheadicon")));
            obj.f3111c = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("headicon")));
            obj.f3119k = query.getString(query.getColumnIndex("type"));
            obj.f3112d = query.getString(query.getColumnIndex("huid"));
            obj.f3114f = C1392h.m6318k(this.f3108d, query.getString(query.getColumnIndex("nikename")));
            arrayList.add(obj);
        }
        if (obj != null) {
            C2538c.m12674b("FamilyMemberDB", "get() DeviceCode=" + str + ", result=" + obj);
        }
        query.close();
        m6348b();
        C2538c.m12674b("FamilyMemberDB", "=========查到结果");
        return arrayList;
    }
}
