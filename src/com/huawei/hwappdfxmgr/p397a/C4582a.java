package com.huawei.hwappdfxmgr.p397a;

import android.content.Context;
import com.huawei.crowdtestsdk.api.CrowdTestApi;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity.FeedbackCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;

/* compiled from: HWCrowdApi */
public class C4582a {
    private static C4582a f16785a;
    private static final Object f16786b = new Object();

    private C4582a() {
    }

    public static C4582a m21849a() {
        C4582a c4582a;
        synchronized (f16786b) {
            if (f16785a == null) {
                f16785a = new C4582a();
            }
            c4582a = f16785a;
        }
        return c4582a;
    }

    public void m21850a(Context context, FeedbackParams feedbackParams, FeedbackCallback feedbackCallback) {
        int parseInt;
        CloudLoginBean cloudLoginBean = new CloudLoginBean();
        cloudLoginBean.setAppID(context.getPackageName());
        cloudLoginBean.setSiteId(String.valueOf(a.a(BaseApplication.b()).e()));
        cloudLoginBean.setServiceToken(a.a(BaseApplication.b()).g());
        cloudLoginBean.setDeviceId(C5433c.m26039a(context).m26056e());
        try {
            String f = C5433c.m26039a(context).m26058f();
            if (f != null) {
                parseInt = Integer.parseInt(f);
                cloudLoginBean.setDeviceType(Integer.valueOf(parseInt));
                cloudLoginBean.setUserName(C5433c.m26039a(context).m26054d());
                cloudLoginBean.setTerminalType("Android");
                cloudLoginBean.setLoginChannel(Integer.valueOf(39000000));
                C2538c.b("HWCrowdApi", new Object[]{"siteID:" + r3 + " sToken :" + r4 + " deviceId:" + r5 + " deviceType: " + parseInt + " accountName:" + r6});
                CrowdTestApi.getInstance().gotoFeedback(context, cloudLoginBean, feedbackParams, feedbackCallback);
            }
        } catch (Exception e) {
            C2538c.e("HWCrowdApi", new Object[]{"exception:" + e.getMessage()});
        }
        parseInt = 0;
        cloudLoginBean.setDeviceType(Integer.valueOf(parseInt));
        cloudLoginBean.setUserName(C5433c.m26039a(context).m26054d());
        cloudLoginBean.setTerminalType("Android");
        cloudLoginBean.setLoginChannel(Integer.valueOf(39000000));
        C2538c.b("HWCrowdApi", new Object[]{"siteID:" + r3 + " sToken :" + r4 + " deviceId:" + r5 + " deviceType: " + parseInt + " accountName:" + r6});
        CrowdTestApi.getInstance().gotoFeedback(context, cloudLoginBean, feedbackParams, feedbackCallback);
    }
}
