package com.huawei.wallet.ui.idencard.camera.hcoincard;

import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.DecodeHandler;
import com.huawei.wallet.ui.idencard.camera.base.DecodeThread;

public class HCoinCardDecodeThread extends DecodeThread {
    public HCoinCardDecodeThread(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
    }

    protected DecodeHandler mo5179a(BaseCaptureActivity baseCaptureActivity) {
        return new HCoinCardDecodeHandler(baseCaptureActivity);
    }
}
