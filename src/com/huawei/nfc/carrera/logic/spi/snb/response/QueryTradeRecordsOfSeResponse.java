package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import java.util.List;

public class QueryTradeRecordsOfSeResponse extends SNBBaseResponse {
    public List<TradeRecord> records;
    public int resultCode;

    public QueryTradeRecordsOfSeResponse() {
        this.resultCode = -1;
    }

    public QueryTradeRecordsOfSeResponse(List<TradeRecord> list, int i) {
        this.resultCode = i;
        this.records = list;
    }
}
