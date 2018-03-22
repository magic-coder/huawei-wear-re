package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import java.util.Map;

public interface QuerySupportedTrafficCardListCallback extends BaseCallback {
    void querySupportedTrafficCardListCallback(Map<String, SupportedTrafficCardListItem> map);
}
