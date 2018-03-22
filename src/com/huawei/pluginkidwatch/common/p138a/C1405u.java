package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: RewardReachedDB */
public class C1405u {
    public static final String f3174a;
    private static final String[] f3175e = new String[]{"deviceCode", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "goalnum", "name", "hope", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3176b;
    private C1393i f3177c;
    private Context f3178d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS rewardreach(");
        stringBuilder.append("deviceCode integer not null,");
        stringBuilder.append("goalnum NVARCHAR(300) ,");
        stringBuilder.append("time NVARCHAR(300) not null,");
        stringBuilder.append("name NVARCHAR(300) ,");
        stringBuilder.append("hope NVARCHAR(300) ,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append("data4 NVARCHAR(300) ,");
        stringBuilder.append("data5 NVARCHAR(300) ,");
        stringBuilder.append("primary key(time,deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("RewardReachedDB", "===createTableSQL", stringBuilder.toString());
        f3174a = stringBuilder.toString();
    }

    public C1405u(Context context) {
        this.f3177c = C1393i.m6319a(context);
        this.f3178d = context;
    }

    public void m6428a() {
        if (this.f3176b == null) {
            this.f3176b = this.f3177c.m6327a();
        }
    }

    public void m6430b() {
        this.f3177c.m6328b();
        this.f3176b = null;
    }

    public long m6426a(C1404t c1404t) {
        try {
            String j = C1392h.m6317j(this.f3178d, c1404t.m6408c());
            String j2 = C1392h.m6317j(this.f3178d, c1404t.m6410d());
            String j3 = C1392h.m6317j(this.f3178d, c1404t.m6406b());
            String j4 = C1392h.m6317j(this.f3178d, c1404t.m6414f());
            String j5 = C1392h.m6317j(this.f3178d, c1404t.m6416g());
            String j6 = C1392h.m6317j(this.f3178d, c1404t.m6418h());
            String j7 = C1392h.m6317j(this.f3178d, c1404t.m6420i());
            String j8 = C1392h.m6317j(this.f3178d, c1404t.m6422j());
            if (!C1392h.m6318k(this.f3178d, j).equals(c1404t.m6408c())) {
                C2538c.m12674b("RewardReachedDB", "===before encrypt--RewaedReachedTable mod.count== " + c1404t.m6408c());
                j = C1392h.m6317j(this.f3178d, c1404t.m6408c());
                j2 = C1392h.m6317j(this.f3178d, c1404t.m6410d());
                j3 = C1392h.m6317j(this.f3178d, c1404t.m6406b());
                j4 = C1392h.m6317j(this.f3178d, c1404t.m6414f());
                j5 = C1392h.m6317j(this.f3178d, c1404t.m6416g());
                j6 = C1392h.m6317j(this.f3178d, c1404t.m6418h());
                j7 = C1392h.m6317j(this.f3178d, c1404t.m6420i());
                j8 = C1392h.m6317j(this.f3178d, c1404t.m6422j());
            }
            m6428a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("deviceCode", c1404t.m6404a());
            contentValues.put("goalnum", j);
            contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1404t.m6412e());
            contentValues.put("name", j2);
            contentValues.put("hope", j3);
            contentValues.put("data1", j4);
            contentValues.put("data2", j5);
            contentValues.put("data3", j6);
            contentValues.put("data4", j7);
            contentValues.put("data5", j8);
            long insert = this.f3176b.insert("rewardreach", null, contentValues);
            if (-1 == insert) {
                C2538c.m12680e("RewardReachedDB", "RewardReachedDB insert() failed");
            }
            j5 = "RewardReachedDB";
            Object[] objArr = new Object[1];
            objArr[0] = "RewardReachedDB insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1404t + ", values=" + contentValues.toString();
            C2538c.m12674b(j5, objArr);
            m6430b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("RewardReachedDB", "RewardReachedDB insert() Exception=" + e.getMessage());
            return -1;
        }
    }

    private void m6425a(Cursor cursor, C1404t c1404t) {
        c1404t.m6405a(cursor.getString(cursor.getColumnIndex("deviceCode")));
        c1404t.m6415f(cursor.getString(cursor.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
        c1404t.m6411d(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("name"))));
        c1404t.m6409c(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("goalnum"))));
        c1404t.m6407b(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("hope"))));
        c1404t.m6417g(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("data1"))));
        c1404t.m6419h(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("data2"))));
        c1404t.m6421i(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("data3"))));
        c1404t.m6423j(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("data4"))));
        c1404t.m6424k(C1392h.m6318k(this.f3178d, cursor.getString(cursor.getColumnIndex("data5"))));
    }

    public ArrayList<C1404t> m6427a(int i) {
        try {
            m6428a();
            String[] strArr = new String[]{String.valueOf(i)};
            C2538c.m12674b("RewardReachedDB", "================selection:", "deviceCode = ?");
            Cursor query = this.f3176b.query("rewardreach", f3175e, "deviceCode = ?", strArr, null, null, null);
            if (query == null) {
                m6430b();
                return null;
            }
            ArrayList<C1404t> arrayList = new ArrayList();
            while (query.moveToNext()) {
                C1404t c1404t = new C1404t();
                m6425a(query, c1404t);
                arrayList.add(c1404t);
            }
            query.close();
            m6430b();
            return arrayList;
        } catch (Exception e) {
            C2538c.m12680e("RewardReachedDB", "getAll() Exception=" + e.getMessage());
            return null;
        }
    }

    public void m6431c() {
        try {
            m6428a();
            C2538c.m12674b("RewardReachedDB", "================ delete all deviceinfo   sql:", "DELETE FROM rewardreach");
            this.f3176b.execSQL("DELETE FROM rewardreach");
            m6430b();
        } catch (SQLException e) {
            C2538c.m12680e("RewardReachedDB", "truncateDatabaseTable SQLException e = " + e.getMessage());
            m6430b();
        } catch (Exception e2) {
            C2538c.m12680e("RewardReachedDB", "truncateDatabaseTable Exception e = " + e2.getMessage());
            m6430b();
        }
    }

    public boolean m6429a(String str) {
        try {
            m6428a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("RewardReachedDB", "================ delete all deviceinfo   sql:", "DELETE FROM rewardreach Where deviceCode like ?");
            this.f3176b.execSQL("DELETE FROM rewardreach Where deviceCode like ?", strArr);
            m6430b();
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("RewardReachedDB", "deleteAll SQLException e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("RewardReachedDB", "deleteAll Exception e = " + e2.getMessage());
            m6430b();
            return false;
        }
    }
}
