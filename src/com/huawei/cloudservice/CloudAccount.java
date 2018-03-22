package com.huawei.cloudservice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.api.common.d;
import com.huawei.hwid.api.common.e;
import com.huawei.hwid.api.common.n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.d.b;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.helper.handler.ErrorStatus;

public class CloudAccount {
    public static final int ACCOUNT_MANAGER_LOGOUT = 1;
    public static final String ACTION_HWID_ACCOUNT_REMOVE = "com.huawei.hwid.ACTION_REMOVE_ACCOUNT";
    public static final int FLAG_BIND_ACCOUNT_CARD_VERIFY = 4;
    public static final int FLAG_BIND_CARD_VERIFY = 3;
    public static final int FLAG_IDENTY_CAM_VERIFY = 2;
    public static final int FLAG_REAL_NAME_VERIFY = 0;
    public static final int FLAG_SIMPLE_IDENTY_VERIFY = 1;
    public static final String KEY_ACCOUNT_NAME = "accountName";
    public static final String KEY_ACCOUNT_TYPE = "accountType";
    public static final String KEY_ACTIVATE_VIP = "activateVip";
    public static final String KEY_APP_ID_WEB = "key_app_id_to_web";
    public static final String KEY_CHOOSE_WINDOW = "chooseWindow";
    public static final String KEY_DEVICEID = "deviceId";
    public static final String KEY_DEVICEINFO = "deviceInfo";
    public static final String KEY_DEVICE_TYPE = "deviceType";
    public static final String KEY_ISO_COUNTRY_CODE = "countryIsoCode";
    public static final String KEY_LOGININFO = "userLoginInfo";
    public static final String KEY_LOGIN_CHANNEL = "loginChannel";
    public static final String KEY_LOGIN_USERNAME = "loginUserName";
    public static final String KEY_NEEDAUTH = "needAuth";
    public static final String KEY_REMOVED_ACCOUNT_NAME = "removedAccountName";
    public static final String KEY_REQCLIENTTYPE = "reqClientType";
    public static final String KEY_REQUESTCODE = "requestcode";
    public static final String KEY_RESULT_CODE = "result_code";
    public static final String KEY_SCOPE = "scope";
    public static final String KEY_SERVICEFLAG = "serviceFlag";
    public static final String KEY_SERVICE_COUNTRY_CODE = "serviceCountryCode";
    public static final String KEY_SERVICE_TOKEN = "serviceToken";
    public static final String KEY_SERVICE_TOKEN_WEB = "key_service_token_to_web";
    public static final String KEY_SITEID = "siteId";
    public static final String KEY_ST_STATUS = "STValidStatus";
    public static final String KEY_SUB_DEVICEID = "subDeviceId";
    public static final String KEY_USERACCOUNTINFO = "userAccountInfo";
    public static final String KEY_USERID = "userId";
    public static final String KEY_USERINFO = "userInfo";
    public static final String KEY_USER_ACCOUNT_WEB = "key_user_account_to_web";
    public static final String KEY_VERSION_NAME = "versionName";
    private d f1223a = null;

    public CloudAccount(d dVar) {
        this.f1223a = dVar;
    }

    public HwAccount getAccountData() {
        if (this.f1223a == null) {
            this.f1223a = new d();
        }
        return this.f1223a.a();
    }

    public String getAccountName() {
        return getAccountData().b();
    }

    public String getUserId() {
        return getAccountData().d();
    }

    public String getDeviceId() {
        return getAccountData().i();
    }

    public String getDeviceType() {
        return getAccountData().k();
    }

    public int getSiteId() {
        return getAccountData().e();
    }

    public String getServiceToken() {
        return getAccountData().g();
    }

    public String getAccountType() {
        return getAccountData().h();
    }

    public String getLoginUserName() {
        String l = getAccountData().l();
        if (TextUtils.isEmpty(l)) {
            return getAccountName();
        }
        return l;
    }

    public static void getAccountsByType(Context context, String str, Bundle bundle, LoginHandler loginHandler) {
        d.a(context, str, bundle, loginHandler);
    }

    public static void logout(Context context, String str, String str2, Bundle bundle, LogoutHandler logoutHandler) throws RuntimeException {
        e.a(context, str, str2, bundle, logoutHandler);
    }

    public static void setLogoutIntent(Context context, Intent intent, int i, CloudRequestHandler cloudRequestHandler) {
        d.a(context, intent, i, cloudRequestHandler);
    }

