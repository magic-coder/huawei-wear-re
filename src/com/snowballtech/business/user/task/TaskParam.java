package com.snowballtech.business.user.task;

import android.content.Context;

public class TaskParam {
    private Context context;
    private String inputParam;
    private String operation;

    public String getInputParam() {
        return this.inputParam;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setInputParam(String str) {
        this.inputParam = str;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
