package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p130e.p488a.C5726a;
import org.json.JSONObject;

public class PayInfo {
    public static final String FM_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj/CoTrOv5Zq7xIBu8+sIi3L2+m/COLzexllpJXgfk+N6/Fb8mAbVGcBsPV409bEiSzZfBrMuIOLuQOIZAS8+gE20PcAWAhreAkExInlwYw6fCHLH5AZy7K+O6Ae0HOX2sCaAIARLrl+w3/Qff/on95u4VDvn/UV0QBRlWPIymHqbYKDx/sgXzBiwhVq9lUFDyWT4pcy3ipTstHi9akM5gGgeD0byqByU271+ParCu46Ds1GpOAcOtFi7fzC1zXKNBEHienx/Ese8KVlWLmdUWlpqJMzSwcz01sAi9R0NjOvu4jONrXgYGBVibDIBR2QXrsTHgHjXsITvP0IuW+h5dwIDAQAB";
    public static final String FM_PUBLIC_KEY_RLS = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj/CoTrOv5Zq7xIBu8+sIi3L2+m/COLzexllpJXgfk+N6/Fb8mAbVGcBsPV409bEiSzZfBrMuIOLuQOIZAS8+gE20PcAWAhreAkExInlwYw6fCHLH5AZy7K+O6Ae0HOX2sCaAIARLrl+w3/Qff/on95u4VDvn/UV0QBRlWPIymHqbYKDx/sgXzBiwhVq9lUFDyWT4pcy3ipTstHi9akM5gGgeD0byqByU271+ParCu46Ds1GpOAcOtFi7fzC1zXKNBEHienx/Ese8KVlWLmdUWlpqJMzSwcz01sAi9R0NjOvu4jONrXgYGBVibDIBR2QXrsTHgHjXsITvP0IuW+h5dwIDAQAB";
    public static final String FM_PUBLIC_KEY_TEST = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8GYIbs7HirEkBkzGE9QGuX4dlBEcRU6kHVeN5iss/EIKPiBf9KiA73oJoCKmMv7bqv2snCwdMl2Yfb3zUDeJ6cL/CnC/a/dLYHqemIxrJf9fogTgHMPWqTQGvGGqU7kLMqus4ebtAcSdNS7Y2e4twFQscVztY7BVqJTqsIC3cscszr0e8oCRgcBygmjCkLuEv9vLKeZaMj7SZ3CO56VT8m8r3YJYrfeWkmtfEGC5EhwV8CgniasgsOMSe0rf/ztjYbH6SsTWf1swac22EXGpjFoXk9NopZd60iJtKS7BTuTS9VZHl2E/Lfnzb5RZ/KM5AWcvKYjCqv4v2YABx6ZbTwIDAQAB";
    public static final String PAY_RESULT_CODE_CANCLE = "30000";
    public static final String PAY_RESULT_CODE_NET_ERROR = "30005";
    public static final String PAY_RESULT_FAILED = "-1";
    public static final String PAY_RESULT_SUCCESS = "0";
    public static final String SH_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmPTm2FTz2kv3FBmYKgI3LC6Q/LCmJnwpaGes6yc7LBQ+ptV/J3TfBBNEPjrr5NQy47FmSiA4xbjlNmfTqoacEHAzNmFE4ER3EANeLl4wGPgqCjnVVqpa0OCSPTaycjNcsSHhrCq31GdLWadn4Zs1OcOLtEHnKS/aOuxw+poHKQtIONK3115T28A0/ithK6lEJDOKyIU9Ofyji9V2hG3s2pEV8h5w/hQmFjRF05QnPUjRZQCeh6zcebt+OPQuU/i1EMytC8GgK+2sh+AzNSB/nc5Va3npjul9HYExRklJVLA9sYCf7U24+4G8Z3BqHrdiVPmhdrFqa5OQbqhmyOw3DQIDAQAB";
    public static final String SH_PUBLIC_KEY_RLS = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmPTm2FTz2kv3FBmYKgI3LC6Q/LCmJnwpaGes6yc7LBQ+ptV/J3TfBBNEPjrr5NQy47FmSiA4xbjlNmfTqoacEHAzNmFE4ER3EANeLl4wGPgqCjnVVqpa0OCSPTaycjNcsSHhrCq31GdLWadn4Zs1OcOLtEHnKS/aOuxw+poHKQtIONK3115T28A0/ithK6lEJDOKyIU9Ofyji9V2hG3s2pEV8h5w/hQmFjRF05QnPUjRZQCeh6zcebt+OPQuU/i1EMytC8GgK+2sh+AzNSB/nc5Va3npjul9HYExRklJVLA9sYCf7U24+4G8Z3BqHrdiVPmhdrFqa5OQbqhmyOw3DQIDAQAB";
    public static final String SH_PUBLIC_KEY_TEST = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8GYIbs7HirEkBkzGE9QGuX4dlBEcRU6kHVeN5iss/EIKPiBf9KiA73oJoCKmMv7bqv2snCwdMl2Yfb3zUDeJ6cL/CnC/a/dLYHqemIxrJf9fogTgHMPWqTQGvGGqU7kLMqus4ebtAcSdNS7Y2e4twFQscVztY7BVqJTqsIC3cscszr0e8oCRgcBygmjCkLuEv9vLKeZaMj7SZ3CO56VT8m8r3YJYrfeWkmtfEGC5EhwV8CgniasgsOMSe0rf/ztjYbH6SsTWf1swac22EXGpjFoXk9NopZd60iJtKS7BTuTS9VZHl2E/Lfnzb5RZ/KM5AWcvKYjCqv4v2YABx6ZbTwIDAQAB";
    public static final String SNB_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsiHAdMr5lpTnfz4P6IFb3Cf8F3tTPzVuLZcX/YzcdQAo1eYF5IO6KX+kY2F0HiR8U3zQm30wZjSqtsK8QGXC1gl23Dn9Dkz3/CiK84xoxpNr8zT9ouKcf1XY0EOOLZnZexNsqW9bgwf6sRKXVObT+QPKdsi76lv1cgpB6HKoHgfB5Z+srRgf0GSkPDAbezWmMsbCyt2TpQ6ddcUKFniER0dXoeM5Rtsz+myTWjwVEvQx+dE+aocjt9KttL20XZit6UB5IShDh6kT1gjIJmZyXMljTRm59AOxng8TBph1Ty3769r/qogO8aDCz17l9q8HdYHRZJden9/5aP+DDXKhYwIDAQAB";
    private static final String TAG = "PayInfo";
    private String amount;
    private String applicationID;
    private String currency;
    private String notifyUrl;
    private String productDesc;
    private String productName;
    private String pubKey;
    private String requestId;
    private int sdkChannel = -1;
    private String serviceCatalog;
    private String sign;
    private String signType;
    private String urlVer;
    private String userID;
    private String userName;

