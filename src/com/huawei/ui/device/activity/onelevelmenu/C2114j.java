package com.huawei.ui.device.activity.onelevelmenu;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.BuildConfig;
import java.util.Map;

/* compiled from: OneLevelMenuManagerActivity */
class C2114j implements IBaseResponseCallback {
    final /* synthetic */ OneLevelMenuManagerActivity f7466a;

    C2114j(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7466a = oneLevelMenuManagerActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===getDataFromBand isTimeout=" + this.f7466a.f7451t);
        this.f7466a.f7454w.removeMessages(3);
        if (!this.f7466a.f7451t) {
            C2538c.m12677c("OneLevelMenuManagerActivity", "===123===getDataFromBand err_code=" + i + "objData=" + obj);
            if (i == 0) {
                C2538c.m12677c("OneLevelMenuManagerActivity", "Enter getDataFromBand():mOneMenuHandler=" + this.f7466a.f7454w);
                try {
                    this.f7466a.f7432a = (Map) obj;
                } catch (Exception e) {
                    C2538c.m12680e("OneLevelMenuManagerActivity", "catch (Exception e)" + e.getMessage());
                }
                byte[] bArr = (byte[]) this.f7466a.f7432a.get("all");
                if (bArr != null) {
                    int i2;
                    this.f7466a.f7439h.clear();
                    for (i2 = 0; i2 < bArr.length; i2++) {
                        if (this.f7466a.f7437f.m10310a(this.f7466a.f7437f.m10307a(bArr[i2]))) {
                            this.f7466a.f7439h.add(Integer.valueOf(this.f7466a.f7437f.m10307a(bArr[i2])));
                        }
                    }
                    C2538c.m12677c("OneLevelMenuManagerActivity", "===123===getDataFromBand mAllList=" + this.f7466a.f7439h);
                    bArr = (byte[]) this.f7466a.f7432a.get(BuildConfig.sdk_log_switch);
                    if (bArr != null) {
                        this.f7466a.f7438g.clear();
                        this.f7466a.f7440i.clear();
                        for (i2 = 0; i2 < bArr.length; i2++) {
                            if (this.f7466a.f7437f.m10310a(this.f7466a.f7437f.m10307a(bArr[i2]))) {
                                this.f7466a.f7438g.add(Integer.valueOf(this.f7466a.f7437f.m10307a(bArr[i2])));
                                this.f7466a.f7440i.add(Integer.valueOf(this.f7466a.f7437f.m10307a(bArr[i2])));
                            }
                        }
                        this.f7466a.f7454w.sendEmptyMessage(4);
                        this.f7466a.f7454w.sendEmptyMessage(5);
                        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===getDataFromBand mMenuTables=" + this.f7466a.f7438g);
                        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===getDataFromBand mMenuItemFromBandTables=" + this.f7466a.f7440i);
                    }
                }
            }
        }
    }
}
