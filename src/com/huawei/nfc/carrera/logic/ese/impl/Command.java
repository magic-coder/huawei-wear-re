package com.huawei.nfc.carrera.logic.ese.impl;

import android.util.Log;
import com.huawei.nfc.carrera.util.LogX;
import org.simalliance.openmobileapi.C6649a;

public class Command {
    private String mApdu;
    private String mChecker;
    private String mRpdu;

    public Command(String str, String str2) {
        this.mApdu = str;
        this.mChecker = str2;
    }

    public boolean excuteCommand(C6649a c6649a) {
        boolean z = false;
        if (c6649a == null) {
            LogX.e("excuteCommand failed. mChannel can not be null. before this please call setChannel method.");
        } else {
            try {
                this.mRpdu = HexByteHelper.byteArrayToHexString(c6649a.m29940a(HexByteHelper.hexStringToByteArray(this.mApdu)));
                z = this.mRpdu.matches(this.mChecker);
            } catch (Throwable e) {
                LogX.e("getCommandResult IOException : " + Log.getStackTraceString(e));
            }
        }
        return z;
    }

    public String getCommandResult() {
        return this.mRpdu;
    }

    public String getCommand() {
        return this.mApdu;
    }
}
