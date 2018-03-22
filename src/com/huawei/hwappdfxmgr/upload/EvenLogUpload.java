package com.huawei.hwappdfxmgr.upload;

public class EvenLogUpload {
    private String huid;
    private EventInfo info;
    private String path;
    private String version;

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public EventInfo getInfo() {
        return this.info;
    }

    public void setInfo(EventInfo eventInfo) {
        this.info = eventInfo;
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "EvenLogUpload{huid='" + this.huid + '\'' + ", version='" + this.version + '\'' + ", info=" + this.info.toString() + '}';
    }
}
