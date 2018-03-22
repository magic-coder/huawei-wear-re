package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HuaFenClubInteractor */
public class C2287i {
    private static volatile C2287i f8294a = null;
    private C2286h f8295b = C2286h.m11749a();

    private C2287i(Context context) {
    }

    public static C2287i m11757a(Context context) {
        if (f8294a == null) {
            synchronized (C2287i.class) {
                if (f8294a == null) {
                    f8294a = new C2287i(BaseApplication.m2632b());
                }
            }
        }
        return f8294a;
    }

    public String m11758a() {
        String str = "http://cn.club.vmall.com/forum.php?mobile=2&mod=forumdisplay&fid=339";
        DeviceInfo b = this.f8295b.m11755b();
        if (b == null) {
            C2538c.m12674b("HuaFenClubInteractor", "getHuaFenClubUrl() -> null == deviceInfo");
            return str;
        }
        C2538c.m12674b("HuaFenClubInteractor", "DeviceType =" + b.getProductType());
        switch (b.getProductType()) {
            case 0:
                return "http://cn.club.vmall.com/forum.php?mobile=2&mod=forumdisplay&fid=339";
            case 1:
                return "http://cn.club.vmall.com/forum-854-1.html";
            case 3:
                return "http://club.huawei.com/forum-1776-1.html";
            case 5:
                return "http://cn.club.vmall.com/forum-1270-1.html";
            case 7:
                return "http://cn.club.vmall.com/forum-2243-1.html";
            case 8:
                return "http://club.huawei.com/forum-2666-1.html";
            case 10:
                return "http://club.huawei.com/forum-2788-1.html";
            case 11:
                return "http://club.huawei.com/forum-917-1.html";
            case 12:
                return "http://club.huawei.com/forum-2343-1.html";
            case 13:
                return "http://club.huawei.com/forum-2847-1.html";
            case 14:
                return "http://cn.club.vmall.com/forum-2849-1.html";
            case 15:
                return "http://club.huawei.com/forum-2848-1.html";
            default:
                return "http://cn.club.vmall.com/forum-530-1.html";
        }
    }
}
