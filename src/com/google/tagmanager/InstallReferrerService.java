package com.google.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService f14223a;
    Context f14224b;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.f14224b != null ? this.f14224b : getApplicationContext();
        C3699y.m18621a(applicationContext, stringExtra);
        m18413a(applicationContext, intent);
    }

    private void m18413a(Context context, Intent intent) {
        if (this.f14223a == null) {
            this.f14223a = new CampaignTrackingService();
        }
        this.f14223a.m18201a(context, intent);
    }
}
