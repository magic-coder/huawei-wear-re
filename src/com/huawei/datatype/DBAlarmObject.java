package com.huawei.datatype;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class DBAlarmObject {
    private IBaseResponseCallback iBaseResponseCallback;
    private Object object;

    public IBaseResponseCallback getiBaseResponseCallback() {
        return (IBaseResponseCallback) C0978h.a(this.iBaseResponseCallback);
    }

    public void setiBaseResponseCallback(IBaseResponseCallback iBaseResponseCallback) {
        this.iBaseResponseCallback = (IBaseResponseCallback) C0978h.a(iBaseResponseCallback);
    }

    public Object getObject() {
        return C0978h.a(this.object);
    }

    public void setObject(Object obj) {
        this.object = C0978h.a(obj);
    }
}
