package com.huawei.common.applog;

public class AppLogApi$Param {
    private int fileMaxNum = -1;
    private boolean isHttpProtocol = true;
    private boolean isShutdown_Immediate = false;
    private int logLevel = -1;
    private String logWritePath = "";
    private int perFileSize = -1;
    private int reportCycle = 40;

    public boolean isHttpProtocol() {
        return this.isHttpProtocol;
    }

    public AppLogApi$Param setLogLevel(int i) {
        this.logLevel = i;
        return this;
    }

    public boolean getHttpProtocol() {
        return this.isHttpProtocol;
    }

    public void setHttpProtocol(boolean z) {
        this.isHttpProtocol = z;
    }

    public AppLogApi$Param setPerFileSize(int i) {
        this.perFileSize = i;
        return this;
    }

    public AppLogApi$Param setLogWritePath(String str) {
        this.logWritePath = str;
        return this;
    }

    public AppLogApi$Param setLogFileMaxnum(int i) {
        this.fileMaxNum = i;
        return this;
    }

    public AppLogApi$Param setShutdown_Immediate(boolean z) {
        this.isShutdown_Immediate = z;
        return this;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public int getPerFileSize() {
        return this.perFileSize;
    }

    public String getLogWritePath() {
        return this.logWritePath;
    }

    public int getLogFileMaxnum() {
        return this.fileMaxNum;
    }

    public int getReportCycle() {
        return this.reportCycle;
    }

    public boolean getShutdown_Immediate() {
        return this.isShutdown_Immediate;
    }

    public void setReportCycle(int i) {
        this.reportCycle = i;
    }
}
