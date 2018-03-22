package com.huawei.nfc.carrera.server.card.response;

import com.huawei.nfc.carrera.server.card.model.ServerAccessQueryOrder;
import java.util.List;

public class ServerAccessQueryOrderResponse extends ServerAccessBaseResponse {
    private List<ServerAccessQueryOrder> orderList = null;

    public List<ServerAccessQueryOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<ServerAccessQueryOrder> list) {
        this.orderList = list;
    }
}
