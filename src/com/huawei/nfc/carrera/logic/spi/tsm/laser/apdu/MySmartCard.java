package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.leisen.wallet.sdk.oma.SmartCardBean;
import org.simalliance.openmobileapi.C3076f;
import org.simalliance.openmobileapi.C6651c;

public final class MySmartCard implements C3076f {
    private static final String BOUNDARY = "==>";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "SmartCard";
    private static MySmartCard mInstance;
    private final Object lock = new Object();
    private SmartCardCallback mCallback;
    private int mFlag = -1;
    private C6651c mSEService;
    private boolean mServiceIsConnection = false;
    private SmartCardBean mSmartCardBean;
    private SmartCardRequest mSmartCardRequest;

    private MySmartCard() {
    }

    public static MySmartCard getInstance() {
        MySmartCard mySmartCard;
        synchronized (SYNC_LOCK) {
            if (mInstance == null) {
                mInstance = new MySmartCard();
            }
            mySmartCard = mInstance;
        }
        return mySmartCard;
    }

    public void execute(Context context, int i, SmartCardBean smartCardBean) {
        synchronized (this.lock) {
            this.mFlag = i;
            if (smartCardBean == null) {
                operFailure(this.mFlag, "SmartCardBean must not allow to null");
            } else if (smartCardBean.getReaderName() == null) {
                operFailure(this.mFlag, "choose reader not exist");
            } else if (smartCardBean.getAid() == null) {
                operFailure(this.mFlag, "the aid must not allow to null");
            } else {
                this.mSmartCardBean = smartCardBean;
                if (this.mSEService == null) {
                    C6651c c6651c = new C6651c(context, this);
                    C2538c.b(TAG, new Object[]{"==>start bind SEService"});
                    synchronized (this) {
                        while (!this.mServiceIsConnection) {
                            try {
                                C2538c.b(TAG, new Object[]{"==>thread is waiting"});
                                wait();
                            } catch (InterruptedException e) {
                                operFailure(this.mFlag, "thread error:" + e.getMessage());
                            }
                        }
                    }
                }
                executeSmartCardRequest();
            }
        }
    }

    private void executeSmartCardRequest() {
        synchronized (this.lock) {
            if (this.mSEService == null) {
                return;
            }
            if (this.mSmartCardRequest == null) {
                this.mSmartCardRequest = new SmartCardRequest(this.mSEService, null);
            }
            this.mSmartCardRequest.setSmartCartBean(this.mSmartCardBean);
            this.mSmartCardRequest.setSmartCardCallback(this.mCallback);
            this.mSmartCardRequest.setFlag(this.mFlag);
            this.mSmartCardRequest.run();
        }
    }

    public void serviceConnected(C6651c c6651c) {
        synchronized (this.lock) {
            synchronized (this) {
                if (c6651c.m29952a()) {
                    C2538c.b(TAG, new Object[]{"==>bind SEService success"});
                    this.mSEService = c6651c;
                } else {
                    operFailure(this.mFlag, "SEService connect failure");
                }
                C2538c.b(TAG, new Object[]{"==>thread notifyAll"});
                this.mServiceIsConnection = true;
                notifyAll();
            }
        }
    }

    public MySmartCard setSmartCardCallBack(SmartCardCallback smartCardCallback) {
        synchronized (this.lock) {
            this.mCallback = smartCardCallback;
        }
        return this;
    }

    public void closeService() {
        synchronized (this.lock) {
            if (this.mSmartCardRequest != null) {
                this.mSmartCardRequest.closeChannelAndSession();
                this.mSmartCardRequest = null;
            }
            try {
                if (this.mSEService != null && this.mSEService.m29952a()) {
                    this.mSEService.m29954c();
                    this.mSEService = null;
                    this.mServiceIsConnection = false;
                    C2538c.c(TAG, new Object[]{"==>SEService close success"});
                }
            } catch (Exception e) {
                C2538c.e(TAG, new Object[]{"==>SEService close fail" + e.getMessage()});
            }
            this.mCallback = null;
            this.mSmartCardBean = null;
            this.mSmartCardRequest = null;
        }
    }

    public void closeChannel() {
        synchronized (this.lock) {
            if (this.mSmartCardRequest != null) {
                this.mSmartCardRequest.closeChannelAndSession();
                this.mSmartCardRequest = null;
            }
        }
    }

    private void operFailure(int i, String str) {
        if (this.mCallback != null) {
            this.mCallback.onOperFailure(i, str);
        }
    }
}
