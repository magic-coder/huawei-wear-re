package com.huawei.nfc.carrera.server.card.request;

public class DeviceStatusReportRequest extends CardServerBaseRequest {
    public static final String HANDLE_DEVICE_LOST_STATUE = "2";
    public static final String HANDLE_DEVICE_REPAIR_STATUE = "4";
    public static final String HANDLE_REPAIR_INFO_STATUS_NORMAL = "0";
    public static final String HANDLE_REPAIR_INFO_STATUS_REJECT = "01";
    public String reportDeviceInfo;
    public String status;
}
