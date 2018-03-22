package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetHealthStatRsp extends CloudCommonReponse {
    private List<ProfessionalSleepTotal> professionalSleepTotal;
    private List<SleepTotal> sleepTotal;

    public List<SleepTotal> getSleepTotal() {
        return this.sleepTotal;
    }

    public List<ProfessionalSleepTotal> getProfessionalSleepTotal() {
        return this.professionalSleepTotal;
    }

    public void setSleepTotal(List<SleepTotal> list) {
        this.sleepTotal = list;
    }

    public void setProfessionalSleepTotal(List<ProfessionalSleepTotal> list) {
        this.professionalSleepTotal = list;
    }

    public String toString() {
        return "GetHealthStatRsp{sleepTotal=" + this.sleepTotal + ", professionalSleepTotal=" + this.professionalSleepTotal + '}';
    }
}
