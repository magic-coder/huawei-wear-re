package com.huawei.pluginkidwatch.plugin.chat;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.view.C1574j;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatAdapter */
class au extends C1574j {
    final /* synthetic */ int f4836a;
    final /* synthetic */ int f4837b;
    final /* synthetic */ as f4838c;

    au(as asVar, int i, int i2, int i3) {
        this.f4838c = asVar;
        this.f4836a = i2;
        this.f4837b = i3;
        super(i);
    }

    public void mo2597a(Bitmap bitmap) {
        if (this.f4838c.f4825a != null && this.f4836a < this.f4838c.f4825a.size()) {
            C2538c.m12674b("ChatAdapter", "  ==================从网络下载-->成功");
            ((C1744a) this.f4838c.f4825a.get(this.f4837b)).f4779n = bitmap;
            this.f4838c.notifyDataSetChanged();
        }
    }
}
