package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.common.IWalletServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

public class SNBProviderHelper {
    private static final String TAG = "SNBProviderHelper";
    private Context mContext;
    private String mCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
    private String mImei = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceSN();
    private String mModel = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel();
    private IWalletServiceProvider mSNBServiceProvider;

    public SNBProviderHelper(IWalletServiceProvider iWalletServiceProvider, Context context) {
        C2538c.c(TAG, new Object[]{TAG, "mSNBServiceProvider= " + iWalletServiceProvider + " ; context : " + context});
        this.mSNBServiceProvider = iWalletServiceProvider;
        this.mContext = context;
        iWalletServiceProvider.service("init", null);
    }

    public String getCplc() {
        return this.mCplc;
    }

    String getPayOrder(String str, String str2, double d, int i, double d2, int i2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SNBConstant.FIELD_TXN_AMT, String.valueOf((int) (d * 100.0d)));
            jSONObject.put(SNBConstant.FIELD_CARD_TXN_AMT, String.valueOf((int) (d2 * 100.0d)));
            jSONObject.put("instance_id", str);
            jSONObject.put(SNBConstant.FIELD_PAYMENT_CHANNEL, SNBConstant.PAYMENT_CHANNEL);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            jSONObject.put(SNBConstant.FIELD_PAY_TYPE, i);
            jSONObject.put(SNBConstant.FIELD_CARD_NO, str3);
            jSONObject.put(SNBConstant.FIELD_PKG, this.mContext.getPackageName());
            jSONObject.put("imei", this.mImei);
            jSONObject.put("cplc", this.mCplc);
            jSONObject.put(SNBConstant.FIELD_MOBILE_VENDOR, "HUAWEI");
            jSONObject.put(SNBConstant.FIELD_MOBILE_MODEL, this.mModel);
            jSONObject.put(SNBConstant.FIELD_ACTIVITY_FLG, i2);
            jSONObject.put(SNBConstant.FIELD_CITY_BUS_CODE, str2);
            String jSONObject2 = jSONObject.toString();
            C2538c.c(TAG, new Object[]{" getPayOrder input param = " + jSONObject2, Boolean.valueOf(true)});
            return this.mSNBServiceProvider.getPayOrder(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String appletManage(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", SNBConstant.DEFAULT_OPERATION);
            jSONObject.put("instance_id", str);
            if (str2 != null) {
                jSONObject.put(SNBConstant.FIELD_EXTRA_INFO, str2);
            }
            String jSONObject2 = jSONObject.toString();
            C2538c.c(TAG, new Object[]{"SNBServiceImpl loadAndInstallApplet input param = " + jSONObject2});
            return this.mSNBServiceProvider.appletManage(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String issueCard(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            jSONObject.put("category", SNBConstant.DEFAULT_OPERATION);
            jSONObject.put(SNBConstant.FIELD_TOKEN, str2);
            if (str3 != null) {
                jSONObject.put(SNBConstant.FIELD_EXTRA_INFO, str3);
            }
            String jSONObject2 = jSONObject.toString();
            C2538c.c(TAG, new Object[]{"SNBServiceImpl issueCard param = " + jSONObject2, Boolean.valueOf(true)});
            return this.mSNBServiceProvider.issueCard(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String cardTopup(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            jSONObject.put(SNBConstant.FIELD_TOKEN, str2);
            if (str3 != null) {
                jSONObject.put(SNBConstant.FIELD_EXTRA_INFO, str3);
            }
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl cardTopup param = " + jSONObject2, true);
            return this.mSNBServiceProvider.cardTopup(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String cardDelete(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            if (str2 != null) {
                jSONObject.put(SNBConstant.FIELD_EXTRA_INFO, str2);
            }
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl deleteCard input param = " + jSONObject2);
            return this.mSNBServiceProvider.cardDelete(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String refund(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            jSONObject.put(SNBConstant.FIELD_PAYMENT_CHANNEL, SNBConstant.PAYMENT_CHANNEL);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            jSONObject.put(SNBConstant.FIELD_ORDER_ID, str2);
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl refund input param = " + jSONObject2, true);
            return this.mSNBServiceProvider.refund(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String recordsOnlineQuery(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            jSONObject.put("cplc", this.mCplc);
            jSONObject.put("count", i);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            return this.mSNBServiceProvider.recordsOnlineQuery(jSONObject.toString());
        } catch (JSONException e) {
            return null;
        }
    }

    String orderQuery(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cplc", this.mCplc);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            jSONObject.put("instance_id", str);
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl queryUnfinishedOrders input param = " + jSONObject2, true);
            return this.mSNBServiceProvider.orderQuery(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String cardCoupon(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SNBConstant.FIELD_CARD_ID, str);
            jSONObject.put("instance_id", str2);
            jSONObject.put(SNBConstant.FIELD_MOBILE_MODEL, this.mModel);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl queryIssueCardCoupon input param = " + jSONObject2, true);
            return this.mSNBServiceProvider.cardCoupon(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    String rechargeCoupon(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SNBConstant.FIELD_CARD_ID, str2);
            jSONObject.put("instance_id", str);
            jSONObject.put(SNBConstant.FIELD_MOBILE_MODEL, this.mModel);
            jSONObject.put(SNBConstant.FIELD_SP_ID, SNBConstant.SPID);
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl queryRechargeCoupon input param = " + jSONObject2, true);
            return this.mSNBServiceProvider.rechargeCoupon(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    public String cardQuery(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            if (!StringUtil.isEmpty(str2, true)) {
                jSONObject.put("tag", str2);
            }
            String jSONObject2 = jSONObject.toString();
            C2538c.c(TAG, new Object[]{"SNBServiceImpl cardQuery input param = " + jSONObject2});
            return this.mSNBServiceProvider.cardQuery(jSONObject2);
        } catch (JSONException e) {
            C2538c.c(TAG, new Object[]{"SNBServiceImpl cardQuery JSONException = " + e.getMessage()});
            return null;
        }
    }

    public String getFullCardNo(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("instance_id", str);
            jSONObject.put("cplc", this.mCplc);
            String jSONObject2 = jSONObject.toString();
            C2538c.c(TAG, new Object[]{"SNBServiceImpl getFullCardNo input param = " + jSONObject2});
            return this.mSNBServiceProvider.service("getFullCardNo", jSONObject2);
        } catch (JSONException e) {
            C2538c.c(TAG, new Object[]{"SNBServiceImpl getFullCardNo JSONException = " + e.getMessage()});
            return null;
        }
    }

    public String cardSwitch(String str) {
        C2538c.c(TAG, new Object[]{"SNBServiceImpl transQuerySe input aid = " + str});
        return this.mSNBServiceProvider.cardSwitch(str);
    }

    public String transQuerySe(String str) {
        C2538c.c(TAG, new Object[]{"SNBServiceImpl transQuerySe input aid = " + str});
        return this.mSNBServiceProvider.transQuerySe(str);
    }

    String cityAndCardList(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", str);
            jSONObject.put("latitude", str2);
            String jSONObject2 = jSONObject.toString();
            LogX.i("SNBServiceImpl queryCityAndCardList input param = " + jSONObject2, true);
            return this.mSNBServiceProvider.service("queryCityAndCardList", jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }
}
