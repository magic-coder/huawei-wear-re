package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUnfinishedOrdersResponse extends SNBBaseResponse {
    public List<RecordServerInfo> unfinishedOrders = new ArrayList();

    public static QueryUnfinishedOrdersResponse build(String str, int i) throws JSONException {
        QueryUnfinishedOrdersResponse queryUnfinishedOrdersResponse = new QueryUnfinishedOrdersResponse();
        JSONArray jSONArray = new JSONObject(str).getJSONArray(SNBConstant.FIELD_ORDERS);
        if (jSONArray == null) {
            LogX.i("SNBServiceImpl queryUnfinishedOrders no orders in response");
            queryUnfinishedOrdersResponse.returnCd = 100002;
            return queryUnfinishedOrdersResponse;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            queryUnfinishedOrdersResponse.unfinishedOrders.add(RecordServerInfo.build(jSONArray.getJSONObject(i2)));
        }
        queryUnfinishedOrdersResponse.returnCd = i;
        return queryUnfinishedOrdersResponse;
    }
}
