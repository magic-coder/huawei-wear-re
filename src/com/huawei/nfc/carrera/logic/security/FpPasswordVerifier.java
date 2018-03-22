package com.huawei.nfc.carrera.logic.security;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import com.huawei.ai.C4015d;
import com.huawei.ai.C4017f;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.p130e.p490d.C5733c;
import com.huawei.pay.p484c.p485a.C5724a;
import java.util.HashMap;
import java.util.Map;

public class FpPasswordVerifier implements C4015d, C4017f {
    public static final int CHECK_VALID_FP_PSW_FP_AUTH_DISABLED = -4;
    public static final int CHECK_VALID_FP_PSW_FP_UNAVAILABLE = -3;
    public static final int CHECK_VALID_FP_PSW_NO_FP_PSW = -1;
    public static final int CHECK_VALID_FP_PSW_NO_SYS_FP = -2;
    public static final int CHECK_VALID_FP_PSW_VALIDE = 1;
    private static final int FINGER_ERROR_NUM = 5;
    private C5733c innerTimeKeeper;
    private Context mContext;
    private int mRemainErrorNum = 5;

    public FpPasswordVerifier(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.mRemainErrorNum = getSpRemainErrorNum();
        this.mRemainErrorNum = getFailedNum();
        setSpRemainErrorNum(this.mRemainErrorNum);
        initInnerTimeKeeper();
    }

    private int getSpRemainErrorNum() {
        return C5724a.m26386a(this.mContext).m26388a("finger_remain_error_time", 5);
    }

    private void setSpRemainErrorNum(int i) {
        if (i >= 0) {
            C5724a.m26386a(this.mContext).m26391b("finger_remain_error_time", i);
        }
    }

    private void initInnerTimeKeeper() {
        if (this.innerTimeKeeper == null) {
            this.innerTimeKeeper = C5733c.m26413a(this.mContext, "finger");
        }
    }

    public final int getFailedNum() {
        return this.mRemainErrorNum;
    }

    public long getFailedTime() {
        return -1;
    }

    public int checkValidFpPassword() {
        LogX.i("checkValidFpPassword");
        return -1;
    }

    public void startCheckFpPassword(CheckFpPasswdCallback checkFpPasswdCallback) {
    }

    public void release() {
        LogX.i("release");
    }

    private int getCurFingerPrintId() {
        Map hashMap;
        try {
            return WalletTaManager.getInstance(this.mContext).getFingerId();
        } catch (WalletTaFingerIdNotExistException e) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get finger id failed, finger id is not exist");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_OPEN_FINFER_FAIL, hashMap, (String) hashMap.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
            return -1;
        } catch (WalletTaSystemErrorException e2) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get finger id failed, system error");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_OPEN_FINFER_FAIL_SYSTEM_ERROR, hashMap, (String) hashMap.get(ShowBindBusResultActivity.FAIL_REASON_KEY), false, false);
            return -1;
        }
    }

    public void onIdentified(int i, byte[] bArr, boolean z) {
        LogX.i("onIdentified: " + i, false);
        int curFingerPrintId = getCurFingerPrintId();
        String str = null;
        if (bArr != null) {
            str = Base64.encodeToString(bArr, 10);
        }
        if (StringUtil.isEmpty(str, true) || i != curFingerPrintId) {
            LogX.i("onIdentified: OK ，but not the wallet's fingerId", false);
        } else {
            LogX.i("onIdentified: OK", false);
        }
    }

    public void onNoMatch(int i) {
        LogX.i("onNoMatch: " + i, false);
    }

    public void resetSpErrorNum(boolean z) {
        this.mRemainErrorNum = 5;
        if (z) {
            this.mRemainErrorNum = getFailedNum();
        }
        setSpRemainErrorNum(this.mRemainErrorNum);
    }

    public void onCaptureCompleted() {
        LogX.d("onCaptureCompleted");
    }

    public void onInput() {
        LogX.d("onInput");
    }

    public void onWaitingForInput() {
        LogX.d("onWaitingForInput");
    }
}
