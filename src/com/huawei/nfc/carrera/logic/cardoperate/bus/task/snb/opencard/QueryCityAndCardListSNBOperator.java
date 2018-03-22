package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.logic.spi.snb.response.CardCityInfo;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryCityAndCardListResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LocationUtil;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.List;

public class QueryCityAndCardListSNBOperator {
    private static final Object sLock = new Object();
    String LNT_CITY_CODE_TIME_STAMP = "lnt_cityCode_timeStamp";
    private long LNT_CITY_CODE_VALID_TIME = 600000;
    private final Context mContext;

    public QueryCityAndCardListSNBOperator(Context context) {
        this.mContext = context;
    }

    public String queryCityAndCardList(String str) {
        String queryCityAndCardListFromTA;
        synchronized (sLock) {
            queryCityAndCardListFromTA = queryCityAndCardListFromTA(str);
            if (StringUtil.isEmpty(queryCityAndCardListFromTA, true) || !isNumeric(queryCityAndCardListFromTA)) {
                queryCityAndCardListFromTA = getCityCodeFromSP();
                if (StringUtil.isEmpty(queryCityAndCardListFromTA, true) || !isNumeric(queryCityAndCardListFromTA)) {
                    HashMap locationInfo = LocationUtil.getLocationInfo(this.mContext);
                    QueryCityAndCardListResponse queryCityAndCardList = SPIServiceFactory.createSNBService(this.mContext).queryCityAndCardList((String) locationInfo.get("longitude"), (String) locationInfo.get("latitude"));
                    if (queryCityAndCardList == null || queryCityAndCardList.getReturnCd() != 0) {
                        Object obj;
                        StringBuilder append = new StringBuilder().append("IssueTrafficCardSNBTask SNBService issueCard failed. resultCode = ");
                        if (queryCityAndCardList == null) {
                            obj = "null";
                        } else {
                            obj = Integer.valueOf(queryCityAndCardList.getReturnCd());
                        }
                        LogX.e(append.append(obj).toString());
                        queryCityAndCardListFromTA = null;
                    } else {
                        LogX.i("QueryCityAndCardList , success.");
                        CardCityInfo cardCityInfo = queryCityAndCardList.recommendedCity;
                        if (cardCityInfo != null) {
                            queryCityAndCardListFromTA = cardCityInfo.getCityID();
                        } else {
                            queryCityAndCardListFromTA = findCityCode(queryCityAndCardList.useCitys);
                        }
                    }
                    if (!StringUtil.isEmpty(queryCityAndCardListFromTA, true)) {
                        savaCityCodeToSP(queryCityAndCardListFromTA);
                    }
                    LogX.i("QueryCityAndCardList get LNT city code : " + queryCityAndCardListFromTA);
                }
            }
        }
        return queryCityAndCardListFromTA;
    }

    public boolean isNumeric(String str) {
        LogX.i("QueryCityAndCardList get LNT city code isNumeric : " + str);
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String findCityCode(List<CardCityInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        CardCityInfo cardCityInfo = null;
        CardCityInfo cardCityInfo2 = null;
        CardCityInfo cardCityInfo3 = null;
        for (CardCityInfo cardCityInfo4 : list) {
            CardCityInfo cardCityInfo42;
            if (cardCityInfo42 != null) {
                CardCityInfo cardCityInfo5;
                if ("00".equals(cardCityInfo42.getCityID())) {
                    cardCityInfo5 = cardCityInfo;
                    cardCityInfo = cardCityInfo2;
                    cardCityInfo2 = cardCityInfo42;
                    cardCityInfo42 = cardCityInfo5;
                } else if ("01".equals(cardCityInfo42.getCityID())) {
                    cardCityInfo2 = cardCityInfo3;
                    cardCityInfo5 = cardCityInfo42;
                    cardCityInfo42 = cardCityInfo;
                    cardCityInfo = cardCityInfo5;
                } else {
                    cardCityInfo = cardCityInfo2;
                    cardCityInfo2 = cardCityInfo3;
                }
                cardCityInfo3 = cardCityInfo2;
                cardCityInfo2 = cardCityInfo;
                cardCityInfo = cardCityInfo42;
            }
        }
        if (cardCityInfo3 != null) {
            return cardCityInfo3.getCityID();
        }
        if (cardCityInfo2 != null) {
            return cardCityInfo2.getCityID();
        }
        if (cardCityInfo != null) {
            return cardCityInfo.getCityID();
        }
        return null;
    }

    private void savaCityCodeToSP(String str) {
        NFCPreferences.getInstance(this.mContext).putLong(this.LNT_CITY_CODE_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));
        NFCPreferences.getInstance(this.mContext).putString(SNBConstant.KEY_LNT_CITY_CODE, str);
    }

    private String getCityCodeFromSP() {
        if (isLNTCodeValid(NFCPreferences.getInstance(this.mContext).getLong(this.LNT_CITY_CODE_TIME_STAMP, Long.valueOf(0)).longValue(), System.currentTimeMillis())) {
            return NFCPreferences.getInstance(this.mContext).getString(SNBConstant.KEY_LNT_CITY_CODE, "");
        }
        return null;
    }

    private boolean isLNTCodeValid(long j, long j2) {
        return Math.abs(j2 - j) < this.LNT_CITY_CODE_VALID_TIME;
    }

    private String queryCityAndCardListFromTA(String str) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
        if (card != null) {
            return card.getDpanFour();
        }
        return null;
    }
}
