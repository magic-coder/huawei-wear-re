package com.huawei.nfc.carrera.server.card.request;

public class WipeAllCUPCardRequest extends CardServerBaseRequest {
    public static final String WIPE_ALL_CUP_CARD = "10";
    public String cplc;
    public String event;
}
