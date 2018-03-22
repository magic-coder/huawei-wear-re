package com.huawei.nfc.carrera.logic.swipe;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.lifecycle.push.PushTransactionInfoListener;
import com.huawei.nfc.carrera.lifecycle.push.data.PushConsumeMessage;
import com.huawei.nfc.carrera.logic.swipe.listener.TransactionInfoReceivedListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public class TransactionInfoHandler {
    private Context mContext;
    private TransactionInfoReceivedListener mListener;

    class C55571 implements PushTransactionInfoListener {
        C55571() {
        }

        public void transactionResult(PushConsumeMessage pushConsumeMessage) {
            if (pushConsumeMessage == null) {
                LogX.e("receive empty transaction info");
                return;
            }
            final String consumeAccount = pushConsumeMessage.getConsumeAccount();
            final String consumeTime = pushConsumeMessage.getConsumeTime();
            LogX.d("receive transaction info, ammount: " + consumeAccount + " ,time: " + consumeTime, true);
            new Handler(TransactionInfoHandler.this.mContext.getMainLooper()).post(new Runnable() {
                @SuppressLint({"NewApi"})
                public void run() {
                    if (!(StringUtil.isEmpty(consumeAccount, true) || StringUtil.isEmpty(consumeTime, true))) {
                        Intent intent = new Intent();
                        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                        intent.setClass(TransactionInfoHandler.this.mContext, CardHolderActivity.class);
                        intent.setPackage(TransactionInfoHandler.this.mContext.getPackageName());
                        PendingIntent activity = PendingIntent.getActivity(TransactionInfoHandler.this.mContext, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
                        CharSequence stringBuilder = new StringBuilder();
                        stringBuilder.append(TransactionInfoHandler.this.mContext.getResources().getString(R.string.nfc_swipe_msg_amount));
                        stringBuilder.append(HwAccountConstants.BLANK).append(consumeAccount).append("\n").append(TransactionInfoHandler.this.mContext.getResources().getString(R.string.nfc_swipe_msg_time)).append(HwAccountConstants.BLANK).append(consumeTime);
                        Builder builder = new Builder(TransactionInfoHandler.this.mContext);
                        builder.setSmallIcon(R.drawable.nfc_apk_icon);
                        builder.setTicker(stringBuilder.toString());
                        Notification build = builder.setContentIntent(activity).setContentTitle(TransactionInfoHandler.this.mContext.getResources().getString(R.string.nfc_swipe_notification)).setContentText(stringBuilder).build();
                        build.flags = 16;
                        build.when = System.currentTimeMillis();
                        NotificationManager notificationManager = (NotificationManager) TransactionInfoHandler.this.mContext.getSystemService("notification");
                        notificationManager.cancel(1);
                        notificationManager.notify(1, build);
                    }
                    if (TransactionInfoHandler.this.mListener != null) {
                        TransactionInfoHandler.this.mListener.onTransactionInfo();
                    }
                }
            });
        }
    }

    public TransactionInfoHandler(Context context, TransactionInfoReceivedListener transactionInfoReceivedListener) {
        this.mContext = context.getApplicationContext();
        this.mListener = transactionInfoReceivedListener;
        initPushInfoListener();
    }

    private void initPushInfoListener() {
        NFCPushServiceManager.getInstance(this.mContext).setPushTransactionMsgListener(new C55571());
    }

    public void destroy() {
        this.mListener = null;
    }
}
