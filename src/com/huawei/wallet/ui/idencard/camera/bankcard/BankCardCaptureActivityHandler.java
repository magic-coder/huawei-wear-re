package com.huawei.wallet.ui.idencard.camera.bankcard;

import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivityHandler;
import com.huawei.wallet.ui.idencard.camera.base.DecodeThread;

public class BankCardCaptureActivityHandler extends BaseCaptureActivityHandler {
    public BankCardCaptureActivityHandler(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
    }

    protected DecodeThread mo5175a(BaseCaptureActivity baseCaptureActivity) {
        return new BankCardDecodeThread(baseCaptureActivity);
    }
}
