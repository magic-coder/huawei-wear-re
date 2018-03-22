package com.huawei.datatype;

import com.huawei.hwbasemgr.IBaseResponseCallback;

public class DBObject {
    private IBaseResponseCallback iResponseCallback;
    private Object object;

    public IBaseResponseCallback getiBaseResponseCallback() {
        return this.iResponseCallback;
    }

    public void setiBaseResponseCallback(IBaseResponseCallback iBaseResponseCallback) {
        this.iResponseCallback = iBaseResponseCallback;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }
}
