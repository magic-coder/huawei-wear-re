package com.amap.api.maps;

import com.amap.api.maps.model.Marker;

public interface AMap$OnMarkerDragListener {
    void onMarkerDrag(Marker marker);

    void onMarkerDragEnd(Marker marker);

    void onMarkerDragStart(Marker marker);
}
