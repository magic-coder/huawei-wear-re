package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.cardlist.listener.EnableNFCListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;

public class NFCOpenLogic {
    public static final String AUTO_ENABLE_NFC = "auto_enable_nfc";
    private static final int CHECK_DELAY = 500;
    public static final int DEFAULT_PAY_REQUESTCODE = 0;
    private static final int OPEN_DEFAULT_PAY = 13;
    private static final int OPEN_NFC_ACTION = 10;
    private static final int OPEN_NFC_FAILEED = 12;
    private static final int OPEN_NFC_SUCCESS = 11;
    private static final int SUCCESS_CHECK_DELAY = 1000;
    public static final String SWITH_CE_SWITCH_ACTION = "com.huawei.android.nfc.SWITCH_CE_STATE";
    public static final String SWITH_CE_SWITCH_STATUS = "com.huawei.android.nfc.CE_SELECTED_STATE";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static NFCOpenLogic instance;
    @SuppressLint({"HandlerLeak"})
    Handler handler = new C55431();
    private EnableNFCListener listener;
    private Activity mActivty;
    private Context mContext;
    Runnable openNFCRunnable = new C55442();

    class C55431 extends Handler {
        C55431() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 10:
                    NFCOpenLogic.this.openNFCEnvironment(NFCOpenLogic.this.mActivty);
                    return;
                case 11:
                    NFCOpenLogic.this.listener.enableNFCSuccess();
                    return;
                case 12:
                    NFCOpenLogic.this.listener.enableNFCFailed();
                    return;
                case 13:
                    NFCOpenLogic.this.listener.dealDefaultPay();
                    return;
                default:
                    return;
            }
        }
    }

    class C55442 implements Runnable {
        C55442() {
        }

        public void run() {
            if (!NfcUtil.isEnabledNFC(NFCOpenLogic.this.mActivty) && !NfcUtil.enableNFC(NFCOpenLogic.this.mActivty)) {
                NFCOpenLogic.this.handler.sendEmptyMessageDelayed(12, 500);
            } else if (NfcUtil.isSelectSE(NFCOpenLogic.this.mActivty) != 1) {
                NfcUtil.selectSE(NFCOpenLogic.this.mActivty);
            } else {
                NFCOpenLogic.this.handler.sendEmptyMessageDelayed(11, 1000);
            }
        }
    }

    private NFCOpenLogic(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
    }

    public static NFCOpenLogic getInstance(Context context) {
        NFCOpenLogic nFCOpenLogic;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new NFCOpenLogic(context);
            }
            nFCOpenLogic = instance;
        }
        return nFCOpenLogic;
    }

    public boolean isAutoOpenNFC() {
        return NFCPreferences.getInstance(this.mContext).getBoolean(AUTO_ENABLE_NFC, false);
    }

    public void setAutoOpenNFC() {
        NFCPreferences.getInstance(this.mContext).putBoolean(AUTO_ENABLE_NFC, true);
    }

    public void registEnableListener(EnableNFCListener enableNFCListener) {
        this.listener = enableNFCListener;
    }

    public void unRegistEnableListener(EnableNFCListener enableNFCListener) {
        this.listener = null;
    }

    public void openNFCEnvironment(Activity activity) {
        this.mActivty = activity;
        if (this.listener == null) {
            LogX.e("listener is null");
        } else {
            new Thread(this.openNFCRunnable).start();
        }
    }
}
