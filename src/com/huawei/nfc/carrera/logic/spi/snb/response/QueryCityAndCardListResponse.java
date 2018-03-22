package com.huawei.nfc.carrera.logic.spi.snb.response;

import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryCityAndCardListResponse extends SNBBaseResponse {
    public CardCityInfo recommendedCity;
    public List<CardCityInfo> useCitys = new ArrayList();

    public static QueryCityAndCardListResponse build(String str, int i) throws JSONException {
        QueryCityAndCardListResponse queryCityAndCardListResponse = new QueryCityAndCardListResponse();
        if (TextUtils.isEmpty(str)) {
            LogX.i("SNBServiceImpl queryCityAndCardList but dataJson is null in response");
            queryCityAndCardListResponse.returnCd = 100002;
            return queryCityAndCardListResponse;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jsonObject = JsonUtil.getJsonObject(jSONObject, SNBConstant.FIELD_RECOMMENDED_CITY);
        if (jsonObject != null) {
            queryCityAndCardListResponse.recommendedCity = CardCityInfo.build(jsonObject);
        } else {
            LogX.i("SNBServiceImpl queryCityAndCardList but recommendedCity is null");
        }
        JSONArray jSONArray = new JSONArray(JsonUtil.getStringValue(jSONObject, SNBConstant.FIELD_USE_CITY));
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            queryCityAndCardListResponse.useCitys.add(CardCityInfo.build(jSONArray.getJSONObject(i2)));
        }
        queryCityAndCardListResponse.returnCd = i;
        return queryCityAndCardListResponse;
    }
}
