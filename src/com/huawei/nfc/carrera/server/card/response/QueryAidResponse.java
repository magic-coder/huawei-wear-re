package com.huawei.nfc.carrera.server.card.response;

public class QueryAidResponse extends CardServerBaseResponse {
    public static final int RESPONSE_CODE_AID_NOT_EXISTED = -3;
    public static final int RESPONSE_CODE_CARD_UNSTARTED_OR_DELETEED = -5;
    public String aid;
    public String virtualCardRefID;
}
