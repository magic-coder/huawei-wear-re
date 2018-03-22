package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.SupportNFCBankInfo;
import java.util.Map;

public interface QuerySupportBankInfoCallback extends BaseCallback {
    void queryResultCallback(Map<String, SupportNFCBankInfo> map);
}
