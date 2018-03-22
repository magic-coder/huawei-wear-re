package com.huawei.pluginkidwatch.plugin.menu.activity;

/* compiled from: NotificationHistoryActivity */
class ff implements Runnable {
    final /* synthetic */ fe f6116a;

    ff(fe feVar) {
        this.f6116a = feVar;
    }

    public void run() {
        this.f6116a.f6115a.m9463f();
        this.f6116a.f6115a.f5784e.notifyDataSetChanged();
        if (this.f6116a.f6115a.f5781b.getFooterViewsCount() > 0) {
            this.f6116a.f6115a.f5781b.removeFooterView(this.f6116a.f6115a.f5790k);
            this.f6116a.f6115a.f5791l = true;
        }
    }
}
