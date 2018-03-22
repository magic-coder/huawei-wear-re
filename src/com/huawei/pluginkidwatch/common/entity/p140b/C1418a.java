package com.huawei.pluginkidwatch.common.entity.p140b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: BaseBuilder */
public abstract class C1418a implements Serializable {
    public String f3234a = "/rest.php";
    public int f3235b = 20000;
    public int f3236c = 5000;
    public int f3237d = SdkConstants.TIME_OUT;
    public int f3238e = 240000;
    public int f3239f = 10000;
    protected String f3240g = "nsp_ts";
    protected String f3241h = "nsp_svc";
    protected String f3242i = "access_token";
    protected Gson f3243j = new Gson();

    public abstract BaseEntityModel mo2511a(String str);

    public abstract String mo2512a();

    protected void m6597a(StringBuffer stringBuffer, BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null) {
            String f;
            stringBuffer.append(this.f3240g);
            stringBuffer.append("=");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append(SNBConstant.FILTER);
            stringBuffer.append(this.f3242i);
            stringBuffer.append("=");
            if (baseEntityModel instanceof BindDeviceInfosIOEntityModel) {
                BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel = (BindDeviceInfosIOEntityModel) baseEntityModel;
                if (TextUtils.isEmpty(bindDeviceInfosIOEntityModel.accessToken)) {
                    f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
                } else {
                    f = bindDeviceInfosIOEntityModel.accessToken;
                }
            } else {
                f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
            }
            if (f == null) {
                f = "";
            }
            try {
                stringBuffer.append(URLEncoder.encode(f, GameManager.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                C2538c.m12680e("BaseBuilder", "UnsupportedEncodingException e = " + e.getMessage());
            }
            stringBuffer.append(SNBConstant.FILTER);
            stringBuffer.append(this.f3241h);
            stringBuffer.append("=");
            stringBuffer.append(baseEntityModel.interfaceName);
        }
    }

    public String toString() {
        return "BaseBuilder{uri='" + this.f3234a + '\'' + ", DEFAULT_HTTP_TIMEOUT=" + this.f3235b + ", SHORT_HTTP_TIMEOUT=" + this.f3236c + ", LONG_HTTP_TIMEOUT=" + this.f3237d + ", LONG_LONG_HTTP_TIMEOUT=" + this.f3238e + ", CONIFG_HTTP_TIMEOUT=" + this.f3239f + ", nsp_ts='" + this.f3240g + '\'' + ", nsp_svc='" + this.f3241h + '\'' + ", access_token='" + this.f3242i + '\'' + ", gson=" + this.f3243j + '}';
    }
}
