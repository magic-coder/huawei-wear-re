package com.huawei.appmarket.sdk.service.download.bean;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat.Builder;
import com.huawei.appmarket.sdk.foundation.d.a.a;
import com.huawei.appmarket.sdk.foundation.e.c.c;
import com.huawei.appmarket.sdk.service.p028a.C0665a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.http.client.methods.HttpGet;

public class DownloadTask extends a implements Parcelable {
    public static final Creator<DownloadTask> CREATOR = new d();
    public static final int DEFAULT_ID = -1;
    public static final String TABLE_NAME = "DownloadTask";
    private static int taskIndex = com.huawei.appmarket.sdk.foundation.e.a.a.a();
    protected boolean allowMobileNetowrkDownload = false;
    @C0665a
    protected long alreadDownloadSize_ = 0;
    @C0665a
    protected String appID_;
    @C0665a
    protected long backupFileSize_ = 0;
    @C0665a
    protected String backupUrl_;
    protected List<DownloadTask> dependTaskList = null;
    @C0665a
    protected String detailID_;
    @C0665a
    protected String diffMD5_;
    protected int dlType_ = 0;
    protected e downloadErrInfo = new e(this);
    @C0665a
    protected int downloadProtocol_ = 0;
    protected f downloadQuality = new f(this);
    @C0665a
    protected int downloadRate_;
    @C0665a
    protected long fileSize_ = 0;
    @C0665a
    protected String filepath_;
    public String hash_;
    protected HttpGet httpGet = null;
    @C0665a
    protected String iconUrl_;
    @C0665a
    protected int id_ = -1;
    @C0665a
    protected int installType_ = 0;
    @C0665a
    public int interruptReason_ = 0;
    private boolean isDeleteDirtyFile = true;
    public boolean isInterrupt = false;
    protected Builder mNotifyBuilder;
    @C0665a
    protected String name_;
    @C0665a
    protected String packageName_;
    @C0665a
    protected int progress_ = 0;
    List<a> sliceChkList;
    @C0665a
    protected int status_ = 0;
    protected Future<?> taskFuture = null;
    protected String trace_;
    @C0665a
    protected String url_;

    protected DownloadTask(Bundle bundle) {
        int i = 0;
        Field[] declaredFields = DownloadTask.class.getDeclaredFields();
        while (i < declaredFields.length) {
            try {
                declaredFields[i].setAccessible(true);
                if (declaredFields[i].isAnnotationPresent(C0665a.class)) {
                    String simpleName = declaredFields[i].getType().getSimpleName();
                    String name = declaredFields[i].getName();
                    if (simpleName.equals("String")) {
                        declaredFields[i].set(this, bundle.getString(name));
                    } else if (simpleName.equals("int")) {
                        declaredFields[i].set(this, Integer.valueOf(bundle.getInt(name)));
                    } else if (simpleName.equals("long")) {
                        declaredFields[i].set(this, Long.valueOf(bundle.getLong(name)));
                    } else if (simpleName.equals("float")) {
                        declaredFields[i].set(this, Float.valueOf(bundle.getFloat(name)));
                    } else {
                        com.huawei.appmarket.sdk.foundation.b.a.a.a.b("RecordBean", "unsupport field type:" + simpleName + HwAccountConstants.BLANK + declaredFields[i].getName());
                    }
                }
            } catch (Throwable e) {
                com.huawei.appmarket.sdk.foundation.b.a.a.a.a("RecordBean", "DownloadTask exception:", e);
            }
            i++;
        }
    }

    protected DownloadTask(Parcel parcel) {
        this.id_ = parcel.readInt();
        this.name_ = parcel.readString();
        this.progress_ = parcel.readInt();
        this.url_ = parcel.readString();
        this.fileSize_ = parcel.readLong();
        this.alreadDownloadSize_ = parcel.readLong();
        this.filepath_ = parcel.readString();
        this.packageName_ = parcel.readString();
        this.downloadRate_ = parcel.readInt();
        this.status_ = parcel.readInt();
        this.iconUrl_ = parcel.readString();
        this.appID_ = parcel.readString();
        this.detailID_ = parcel.readString();
        this.interruptReason_ = parcel.readInt();
        this.installType_ = parcel.readInt();
        this.backupUrl_ = parcel.readString();
        this.backupFileSize_ = parcel.readLong();
        this.diffMD5_ = parcel.readString();
        this.downloadProtocol_ = parcel.readInt();
        this.hash_ = parcel.readString();
    }

