package com.huawei.openalliance.ad.inter.data;

public class ChannelInfo {
    private String channelId;
    private String channelName;
    private String slotId;

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }

    public String toString() {
        return "ChannelInfo [channelId=" + this.channelId + ", channelName=" + this.channelName + ", slotId=" + this.slotId + "]";
    }
}
