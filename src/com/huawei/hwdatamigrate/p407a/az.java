package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserConfigDB */
public class az {
    public static final String f17524a;
    public static final String f17525b;
    private static final String[] f17526f = new String[]{"_id", "userid", "data"};
    private SQLiteDatabase f17527c;
    private C4780m f17528d;
    private Context f17529e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS userconfig(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("opencloud integer not null,");
        stringBuilder.append("accessToken NVARCHAR(300) not null,");
        stringBuilder.append("login_type integer not null,");
        stringBuilder.append("login_time integer not null,");
        stringBuilder.append("expire_time integer not null,");
        stringBuilder.append("userID_Login NVARCHAR(200) not null,");
        stringBuilder.append("userName_Login NVARCHAR(200) not null,");
        stringBuilder.append("accessToken_Login NVARCHAR(200) not null");
        stringBuilder.append(")");
        f17524a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS userconfig(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("data varchar(3000)");
        stringBuilder.append(")");
        f17525b = stringBuilder.toString();
    }

    public az(Context context) {
        this.f17529e = context.getApplicationContext();
        this.f17528d = C4780m.m22870a(context);
    }

    public void m22828a() {
        if (this.f17527c == null) {
            this.f17527c = this.f17528d.m22886a();
        }
    }

    public void m22829b() {
        this.f17528d.m22888b();
        this.f17527c = null;
    }

    public ba m22826a(String str) {
        try {
            m22828a();
            Cursor query = this.f17527c.query("userconfig", f17526f, "userid= ?", new String[]{str}, null, null, null);
            if (query == null) {
                m22829b();
                return null;
            }
            ba b;
            if (query.moveToFirst()) {
                b = m22825b(C4775h.m22868e(this.f17529e, query.getString(query.getColumnIndex("data"))));
                b.f17539k = b.a == 1;
                b.f17537i = query.getInt(query.getColumnIndex("_id"));
                b.f17538j = query.getString(query.getColumnIndex("userid"));
            } else {
                b = null;
            }
            query.close();
            m22829b();
            return b;
        } catch (Exception e) {
            C2538c.e("UserConfigDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }

    public String m22827a(ba baVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i;
            jSONObject.put("accessToken", baVar.b);
            jSONObject.put("login_type", baVar.c);
            jSONObject.put("login_time", baVar.d);
            jSONObject.put("expire_time", baVar.e);
            jSONObject.put("userID_Login", baVar.f);
            jSONObject.put("accessToken_Login", baVar.g);
            jSONObject.put("userName_Login", baVar.h);
            String str = "openCloudState";
            if (baVar.f17539k) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put(str, i);
            return jSONObject.toString();
        } catch (Exception e) {
            C2538c.b("UserConfigDB", new Object[]{"dataToJson Exception=" + e.getMessage()});
            return null;
        }
    }

    private ba m22825b(String str) {
        ba baVar = new ba();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("openCloudState")) {
                baVar.a = jSONObject.getInt("openCloudState");
            }
            if (!jSONObject.isNull("accessToken")) {
                baVar.b = jSONObject.getString("accessToken");
            }
            if (!jSONObject.isNull("login_type")) {
                baVar.c = jSONObject.getInt("login_type");
            }
            if (!jSONObject.isNull("login_time")) {
                baVar.d = jSONObject.getInt("login_time");
            }
            if (!jSONObject.isNull("expire_time")) {
                baVar.e = jSONObject.getInt("expire_time");
            }
            if (!jSONObject.isNull("userID_Login")) {
                baVar.f = jSONObject.getString("userID_Login");
            }
            if (!jSONObject.isNull("accessToken_Login")) {
                baVar.g = jSONObject.getString("accessToken_Login");
            }
            if (!jSONObject.isNull("userName_Login")) {
                baVar.h = jSONObject.getString("userName_Login");
            }
        } catch (JSONException e) {
            C2538c.e("UserConfigDB", new Object[]{"JsonToData JSONException message:" + e.getMessage()});
        }
        return baVar;
    }
}
