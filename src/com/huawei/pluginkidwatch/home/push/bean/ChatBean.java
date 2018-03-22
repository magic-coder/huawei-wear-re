package com.huawei.pluginkidwatch.home.push.bean;

import com.huawei.pluginkidwatch.common.entity.model.VoiceContent;

public class ChatBean extends KOnePushBeanBase {
    public VoiceContent data = new VoiceContent();

    public String toString() {
        if (this.data == null) {
            return "ChatBean{data=" + this.data + '}';
        }
        return "ChatBean{data=" + this.data.toString() + '}';
    }
}
