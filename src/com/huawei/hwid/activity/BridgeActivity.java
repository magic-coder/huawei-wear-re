package com.huawei.hwid.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p423a.C5061a.C5060a;
import java.lang.reflect.InvocationTargetException;

public class BridgeActivity extends Activity {
    private C5063a f18279a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m24366a();
        if (!m24368b()) {
            setResult(1, null);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f18279a != null) {
            this.f18279a.mo4667a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f18279a != null) {
            this.f18279a.mo4672b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f18279a != null && !this.f18279a.mo4671a(i, i2, intent) && !isFinishing()) {
            setResult(i2, intent);
            finish();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f18279a != null) {
            this.f18279a.mo4668a(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void finish() {
        C5165e.m24906b("BridgeActivity", "Enter finish.");
        super.finish();
    }

    private void m24366a() {
        requestWindowFeature(1);
        if (C5060a.f18271a >= 9) {
            Window window = getWindow();
            window.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            m24367a(window, true);
        }
    }

    private boolean m24368b() {
        Exception e;
        Intent intent = getIntent();
        if (intent == null) {
            C5165e.m24910d("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        String stringExtra = intent.getStringExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME);
        if (stringExtra == null) {
            C5165e.m24910d("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        }
        try {
            this.f18279a = (C5063a) Class.forName(stringExtra).asSubclass(C5063a.class).newInstance();
            this.f18279a.mo4669a((Activity) this, true);
            return true;
        } catch (ClassCastException e2) {
            e = e2;
            C5165e.m24910d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (InstantiationException e3) {
            e = e3;
            C5165e.m24910d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (IllegalAccessException e4) {
            e = e4;
            C5165e.m24910d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (ClassNotFoundException e5) {
            e = e5;
            C5165e.m24910d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        }
    }

    private static void m24367a(Window window, boolean z) {
        Exception e;
        try {
            window.getClass().getMethod("setHwFloating", new Class[]{Boolean.TYPE}).invoke(window, new Object[]{Boolean.valueOf(z)});
            return;
        } catch (NoSuchMethodException e2) {
            e = e2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (IllegalArgumentException e4) {
            e = e4;
        } catch (InvocationTargetException e5) {
            e = e5;
        }
        C5165e.m24910d("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e.getMessage());
    }
}
