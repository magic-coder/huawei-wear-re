package com.huawei.crowdtestsdk.bases;

public abstract class IQuestionItem {
    public abstract String getBrief();

    public abstract String getCreatedDate();

    public abstract String getDetail();

    public abstract String getFlowStatus();

    public abstract String getImeiNo();

    public abstract String getNewQuesType();

    public abstract String getProjectId();

    public abstract String getProjectName();

    public abstract String getQuesImeiNo();

    public abstract String getQuesStatus();

    public abstract String getRecure();

    public abstract String getTbdtsQuesNo();

    public abstract String getUserDealUltimateness();

    public abstract String getVersionName();

    public abstract void setBrief(String str);

    public abstract void setCreatedDate(String str);

    public abstract void setDetail(String str);

    public abstract void setFlowStatus(String str);

    public abstract void setImeiNo(String str);

    public abstract void setNewQuesType(String str);

    public abstract void setProjectId(String str);

    public abstract void setProjectName(String str);

    public abstract void setQuesImeiNo(String str);

    public abstract void setQuesStatus(String str);

    public abstract void setRecure(String str);

    public abstract void setTbdtsQuesNo(String str);

    public abstract void setUserDealUltimateness(String str);

    public abstract void setVersionName(String str);
}
