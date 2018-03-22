package com.huawei.pluginkidwatch.common.entity.model;

public class HandleFenceIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String fenceId = "";
    public int type = 1;

    public void setHandleFenceInfo(String str, int i) {
        this.fenceId = str;
        this.type = i;
    }

    public String toString() {
        return "  fenceId = " + this.fenceId + "  type = " + this.type;
    }
}
