package com.huawei.nfc.carrera.server.card.response;

import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import java.util.List;

public class ServerAccessBaseResponse extends CardServerBaseResponse {
    private List<ServerAccessAPDU> apduList = null;
    private String resultDesc = null;
    private String transactionId = null;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public List<ServerAccessAPDU> getApduList() {
        return this.apduList;
    }

    public void setApduList(List<ServerAccessAPDU> list) {
        this.apduList = list;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }
}
