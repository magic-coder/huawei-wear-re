package com.huawei.nfc.carrera.server.card.response;

import com.huawei.nfc.carrera.server.card.model.ServerAccessIssueAmount;
import com.huawei.nfc.carrera.server.card.model.ServerAccessRechargeAmount;
import java.util.List;

public class ServerAccessQueryAmountResponse extends ServerAccessBaseResponse {
    private List<ServerAccessIssueAmount> issueAmountList = null;
    private List<ServerAccessRechargeAmount> rechargeAmountList = null;

    public List<ServerAccessIssueAmount> getIssueAmountList() {
        return this.issueAmountList;
    }

    public void setIssueAmountList(List<ServerAccessIssueAmount> list) {
        this.issueAmountList = list;
    }

    public List<ServerAccessRechargeAmount> getRechargeAmountList() {
        return this.rechargeAmountList;
    }

    public void setRechargeAmountList(List<ServerAccessRechargeAmount> list) {
        this.rechargeAmountList = list;
    }
}