    public static DownloadTask fromBundle(Bundle bundle) {
        return bundle == null ? null : new DownloadTask(bundle);
    }

    public static synchronized int genTaskIndex() {
        int i;
        synchronized (DownloadTask.class) {
            taskIndex++;
            if (taskIndex > Integer.MAX_VALUE) {
                taskIndex = com.huawei.appmarket.sdk.foundation.e.a.a.a();
            }
            i = taskIndex;
        }
        return i;
    }

    public void addStatisticsParam(NetworkInfo networkInfo) {
        if (this.url_ != null) {
            int lastIndexOf = this.url_.lastIndexOf(SNBConstant.FILTER);
            String str = this.url_;
            if (lastIndexOf != -1 && this.url_.substring(lastIndexOf + 1).trim().startsWith("net")) {
                str = this.url_.substring(0, lastIndexOf);
            }
            this.url_ = str + SNBConstant.FILTER + "net" + "=" + c.a(networkInfo);
        }
    }

    public void assignTo(DownloadTask downloadTask) {
        downloadTask.setAppID(this.appID_);
        downloadTask.hash_ = this.hash_;
        downloadTask.setId(this.id_);
        downloadTask.setName(this.name_);
        downloadTask.setProgress(this.progress_);
        downloadTask.setUrl(this.url_);
        downloadTask.setIconUrl(this.iconUrl_);
        downloadTask.setFileSize(this.fileSize_);
        downloadTask.setAlreadDownloadSize(this.alreadDownloadSize_);
        downloadTask.setFilepath(this.filepath_);
        downloadTask.setDownloadRate(this.downloadRate_);
        downloadTask.setStatus(this.status_);
        downloadTask.isInterrupt = this.isInterrupt;
        downloadTask.setPackageName(this.packageName_);
        downloadTask.interruptReason_ = this.interruptReason_;
        downloadTask.setInstallType(this.installType_);
        downloadTask.diffMD5_ = this.diffMD5_;
        downloadTask.setDetailID(this.detailID_);
        downloadTask.setDlType_(this.dlType_);
        downloadTask.setDeleteDirtyFile(this.isDeleteDirtyFile);
        downloadTask.setAllowMobileNetowrkDownload(this.allowMobileNetowrkDownload);
        downloadTask.setDownloadProtocol(this.downloadProtocol_);
        downloadTask.setBackupFileSize(this.backupFileSize_);
        downloadTask.setBackupUrl(this.backupUrl_);
    }

    public int calculateProgress() {
        int round = Math.round((((float) getAlreadDownloadSize()) / ((float) getFileSize())) * 100.0f);
        return round > 100 ? 100 : round;
    }

    public void cancel() {
        try {
            if (this.httpGet != null && !this.httpGet.isAborted()) {
                new c(this).start();
            }
        } catch (Throwable e) {
            com.huawei.appmarket.sdk.foundation.b.a.a.a.a("RecordBean", "cancel exception:", e);
        }
    }

    public void deleteDownloadFile() {
        if (this.isDeleteDirtyFile && this.filepath_ != null) {
            com.huawei.appmarket.sdk.foundation.b.a.a.a.a(TABLE_NAME, "download failed, delete temp file, task:" + this);
            new File(this.filepath_).delete();
        }
    }

    public int describeContents() {
        return 0;
    }

    public long getAlreadDownloadSize() {
        return this.alreadDownloadSize_;
    }

    public String getAppID() {
        return this.appID_;
    }

    public long getBackupFileSize() {
        return this.backupFileSize_;
    }

    public String getBackupUrl() {
        return this.backupUrl_;
    }

    public String getDefaultTableName() {
        return TABLE_NAME;
    }

    public List<DownloadTask> getDependTaskList() {
        return this.dependTaskList;
    }

    public String getDetailID() {
        return this.detailID_;
    }

    public String getDiffMD5() {
        return this.diffMD5_;
    }

    public int getDlType_() {
        return this.dlType_;
    }

    public e getDownloadFailedReason() {
        return this.downloadErrInfo;
    }

    public int getDownloadProtocol() {
        return this.downloadProtocol_;
    }

    public f getDownloadQuality() {
        return this.downloadQuality;
    }

    public int getDownloadRate() {
        return this.downloadRate_;
    }

    public long getFileSize() {
        return this.fileSize_;
    }

    public String getFilename() {
        if (this.filepath_ == null) {
            return null;
        }
        int lastIndexOf = this.filepath_.lastIndexOf(File.separator);
        return lastIndexOf != -1 ? this.filepath_.substring(lastIndexOf + 1) : null;
    }

