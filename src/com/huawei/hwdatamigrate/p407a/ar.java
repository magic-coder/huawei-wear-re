package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SportTotalDB */
public class ar {
    public static final String f17486a;
    public static final String f17487b;
    private static final String[] f17488e = new String[]{"_id", "userid", "data", "isUpload", "sportcurTime"};
    private C4780m f17489c;
    private Context f17490d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sporttotal(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("steps NVARCHAR(1000) not null,");
        stringBuilder.append("meters NVARCHAR(1000) not null,");
        stringBuilder.append("calories NVARCHAR(1000) not null,");
        stringBuilder.append("totalSteps integer not null,");
        stringBuilder.append("totalDistance integer not null,");
        stringBuilder.append("totalCalories integer not null,");
        stringBuilder.append("sportduration integer not null,");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sportcurTime DATETIME  not null");
        stringBuilder.append(")");
        f17486a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS sporttotal(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("data varchar(3000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("sportcurTime DATETIME  not null");
        stringBuilder.append(")");
        f17487b = stringBuilder.toString();
    }

    public ar(Context context) {
        this.f17490d = context.getApplicationContext();
        this.f17489c = C4780m.m22870a(context);
    }

    public String m22819a(an anVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("steps", anVar.q);
            jSONObject.put("meters", anVar.r);
            jSONObject.put("calories", anVar.s);
            jSONObject.put("totalSteps", anVar.t);
            jSONObject.put("totalDistance", anVar.u);
            jSONObject.put("totalCalories", anVar.v);
            jSONObject.put("sportDuration", anVar.w);
            jSONObject.put("totalRunSteps", anVar.x);
            jSONObject.put("totalRunDistance", anVar.y);
            jSONObject.put("totalRunCalories", anVar.z);
            jSONObject.put("totalRideDistance", anVar.A);
            jSONObject.put("totalRideCalories", anVar.B);
            jSONObject.put("totalClimbSteps", anVar.C);
            jSONObject.put("totalClimbHeight", anVar.D);
            jSONObject.put("totalClimbCalories", anVar.E);
            jSONObject.put("totalWalkSteps", anVar.F);
            jSONObject.put("totalWalkDistance", anVar.G);
            jSONObject.put("totalWalkCalories", anVar.H);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b("SportTotalDB", new Object[]{"DataToJson Exception=" + e.getMessage()});
            return "";
        }
    }
}
