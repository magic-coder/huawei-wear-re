package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: BillInfoDB */
public class C1387c {
    public static final String f3035a;
    private static final String[] f3036e = new String[]{"_id", "deviceCode", "responseTime", "billTime", "billContent", "feeBalance", "remainingMessage", "operatorNum", "balanceOrder", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3037b;
    private C1393i f3038c;
    private Context f3039d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table IF NOT EXISTS billinfo(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("deviceCode integer not null,");
        stringBuilder.append("responseTime NVARCHAR(300),");
        stringBuilder.append("billTime NVARCHAR(300),");
        stringBuilder.append("billContent NVARCHAR(300),");
        stringBuilder.append("feeBalance NVARCHAR(300),");
        stringBuilder.append("remainingMessage NVARCHAR(300),");
        stringBuilder.append("operatorNum NVARCHAR(100),");
        stringBuilder.append("balanceOrder NVARCHAR(100),");
        stringBuilder.append("data1 NVARCHAR(300),");
        stringBuilder.append("data2 NVARCHAR(300),");
        stringBuilder.append("data3 NVARCHAR(300),");
        stringBuilder.append("data4 NVARCHAR(300),");
        stringBuilder.append("data5 NVARCHAR(300)");
        stringBuilder.append(")");
        C2538c.m12674b("BillInfoDB", "=DBUtil checkBill= createTableSQL", stringBuilder.toString());
        f3035a = stringBuilder.toString();
    }

    public C1387c(Context context) {
        this.f3038c = C1393i.m6319a(context);
        this.f3039d = context;
    }

    public void m6248a() {
        if (this.f3037b == null) {
            this.f3037b = this.f3038c.m6327a();
        }
    }

    public void m6249b() {
        this.f3038c.m6328b();
        this.f3037b = null;
    }

    public long m6245a(C1388d c1388d, String str) {
        C2538c.m12680e("BillInfoDB", "=DBUtil checkBill= enter  insert() ");
        try {
            m6248a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("deviceCode", str);
            contentValues.put("responseTime", c1388d.f3040a);
            contentValues.put("billTime", c1388d.f3042c);
            contentValues.put("billContent", C1392h.m6317j(this.f3039d, c1388d.f3041b));
            contentValues.put("feeBalance", C1392h.m6317j(this.f3039d, c1388d.f3043d));
            contentValues.put("remainingMessage", C1392h.m6317j(this.f3039d, c1388d.f3044e));
            contentValues.put("operatorNum", C1392h.m6317j(this.f3039d, c1388d.f3047h));
            contentValues.put("balanceOrder", C1392h.m6317j(this.f3039d, c1388d.f3048i));
            contentValues.put("data1", C1392h.m6317j(this.f3039d, c1388d.f3049j));
            contentValues.put("data2", C1392h.m6317j(this.f3039d, c1388d.f3050k));
            contentValues.put("data3", C1392h.m6317j(this.f3039d, c1388d.f3051l));
            contentValues.put("data4", C1392h.m6317j(this.f3039d, c1388d.f3052m));
            contentValues.put("data5", C1392h.m6317j(this.f3039d, c1388d.f3053n));
            long insert = this.f3037b.insert("billinfo", null, contentValues);
            String str2 = "BillInfoDB";
            Object[] objArr = new Object[1];
            objArr[0] = "=DBUtil checkBill= insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1388d + ", values=" + contentValues.toString();
            C2538c.m12674b(str2, objArr);
            m6249b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("BillInfoDB", "=DBUtil checkBill= insert() Exception=" + e.getMessage());
            return -1;
        }
    }

    public ArrayList<C1388d> m6247a(String str) {
        m6248a();
        Cursor rawQuery = this.f3037b.rawQuery("select * from billinfo where deviceCode = ?", new String[]{str});
        if (rawQuery == null) {
            m6249b();
            return null;
        }
        ArrayList<C1388d> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            C1388d c1388d = new C1388d();
            c1388d.f3040a = rawQuery.getString(rawQuery.getColumnIndex("responseTime"));
            c1388d.f3042c = rawQuery.getString(rawQuery.getColumnIndex("billTime"));
            c1388d.f3046g = rawQuery.getString(rawQuery.getColumnIndex("deviceCode"));
            c1388d.f3041b = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("billContent")));
            c1388d.f3044e = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("remainingMessage")));
            c1388d.f3043d = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("feeBalance")));
            c1388d.f3047h = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("operatorNum")));
            c1388d.f3048i = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("balanceOrder")));
            c1388d.f3049j = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("data1")));
            c1388d.f3050k = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("data2")));
            c1388d.f3051l = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("data3")));
            c1388d.f3052m = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("data4")));
            c1388d.f3053n = C1392h.m6318k(this.f3039d, rawQuery.getString(rawQuery.getColumnIndex("data5")));
            C2538c.m12674b("BillInfoDB", "=DBUtil checkBill= mod=" + c1388d);
            arrayList.add(c1388d);
        }
        rawQuery.close();
        m6249b();
        return arrayList;
    }

    public void m6250c() {
        try {
            m6248a();
            C2538c.m12674b("BillInfoDB", "================ delete all deviceinfo   sql:", "DELETE FROM billinfo");
            this.f3037b.execSQL("DELETE FROM billinfo");
            m6249b();
        } catch (SQLException e) {
            C2538c.m12680e("BillInfoDB", "SQLException e = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("BillInfoDB", "Exception e = " + e2.getMessage());
        }
    }

    public C1388d m6246a(C1388d c1388d) {
        C1388d c1388d2 = null;
        C2538c.m12674b("BillInfoDB", "=DBUtil checkBill= enter  getBillByTime() ");
        if (c1388d != null) {
            m6248a();
            String[] strArr = new String[]{c1388d.f3046g, c1388d.f3042c};
            Cursor query = this.f3037b.query("billinfo", f3036e, "deviceCode= ? and billTime like ?", strArr, null, null, null);
            if (query == null) {
                m6249b();
            } else {
                if (query.moveToFirst()) {
                    c1388d2 = new C1388d();
                    c1388d2.f3040a = query.getString(query.getColumnIndex("responseTime"));
                    c1388d2.f3042c = query.getString(query.getColumnIndex("billTime"));
                    c1388d2.f3046g = query.getString(query.getColumnIndex("deviceCode"));
                    c1388d2.f3041b = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("billContent")));
                    c1388d2.f3044e = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("remainingMessage")));
                    c1388d2.f3043d = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("feeBalance")));
                    c1388d2.f3047h = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("operatorNum")));
                    c1388d2.f3048i = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("balanceOrder")));
                    c1388d2.f3049j = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("data1")));
                    c1388d2.f3050k = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("data2")));
                    c1388d2.f3051l = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("data3")));
                    c1388d2.f3052m = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("data4")));
                    c1388d2.f3053n = C1392h.m6318k(this.f3039d, query.getString(query.getColumnIndex("data5")));
                    C2538c.m12674b("BillInfoDB", "=DBUtil checkBill getBillByTime= mod = " + c1388d2);
                }
                query.close();
                m6249b();
            }
        }
        return c1388d2;
    }
}
