package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.android.pushagent.PushReceiver$BOUND_KEY;
import com.huawei.nfc.carrera.server.card.request.QueryUnionPayPushRequest;
import com.huawei.nfc.carrera.server.card.response.QueryUnionPayPushResponse;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUnionPayPushTask extends HttpConnTask<QueryUnionPayPushResponse, QueryUnionPayPushRequest> {
    public static final String QUERY_UNIONPAY_PUSH_COMMANDER = "get.UnionPayPush";
    public static final String TAG = "QueryUnionPayPushTask";

    public QueryUnionPayPushTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryUnionPayPushRequest queryUnionPayPushRequest) {
        C2538c.b(TAG, new Object[]{"prepareRequestStr"});
        if (queryUnionPayPushRequest == null || StringUtil.isEmpty(queryUnionPayPushRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(queryUnionPayPushRequest.getMerchantID(), true)) {
            C2538c.b(TAG, new Object[]{"prepareRequestStr, params invalid."});
            return null;
        }
        return JSONHelper.createRequestStr(queryUnionPayPushRequest.getMerchantID(), queryUnionPayPushRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryUnionPayPushRequest.getSrcTransactionID(), QUERY_UNIONPAY_PUSH_COMMANDER, true), queryUnionPayPushRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryUnionPayPushRequest queryUnionPayPushRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("requestid", String.valueOf(System.currentTimeMillis()));
            if (!StringUtil.isEmpty(queryUnionPayPushRequest.cplc, true)) {
                jSONObject2.put("cplc", queryUnionPayPushRequest.cplc);
            }
        } catch (JSONException e) {
            C2538c.e(TAG, new Object[]{"createDataStr, params invalid."});
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QueryUnionPayPushResponse readErrorResponse(int i) {
        QueryUnionPayPushResponse queryUnionPayPushResponse = new QueryUnionPayPushResponse();
        switch (i) {
            case -4:
                queryUnionPayPushResponse.returnCode = -4;
                break;
            case -3:
                queryUnionPayPushResponse.returnCode = 1;
                break;
            case -2:
                queryUnionPayPushResponse.returnCode = -2;
                break;
            case -1:
                queryUnionPayPushResponse.returnCode = -1;
                break;
            default:
                queryUnionPayPushResponse.returnCode = i;
                break;
        }
        return queryUnionPayPushResponse;
    }

    protected QueryUnionPayPushResponse readSuccessResponse(String str) {
        C2538c.e(TAG, new Object[]{"==123 readSuccessResponse, responseStr : " + str});
        QueryUnionPayPushResponse queryUnionPayPushResponse = new QueryUnionPayPushResponse();
        if (str == null) {
            queryUnionPayPushResponse.returnCode = -99;
        } else {
            C2538c.e(TAG, new Object[]{"responseStr :  " + str});
            try {
                String stringValue = JSONHelper.getStringValue(new JSONObject(str), "response");
                if (StringUtil.isEmpty(stringValue, true)) {
                    C2538c.e(TAG, new Object[]{"handleResponse, responseStrr is invalid."});
                } else {
                    JSONObject jSONObject = new JSONObject(stringValue);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    if (StringUtil.isEmpty(stringValue, true)) {
                        queryUnionPayPushResponse.returnCode = -99;
                    } else if (isNumber(stringValue)) {
                        int parseInt = Integer.parseInt(stringValue);
                        queryUnionPayPushResponse.returnCode = parseInt;
                        if (parseInt == 0) {
                            String stringValue2 = JSONHelper.getStringValue(jSONObject, PushReceiver$BOUND_KEY.pushMsgKey);
                            String stringValue3 = JSONHelper.getStringValue(jSONObject, "pushTime");
                            String stringValue4 = JSONHelper.getStringValue(jSONObject, "systemCurrentTime");
                            queryUnionPayPushResponse.setPushMsg(stringValue2);
                            queryUnionPayPushResponse.setPushTime(stringValue3);
                            queryUnionPayPushResponse.setSystemCurrentTime(stringValue4);
                            C2538c.e(TAG, new Object[]{"pushMsg :  " + stringValue2 + " ; pushTime :  " + stringValue3 + " ; systemCurrentTime : " + stringValue4 + " ; returncodeInt : " + parseInt});
                        }
                    } else {
                        queryUnionPayPushResponse.returnCode = -98;
                    }
                }
            } catch (Throwable e) {
                C2538c.e(TAG, new Object[]{"readSuccessResponse, JSONException : " + Log.getStackTraceString(e)});
                queryUnionPayPushResponse.returnCode = -99;
            }
        }
        return queryUnionPayPushResponse;
    }

    public boolean isNumber(String str) {
        if (!(str == null || "".equals(str.trim()) || !Pattern.compile("[0-9]*").matcher(str).matches())) {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            if (valueOf.longValue() <= 2147483647L && valueOf.longValue() >= -2147483648L) {
                return true;
            }
        }
        return false;
    }
}
