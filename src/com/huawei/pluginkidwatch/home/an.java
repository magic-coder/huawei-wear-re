package com.huawei.pluginkidwatch.home;

/* compiled from: HomeActivity */
class an implements Runnable {
    final /* synthetic */ HomeActivity f4179a;

    an(HomeActivity homeActivity) {
        this.f4179a = homeActivity;
    }

    public void run() {
        if (HomeActivity.f4103g) {
            this.f4179a.m7596h(HomeActivity.f4103g);
            HomeActivity.f4103g = false;
            this.f4179a.f4131c.removeCallbacks(this);
            return;
        }
        this.f4179a.m7596h(HomeActivity.f4103g);
        HomeActivity.f4103g = true;
        this.f4179a.f4131c.postDelayed(this, 20000);
    }
}
