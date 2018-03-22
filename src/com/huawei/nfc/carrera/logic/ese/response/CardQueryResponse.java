package com.huawei.nfc.carrera.logic.ese.response;

import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;

public class CardQueryResponse extends SNBBaseResponse {
    public TrafficCardInfo cardInfo;

    public interface CardQueryResponseSAI1 {
    }

    public interface CardQueryResponseSAI2 {
    }

    public interface CardQueryResponseSAI3 {
    }

    public interface CardQueryResponseSAI4 {
    }

    public CardQueryResponse(TrafficCardInfo trafficCardInfo, int i) {
        this.cardInfo = trafficCardInfo;
        this.returnCd = i;
    }
}
