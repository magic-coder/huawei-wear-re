package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler */
public class C3431t extends C3387r<RegeocodeQuery, RegeocodeAddress> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3431t(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/geocode/regeo?";
    }

    protected RegeocodeAddress mo4100a(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject != null) {
                regeocodeAddress.setFormatAddress(C3415j.m16913b(optJSONObject, "formatted_address"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
                if (optJSONObject2 != null) {
                    C3415j.m16909a(optJSONObject2, regeocodeAddress);
                }
                regeocodeAddress.setPois(C3415j.m16920c(optJSONObject));
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                if (optJSONArray != null) {
                    C3415j.m16917b(optJSONArray, regeocodeAddress);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
                if (optJSONArray2 != null) {
                    C3415j.m16907a(optJSONArray2, regeocodeAddress);
                }
            }
        } catch (Throwable e) {
            C3409d.m16881a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        return regeocodeAddress;
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&extensions=all").append("&location=").append(((RegeocodeQuery) this.a).getPoint().getLongitude()).append(",").append(((RegeocodeQuery) this.a).getPoint().getLatitude());
        stringBuffer.append("&radius=").append(((RegeocodeQuery) this.a).getRadius());
        stringBuffer.append("&coordsys=").append(((RegeocodeQuery) this.a).getLatLonType());
        stringBuffer.append("&key=" + C3434w.m16993f(this.d));
        stringBuffer.append("&language=").append(C3408c.m16875b());
        return stringBuffer.toString();
    }
}