    public static boolean checkIsInstallHuaweiAccount(Context context) {
        return n.b(context);
    }

    @Deprecated
    public static boolean hasAlreadyLogin(Context context, String str) {
        return d.a(context, str);
    }

    public static String getCurrLoginUserName(Context context) {
        return d.c(context);
    }

    public static void quickLogin(Context context, LoginHandler loginHandler) {
        quickLogin(context, null, loginHandler);
    }

    public static void quickLogin(Context context, String str, LoginHandler loginHandler) {
        d.a(context, str, loginHandler);
    }

    public void serviceTokenAuth(Context context, String str, String str2, int i, CloudRequestHandler cloudRequestHandler) {
        this.f1223a.a(context, str, str2, i, cloudRequestHandler);
    }

    public static void clearAccountData(Context context) {
        d.b(context);
    }

    public static CloudAccount getCloudAccountByUserID(Context context, String str) {
        return d.b(context, str);
    }

    public static void logoutHwIDByUserID(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        d.a(context, str, cloudRequestHandler, bundle);
    }

    public String getAuthToken() {
        return this.f1223a.b();
    }

    public Bundle getAccountInfo() {
        return this.f1223a.c();
    }

    public static void checkPassWord(Context context, String str, String str2, String str3, String str4, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        d.a(context, str, str2, str3, str4, cloudRequestHandler, bundle);
    }

    public static boolean isThirdAccount(String str) {
        return b.e(str);
    }

    @Deprecated
    public void logout(Context context) {
        this.f1223a.d(context);
    }

    public void getUserInfo(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        this.f1223a.a(context, str, cloudRequestHandler);
    }

    public boolean updateUserInfo(Context context, UserInfo userInfo, CloudRequestHandler cloudRequestHandler) {
        return this.f1223a.a(context, userInfo, cloudRequestHandler);
    }

    public boolean updateHeadPicture(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        return this.f1223a.b(context, str, cloudRequestHandler);
    }

    public static void getVerifiedPhoneOrEmail(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        e.a(context, str, cloudRequestHandler, bundle);
    }

    public static void release(Context context, Bundle bundle) {
        d.a(context, bundle);
    }

    public static String getAccountStatus(Context context) {
        return d.f(context);
    }

    public static void initial(Context context, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        d.a(context, bundle, cloudRequestHandler);
    }

    public static void updateHwID(Context context, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        d.b(context, bundle, cloudRequestHandler);
    }

    @Deprecated
    public AlertDialog getAccountManagerDialog(Activity activity, String str, Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        if (activity == null || TextUtils.isEmpty(str) || cloudRequestHandler == null) {
            return null;
        }
        if (!n.b(activity)) {
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
            return null;
        } else if (!n.a(activity, 20301000)) {
            return this.f1223a.a(activity, str, bundle, cloudRequestHandler);
        } else {
            cloudRequestHandler.onError(new ErrorStatus(35, "hwid is low version"));
            return null;
        }
    }

    public static long getLoginCount(Context context) {
        return e.a(context);
    }

    public static Intent getPwdVerifyIntent() {
        return d.d();
    }

    public void getRemoteAccessAuthorizeIntent(Context context, IntentResultHandler intentResultHandler) {
        this.f1223a.a(context, HwAccountConstants.REMOTE_AUTH_INTENT, intentResultHandler);
    }

    public void getHomeCountryChangeIntent(Context context, IntentResultHandler intentResultHandler) {
        this.f1223a.a(context, HwAccountConstants.HOME_COUNTRY_CHANGE_INTENT, intentResultHandler);
    }

    public void getRealNameVerifyIntent(Context context, int i, IntentResultHandler intentResultHandler) {
        this.f1223a.a(context, i, intentResultHandler);
    }

    public void getRealNameInfo(Context context, CloudRequestHandler cloudRequestHandler) {
        this.f1223a.c(context, cloudRequestHandler);
    }

    public void getAuthAppListIntent(Context context, IntentResultHandler intentResultHandler) {
        this.f1223a.a(context, HwAccountConstants.AUTH_APP_LIST_INTENT, intentResultHandler);
    }

    public static void loginSystemAccount(Activity activity, LoginHandler loginHandler, int i) {
        if (activity != null && loginHandler != null) {
            d.a(activity, loginHandler, i, activity.getPackageName());
        }
    }
}
