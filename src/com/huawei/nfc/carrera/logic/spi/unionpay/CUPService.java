package com.huawei.nfc.carrera.logic.spi.unionpay;

import com.huawei.nfc.carrera.logic.spi.unionpay.response.CUPEncryptResponse;

public interface CUPService {
    CUPEncryptResponse encryptCardInfo(String str);

    int excuteCMD(String str, String str2);

    int init();
}
