package com.huawei.nfc.carrera.logic.ese.model;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.util.JSONHelperNotEncrypted;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

public class GetFullCardNoInfo {
    private static final String TAG = "GetFullCardNoInfo";
    private String card_no;

    public String getCard_no() {
        return (String) C0978h.a(this.card_no);
    }

    public void setCard_no(String str) {
        this.card_no = (String) C0978h.a(str);
    }

    public static GetFullCardNoInfo build(String str) throws JSONException {
        GetFullCardNoInfo getFullCardNoInfo = new GetFullCardNoInfo();
        try {
            getFullCardNoInfo.card_no = JSONHelperNotEncrypted.getStringValue(new JSONObject(str), SNBConstant.FIELD_CARD_NO);
        } catch (JSONException e) {
            C2538c.e(TAG, new Object[]{"GetFullCardNoInfo build JSONException e : " + e.getMessage()});
        }
        return getFullCardNoInfo;
    }
}
