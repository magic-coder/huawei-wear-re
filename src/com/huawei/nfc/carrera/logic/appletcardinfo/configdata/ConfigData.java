package com.huawei.nfc.carrera.logic.appletcardinfo.configdata;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import java.util.List;

public interface ConfigData {
    public static final int TYPE_BANK_CARD_NUM = 5;
    public static final int TYPE_CARD_AMOUNT = 3;
    public static final int TYPE_CARD_DATE = 2;
    public static final int TYPE_CARD_NUM = 1;
    public static final int TYPE_CARD_RECORDS = 4;
    public static final int TYPE_CARD_STATUS = 0;

    List<ApduCommand> getApudList(String str, int i) throws AppletCardException;

    boolean isSameApduNumAndDate(String str) throws AppletCardException;
}
