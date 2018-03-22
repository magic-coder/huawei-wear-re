package com.huawei.nfc.carrera.logic.security.fingerprint;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.ai.C4010a;
import com.huawei.ai.C4015d;
import com.huawei.ai.C4017f;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.utils.PhoneDeviceUtil;
import com.huawei.wallet.utils.TimeUtil;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

public final class FingerPrintManager {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final int TYPE_NO_MATCH_AUTH = 2001;
    private static final int TYPE_NO_MATCH_CATCH_EXCEPTION = 2006;
    private static final int TYPE_NO_MATCH_IDENTIFING = 2005;
    private static final int TYPE_NO_MATCH_INTERRUPT = 2004;
    private static final int TYPE_NO_MATCH_IO_EXCEPTION = 2003;
    private static final int TYPE_NO_MATCH_NO_MODEL = 2002;
    private static FingerPrintManager instance = null;
    private C4010a authenticationManager = C4010a.m19772a(1);

    private FingerPrintManager() {
    }

    public static boolean isNeedReCreateFingerPrintAuth(int i) {
        LogX.i("isNeedReCreateFingerPrintAuth id::" + i, false);
        if (i == 2001 || i == 2003 || i == 2005 || i == 2006) {
            return true;
        }
        return false;
    }

    public static boolean isFingerPrintAuthFail(int i) {
        if (2001 == i || 2003 == i || 2004 == i || 2006 == i) {
            return true;
        }
        return false;
    }

    public static FingerPrintManager getInstance() {
        FingerPrintManager fingerPrintManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new FingerPrintManager();
            }
            fingerPrintManager = instance;
        }
        return fingerPrintManager;
    }

    public static FingerPrintManager getFingerPrintManager() {
        return instance;
    }

    public static C4010a getAuthFpManager() {
        if (instance != null) {
            return instance.authenticationManager;
        }
        return null;
    }

    public void release() {
        if (this.authenticationManager != null) {
            this.authenticationManager.m19780a();
            this.authenticationManager = null;
        }
    }

    public void abortAndRelease() {
        abort();
        release();
    }

    public void abort() {
        if (this.authenticationManager != null) {
            this.authenticationManager.m19783c();
        }
    }

    public C4010a getAuthenticationManager() {
        return this.authenticationManager;
    }

    public int[] getAllSupportFpId() {
        int[] iArr = null;
        if (this.authenticationManager != null) {
            iArr = this.authenticationManager.m19782b();
        }
        abortAndRelease();
        return iArr;
    }

    public boolean isFpidEffetive(String str) throws FingerPrintAuthUnusableException {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            LogX.i("isFpidEffetive fpid is null", false);
        } else if (this.authenticationManager != null) {
            int[] allSupportFpId = getAllSupportFpId();
            if (allSupportFpId != null) {
                for (int valueOf : allSupportFpId) {
                    if (str.equals(String.valueOf(valueOf))) {
                        z = true;
                        break;
                    }
                }
                abortAndRelease();
            } else {
                abortAndRelease();
                throw new FingerPrintAuthUnusableException();
            }
        } else {
            throw new FingerPrintAuthUnusableException();
        }
        return z;
    }

    public static boolean isSupportFingerPrint() {
        boolean z;
        int[] d = C4010a.m19777d();
        if (d == null || d.length == 0) {
            z = false;
        } else {
            z = false;
            for (int i : d) {
                if (i == 1 && C4010a.m19775b(1)) {
                    z = true;
                }
            }
        }
        LogX.e("isSupport fingerprint::" + z, false);
        return z;
    }

    public boolean isHasFingerPrint() {
        boolean z;
        if (this.authenticationManager == null || this.authenticationManager.m19782b().length <= 0) {
            z = false;
        } else {
            z = true;
        }
        abortAndRelease();
        LogX.e("isHasFingerInfo fingerprint::" + z, false);
        return z;
    }

    public void registerCaptureCallback(C4015d c4015d) {
        if (this.authenticationManager != null) {
            LogX.i("registerCaptureCallback", false);
            this.authenticationManager.m19781a(c4015d);
        }
    }

    public void startIdentify(C4017f c4017f, String str, int[] iArr) {
        if (c4017f == null || TextUtils.isEmpty(str)) {
            LogX.e("saltKey is empty or identifyCallback is null", false);
            return;
        }
        byte[] bArr = null;
        try {
            bArr = str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            LogX.e("saltKey getBytes UnsupportedEncodingException", false);
        }
        if (bArr == null) {
            LogX.e("saltBytes is null", false);
            return;
        }
        if (iArr == null) {
            iArr = this.authenticationManager.m19782b();
        }
        if (this.authenticationManager != null) {
            LogX.i("startIdentify", false);
            this.authenticationManager.m19779a(c4017f, iArr, bArr);
        }
    }

    public static String createFingerPrintPassWd(Context context, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PhoneDeviceUtil.m28466a(context));
        stringBuilder.append("|");
        stringBuilder.append("|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(getFingerPrintFlashID());
        stringBuilder.append("|");
        stringBuilder.append(str);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    public static String createSaltKey(String str) {
        int nextInt = (new SecureRandom().nextInt(10000) + 10000) % 10000;
        if (nextInt < 1000) {
            nextInt += 1000;
        }
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        return TimeUtil.m28480a("yyyyMMddHHmmssSSS") + String.valueOf(nextInt) + ":" + str;
    }

    public static String getFingerPrintFlashID() {
        byte[] fingerPrintFlashByte = getFingerPrintFlashByte(1);
        if (fingerPrintFlashByte != null && fingerPrintFlashByte.length > 0) {
            try {
                return new String(fingerPrintFlashByte, GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                LogX.e("flashId failed, cause:" + e.toString(), false);
            }
        }
        return null;
    }

    private static byte[] getFingerPrintFlashByte(int i) {
        return new byte[0];
    }
}
