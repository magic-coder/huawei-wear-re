package com.huawei.nfc.carrera.logic.spi.fm.response;

import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import java.util.ArrayList;

public class QueryBusinessOrdersResponse extends FMBaseResponse {
    public ArrayList<NfcosBusinessOrder> orderList;
}
