package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class Fence implements Serializable {
    private static final long serialVersionUID = -2527453346234304077L;
    public String cycle;
    public String deviceCode;
    public String endTime;
    public String fenceId;
    public String fenceRange;
    public String isActive;
    public String locationName = "";
    public String name;
    public String startTime;
    public int type;

    public String toString() {
        return "  deviceCode = " + this.deviceCode + "  name = " + this.name + "  type = " + this.type + "  fenceRange = " + this.fenceRange + "  startTime = " + this.startTime + "  endTime = " + this.endTime + "  cycle = " + this.cycle + "  isActive = " + this.isActive + "  fenceId = " + this.fenceId + "  locationName = " + this.locationName;
    }

    public void locationNameBuild() {
    }

    public void initDeviceCode() {
    }

    public void activeFenceRange() {
    }

    public void activeFenceRangeStartTime() {
    }

    public void setFenceRangeActiveState() {
    }

    public void cycleStartTimeAndEndTime() {
    }

    public void initStartTime() {
    }
}
