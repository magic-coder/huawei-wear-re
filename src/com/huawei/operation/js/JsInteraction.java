package com.huawei.operation.js;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.operation.a.a;
import com.huawei.operation.b;
import com.huawei.operation.utils.AbilitySetUtils;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.config.ParseConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class JsInteraction {
    private static final String TAG = "[Operation Version 1.2]JsInteraction";
    private AchievementShareCallback mAchievementShareCallback;
    private Context mContext;
    private Map<String, String> mMapInfo;
    private SetTitleCallback mSetTitleCallback;
    private ShareCallback mShareCallback;
    private a mSportData;
    private StartGPSTrackPageCallback mStartGPSTrackPageCallback;
    private StartSocialDetailPageCallback mStartSocialDetailPageCallback;
    private ToastCallBack mToastCallBack;

    public JsInteraction(Context context) {
        this.mContext = context;
        b bVar = (b) com.huawei.operation.a.a(context).getAdapter();
        if (bVar != null) {
            this.mMapInfo = bVar.a(new String[]{"getAppInfo", "getDeviceInfo", "getLoginInfo", "getUserInfo", "getPhoneInfo"});
            this.mSportData = bVar.a();
        }
    }

    public void setShareCallback(ShareCallback shareCallback) {
        this.mShareCallback = shareCallback;
    }

    public void setSetTitleCallback(SetTitleCallback setTitleCallback) {
        this.mSetTitleCallback = setTitleCallback;
    }

    public void setAchievementShareCallback(AchievementShareCallback achievementShareCallback) {
        this.mAchievementShareCallback = achievementShareCallback;
    }

    public void setStartGPSTrackPageCallback(StartGPSTrackPageCallback startGPSTrackPageCallback) {
        this.mStartGPSTrackPageCallback = startGPSTrackPageCallback;
    }

    public void setStartSocialDetailPageCallback(StartSocialDetailPageCallback startSocialDetailPageCallback) {
        this.mStartSocialDetailPageCallback = startSocialDetailPageCallback;
    }

    public void setToastCallBack(ToastCallBack toastCallBack) {
        this.mToastCallBack = toastCallBack;
    }

    @JavascriptInterface
    public String getHuid() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("huid");
        }
        C2538c.m12677c(TAG, "getHuid return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getAccessToken() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("accessToken");
        }
        C2538c.m12677c(TAG, "getAccessToken return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getServiceToken() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("severToken");
        }
        C2538c.m12677c(TAG, "getServiceToken return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getVersion() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("version");
        }
        C2538c.m12677c(TAG, "getVersion return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getAppId() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get(AppOpenOrDownHelper.APP_ID_PARAM);
        }
        C2538c.m12677c(TAG, "getAppId return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getAppType() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("appType");
        }
        C2538c.m12677c(TAG, "getAppType return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getDeviceType() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("deviceModel");
        }
        C2538c.m12677c(TAG, "getDeviceType return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getDeviceId() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("deviceId");
        }
        C2538c.m12677c(TAG, "getDeviceId return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getSysVersion() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("sysVersion");
        }
        C2538c.m12677c(TAG, "getSysVersion return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getBindDeviceType() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("productType");
        }
        C2538c.m12677c(TAG, "getBindDeviceType return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getLanguage() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get(UserInfo.LANGUAGECODE);
        }
        C2538c.m12677c(TAG, "getLanguage return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getEnvironment() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get(ParseConfig.CFG_ENVIRONMENT);
        }
        C2538c.m12677c(TAG, "getEnvironment return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getNickName() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("name");
        }
        C2538c.m12677c(TAG, "getNickName return:" + str);
        return str;
    }

    @JavascriptInterface
    public String getPhoto() {
        String str = "";
        if (this.mMapInfo != null) {
            str = (String) this.mMapInfo.get("portraitUrl");
        }
        C2538c.m12677c(TAG, "getPhoto return:" + str);
        return str;
    }

    @JavascriptInterface
    public void setTitle(String str) {
        C2538c.m12677c(TAG, "setTitle title:" + str);
        if (this.mSetTitleCallback != null) {
            this.mSetTitleCallback.setTitle(str);
        }
    }

    @JavascriptInterface
    public void log(String str, String str2) {
        C2538c.m12677c(TAG, "log level:" + str + ", content:" + str2);
    }

    @JavascriptInterface
    public void achievementShare(String str, String str2) {
        C2538c.m12677c(TAG, "achievementShare imgUrl:" + str + ", awardName:" + str2);
        if (this.mAchievementShareCallback != null) {
            this.mAchievementShareCallback.onAchievementShare(str, str2);
        }
    }

    @JavascriptInterface
    public void toast(String str, String str2) {
        C2538c.m12677c(TAG, "toast content:" + str + ", time:" + str2);
        if (this.mToastCallBack != null) {
            this.mToastCallBack.onToast(str, str2);
        }
    }

    @JavascriptInterface
    public void share(String str, String str2, String str3) {
        C2538c.m12677c(TAG, "share activityId:" + str + ", shareType:" + str2 + ", shareChannel:" + str3);
        if (this.mShareCallback != null) {
            this.mShareCallback.onShare(str, str2);
        }
    }

    @JavascriptInterface
    public String getSportData() {
        String str = "";
        str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.valueOf(Long.parseLong((String) this.mMapInfo.get("utc"))).longValue()));
        Object jsSportData = new JsSportData();
        jsSportData.setVersion("1.0.1");
        jsSportData.setCurrentTime(str);
        if (this.mSportData != null) {
            jsSportData.setData(this.mSportData.getData());
        }
        str = new Gson().toJson(jsSportData);
        C2538c.m12677c(TAG, "getSportData json ===>" + str);
        return str;
    }

    @JavascriptInterface
    public void startGPSTrailPage(int i, String str, float f) {
        C2538c.m12677c(TAG, "startGPSTrailPage sportType:" + i + " targetType:" + str + " targetValue:" + f);
        if (this.mStartGPSTrackPageCallback != null) {
            this.mStartGPSTrackPageCallback.onStartGPSTrackPage(this.mContext, i, str, f);
        }
    }

    @JavascriptInterface
    public void startSocialDetailPage(String str) {
        C2538c.m12674b(TAG, "startSocialDetailPage huid" + str);
        if (this.mStartSocialDetailPageCallback != null) {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                this.mStartSocialDetailPageCallback.onStartSocialDetialPage(this.mContext, parseLong);
                return;
            }
            C2538c.m12674b(TAG, "startSocialDetailPage failed because of huid = " + str);
        }
    }

    @JavascriptInterface
    public String getAbility() {
        String abilitySet = AbilitySetUtils.getAbilitySet();
        C2538c.m12674b(TAG, "AbilityData json ===>" + abilitySet);
        return abilitySet;
    }
}
