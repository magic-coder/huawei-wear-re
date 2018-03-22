package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONObject;

/* compiled from: ClearCommandFailedDB */
public class C4777j {
    public static final String[] f17626a = new String[]{"_id", "data"};
    public static final String f17627b;
    private C4780m f17628c;
    private Context f17629d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS clearcommandfailed(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("data varchar(1000)");
        stringBuilder.append(")");
        f17627b = stringBuilder.toString();
    }

    public C4777j(Context context) {
        this.f17629d = context.getApplicationContext();
        this.f17628c = C4780m.m22870a(context);
    }

    public String m22869a(C4779l c4779l) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceID", c4779l.a);
            jSONObject.put("frameCount", c4779l.b);
            jSONObject.put("firstData", c4779l.c);
            jSONObject.put("remark", c4779l.d);
            return jSONObject.toString();
        } catch (Exception e) {
            C2538c.b("ClearCommandFailedDB", new Object[]{"dataToJson Exception=" + e.getMessage()});
            return null;
        }
    }
}
