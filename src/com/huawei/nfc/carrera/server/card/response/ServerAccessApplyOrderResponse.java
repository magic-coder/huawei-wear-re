package com.huawei.nfc.carrera.server.card.response;

import com.huawei.nfc.carrera.server.card.model.ServerAccessApplyOrder;
import java.util.List;

public class ServerAccessApplyOrderResponse extends ServerAccessBaseResponse {
    private List<ServerAccessApplyOrder> orderList = null;

    public List<ServerAccessApplyOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<ServerAccessApplyOrder> list) {
        this.orderList = list;
    }
}
