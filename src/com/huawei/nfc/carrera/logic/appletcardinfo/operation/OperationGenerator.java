package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class OperationGenerator {
    private static Operation initHandler(String str) {
        if ("cut".equals(str)) {
            return new CutStringOperation();
        }
        if ("match".equals(str)) {
            return new MatchConditionOperation();
        }
        if ("parseInt".equals(str)) {
            return new ParseIntOperation();
        }
        if ("reverse".equals(str)) {
            return new ReverseOperation();
        }
        if ("minus".equals(str)) {
            return new MinusOperation();
        }
        if ("xor".equals(str)) {
            return new XorOperation();
        }
        if ("mod".equals(str)) {
            return new ModOperation();
        }
        if ("cat".equals(str)) {
            return new CatStringOperation();
        }
        return null;
    }

    public static List<Operation> parseOperations(String str) throws AppletCardException {
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        List<Operation> arrayList = new ArrayList();
        for (String str2 : str.split(";")) {
            String[] split = str2.split(",");
            Operation initHandler = initHandler(split[0]);
            if (initHandler != null) {
                if (split.length < 2) {
                    throw new AppletCardException(2, "operation config error. config data : " + str2);
                }
                initHandler.init(split[1], split[2]);
                arrayList.add(initHandler);
            }
        }
        return arrayList;
    }
}
