package com.huawei.nfc.carrera.logic.lostmanager.report;

import android.content.Context;

public class ReportDeviceStatusTask extends ReportStatusBaseTask implements Runnable {
    public static final String KEY_DEVICE_STATUS = "device_status";
    private String deviceStatus;

    public ReportDeviceStatusTask(Context context, String str) {
        super(context);
        this.deviceStatus = str;
    }

    public void run() {
        updateDeviceStatus(this.deviceStatus);
        if (reportStatusToServer(this.deviceStatus)) {
            removeDeviceStatus();
        }
    }
}