    public String getFilepath() {
        return this.filepath_;
    }

    public HttpGet getHttpGet() {
        return this.httpGet;
    }

    public String getIconUrl() {
        return this.iconUrl_;
    }

    public int getId() {
        return this.id_;
    }

    public int getInstallType() {
        return this.installType_;
    }

    public int getInterruptReason() {
        return this.interruptReason_;
    }

    public String getName() {
        return this.name_;
    }

    public Builder getNotifyBuilder() {
        return this.mNotifyBuilder;
    }

    public String getPackageName() {
        return this.packageName_;
    }

    public int getProgress() {
        return this.progress_ > 100 ? 100 : this.progress_;
    }

    public List<a> getSliceChkList() {
        return this.sliceChkList;
    }

    public int getStatus() {
        return this.status_;
    }

    public Future<?> getTaskFuture() {
        return this.taskFuture;
    }

    public String getTrace() {
        return this.trace_;
    }

    public String getUrl() {
        return this.url_;
    }

    public boolean isAllowMobileNetowrkDownload() {
        return this.allowMobileNetowrkDownload;
    }

    public boolean isDeleteDirtyFile() {
        return this.isDeleteDirtyFile;
    }

    public boolean isInterrupt() {
        return this.isInterrupt;
    }

    public boolean isSmartpatch() {
        return this.diffMD5_ != null && this.diffMD5_.length() > 0;
    }

    public void resetStatus() {
        if (getInterruptReason() == 3) {
            setStatus(3);
        } else if (getInterruptReason() == 1 || getInterruptReason() == 2) {
            this.interruptReason_ = 1;
            setStatus(6);
        }
    }

    public void setAllowMobileNetowrkDownload(boolean z) {
        this.allowMobileNetowrkDownload = z;
    }

    public void setAlreadDownloadSize(long j) {
        this.alreadDownloadSize_ = j;
    }

    public void setAppID(String str) {
        this.appID_ = str;
    }

    public void setBackupFileSize(long j) {
        this.backupFileSize_ = j;
    }

    public void setBackupUrl(String str) {
        this.backupUrl_ = str;
    }

    public void setDeleteDirtyFile(boolean z) {
        this.isDeleteDirtyFile = z;
    }

    public void setDependTaskList(List<DownloadTask> list) {
        this.dependTaskList = list;
    }

    public void setDetailID(String str) {
        this.detailID_ = str;
    }

    public void setDiffMD5(String str) {
        this.diffMD5_ = str;
    }

    public void setDlType_(int i) {
        this.dlType_ = i;
    }

    public void setDownloadProtocol(int i) {
        this.downloadProtocol_ = i;
    }

    public void setDownloadRate(int i) {
        this.downloadRate_ = i;
    }

    public void setFileSize(long j) {
        this.fileSize_ = j;
    }

    public void setFilepath(String str) {
        this.filepath_ = str;
    }

