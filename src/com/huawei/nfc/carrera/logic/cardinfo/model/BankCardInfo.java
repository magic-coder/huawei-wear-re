package com.huawei.nfc.carrera.logic.cardinfo.model;

import android.graphics.Bitmap;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;

public class BankCardInfo {
    public Bitmap cardIcon;
    private String cardName;
    private boolean cardType;
    private String dpanFour;
    private String fpanFour;
    private int mode;
    private String productId;

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public String getFpanFour() {
        return this.fpanFour;
    }

    public void setFpanFour(String str) {
        this.fpanFour = str;
    }

    public String getDpanFour() {
        return this.dpanFour;
    }

    public void setDpanFour(String str) {
        this.dpanFour = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public boolean isCardType() {
        return this.cardType;
    }

    public void setCardType(boolean z) {
        this.cardType = z;
    }

    public BankCardInfo(TACardInfo tACardInfo, IssuerInfoItem issuerInfoItem, CardProductInfoItem cardProductInfoItem) {
        this.fpanFour = tACardInfo.getFpanFour();
        this.dpanFour = tACardInfo.getDpanFour();
        this.productId = tACardInfo.getProductId();
        this.cardType = tACardInfo.getCardType() == 2;
        if (cardProductInfoItem != null) {
            this.cardName = cardProductInfoItem.getProductName();
        } else {
            this.cardName = issuerInfoItem.getName();
        }
        this.mode = issuerInfoItem.getMode();
    }

    public void bankCardInfoSai1() {
    }

    public void bankCardInfoSai2() {
    }

    public void bankCardInfoSai3() {
    }

    public void bankCardInfoSai4() {
    }

    public void bankCardInfoSai5() {
    }

    public void bankCardInfoSai6() {
    }

    public void bankCardInfoSai7() {
    }
}
