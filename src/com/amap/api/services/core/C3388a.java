package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;

/* compiled from: BusRouteSearchHandler */
public class C3388a extends C3387r<BusRouteQuery, BusRouteResult> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3388a(Context context, BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C3434w.m16993f(this.d));
        stringBuffer.append("&origin=").append(C3409d.m16878a(((BusRouteQuery) this.a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C3409d.m16878a(((BusRouteQuery) this.a).getFromAndTo().getTo()));
        String city = ((BusRouteQuery) this.a).getCity();
        if (!C3415j.m16935h(city)) {
            stringBuffer.append("&city=").append(m16574c(city));
        }
        stringBuffer.append("&strategy=").append("" + ((BusRouteQuery) this.a).getMode());
        stringBuffer.append("&nightflag=").append(((BusRouteQuery) this.a).getNightFlag());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    protected BusRouteResult mo4100a(String str) throws AMapException {
        return C3415j.m16912b(str);
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/direction/transit/integrated?";
    }
}
