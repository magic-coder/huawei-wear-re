package com.huawei.ui.main.stories.about.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.huawei.p190v.C2538c;

/* compiled from: AboutActivity */
class C2324n extends BroadcastReceiver {
    boolean f8412a = false;
    final /* synthetic */ AboutActivity f8413b;

    C2324n(AboutActivity aboutActivity) {
        this.f8413b = aboutActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            C2538c.m12677c("AboutActivity", "mWifiBroadcastReceiver----onReceive intent =" + intent.getAction());
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                    if (parcelableExtra != null) {
                        boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                        if (z != this.f8412a) {
                            this.f8412a = z;
                            if (!z) {
                                this.f8413b.f8303D.post(new C2325o(this));
                            }
                        }
                    }
                } catch (TypeNotPresentException e) {
                    C2538c.m12680e("AboutActivity", "(NetworkInfo) parcelableExtra error" + e.getMessage());
                } catch (ClassCastException e2) {
                    C2538c.m12680e("AboutActivity", "(NetworkInfo) parcelableExtra error" + e2.getMessage());
                }
            }
        }
    }
}
