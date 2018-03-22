package com.huawei.pluginkidwatch.plugin.chat;

import com.amap.api.maps.model.WeightedLatLng;

/* compiled from: ChatActivity */
class C1766t implements Runnable {
    final /* synthetic */ ChatActivity f4859a;

    C1766t(ChatActivity chatActivity) {
        this.f4859a = chatActivity;
    }

    public void run() {
        if (this.f4859a.f4706N != null) {
            double maxAmplitude = (double) this.f4859a.f4706N.getMaxAmplitude();
            double d = 0.0d;
            if (maxAmplitude > WeightedLatLng.DEFAULT_INTENSITY) {
                d = 20.0d * Math.log10(maxAmplitude);
            }
            int e = this.f4859a.m8387b((int) d);
            this.f4859a.f4718Z[3] = this.f4859a.f4718Z[2];
            this.f4859a.f4718Z[2] = this.f4859a.f4718Z[1];
            this.f4859a.f4718Z[1] = this.f4859a.f4718Z[0];
            this.f4859a.f4718Z[0] = e;
            this.f4859a.m8431j();
            this.f4859a.ay.removeCallbacks(this.f4859a.aC);
            this.f4859a.ay.postDelayed(this.f4859a.aC, 100);
        }
    }
}
