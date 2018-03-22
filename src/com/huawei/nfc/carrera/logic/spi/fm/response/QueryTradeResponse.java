package com.huawei.nfc.carrera.logic.spi.fm.response;

import cn.com.fmsh.nfcos.client.service.huawei.CardAppRecord;

public class QueryTradeResponse extends FMBaseResponse {
    public static final int TRADE_TYPE_ONLINE_RECHARGE = 12;
    public static final int TRADE_TYPE_RECHARGE = 6;
    public CardAppRecord[] tradeRecords;
}
