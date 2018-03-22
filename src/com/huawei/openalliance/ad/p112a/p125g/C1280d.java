package com.huawei.openalliance.ad.p112a.p125g;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.openalliance.ad.inter.data.MagLockAd;
import com.huawei.openalliance.ad.inter.data.MagLockAdContent;
import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import com.huawei.openalliance.ad.inter.listener.AdListener;
import com.huawei.openalliance.ad.inter.listener.MagLockListener;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1223i;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1227m;
import com.huawei.openalliance.ad.p112a.p122h.C1284b;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1280d implements C1278b {
    private static int[] f2723a = new int[]{200, 206};
    private static int[] f2724b = new int[]{204, HttpStatus.SC_LOCKED, HttpStatus.SC_FAILED_DEPENDENCY, 425, 432, 442};
    private C1235b f2725c = null;

    public C1280d() {
        Arrays.sort(f2723a);
        Arrays.sort(f2724b);
    }

    private MagLockAdContent m5638a(C1221g c1221g) {
        MagLockAdContent magLockAdContent = new MagLockAdContent();
        magLockAdContent.setContentId(c1221g.getContentid__());
        C1227m metaData__ = c1221g.getMetaData__();
        if (metaData__ != null) {
            C1223i c1223i;
            List imageInfo__ = metaData__.getImageInfo__();
            if (!(imageInfo__ == null || imageInfo__.isEmpty())) {
                c1223i = (C1223i) imageInfo__.get(0);
                magLockAdContent.setUrl(c1223i.getUrl__());
                magLockAdContent.setMd5(c1223i.getMd5__());
                magLockAdContent.setSha256(c1223i.getSha256__());
                magLockAdContent.setFileSize((long) c1223i.getFileSize__());
            }
            c1223i = metaData__.getThumbNail__();
            if (c1223i != null) {
                magLockAdContent.setPreviewUrl(c1223i.getUrl__());
                magLockAdContent.setPreviewMd5(c1223i.getMd5__());
                magLockAdContent.setPreviewSha256(c1223i.getSha256__());
            }
        }
        magLockAdContent.setEndTime(c1221g.getEndtime__());
        if (c1221g.getParamfromserver__() != null) {
            try {
                magLockAdContent.setParamFromServer(c1221g.getParamfromserver__().toJson());
            } catch (Exception e) {
                C1336d.m5888c("", "fail to parse paramfromserver to json string");
            }
        }
        if (c1221g.getMetaData__() != null) {
            try {
                magLockAdContent.setMetaData(c1221g.getMetaData__().toJson());
            } catch (Exception e2) {
                C1336d.m5888c("", "fail to parse metaData to json string");
            }
        }
        magLockAdContent.setImpMonitorUrl(C1365i.m6079a(c1221g.getImpmonitorurl__(), ";"));
        magLockAdContent.setClickMonitorUrl(C1365i.m6079a(c1221g.getClickmonitorurl__(), ";"));
        return magLockAdContent;
    }

    private MagLockAdInfo m5639b(C1235b c1235b) {
        if (c1235b == null) {
            return null;
        }
        MagLockAdInfo magLockAdInfo = new MagLockAdInfo();
        magLockAdInfo.setRetCode(c1235b.getRetcode__());
        magLockAdInfo.setInvalidContentIds(c1235b.getInvalidcontentid__());
        if (C1284b.m5669a(c1235b)) {
            List arrayList = new ArrayList(4);
            for (C1215a c1215a : c1235b.getMultiad__()) {
                if (c1215a != null) {
                    MagLockAd magLockAd = new MagLockAd();
                    magLockAd.setRetCode(c1215a.getRetcode30__());
                    magLockAd.setSlotId(c1215a.getSlotid__());
                    if (200 == c1215a.getRetcode30__() && C1284b.m5668a(c1215a)) {
                        List arrayList2 = new ArrayList(4);
                        for (C1221g c1221g : c1215a.getContent__()) {
                            if (c1221g != null) {
                                arrayList2.add(m5638a(c1221g));
                            }
                        }
                        magLockAd.setAdList(arrayList2);
                    }
                    arrayList.add(magLockAd);
                }
            }
            magLockAdInfo.setMultiAds(arrayList);
        }
        return magLockAdInfo;
    }

    public void mo2442a(int i, AdListener adListener) {
        if (adListener != null && (adListener instanceof MagLockListener)) {
            MagLockListener magLockListener = (MagLockListener) adListener;
            if (Arrays.binarySearch(f2723a, i) >= 0 && this.f2725c != null) {
                magLockListener.onAdSuccess(m5639b(this.f2725c));
            } else if (Arrays.binarySearch(f2724b, i) >= 0 && this.f2725c != null) {
                magLockListener.onAdFailed(i, this.f2725c.getInvalidcontentid__());
            } else if (this.f2725c != null) {
                magLockListener.onAdFailed(499, this.f2725c.getInvalidcontentid__());
            } else {
                magLockListener.onAdFailed(499, null);
            }
        }
    }

    public boolean mo2443a(C1235b c1235b) {
        this.f2725c = c1235b;
        return 200 == c1235b.getRetcode__() || 206 == c1235b.getRetcode__();
    }
}
