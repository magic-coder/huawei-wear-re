package com.huawei.nfc.carrera.server.card.request;

import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import java.util.List;

public class ServerAccessApplyAPDURequest extends ServerAccessBaseRequest {
    private int apduCount = 0;
    private List<ServerAccessAPDU> apduList = null;
    private String transactionId = null;

    public ServerAccessApplyAPDURequest(String str, String str2, String str3, String str4, int i, List<ServerAccessAPDU> list, String str5, String str6) {
        setIssuerId(str);
        setAppletAid(str2);
        setCplc(str3);
        setDeviceModel(str5);
        setSeChipManuFacturer(str6);
        this.transactionId = str4;
        this.apduCount = i;
        this.apduList = list;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public int getApduCount() {
        return this.apduCount;
    }

    public void setApduCount(int i) {
        this.apduCount = i;
    }

    public List<ServerAccessAPDU> getApduList() {
        return this.apduList;
    }

    public void setApduList(List<ServerAccessAPDU> list) {
        this.apduList = list;
    }
}
