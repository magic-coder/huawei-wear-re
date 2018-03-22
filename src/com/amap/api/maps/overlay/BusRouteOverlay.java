package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class BusRouteOverlay extends C3381b {
    private BusPath f12196a;
    private LatLng f12197b;

    public /* bridge */ /* synthetic */ void removeFromMap() {
        super.removeFromMap();
    }

    public /* bridge */ /* synthetic */ void setNodeIconVisibility(boolean z) {
        super.setNodeIconVisibility(z);
    }

    public /* bridge */ /* synthetic */ void zoomToSpan() {
        super.zoomToSpan();
    }

    public BusRouteOverlay(Context context, AMap aMap, BusPath busPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.f12196a = busPath;
        this.startPoint = C3382a.m16539a(latLonPoint);
        this.endPoint = C3382a.m16539a(latLonPoint2);
        this.mAMap = aMap;
    }

    public void addToMap() {
        try {
            List steps = this.f12196a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                BusStep busStep = (BusStep) steps.get(i);
                if (i < steps.size() - 1) {
                    BusStep busStep2 = (BusStep) steps.get(i + 1);
                    if (!(busStep.getWalk() == null || busStep.getBusLine() == null)) {
                        m16510b(busStep);
                    }
                    if (!(busStep.getBusLine() == null || busStep2.getWalk() == null)) {
                        m16517c(busStep, busStep2);
                    }
                    if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                        m16511b(busStep, busStep2);
                    }
                    if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                        m16507a(busStep, busStep2);
                    }
                }
                if (busStep.getWalk() != null && busStep.getWalk().getSteps().size() > 0) {
                    m16506a(busStep);
                } else if (busStep.getBusLine() == null) {
                    m16503a(this.f12197b, this.endPoint);
                }
                if (busStep.getBusLine() != null) {
                    RouteBusLineItem busLine = busStep.getBusLine();
                    m16508a(busLine);
                    m16512b(busLine);
                }
            }
            addStartAndEndMarker();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m16506a(BusStep busStep) {
        List steps = busStep.getWalk().getSteps();
        for (int i = 0; i < steps.size(); i++) {
            WalkStep walkStep = (WalkStep) steps.get(i);
            if (i == 0) {
                m16504a(C3382a.m16539a((LatLonPoint) walkStep.getPolyline().get(0)), walkStep.getRoad(), m16516c(steps));
            }
            List a = C3382a.m16540a(walkStep.getPolyline());
            this.f12197b = (LatLng) a.get(a.size() - 1);
            m16513b(a);
            if (i < steps.size() - 1) {
                LatLng latLng = (LatLng) a.get(a.size() - 1);
                LatLng a2 = C3382a.m16539a((LatLonPoint) ((WalkStep) steps.get(i + 1)).getPolyline().get(0));
                if (!latLng.equals(a2)) {
                    m16503a(latLng, a2);
                }
            }
        }
    }

    private void m16508a(RouteBusLineItem routeBusLineItem) {
        m16509a(routeBusLineItem.getPolyline());
    }

    private void m16509a(List<LatLonPoint> list) {
        if (list.size() >= 1) {
            addPolyLine(new PolylineOptions().width(getRouteWidth()).color(getBusColor()).addAll(C3382a.m16540a((List) list)));
        }
    }

    private void m16504a(LatLng latLng, String str, String str2) {
        addStationMarker(new MarkerOptions().position(latLng).title(str).snippet(str2).anchor(0.5f, 0.5f).visible(this.nodeIconVisible).icon(getWalkBitmapDescriptor()));
    }

    private void m16512b(RouteBusLineItem routeBusLineItem) {
        LatLng a = C3382a.m16539a(routeBusLineItem.getDepartureBusStation().getLatLonPoint());
        String busLineName = routeBusLineItem.getBusLineName();
        addStationMarker(new MarkerOptions().position(a).title(busLineName).snippet(m16515c(routeBusLineItem)).anchor(0.5f, 0.5f).visible(this.nodeIconVisible).icon(getBusBitmapDescriptor()));
    }

    private void m16507a(BusStep busStep, BusStep busStep2) {
        LatLng a = C3382a.m16539a(m16519e(busStep));
        LatLng a2 = C3382a.m16539a(m16520f(busStep2));
        if (a2.latitude - a.latitude > 1.0E-4d || a2.longitude - a.longitude > 1.0E-4d) {
            drawLineArrow(a, a2);
        }
    }

    private void m16511b(BusStep busStep, BusStep busStep2) {
        LatLng a = C3382a.m16539a(m16519e(busStep));
        LatLng a2 = C3382a.m16539a(m16520f(busStep2));
        if (!a.equals(a2)) {
            drawLineArrow(a, a2);
        }
    }

    private void m16517c(BusStep busStep, BusStep busStep2) {
        LatLonPoint e = m16519e(busStep);
        LatLonPoint c = m16514c(busStep2);
        if (!e.equals(c)) {
            m16505a(e, c);
        }
    }

    private void m16510b(BusStep busStep) {
        LatLonPoint d = m16518d(busStep);
        LatLonPoint f = m16520f(busStep);
        if (!d.equals(f)) {
            m16505a(d, f);
        }
    }

    private LatLonPoint m16514c(BusStep busStep) {
        return (LatLonPoint) ((WalkStep) busStep.getWalk().getSteps().get(0)).getPolyline().get(0);
    }

    private void m16505a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        m16503a(C3382a.m16539a(latLonPoint), C3382a.m16539a(latLonPoint2));
    }

    private void m16503a(LatLng latLng, LatLng latLng2) {
        addPolyLine(new PolylineOptions().add(latLng, latLng2).width(getRouteWidth()).color(getWalkColor()));
    }

    private void m16513b(List<LatLng> list) {
        addPolyLine(new PolylineOptions().addAll(list).color(getWalkColor()).width(getRouteWidth()));
    }

    private String m16516c(List<WalkStep> list) {
        float f = 0.0f;
        for (WalkStep distance : list) {
            f = distance.getDistance() + f;
        }
        return "步行" + f + "米";
    }

    public void drawLineArrow(LatLng latLng, LatLng latLng2) {
        addPolyLine(new PolylineOptions().add(latLng, latLng2).width(3.0f).color(getBusColor()).width(getRouteWidth()));
    }

    private String m16515c(RouteBusLineItem routeBusLineItem) {
        return "(" + routeBusLineItem.getDepartureBusStation().getBusStationName() + "-->" + routeBusLineItem.getArrivalBusStation().getBusStationName() + ") 经过" + (routeBusLineItem.getPassStationNum() + 1) + "站";
    }

    private LatLonPoint m16518d(BusStep busStep) {
        List steps = busStep.getWalk().getSteps();
        steps = ((WalkStep) steps.get(steps.size() - 1)).getPolyline();
        return (LatLonPoint) steps.get(steps.size() - 1);
    }

    private LatLonPoint m16519e(BusStep busStep) {
        List polyline = busStep.getBusLine().getPolyline();
        return (LatLonPoint) polyline.get(polyline.size() - 1);
    }

    private LatLonPoint m16520f(BusStep busStep) {
        return (LatLonPoint) busStep.getBusLine().getPolyline().get(0);
    }
}
