package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.inter.data.SplashParam;
import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.p112a.p117c.C1245a;
import com.huawei.openalliance.ad.p112a.p117c.C1245a.C1244a;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p121e.C1254f;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p121e.C1258j;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.p112a.p124i.C1312i;
import com.huawei.openalliance.ad.p112a.p124i.C1312i.C1273a;
import com.huawei.openalliance.ad.p112a.p124i.C1315l;
import com.huawei.openalliance.ad.p112a.p124i.C1315l.C1274a;
import com.huawei.openalliance.ad.p112a.p125g.C1278b;
import com.huawei.openalliance.ad.p112a.p125g.C1282f;
import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.db.bean.SloganRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import com.sina.weibo.sdk.component.ShareRequestParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class C1275m implements C1244a, C1273a, C1274a {
    private Context f2709a;
    private SplashParam f2710b;
    private SplashListener f2711c;
    private long f2712d;
    private C1312i f2713e;
    private int f2714f = 3000;
    private C1278b f2715g = new C1282f();
    private C1315l f2716h;
    private C1221g f2717i;
    private int f2718j = 1;
    private C1245a f2719k;

    public C1275m(Context context, SplashParam splashParam, SplashListener splashListener) {
        this.f2709a = context;
        this.f2710b = splashParam;
        this.f2711c = splashListener;
        this.f2719k = new C1245a(context, this);
        this.f2716h = new C1315l(context, splashParam, splashListener, this);
        this.f2713e = new C1312i(context, splashParam, this);
        this.f2718j = C1289h.m5695a(context).m5705c();
    }

    private boolean m5617a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C1336d.m5886b("SplashController", str);
        return C1345b.m5938a(new File(str), (long) C1287e.m5679a(this.f2709a, i), str2);
    }

    private boolean m5618b(int i) {
        boolean z;
        int i2 = 4;
        SloganRecord sloganRecord = null;
        boolean z2 = true;
        this.f2714f = C1289h.m5695a(this.f2709a).m5711e();
        if (this.f2714f == 0) {
            return false;
        }
        String str;
        boolean z3;
        this.f2710b.showSlogan();
        this.f2710b.showLogo();
        this.f2710b.hideAdView();
        this.f2710b.getSlogan().addView(this.f2713e);
        SloganRecord a = C1258j.m5572a(this.f2709a, this.f2710b.getOrientation());
        if (a == null || a.m6059c() == null) {
            str = null;
            z3 = false;
        } else {
            str = a.m6059c();
            z3 = m5617a(str, null, a.m6058b());
        }
        if (z3) {
            sloganRecord = a;
        }
        if (z3) {
            if (4 == sloganRecord.m6058b()) {
                this.f2714f = C1289h.m5695a(this.f2709a).m5725l();
                if (1000 == i) {
                    i = 1007;
                }
                z = true;
            } else {
                i2 = 2;
                z = false;
            }
            this.f2713e.m5815a(str, i2, i);
            C1221g c1221g = new C1221g();
            c1221g.setShowid__(String.valueOf(C1287e.m5689d()));
            if (!TextUtils.isEmpty(sloganRecord.m6060d())) {
                C1229o c1229o = new C1229o();
                try {
                    c1229o.fromJson(new JSONObject(sloganRecord.m6060d()));
                } catch (Throwable e) {
                    C1336d.m5883a("SplashController", "convert param error", e);
                }
                c1221g.setParamfromserver__(c1229o);
            }
            C1249b.m5535a(this.f2709a, 1, C1249b.m5531a("imp", c1221g));
        } else {
            Resources resources = this.f2709a.getResources();
            try {
                if (C1345b.m5939a(resources.openRawResource(this.f2710b.getDefaultSlogan()))) {
                    this.f2714f = C1289h.m5695a(this.f2709a).m5725l();
                    if (1000 == i) {
                        i = 1007;
                    }
                    try {
                        this.f2713e.m5813a(this.f2710b.getDefaultSlogan(), i);
                    } catch (NotFoundException e2) {
                        z = true;
                        C1336d.m5888c("SplashController", "resource is not exist");
                        return z;
                    }
                }
                this.f2713e.m5814a(BitmapFactory.decodeResource(resources, this.f2710b.getDefaultSlogan()));
                z2 = false;
                z = z2;
            } catch (NotFoundException e3) {
                z = false;
                C1336d.m5888c("SplashController", "resource is not exist");
                return z;
            }
        }
        return z;
    }

    private int m5619e() {
        long g = (2 == this.f2718j ? C1289h.m5695a(this.f2709a).m5715g() : 0) - (C1287e.m5689d() - this.f2712d);
        if (g < 0) {
            g = 1;
        }
        return (int) g;
    }

    private void m5620f() {
        if (2 != this.f2718j) {
            List arrayList = new ArrayList(4);
            arrayList.add(this.f2710b.getAdId());
            C1261a.m5578a(this.f2709a, 1, arrayList, this.f2711c, this.f2715g, this.f2710b.isTest(), this.f2710b.getOrientation(), this.f2710b.getDeviceType(), null);
        }
    }

    public void mo2432a() {
        if (this.f2711c != null) {
            this.f2711c.onAdDismissed();
        }
        if (this.f2717i != null) {
            C1249b.m5535a(this.f2709a, 1, C1249b.m5531a("showstop", this.f2717i));
        }
        m5620f();
    }

    public void mo2433a(int i) {
        this.f2719k.sendEmptyMessage(i);
    }

    public void mo2434a(int i, int i2) {
        Message obtainMessage = this.f2719k.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.what = 1004;
        this.f2719k.sendMessage(obtainMessage);
    }

    public void mo2435a(Message message) {
        C1249b.m5534a(this.f2709a, 1, message.arg1, message.arg2, EventType.CLICK, this.f2717i);
        C1249b.m5535a(this.f2709a, 1, C1249b.m5531a("showstop", this.f2717i));
        m5620f();
    }

    public void m5625a(C1221g c1221g) {
        int i = 4;
        this.f2710b.getAdView().addView(this.f2716h);
        this.f2717i = c1221g;
        this.f2714f = C1289h.m5695a(this.f2709a).m5701b();
        if (c1221g != null) {
            String a = C1365i.m6078a(c1221g.getHtml__(), ShareRequestParam.REQ_UPLOAD_PIC_PARAM_IMG, "src");
            if (m5617a(a, c1221g.getMd5__(), c1221g.getCreativetype__())) {
                this.f2710b.hideSlogan();
                this.f2710b.showAdView();
                if (2 != c1221g.getShowAppLogoFlag__()) {
                    this.f2710b.showLogo();
                } else {
                    this.f2710b.hideLogo();
                }
                if (4 == c1221g.getCreativetype__()) {
                    this.f2714f = C1289h.m5695a(this.f2709a).m5725l();
                } else {
                    i = 2;
                }
                this.f2716h.m5831a(c1221g, a, i);
                C1366j.f2950b.execute(new C1276n(this, c1221g));
                C1254f.m5560d(this.f2709a);
                return;
            }
            this.f2714f = m5619e();
            return;
        }
        this.f2714f = m5619e();
    }

    public void mo2436a(String str) {
        int i = (C1289h.m5695a(this.f2709a).m5735t() >= C1287e.m5689d() || str == null) ? 0 : 1;
        C1221g a = (i == 0 || !this.f2713e.m5816a()) ? null : C1255g.m5562a(this.f2709a, this.f2710b.getAdId(), str, this.f2710b.getOrientation(), 1);
        if (a != null) {
            a.setShowid__("" + C1287e.m5689d());
        }
        m5625a(a);
        this.f2719k.sendEmptyMessageDelayed(1003, (long) this.f2714f);
    }

    public void m5627a(boolean z) {
        C1221g c1221g = null;
        if (z) {
            c1221g = C1255g.m5562a(this.f2709a, this.f2710b.getAdId(), null, this.f2710b.getOrientation(), 1);
        }
        if (c1221g == null) {
            m5618b(1003);
            if (this.f2714f == 0 && this.f2711c != null) {
                this.f2711c.onAdDismissed();
                return;
            }
        }
        c1221g.setShowid__("" + C1287e.m5689d());
        m5625a(c1221g);
        this.f2719k.sendEmptyMessageDelayed(1003, (long) this.f2714f);
    }

    public void mo2437b() {
        m5625a(null);
        this.f2719k.sendEmptyMessageDelayed(1003, (long) this.f2714f);
    }

    public void mo2438b(int i, int i2) {
        Message obtainMessage = this.f2719k.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.what = 1005;
        this.f2719k.sendMessage(obtainMessage);
    }

    public void mo2439b(Message message) {
        if (this.f2717i != null) {
            C1216b a = C1249b.m5530a("userclose", message.arg1, message.arg2, this.f2717i);
            C1254f.m5558b(this.f2709a);
            C1249b.m5535a(this.f2709a, 1, a);
            C1249b.m5535a(this.f2709a, 1, C1249b.m5531a("showstop", this.f2717i));
        }
        m5620f();
    }

    public void m5631c() {
        int i = 1000;
        boolean z = true;
        this.f2712d = C1287e.m5689d();
        if (2 == this.f2718j) {
            boolean b = m5618b(1000);
            int e = C1289h.m5695a(this.f2709a).m5711e();
            if (b) {
                e = C1289h.m5695a(this.f2709a).m5725l();
                i = 1007;
                this.f2719k.m5524a();
            }
            this.f2719k.sendEmptyMessageDelayed(i, (long) e);
            List arrayList = new ArrayList(4);
            arrayList.add(this.f2710b.getAdId());
            C1261a.m5578a(this.f2709a, 1, arrayList, this.f2711c, this.f2715g, this.f2710b.isTest(), this.f2710b.getOrientation(), this.f2710b.getDeviceType(), this.f2719k);
            return;
        }
        C1289h a = C1289h.m5695a(this.f2709a);
        long d = C1287e.m5689d();
        if (C1254f.m5556a(this.f2709a) || a.m5735t() >= d) {
            z = false;
        }
        m5627a(z);
    }

    public void mo2440d() {
        this.f2719k.sendEmptyMessage(1003);
    }
}
