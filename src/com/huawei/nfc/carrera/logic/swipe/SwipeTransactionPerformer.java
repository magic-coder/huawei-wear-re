package com.huawei.nfc.carrera.logic.swipe;

import android.app.Activity;
import android.content.Context;
import com.huawei.nfc.carrera.logic.swipe.channel.ChannelManager;
import com.huawei.nfc.carrera.logic.swipe.channel.ChannelOpenCallback;
import com.huawei.nfc.carrera.logic.swipe.channel.GetDefaultCardCallback;
import com.huawei.nfc.carrera.logic.swipe.listener.SwipePerformStateListener;
import com.huawei.nfc.carrera.logic.swipe.listener.TransactionInfoReceivedListener;
import com.huawei.nfc.carrera.logic.swipe.receiver.SwipeDoneListener;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutListener;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutTimer;
import com.huawei.nfc.carrera.util.LogX;

public class SwipeTransactionPerformer implements ChannelOpenCallback, TransactionInfoReceivedListener, SwipeDoneListener, TimeoutListener {
    private static final int TRANSACTION_TIMEOUT = 60000;
    private Context mContext;
    private SwipePerformStateListener stateListener;
    private TimeoutTimer timer;
    private TransactionInfoHandler transactionInfoHandler;

    class C55552 implements GetDefaultCardCallback {
        C55552() {
        }

        public void getDefaultCardCallback(TACardInfo tACardInfo) {
            if (tACardInfo.cardGroupType == 2) {
                ChannelManager.getInstance(SwipeTransactionPerformer.this.mContext).disableCardEmulation(null);
            } else {
                ChannelManager.getInstance(SwipeTransactionPerformer.this.mContext).disableTransactionChannel(tACardInfo.cardGroupType, null);
            }
        }
    }

    public SwipeTransactionPerformer(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
    }

    public void startAndAddListener(final boolean z, SwipePerformStateListener swipePerformStateListener) {
        this.stateListener = swipePerformStateListener;
        ChannelManager.getInstance(this.mContext).getDefaultCard(new GetDefaultCardCallback() {
            public void getDefaultCardCallback(TACardInfo tACardInfo) {
                SwipeTransactionPerformer.this.transactionInfoHandler = new TransactionInfoHandler(SwipeTransactionPerformer.this.mContext, SwipeTransactionPerformer.this);
                if (SwipeTransactionPerformer.this.timer == null) {
                    SwipeTransactionPerformer.this.timer = new TimeoutTimer(SwipeTransactionPerformer.TRANSACTION_TIMEOUT, SwipeTransactionPerformer.this);
                }
                SwipeTransactionPerformer.this.timer.startTimer();
                if (tACardInfo.cardGroupType == 2) {
                    ChannelManager.getInstance(SwipeTransactionPerformer.this.mContext).enableCardEmulation(null);
                } else if (z) {
                    ChannelManager.getInstance(SwipeTransactionPerformer.this.mContext).enableTransactionChannelByFpPwd(tACardInfo.cardGroupType, SwipeTransactionPerformer.this);
                } else {
                    ChannelManager.getInstance(SwipeTransactionPerformer.this.mContext).enableTransactionChannelByPayPwd(tACardInfo.cardGroupType, SwipeTransactionPerformer.this);
                }
            }
        });
    }

    public void stopAndRemoveListener() {
        if (this.timer != null) {
            this.timer.stopTimer();
        }
        if (this.transactionInfoHandler != null) {
            this.transactionInfoHandler.destroy();
            this.transactionInfoHandler = null;
        }
        this.stateListener = null;
        ChannelManager.getInstance(this.mContext).getDefaultCard(new C55552());
    }

    public void openChannelResult(boolean z) {
        LogX.i("open channel result: " + z);
        if (this.stateListener != null) {
            this.stateListener.swipePrepare(z);
        }
    }

    public void swipeDone() {
        if (this.stateListener != null) {
            this.stateListener.swipeState(0);
        }
    }

    public void timeout() {
        if (this.stateListener != null) {
            this.stateListener.swipeState(-1);
        }
    }

    public void onTransactionInfo() {
        if (this.stateListener != null) {
            this.stateListener.swipeState(0);
        }
    }
}
