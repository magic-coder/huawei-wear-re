package com.huawei.ui.device.activity.onelevelmenu;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: OneLevelMenuManagerActivity */
class C2113i implements IBaseResponseCallback {
    final /* synthetic */ OneLevelMenuManagerActivity f7465a;

    C2113i(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7465a = oneLevelMenuManagerActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===sendDataToBand err_code=" + i + "objData=" + obj);
    }
}
