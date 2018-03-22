package com.huawei.pluginkidwatch.common.ui.view;

import com.android.volley.DefaultRetryPolicy;

/* compiled from: WaveView */
class ao implements Runnable {
    final /* synthetic */ WaveView f3863a;

    private ao(WaveView waveView) {
        this.f3863a = waveView;
    }

    public void run() {
        synchronized (this.f3863a) {
            this.f3863a.f3819h = (int) (((float) this.f3863a.f3817f) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f3863a.f3820i));
            this.f3863a.m7209a();
            this.f3863a.invalidate();
            this.f3863a.postDelayed(this, 100);
        }
    }
}
