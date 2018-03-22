package com.leisen.wallet.sdk.business;

import java.util.List;

public class BaseBusinessForResp extends Business {
    private List<ApduBean> capduList;
    private int finishFlag;
    private String operationDes;
    private int operationResult;

    public int getOperationResult() {
        return this.operationResult;
    }

    public void setOperationResult(int i) {
        this.operationResult = i;
    }

    public String getOperationDes() {
        return this.operationDes;
    }

    public void setOperationDes(String str) {
        this.operationDes = str;
    }

    public int getFinishFlag() {
        return this.finishFlag;
    }

    public void setFinishFlag(int i) {
        this.finishFlag = i;
    }

    public List<ApduBean> getCapduList() {
        return this.capduList;
    }

    public void setCapduList(List<ApduBean> list) {
        this.capduList = list;
    }
}
