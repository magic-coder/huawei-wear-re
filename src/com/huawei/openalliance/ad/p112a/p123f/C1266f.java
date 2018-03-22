package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.openalliance.ad.inter.data.ChannelInfo;
import com.huawei.openalliance.ad.inter.data.CubeConfig;
import com.huawei.openalliance.ad.inter.listener.MagLockConfigListener;
import com.huawei.openalliance.ad.p112a.p113a.C1236c;
import com.huawei.openalliance.ad.p112a.p113a.C1237d;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1224j;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1226l;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p122h.C1286d;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1266f {
    private static int[] f2693a = new int[]{200, 421, HttpStatus.SC_LOCKED};

    static {
        Arrays.sort(f2693a);
    }

    public static void m5592a(Context context, String str, MagLockConfigListener magLockConfigListener) {
        if (context != null && !C1365i.m6081a(str)) {
            try {
                new C1286d(context, C1243a.f2654b, new C1236c(str), new C1267g(magLockConfigListener)).executeOnExecutor(C1366j.f2949a, new Void[0]);
            } catch (Exception e) {
                C1336d.m5888c("AppConfig", "request config fail");
            }
        }
    }

    private static CubeConfig m5594b(C1237d c1237d) {
        if (c1237d == null) {
            return null;
        }
        CubeConfig cubeConfig = new CubeConfig();
        C1226l magazinelockBoxPara__ = c1237d.getMagazinelockBoxPara__();
        if (magazinelockBoxPara__ != null) {
            cubeConfig.setRequestTimeInterval(magazinelockBoxPara__.getBoxRequestTimeInterval__());
            cubeConfig.setScreenSaverPoolSize(magazinelockBoxPara__.getBoxScreenSaverPoolSize__());
            cubeConfig.setSerialAdCount(magazinelockBoxPara__.getBoxScreenSaverSerialAdCount__());
            cubeConfig.setSerialNoAdCount(magazinelockBoxPara__.getBoxScreenSaverSerialNoadCount__());
            cubeConfig.setStartUpPoolSize(magazinelockBoxPara__.getBoxStartupPoolSize__());
            List<C1224j> channelInfo__ = magazinelockBoxPara__.getChannelInfo__();
            if (!(channelInfo__ == null || channelInfo__.isEmpty())) {
                List arrayList = new ArrayList(4);
                for (C1224j c1224j : channelInfo__) {
                    ChannelInfo channelInfo = new ChannelInfo();
                    channelInfo.setChannelId(c1224j.getChannelId__());
                    channelInfo.setChannelName(c1224j.getChannelName__());
                    channelInfo.setSlotId(c1224j.getSlotid__());
                    arrayList.add(channelInfo);
                }
                cubeConfig.setChannelInfo(arrayList);
            }
        }
        return cubeConfig;
    }

    private static void m5595b(Context context, C1237d c1237d) {
        C1289h a = C1289h.m5695a(context);
        a.m5697a(c1237d.getSplashcachenum_());
        a.m5702b(c1237d.getSplashshow_());
        a.m5706c(c1237d.getSplashmode_());
        a.m5710d(c1237d.getSplashSkipArea__());
        a.m5712e(c1237d.getSloganShowTime__());
        a.m5698a(c1237d.getSplashShowTimeInterval__());
        a.m5703b(c1237d.getSloganShowMinTimeRealMode__());
        a.m5714f(c1237d.getSplashUserAppDayImpFc__());
        a.m5704b(c1237d.getReduceDisturbRule__(a.m5723k()));
        a.m5718h(c1237d.getGifTimeUpperLimit__(a.m5725l()));
        a.m5720i(c1237d.getGifTimeLowerLimitFrame__(a.m5727m()));
        a.m5722j(c1237d.getGifSizeUpperLimit__(a.m5729n()));
        a.m5724k(c1237d.getImgSizeUpperLimit__(a.m5730o()));
    }
}
