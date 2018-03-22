package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3408c;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3415j;
import com.amap.api.services.core.C3434w;
import com.amap.api.services.core.ServiceSettings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
class C3462i extends C3460g<String, PoiItemDetail> {
    private String f12731h = "zh-CN";

    public /* synthetic */ Object mo4102b(String str) throws AMapException {
        return m17099e(str);
    }

    public C3462i(Context context, String str, String str2) {
        super(context, str);
        if ("en".equals(str2)) {
            this.f12731h = str2;
        }
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/place/detail?";
    }

    public PoiItemDetail m17099e(String str) throws AMapException {
        PoiItemDetail poiItemDetail = null;
        try {
            poiItemDetail = m17095a(new JSONObject(str));
        } catch (Throwable e) {
            C3409d.m16881a(e, "PoiSearchIdHandler", "paseJSONJSONException");
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "PoiSearchIdHandler", "paseJSONException");
        }
        return poiItemDetail;
    }

    private PoiItemDetail m17095a(JSONObject jSONObject) throws JSONException {
        PoiItemDetail poiItemDetail = null;
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    poiItemDetail = C3415j.m16923d(optJSONObject);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                    if (optJSONObject2 != null) {
                        C3415j.m16904a(poiItemDetail, optJSONObject2);
                    }
                    optJSONObject2 = optJSONObject.optJSONObject("deep_info");
                    if (optJSONObject2 != null) {
                        C3415j.m16929e(poiItemDetail, optJSONObject2, optJSONObject);
                    }
                }
            }
        }
        return poiItemDetail;
    }

    protected String a_() {
        return m17096f();
    }

    private String m17096f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append((String) this.a);
        stringBuilder.append("&output=json");
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&language=").append(ServiceSettings.getInstance().getLanguage());
        stringBuilder.append("&key=" + C3434w.m16993f(this.d));
        return stringBuilder.toString();
    }
}
