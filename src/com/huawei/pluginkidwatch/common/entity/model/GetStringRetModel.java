package com.huawei.pluginkidwatch.common.entity.model;

public class GetStringRetModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public CommonState commonState = new CommonState();
    public String data = "";

    public String toString() {
        return "GetStringRetModel [data=" + this.data + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + "]";
    }
}
