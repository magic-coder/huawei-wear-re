package com.huawei.wallet.ui.idencard.camera.bankcard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.huawei.b.f;
import com.huawei.b.h;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureResultActivity;
import com.huawei.wallet.ui.idencard.camera.base.CardResultInfoManager;

public class BankCardCaptureResultActivity extends BaseCaptureResultActivity {
    private boolean f21524g;
    private CustomTitleBar f21525h;

    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.f21524g = intent.getBooleanExtra("isSupportHorVerSwitch", false);
        }
        this.f = CardResultInfoManager.m28422d().m28423a();
        super.onCreate(bundle);
        m28371a(h.wallet_camera_confirm_card_info);
        ((TextView) findViewById(f.card_tips)).setText(h.wallet_camera_confirm_card_tips);
        this.f21525h = (CustomTitleBar) findViewById(f.ocr_result_title_bar);
        this.f21525h.setTitleText(getString(h.wallet_camera_confirm_card_info));
    }

    protected boolean mo5176a() {
        if (this.f21524g) {
            return false;
        }
        return super.mo5176a();
    }
}
