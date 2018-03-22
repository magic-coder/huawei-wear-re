package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetSleepStatRsp extends CloudCommonReponse {
    private List<SleepTotal> sleepTotals;

    public List<SleepTotal> getSleepTotals() {
        return this.sleepTotals;
    }

    public void setSleepTotals(List<SleepTotal> list) {
        this.sleepTotals = list;
    }

    public String toString() {
        return "GetSleepStatRsp{sleepTotals=" + this.sleepTotals + '}';
    }
}
