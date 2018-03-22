package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovePointData implements Serializable {
    public List<Integer> move_points = new ArrayList();
    public int move_type;

    public String toString() {
        return "  move_type = " + this.move_type + "  move_points = " + this.move_points.toString();
    }
}
