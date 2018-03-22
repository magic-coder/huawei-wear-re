package com.huawei.nfc.carrera.logic.spi.serveraccess.response;

import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import java.util.List;

public class ApplyOrderResponse extends BaseResponse {
    private List<ApplyOrder> orderList = null;

    public List<ApplyOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<ApplyOrder> list) {
        this.orderList = list;
    }
}
