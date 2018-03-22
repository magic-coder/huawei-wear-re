package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class TsmParamQueryTask extends HttpConnTask<TsmParamQueryResponse, TsmParamQueryRequest> {
    static final String TASK_COMMANDER_CREATE_SSD = "nfc.get.create.SSD";
    static final String TASK_COMMANDER_DEL_APP = "nfc.get.del.APP";
    static final String TASK_COMMANDER_DEL_SSD = "nfc.get.del.SSD";
    static final String TASK_COMMANDER_INFO_INIT = "nfc.get.NotifyInfoInit";
    static final String TASK_COMMANDER_INSTALL_APP = "nfc.get.install.APP";
    static final String TASK_COMMANDER_LOCK_APP = "nfc.get.lock.APP";
    static final String TASK_COMMANDER_SYNC_INFO = "nfc.get.NotifyEseInfoSync";
    static final String TASK_COMMANDER_UNLOCK_APP = "nfc.get.unlock.APP";
    static final String TASK_COMMANDER_UNLOCK_ESE = "nfc.se.unlock";
    static final String TASK_COMMANDER_UPDATE_APP = "nfc.get.transit.temp.update.APP";
    private static final int TSM_CHANNEL_HUAWEI = 0;
    private final String paramType;

    public TsmParamQueryTask(Context context, String str, String str2) {
        super(context, str);
        this.paramType = str2;
    }

    protected String prepareRequestStr(TsmParamQueryRequest tsmParamQueryRequest) {
        if (tsmParamQueryRequest == null || StringUtil.isEmpty(tsmParamQueryRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(tsmParamQueryRequest.getCplc(), true) || StringUtil.isEmpty(tsmParamQueryRequest.getTerminal(), true) || StringUtil.isEmpty(this.paramType, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(tsmParamQueryRequest.getMerchantID(), tsmParamQueryRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(tsmParamQueryRequest.getSrcTransactionID(), this.paramType, true), tsmParamQueryRequest, this.paramType), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, TsmParamQueryRequest tsmParamQueryRequest, String str) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, System.currentTimeMillis());
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getCplc(), true)) {
                jSONObject2.put("cplc", tsmParamQueryRequest.getCplc());
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getAid(), true)) {
                jSONObject2.put("aid", tsmParamQueryRequest.getAid());
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getTerminal(), true)) {
                jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_AFTER_TERMINAL_ID, tsmParamQueryRequest.getTerminal());
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getIssuerId(), true)) {
                jSONObject2.put("issuerid", tsmParamQueryRequest.getIssuerId());
            }
            jSONObject2.put("tsmChannel", 0);
            String signCommand = SignCommand.getSignCommand(str);
            if (signCommand != null) {
                if (!StringUtil.isEmpty(tsmParamQueryRequest.getBankSignResult(), true)) {
                    jSONObject2.put("sign", tsmParamQueryRequest.getBankSignResult());
                }
                if (!StringUtil.isEmpty(tsmParamQueryRequest.getBankSignTime(), true)) {
                    jSONObject2.put("content", signCommand + "|" + tsmParamQueryRequest.getBankSignTime());
                }
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getBankRsaIndex(), true)) {
                jSONObject2.put("rsaindex", tsmParamQueryRequest.getBankRsaIndex());
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getSignType(), true)) {
                jSONObject2.put(SNBConstant.FIELD_RSA_SIGN_TYPE, tsmParamQueryRequest.getSignType());
            }
            if (tsmParamQueryRequest.isDeleteRelatedObjects()) {
                jSONObject2.put("deleteRelatedObjects", tsmParamQueryRequest.isDeleteRelatedObjects());
            }
            if (!StringUtil.isEmpty(tsmParamQueryRequest.getTsmParamIMEI(), true)) {
                jSONObject2.put("imei", tsmParamQueryRequest.getTsmParamIMEI());
            }
            LogX.d("createDataStr, dataJson: " + jSONObject2);
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected TsmParamQueryResponse readErrorResponse(int i) {
        TsmParamQueryResponse tsmParamQueryResponse = new TsmParamQueryResponse();
        if (-1 == i) {
            tsmParamQueryResponse.returnCode = -1;
        } else if (-3 == i) {
            tsmParamQueryResponse.returnCode = 1;
        } else if (-2 == i) {
            tsmParamQueryResponse.returnCode = -2;
        } else if (-4 == i) {
            tsmParamQueryResponse.returnCode = -4;
        }
        return tsmParamQueryResponse;
    }

    protected TsmParamQueryResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        TsmParamQueryResponse tsmParamQueryResponse = new TsmParamQueryResponse();
        if (str == null) {
            tsmParamQueryResponse.returnCode = -99;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
                int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
                String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
                String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
                String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
                if (stringValue3 != null) {
                    LogX.d("readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                    tsmParamQueryResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    stringValue2 = JSONHelper.getStringValue(jSONObject, "funcID");
                    stringValue4 = JSONHelper.getStringValue(jSONObject, "servicID");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        tsmParamQueryResponse.returnCode = -99;
                    } else {
                        tsmParamQueryResponse.returnCode = Integer.parseInt(stringValue);
                        if (tsmParamQueryResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else if (StringUtil.isEmpty(stringValue2, true) || StringUtil.isEmpty(stringValue4, true)) {
                            LogX.d("readSuccessResponse, illegal funcID or servicID");
                            tsmParamQueryResponse.returnCode = -99;
                        } else {
                            tsmParamQueryResponse.funcID = stringValue2;
                            tsmParamQueryResponse.servicID = stringValue4;
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    tsmParamQueryResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                tsmParamQueryResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                tsmParamQueryResponse.returnCode = -99;
            }
        }
        return tsmParamQueryResponse;
    }
}
