package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TLEventDataDB */
public class aw {
    public static final String f17511a;
    private static final String[] f17512e = new String[]{"_id", "eventType", "eventStrDay", "data"};
    private final String f17513b = aw.class.getSimpleName();
    private C4780m f17514c;
    private Context f17515d;

    public aw(Context context) {
        this.f17515d = context.getApplicationContext();
        this.f17514c = C4780m.m22870a(context);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS timelinetable(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("eventType integer not null,");
        stringBuilder.append("eventStrDay TEXT,");
        stringBuilder.append("data varchar(50000)");
        stringBuilder.append(")");
        f17511a = stringBuilder.toString();
    }

    public String m22824a(ax axVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventTypeIconResId", axVar.a);
            jSONObject.put("eventContent", axVar.b);
            jSONObject.put("eventGpsLoc", axVar.c);
            jSONObject.put("eventContentIconResId", axVar.d);
            jSONObject.put("eventContentPicPath", axVar.e);
            jSONObject.put("eventSummary", axVar.f);
            jSONObject.put("eventStartStrTime", axVar.g);
            jSONObject.put("eventEndStrTime", axVar.h);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2538c.b(this.f17513b, new Object[]{"dataToJson Exception=" + e.getMessage()});
            return null;
        }
    }
}
