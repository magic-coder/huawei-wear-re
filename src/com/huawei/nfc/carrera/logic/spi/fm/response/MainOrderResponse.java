package com.huawei.nfc.carrera.logic.spi.fm.response;

import cn.com.fmsh.nfcos.client.service.huawei.NfcosMainOrder;

public class MainOrderResponse extends FMBaseResponse {
    public static final int EXIST_HAS_PAIED_ORDER = 1;
    public NfcosMainOrder order;
}
