package com.leisen.wallet.sdk.business;

public class BaseBusinessForReqNext extends BaseBusinessForReq {
    private ApduResBean rapduList;
    private int result;

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public ApduResBean getRapduList() {
        return this.rapduList;
    }

    public void setRapduList(ApduResBean apduResBean) {
        this.rapduList = apduResBean;
    }
}
