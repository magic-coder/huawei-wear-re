package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import java.util.List;

public class CardDateInfoReader extends InfoReader<String[]> {
    private static final String TAG = "CardDateInfoReader";

    public CardDateInfoReader(IOmaService iOmaService) {
        super(iOmaService);
    }

    protected String[] handleResult(List<List<String>> list) throws AppletCardException {
        List list2 = (List) list.get(0);
        checkData(TAG, list2);
        int size = list2.size();
        String str = (String) list2.get(size - 2);
        String str2 = (String) list2.get(size - 1);
        return new String[]{str, str2};
    }
}
