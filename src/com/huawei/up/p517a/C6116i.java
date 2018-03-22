package com.huawei.up.p517a;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;

/* compiled from: UpApi */
class C6116i implements C4694a {
    final /* synthetic */ C6115h f21136a;

    C6116i(C6115h c6115h) {
        this.f21136a = c6115h;
    }

    public void mo4558a(Bundle bundle) {
        UserInfo userInfo = (UserInfo) bundle.getParcelable("getUserInfoTag");
        Parcelable userInfo2 = new UserInfo();
        if (userInfo != null) {
            userInfo2.setBirthDate(userInfo.getBirthDate());
            userInfo2.setGender(userInfo.getGender());
            userInfo2.setHeadPictureURL(userInfo.getHeadPictureURL());
            userInfo2.setNickName(userInfo.getNickName());
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("userInfo", userInfo2);
        this.f21136a.f21132a.onFinish(bundle2);
    }

    public void mo4557a(int i) {
        this.f21136a.f21132a.onError(new ErrorStatus(i, "unknown error"));
        C2538c.e("UpApi", new Object[]{"getUserInfo failure, errcode is " + i});
    }
}
