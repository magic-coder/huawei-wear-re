package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.request.QueryRFConfURLResquest;
import com.huawei.nfc.carrera.server.card.response.QueryRFConfURLResponse;
import com.huawei.nfc.carrera.server.card.response.RFConfServerInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import org.json.JSONObject;

public class QueryRFConfURLTask extends HttpConnTask<QueryRFConfURLResponse, QueryRFConfURLResquest> {
    private static final String HUAWEI_WEAR = "HUAWEI-WEAR";
    private static final String QUERY_SUPPORT_COMMANDER = "query.rule.rf";
    private static final String TAG = "QueryRFConfURLTask";

    public QueryRFConfURLTask(Context context, String str, int i, int i2) {
        super(context, str, i, i2);
    }

    public QueryRFConfURLTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryRFConfURLResquest queryRFConfURLResquest) {
        return JSONHelper.createRequestStr(queryRFConfURLResquest.getMerchantID(), queryRFConfURLResquest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryRFConfURLResquest.getSrcTransactionID(), QUERY_SUPPORT_COMMANDER, true), queryRFConfURLResquest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryRFConfURLResquest queryRFConfURLResquest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", jSONObject);
            jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_AFTER_TERMINAL_ID, queryRFConfURLResquest.getModel());
            jSONObject2.put("issuerid", queryRFConfURLResquest.getIssuerId());
            jSONObject2.put("romVersion", queryRFConfURLResquest.getRomVersion());
            jSONObject2.put("timestamp", queryRFConfURLResquest.getTimeStamp());
        } catch (Throwable e) {
            LogX.e("QueryRFConfURLTask createDataStr parse json error", e);
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QueryRFConfURLResponse readErrorResponse(int i) {
        QueryRFConfURLResponse queryRFConfURLResponse = new QueryRFConfURLResponse();
        queryRFConfURLResponse.returnCode = i;
        if (-1 == i) {
            queryRFConfURLResponse.returnCode = -1;
        } else if (-3 == i) {
            queryRFConfURLResponse.returnCode = 1;
        } else if (-2 == i) {
            queryRFConfURLResponse.returnCode = -2;
        } else if (-4 == i) {
            queryRFConfURLResponse.returnCode = -4;
        }
        return queryRFConfURLResponse;
    }

    protected QueryRFConfURLResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        QueryRFConfURLResponse queryRFConfURLResponse = new QueryRFConfURLResponse();
        queryRFConfURLResponse.returnCode = i;
        if (i == 0 && jSONObject != null) {
            try {
                String stringValue = JSONHelper.getStringValue(jSONObject, "rf");
                if (!StringUtil.isEmpty(stringValue, true)) {
                    String deviceModel = ESEInfoManager.getInstance(this.mContext).getDeviceModel();
                    String wearRomVersion = getWearRomVersion();
                    RFConfServerInfo rFConfServerInfo = new RFConfServerInfo();
                    rFConfServerInfo.setModel(deviceModel);
                    rFConfServerInfo.setRomVersion(wearRomVersion);
                    rFConfServerInfo.setRfURL(stringValue);
                    rFConfServerInfo.setIssuerId(JSONHelper.getStringValue(jSONObject, "issuerid"));
                    rFConfServerInfo.setTimeStamp(JSONHelper.getLongValue(jSONObject, "timestamp"));
                    queryRFConfURLResponse.rfConfInfos = rFConfServerInfo;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e));
                queryRFConfURLResponse.returnCode = -99;
            }
        }
        return queryRFConfURLResponse;
    }

    private String getWearRomVersion() {
        C2538c.b(TAG, new Object[]{"enter getWearRomVersion"});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(HUAWEI_WEAR).append(HwAccountConstants.SPLIIT_UNDERLINE).append(getWearModle()).append(HwAccountConstants.SPLIIT_UNDERLINE).append(getWearBTVersion());
        return stringBuffer.toString();
    }

    private String getWearModle() {
        C2538c.b(TAG, new Object[]{"enter getWearModle"});
        if (this.mContext == null) {
            return "";
        }
        String deviceModel = ESEInfoManager.getInstance(this.mContext).getDeviceModel();
        if (!StringUtil.isEmpty(deviceModel, true)) {
            return deviceModel;
        }
        C2538c.b(TAG, new Object[]{"getWearModle watchModle is null"});
        return "";
    }

    private String getWearBTVersion() {
        C2538c.b(TAG, new Object[]{"enter getWearBTVersion"});
        if (this.mContext == null) {
            return "";
        }
        String versionStr = getVersionStr(ESEInfoManager.getInstance(this.mContext).getDeviceBTVersion());
        if (!StringUtil.isEmpty(versionStr, true)) {
            return versionStr;
        }
        C2538c.b(TAG, new Object[]{"getWearBTVersion btVersion is null"});
        return "";
    }

    private String getVersionStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = "";
        if (str == null) {
            return str2;
        }
        String[] split = str.split("\\.");
        if (split.length > 2) {
            return stringBuffer.append(split[0]).append(".").append(split[1]).append(".").append(split[2]).toString();
        }
        return str;
    }
}
