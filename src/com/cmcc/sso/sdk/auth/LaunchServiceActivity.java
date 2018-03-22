package com.cmcc.sso.sdk.auth;

import android.app.Activity;
import android.os.Bundle;
import com.cmcc.sso.p011a.C0324d;
import com.cmcc.sso.sdk.p013b.C0327a;

public class LaunchServiceActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0327a.m200a("onCreate...");
        new C0324d(this).m193c();
        C0327a.m200a(getPackageName() + "launch activity started...");
        finish();
    }
}