    class Commonkey {
        static final String KEY_NOTIFY_URL = "url";
        static final String KEY_NOTIFY_URL_VERSION = "urlver";
        static final String KEY_ORDER_AMOUNT = "amount";
        static final String KEY_ORDER_APPLICATIONID = "applicationID";
        static final String KEY_ORDER_PACKAGE_NAME = "packageName";
        static final String KEY_ORDER_PRODUCTDESC = "productDesc";
        static final String KEY_ORDER_PRODUCTNAME = "productName";
        static final String KEY_ORDER_REQUESTID = "requestId";
        static final String KEY_ORDER_SERVICECATALOG = "serviceCatalog";
        static final String KEY_ORDER_SIGN = "sign";
        static final String KEY_ORDER_SIGNTYPE = "signType";
        static final String KEY_ORDER_USERID = "merchantId";
        static final String KEY_ORDER_USERNAME = "merchantName";

        private Commonkey() {
        }
    }

    public String getCurrency() {
        return (String) C0978h.a(this.currency);
    }

    public void setCurrency(String str) {
        this.currency = (String) C0978h.a(str);
    }

    public String getRequestId() {
        return (String) C0978h.a(this.requestId);
    }

    public void setRequestId(String str) {
        this.requestId = (String) C0978h.a(str);
    }

