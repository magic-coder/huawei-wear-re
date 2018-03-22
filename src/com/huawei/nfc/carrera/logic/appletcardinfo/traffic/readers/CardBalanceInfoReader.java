package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import java.util.List;

public class CardBalanceInfoReader extends InfoReader<Integer[]> {
    private static final String TAG = "CardBalanceInfoReader";

    public CardBalanceInfoReader(IOmaService iOmaService) {
        super(iOmaService);
    }

    protected Integer[] handleResult(List<List<String>> list) throws AppletCardException {
        Integer[] numArr = new Integer[2];
        List list2;
        if (list.size() < 2) {
            numArr[0] = Integer.valueOf(0);
            list2 = (List) list.get(0);
            checkData(TAG, list2);
            numArr[1] = Integer.valueOf(Integer.parseInt((String) list2.get(list2.size() - 1)));
        } else {
            for (int i = 0; i < 2; i++) {
                list2 = (List) list.get(i);
                checkData(TAG, list2);
                numArr[i] = Integer.valueOf(Integer.parseInt((String) list2.get(list2.size() - 1)));
            }
        }
        return numArr;
    }
}
