package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: GeminiContactDB */
public class C4785r {
    public static final String f17689a;
    private static final String[] f17690e = new String[]{"_id", "username", "userid", "usernumber", "numbertype"};
    private SQLiteDatabase f17691b;
    private C4780m f17692c;
    private Context f17693d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS geminicontact(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("username NVARCHAR(300) not null,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("usernumber NVARCHAR(300) not null,");
        stringBuilder.append("numbertype NVARCHAR(300) not null");
        stringBuilder.append(")");
        f17689a = stringBuilder.toString();
    }

    public C4785r(Context context) {
        this.f17693d = context.getApplicationContext();
        this.f17692c = C4780m.m22870a(context);
    }

    public void m22900a() {
        if (this.f17691b == null) {
            this.f17691b = this.f17692c.m22886a();
        }
    }

    public void m22901b() {
        this.f17692c.m22888b();
        this.f17691b = null;
    }

    public ArrayList<C4786s> m22902c() {
        try {
            m22900a();
            ArrayList<C4786s> arrayList = new ArrayList();
            Cursor query = this.f17691b.query("geminicontact", f17690e, null, null, null, null, null);
            if (query == null) {
                m22901b();
                C2538c.b("GeminiContactDB", new Object[]{"ArrayList<GeminiContactTable> is null"});
                return null;
            }
            while (query.moveToNext()) {
                C4786s c4786s = new C4786s();
                c4786s.m22904a(query.getInt(query.getColumnIndex("_id")));
                c4786s.m22905a(C4775h.m22868e(this.f17693d, query.getString(query.getColumnIndex("username"))));
                c4786s.m22907b(query.getString(query.getColumnIndex("userid")));
                c4786s.m22909c(C4775h.m22868e(this.f17693d, query.getString(query.getColumnIndex("usernumber"))));
                c4786s.m22911d(C4775h.m22868e(this.f17693d, query.getString(query.getColumnIndex("numbertype"))));
                arrayList.add(c4786s);
            }
            query.close();
            m22901b();
            return arrayList;
        } catch (Exception e) {
            C2538c.e("GeminiContactDB", new Object[]{"GeminiContactDB get() catch Exception:" + e.getMessage()});
            return null;
        }
    }

    public static String[] m22899d() {
        return (String[]) f17690e.clone();
    }
}
