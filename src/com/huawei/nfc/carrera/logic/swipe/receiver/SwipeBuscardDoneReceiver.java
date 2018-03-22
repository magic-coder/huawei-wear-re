package com.huawei.nfc.carrera.logic.swipe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.logic.tlv.TlvUtil;

public class SwipeBuscardDoneReceiver extends BroadcastReceiver {
    public static final String ACTION_TRANSACTION_DETECTED = "com.nxp.action.TRANSACTION_DETECTED";
    private static final String EXTRA_AID = "com.nxp.extra.AID";
    private static final String EXTRA_DATA = "com.nxp.extra.DATA";
    private SwipeDoneListener swipeDoneListener;

    public SwipeBuscardDoneReceiver(SwipeDoneListener swipeDoneListener) {
        this.swipeDoneListener = swipeDoneListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogX.e("SwipeBuscardDoneReceiver onReceive, null == intent");
            return;
        }
        String action = intent.getAction();
        LogX.i("SwipeBuscardDoneReceiver onReceive, action=" + action);
        if ("com.nxp.action.TRANSACTION_DETECTED".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(EXTRA_AID);
            if (byteArrayExtra == null) {
                LogX.e("SwipeBuscardDoneReceiver onReceive, null == aidBytes");
            } else {
                LogX.i("SwipeBuscardDoneReceiver onReceive, aid=" + TlvUtil.m28096a(byteArrayExtra), false);
            }
            byteArrayExtra = intent.getByteArrayExtra(EXTRA_DATA);
            if (byteArrayExtra == null) {
                LogX.e("SwipeBuscardDoneReceiver onReceive, null == dataBytes");
            } else {
                LogX.i("SwipeBuscardDoneReceiver onReceive, dataStr=" + TlvUtil.m28096a(byteArrayExtra));
            }
            this.swipeDoneListener.swipeDone();
            return;
        }
        LogX.e("SwipeBuscardDoneReceiver onReceive, illegal action");
    }
}
