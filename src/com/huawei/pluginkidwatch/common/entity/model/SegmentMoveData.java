package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SegmentMoveData implements Serializable {
    public List<MovePointData> movePointDatas = new ArrayList();
    public String startTime = "";

    public String toString() {
        return "  startTime = " + this.startTime + "  movePointDatas = " + this.movePointDatas.toString();
    }
}
