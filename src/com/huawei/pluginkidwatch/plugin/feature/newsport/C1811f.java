package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.os.Handler;
import android.view.View;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1498r;
import com.huawei.pluginkidwatch.common.ui.p150a.C1510l;
import com.huawei.pluginkidwatch.plugin.feature.newsport.p163a.C1804a;
import com.huawei.pluginkidwatch.plugin.feature.newsport.view.C1817b;
import java.util.Date;
import java.util.List;

/* compiled from: NewSportActivity */
class C1811f extends C1804a<C1817b> {
    final /* synthetic */ NewSportActivity f5005a;

    C1811f(NewSportActivity newSportActivity, List list, C1510l c1510l, Handler handler) {
        this.f5005a = newSportActivity;
        super(list, c1510l, handler);
    }

    public /* synthetic */ View mo2601b(int i) {
        return m8650a(i);
    }

    public /* synthetic */ View mo2602b(int i, Date date) {
        return m8651a(i, date);
    }

    public void m8653a(C1817b c1817b, Date date) {
        C2538c.m12674b("NewSportActivity", "resetSportData...  date = " + date.toString());
        if (c1817b != null) {
            c1817b.m8679a();
        }
    }

    public C1817b m8651a(int i, Date date) {
        C2538c.m12674b("NewSportActivity", "resetSportData... position = " + i + " date = " + date.toString());
        return this.f5005a.m8606a(i, date);
    }

    public C1817b m8650a(int i) {
        C2538c.m12674b("NewSportActivity", "getItemView... index = " + i);
        return this.f5005a.m8623a(i);
    }

    public void mo2600a(Date date) {
        C2538c.m12674b("NewSportActivity", "setToday... date = " + date.toString());
        this.f5005a.f4967b = date;
        this.f5005a.f4972h.setText(C1498r.m6960a(date, this.f5005a.f4979o));
        if (C1485e.m6861c().equals(C1498r.m6960a(date, this.f5005a.f4979o))) {
            this.f5005a.f4969e.setEnabled(false);
            this.f5005a.f4970f.setVisibility(8);
            return;
        }
        this.f5005a.f4969e.setEnabled(true);
        this.f5005a.f4970f.setVisibility(0);
    }
}
