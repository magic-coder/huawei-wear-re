package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.az;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int f264a = 0;

    public static PendingIntent m327a(Context context, PendingIntent pendingIntent, int i) {
        return m328a(context, pendingIntent, i, true);
    }

    public static PendingIntent m328a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, m331b(context, pendingIntent, i, z), HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    private void m329a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f264a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            C0389b.m424a().m443b(this, num.intValue(), 2, this);
            this.f264a = 1;
        }
    }

    private void m330a(int i, az azVar) {
        switch (i) {
            case -1:
                azVar.m1032c();
                return;
            case 0:
                azVar.m1030b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                return;
            default:
                return;
        }
    }

    public static Intent m331b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void m332a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f264a = 0;
            m332a(i2);
            if (booleanExtra) {
                m330a(i2, az.m1002a((Context) this));
            }
        } else if (i == 2) {
            this.f264a = 0;
            m332a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f264a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f264a = bundle.getInt("resolution");
        }
        if (this.f264a != 1) {
            m329a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f264a);
        super.onSaveInstanceState(bundle);
    }
}
