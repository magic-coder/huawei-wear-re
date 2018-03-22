package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.model.Marker;

public interface AMap$InfoWindowAdapter {
    View getInfoContents(Marker marker);

    View getInfoWindow(Marker marker);
}
