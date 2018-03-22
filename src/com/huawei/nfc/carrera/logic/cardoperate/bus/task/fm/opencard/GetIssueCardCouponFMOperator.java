package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard;

import android.content.Context;
import cn.com.fmsh.tsm.business.bean.Product;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util.NfcCityCode;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryProductsRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryProductsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;

public class GetIssueCardCouponFMOperator {
    private static final String TAG = "GetIssueCardCouponFMOperator";
    private String mCityCode;
    private Context mContext;
    private IssuerInfoItem mInfo;

    public GetIssueCardCouponFMOperator(Context context, String str, IssuerInfoItem issuerInfoItem) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mCityCode = str;
    }

    public TrafficActivityInfo getIssueCardCoupon() {
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        String aid = this.mInfo.getAid();
        String fMCityCode;
        if (CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(this.mInfo.getProductId()) == null) {
            C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator getIssueCardCoupon failed. card info does not exists. productId = " + fMCityCode});
            trafficActivityInfo.setReturnCd(99);
            return trafficActivityInfo;
        }
        C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator befor"});
        fMCityCode = NfcCityCode.getFMCityCode(this.mCityCode);
        C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator end cityCode ：" + fMCityCode});
        if (fMCityCode == null || fMCityCode.equals("")) {
            C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator getCityCode is null !"});
            fMCityCode = "01";
        }
        String deviceModel = ESEInfoManager.getInstance(this.mContext).getDeviceModel();
        QueryProductsRequest queryProductsRequest = new QueryProductsRequest();
        queryProductsRequest.setAid(aid);
        queryProductsRequest.setDeviceModel(deviceModel);
        queryProductsRequest.setCity4Current(fMCityCode);
        LogX.i("getIssueCardCoupon myAid : " + this.mInfo.getAid());
        QueryProductsResponse queryProducts = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryProducts(queryProductsRequest);
        C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator response.resultCode : " + queryProducts.resultCode});
        if (queryProducts.resultCode != 0) {
            trafficActivityInfo.setReturnCd(99);
            return trafficActivityInfo;
        } else if (queryProducts.getList() == null || queryProducts.getList().size() < 1) {
            C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator Product List is null "});
            trafficActivityInfo.setReturnCd(99);
            return trafficActivityInfo;
        } else {
            Product product = (Product) queryProducts.getList().get(0);
            int price = product.getPrice();
            deviceModel = product.getName();
            fMCityCode = product.getCode();
            C2538c.c(TAG, new Object[]{"GetIssueCardCouponFMOperator price : " + price + " ; name : " + deviceModel + " ; productCode : " + fMCityCode});
            trafficActivityInfo.setIssueActCode(String.valueOf(0));
            trafficActivityInfo.setIssueActAmount(String.valueOf(price));
            trafficActivityInfo.setIssueStdAmount(String.valueOf(price));
            trafficActivityInfo.setReturnCd(0);
            trafficActivityInfo.setProductCode(fMCityCode);
            return trafficActivityInfo;
        }
    }
}
