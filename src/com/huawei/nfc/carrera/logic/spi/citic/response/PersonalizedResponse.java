package com.huawei.nfc.carrera.logic.spi.citic.response;

public class PersonalizedResponse extends BaseResponse {
    public String dpanid;
    public String productId;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("dpanid: ").append(this.dpanid);
        return stringBuilder.toString();
    }
}
