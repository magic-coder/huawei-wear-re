package com.huawei.nfc.carrera.ui.identifycard;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.tlv.TlvParserUtil;

public abstract class CardReaderBaseActivity extends NFCBaseActivity {
    public static final int REQUEST_CODE_NFC_TAG = 1;
    private static final String TAG = CardReaderBaseActivity.class.getSimpleName();
    IntentFilter[] intentFilter = null;
    private NfcAdapter nfcAdapter;
    PendingIntent pendingIntent = null;
    String[][] techList = ((String[][]) null);

    protected abstract void getBankNumber(String str);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(R.string.nfc_input_card_num_title);
        if (NfcUtil.isEnabledNFC(this)) {
            init();
        }
    }

    private void init() {
        this.pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0);
        try {
            new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataType("*/*");
        } catch (Throwable e) {
            LogX.e("fail : " + Log.getStackTraceString(e));
        }
        this.intentFilter = new IntentFilter[]{r1};
        String[][] strArr = new String[1][];
        strArr[0] = new String[]{IsoDep.class.getName()};
        this.techList = strArr;
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogX.d(TAG, "onNewIntent");
        if ("android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            readCardNumber(intent);
        }
    }

    private void readCardNumber(Intent intent) {
        String a = TlvParserUtil.m28089a(intent);
        if (a == null) {
            LogX.d(TAG, "onNewIntent.number is null");
        } else {
            getBankNumber(a);
        }
    }

    protected void onResume() {
        super.onResume();
        LogX.d(TAG, "onResume");
        if (this.nfcAdapter != null && NfcUtil.isEnabledNFC(this)) {
            this.nfcAdapter.enableForegroundDispatch(this, this.pendingIntent, this.intentFilter, this.techList);
        }
    }

    public void onPause() {
        super.onPause();
        LogX.d(TAG, "onPause");
        if (this.nfcAdapter != null && NfcUtil.isEnabledNFC(this)) {
            this.nfcAdapter.disableForegroundDispatch(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            setResult(0);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
