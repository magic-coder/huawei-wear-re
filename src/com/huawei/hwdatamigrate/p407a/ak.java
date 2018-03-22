package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SleepTotalDB */
public class ak {
    public static final String f17417a;
    public static final String f17418b;
    private static final String[] f17419e = new String[]{"_id", "userid", "data", "isUpload", "sleepCurTime"};
    private C4780m f17420c;
    private Context f17421d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sleeptotal(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("sleeps NVARCHAR(1000),");
        stringBuilder.append("totalMinutes integer not null,");
        stringBuilder.append("deepMinutes integer not null,");
        stringBuilder.append("lightMinutes integer not null,");
        stringBuilder.append("awakeMinutes integer not null,");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sleepCurTime DATETIME  not null,");
        stringBuilder.append("sleepsDataDetail NVARCHAR(3000)");
        stringBuilder.append(")");
        f17417a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sleeptotal(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("data varchar(3000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sleepCurTime DATETIME  not null");
        stringBuilder.append(")");
        f17418b = stringBuilder.toString();
    }

    public ak(Context context) {
        this.f17421d = context.getApplicationContext();
        this.f17420c = C4780m.m22870a(context);
    }

    public String m22804a(aj ajVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sleeps", ajVar.a);
            jSONObject.put("totalMinutes", ajVar.b);
            jSONObject.put("deepMinutes", ajVar.c);
            jSONObject.put("lightMinutes", ajVar.d);
            jSONObject.put("awakeMinutes", ajVar.e);
            jSONObject.put("sleepsDataDetail", ajVar.f);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b("SleepTotalDB", new Object[]{"DataToJson Exception=" + e.getMessage()});
            return "";
        }
    }
}
