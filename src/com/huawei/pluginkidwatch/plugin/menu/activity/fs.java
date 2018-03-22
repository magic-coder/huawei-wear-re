package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.button.C1514c;

/* compiled from: ProjectModeActivity */
class fs implements C1514c {
    final /* synthetic */ ProjectModeActivity f6133a;

    fs(ProjectModeActivity projectModeActivity) {
        this.f6133a = projectModeActivity;
    }

    public void mo2610a(boolean z) {
        C2538c.m12674b("ProjectModeActivity", "============Enter trackThrowpointChangeListener-->onChanged :", z + "");
        C1497q.m6942a(this.f6133a, "is_track_throwpoint", Boolean.valueOf(z));
    }
}
