package com.huawei.openalliance.ad.inter.data;

import java.util.List;

public class CubeConfig {
    private List<ChannelInfo> channelInfo;
    private int requestTimeInterval;
    private int screenSaverPoolSize;
    private int serialAdCount;
    private int serialNoAdCount;
    private int startUpPoolSize;

    public List<ChannelInfo> getChannelInfo() {
        return this.channelInfo;
    }

    public int getRequestTimeInterval() {
        return this.requestTimeInterval;
    }

    public int getScreenSaverPoolSize() {
        return this.screenSaverPoolSize;
    }

    public int getSerialAdCount() {
        return this.serialAdCount;
    }

    public int getSerialNoAdCount() {
        return this.serialNoAdCount;
    }

    public int getStartUpPoolSize() {
        return this.startUpPoolSize;
    }

    public void setChannelInfo(List<ChannelInfo> list) {
        this.channelInfo = list;
    }

    public void setRequestTimeInterval(int i) {
        this.requestTimeInterval = i;
    }

    public void setScreenSaverPoolSize(int i) {
        this.screenSaverPoolSize = i;
    }

    public void setSerialAdCount(int i) {
        this.serialAdCount = i;
    }

    public void setSerialNoAdCount(int i) {
        this.serialNoAdCount = i;
    }

    public void setStartUpPoolSize(int i) {
        this.startUpPoolSize = i;
    }

    public String toString() {
        return "CubeConfig [channelInfo=" + this.channelInfo + ", startUpPoolSize=" + this.startUpPoolSize + ", screenSaverPoolSize=" + this.screenSaverPoolSize + ", serialNoAdCount=" + this.serialNoAdCount + ", serialAdCount=" + this.serialAdCount + ", requestTimeInterval=" + this.requestTimeInterval + "]";
    }
}
