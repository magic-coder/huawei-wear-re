package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

public class GetHealthDataByTimeRsp extends CloudCommonReponse {
    private Map<String, List<HealthDetail>> data;
    private List<HealthDetail> detailInfos;

    public List<HealthDetail> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<HealthDetail> list) {
        this.detailInfos = list;
    }

    public Map<String, List<HealthDetail>> getData() {
        return this.data;
    }

    public void setData(Map<String, List<HealthDetail>> map) {
        this.data = map;
    }

    public String toString() {
        return "GetHealthDataByTimeRsp{detailInfos=" + this.detailInfos + ", data=" + this.data + '}';
    }
}
