package com.huawei.nfc.carrera.logic.ese.response;

import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;

public class QueryCardInfoResponse extends QueryCardBaseResponse {
    public TrafficCardInfo cardInfo;

    public QueryCardInfoResponse(int i, TrafficCardInfo trafficCardInfo) {
        this.resultCode = i;
        this.cardInfo = trafficCardInfo;
    }

    public void setCardNo(QueryCardNumResponse queryCardNumResponse) {
        if (this.cardInfo != null) {
            this.cardInfo.setCardNo(queryCardNumResponse.cardNum);
        }
    }

    public void setCardValidity(QueryCardValidityDateResponse queryCardValidityDateResponse) {
        if (this.cardInfo != null) {
            this.cardInfo.setExpireDate(queryCardValidityDateResponse.expireDate);
            this.cardInfo.setValidityTermStatus(queryCardValidityDateResponse.validityTermStatus);
        }
    }

    public void setBalance(QueryCardBalanceResponse queryCardBalanceResponse) {
        if (this.cardInfo != null) {
            this.cardInfo.setBalance(queryCardBalanceResponse.balance);
        }
    }

    public boolean setResultCdforFailed(QueryCardBaseResponse queryCardBaseResponse) {
        if (queryCardBaseResponse.isSuccess()) {
            return false;
        }
        this.resultCode = queryCardBaseResponse.resultCode;
        return true;
    }
}
