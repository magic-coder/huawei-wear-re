package com.huawei.pluginkidwatch.common.ui.p150a;

import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import java.util.Date;

/* compiled from: CalendarDialogUtil */
final class C1502c implements C1501j {
    final /* synthetic */ TextView f3514a;
    final /* synthetic */ ImageView f3515b;

    C1502c(TextView textView, ImageView imageView) {
        this.f3514a = textView;
        this.f3515b = imageView;
    }

    public void mo2516a(Date date) {
        Object a = C1485e.m6849a(date, "yyyy年MM月");
        this.f3514a.setText(a);
        if (C1485e.m6861c().startsWith(a)) {
            this.f3515b.setEnabled(false);
        } else {
            this.f3515b.setEnabled(true);
        }
    }
}
