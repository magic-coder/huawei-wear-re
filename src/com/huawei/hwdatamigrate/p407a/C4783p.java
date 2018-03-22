package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceDatasDB */
public class C4783p {
    public static final String f17646a;
    public static final String f17647b;
    private static final String[] f17648e = new String[]{"_id", "userid", "mac", "data", "CurDate"};
    private C4780m f17649c;
    private Context f17650d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS devicedatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("CurDate DATETIME not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("TypeDetailInMin varchar(7500),");
        stringBuilder.append("TotalStepDetailInMin varchar(10000),");
        stringBuilder.append("TotalDistanceDetailInMin varchar(10000),");
        stringBuilder.append("TotalCalorieDetailInMin varchar(10000),");
        stringBuilder.append("SleepStatusDetailInMin varchar(7500)");
        stringBuilder.append(")");
        f17646a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS devicedatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("data varchar(60000),");
        stringBuilder.append("CurDate DATETIME not null");
        stringBuilder.append(")");
        f17647b = stringBuilder.toString();
    }

    public C4783p(Context context) {
        this.f17650d = context.getApplicationContext();
        this.f17649c = C4780m.m22870a(context);
    }

    public String m22898a(C4784q c4784q) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TypeDetailInMin", c4784q.a);
            jSONObject.put("TotalStepDetailInMin", c4784q.b);
            jSONObject.put("TotalDistanceDetailInMin", c4784q.c);
            jSONObject.put("TotalCalorieDetailInMin", c4784q.d);
            jSONObject.put("SleepStatusDetailInMin", c4784q.e);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.e("DeviceDatasDB", new Object[]{"DataToJson Exception=" + e.getMessage()});
            return null;
        }
    }
}
