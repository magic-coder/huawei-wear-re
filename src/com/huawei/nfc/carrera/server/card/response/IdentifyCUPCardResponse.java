package com.huawei.nfc.carrera.server.card.response;

public class IdentifyCUPCardResponse extends CardServerBaseResponse {
    public static final int ERR_APPLET_IS_NOT_EXIST = 1301;
    public static final int ERR_CHECK_CARD_BIN_FAIL = 1110;
    public static final int ERR_NO_BANK_INFO = 1618;
    public static final int ERR_NO_ISSUER_INFO = 1349;
    public static final int ERR_UNSUPPORTED_CARD_TYPE = 1617;
    public int cardType;
    public String issuerId;
}
