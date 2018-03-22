package com.huawei.nfc.carrera.logic.spi.serveraccess.response;

import com.huawei.nfc.carrera.logic.spi.serveraccess.model.IssueAmount;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.RechargeAmount;
import java.util.List;

public class QueryAmountResponse extends BaseResponse {
    private List<IssueAmount> issueAmountList = null;
    private List<RechargeAmount> rechargeAmountList = null;

    public List<IssueAmount> getIssueAmountList() {
        return this.issueAmountList;
    }

    public void setIssueAmountList(List<IssueAmount> list) {
        this.issueAmountList = list;
    }

    public List<RechargeAmount> getRechargeAmountList() {
        return this.rechargeAmountList;
    }

    public void setRechargeAmountList(List<RechargeAmount> list) {
        this.rechargeAmountList = list;
    }
}
