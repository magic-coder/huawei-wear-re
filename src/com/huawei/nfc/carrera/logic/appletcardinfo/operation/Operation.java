package com.huawei.nfc.carrera.logic.appletcardinfo.operation;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.List;

public abstract class Operation {
    private int idx;
    protected String param = "";
    private int paramIdx = -1;

    protected abstract String handleData(String str) throws AppletCardException;

    public void init(String str, String str2) throws AppletCardException {
        int resultIdx = getResultIdx(str);
        if (resultIdx < 0) {
            throw new AppletCardException(2, "operation config error. config data : " + str + "," + str2);
        }
        this.idx = resultIdx;
        this.param = str2;
        this.paramIdx = getResultIdx(str2);
    }

    public String checkAndHandleData(List<String> list) throws AppletCardException {
        if (this.idx >= list.size()) {
            throw new AppletCardException(2, "handlerRespData idx out of bound. idx : " + this.idx + " size : " + list.size());
        }
        String str = (String) list.get(this.idx);
        if (!StringUtil.isEmpty(str, true)) {
            return handleData(str);
        }
        throw new AppletCardException(1, getClass().getSimpleName() + " checkAndHandleData but data is null");
    }

    public boolean isNeedChangeParamWithData() {
        return this.paramIdx >= 0;
    }

    public void changeParamWithData(List<String> list) throws AppletCardException {
        if (this.paramIdx >= list.size() || this.paramIdx < 0) {
            throw new AppletCardException(2, "handlerRespData idx out of bound. paramIdx : " + this.paramIdx + " size : " + list.size());
        }
        this.param = (String) list.get(this.paramIdx);
    }

    private boolean isResultPattern(String str) {
        return str != null && str.matches("^r[0-9]");
    }

    private int getResultIdx(String str) {
        if (isResultPattern(str)) {
            return Integer.parseInt(str.replace("r", ""));
        }
        return -1;
    }
}
