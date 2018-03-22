package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.graphics.Bitmap;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.ui.view.C1574j;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;

/* compiled from: ContactManagerListAdapter */
class C1839j extends C1574j {
    final /* synthetic */ int f5286a;
    final /* synthetic */ C1838i f5287b;

    C1839j(C1838i c1838i, int i, int i2) {
        this.f5287b = c1838i;
        this.f5286a = i2;
        super(i);
    }

    public void mo2597a(Bitmap bitmap) {
        if (this.f5287b.f5282a != null && this.f5286a < this.f5287b.f5282a.size()) {
            ((UserInfo) this.f5287b.f5282a.get(this.f5286a)).bitmapStr = C1906x.m9704b(bitmap);
            this.f5287b.notifyDataSetChanged();
        }
    }
}
