package com.huawei.nfc.carrera.logic.cardoperate.init;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.impl.EseTsmInitLoader;

public class InitEseTask implements Runnable {
    private final Context mContext;
    private final HandleInitEseResultTask mResultHandleTask;

    public InitEseTask(Context context, HandleInitEseResultTask handleInitEseResultTask) {
        this.mContext = context;
        this.mResultHandleTask = handleInitEseResultTask;
    }

    public void run() {
        this.mResultHandleTask.notifyInitEseResult(checkEseInitStatus());
    }

    private int checkEseInitStatus() {
        return new EseTsmInitLoader(this.mContext).excuteEseInit();
    }
}
