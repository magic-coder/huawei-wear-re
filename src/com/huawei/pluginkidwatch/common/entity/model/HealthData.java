package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HealthData implements Serializable {
    public String logDate = "";
    public List<SegmentMoveData> segmentMoveDatas = new ArrayList();

    public String toString() {
        return "  logDate = " + this.logDate + "  segmentMoveDatas = " + this.segmentMoveDatas.toString();
    }
}
