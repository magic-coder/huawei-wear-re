package com.huawei.hwdevicedfxmanager.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class DataMaintFileInformation {
    private long fileCrc;
    private String fileName;
    private long fileSize;

    public String getFileName() {
        return (String) C0978h.a(this.fileName);
    }

    public void setFileName(String str) {
        this.fileName = (String) C0978h.a(str);
    }

    public long getFileSize() {
        return ((Long) C0978h.a(Long.valueOf(this.fileSize))).longValue();
    }

    public void setFileSize(long j) {
        this.fileSize = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getFileCrc() {
        return ((Long) C0978h.a(Long.valueOf(this.fileCrc))).longValue();
    }

    public void setFileCrc(long j) {
        this.fileCrc = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }
}
