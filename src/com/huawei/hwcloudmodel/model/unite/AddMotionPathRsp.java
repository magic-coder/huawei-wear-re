package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

public class AddMotionPathRsp extends CloudCommonReponse {
    private Long timestamp;

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public String toString() {
        return "AddMotionPathRsp{timestamp=" + this.timestamp + '}';
    }
}
