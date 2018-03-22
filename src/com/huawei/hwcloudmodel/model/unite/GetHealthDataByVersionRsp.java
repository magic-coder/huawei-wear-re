package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetHealthDataByVersionRsp extends CloudCommonReponse {
    private Long currentVersion;
    private List<HealthDetail> detailInfos;

    public List<HealthDetail> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<HealthDetail> list) {
        this.detailInfos = list;
    }

    public Long getCurrentVersion() {
        return this.currentVersion;
    }

    public void setCurrentVersion(Long l) {
        this.currentVersion = l;
    }

    public String toString() {
        return "GetHealthDataByVersionRsp{detailInfos=" + this.detailInfos + ", currentVersion=" + this.currentVersion + '}';
    }
}
