package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeResponse;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseOperatorA {
    protected abstract void reportEmptyErrorMsg();

    protected abstract void reportFailErrorMsg(int i, String str);

    protected abstract void reportJsonExpErrorMsg(JSONException jSONException);

    protected RechargeResponse analyzeResult(String str, String str2) {
        RechargeResponse rechargeResponse = new RechargeResponse();
        if (StringUtil.isEmpty(str, true)) {
            reportEmptyErrorMsg();
            rechargeResponse.setReturnCd(100002);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int intValue = JSONHelper.getIntValue(jSONObject, "result_code");
                String stringValue = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RESULT_MSG);
                if (intValue != 0) {
                    reportFailErrorMsg(intValue, stringValue);
                    rechargeResponse.setMsg(stringValue);
                    rechargeResponse.setReturnCd(intValue);
                } else {
                    rechargeResponse.setReturnCd(0);
                }
            } catch (JSONException e) {
                reportJsonExpErrorMsg(e);
                rechargeResponse.setReturnCd(100003);
            }
        }
        return rechargeResponse;
    }

    protected int analyzeResult(String str) {
        if (StringUtil.isEmpty(str, true)) {
            reportEmptyErrorMsg();
            return 100002;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int intValue = JSONHelper.getIntValue(jSONObject, "result_code");
            String stringValue = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RESULT_MSG);
            if (intValue == 0) {
                return 0;
            }
            reportFailErrorMsg(intValue, stringValue);
            return intValue;
        } catch (JSONException e) {
            reportJsonExpErrorMsg(e);
            return 100003;
        }
    }

    protected String makeExtraInfo(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey()).append("=").append((String) entry.getValue());
            stringBuffer.append(SNBConstant.FILTER);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    protected String makeToken(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SNBConstant.FIELD_ORDER_ID).append("=").append(str).append(SNBConstant.FILTER);
        stringBuffer.append(SNBConstant.FIELD_DEVICE_ID).append("=").append(str2).append(SNBConstant.FILTER);
        stringBuffer.append(SNBConstant.FIELD_SP_ID).append("=").append(SNBConstant.SPID);
        return stringBuffer.toString();
    }
}
