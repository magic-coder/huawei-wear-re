package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardInfoDBManager {
    private IssuerInfoOperator issuerInfoOperator = new IssuerInfoOperator(this.mContext.getContentResolver());
    private Context mContext;
    private OrderInfoOperator orderInfoOperator = new OrderInfoOperator(this.mContext.getContentResolver());
    private ProductInfoOperator productInfoOperator = new ProductInfoOperator(this.mContext.getContentResolver());
    private RFConfInfoOperator rfConfInfoOperator = new RFConfInfoOperator(this.mContext.getContentResolver());

    public CardInfoDBManager(Context context) {
        this.mContext = context;
    }

    public void insertOrUpdateCardOrderInfos(List<CardOrderInfoItem> list) {
        this.orderInfoOperator.insertOrUpdateCardOrderInfos(list);
    }

    public void deleteAllCardOrderInfos() {
        this.orderInfoOperator.deleteAllCardOrderInfos();
    }

    public void deleteCardOrderItem(String str) {
        this.orderInfoOperator.deleteCardOrderItem(str);
    }

    public void insertOrUpdateCardProductInfos(List<CardProductInfoItem> list) {
        this.productInfoOperator.insertOrUpdateCardProductInfos(list);
    }

    public ArrayList<CardOrderInfoItem> queryCardOrderInfo() {
        return this.orderInfoOperator.queryCardOrderInfo();
    }

    public CardOrderInfoItem queryCardOrderInfoById(String str) {
        return this.orderInfoOperator.queryCardOrderInfoById(str);
    }

    public void updateDefalutCardOrderInfo(String str) {
        this.orderInfoOperator.updateDefalutCardOrderInfo(str);
    }

    public void insertOrUpdateIssuerInfos(List<IssuerInfoItem> list) {
        this.issuerInfoOperator.insertOrUpdateIssuerInfos(list);
    }

    public List<IssuerInfoItem> queryIssuerInfo() {
        return this.issuerInfoOperator.queryIssuerInfo();
    }

    public IssuerInfoItem queryIssuerInfoById(String str) {
        return this.issuerInfoOperator.queryIssuerInfoById(str);
    }

    public List<CardProductInfoItem> queryCardProductInfo() {
        return this.productInfoOperator.queryCardProductInfo();
    }

    public CardProductInfoItem queryCardProductInfoById(String str) {
        return this.productInfoOperator.queryCardProductInfoById(str);
    }

    public HashMap<String, RFConfInfoItem> queryRFConfInfo() {
        return this.rfConfInfoOperator.queryRFConfInfo();
    }

    public void insertOrUpdateRFConfInfos(List<RFConfInfoItem> list) {
        this.rfConfInfoOperator.insertOrUpdateRFConfInfos(list);
    }
}
