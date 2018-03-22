package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONObject;

public class CardCityInfo {
    public static final String CITY_ID_LNT_ALL = "00";
    public static final String CITY_ID_LNT_GZ = "01";
    private String cardID;
    private String cityID;
    private String cityName;
    private String instanceID;

    public String getCardID() {
        return this.cardID;
    }

    public void setCardID(String str) {
        this.cardID = str;
    }

    public String getCityID() {
        return this.cityID;
    }

    public void setCityID(String str) {
        this.cityID = str;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String getInstanceID() {
        return this.instanceID;
    }

    public void setInstanceID(String str) {
        this.instanceID = str;
    }

    public String toString() {
        return "CityAndCardListResponse [cardID=" + this.cardID + ", cityID=" + this.cityID + ", cityName=" + this.cityName + ", instanceID=" + this.instanceID + "]";
    }

    public static CardCityInfo build(JSONObject jSONObject) {
        CardCityInfo cardCityInfo = new CardCityInfo();
        if (jSONObject != null) {
            try {
                cardCityInfo.cardID = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CARD_ID);
                cardCityInfo.cityID = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CITY_ID);
                cardCityInfo.cityName = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CITY_NAME);
                cardCityInfo.instanceID = JSONHelper.getStringValue(jSONObject, "instance_id");
            } catch (Throwable e) {
                LogX.e("CardCityInfo, JSONException", e);
            }
        }
        return cardCityInfo;
    }
}
