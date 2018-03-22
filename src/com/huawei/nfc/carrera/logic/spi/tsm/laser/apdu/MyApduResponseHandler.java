package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class MyApduResponseHandler {
    private static final int MESSAGE_FAILURE = 2;
    private static final int MESSAGE_SENDNEXT = 1;
    private static final int MESSAGE_SENDNEXT_ERROR = 3;
    private static final int MESSAGE_SUCCESS = 0;
    private ResponseHandler mHandler;
    private boolean useSynchronousMode;

    class ResponseHandler extends Handler {
        private final MyApduResponseHandler mResponder;

        public ResponseHandler(MyApduResponseHandler myApduResponseHandler) {
            this.mResponder = myApduResponseHandler;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.mResponder.handleMessage(message);
        }
    }

    public abstract void onFailure(int i, String str);

    public abstract void onSendNext(int i, int i2, String str, String str2);

    public abstract void onSendNextError(int i, int i2, String str, String str2, String str3);

    public abstract void onSuccess(String str);

    public MyApduResponseHandler() {
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
                    onFailure(Integer.parseInt(objArr[0].toString()), objArr[1].toString());
                    return;
                }
                return;
            case 3:
                objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 5) {
                    onSendNextError(Integer.parseInt(objArr[0].toString()), Integer.parseInt(objArr[1].toString()), objArr[2].toString(), objArr[3].toString(), objArr[4].toString());
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

    public void sendSendNextErrorMessage(int i, int i2, String str, String str2, String str3) {
        sendMessage(obtainMessage(3, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3}));
    }

    public void sendFailureMessage(int i, String str) {
        sendMessage(obtainMessage(2, new Object[]{Integer.valueOf(i), str}));
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
