package com.huawei.pluginkidwatch.common.entity.model;

public class ConfirmBindIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String recordId = "";
    public String result = "";

    public void setHandleFenceInfo(String str, String str2) {
        this.recordId = str;
        this.result = str2;
    }

    public String toString() {
        return "  recordId = " + this.recordId + "  result = " + this.result;
    }
}
