package com.huawei.pluginkidwatch.common.ui.p150a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.g;

/* compiled from: CalendarDialogUtil */
final class C1504e implements OnClickListener {
    C1504e() {
    }

    public void onClick(View view) {
        if (g.calender_pre == view.getId()) {
            C1500b.f3511a.setCurrentItem(C1500b.f3511a.getCurrentItem() - 1);
        } else if (g.calender_next == view.getId()) {
            C1500b.f3511a.setCurrentItem(C1500b.f3511a.getCurrentItem() + 1);
        }
    }
}
