package com.huawei.lcagent.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.huawei.lcagent.client.ILogCollect.Stub;

public class LogCollectManager {
    public static final int ALREADY_DONE = 1;
    public static final int ERROR_OTHER = -2;
    public static final int ERROR_SERVICE_NOT_CONNECTED = -1;
    public static final int FAIL = -3;
    public static final int SUCCESS = 0;
    private static final String TAG = "LogCollectManager";
    protected ILogCollect iLogCollect = null;
    private CallBack mCallerCallback = null;
    private Context mContext = null;
    protected ServiceConnection scLogCollect = new C10911();

    class C10911 implements ServiceConnection {
        C10911() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(LogCollectManager.TAG, "service is connected");
            LogCollectManager.this.iLogCollect = Stub.asInterface(iBinder);
            if (LogCollectManager.this.mCallerCallback != null) {
                LogCollectManager.this.mCallerCallback.serviceConnected();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(LogCollectManager.TAG, "service is disconnceted");
            LogCollectManager.this.iLogCollect = null;
        }
    }

    public interface CallBack {
        void serviceConnected();
    }

    public LogCollectManager(Context context) {
        this.mContext = context.getApplicationContext();
        if (this.mContext == null) {
            this.mContext = context;
        }
        bindToService(this.mContext);
    }

    public LogCollectManager(Context context, CallBack callBack) {
        this.mCallerCallback = callBack;
        this.mContext = context.getApplicationContext();
        bindToService(this.mContext);
    }

    public LogCollectManager(Context context, boolean z) {
        if (z) {
            this.mContext = context;
            bindToService(this.mContext);
            return;
        }
        this.mContext = context.getApplicationContext();
        bindToService(this.mContext);
    }

    public int setMetricStoargeHeader(int i, byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2) {
            return -2;
        }
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.setMetricStoargeHeader(i, bArr, i2);
        }
        return -1;
    }

    public int setMetricStoargeHeader(int i, byte[] bArr) {
        return setMetricStoargeHeader(i, bArr, bArr.length);
    }

    public int setMetricStoargeTail(int i, byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2) {
            return -2;
        }
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.setMetricStoargeTail(i, bArr, i2);
        }
        return -1;
    }

    public int setMetricStoargeTail(int i, byte[] bArr) {
        return setMetricStoargeTail(i, bArr, bArr.length);
    }

    public int setMetricCommonHeader(int i, byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2) {
            return -2;
        }
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.setMetricCommonHeader(i, bArr, i2);
        }
        return -1;
    }

    public int setMetricCommonHeader(int i, byte[] bArr) {
        return setMetricCommonHeader(i, bArr, bArr.length);
    }

    public int submitMetric(int i, int i2, byte[] bArr, int i3) {
        if (bArr == null || bArr.length < i3) {
            return -2;
        }
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.submitMetric(i, i2, bArr, i3);
        }
        return -1;
    }

    public int submitMetric(int i, int i2, byte[] bArr) {
        return submitMetric(i, i2, bArr, bArr.length);
    }

    public boolean shouldSubmitMetric(int i, int i2) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.shouldSubmitMetric(i, i2);
        }
        return false;
    }

    public LogMetricInfo captureLogMetric(int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.captureLogMetric(i);
        }
        return null;
    }

    public LogMetricInfo captureAllLog() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.captureAllLog();
        }
        return null;
    }

    public void clearLogMetric(long j) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            this.iLogCollect.clearLogMetric(j);
        }
    }

    public int allowUploadInMobileNetwork(boolean z) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.allowUploadInMobileNetwork(z);
        }
        return -1;
    }

    public int allowUploadAlways(boolean z) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.allowUploadAlways(z);
        }
        return -1;
    }

    public int configureUserType(int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureUserType(i);
        }
        return -1;
    }

    public int forceUpload() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.forceUpload();
        }
        return -1;
    }

    public int feedbackUploadResult(long j, int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.feedbackUploadResult(j, i);
        }
        return -1;
    }

    public int configure(String str) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configure(str);
        }
        return -1;
    }

    public int getUserType() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.getUserType();
        }
        return -1;
    }

    public boolean bindToService(Context context) {
        Log.i(TAG, "start to bind to Log Collect service");
        if (this.mContext == null) {
            Log.e(TAG, "mContext == null");
            return false;
        }
        Intent intent = new Intent("com.huawei.lcagent.service.ILogCollect");
        intent.setClassName("com.huawei.lcagent", "com.huawei.lcagent.service.LogCollectService");
        context.startService(intent);
        intent = new Intent("com.huawei.lcagent.service.ILogCollect");
        intent.setClassName("com.huawei.lcagent", "com.huawei.lcagent.service.LogCollectService");
        return this.mContext.bindService(intent, this.scLogCollect, 1);
    }

    private void unbindToService() {
        if (this.mContext == null || this.scLogCollect == null) {
            Log.e(TAG, "mContext == null || scLogCollect == null");
        } else {
            this.mContext.unbindService(this.scLogCollect);
        }
    }

    protected void finalize() {
        unbindToService();
    }

    public long getFirstErrorTime() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.getFirstErrorTime();
        }
        return -1;
    }

    public int resetFirstErrorTime() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.resetFirstErrorTime();
        }
        return -1;
    }

    public String getFirstErrorType() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.getFirstErrorType();
        }
        return null;
    }

    public int configureModemlogcat(int i, String str) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureModemlogcat(i, str);
        }
        return -1;
    }

    public int configureBluetoothlogcat(int i, String str) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureBluetoothlogcat(i, str);
        }
        return -1;
    }

    public int configureLogcat(int i, String str) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureLogcat(i, str);
        }
        return -1;
    }

    public int configureAPlogs(int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureAPlogs(i);
        }
        return -1;
    }

    public int configureCoredump(int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureCoredump(i);
        }
        return -1;
    }

    public int configureGPS(int i) {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.configureGPS(i);
        }
        return -1;
    }

    public CompressInfo getCompressInfo() {
        if ((this.iLogCollect != null || bindToService(this.mContext)) && this.iLogCollect != null) {
            return this.iLogCollect.getCompressInfo();
        }
        return null;
    }
}
