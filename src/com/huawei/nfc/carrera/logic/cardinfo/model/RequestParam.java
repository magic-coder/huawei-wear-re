package com.huawei.nfc.carrera.logic.cardinfo.model;

import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import java.util.HashMap;
import java.util.Map;

public class RequestParam {
    private String issuerId;
    private int mode;
    private String productId;
    private int type;

    public RequestParam(String str, int i, int i2, String str2) {
        this.productId = str;
        this.mode = i;
        this.type = i2;
        this.issuerId = str2;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.issuerId == null ? 0 : this.issuerId.hashCode()) + 31) * 31) + this.mode) * 31;
        if (this.productId != null) {
            i = this.productId.hashCode();
        }
        return ((hashCode + i) * 31) + this.type;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestParam)) {
            return false;
        }
        RequestParam requestParam = (RequestParam) obj;
        if (this.productId.equals(requestParam.productId) && this.issuerId.equals(requestParam.issuerId) && this.type == requestParam.type && this.mode == requestParam.mode) {
            return true;
        }
        return false;
    }

    public Map<String, String> convert2Map() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("productid", this.productId);
        hashMap.put(IssuerInfoColumns.COLUMN_NAME_MODE, "" + this.mode);
        hashMap.put("type", "" + this.type);
        hashMap.put("issuerid", this.issuerId);
        return hashMap;
    }
}
