package com.huawei.ui.commonui.wheelview;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.ui.commonui.wheelview.p515a.C6055b;
import java.util.List;

/* compiled from: WheelCalendarPicker */
class C6078x implements C5691c {
    final /* synthetic */ List f20986a;
    final /* synthetic */ List f20987b;
    final /* synthetic */ C6069o f20988c;

    C6078x(C6069o c6069o, List list, List list2) {
        this.f20988c = c6069o;
        this.f20986a = list;
        this.f20987b = list2;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int d = C6069o.f20960g + i2;
        if (this.f20986a.contains(String.valueOf(this.f20988c.f20966e.getCurrentItem() + 1))) {
            this.f20988c.f20967f.setAdapter(new C6055b(1, 31, "%02d"));
        } else if (this.f20987b.contains(String.valueOf(this.f20988c.f20966e.getCurrentItem() + 1))) {
            this.f20988c.f20967f.setAdapter(new C6055b(1, 30, "%02d"));
        } else if ((d % 4 != 0 || d % 100 == 0) && d % HttpStatus.SC_BAD_REQUEST != 0) {
            if (this.f20988c.f20967f.getCurrentItem() == 28) {
                this.f20988c.f20967f.setCurrentItem(27);
            }
            this.f20988c.f20967f.setAdapter(new C6055b(1, 28, "%02d"));
        } else {
            if (this.f20988c.f20967f.getCurrentItem() == 29) {
                this.f20988c.f20967f.setCurrentItem(28);
            }
            this.f20988c.f20967f.setAdapter(new C6055b(1, 29, "%02d"));
        }
        if (this.f20988c.f20971l != null) {
            this.f20988c.f20971l.onChanged(wheelView, i, i2);
        }
    }
}
