package com.huawei.nfc.carrera.logic.security;

import android.content.Context;
import com.huawei.nfc.carrera.logic.security.fingerprint.FingerPrintAuthUnusableException;
import com.huawei.nfc.carrera.logic.security.fingerprint.FingerPrintManager;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class CheckFingerPrintPasswd {
    private Context mContext;

    public CheckFingerPrintPasswd(Context context) {
        this.mContext = context;
    }

    public boolean isFingerPrintExsit() {
        try {
            try {
                if (!FingerPrintManager.getInstance().isFpidEffetive(String.valueOf(WalletTaManager.getInstance(this.mContext).getFingerId()))) {
                    try {
                        WalletTaManager.getInstance(this.mContext).removeFingerId();
                        return false;
                    } catch (WalletTaSystemErrorException e) {
                        LogX.e("remove finger id failed, system error");
                        return false;
                    }
                }
            } catch (FingerPrintAuthUnusableException e2) {
                LogX.e("fingerprint auth unusable");
            }
            return true;
        } catch (WalletTaFingerIdNotExistException e3) {
            LogX.e("get finger id failed, finger id is not exist");
            return false;
        } catch (WalletTaSystemErrorException e4) {
            LogX.e("get finger id failed, system error");
            return false;
        }
    }

    public boolean isFpIdInSystemSetting(String str) throws FingerPrintAuthUnusableException {
        return FingerPrintManager.getInstance().isFpidEffetive(str);
    }
}
