package com.huawei.ui.main.stories.about.activity;

import com.huawei.crowdtestsdk.bases.LogCollectedResult;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity.FeedbackCallback;
import com.huawei.hwappdfxmgr.f.c;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: AboutActivity */
class C2327q implements FeedbackCallback {
    final /* synthetic */ AboutActivity f8416a;

    C2327q(AboutActivity aboutActivity) {
        this.f8416a = aboutActivity;
    }

    public void onFailed(String str) {
        C2538c.m12674b("AboutActivity", "gotoFeedBack failed");
    }

    public LogCollectedResult collectLogs() {
        LogCollectedResult logCollectedResult = new LogCollectedResult();
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.a + "com.huawei.bone");
        arrayList.add(c.a + "com.huawei.bone_temp");
        arrayList.add(c.a + "com.huawei.version.txt");
        logCollectedResult.setLogPath(arrayList);
        logCollectedResult.setStatus(200);
        this.f8416a.f8303D.sendEmptyMessageDelayed(10, 5000);
        return logCollectedResult;
    }
}
