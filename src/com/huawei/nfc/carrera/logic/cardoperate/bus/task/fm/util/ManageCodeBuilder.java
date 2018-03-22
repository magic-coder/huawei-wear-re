package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util;

import android.content.Context;
import com.huawei.nfc.carrera.util.LogX;

public class ManageCodeBuilder extends ServiceCodeBuilder {
    private static final String MANAGE_MOVE = "8000000400110003";

    public ManageCodeBuilder(Context context) {
        super(context);
    }

    protected String getServiceNo(int i) {
        if (i == 3) {
            return MANAGE_MOVE;
        }
        LogX.e("type is illegal");
        return null;
    }

    protected byte[] getServiceData(String str) {
        return new byte[0];
    }
}
