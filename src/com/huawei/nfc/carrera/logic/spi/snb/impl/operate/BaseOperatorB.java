package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseOperatorB {
    protected abstract SNBBaseResponse makeErrorResponse(int i);

    protected abstract SNBBaseResponse makeSuccessResponse(String str) throws JSONException;

    protected abstract void reportDataEmptyErrorMsg();

    protected abstract void reportEmptyErrorMsg();

    protected abstract void reportFailErrorMsg(int i, String str);

    protected abstract void reportJsonExpErrorMsg(JSONException jSONException);

    protected SNBBaseResponse analyzeResult(String str) {
        if (StringUtil.isEmpty(str, true)) {
            reportEmptyErrorMsg();
            return makeErrorResponse(100002);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int intValue = JSONHelper.getIntValue(jSONObject, "result_code");
            String stringValue = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RESULT_MSG);
            if (intValue != 0) {
                reportFailErrorMsg(intValue, stringValue);
                return makeErrorResponse(intValue);
            }
            String stringValue2 = JSONHelper.getStringValue(jSONObject, "data");
            LogX.d("SNBServiceImpl query dataField : " + stringValue2);
            if (!StringUtil.isEmpty(stringValue2, true)) {
                return makeSuccessResponse(stringValue2);
            }
            reportDataEmptyErrorMsg();
            return makeErrorResponse(100002);
        } catch (JSONException e) {
            reportJsonExpErrorMsg(e);
            return makeErrorResponse(100003);
        }
    }
}
