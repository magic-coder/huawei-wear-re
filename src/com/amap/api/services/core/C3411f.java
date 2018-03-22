package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;

/* compiled from: DriveRouteSearchHandler */
public class C3411f extends C3387r<DriveRouteQuery, DriveRouteResult> {
    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3411f(Context context, DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    protected String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C3434w.m16993f(this.d));
        stringBuffer.append("&origin=").append(C3409d.m16878a(((DriveRouteQuery) this.a).getFromAndTo().getFrom()));
        if (!C3415j.m16935h(((DriveRouteQuery) this.a).getFromAndTo().getStartPoiID())) {
            stringBuffer.append("&originid=").append(((DriveRouteQuery) this.a).getFromAndTo().getStartPoiID());
        }
        stringBuffer.append("&destination=").append(C3409d.m16878a(((DriveRouteQuery) this.a).getFromAndTo().getTo()));
        if (!C3415j.m16935h(((DriveRouteQuery) this.a).getFromAndTo().getDestinationPoiID())) {
            stringBuffer.append("&destinationid=").append(((DriveRouteQuery) this.a).getFromAndTo().getDestinationPoiID());
        }
        stringBuffer.append("&strategy=").append("" + ((DriveRouteQuery) this.a).getMode());
        stringBuffer.append("&extensions=all");
        if (((DriveRouteQuery) this.a).hasPassPoint()) {
            stringBuffer.append("&waypoints=").append(((DriveRouteQuery) this.a).getPassedPointStr());
        }
        if (((DriveRouteQuery) this.a).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=").append(((DriveRouteQuery) this.a).getAvoidpolygonsStr());
        }
        if (((DriveRouteQuery) this.a).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=").append(m16574c(((DriveRouteQuery) this.a).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    protected DriveRouteResult mo4100a(String str) throws AMapException {
        return C3415j.m16919c(str);
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/direction/driving?";
    }
}
