package com.huawei.nfc.carrera.lifecycle.push.data;

import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class PushMessageParser {
    private static final String NFC_PUSH_MSG_CONTENT_KEY = "content";
    private static final String NFC_PUSH_MSG_TYPE_KEY = "msg";

    public Object parsePushMessage(String str) {
        LogX.d("parsePushMessage, content: " + str, true);
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            LogX.d("parsePushMessage, get json exception.");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        String stringValue = JsonUtil.getStringValue(jSONObject, "msg");
        String stringValue2 = JsonUtil.getStringValue(jSONObject, "content");
        if (StringUtil.isEmpty(stringValue2, true)) {
            LogX.d("parsePushMessage, content is empty.");
            return null;
        } else if ("reportloss".equals(stringValue)) {
            return parsePushLostMsg(stringValue2);
        } else {
            if ("consume".equals(stringValue)) {
                return parsePushConsumeMsg(stringValue2);
            }
            if ("UnionPayPush".equals(stringValue)) {
                return parsePushCUPOperateMsg(stringValue2);
            }
            if ("personizedPush".equals(stringValue)) {
                return parseCUPPMsg(stringValue2);
            }
            LogX.d("the push msg type do not supported, now.");
            return null;
        }
    }

    private PushLostMessage parsePushLostMsg(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            LogX.d("parsePushLostMsg, get json exception.");
            jSONObject = null;
        }
        if (jSONObject == null) {
            LogX.d("parsePushLostMsg, jsonobject is null");
            return null;
        }
        PushLostMessage pushLostMessage = new PushLostMessage();
        pushLostMessage.setAid(JsonUtil.getStringValue(jSONObject, "aid"));
        pushLostMessage.setCplc(JsonUtil.getStringValue(jSONObject, "cplc"));
        pushLostMessage.setStatus(JsonUtil.getStringValue(jSONObject, "status"));
        pushLostMessage.setDpanid(JsonUtil.getStringValue(jSONObject, ReportCardInfo.COLUMN_NAME_DPANID));
        return pushLostMessage;
    }

    private PushConsumeMessage parsePushConsumeMsg(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            LogX.d("parsPushConsumeMsg, get json exception.");
            jSONObject = null;
        }
        if (jSONObject == null) {
            LogX.d("parsPushConsumeMsg, jsonobject is null");
            return null;
        }
        PushConsumeMessage pushConsumeMessage = new PushConsumeMessage();
        pushConsumeMessage.setCplc(JsonUtil.getStringValue(jSONObject, "cplc"));
        pushConsumeMessage.setConsumeTime(JsonUtil.getStringValue(jSONObject, HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
        pushConsumeMessage.setConsumeAccount(JsonUtil.getStringValue(jSONObject, "amount"));
        pushConsumeMessage.setCurrency(JsonUtil.getStringValue(jSONObject, HwPayConstant.KEY_CURRENCY));
        pushConsumeMessage.setMerchantName(JsonUtil.getStringValue(jSONObject, "merchantName"));
        pushConsumeMessage.setProductName(JsonUtil.getStringValue(jSONObject, "productName"));
        return pushConsumeMessage;
    }

    private Object parsePushCUPOperateMsg(String str) {
        JSONObject jSONObject;
        Object obj = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            LogX.d("parsPushConsumeMsg, get json exception.");
            jSONObject = null;
        }
        if (jSONObject == null) {
            LogX.d("parsPushConsumeMsg, jsonobject is null");
        } else {
            obj = new PushCUPOperateMessage();
            obj.setCplc(JsonUtil.getStringValue(jSONObject, "cplc"));
            obj.setVirtualCards(JsonUtil.getStringArrayValue(jSONObject, "virtualCards"));
            jSONObject = JsonUtil.getJsonObject(jSONObject, "tsmLibData");
            if (jSONObject != null) {
                obj.setSsid(JsonUtil.getStringValue(jSONObject, Constant.KEY_DOWNLOAD_INFO_SSID));
                obj.setSign(JsonUtil.getStringValue(jSONObject, "sign"));
                obj.setEvent(JsonUtil.getStringValue(jSONObject, "event"));
            }
        }
        return obj;
    }

    private Object parseCUPPMsg(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            LogX.e("parseCUPPMsg, get json exception.");
            jSONObject = null;
        }
        if (jSONObject == null) {
            LogX.d("parseCUPPMsg, jsonobject is null");
            return null;
        }
        Object pushCUPPersonalizedMessage = new PushCUPPersonalizedMessage();
        pushCUPPersonalizedMessage.setCplc(JsonUtil.getStringValue(jSONObject, "cplc"));
        pushCUPPersonalizedMessage.setAid(JsonUtil.getStringValue(jSONObject, "aid"));
        pushCUPPersonalizedMessage.setVirtualCardRefID(JsonUtil.getStringValue(jSONObject, "cardRefId"));
        return pushCUPPersonalizedMessage;
    }
}
