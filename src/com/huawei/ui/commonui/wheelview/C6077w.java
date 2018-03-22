package com.huawei.ui.commonui.wheelview;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.ui.commonui.wheelview.p515a.C6055b;
import java.util.List;

/* compiled from: WheelCalendarPicker */
class C6077w implements C5691c {
    final /* synthetic */ List f20983a;
    final /* synthetic */ List f20984b;
    final /* synthetic */ C6069o f20985c;

    C6077w(C6069o c6069o, List list, List list2) {
        this.f20985c = c6069o;
        this.f20983a = list;
        this.f20984b = list2;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int i3 = i2 + 1;
        if (this.f20983a.contains(String.valueOf(i3))) {
            this.f20985c.f20967f.setAdapter(new C6055b(1, 31, "%02d"));
        } else if (this.f20984b.contains(String.valueOf(i3))) {
            if (this.f20985c.f20967f.getCurrentItem() == 30) {
                this.f20985c.f20967f.setCurrentItem(29);
            }
            this.f20985c.f20967f.setAdapter(new C6055b(1, 30, "%02d"));
        } else if (((this.f20985c.f20965d.getCurrentItem() + C6069o.f20960g) % 4 != 0 || (this.f20985c.f20965d.getCurrentItem() + C6069o.f20960g) % 100 == 0) && (this.f20985c.f20965d.getCurrentItem() + C6069o.f20960g) % HttpStatus.SC_BAD_REQUEST != 0) {
            if (this.f20985c.f20967f.getCurrentItem() == 30 || this.f20985c.f20967f.getCurrentItem() == 29 || this.f20985c.f20967f.getCurrentItem() == 28) {
                this.f20985c.f20967f.setCurrentItem(27);
            }
            this.f20985c.f20967f.setAdapter(new C6055b(1, 28, "%02d"));
        } else {
            if (this.f20985c.f20967f.getCurrentItem() == 30 || this.f20985c.f20967f.getCurrentItem() == 29) {
                this.f20985c.f20967f.setCurrentItem(28);
            }
            this.f20985c.f20967f.setAdapter(new C6055b(1, 29, "%02d"));
        }
        if (this.f20985c.f20971l != null) {
            this.f20985c.f20971l.onChanged(wheelView, i, i2);
        }
    }
}
