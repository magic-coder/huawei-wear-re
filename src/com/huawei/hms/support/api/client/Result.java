package com.huawei.hms.support.api.client;

public abstract class Result {
    private Status f1368a = Status.FAILURE;

    public Status getStatus() {
        return this.f1368a;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.f1368a = status;
        }
    }
}
