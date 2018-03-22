package com.huawei.pluginkidwatch.common.ui.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: CalendarViewPager */
class C1580o extends Handler {
    final /* synthetic */ CalendarViewPager f3915a;

    C1580o(CalendarViewPager calendarViewPager) {
        this.f3915a = calendarViewPager;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (this.f3915a != null) {
                    this.f3915a.setCurrentItem(1, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
