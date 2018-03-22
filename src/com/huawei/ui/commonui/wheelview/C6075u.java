package com.huawei.ui.commonui.wheelview;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.ui.commonui.wheelview.p515a.C6055b;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: WheelCalendarPicker */
class C6075u implements C5691c {
    final /* synthetic */ List f20979a;
    final /* synthetic */ List f20980b;
    final /* synthetic */ C6069o f20981c;

    C6075u(C6069o c6069o, List list, List list2) {
        this.f20981c = c6069o;
        this.f20979a = list;
        this.f20980b = list2;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int d = C6069o.f20960g + i2;
        if (this.f20979a.contains(String.valueOf(this.f20981c.f20966e.getCurrentItem() + 1))) {
            this.f20981c.f20967f.setAdapter(new C6055b(1, 31, "%02d"));
        } else if (this.f20980b.contains(String.valueOf(this.f20981c.f20966e.getCurrentItem() + 1))) {
            this.f20981c.f20967f.setAdapter(new C6055b(1, 30, "%02d"));
        } else if ((d % 4 != 0 || d % 100 == 0) && d % HttpStatus.SC_BAD_REQUEST != 0) {
            if (this.f20981c.f20967f.getCurrentItem() == 28) {
                this.f20981c.f20967f.setCurrentItem(27);
            }
            this.f20981c.f20967f.setAdapter(new C6055b(1, 28, "%02d"));
        } else {
            if (this.f20981c.f20967f.getCurrentItem() == 29) {
                this.f20981c.f20967f.setCurrentItem(28);
            }
            this.f20981c.f20967f.setAdapter(new C6055b(1, 29, "%02d"));
        }
        C2538c.c("WheelCalendarPicker", new Object[]{"setYearListener() year_num = " + d});
        if (this.f20981c.f20971l != null) {
            this.f20981c.f20971l.onChanged(wheelView, i, i2);
        }
    }
}
