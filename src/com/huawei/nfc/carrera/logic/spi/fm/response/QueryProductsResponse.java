package com.huawei.nfc.carrera.logic.spi.fm.response;

import cn.com.fmsh.tsm.business.bean.Product;
import java.util.List;

public class QueryProductsResponse extends FMBaseResponse {
    private List<Product> list;

    public List<Product> getList() {
        return this.list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
