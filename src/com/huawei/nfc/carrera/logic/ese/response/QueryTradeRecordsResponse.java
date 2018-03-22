package com.huawei.nfc.carrera.logic.ese.response;

import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import java.util.List;

public class QueryTradeRecordsResponse extends QueryCardBaseResponse {
    public List<TradeRecord> records;

    public QueryTradeRecordsResponse() {
        this.resultCode = -1;
    }

    public QueryTradeRecordsResponse(int i, List<TradeRecord> list) {
        this.resultCode = i;
        this.records = list;
    }
}
