package com.huawei.pluginmessagecenter.provider.data;

public class MessageCenterPushBean {
    public String pushContent = "";
    public String pushType = "";

    public String toString() {
        return "MessageCenterPushBean{, pushType='" + this.pushType + '\'' + ", pushId='" + this.pushContent + '\'' + '}';
    }
}
