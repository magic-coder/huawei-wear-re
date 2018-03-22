package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult<T> extends Result {
    private T f1369a;

    public ResolveResult() {
        this.f1369a = null;
    }

    public ResolveResult(T t) {
        this.f1369a = t;
    }

    public T getValue() {
        return this.f1369a;
    }
}
