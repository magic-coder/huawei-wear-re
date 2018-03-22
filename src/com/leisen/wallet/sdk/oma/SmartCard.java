package com.leisen.wallet.sdk.oma;

import android.content.Context;
import com.huawei.p190v.C2538c;

public class SmartCard {
    public static final int MAIN_CHANNEL = 0;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "SmartCard";
    private static SmartCard mInstance;
    private SmartCardCallback mCallback;
    private int mFlag = -1;
    private boolean mServiceIsConnection = false;
    private SmartCardBean mSmartCardBean;
    private SmartCardRequest mSmartCardRequest;

    private SmartCard() {
    }

    public static SmartCard getInstance() {
        SmartCard smartCard;
        synchronized (SYNC_LOCK) {
            if (mInstance == null) {
                mInstance = new SmartCard();
            }
            smartCard = mInstance;
        }
        return smartCard;
    }

    public void execute(Context context, int i, SmartCardBean smartCardBean) {
        this.mFlag = i;
        if (smartCardBean == null) {
            operFailure(this.mFlag, "SmartCardBean must not allow to null");
        } else if (smartCardBean.getReaderName() == null) {
            operFailure(this.mFlag, "choose reader not exist");
        } else if (smartCardBean.getAid() == null) {
            operFailure(this.mFlag, "the aid must not allow to null");
        } else {
            this.mSmartCardBean = smartCardBean;
            executeSmartCardRequest();
        }
    }

    private void executeSmartCardRequest() {
        if (this.mSmartCardRequest == null) {
            C2538c.b(TAG, new Object[]{"new  SmartCardRequest"});
            this.mSmartCardRequest = new SmartCardRequest();
        }
        this.mSmartCardRequest.setSmartCartBean(this.mSmartCardBean);
        this.mSmartCardRequest.setSmartCardCallback(this.mCallback);
        this.mSmartCardRequest.setFlag(this.mFlag);
        this.mSmartCardRequest.run();
    }

    public SmartCard setSmartCardCallBack(SmartCardCallback smartCardCallback) {
        this.mCallback = smartCardCallback;
        return this;
    }

    public void closeChannel() {
        if (this.mSmartCardRequest != null) {
            this.mSmartCardRequest.closeChannelAndSession();
            this.mSmartCardRequest = null;
        }
        this.mCallback = null;
        this.mSmartCardBean = null;
        this.mSmartCardRequest = null;
    }

    private void operFailure(int i, String str) {
        if (this.mCallback != null) {
            this.mCallback.onOperFailure(i, new Error(str));
        }
    }
}
