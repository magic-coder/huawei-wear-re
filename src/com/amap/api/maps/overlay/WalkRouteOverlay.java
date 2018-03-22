package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class WalkRouteOverlay extends C3381b {
    private WalkPath f12207a;

    public /* bridge */ /* synthetic */ void removeFromMap() {
        super.removeFromMap();
    }

    public /* bridge */ /* synthetic */ void setNodeIconVisibility(boolean z) {
        super.setNodeIconVisibility(z);
    }

    public /* bridge */ /* synthetic */ void zoomToSpan() {
        super.zoomToSpan();
    }

    public WalkRouteOverlay(Context context, AMap aMap, WalkPath walkPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.f12207a = walkPath;
        this.startPoint = C3382a.m16539a(latLonPoint);
        this.endPoint = C3382a.m16539a(latLonPoint2);
    }

    public void addToMap() {
        try {
            List steps = this.f12207a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                WalkStep walkStep = (WalkStep) steps.get(i);
                LatLng a = C3382a.m16539a((LatLonPoint) walkStep.getPolyline().get(0));
                if (i < steps.size() - 1) {
                    if (i == 0) {
                        m16533a(this.startPoint, a);
                    }
                    m16536a(walkStep, (WalkStep) steps.get(i + 1));
                } else {
                    m16533a(C3382a.m16539a(m16532a(walkStep)), this.endPoint);
                }
                m16535a(walkStep, a);
                m16538c(walkStep);
            }
            addStartAndEndMarker();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m16536a(WalkStep walkStep, WalkStep walkStep2) {
        LatLonPoint a = m16532a(walkStep);
        LatLonPoint b = m16537b(walkStep2);
        if (!a.equals(b)) {
            m16534a(a, b);
        }
    }

    private LatLonPoint m16532a(WalkStep walkStep) {
        return (LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1);
    }

    private LatLonPoint m16537b(WalkStep walkStep) {
        return (LatLonPoint) walkStep.getPolyline().get(0);
    }

    private void m16534a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        m16533a(C3382a.m16539a(latLonPoint), C3382a.m16539a(latLonPoint2));
    }

    private void m16533a(LatLng latLng, LatLng latLng2) {
        addPolyLine(new PolylineOptions().add(latLng, latLng2).color(getWalkColor()).width(getRouteWidth()));
    }

    private void m16538c(WalkStep walkStep) {
        addPolyLine(new PolylineOptions().addAll(C3382a.m16540a(walkStep.getPolyline())).color(getWalkColor()).width(getRouteWidth()));
    }

    private void m16535a(WalkStep walkStep, LatLng latLng) {
        addStationMarker(new MarkerOptions().position(latLng).title("方向:" + walkStep.getAction() + "\n道路:" + walkStep.getRoad()).snippet(walkStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor()));
    }
}
