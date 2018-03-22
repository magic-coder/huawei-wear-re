package com.huawei.wallet.ui.idencard.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventType;

public class NfcReadCardResultActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object intent = getIntent();
        if ("android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            if (!intent.getBooleanExtra("is_activity_main_task", true)) {
                Intent intent2 = new Intent();
                intent2.setClass(this, NfcReadCardResultActivity.class);
                intent2.addFlags(32768);
                startActivity(intent2);
            }
            EventDispatchManager.m28051a().m28053a(IEventType.TYPE_NFC_IDENTIFY_CARD, intent);
        }
        finish();
    }
}