    public String getPubKey() {
        return (String) C0978h.a(this.pubKey);
    }

    public void setPubKey(String str) {
        this.pubKey = (String) C0978h.a(str);
    }

    public String getServiceCatalog() {
        return (String) C0978h.a(this.serviceCatalog);
    }

    public void setServiceCatalog(String str) {
        this.serviceCatalog = (String) C0978h.a(str);
    }

    public String getUserName() {
        return (String) C0978h.a(this.userName);
    }

    public void setUserName(String str) {
        this.userName = (String) C0978h.a(str);
    }

    public String getUserID() {
        return (String) C0978h.a(this.userID);
    }

    public void setUserID(String str) {
        this.userID = (String) C0978h.a(str);
    }

    public String getApplicationID() {
        return (String) C0978h.a(this.applicationID);
    }

    public void setApplicationID(String str) {
        this.applicationID = (String) C0978h.a(str);
    }

    public String getAmount() {
        return (String) C0978h.a(this.amount);
    }

    public void setAmount(String str) {
        this.amount = (String) C0978h.a(str);
    }

    public String getProductName() {
        return (String) C0978h.a(this.productName);
    }

    public void setProductName(String str) {
        this.productName = (String) C0978h.a(str);
    }

    public String getProductDesc() {
        return (String) C0978h.a(this.productDesc);
    }

    public void setProductDesc(String str) {
        this.productDesc = (String) C0978h.a(str);
    }

    public String getSign() {
        return (String) C0978h.a(this.sign);
    }

    public void setSign(String str) {
        this.sign = (String) C0978h.a(str);
    }

    public String getSignType() {
        return (String) C0978h.a(this.signType);
    }

    public void setSignType(String str) {
        this.signType = (String) C0978h.a(str);
    }

    public String getNotifyUrl() {
        return (String) C0978h.a(this.notifyUrl);
    }

    public void setNotifyUrl(String str) {
        this.notifyUrl = (String) C0978h.a(str);
    }

    public String getUrlVer() {
        return (String) C0978h.a(this.urlVer);
    }

    public void setUrlVer(String str) {
        this.urlVer = (String) C0978h.a(str);
    }

