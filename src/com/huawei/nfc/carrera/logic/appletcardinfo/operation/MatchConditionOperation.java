package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class MatchConditionOperation extends Operation {
    private Result defaultResult;
    private List<Result> resultList;

    class Result {
        String result;
        String value;

        public Result(String str, String str2) {
            this.value = str;
            this.result = str2;
        }
    }

    public String handleData(String str) throws AppletCardException {
        if (this.resultList == null || this.resultList.isEmpty()) {
            throw new AppletCardException(2, " MatchConditionOperation no value-result pairs");
        } else if (this.defaultResult == null) {
            throw new AppletCardException(2, " MatchConditionOperation default value-result is null");
        } else {
            for (Result result : this.resultList) {
                if (str.matches(result.value)) {
                    return getResult(str, result.result);
                }
            }
            return getResult(str, this.defaultResult.result);
        }
    }

    private String getResult(String str, String str2) {
        return (str2.length() == 2 && str2.matches("r[0-9]")) ? str : str2;
    }

    public void init(String str, String str2) throws AppletCardException {
        super.init(str, str2);
        if (StringUtil.isEmpty(str2, true)) {
            this.resultList = null;
            this.defaultResult = null;
            return;
        }
        String[] split = str2.split(":");
        if (split.length < 2) {
            this.resultList = null;
            this.defaultResult = null;
            return;
        }
        this.resultList = new ArrayList();
        for (String split2 : split) {
            String split22;
            String[] split3 = split22.split("=");
            if (split3.length != 2) {
                this.resultList = null;
                this.defaultResult = null;
                return;
            }
            String str3 = split3[0];
            split22 = split3[1];
            if ("dft".equals(str3)) {
                this.defaultResult = new Result(str3, split22);
            } else {
                this.resultList.add(new Result(str3, split22));
            }
        }
    }
}
