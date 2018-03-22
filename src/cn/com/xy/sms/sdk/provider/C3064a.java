package cn.com.xy.sms.sdk.provider;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class C3064a implements Runnable {
    private final /* synthetic */ Map f10321a;
    private final /* synthetic */ Context f10322b;

    C3064a(Map map, Context context) {
        this.f10321a = map;
        this.f10322b = context;
    }

    public final void run() {
        try {
            JSONObject b = C2973a.m13373b(this.f10321a);
            if (b != null) {
                JSONArray jSONArray = b.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("phone", jSONObject.getString("phone").trim().replace("-", ""));
                    contentValues.put("name", jSONObject.getString("name"));
                    this.f10322b.getContentResolver().insert(Uri.parse("content://cn.com.xy.sms.sdk.provider.contacts/contacts"), contentValues);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
