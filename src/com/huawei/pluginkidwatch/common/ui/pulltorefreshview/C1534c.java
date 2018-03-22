package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: PullToRefreshLayout */
class C1534c extends Handler {
    final /* synthetic */ PullToRefreshLayout f3640a;

    C1534c(PullToRefreshLayout pullToRefreshLayout) {
        this.f3640a = pullToRefreshLayout;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f3640a.f3614b = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / ((double) this.f3640a.getMeasuredHeight())) * ((double) (this.f3640a.f3613a + Math.abs(this.f3640a.f3620h))))));
        if (!this.f3640a.f3624l && this.f3640a.f3616d == 2 && this.f3640a.f3613a <= this.f3640a.f3621i) {
            this.f3640a.f3613a = this.f3640a.f3621i;
            this.f3640a.f3622j.m7066a();
        }
        if (this.f3640a.f3613a > 0.0f) {
            PullToRefreshLayout pullToRefreshLayout = this.f3640a;
            pullToRefreshLayout.f3613a -= this.f3640a.f3614b;
        } else if (this.f3640a.f3620h < 0.0f) {
            this.f3640a.f3620h = this.f3640a.f3620h + this.f3640a.f3614b;
        }
        if (this.f3640a.f3613a < 0.0f) {
            this.f3640a.f3613a = 0.0f;
            this.f3640a.f3629q.clearAnimation();
            if (!(this.f3640a.f3616d == 2 || this.f3640a.f3616d == 4)) {
                this.f3640a.m7051b(0);
            }
            this.f3640a.f3622j.m7066a();
            this.f3640a.requestLayout();
        }
        if (this.f3640a.f3620h > 0.0f) {
            this.f3640a.f3620h = 0.0f;
            if (!(this.f3640a.f3616d == 2 || this.f3640a.f3616d == 4)) {
                this.f3640a.m7051b(0);
            }
            this.f3640a.f3622j.m7066a();
            this.f3640a.requestLayout();
        }
        Log.d("handle", "handle");
        this.f3640a.requestLayout();
        if (this.f3640a.f3613a + Math.abs(this.f3640a.f3620h) == 0.0f) {
            this.f3640a.f3622j.m7066a();
        }
    }
}
