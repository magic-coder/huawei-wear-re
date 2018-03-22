package com.huawei.hwid.core.datatype;

import android.text.TextUtils;

/* compiled from: AppInfo */
public class C5196a {
    private String f18777a = "";
    private String f18778b = "";
    private String f18779c = "";
    private boolean f18780d = false;
    private boolean f18781e = false;
    private boolean f18782f = false;
    private boolean f18783g = false;
    private boolean f18784h = false;
    private boolean f18785i = false;
    private int f18786j = 0;
    private String f18787k = "";
    private int f18788l = 0;
    private boolean f18789m = false;

    public void m25276a(String str) {
        this.f18778b = str;
    }

    public String m25275a() {
        return this.f18779c;
    }

    public void m25278b(String str) {
        if (m25274d(str)) {
            this.f18779c = str;
        }
    }

    private boolean m25274d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public void m25279c(String str) {
        this.f18777a = str;
    }

    public String m25277b() {
        return this.f18777a;
    }

    public String toString() {
        return "mAppID:" + this.f18777a + " ;mReqClientType:" + this.f18778b + " ;mDefaultChannel:" + this.f18779c + " ;popLogin:" + String.valueOf(this.f18780d) + " ;chooseAccount:" + String.valueOf(this.f18781e) + ";mScope:" + this.f18786j + ";mChooseWindow:" + this.f18785i + ";mCheckPsd:" + this.f18784h + ";mNeedAuth:" + this.f18782f + ";mAccountName:" + this.f18787k + ";mSdkType:" + this.f18788l + ";mIsFromAPK:" + this.f18783g + ";mActivateVip:" + this.f18789m;
    }
}
