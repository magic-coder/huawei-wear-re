package com.huawei.nfc.carrera.logic.spi.serveraccess.response;

import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import java.util.List;

public class QueryOrderResponse extends BaseResponse {
    private List<QueryOrder> orderList = null;

    public List<QueryOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<QueryOrder> list) {
        this.orderList = list;
    }
}
