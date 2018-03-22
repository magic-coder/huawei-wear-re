package com.amap.api.maps;

import com.amap.api.maps.model.CameraPosition;

public interface AMap$OnCameraChangeListener {
    void onCameraChange(CameraPosition cameraPosition);

    void onCameraChangeFinish(CameraPosition cameraPosition);
}
