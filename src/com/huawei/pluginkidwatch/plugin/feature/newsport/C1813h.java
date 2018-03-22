package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: NewSportActivity */
class C1813h extends Handler {
    final /* synthetic */ NewSportActivity f5007a;

    C1813h(NewSportActivity newSportActivity) {
        this.f5007a = newSportActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.m12674b("NewSportActivity", "mViewHandler... DynamicViewPagerAdapter.MSG_DELAY_LOAD_DATA = 1");
                if (message.arg1 == NewSportActivity.f4966c) {
                    this.f5007a.m8626a(((Long) message.obj).longValue(), false);
                    return;
                } else {
                    this.f5007a.m8625a(((Long) message.obj).longValue());
                    return;
                }
            case 2:
                C2538c.m12674b("NewSportActivity", "mViewHandler... DynamicViewPagerAdapter.MSG_SET_CURRENT_ITEM = 2");
                if (this.f5007a.f4974j != null) {
                    this.f5007a.f4974j.setCurrentItem(1, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
