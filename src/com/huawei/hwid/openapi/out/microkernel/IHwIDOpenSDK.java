package com.huawei.hwid.openapi.out.microkernel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.huawei.hwid.openapi.out.ResReqHandler;
import java.util.HashMap;

public interface IHwIDOpenSDK {
    public static final String plusName = "hwID_opensdk";

    void authorize(Activity activity, ResReqHandler resReqHandler, String str, Bundle bundle);

    void authorize(Activity activity, String str, ResReqHandler resReqHandler, String str2, Bundle bundle);

    void authorize(Activity activity, String str, ResReqHandler resReqHandler, String str2, String str3, Bundle bundle);

    void authorize(Activity activity, String str, String str2, String str3, ResReqHandler resReqHandler, String str4, String str5, Bundle bundle);

    String getAccessToken(Context context, String str, String str2, Bundle bundle);

    HashMap getUserInfo();

    void logOut(Context context, String str, String str2, Bundle bundle);

    void login(Bundle bundle);

    void logout();

    void releaseResouce();

    void setLoginProxy(Activity activity, String str, IHwIDCallBack iHwIDCallBack, Bundle bundle);

    void setPorxy(String str, int i, Bundle bundle);

    Boolean storeAccessToken(Context context, String str, String str2, String str3, Bundle bundle);

    void userInfoRequest(Context context, ResReqHandler resReqHandler, String str);
}
