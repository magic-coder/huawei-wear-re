package com.google.analytics.tracking.android;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import java.io.OutputStream;

public class CampaignTrackingService extends IntentService {
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }

    public void onHandleIntent(Intent intent) {
        m18201a(this, intent);
    }

    public void m18201a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        try {
            OutputStream openFileOutput = context.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            ar.m18264a("Error storing install campaign.");
        }
    }
}
