package com.leisen.wallet.sdk.apdu;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.leisen.wallet.sdk.business.ApduBean;
import com.leisen.wallet.sdk.oma.SmartCard;
import com.leisen.wallet.sdk.oma.SmartCardBean;
import com.leisen.wallet.sdk.oma.SmartCardCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ApduSmartCardRequest implements SmartCardCallback, Runnable {
    private static final int RESULT_FAILURE = 1;
    private static final int RESULT_SUCCESS = 0;
    private static final String TAG = "ApduSmartCardRequest";
    private final Object lock = new Object();
    private String mApduAid;
    private List<ApduBean> mCapduList;
    private Context mContext;
    private ApduBean mCurrentExecuteApduBean;
    private int mCurrentExecuteIndex = 0;
    private int mFlag;
    private ApduResponseHandler mHandler;
    private boolean mIsGetLocalData = false;

    public ApduSmartCardRequest(Context context, ApduResponseHandler apduResponseHandler) {
        this.mContext = context;
        this.mHandler = apduResponseHandler;
    }

    public void run() {
        sendApudToSmartCard();
    }

    private void sendApudToSmartCard() {
        synchronized (this.lock) {
            if (this.mCapduList == null) {
            } else if (this.mCurrentExecuteIndex == this.mCapduList.size()) {
            } else {
                this.mCurrentExecuteApduBean = (ApduBean) this.mCapduList.get(this.mCurrentExecuteIndex);
                String apdu = this.mCurrentExecuteApduBean.getApdu();
                C2538c.b(TAG, new Object[]{"==>start get apdu index:" + this.mCurrentExecuteIndex + "==apdu:" + apdu});
                if ("00A4".equals(apdu.substring(0, 4))) {
                    C2538c.b(TAG, new Object[]{"==>deal with select apdu :" + apdu});
                    this.mApduAid = apdu.substring(apdu.length() - (Integer.parseInt(apdu.substring(8, 10), 16) * 2), apdu.length());
                    this.mCurrentExecuteIndex++;
                    SmartCard.getInstance().closeChannel();
                    C2538c.b(TAG, new Object[]{"==>has been get select aid:" + this.mApduAid});
                    sendApudToSmartCard();
                } else if (this.mApduAid == null) {
                } else {
                    C2538c.b(TAG, new Object[]{"==>start execute apdu：" + apdu});
                    SmartCardBean smartCardBean = new SmartCardBean(1, this.mApduAid);
                    smartCardBean.setCommand(apdu);
                    SmartCard.getInstance().setSmartCardCallBack(this).execute(this.mContext, this.mFlag, smartCardBean);
                }
            }
        }
    }

    public void onOperSuccess(int i, String str) {
        C2538c.b(TAG, new Object[]{"==>handle apdu response:" + str + " ; mIsGetLocalData : " + this.mIsGetLocalData});
        if (this.mIsGetLocalData) {
            sendSuccessMessage(str);
            return;
        }
        String str2;
        String str3 = "";
        if (str == null || str.length() <= 4) {
            str2 = str3;
            str3 = str;
        } else {
            str2 = str.substring(str.length() - 4, str.length());
            str3 = str2;
            str2 = str.substring(0, str.length() - 4).toUpperCase(Locale.getDefault());
        }
        if (str3 != null) {
            str3 = str3.toUpperCase(Locale.getDefault());
        }
        C2538c.b(TAG, new Object[]{"==>get response res_sw:" + str3});
        if (!Arrays.asList(this.mCurrentExecuteApduBean.getSw()).contains(str3)) {
            sendMessage(1, this.mCurrentExecuteApduBean.getIndex(), str2, str3);
        } else if (this.mCurrentExecuteIndex < this.mCapduList.size() - 1) {
            this.mCurrentExecuteIndex++;
            sendApudToSmartCard();
        } else {
            sendMessage(0, this.mCurrentExecuteApduBean.getIndex(), str2, str3);
        }
    }

    public void onOperFailure(int i, Error error) {
        C2538c.b(TAG, new Object[]{" onOperFailure mIsGetLocalData : " + this.mIsGetLocalData});
        if (this.mIsGetLocalData) {
            sendFailureMessage(100009, error);
        } else {
            sendErrorMessage(1, this.mCurrentExecuteApduBean.getIndex(), "", "", error);
        }
    }

    public void setCapduList(List<ApduBean> list) {
        this.mCapduList = list;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void isGetLocalData(boolean z) {
        C2538c.b(TAG, new Object[]{" isGetLocalData enable : " + z});
        C2538c.b(TAG, new Object[]{" isGetLocalData mIsGetLocalData : " + this.mIsGetLocalData});
        this.mIsGetLocalData = z;
    }

    public void setGetLocalDataApdu(String str, String str2) {
        if (this.mCapduList == null) {
            this.mCapduList = new ArrayList();
        } else {
            this.mCapduList.clear();
        }
        this.mCapduList.add(new ApduBean(str));
        synchronized (this.lock) {
            this.mApduAid = str2;
        }
    }

    private void sendMessage(int i, int i2, String str, String str2) {
        clearData();
        if (this.mHandler != null) {
            this.mHandler.sendSendNextMessage(i, i2, str, str2);
        }
    }

    private void sendErrorMessage(int i, int i2, String str, String str2, Error error) {
        clearData();
        if (this.mHandler != null) {
            this.mHandler.sendSendNextErrorMessage(i, i2, str, str2, error);
        }
    }

    private void sendSuccessMessage(String str) {
        clearData();
        if (this.mHandler != null) {
            this.mHandler.sendSuccessMessage(str);
        }
    }

    private void sendFailureMessage(int i, Error error) {
        clearData();
        if (this.mHandler != null) {
            this.mHandler.sendFailureMessage(i, error);
        }
    }

    private void clearData() {
        C2538c.b(TAG, new Object[]{" clearData"});
        this.mCurrentExecuteIndex = 0;
        this.mCurrentExecuteApduBean = null;
        this.mIsGetLocalData = false;
    }
}
