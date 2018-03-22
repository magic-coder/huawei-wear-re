package com.huawei.appmarket.service.deamon.download;

import android.os.Parcel;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.p371c.C4285c;
import com.huawei.appmarket.sdk.service.download.C4307a;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;

public class SecurityDownloadTask extends DownloadTask {
    private static final String TAG = "SecurityDownloadTask";

    public SecurityDownloadTask(Parcel parcel) {
        super(parcel);
    }

    private boolean needRestartHttpsDownload() {
        return (!C4285c.m20688d(C4234a.m20519a().m20523b()) || getDownloadProtocol() == 1) ? false : this.interruptReason_ == 7 || this.interruptReason_ == 8 || this.interruptReason_ == 9;
    }

    public boolean isInterrupt() {
        boolean isInterrupt = super.isInterrupt();
        if (!isInterrupt || !needRestartHttpsDownload()) {
            return isInterrupt;
        }
        C4241a.m20532b(TAG, "Download failed reason:" + this.interruptReason_ + ",restart in https protocol.");
        String c = C4307a.m20759a().m20767c();
        if (c == null) {
            C4241a.m20532b(TAG, "Https ip is null! Security download failed!");
            return isInterrupt;
        }
        deleteDownloadFile();
        this.interruptReason_ = 0;
        this.alreadDownloadSize_ = 0;
        this.progress_ = 0;
        this.downloadRate_ = 0;
        this.isInterrupt = false;
        this.filepath_ = null;
        this.status_ = 2;
        if (isSmartpatch() && getBackupUrl() != null) {
            setUrl(getBackupUrl());
            setFileSize(getBackupFileSize());
            this.diffMD5_ = "";
            this.hash_ = null;
        }
        setUrl(C4307a.m20760a(getUrl(), c));
        setDownloadProtocol(1);
        return false;
    }
}
