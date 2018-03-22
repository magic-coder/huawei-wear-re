package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

public class GetSportDataByTimeRsp extends CloudCommonReponse {
    private Map<String, List<SportDetail>> data;
    private List<SportDetail> detailInfos;

    public Map<String, List<SportDetail>> getData() {
        return this.data;
    }

    public void setData(Map<String, List<SportDetail>> map) {
        this.data = map;
    }

    public List<SportDetail> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<SportDetail> list) {
        this.detailInfos = list;
    }

    public String toString() {
        return "GetSportDataByTimeRsp{data=" + this.data + ", detailInfos=" + this.detailInfos + '}';
    }
}
