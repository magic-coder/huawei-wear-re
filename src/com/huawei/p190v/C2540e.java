package com.huawei.p190v;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LogUtil */
class C2540e {
    private List<String> f9052a = new ArrayList();
    private boolean f9053b = true;

    void m12691a(boolean z) {
        this.f9053b = z;
    }

    boolean m12692a(int i, String str) {
        if (!m12688a(i)) {
            return false;
        }
        if (!this.f9053b || m12690a(str)) {
            return true;
        }
        return false;
    }

    private boolean m12688a(int i) {
        if (i >= (this.f9053b ? C2542g.f9058c : C2542g.f9056a)) {
            return true;
        }
        return false;
    }

    private boolean m12690a(String str) {
        if (str == null || !str.contains(HwAccountConstants.SPLIIT_UNDERLINE)) {
            return false;
        }
        String[] split = str.split(HwAccountConstants.SPLIIT_UNDERLINE);
        if (split.length < 1) {
            return false;
        }
        if (this.f9052a.contains(split[0])) {
            return true;
        }
        return false;
    }
}
