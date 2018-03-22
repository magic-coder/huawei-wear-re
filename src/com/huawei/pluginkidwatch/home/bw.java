package com.huawei.pluginkidwatch.home;

import cn.com.xy.sms.a.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1487g;
import java.security.SecureRandom;
import java.util.HashMap;

/* compiled from: SettingFragment */
class bw implements Runnable {
    final /* synthetic */ bu f4342a;

    bw(bu buVar) {
        this.f4342a = buVar;
    }

    public void run() {
        this.f4342a.f4339m = new HashMap();
        this.f4342a.f4339m.put("ONLINE_UPDATE_SDK", "1");
        this.f4342a.f4339m.put("SUPPORT_NETWORK_TYPE", "2");
        this.f4342a.f4339m.put("CUSTOM_PUBINFO_SERVER_URL", "https://olapi" + (new SecureRandom().nextInt(10) + 1) + ".bizport.cn/");
        this.f4342a.f4339m.put("RSAPRVKEY", C1487g.m6873a(this.f4342a.f4337k, "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"));
        this.f4342a.f4339m.put("SECRETKEY", C1487g.m6873a(this.f4342a.f4337k, "1D6DD87A477DB8143749AC7CBFD7D5A5CMgUjAtqLActKpn5oSTXMqxa85e/GOiDJDzgMV/f4t8jGUs/g++a5QXJsCp+slkaf8JvOJMYYUHyPscm2fGf7sOI/tgCLlTb1maCHCxzGn7sDeZesgOuDHKbE+KjtBsIOZJlu3yrDudWU+DEAYxDPuieH50BwWNnvRyj4nbjyL2N8WKiYwk0DRoOTvdsDVSlWGHxGCIiTD8G5d16JVLEd3UBZeNsrWM/bGiHQRyVHZDA2Rhidi1I0vlmuUt1rCp4dRv2ks1vv6wk0voi1Lrvcj47Pq+3RmyjVSAdTBodsByBbU9JigDZfcdy/c6UYRFooQEm9pUGMS4Q4i0DsfQs3RQUPl9+AGGTfwB0EUWfoEZOj62nXYakXWaPTYXzxIg1JuMnzFIVAP9hsLPKIj3e84OsVa03hUVKTrdNCoiKo8RpPuDrdWSrclnUHyTbyKgWjGUHQ48WI6JE1xvyWJ5t1jsLik1NGXXsacf31BWMKVNXaIWO8xA8qslnuEz8Veuoo3C32JJTeFmfzTbg8TgYyJ7psw8/zulL4eJWt7GwGHVS5YogQY1VrZYnoIMNG0mCWhPkNyzMmm6PZFn3ccNnzSlTVXPY2dmRdTDhiXaI4+6EXl0r70dBrFpN1Cc85s+aCGERzK5qxzcLlBPtbMR/gJV/p9TlaGerp5xCkvgrIg0YMgY+v1ltpZaIjxOfGb7Rk7Jn+Dnk14cQdnTPCh1hJ9Ufw93x1F+EPKSoOOxsa4I7shHkjZWk7ciblFro96p7mi3yFYO8/hBRhcuAf2HdKMGb/PTjJ5p+Fdef9rVQQLBkogX9IEbxEhNDfJFTKyKaesWKpuPlQzhF69X6yQP4fPtEJbP9MwneBmtGI9F+ZqLi9dMoVoU9SCMPE5zbAzEdgF3gUr4tz+3qwihKgJa2N6k97wTyVVoKLmjUJo91t4Nj01YlVtaXB2v2IeVgIL0hFp1nHmbDrfQZEH93p2F8i31ILbt0nnaQ5TV2duY2ecSqEjTIKGwcaYUSpkdtcCaWG5AKH0CyUvAg/DPNflqCc4PBihHmvUK2V/Dm4JfSCtqPiK8rAXsqUobuPfSgGXNcU3mACVUz2d3mr54vNuWd+Y95MciLZFJYYvpnj1zJqhQGjYdqm87FaQshoH9ofAoX"));
        a.a(this.f4342a.f4337k, "HUAWEIAND", "", true, true, this.f4342a.f4339m);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            C2538c.m12680e("KIDWATCH_SettingFragment", "Exception e = " + e.getMessage());
        }
    }
}
