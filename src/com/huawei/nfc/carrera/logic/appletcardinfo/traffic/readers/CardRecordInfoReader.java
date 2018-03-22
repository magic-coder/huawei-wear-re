package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduCommandInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.TransactionRecord;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.List;

public class CardRecordInfoReader extends InfoReader<List<TransactionRecord>> {
    private static final int RECORES_CNT = 10;
    private static final String SW_6A83 = "6A83";

    public CardRecordInfoReader(IOmaService iOmaService) {
        super(iOmaService);
    }

    protected List<TransactionRecord> handleResult(List<List<String>> list) {
        List<TransactionRecord> arrayList = new ArrayList();
        for (List parseRecord : list) {
            TransactionRecord parseRecord2 = parseRecord(parseRecord);
            if (parseRecord2 != null) {
                arrayList.add(parseRecord2);
            }
        }
        return arrayList;
    }

    private TransactionRecord parseRecord(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() <= 4) {
            return null;
        }
        if (((String) list.get(0)).matches("^0*$")) {
            return null;
        }
        TransactionRecord transactionRecord = new TransactionRecord();
        try {
            transactionRecord.setRecordAmount(Integer.parseInt((String) list.get(1), 16));
        } catch (NumberFormatException e) {
            LogX.i("parseRecord parse amount failed. rapdu :  amountStr : ");
        }
        transactionRecord.setRecordType((String) list.get(2));
        transactionRecord.setRecordTime((String) list.get(3));
        if (list.size() >= 5) {
            if ("1".equals((String) list.get(4))) {
                transactionRecord.setRecordType("1");
            } else {
                transactionRecord.setRecordType("2");
            }
        }
        return transactionRecord;
    }

    protected int getNextStep(ApduCommandInfo apduCommandInfo, int i, int i2) {
        if (SW_6A83.equals(apduCommandInfo.getSw())) {
            int i3 = i2 / 10;
            for (int i4 = 1; i4 <= i3; i4++) {
                int i5 = i4 * 10;
                if (i < i5) {
                    LogX.i("readRecords for 6A83, skip steps(" + i + " - " + (i5 - 1) + ", totle steps : " + i2);
                    return i5;
                }
            }
        }
        return super.getNextStep(apduCommandInfo, i, i2);
    }
}
