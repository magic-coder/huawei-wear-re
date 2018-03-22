package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONObject;

/* compiled from: AltitudeDatasDB */
public class C4773f {
    public static final String f17614a;
    private static final String[] f17615d = new String[]{"_id", "userid", "mac", "data", "isUpload", "HeartCurTime"};
    private C4780m f17616b;
    private Context f17617c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS altitudedatas(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("mac NVARCHAR(128),");
        stringBuilder.append("data varchar(30000),");
        stringBuilder.append("isUpload integer not null,");
        stringBuilder.append("HeartCurTime DATETIME  not null");
        stringBuilder.append(")");
        f17614a = stringBuilder.toString();
    }

    public C4773f(Context context) {
        this.f17617c = context.getApplicationContext();
        this.f17616b = C4780m.m22870a(context);
        C2538c.b("HeartDatasDB", new Object[]{"mDbHelper:" + this.f17616b});
    }

    public String m22856a(C4774g c4774g) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dateTime", c4774g.a);
            jSONObject.put("Altitude", c4774g.b);
        } catch (Exception e) {
            C2538c.e("HeartDatasDB", new Object[]{"dataToJson Exception=" + e.getMessage()});
        }
        return jSONObject.toString();
    }
}
