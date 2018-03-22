package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.graphics.Bitmap;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.ui.view.C1574j;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;

/* compiled from: ContactListAdapter */
class C1836g extends C1574j {
    final /* synthetic */ int f5277a;
    final /* synthetic */ C1835f f5278b;

    C1836g(C1835f c1835f, int i, int i2) {
        this.f5278b = c1835f;
        this.f5277a = i2;
        super(i);
    }

    public void mo2597a(Bitmap bitmap) {
        if (this.f5278b.f5273a != null && this.f5277a < this.f5278b.f5273a.size()) {
            ((Contact) this.f5278b.f5273a.get(this.f5277a)).bitmapStr = C1906x.m9704b(bitmap);
            this.f5278b.notifyDataSetChanged();
        }
    }
}
