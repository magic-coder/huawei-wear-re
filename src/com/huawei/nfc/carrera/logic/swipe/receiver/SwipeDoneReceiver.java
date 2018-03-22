package com.huawei.nfc.carrera.logic.swipe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.wallet.logic.tlv.TlvUtil;
import java.util.HashMap;
import java.util.Map;

public class SwipeDoneReceiver extends BroadcastReceiver {
    public static final String ACTION_TRANSACTION_DETECTED = "com.nxp.action.TRANSACTION_DETECTED";
    private static final String EXTRA_AID = "com.nxp.extra.AID";
    private static final String EXTRA_DATA = "com.nxp.extra.DATA";
    private static final String EXTRA_SOURCE = "com.nxp.extra.SOURCE";
    private static final String SMART_MX_ID = "com.nxp.smart_mx.ID";
    private SwipeDoneListener swipeDoneListener;

    public SwipeDoneReceiver(SwipeDoneListener swipeDoneListener) {
        this.swipeDoneListener = swipeDoneListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogX.e("swipe done broadcast intent is null");
            return;
        }
        String action = intent.getAction();
        LogX.i("onReceive  action==" + action);
        if ("com.nxp.action.TRANSACTION_DETECTED".equals(action)) {
            handleActionTransactionDetected(intent);
        } else {
            LogX.d("onReceive  action is not ACTION_TRANSACTION_DETECTED");
        }
    }

    private void handleActionTransactionDetected(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_SOURCE);
        LogX.d("transaction source: " + stringExtra);
        Map hashMap;
        if (SMART_MX_ID.equals(stringExtra)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(EXTRA_AID);
            if (byteArrayExtra == null) {
                hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get extra aid from intent is null");
                hashMap.put(CloudEyeLogger.FAIL_CODE, "SwipeDoneReceiver");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_CARD_FAIL, hashMap, "get extra aid from intent is null", false, false);
                return;
            }
            LogX.d("trasaction aid: " + TlvUtil.m28096a(byteArrayExtra), false);
            byteArrayExtra = intent.getByteArrayExtra(EXTRA_DATA);
            if (byteArrayExtra == null) {
                hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get extra data from intent is null");
                hashMap.put(CloudEyeLogger.FAIL_CODE, "SwipeDoneReceiver");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_CARD_FAIL, hashMap, "get extra data from intent is null", false, false);
                return;
            }
            handleSwipeMessage(TlvUtil.m28096a(byteArrayExtra));
            return;
        }
        hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "not send from ese broadcast");
        hashMap.put(CloudEyeLogger.FAIL_CODE, "SwipeDoneReceiver");
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_CARD_FAIL, hashMap, "not send from ese broadcast", false, false);
    }

    private void handleSwipeMessage(String str) {
        LogX.i("transaction data: ");
        LogX.d(str, true);
        if (WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD.equals(str)) {
            LogX.i("cup card, swipe done");
            if (this.swipeDoneListener != null) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                this.swipeDoneListener.swipeDone();
            }
        } else if (str.length() > 8) {
            String substring = str.substring(4, 8);
            String substring2 = str.substring(0, 2);
            LogX.d("event tag str: " + substring2 + " ,event status str: " + substring);
            if (!"9000".equals(substring)) {
                return;
            }
            if (("E2".equals(substring2) || "02".equals(substring2)) && this.swipeDoneListener != null) {
                this.swipeDoneListener.swipeDone();
            }
        }
    }
}
