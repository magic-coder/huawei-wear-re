package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationHistoryActivity */
class fe implements OnScrollListener {
    final /* synthetic */ NotificationHistoryActivity f6115a;

    fe(NotificationHistoryActivity notificationHistoryActivity) {
        this.f6115a = notificationHistoryActivity;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int d;
        C2538c.m12674b("NotificationHistoryActivity", "totalItemCount=" + i3);
        if (this.f6115a.f5789j % this.f6115a.f5788i == 0) {
            d = this.f6115a.f5789j / this.f6115a.f5788i;
        } else {
            d = (this.f6115a.f5789j / this.f6115a.f5788i) + 1;
        }
        if (this.f6115a.f5781b.getLastVisiblePosition() + 1 == i3 && i3 > 0) {
            if (((i3 - this.f6115a.f5786g) % this.f6115a.f5788i == 0 ? (i3 - this.f6115a.f5786g) / this.f6115a.f5788i : ((i3 - this.f6115a.f5786g) / this.f6115a.f5788i) + 1) + 1 <= d && this.f6115a.f5791l) {
                this.f6115a.f5791l = false;
                this.f6115a.f5781b.addFooterView(this.f6115a.f5790k);
                this.f6115a.f5792m.postDelayed(new ff(this), 2000);
            }
        }
    }
}
