package com.huawei.nfc.carrera.logic.ese.response;

public class QueryCardBaseResponse {
    public int resultCode;

    public boolean isSuccess() {
        return this.resultCode == 0;
    }

    public QueryCardBaseResponse(int i) {
        this.resultCode = i;
    }
}
