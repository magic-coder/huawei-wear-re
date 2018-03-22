package com.huawei.hwcommonmodel.application;

import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: BaseApplication */
public enum C0975b {
    WEAR("com.huawei.bone"),
    HEALTH(WeChat.HEALTH_PACKAGE_NAME);
    
    String f1641c;

    private C0975b(String str) {
        this.f1641c = str;
    }

    public String m3521a() {
        return this.f1641c;
    }
}
