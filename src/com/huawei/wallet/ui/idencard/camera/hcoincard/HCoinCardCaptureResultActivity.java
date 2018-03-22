package com.huawei.wallet.ui.idencard.camera.hcoincard;

import android.os.Bundle;
import android.widget.TextView;
import com.huawei.b.f;
import com.huawei.b.h;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureResultActivity;
import com.huawei.wallet.ui.idencard.camera.base.CardResultInfoManager;

public class HCoinCardCaptureResultActivity extends BaseCaptureResultActivity {
    protected void onCreate(Bundle bundle) {
        this.f = CardResultInfoManager.m28422d().m28425b();
        super.onCreate(bundle);
        m28371a(h.wallet_camera_confirm_hcoincard_info);
        ((TextView) findViewById(f.card_tips)).setText(h.wallet_camera_confirm_hcoincard_tips);
    }
}
