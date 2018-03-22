package com.amap.api.mapcore;

public class AutoTestConfig {
    public static final int CompassViewId;
    public static final int MyLocationViewId;
    public static final int ScaleControlsViewId;
    public static final int ZoomControllerViewId;
    private static int f10873a;

    static {
        f10873a = 900000000;
        int i = f10873a;
        f10873a = i + 1;
        ZoomControllerViewId = i;
        i = f10873a;
        f10873a = i + 1;
        ScaleControlsViewId = i;
        i = f10873a;
        f10873a = i + 1;
        MyLocationViewId = i;
        i = f10873a;
        f10873a = i + 1;
        CompassViewId = i;
    }
}
