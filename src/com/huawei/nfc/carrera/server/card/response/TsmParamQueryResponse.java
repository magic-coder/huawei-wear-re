package com.huawei.nfc.carrera.server.card.response;

public class TsmParamQueryResponse extends CardServerBaseResponse {
    public String funcID;
    public String servicID;

    public String toString() {
        return "TsmParamQueryResponse{funcID='" + this.funcID + '\'' + ", servicID='" + this.servicID + '\'' + ", servicID='" + this.returnCode + '}';
    }
}
