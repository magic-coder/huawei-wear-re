package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryOnlineRechargeRecordsResponse extends SNBBaseResponse {
    public List<RecordServerInfo> orderRecords = new ArrayList();

    public static QueryOnlineRechargeRecordsResponse build(String str) throws JSONException {
        QueryOnlineRechargeRecordsResponse queryOnlineRechargeRecordsResponse = new QueryOnlineRechargeRecordsResponse();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(SNBConstant.FIELD_ORDERS);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (StringUtil.isEmpty(JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ORDER_TIME), true)) {
                    LogX.w("SNBServiceImpl queryOnlineRechargeRecords skip a record. date is null.");
                } else {
                    queryOnlineRechargeRecordsResponse.orderRecords.add(RecordServerInfo.build(jSONObject));
                }
            }
            return queryOnlineRechargeRecordsResponse;
        } catch (JSONException e) {
            throw e;
        }
    }
}
