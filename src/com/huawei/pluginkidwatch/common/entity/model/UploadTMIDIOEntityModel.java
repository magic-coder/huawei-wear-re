package com.huawei.pluginkidwatch.common.entity.model;

public class UploadTMIDIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String tmid = "";
    public String type = "1";

    public void setHandleFenceInfo(String str) {
        this.tmid = str;
    }

    public String toString() {
        return "  tmid = " + this.tmid;
    }
}
