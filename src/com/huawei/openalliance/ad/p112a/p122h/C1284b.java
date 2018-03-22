package com.huawei.openalliance.ad.p112a.p122h;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.huawei.openalliance.ad.inter.data.MagLockAd;
import com.huawei.openalliance.ad.inter.data.MagLockAdInfo;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1215a;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1217c;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1225k;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.MaterialRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class C1284b {
    public static C1221g m5661a(MaterialRecord materialRecord) {
        if (materialRecord == null) {
            return null;
        }
        C1221g c1221g = new C1221g();
        c1221g.setContentid__(materialRecord.m6022d());
        c1221g.setEndtime__(materialRecord.m6032g());
        c1221g.setStarttime__(materialRecord.m6035h());
        c1221g.setWidth__(materialRecord.m6038i());
        c1221g.setHeight__(materialRecord.m6041j());
        c1221g.setShowAppLogoFlag__(materialRecord.m6029f());
        c1221g.setCreativetype__(materialRecord.m6050o());
        c1221g.setHtml__(materialRecord.m6047m());
        c1221g.setInteractiontype__(materialRecord.m6049n());
        c1221g.setMd5__(materialRecord.m6010a());
        c1221g.setSha256__(materialRecord.m6014b());
        c1221g.setSkipText__(materialRecord.m6018c());
        if (!TextUtils.isEmpty(materialRecord.m6055t())) {
            C1225k c1225k = new C1225k();
            c1225k.setIntentUri__(materialRecord.m6055t());
            c1221g.setInteractionparam__(c1225k);
        }
        if (!TextUtils.isEmpty(materialRecord.m6054s())) {
            C1229o c1229o = new C1229o();
            try {
                c1229o.fromJson(new JSONObject(materialRecord.m6054s()));
            } catch (Exception e) {
                C1336d.m5888c("AdSourceUtil", "convert param json fail");
                c1229o = null;
            }
            c1221g.setParamfromserver__(c1229o);
        }
        Object q = materialRecord.m6052q();
        if (!TextUtils.isEmpty(q)) {
            c1221g.setImpmonitorurl__(Arrays.asList(q.split(";")));
        }
        q = materialRecord.m6051p();
        if (!TextUtils.isEmpty(q)) {
            c1221g.setClickmonitorurl__(Arrays.asList(q.split(";")));
        }
        return c1221g;
    }

    public static MaterialRecord m5662a() {
        MaterialRecord materialRecord = new MaterialRecord();
        materialRecord.m6030f(0);
        materialRecord.m6037h(C1287e.m5681a("yyyy-MM-dd"));
        return materialRecord;
    }

    public static MaterialRecord m5663a(String str, int i, C1221g c1221g, boolean z) {
        if (c1221g == null || TextUtils.isEmpty(str)) {
            return null;
        }
        MaterialRecord a = C1284b.m5662a();
        a.m6033g(c1221g.getInteractiontype__());
        if (c1221g.getInteractionparam__() != null) {
            a.m6048m(c1221g.getInteractionparam__().getIntentUri__());
        }
        a.m6039i(c1221g.getCreativetype__());
        a.m6040i(c1221g.getHtml__());
        a.m6031f(c1221g.getContentid__());
        a.m6034g(c1221g.getTaskid__());
        a.m6028e(str);
        a.m6016b(c1221g.getEndtime__());
        a.m6020c(c1221g.getStarttime__());
        a.m6023d(c1221g.getWidth__());
        a.m6027e(c1221g.getHeight__());
        a.m6019c(c1221g.getShowAppLogoFlag__());
        a.m6036h(0);
        if (z) {
            a.m6015b(0);
        } else {
            a.m6015b(1);
        }
        a.m6024d(C1287e.m5689d());
        if (c1221g.getParamfromserver__() != null) {
            try {
                a.m6046l(c1221g.getParamfromserver__().toJson());
            } catch (Exception e) {
                C1336d.m5888c("AdSourceUtil", "convert param fail");
                a.m6046l(null);
            }
        }
        a.mo2463a(c1221g.getMd5__());
        a.m6017b(c1221g.getSha256__());
        a.m6021c(c1221g.getSkipText__());
        if (c1221g.getMetaData__() != null) {
            try {
                a.m6025d(c1221g.getMetaData__().toJson());
            } catch (Exception e2) {
                C1336d.m5888c("AdSourceUtil", "convert metadata fail");
                a.m6025d(null);
            }
        }
        a.m6011a(i);
        a.m6044k(C1365i.m6079a(c1221g.getImpmonitorurl__(), ";"));
        a.m6042j(C1365i.m6079a(c1221g.getClickmonitorurl__(), ";"));
        return a;
    }

    public static void m5664a(Context context) {
        ContentValues contentValues = new ContentValues();
        String a = C1287e.m5681a("yyyy-MM-dd");
        contentValues.put("displayCount", Integer.valueOf(0));
        contentValues.put("displayDate", a);
        C1357a a2 = C1357a.m5982a(context);
        try {
            a2.m5986a(MaterialRecord.class.getSimpleName(), contentValues, "displayDate != ?", new String[]{a});
        } finally {
            a2.close();
        }
    }

    public static void m5665a(Context context, List<C1216b> list) {
        if (list != null) {
            List arrayList = new ArrayList(4);
            C1357a a = C1357a.m5982a(context);
            try {
                for (C1216b c1216b : list) {
                    if (c1216b != null) {
                        arrayList.add(c1216b.getSeq__());
                        if (!arrayList.isEmpty()) {
                            a.m5993a(AdEventRecord.class.getSimpleName(), arrayList, 0);
                        }
                    }
                }
            } catch (Exception e) {
                C1336d.m5888c("AdSourceUtil", "update lock time fail");
            } finally {
                a.close();
            }
        }
    }

    public static void m5666a(C1217c c1217c, List<String> list, List<String> list2) {
        if (c1217c != null) {
            if (C1284b.m5667a(c1217c.getRetcode())) {
                list.add(c1217c.getSeq());
            } else {
                list2.add(c1217c.getSeq());
            }
        }
    }

    private static boolean m5667a(int i) {
        return 200 == i || HeartRateDetail.HEART_RATE_TYPE_TRANQUILLIZATION == i || 611 == i;
    }

    public static boolean m5668a(C1215a c1215a) {
        return (c1215a.getContent__() == null || c1215a.getContent__().isEmpty()) ? false : true;
    }

    public static boolean m5669a(C1235b c1235b) {
        return (c1235b.getMultiad__() == null || c1235b.getMultiad__().isEmpty()) ? false : true;
    }

    public static boolean m5670a(MagLockAd magLockAd) {
        return (magLockAd.getAdList() == null || magLockAd.getAdList().isEmpty()) ? false : true;
    }

    public static boolean m5671a(MagLockAdInfo magLockAdInfo) {
        return (magLockAdInfo.getMultiAds() == null || magLockAdInfo.getMultiAds().isEmpty()) ? false : true;
    }
}
