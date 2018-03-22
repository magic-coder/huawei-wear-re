package com.huawei.nfc.carrera.logic.appletcardinfo;

import android.content.Context;
import com.huawei.nfc.carrera.logic.appletcardinfo.impl.AppletCardInfoReader;

public class AppletInfoApiFactory {
    public static AppletCardInfoReadApi createAppletCardInfoReader(Context context) {
        return new AppletCardInfoReader(context);
    }
}
