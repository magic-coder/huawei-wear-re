package com.huawei.nfc.carrera.server.card.model;

public class CaptureMethod {
    private static final String CAMERA_MODE = "camera";
    private static final String MANUAL_MODE = "manual";
    private static String MODE = UNKNOWL_MODE;
    private static final String UNKNOWL_MODE = "unknow";

    public static void setCameraMode() {
        MODE = CAMERA_MODE;
    }

    public static void setMunalMode() {
        MODE = MANUAL_MODE;
    }

    public static void setUnKnownMode() {
        MODE = UNKNOWL_MODE;
    }

    public static String getMode() {
        return MODE;
    }
}
