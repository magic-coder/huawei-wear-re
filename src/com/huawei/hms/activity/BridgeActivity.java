package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.huawei.hms.p037a.C0826a.C0825a;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.InvocationTargetException;

public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_EX_NAME = "intent.extra.DELEGATE_CLASS_OBJECT_EX";
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";
    private C0827a f1295a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2917a();
        if (!m2919b()) {
            setResult(1, null);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1295a != null) {
            this.f1295a.mo2237a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1295a != null) {
            this.f1295a.mo2241b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f1295a != null && !this.f1295a.mo2240a(i, i2, intent) && !isFinishing()) {
            setResult(i2, intent);
            finish();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1295a != null) {
            this.f1295a.mo2238a(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void finish() {
        C0887a.m3094b("BridgeActivity", "Enter finish.");
        super.finish();
    }

    private void m2917a() {
        requestWindowFeature(1);
        if (C0825a.f1293a >= 9) {
            Window window = getWindow();
            window.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            m2918a(window, true);
        }
    }

    private boolean m2919b() {
        Exception e;
        Intent intent = getIntent();
        if (intent == null) {
            C0887a.m3098d("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
        if (stringExtra == null) {
            C0887a.m3098d("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        }
        try {
            this.f1295a = (C0827a) Class.forName(stringExtra).asSubclass(C0827a.class).newInstance();
            this.f1295a.mo2239a((Activity) this, true);
            return true;
        } catch (ClassCastException e2) {
            e = e2;
            C0887a.m3098d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (InstantiationException e3) {
            e = e3;
            C0887a.m3098d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (IllegalAccessException e4) {
            e = e4;
            C0887a.m3098d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        } catch (ClassNotFoundException e5) {
            e = e5;
            C0887a.m3098d("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
            return false;
        }
    }

    private static void m2918a(Window window, boolean z) {
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
        C0887a.m3098d("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e.getMessage());
    }
}
