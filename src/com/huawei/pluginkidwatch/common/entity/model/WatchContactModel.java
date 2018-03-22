package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class WatchContactModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public long contactId = 0;
    public String headIcon;

    public long getContactId() {
        return ((Long) C1489i.m6887a(Long.valueOf(this.contactId))).longValue();
    }

    public void setContactId(long j) {
        this.contactId = ((Long) C1489i.m6887a(Long.valueOf(j))).longValue();
    }

    public String getHeadIcon() {
        return (String) C1489i.m6887a(this.headIcon);
    }

    public void setHeadIcon(String str) {
        this.headIcon = (String) C1489i.m6887a(str);
    }
}
