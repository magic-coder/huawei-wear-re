package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SystemPropDB */
public class as {
    public static final String f17491a;
    private static final String[] f17492f = new String[]{"_id", "data"};
    private boolean f17493b = false;
    private SQLiteDatabase f17494c;
    private C4780m f17495d;
    private Context f17496e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS SystemProp(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("data varchar(3000)");
        stringBuilder.append(")");
        f17491a = stringBuilder.toString();
    }

    public as(Context context) {
        this.f17496e = context;
        this.f17495d = C4780m.m22870a(context);
    }

    public void m22821a() {
        if (this.f17494c == null) {
            this.f17494c = this.f17495d.m22886a();
        }
    }

    public void m22822b() {
        this.f17495d.m22888b();
        this.f17494c = null;
    }

    public au m22823c() {
        try {
            m22821a();
            Cursor query = this.f17494c.query("SystemProp", f17492f, null, null, null, null, null);
            if (query == null) {
                m22822b();
                return null;
            }
            au a;
            if (query.moveToFirst()) {
                a = m22820a(C4775h.m22868e(this.f17496e, query.getString(query.getColumnIndex("data"))));
                a.f17502f = query.getInt(query.getColumnIndex("_id"));
            } else {
                a = null;
            }
            query.close();
            m22822b();
            return a;
        } catch (Exception e) {
            C2538c.e("SystemPropDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }

    private au m22820a(String str) {
        au auVar = new au();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("phoneMacAdd")) {
                auVar.a = jSONObject.getString("phoneMacAdd");
            }
            if (!jSONObject.isNull("btMacAdd")) {
                auVar.b = jSONObject.getString("btMacAdd");
            }
            if (!jSONObject.isNull("androidId")) {
                auVar.c = jSONObject.getString("androidId");
            }
            if (!jSONObject.isNull("cloudSwitch")) {
                auVar.d = jSONObject.getInt("cloudSwitch");
            }
            if (!jSONObject.isNull("country")) {
                auVar.e = jSONObject.getString("country");
            }
        } catch (JSONException e) {
            C2538c.e("SystemPropDB", new Object[]{"JsonToData JSONException message:" + e.getMessage()});
        }
        return auVar;
    }
}
