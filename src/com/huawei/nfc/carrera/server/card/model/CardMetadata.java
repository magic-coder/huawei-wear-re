package com.huawei.nfc.carrera.server.card.model;

import org.json.JSONException;
import org.json.JSONObject;

public class CardMetadata {
    private static final String KEY_CARD_PRO_ID = "cardProductId";
    private static final String KEY_CARD_REF_ID = "cardReferenceId";
    private static final String KEY_LAST_DIGITS = "lastDigits";
    private String cardProductId;
    private String cardReferenceId;
    private String lastDigits;

    public CardMetadata(JSONObject jSONObject) throws JSONException {
        this.cardReferenceId = jSONObject.getString(KEY_CARD_REF_ID);
        this.cardProductId = jSONObject.getString(KEY_CARD_PRO_ID);
        this.lastDigits = jSONObject.getString(KEY_LAST_DIGITS);
    }

    public String toString() {
        return "CardMetadata [cardReferenceId=" + this.cardReferenceId + ", cardProductId=" + this.cardProductId + ", lastDigits=" + this.lastDigits + "]";
    }

    public String getCardReferenceId() {
        return this.cardReferenceId;
    }

    public String getCardProductId() {
        return this.cardProductId;
    }

    public String getLastDigits() {
        return this.lastDigits;
    }

    public void setCardProductId(String str) {
        this.cardProductId = str;
    }

    public void setCardReferenceId(String str) {
        this.cardReferenceId = str;
    }

    public void setLastDigits(String str) {
        this.lastDigits = str;
    }
}
