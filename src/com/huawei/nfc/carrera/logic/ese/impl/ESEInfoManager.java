package com.huawei.nfc.carrera.logic.ese.impl;

import android.content.Context;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import com.huawei.nfc.carrera.logic.ese.ESEInfoManagerApi;
import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.ese.response.CardQueryResponse;
import com.huawei.nfc.carrera.logic.ese.response.GetFullCardNoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryTradeRecordsResponse;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.SNBService;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryTradeRecordsOfSeResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ESEInfoManager implements ESEInfoManagerApi {
    private static final String CHIP_MANU_NXP = "01";
    private static final String DEVICE_MODEL_LEO = "LEO";
    private static final String DEVICE_MODEL_NYX = "NYX";
    private static final String TAG = "ESEInfoManager";
    private static ESEInfoManager instance;
    private static final Object lock = new Object();
    private static PluginPayAdapter pluginPayAdapter;
    Map<String, GetFullCardNoResponse> getFullCardNoResponseCache = new HashMap();
    Map<String, Long> getFullCardNoTimeCache = new HashMap();
    private Context mContext;
    Map<String, CardQueryResponse> responseCache = new HashMap();
    private ArrayList<String> supportList;
    Map<String, Long> timeCache = new HashMap();

    public static ESEInfoManager getInstance(Context context) {
        ESEInfoManager eSEInfoManager;
        synchronized (lock) {
            if (instance == null) {
                instance = new ESEInfoManager(context);
            }
            pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(context).getAdapter();
            eSEInfoManager = instance;
        }
        return eSEInfoManager;
    }

    private ESEInfoManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public String queryCplc() {
        return getCplcFromESE();
    }

    private String getCplcFromESE() {
        String str;
        synchronized (lock) {
            LogX.i("cache cplc is null, getCplcFromESE");
            if (pluginPayAdapter == null) {
                str = "";
            } else {
                str = pluginPayAdapter.getCplc();
            }
        }
        return str;
    }

    public String queryCardNum(String str) {
        LogX.i("queryCardNum begin.");
        return "";
    }

    public boolean esePowerOn() {
        LogX.i("esePowerOn begin.");
        return false;
    }

    public boolean esePowerOff() {
        LogX.i("esePowerOff begin.");
        return false;
    }

    public byte[] querySeid() {
        byte[] bArr = new byte[0];
        String queryCplc = queryCplc();
        if (StringUtil.isEmpty(queryCplc, true)) {
            LogX.e("querySeid, illegal cplc");
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(queryCplc.substring(0, 4));
        stringBuilder.append(queryCplc.substring(20, 36));
        return HexByteHelper.hexStringToByteArray(stringBuilder.toString());
    }

    public int queryOpenMobileChannel() {
        LogX.i("queryOpenMobileChannel begin.");
        return -1;
    }

    public QueryTradeRecordsResponse queryTrafficCardTradeRecord(String str) {
        LogX.i("queryTrafficCardTradeRecord begin.");
        return new QueryTradeRecordsResponse();
    }

    public String getDeviceSN() {
        if (pluginPayAdapter == null) {
            return "";
        }
        String str = (String) pluginPayAdapter.getDeviceInfo().get(PluginPayAdapter.KEY_DEVICE_INFO_SN);
        if (StringUtil.isEmpty(str, true)) {
            return "";
        }
        return (String) C0978h.a(str);
    }

    public String getDeviceSoftVersion() {
        if (pluginPayAdapter == null) {
            return "";
        }
        String str = (String) pluginPayAdapter.getDeviceInfo().get(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION);
        if (StringUtil.isEmpty(str, true)) {
            return "";
        }
        return (String) C0978h.a(str);
    }

    public String getDeviceModel() {
        if (pluginPayAdapter == null) {
            return "";
        }
        String str = (String) pluginPayAdapter.getDeviceInfo().get(PluginPayAdapter.KEY_DEVICE_INFO_MODEL);
        if (StringUtil.isEmpty(str, true)) {
            return "";
        }
        return (String) C0978h.a(str);
    }

    public boolean addBusCard(String str, String str2, String str3) {
        if (pluginPayAdapter == null) {
            return false;
        }
        return pluginPayAdapter.addBusCard(str, str2, str3);
    }

    public QueryCardInfoResponse queryTrafficCardInfo(String str, int i) {
        C2538c.c(TAG, new Object[]{"queryTrafficCardInfo begin. instanceID : " + str});
        QueryCardInfoResponse queryCardInfoResponse = new QueryCardInfoResponse();
        queryCardInfoResponse.cardInfo = new TrafficCardInfo();
        if (StringUtil.isEmpty(str, true)) {
            queryCardInfoResponse.resultCode = 100001;
            return queryCardInfoResponse;
        }
        SNBService createSNBService = SPIServiceFactory.createSNBService(this.mContext);
        synchronized (lock) {
            String card_no;
            CardQueryResponse cardQueryResponse = (CardQueryResponse) this.responseCache.get(str);
            GetFullCardNoResponse getFullCardNoResponse = (GetFullCardNoResponse) this.getFullCardNoResponseCache.get(str);
            Long l = (Long) this.timeCache.get(str);
            Long l2 = (Long) this.getFullCardNoTimeCache.get(str);
            if (Constant.BJ_CARD_AID.equals(str)) {
                if (getFullCardNoResponse == null || l2 == null || Math.abs(System.currentTimeMillis() - l2.longValue()) > 5000) {
                    C2538c.c(TAG, new Object[]{"queryGetFullCardNoInfo from SE ,instanceID" + str + ",getFullCardNoCacheTime=" + l2});
                    GetFullCardNoResponse fullCardNo = createSNBService.getFullCardNo(str);
                    if (fullCardNo.cardInfo != null) {
                        card_no = fullCardNo.cardInfo.getCard_no();
                        C2538c.c(TAG, new Object[]{"queryGetFullCardNoInfo from SE ,card_no" + card_no});
                    } else {
                        card_no = null;
                    }
                    this.getFullCardNoResponseCache.put(str, fullCardNo);
                    this.getFullCardNoTimeCache.put(str, Long.valueOf(System.currentTimeMillis()));
                    if (cardQueryResponse != null || l == null || Math.abs(System.currentTimeMillis() - l.longValue()) > 5000) {
                        C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,instanceID" + str + ",cacheTime=" + l});
                        cardQueryResponse = createSNBService.cardQuery(str);
                        queryCardInfoResponse.resultCode = cardQueryResponse.getReturnCd();
                        if (!StringUtil.isEmpty(card_no, true)) {
                            cardQueryResponse.cardInfo.setCardNo(card_no);
                        }
                        queryCardInfoResponse.cardInfo = cardQueryResponse.cardInfo;
                        if (queryCardInfoResponse.cardInfo != null) {
                            C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,card_no" + cardQueryResponse.cardInfo.getCardNo()});
                        }
                        this.responseCache.put(str, cardQueryResponse);
                        this.timeCache.put(str, Long.valueOf(System.currentTimeMillis()));
                    } else {
                        C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from cache ,instanceID" + str + ",cacheTime=" + l});
                        queryCardInfoResponse.resultCode = cardQueryResponse.getReturnCd();
                        queryCardInfoResponse.cardInfo = cardQueryResponse.cardInfo;
                    }
                } else {
                    C2538c.c(TAG, new Object[]{"queryGetFullCardNoInfo from SE ,instanceID" + str + ",getFullCardNoCacheTime=" + l2});
                    if (getFullCardNoResponse.cardInfo != null) {
                        card_no = getFullCardNoResponse.cardInfo.getCard_no();
                        C2538c.c(TAG, new Object[]{"queryGetFullCardNoInfo from SE ,cache , card_no" + card_no});
                        if (cardQueryResponse != null) {
                        }
                        C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,instanceID" + str + ",cacheTime=" + l});
                        cardQueryResponse = createSNBService.cardQuery(str);
                        queryCardInfoResponse.resultCode = cardQueryResponse.getReturnCd();
                        if (StringUtil.isEmpty(card_no, true)) {
                            cardQueryResponse.cardInfo.setCardNo(card_no);
                        }
                        queryCardInfoResponse.cardInfo = cardQueryResponse.cardInfo;
                        if (queryCardInfoResponse.cardInfo != null) {
                            C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,card_no" + cardQueryResponse.cardInfo.getCardNo()});
                        }
                        this.responseCache.put(str, cardQueryResponse);
                        this.timeCache.put(str, Long.valueOf(System.currentTimeMillis()));
                    }
                }
            }
            card_no = null;
            if (cardQueryResponse != null) {
            }
            C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,instanceID" + str + ",cacheTime=" + l});
            cardQueryResponse = createSNBService.cardQuery(str);
            queryCardInfoResponse.resultCode = cardQueryResponse.getReturnCd();
            if (StringUtil.isEmpty(card_no, true)) {
                cardQueryResponse.cardInfo.setCardNo(card_no);
            }
            queryCardInfoResponse.cardInfo = cardQueryResponse.cardInfo;
            if (queryCardInfoResponse.cardInfo != null) {
                C2538c.c(TAG, new Object[]{"queryTrafficCardInfo from SE ,card_no" + cardQueryResponse.cardInfo.getCardNo()});
            }
            this.responseCache.put(str, cardQueryResponse);
            this.timeCache.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return queryCardInfoResponse;
    }

    public QueryTradeRecordsOfSeResponse transQuerySe(String str) {
        QueryTradeRecordsOfSeResponse transQuerySe;
        C2538c.b(TAG, new Object[]{"enter transQuerySe"});
        SNBService createSNBService = SPIServiceFactory.createSNBService(this.mContext);
        synchronized (lock) {
            transQuerySe = createSNBService.transQuerySe(str);
        }
        return transQuerySe;
    }

    public String getDeviceBTVersion() {
        if (pluginPayAdapter == null) {
            return "";
        }
        String str = (String) pluginPayAdapter.getDeviceInfo().get(PluginPayAdapter.KEY_DEVICE_INFO_BT_VERSION);
        if (StringUtil.isEmpty(str, true)) {
            return "";
        }
        return (String) C0978h.a(str);
    }

    public WalletSupportInfo getWalletAbility() {
        Object obj = null;
        String str = "";
        if (pluginPayAdapter != null) {
            obj = new WalletSupportInfo(pluginPayAdapter.getWalletAbility());
        }
        return (WalletSupportInfo) C0978h.a(obj);
    }

    public ArrayList<String> getSupportList() {
        return (ArrayList) C0978h.a(this.supportList);
    }

    public void setSupportList(ArrayList<String> arrayList) {
        if (arrayList == null) {
            C2538c.c(TAG, new Object[]{"setSupportList mSupportList is null"});
            this.supportList = null;
            return;
        }
        C2538c.c(TAG, new Object[]{"setSupportList mSupportList is :" + this.supportList});
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        this.supportList = (ArrayList) C0978h.a(arrayList2);
    }

    public String getBusChipManu() {
        Object obj = "";
        String deviceModel = getDeviceModel();
        if (deviceModel == null) {
            return "";
        }
        if (deviceModel.startsWith(DEVICE_MODEL_LEO) || deviceModel.startsWith(DEVICE_MODEL_NYX)) {
            obj = "01";
        }
        return (String) C0978h.a(obj);
    }
}
