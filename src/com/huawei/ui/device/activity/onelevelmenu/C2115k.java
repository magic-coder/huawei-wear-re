package com.huawei.ui.device.activity.onelevelmenu;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: OneLevelMenuManagerActivity */
class C2115k extends Handler {
    WeakReference<OneLevelMenuManagerActivity> f7467a;
    final /* synthetic */ OneLevelMenuManagerActivity f7468b;

    C2115k(OneLevelMenuManagerActivity oneLevelMenuManagerActivity, OneLevelMenuManagerActivity oneLevelMenuManagerActivity2) {
        this.f7468b = oneLevelMenuManagerActivity;
        this.f7467a = new WeakReference(oneLevelMenuManagerActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((OneLevelMenuManagerActivity) this.f7467a.get()) != null) {
            C2538c.m12677c("OneLevelMenuManagerActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 1:
                    this.f7468b.m10884f();
                    return;
                case 2:
                    this.f7468b.f7451t = false;
                    this.f7468b.m10870a(true);
                    this.f7468b.f7434c.setRightButtonClickable(false);
                    return;
                case 3:
                    this.f7468b.m10875b(true);
                    this.f7468b.f7451t = true;
                    this.f7468b.f7434c.setRightButtonClickable(false);
                    return;
                case 4:
                    this.f7468b.m10870a(false);
                    this.f7468b.m10875b(false);
                    this.f7468b.f7451t = false;
                    this.f7468b.f7434c.setRightButtonClickable(true);
                    return;
                case 5:
                    this.f7468b.f7435d.m11353a(this.f7468b.f7438g);
                    this.f7468b.f7435d.notifyDataSetChanged();
                    this.f7468b.m10869a(this.f7468b.f7443l, this.f7468b.f7435d);
                    this.f7468b.m10884f();
                    return;
                default:
                    return;
            }
        }
    }
}
