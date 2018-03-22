package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;

public class PayOrderResponse extends SNBBaseResponse {
    public PayInfo payInfo;

    public PayOrderResponse(PayInfo payInfo, int i) {
        this.payInfo = payInfo;
        this.returnCd = i;
    }
}
