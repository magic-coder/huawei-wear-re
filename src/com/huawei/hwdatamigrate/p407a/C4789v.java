package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HeartDatasTable */
public class C4789v {
    public static final String f17706a;
    private static final String[] f17707d = new String[]{"_id", "userid", "mac", "data", "isUpload", "HeartCurTime"};
    private C4780m f17708b;
    private Context f17709c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS heartdatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("data varchar(30000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("HeartCurTime DATETIME  not null");
        stringBuilder.append(")");
        f17706a = stringBuilder.toString();
    }

    public C4789v(Context context) {
        this.f17709c = context.getApplicationContext();
        this.f17708b = C4780m.m22870a(context);
    }

    public String m22912a(C4788t c4788t) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dateTime", c4788t.e);
            jSONObject.put("heartRate", c4788t.f);
            jSONObject.put("heartRateType", c4788t.g);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b("HeartDatasDB", new Object[]{"dataToJson Exception=" + e.getMessage()});
            return null;
        }
    }
}
