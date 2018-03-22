package com.huawei.hwfitnessmgr;

import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.data.p312b.C4551e;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessDataMigration */
class C5012c implements C4551e {
    final /* synthetic */ C5011b f18189a;

    C5012c(C5011b c5011b) {
        this.f18189a = c5011b;
    }

    public void mo4609a(HiHealthClient hiHealthClient) {
        C2538c.c("FitnessDataMigration", new Object[]{"registerDeviceToHiHealth onresult :", hiHealthClient});
    }
}
