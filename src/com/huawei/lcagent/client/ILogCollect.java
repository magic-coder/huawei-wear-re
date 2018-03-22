package com.huawei.lcagent.client;

import android.os.IInterface;

public interface ILogCollect extends IInterface {
    int allowUploadAlways(boolean z);

    int allowUploadInMobileNetwork(boolean z);

    LogMetricInfo captureAllLog();

    LogMetricInfo captureLogMetric(int i);

    void clearLogMetric(long j);

    int configure(String str);

    int configureAPlogs(int i);

    int configureBluetoothlogcat(int i, String str);

    int configureCoredump(int i);

    int configureGPS(int i);

    int configureLogcat(int i, String str);

    int configureModemlogcat(int i, String str);

    int configureUserType(int i);

    void configureWithPara(String str, String str2);

    int feedbackUploadResult(long j, int i);

    int forceUpload();

    CompressInfo getCompressInfo();

    long getFirstErrorTime();

    String getFirstErrorType();

    int getUserType();

    int resetFirstErrorTime();

    int setMetricCommonHeader(int i, byte[] bArr, int i2);

    int setMetricStoargeHeader(int i, byte[] bArr, int i2);

    int setMetricStoargeTail(int i, byte[] bArr, int i2);

    boolean shouldSubmitMetric(int i, int i2);

    int submitMetric(int i, int i2, byte[] bArr, int i3);
}
