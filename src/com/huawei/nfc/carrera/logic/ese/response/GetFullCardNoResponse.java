package com.huawei.nfc.carrera.logic.ese.response;

import com.huawei.nfc.carrera.logic.ese.model.GetFullCardNoInfo;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;

public class GetFullCardNoResponse extends SNBBaseResponse {
    public GetFullCardNoInfo cardInfo;

    public interface GetFullCardNoResponseSAI1 {
    }

    public interface GetFullCardNoResponseSAI2 {
    }

    public interface GetFullCardNoResponseSAI3 {
    }

    public interface GetFullCardNoResponseSAI4 {
    }

    public GetFullCardNoResponse(GetFullCardNoInfo getFullCardNoInfo, int i) {
        this.cardInfo = getFullCardNoInfo;
        this.returnCd = i;
    }
}
