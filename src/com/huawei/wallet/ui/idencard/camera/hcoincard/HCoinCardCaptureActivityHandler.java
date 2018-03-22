package com.huawei.wallet.ui.idencard.camera.hcoincard;

import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivityHandler;
import com.huawei.wallet.ui.idencard.camera.base.DecodeThread;

public class HCoinCardCaptureActivityHandler extends BaseCaptureActivityHandler {
    public HCoinCardCaptureActivityHandler(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
    }

    protected DecodeThread mo5175a(BaseCaptureActivity baseCaptureActivity) {
        return new HCoinCardDecodeThread(baseCaptureActivity);
    }
}
