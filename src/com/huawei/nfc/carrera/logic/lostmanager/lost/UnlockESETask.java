package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.UnLockEseTsmOperator;
import com.huawei.nfc.carrera.logic.lostmanager.report.ReportDeviceStatusTask;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class UnlockESETask implements Runnable {
    private final Context mContext;

    public UnlockESETask(Context context) {
        this.mContext = context;
    }

    public void run() {
        if (startUnLockEse()) {
            sendDeviceStatusNormal();
        }
    }

    private void sendDeviceStatusNormal() {
        LogX.d("UnlockESETask, sendDeviceStatusNormal");
        new ReportDeviceStatusTask(this.mContext, "0").run();
    }

    private int unLockEse() {
        int excute = new UnLockEseTsmOperator(this.mContext).excute();
        LogX.i("UnLockEseTsmOperator, excute UnLockEse, result: " + excute);
        return excute;
    }

    private boolean startUnLockEse() {
        LogX.d("UnlockESETask, start unLockEse");
        boolean z = true;
        if (unLockEse() != 0) {
            z = false;
        } else {
            try {
                WalletTaManager.getInstance(this.mContext).addESELockTimes();
            } catch (WalletTaSystemErrorException e) {
                LogX.i("addESELockTimes  WalletTaSystemErrorException");
            }
        }
        LogX.i("isUnLockEseSuccess :" + z);
        return z;
    }
}
