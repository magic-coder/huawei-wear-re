package com.huawei.nfc.carrera.logic.spi.snb.impl;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.response.CardQueryResponse;
import com.huawei.nfc.carrera.logic.ese.response.GetFullCardNoResponse;
import com.huawei.nfc.carrera.logic.spi.snb.SNBService;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.CardQuery;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.CardSwitch;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.DeleteCard;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.GetFullCardNo;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.GetPayOrder;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.IssueCard;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.LoadAndInstallApplet;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.QueryCityAndCardList;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.QueryIssueCardCoupon;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.QueryOnlineRechargeRecords;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.QueryRechargeCoupon;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.QueryUnfinishedOrders;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.Recharge;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.Refund;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.SNBProviderHelper;
import com.huawei.nfc.carrera.logic.spi.snb.impl.operate.TransQuerySe;
import com.huawei.nfc.carrera.logic.spi.snb.response.IssueCardActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.PayOrderResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryCityAndCardListResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryOnlineRechargeRecordsResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryTradeRecordsOfSeResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeResponse;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.common.IWalletServiceProvider;
import com.snowballtech.business.common.SnowballService;
import com.snowballtech.smartdevice.Device;
import java.util.Map;

public final class SNBServiceImpl implements SNBService {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "SNBServiceImpl";
    private static final String VENDOR = "HUAWEI";
    private static SNBService sSNBService;
    private Context mContext;
    private SNBProviderHelper mSnbProviderHelper;

    private SNBServiceImpl(Context context) {
        C2538c.c(TAG, new Object[]{"SNBServiceImpl begin"});
        this.mContext = context;
        setDevice();
        C2538c.c(TAG, new Object[]{"SNBServiceImpl end"});
    }

    private void setDevice() {
        C2538c.c(TAG, new Object[]{"setDevice begin"});
        IWalletServiceProvider walletServiceProvider = SnowballService.getInstance(this.mContext).getWalletServiceProvider();
        C2538c.c(TAG, new Object[]{"setDevice WALLET_RELEASE : " + true});
        walletServiceProvider.switchLog("shutdown");
        Device device = new Device();
        String deviceModel = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel();
        String deviceSN = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceSN();
        C2538c.c(TAG, new Object[]{"setDevice deviceModel : " + deviceModel});
        C2538c.c(TAG, new Object[]{"setDevice deviceUUID : " + deviceSN});
        device.setDevice_model(deviceModel);
        device.setDevice_uid(deviceSN);
        device.setDevice_vendor(VENDOR);
        String toJson = new Gson().toJson(device);
        C2538c.c(TAG, new Object[]{"setDevice device json : " + toJson});
        walletServiceProvider.setDevice(toJson);
        this.mSnbProviderHelper = new SNBProviderHelper(walletServiceProvider, this.mContext);
        C2538c.c(TAG, new Object[]{"setDevice end"});
    }

    public static SNBService getSNBServiceInstance(Context context) {
        SNBService sNBService;
        synchronized (SYNC_LOCK) {
            if (sSNBService == null) {
                sSNBService = new SNBServiceImpl(context);
            }
            sNBService = sSNBService;
        }
        return sNBService;
    }

    public PayOrderResponse getPayOrder(String str, String str2, double d, int i, double d2, int i2) {
        return new GetPayOrder(this.mContext, this.mSnbProviderHelper).getPayOrder(str, str2, d, i, d2, i2);
    }

    public int loadAndInstallApplet(String str, Map<String, String> map) {
        setDevice();
        return new LoadAndInstallApplet(this.mSnbProviderHelper).loadAndInstallApplet(str, map);
    }

    public int issueCard(String str, String str2, Map<String, String> map) {
        setDevice();
        return new IssueCard(this.mSnbProviderHelper).issueCard(str, str2, map);
    }

    public RechargeResponse recharge(String str, String str2, Map<String, String> map) {
        setDevice();
        return new Recharge(this.mSnbProviderHelper).recharge(str, str2, map);
    }

    public int deleteCard(String str, Map<String, String> map) {
        setDevice();
        return new DeleteCard(this.mSnbProviderHelper).deleteCard(str, map);
    }

    public int refund(String str, String str2) {
        setDevice();
        return new Refund(this.mSnbProviderHelper).refund(str, str2);
    }

    public QueryOnlineRechargeRecordsResponse queryOnlineRechargeRecords(String str, int i) {
        return new QueryOnlineRechargeRecords(this.mSnbProviderHelper).queryOnlineRechargeRecords(str, i);
    }

    public QueryUnfinishedOrdersResponse queryUnfinishedOrders(String str) {
        C2538c.c(TAG, new Object[]{"queryUnfinishedOrders aid : " + str});
        C2538c.c(TAG, new Object[]{"queryUnfinishedOrders mSnbProviderHelper : " + this.mSnbProviderHelper});
        return new QueryUnfinishedOrders(this.mSnbProviderHelper).queryUnfinishedOrders(str);
    }

    public IssueCardActResponse queryIssueCardCoupon(String str, String str2) {
        C2538c.c(TAG, new Object[]{"queryIssueCardCoupon aid : " + str});
        C2538c.c(TAG, new Object[]{"queryIssueCardCoupon cardId : " + str2});
        return new QueryIssueCardCoupon(this.mSnbProviderHelper).queryIssueCardCoupon(str, str2);
    }

    public RechargeActResponse queryRechargeCoupon(String str, String str2) {
        return new QueryRechargeCoupon(this.mSnbProviderHelper).queryRechargeCoupon(str, str2);
    }

    public CardQueryResponse cardQuery(String str) {
        setDevice();
        return new CardQuery(this.mSnbProviderHelper).cardquery(str, "");
    }

    public GetFullCardNoResponse getFullCardNo(String str) {
        setDevice();
        return new GetFullCardNo(this.mSnbProviderHelper).getFullCardNo(str);
    }

    public int cardSwitch(String str) {
        setDevice();
        return new CardSwitch(this.mSnbProviderHelper).cardSwitch(str);
    }

    public QueryTradeRecordsOfSeResponse transQuerySe(String str) {
        setDevice();
        return new TransQuerySe(this.mSnbProviderHelper).transQuerySe(str);
    }

    public QueryCityAndCardListResponse queryCityAndCardList(String str, String str2) {
        return new QueryCityAndCardList(this.mSnbProviderHelper).queryCityAndCardList(str, str2);
    }
}
