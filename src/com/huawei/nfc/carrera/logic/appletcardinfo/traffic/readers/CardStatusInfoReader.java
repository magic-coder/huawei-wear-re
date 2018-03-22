package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import java.util.List;

public class CardStatusInfoReader extends InfoReader<Boolean> {
    private static final String TAG = "CardStatusInfoReader";

    public CardStatusInfoReader(IOmaService iOmaService) {
        super(iOmaService);
    }

    protected Boolean handleResult(List<List<String>> list) throws AppletCardException {
        for (List list2 : list) {
            checkData(TAG, list2);
            if (!Boolean.parseBoolean((String) list2.get(list2.size() - 1))) {
                throw new AppletCardException(201, "card status is abnormal. data : " + ((String) list2.get(0)));
            }
        }
        return Boolean.valueOf(true);
    }
}
