package com.huawei.wallet.ui.idencard.camera.bankcard;

import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.DecodeHandler;
import com.huawei.wallet.ui.idencard.camera.base.DecodeThread;

public class BankCardDecodeThread extends DecodeThread {
    public BankCardDecodeThread(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
    }

    protected DecodeHandler mo5179a(BaseCaptureActivity baseCaptureActivity) {
        return new BankCardDecodeHandler(baseCaptureActivity);
    }
}
