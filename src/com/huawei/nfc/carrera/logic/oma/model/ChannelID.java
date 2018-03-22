package com.huawei.nfc.carrera.logic.oma.model;

public class ChannelID {
    private String aid;
    private int channelType = 0;
    private int mediaType = 0;

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public void setChannelType(int i) {
        this.channelType = i;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChannelID channelID = (ChannelID) obj;
        if (this.channelType == channelID.channelType && this.mediaType == channelID.mediaType && this.aid != null) {
            return this.aid.equals(channelID.aid);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.aid != null ? this.aid.hashCode() : 0) * 31) + this.channelType) * 31) + this.mediaType;
    }
}
