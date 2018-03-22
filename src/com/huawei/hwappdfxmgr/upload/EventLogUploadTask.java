package com.huawei.hwappdfxmgr.upload;

import com.huawei.p190v.C2538c;

public class EventLogUploadTask implements Runnable {
    private static final String TAG = "EventLogUploadTask";
    private EvenLogUpload mLogUpload;

    public EventLogUploadTask(EvenLogUpload evenLogUpload) {
        this.mLogUpload = evenLogUpload;
    }

    public void run() {
        C2538c.m12677c(TAG, "上传任务开始");
        if (this.mLogUpload == null) {
            C2538c.m12677c(TAG, "null == mLogUpload");
            return;
        }
        UploadRequest.upLoadHttpsEventLog(this.mLogUpload);
    }
}
