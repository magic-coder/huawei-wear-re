package com.huawei.nfc.carrera.logic.ese;

import android.content.Context;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;

public class ESEApiFactory {
    public static ESEInfoManagerApi createESEInfoManagerApi(Context context) {
        return ESEInfoManager.getInstance(context);
    }
}
