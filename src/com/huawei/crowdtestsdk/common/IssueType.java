package com.huawei.crowdtestsdk.common;

import android.content.Context;
import android.util.Log;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity;

public class IssueType {
    private static final int defaultBugType = -1;
    private String betaTypeId;
    private int bugTypeId;
    private String desc;
    private int imageId;
    private Class<?> myClass;
    private String title;

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int i) {
        this.imageId = i;
    }

    public void setBugTypeId(int i) {
        if (i == -1) {
            this.bugTypeId = -1;
        } else {
            this.bugTypeId = i;
        }
    }

    public void setBetaTypeId(String str) {
        this.betaTypeId = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setClassName(Context context, String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            this.myClass = FeedbackDescriptionActivity.class;
            return;
        }
        try {
            this.myClass = Class.forName(str);
        } catch (Throwable e) {
            Log.e("BETACLUB_SDK", "[IssueType.setClassName]Reflect ERROR!", e);
        }
    }

    public Class<?> getClassName() {
        return this.myClass;
    }

    public String getBetaTypeId() {
        return this.betaTypeId;
    }

    public int getBugTypeId() {
        return this.bugTypeId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "IssueType{bugTypeId=" + this.bugTypeId + ", betaTypeId='" + this.betaTypeId + '\'' + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", myClass=" + this.myClass + ", imageId=" + this.imageId + '}';
    }
}
