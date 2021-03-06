package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.SportTotalData;
import java.util.List;

public class GetSportStatRsp extends CloudCommonReponse {
    private List<SportTotalData> sportStat;

    public List<SportTotalData> getSportStat() {
        return this.sportStat;
    }

    public void setSportStat(List<SportTotalData> list) {
        this.sportStat = list;
    }

    public String toString() {
        return "GetSportStatRsp{sportStat=" + this.sportStat + '}';
    }
}
