package com.huawei.hwcloudmodel.p061c;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: HWCloudUtils */
class C4690e implements CloudRequestHandler {
    final /* synthetic */ C3957a f17121a;
    final /* synthetic */ C4689d f17122b;

    C4690e(C4689d c4689d, C3957a c3957a) {
        this.f17122b = c4689d;
        this.f17121a = c3957a;
    }

    public void onFinish(Bundle bundle) {
        C2538c.c("HWCloudUtils", new Object[]{"getUserInfoFromUP onFinish"});
        if (bundle != null) {
            C2538c.c("HWCloudUtils", new Object[]{"getUserInfoFromUP success: " + bundle.getParcelable("userInfo")});
            UserInfo userInfo = (UserInfo) bundle.getParcelable("userInfo");
            UserInfomation userInfomation = new UserInfomation();
            userInfomation.setName("");
            userInfomation.setPortraitUrl("");
            userInfomation.setPicPath("");
            userInfomation.setBirthday(userInfo.getBirthDate());
            int i = -1;
            try {
                i = Integer.parseInt(userInfo.getGender());
            } catch (Exception e) {
                C2538c.c("HWCloudUtils", new Object[]{"getUserInfoFromUP gender is " + userInfo.getGender()});
            }
            userInfomation.setGender(Integer.valueOf(i));
            userInfomation.setName(userInfo.getNickName());
            userInfomation.setPortraitUrl(userInfo.getHeadPictureURL());
            this.f17121a.mo4330a(userInfomation, null, true);
            return;
        }
        C2538c.c("HWCloudUtils", new Object[]{"getUserInfoFromUP fail"});
        if (this.f17121a != null) {
            this.f17121a.mo4330a(null, null, false);
        }
    }

    public void onError(ErrorStatus errorStatus) {
        if (errorStatus != null) {
            C2538c.c("HWCloudUtils", new Object[]{"getUserInfoFromUP onError: " + errorStatus.getErrorCode()});
            if (FragmentTransaction.TRANSIT_FRAGMENT_FADE == errorStatus.getErrorCode()) {
                a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout", "true", new com.huawei.hwdataaccessmodel.a.c());
            }
        }
        if (this.f17121a != null) {
            this.f17121a.mo4330a(null, null, false);
        }
    }
}
