package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.MagLockAd;
import com.huawei.openalliance.ad.inter.data.MagLockAdContent;
import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1227m;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.p112a.p122h.C1284b;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class C1272l {
    private static C1221g m5609a(MagLockAdContent magLockAdContent) {
        C1221g c1221g = new C1221g();
        c1221g.setContentid__(magLockAdContent.getContentId());
        c1221g.setEndtime__(magLockAdContent.getEndTime());
        c1221g.setCreativetype__(5);
        C1229o c1229o = new C1229o();
        if (!TextUtils.isEmpty(magLockAdContent.getParamFromServer())) {
            try {
                c1229o.fromJson(new JSONObject(magLockAdContent.getParamFromServer()));
            } catch (Exception e) {
                C1336d.m5888c("MagLockTools", "convert paramFromServer json fail");
                c1229o = null;
            }
            c1221g.setParamfromserver__(c1229o);
        }
        C1227m c1227m = new C1227m();
        if (!TextUtils.isEmpty(magLockAdContent.getMetaData())) {
            try {
                c1227m.fromJson(new JSONObject(magLockAdContent.getMetaData()));
            } catch (Exception e2) {
                C1336d.m5888c("MagLockTools", "convert metaData fail");
            }
            c1221g.setMetaData__(c1227m);
        }
        Object impMonitorUrl = magLockAdContent.getImpMonitorUrl();
        if (!TextUtils.isEmpty(impMonitorUrl)) {
            c1221g.setImpmonitorurl__(Arrays.asList(impMonitorUrl.split(";")));
        }
        impMonitorUrl = magLockAdContent.getClickMonitorUrl();
        if (!TextUtils.isEmpty(impMonitorUrl)) {
            c1221g.setClickmonitorurl__(Arrays.asList(impMonitorUrl.split(";")));
        }
        return c1221g;
    }

    private static C1235b m5610a(MagLockAdInfo magLockAdInfo) {
        C1235b c1235b = new C1235b();
        c1235b.setRetcode__(magLockAdInfo.getRetCode());
        c1235b.setInvalidcontentid__(magLockAdInfo.getInvalidContentIds());
        if (C1284b.m5671a(magLockAdInfo)) {
            List arrayList = new ArrayList(4);
            for (MagLockAd magLockAd : magLockAdInfo.getMultiAds()) {
                if (magLockAd != null) {
                    C1215a c1215a = new C1215a();
                    c1215a.setSlotid__(magLockAd.getSlotId());
                    c1215a.setRetcode30__(magLockAd.getRetCode());
                    if (C1284b.m5670a(magLockAd)) {
                        List arrayList2 = new ArrayList(4);
                        for (MagLockAdContent magLockAdContent : magLockAd.getAdList()) {
                            if (magLockAdContent != null) {
                                arrayList2.add(C1272l.m5609a(magLockAdContent));
                            }
                        }
                        c1215a.setContent__(arrayList2);
                    }
                    arrayList.add(c1215a);
                }
            }
            c1235b.setMultiad__(arrayList);
        }
        return c1235b;
    }

    public static void m5611a(Context context, MagLockAdInfo magLockAdInfo) {
        if (magLockAdInfo != null) {
            try {
                new C1269i().m5605b(context, C1272l.m5610a(magLockAdInfo));
            } catch (Exception e) {
                C1336d.m5888c("MagLockTools", "iterator maglock content fail");
            }
        }
    }
}
