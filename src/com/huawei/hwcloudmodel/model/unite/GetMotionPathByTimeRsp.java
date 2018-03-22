package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetMotionPathByTimeRsp extends CloudCommonReponse {
    private List<MotionPathDetail> detailInfos;

    public List<MotionPathDetail> getDdetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<MotionPathDetail> list) {
        this.detailInfos = list;
    }

    public String toString() {
        return "GetMotionPathByTimeRsp{detailInfos=" + this.detailInfos + '}';
    }
}
