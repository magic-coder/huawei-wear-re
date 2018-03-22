package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import java.util.List;

public class CardNumInfoReader extends InfoReader<String> {
    private static final String TAG = "CardNumInfoReader";

    public CardNumInfoReader(IOmaService iOmaService) {
        super(iOmaService);
    }

    protected String handleResult(List<List<String>> list) throws AppletCardException {
        List list2 = (List) list.get(0);
        checkData(TAG, list2);
        return (String) list2.get(list2.size() - 1);
    }
}
