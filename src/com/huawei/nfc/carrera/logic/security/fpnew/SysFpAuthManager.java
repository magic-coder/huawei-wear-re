package com.huawei.nfc.carrera.logic.security.fpnew;

import com.huawei.ai.C4010a;
import com.huawei.nfc.carrera.util.LogX;

public class SysFpAuthManager {
    private static C4010a authenticationManager;

    static C4010a getAuthenticationManager() {
        boolean z = true;
        LogX.i("getAuthenticationManager");
        if (authenticationManager != null) {
            LogX.e("getAuthenticationManager, but the manager is occupied.");
            return null;
        }
        authenticationManager = C4010a.m19772a(1);
        StringBuilder append = new StringBuilder().append("getAuthenticationManager, authenticationManager got is null: ");
        if (authenticationManager != null) {
            z = false;
        }
        LogX.d(append.append(z).toString());
        return authenticationManager;
    }

    static void releaseAuthenticationManager() {
        LogX.i("releaseAuthenticationManager");
        if (authenticationManager == null) {
            LogX.e("releaseAuthenticationManager, but no manager got.");
            return;
        }
        authenticationManager.m19780a();
        authenticationManager = null;
    }
}
