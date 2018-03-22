package com.huawei.up.p519d;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.up.p520e.C6134h;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.cookie.SM;
import org.apache.http.util.EntityUtils;

/* compiled from: ServiceTokenAuthRequest */
public class C6126c extends C6124b {
    private Context f21166c;
    private String f21167d = "0";
    private String f21168e;
    private String f21169f = "";
    private String f21170g = "";
    private String f21171h = "";
    private String f21172i = "";
    private int f21173j;
    private int f21174k;
    private String f21175l;

    public C6126c(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        this.f21166c = context;
        this.f21168e = str;
        this.f21169f = str2;
        this.f21170g = str3;
        this.f21171h = str4;
        this.f21172i = str5;
        this.b = a + "/IUserInfoMng/stAuth?Version=10002";
    }

    public HashMap<String, String> m27904a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("ver", "10002");
        Object obj = "";
        try {
            obj = C6134h.m27921a(this.f21168e, this.f21166c);
        } catch (UnsupportedEncodingException e) {
            C2538c.e(" error ,e=" + e.getMessage(), new Object[0]);
        } catch (IllegalBlockSizeException e2) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e2.getMessage()});
        } catch (InvalidKeyException e3) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e3.getMessage()});
        } catch (NoSuchAlgorithmException e4) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e4.getMessage()});
        } catch (BadPaddingException e5) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e5.getMessage()});
        } catch (NoSuchPaddingException e6) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e6.getMessage()});
        } catch (InvalidAlgorithmParameterException e7) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e7.getMessage()});
        } catch (Exception e8) {
            C2538c.e("ServiceTokenAuthRequest", new Object[]{" error ,e=" + e8.getMessage()});
        }
        hashMap.put(BundleKey.KEY_ST, obj);
        hashMap.put("app", this.f21169f);
        hashMap.put("dvT", this.f21170g);
        hashMap.put("dvID", this.f21171h);
        hashMap.put("tmT", C6134h.m27920a(this.f21166c));
        hashMap.put("clT", "39");
        hashMap.put(HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f21172i);
        hashMap.put("chg", "0");
        hashMap.put("gAc", "0");
        hashMap.put("agr", this.f21167d);
        return hashMap;
    }

    public Bundle m27903a(HttpResponse httpResponse) {
        Bundle bundle = new Bundle();
        String str = "";
        if (httpResponse != null) {
            try {
                str = EntityUtils.toString(httpResponse.getEntity(), GameManager.DEFAULT_CHARSET);
                C2538c.b("ServiceTokenAuthRequest", new Object[]{"unPackageRequest() responseContent=" + str});
            } catch (IOException e) {
                return bundle;
            }
        }
        if (str == null || str.length() <= 0) {
            return bundle;
        }
        String[] split = str.split(SNBConstant.FILTER);
        HashMap hashMap = new HashMap();
        Object obj = "";
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            hashMap.put(split3[0], split3[1]);
            obj = split3[0];
        }
        if (hashMap.containsKey("resultCode")) {
            this.f21173j = Integer.parseInt((String) hashMap.get("resultCode"));
        }
        if (this.f21173j == 0) {
            bundle.putString("userID", (String) hashMap.get("userID"));
            bundle.putString("acctChangedFlag", (String) hashMap.get("acctChangedFlag"));
            bundle.putString("agrFlags", (String) hashMap.get("agrFlags"));
            if (httpResponse != null) {
                Header[] headers = httpResponse.getHeaders(SM.SET_COOKIE);
                if (headers.length > 0) {
                    bundle.putString(SM.SET_COOKIE, headers[0].getValue());
                    C2538c.b("COOKS", new Object[]{"COOKS=" + headers[0].getValue()});
                }
            }
        } else {
            this.f21174k = this.f21173j;
            this.f21175l = (String) hashMap.get(obj);
            bundle.putString(Constant.KEY_ERROR_DESC, this.f21175l);
        }
        bundle.putInt("resultCode", this.f21174k);
        return bundle;
    }
}
