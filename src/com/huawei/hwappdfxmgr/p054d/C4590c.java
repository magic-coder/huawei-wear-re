package com.huawei.hwappdfxmgr.p054d;

import com.amap.api.maps.model.WeightedLatLng;
import java.security.Provider;

/* compiled from: PRNGFixes */
class C4590c extends Provider {
    public C4590c() {
        super("LinuxPRNG", WeightedLatLng.DEFAULT_INTENSITY, "A Linux-specific random number provider that uses /dev/urandom");
        put("SecureRandom.SHA1PRNG", C4589b.class.getName());
        put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
}
