package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetMotionPathByVersionRsp extends CloudCommonReponse {
    private Long currentVersion;
    private List<MotionPathDetail> detailInfos;

    public List<MotionPathDetail> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<MotionPathDetail> list) {
        this.detailInfos = list;
    }

    public Long getCurrentVersion() {
        return this.currentVersion;
    }

    public void setCurrentVersion(Long l) {
        this.currentVersion = l;
    }

    public String toString() {
        return "GetMotionPathByVersionRsp{detailInfos=" + this.detailInfos + ", currentVersion=" + this.currentVersion + '}';
    }
}
