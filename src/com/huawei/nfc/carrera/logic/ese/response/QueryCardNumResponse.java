package com.huawei.nfc.carrera.logic.ese.response;

public class QueryCardNumResponse extends QueryCardBaseResponse {
    public String cardNum;

    public QueryCardNumResponse() {
        this.resultCode = -1;
    }

    public QueryCardNumResponse(int i, String str) {
        this.resultCode = i;
        this.cardNum = str;
    }
}
