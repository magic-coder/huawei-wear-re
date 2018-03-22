package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: WalkRouteSearchHandler */
public class C3432u extends C3387r<WalkRouteQuery, WalkRouteResult> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3432u(Context context, WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C3434w.m16993f(this.d));
        stringBuffer.append("&origin=").append(C3409d.m16878a(((WalkRouteQuery) this.a).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C3409d.m16878a(((WalkRouteQuery) this.a).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    protected WalkRouteResult mo4100a(String str) throws AMapException {
        return C3415j.m16924d(str);
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/direction/walking?";
    }
}
