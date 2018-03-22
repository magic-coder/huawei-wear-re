package com.huawei.nfc.carrera.logic.security;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import com.huawei.ai.C4015d;
import com.huawei.ai.C4017f;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class FpPasswordInstructionVerifier implements C4015d, C4017f {
    public static final int CHECK_VALID_FP_PSW_VALIDE = 1;
    private CheckFpPasswdCallback checkFpPswCallback;
    private Context mContext;

    public FpPasswordInstructionVerifier(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
    }

    public int checkValidFpPassword() {
        LogX.i("checkValidFpPassword");
        return 1;
    }

    public void startCheckFpPassword(CheckFpPasswdCallback checkFpPasswdCallback) {
        LogX.i("startCheckFpPassword");
        this.checkFpPswCallback = checkFpPasswdCallback;
        identifyFpPassword();
    }

    private void identifyFpPassword() {
    }

    public void release() {
    }

    public void onIdentified(int i, byte[] bArr, boolean z) {
        LogX.i("onIdentified: " + i, false);
        String str = null;
        if (bArr != null) {
            str = Base64.encodeToString(bArr, 10);
        }
        if (!StringUtil.isEmpty(str, true)) {
            LogX.i("onIdentified: OK", false);
            if (this.checkFpPswCallback != null) {
                this.checkFpPswCallback.onCheckResult(10);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "onIdentified OK, but check callback is null");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_VERIFY_FINFER_FAIL, hashMap, (String) hashMap.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
        }
    }

    public void onNoMatch(int i) {
    }

    public void onCaptureCompleted() {
        LogX.d("onCaptureCompleted");
    }

    public void onInput() {
        LogX.d("onInput");
        if (this.checkFpPswCallback != null) {
            this.checkFpPswCallback.onChecking(2);
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "onInput, but check callback is null");
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_VERIFY_FINFER_FAIL, hashMap, (String) hashMap.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
    }

    public void onWaitingForInput() {
        LogX.d("onWaitingForInput");
        if (this.checkFpPswCallback != null) {
            this.checkFpPswCallback.onChecking(1);
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "onWaitingForInput, but check callback is null");
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_VERIFY_FINFER_FAIL, hashMap, (String) hashMap.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
    }
}
