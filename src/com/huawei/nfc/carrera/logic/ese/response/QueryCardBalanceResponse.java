package com.huawei.nfc.carrera.logic.ese.response;

public class QueryCardBalanceResponse extends QueryCardBaseResponse {
    public String balance;

    public QueryCardBalanceResponse() {
        this.resultCode = -1;
    }

    public QueryCardBalanceResponse(int i, String str) {
        this.resultCode = i;
        this.balance = str;
    }
}
