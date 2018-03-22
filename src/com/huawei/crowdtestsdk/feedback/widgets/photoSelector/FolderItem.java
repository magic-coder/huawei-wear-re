package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

public class FolderItem {
    private String count;
    private String dir;
    private String firstImagePath;
    private String name;

    public String getDir() {
        return this.dir;
    }

    public void setDir(String str) {
        this.dir = str;
        this.name = this.dir.substring(this.dir.lastIndexOf("/") + 1);
    }

    public String getFirstImagePath() {
        return this.firstImagePath;
    }

    public void setFirstImagePath(String str) {
        this.firstImagePath = str;
    }

    public String getName() {
        return this.name;
    }

    public String getCountString() {
        return this.count;
    }

    public void setCountString(String str) {
        this.count = str;
    }
}