    public int getSdkChannel() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sdkChannel))).intValue();
    }

    public void setSdkChannel(int i) {
        this.sdkChannel = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public static PayInfo build(String str) {
        return buildForCommon(str);
    }

    public static PayInfo build(String str, boolean z) {
        if (z) {
            return buildForSNB(str);
        }
        return buildForCommon(str);
    }

    public static PayInfo build(ApplyOrder applyOrder) {
        if (applyOrder == null) {
            LogX.e("build PayInfo err, applyOrder is null!");
            return null;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.setRequestId(applyOrder.getOrderId());
        payInfo.setAmount(applyOrder.getAmount());
        payInfo.setApplicationID(applyOrder.getApplicationId());
        payInfo.setNotifyUrl(applyOrder.getUrl());
        payInfo.setUserName(applyOrder.getMerchantName());
        payInfo.setUserID(applyOrder.getSPMerchantId());
        payInfo.setSignType(applyOrder.getSignType());
        payInfo.setSign(applyOrder.getSign());
        payInfo.setServiceCatalog(applyOrder.getServiceCatalog());
        payInfo.setProductName(applyOrder.getProductName());
        payInfo.setProductDesc(applyOrder.getProductDesc());
        payInfo.setUrlVer(applyOrder.getUrlVer());
        payInfo.setCurrency(applyOrder.getCurrency());
        payInfo.setSdkChannel(Integer.parseInt(applyOrder.getSdkChannel()));
        return payInfo;
    }

    private static PayInfo buildForSNB(String str) {
        C2538c.c(TAG, new Object[]{"json=" + str});
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        PayInfo payInfo = new PayInfo();
        try {
            String string = new JSONObject(str).getString("signedData");
            C2538c.c(TAG, new Object[]{"json1=" + string});
            JSONObject jSONObject = new JSONObject(string);
            payInfo.setUserName(JsonUtil.getStringValue(jSONObject, "merchantName"));
            if (payInfo.getUserName() == null) {
                C2538c.c(TAG, new Object[]{"userName is null"});
                return null;
            }
            payInfo.setUserID(JsonUtil.getStringValue(jSONObject, "merchantId"));
            if (payInfo.getUserID() == null) {
                C2538c.c(TAG, new Object[]{"userID is null"});
                return null;
            }
            payInfo.setApplicationID(JsonUtil.getStringValue(jSONObject, "applicationID"));
            if (payInfo.getApplicationID() == null) {
                C2538c.c(TAG, new Object[]{"applicationID is null"});
                return null;
            }
            payInfo.setProductName(JsonUtil.getStringValue(jSONObject, "productName"));
            if (payInfo.getProductName() == null) {
                C2538c.c(TAG, new Object[]{"productName is null"});
                return null;
            }
            payInfo.setAmount(C5726a.m26396a(JsonUtil.getStringValue(jSONObject, "amount")));
            if (payInfo.getAmount() == null) {
                C2538c.c(TAG, new Object[]{"amount is null"});
                return null;
            }
            payInfo.setProductDesc(JsonUtil.getStringValue(jSONObject, "productDesc"));
            if (payInfo.getProductDesc() == null) {
                C2538c.c(TAG, new Object[]{"productDesc is null"});
                return null;
            }
            payInfo.setRequestId(JsonUtil.getStringValue(jSONObject, HwPayConstant.KEY_REQUESTID));
            if (payInfo.getRequestId() == null) {
                C2538c.c(TAG, new Object[]{"requestId is null"});
                return null;
            }
            payInfo.setServiceCatalog(JsonUtil.getStringValue(jSONObject, "serviceCatalog"));
            if (payInfo.getServiceCatalog() == null) {
                C2538c.c(TAG, new Object[]{"serviceCatalog is null"});
                return null;
            }
            payInfo.setSign(JsonUtil.getStringValue(jSONObject, "sign"));
            if (payInfo.getSign() == null) {
                C2538c.c(TAG, new Object[]{"sign is null"});
                return null;
            }
            payInfo.setSignType("RSA256");
            payInfo.setNotifyUrl(JsonUtil.getStringValue(jSONObject, "url"));
            if (payInfo.getNotifyUrl() == null) {
                C2538c.c(TAG, new Object[]{"notifyUrl is null"});
                return null;
            }
            payInfo.setSdkChannel(JsonUtil.getIntValue(jSONObject, "sdkChannel", -1));
            return payInfo;
        } catch (Throwable e) {
            LogX.e("PayInfo, JSONException", e);
            return null;
        }
    }

    private static PayInfo buildForCommon(String str) {
        C2538c.c(TAG, new Object[]{"buildForCommon son = " + str});
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        PayInfo payInfo = new PayInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            payInfo.setUserName(JsonUtil.getStringValue(jSONObject, "merchantName"));
            if (payInfo.getUserName() == null) {
                return null;
            }
            payInfo.setUserID(JsonUtil.getStringValue(jSONObject, "merchantId"));
            if (payInfo.getUserID() == null) {
                return null;
            }
            payInfo.setApplicationID(JsonUtil.getStringValue(jSONObject, "applicationID"));
            if (payInfo.getApplicationID() == null) {
                return null;
            }
            payInfo.setProductName(JsonUtil.getStringValue(jSONObject, "productName"));
            if (payInfo.getProductName() == null) {
                return null;
            }
            payInfo.setAmount(C5726a.m26396a(JsonUtil.getStringValue(jSONObject, "amount")));
            if (payInfo.getAmount() == null) {
                return null;
            }
            payInfo.setProductDesc(JsonUtil.getStringValue(jSONObject, "productDesc"));
            if (payInfo.getProductDesc() == null) {
                return null;
            }
            payInfo.setRequestId(JsonUtil.getStringValue(jSONObject, HwPayConstant.KEY_REQUESTID));
            if (payInfo.getRequestId() == null) {
                return null;
            }
            payInfo.setServiceCatalog(JsonUtil.getStringValue(jSONObject, "serviceCatalog"));
            if (payInfo.getServiceCatalog() == null) {
                return null;
            }
            payInfo.setSign(JsonUtil.getStringValue(jSONObject, "sign"));
            if (payInfo.getSign() == null) {
                return null;
            }
            payInfo.setSignType("RSA256");
            payInfo.setNotifyUrl(JsonUtil.getStringValue(jSONObject, "url"));
            if (payInfo.getNotifyUrl() == null) {
                return null;
            }
            payInfo.setUrlVer(JsonUtil.getStringValue(jSONObject, HwPayConstant.KEY_URLVER));
            if (payInfo.getUrlVer() == null) {
                return null;
            }
            payInfo.setSdkChannel(JsonUtil.getIntValue(jSONObject, "sdkChannel", -1));
            return payInfo;
        } catch (Throwable e) {
            LogX.e("PayInfo, JSONException", e);
            return null;
        }
    }

    public PayReq makePayReq() {
        PayReq payReq = new PayReq();
        payReq.productName = getProductName();
        C2538c.c(TAG, new Object[]{" payReq.productName =" + payReq.productName});
        payReq.productDesc = getProductDesc();
        C2538c.c(TAG, new Object[]{" payReq.productDesc =" + payReq.productDesc});
        payReq.merchantId = getUserID();
        C2538c.c(TAG, new Object[]{" payReq.merchantId =" + payReq.merchantId});
        payReq.applicationID = getApplicationID();
        C2538c.c(TAG, new Object[]{" payReq.applicationID =" + payReq.applicationID});
        payReq.amount = getAmount();
        C2538c.c(TAG, new Object[]{" payReq.amount =" + payReq.amount});
        payReq.requestId = getRequestId();
        C2538c.c(TAG, new Object[]{" payReq.requestId =" + payReq.requestId});
        payReq.url = getNotifyUrl();
        C2538c.c(TAG, new Object[]{" payReq.url =" + payReq.url});
        if (-1 != getSdkChannel()) {
            payReq.sdkChannel = getSdkChannel();
        }
        C2538c.c(TAG, new Object[]{" payReq.sdkChannel =" + payReq.sdkChannel});
        if (!(getUrlVer() == null || TextUtils.isEmpty(getUrlVer()))) {
            payReq.urlVer = getUrlVer();
            C2538c.c(TAG, new Object[]{" payReq.urlVer =" + payReq.urlVer});
        }
        if (!(getCurrency() == null || TextUtils.isEmpty(getCurrency()))) {
            payReq.currency = getCurrency();
        }
        payReq.sign = getSign();
        C2538c.c(TAG, new Object[]{" payReq.sign =" + payReq.sign});
        payReq.merchantName = getUserName();
        C2538c.c(TAG, new Object[]{" payReq.merchantName =" + payReq.merchantName});
        payReq.serviceCatalog = getServiceCatalog();
        C2538c.c(TAG, new Object[]{" payReq.serviceCatalog =" + payReq.serviceCatalog});
        payReq.extReserved = "cp private data";
        C2538c.c(TAG, new Object[]{" payReq.extReserved =" + payReq.extReserved});
        return payReq;
    }
}
