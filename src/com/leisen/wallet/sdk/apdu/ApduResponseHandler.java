package com.leisen.wallet.sdk.apdu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;

public abstract class ApduResponseHandler {
    private static final int MESSAGE_FAILURE = 2;
    private static final int MESSAGE_SENDNEXT = 1;
    private static final int MESSAGE_SENDNEXT_ERROR = 3;
    private static final int MESSAGE_SUCCESS = 0;
    private static final String TAG = "ApduResponseHandler";
    private ResponseHandler mHandler;
    private boolean useSynchronousMode;

    class ResponseHandler extends Handler {
        private final ApduResponseHandler mResponder;

        public ResponseHandler(ApduResponseHandler apduResponseHandler) {
            this.mResponder = apduResponseHandler;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.mResponder.handleMessage(message);
        }
    }

    public abstract void OnSendNextError(int i, int i2, String str, String str2, Error error);

    public abstract void onFailure(int i, Error error);

    public abstract void onSendNext(int i, int i2, String str, String str2);

    public abstract void onSuccess(String str);

    public ApduResponseHandler() {
        setUseSynchronousMode(true);
    }

    public void setUseSynchronousMode(boolean z) {
        if (!z && Looper.myLooper() == null) {
            z = true;
        }
        if (!z && this.mHandler == null) {
            this.mHandler = new ResponseHandler(this);
        } else if (z && this.mHandler != null) {
            this.mHandler = null;
        }
        this.useSynchronousMode = z;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    private void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.mHandler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.mHandler.sendMessage(message);
        }
    }

    public void handleMessage(Message message) {
        C2538c.c(TAG, new Object[]{"handleMessage : " + message.what + " ; objects : " + message.toString()});
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 1) {
                    onSuccess(objArr[0] == null ? null : objArr[0].toString());
                    return;
                }
                return;
            case 1:
                objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 4) {
                    onSendNext(Integer.parseInt(objArr[0].toString()), Integer.parseInt(objArr[1].toString()), objArr[2].toString(), objArr[3].toString());
                    return;
                }
                return;
            case 2:
                objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 2) {
                    onFailure(Integer.parseInt(objArr[0].toString()), (Error) objArr[1]);
                    return;
                }
                return;
            case 3:
                objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 5) {
                    OnSendNextError(Integer.parseInt(objArr[0].toString()), Integer.parseInt(objArr[1].toString()), objArr[2].toString(), objArr[3].toString(), (Error) objArr[4]);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void sendSuccessMessage(String str) {
        sendMessage(obtainMessage(0, new Object[]{str}));
    }

    public void sendSendNextMessage(int i, int i2, String str, String str2) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}));
    }

    public void sendSendNextErrorMessage(int i, int i2, String str, String str2, Error error) {
        sendMessage(obtainMessage(3, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, error}));
    }

    public void sendFailureMessage(int i, Error error) {
        sendMessage(obtainMessage(2, new Object[]{Integer.valueOf(i), error}));
    }

    private Message obtainMessage(int i, Object obj) {
        if (this.mHandler != null) {
            return Message.obtain(this.mHandler, i, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }
}