    public void setHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
    }

    public void setIconUrl(String str) {
        this.iconUrl_ = str;
    }

    public void setId(int i) {
        this.id_ = i;
    }

    public void setInstallType(int i) {
        this.installType_ = i;
    }

    public void setInterrupt(boolean z, int i) {
        this.isInterrupt = z;
        this.interruptReason_ = i;
        if (i != 4 && z) {
            this.downloadQuality.d = true;
        }
        com.huawei.appmarket.sdk.foundation.b.a.a.a.a("RecordBean", "setInterrupt,id:" + getId() + ", isInterrupt:" + z + ",reason:" + i);
        if (z) {
            cancel();
        }
    }

    public void setName(String str) {
        this.name_ = str;
    }

    public void setNotifyBuilder(Builder builder) {
        this.mNotifyBuilder = builder;
    }

    public void setPackageName(String str) {
        this.packageName_ = str;
    }

    public void setProgress(int i) {
        this.progress_ = i;
    }

    public void setSliceChkList(List<a> list) {
        this.sliceChkList = list;
    }

    public void setStatus(int i) {
        this.status_ = i;
    }

    public void setTaskFuture(Future<?> future) {
        this.taskFuture = future;
    }

    public void setTrace(String str) {
        this.trace_ = str;
    }

    public void setUrl(String str) {
        this.url_ = str;
    }

    public String toSmapleString() {
        return "[hash_=" + this.hash_ + ", diffMD5_=" + this.diffMD5_ + ", name_=" + this.name_ + ", progress_=" + this.progress_ + ", url_=" + this.url_ + ", fileSize_=" + this.fileSize_ + ", alreadDownloadSize_=" + this.alreadDownloadSize_ + ", filepath_=" + this.filepath_ + ", status_=" + this.status_ + ", isInterrupt=" + this.isInterrupt + ", packageName_=" + this.packageName_ + ", interruptReason_=" + this.interruptReason_ + ", installType_=" + this.installType_ + "allowMobileNetowrkDownload=" + this.allowMobileNetowrkDownload + ", appID_=" + this.appID_ + ", trace_=" + this.trace_ + ", dlType_=" + this.dlType_ + ", isDeleteDirtyFile:" + this.isDeleteDirtyFile + ", downloadProtocol:" + this.downloadProtocol_ + "]";
    }

    public String toString() {
        return getClass().getName() + " {\n\thash_: " + this.hash_ + "\n\tdiffMD5_: " + this.diffMD5_ + "\n\tid_: " + this.id_ + "\n\tname_: " + this.name_ + "\n\tprogress_: " + this.progress_ + "\n\turl_: " + this.url_ + "\n\ticonUrl_: " + this.iconUrl_ + "\n\tfileSize_: " + this.fileSize_ + "\n\talreadDownloadSize_: " + this.alreadDownloadSize_ + "\n\tfilepath_: " + this.filepath_ + "\n\tdownloadRate_: " + this.downloadRate_ + "\n\tstatus_: " + this.status_ + "\n\tisInterrupt: " + this.isInterrupt + "\n\tpackageName_: " + this.packageName_ + "\n\tinterruptReason_: " + this.interruptReason_ + "\n\tallowMobileNetowrkDownload: " + this.allowMobileNetowrkDownload + "\n\tinstallType_: " + this.installType_ + "\n\tdetailID_: " + this.detailID_ + "\n\tappID_: " + this.appID_ + "\n\tdownloadErrInfo: " + this.downloadErrInfo + "\n\ttrace_: " + this.trace_ + "\n\tdlType_: " + this.dlType_ + "\n\tisDeleteDirtyFile: " + this.isDeleteDirtyFile + "\n\tbackupUrl: " + this.backupUrl_ + "\n\tbackupFileSize: " + this.backupFileSize_ + "\n\tdownloadProtocol_: " + this.downloadProtocol_ + "\n}";
    }

    public void writeToBundle(Bundle bundle) {
        Field[] declaredFields = DownloadTask.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            try {
                declaredFields[i].setAccessible(true);
                if (declaredFields[i].isAnnotationPresent(C0665a.class)) {
                    String simpleName = declaredFields[i].getType().getSimpleName();
                    String name = declaredFields[i].getName();
                    Object obj = declaredFields[i].get(this);
                    if (obj != null) {
                        if (simpleName.equals("String")) {
                            bundle.putString(name, (String) obj);
                        } else if (simpleName.equals("int")) {
                            bundle.putInt(name, ((Integer) obj).intValue());
                        } else if (simpleName.equals("long")) {
                            bundle.putLong(name, ((Long) obj).longValue());
                        } else if (simpleName.equals("float")) {
                            bundle.putFloat(name, ((Float) obj).floatValue());
                        } else {
                            com.huawei.appmarket.sdk.foundation.b.a.a.a.b("RecordBean", "unsupport type, name:" + declaredFields[i].getName() + ", value:" + obj);
                        }
                    }
                }
            } catch (Throwable e) {
                com.huawei.appmarket.sdk.foundation.b.a.a.a.a("RecordBean", "writeToBundle exception:", e);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id_);
        parcel.writeString(this.name_);
        parcel.writeInt(this.progress_);
        parcel.writeString(this.url_);
        parcel.writeLong(this.fileSize_);
        parcel.writeLong(this.alreadDownloadSize_);
        parcel.writeString(this.filepath_);
        parcel.writeString(this.packageName_);
        parcel.writeInt(this.downloadRate_);
        parcel.writeInt(this.status_);
        parcel.writeString(this.iconUrl_);
        parcel.writeString(this.appID_);
        parcel.writeString(this.detailID_);
        parcel.writeInt(this.interruptReason_);
        parcel.writeInt(this.installType_);
        parcel.writeString(this.backupUrl_);
        parcel.writeLong(this.backupFileSize_);
        parcel.writeString(this.diffMD5_);
        parcel.writeInt(this.downloadProtocol_);
        parcel.writeString(this.hash_);
    }
}
