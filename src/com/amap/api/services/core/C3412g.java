package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: GeocodingHandler */
public class C3412g extends C3387r<GeocodeQuery, ArrayList<GeocodeAddress>> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3412g(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    protected ArrayList<GeocodeAddress> mo4100a(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                arrayList = C3415j.m16945n(jSONObject);
            }
        } catch (Throwable e) {
            C3409d.m16881a(e, "GeocodingHandler", "paseJSONJSONException");
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "GeocodingHandler", "paseJSONException");
        }
        return arrayList;
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/geocode/geo?";
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&address=").append(m16574c(((GeocodeQuery) this.a).getLocationName()));
        String city = ((GeocodeQuery) this.a).getCity();
        if (!C3415j.m16935h(city)) {
            stringBuffer.append("&city=").append(m16574c(city));
        }
        stringBuffer.append("&key=" + C3434w.m16993f(this.d));
        stringBuffer.append("&language=").append(C3408c.m16875b());
        return stringBuffer.toString();
    }
}
