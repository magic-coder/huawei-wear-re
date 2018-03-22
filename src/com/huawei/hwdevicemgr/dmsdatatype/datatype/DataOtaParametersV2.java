package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class DataOtaParametersV2 {
    private boolean ackEnable = false;
    private int appWaitTimeout;
    private int deviceRestartTimeout;
    private long otaInterval = 0;
    private int otaUnitSize;

    public long getOtaInterval() {
        return ((Long) C0978h.a(Long.valueOf(this.otaInterval))).longValue();
    }

    public void setOtaInterval(long j) {
        this.otaInterval = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void setAckEnable(long j) {
        if (1 == j) {
            this.ackEnable = ((Boolean) C0978h.a(Boolean.valueOf(true))).booleanValue();
        }
    }

    public boolean getAckEnable() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.ackEnable))).booleanValue();
    }

    public int getDeviceRestartTimeout() {
        return ((Integer) C0978h.a(Integer.valueOf(this.deviceRestartTimeout))).intValue();
    }

    public void setDeviceRestartTimeout(int i) {
        this.deviceRestartTimeout = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getAppWaitTimeout() {
        return ((Integer) C0978h.a(Integer.valueOf(this.appWaitTimeout))).intValue();
    }

    public void setAppWaitTimeout(int i) {
        this.appWaitTimeout = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getOtaUnitSize() {
        return ((Integer) C0978h.a(Integer.valueOf(this.otaUnitSize))).intValue();
    }

    public void setOtaUnitSize(int i) {
        this.otaUnitSize = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
