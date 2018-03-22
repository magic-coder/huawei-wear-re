package com.huawei.crowdtestsdk.bases;

import java.util.ArrayList;

public class LogCollectedResult {
    private ArrayList<String> logPathList;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public ArrayList<String> getLogPath() {
        return this.logPathList;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setLogPath(ArrayList<String> arrayList) {
        this.logPathList = arrayList;
    }
}
