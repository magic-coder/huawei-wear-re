package com.google.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            C3700z.m18627c("Preview activity");
            Uri data = getIntent().getData();
            if (!be.m18516a((Context) this).m18520a(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                C3700z.m18626b(str);
                m18414a("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                C3700z.m18627c("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            C3700z.m18627c("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            C3700z.m18624a("Calling preview threw an exception: " + e.getMessage());
        }
    }

    private void m18414a(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new al(this));
        create.show();
    }
}
