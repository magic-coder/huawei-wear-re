package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.ab.C3270a;
import com.amap.api.mapcore.util.ah.C3277a;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;

/* compiled from: CityObject */
public class C3323g extends OfflineMapCity implements ac, ah, C3322p {
    public al f11777a;
    public al f11778b;
    public al f11779c;
    public al f11780d;
    public al f11781e;
    public al f11782f;
    public al f11783g;
    public al f11784h;
    al f11785i;
    Context f11786j;
    private String f11787k;
    private String f11788l;
    private long f11789m;

    public String m16116a() {
        return this.f11788l;
    }

    public String mo4057b() {
        return getUrl();
    }

    public C3323g(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        m16140r();
    }

    public C3323g(Context context, int i) {
        this.f11777a = new an(6, this);
        this.f11778b = new at(2, this);
        this.f11779c = new ap(0, this);
        this.f11780d = new ar(3, this);
        this.f11781e = new as(1, this);
        this.f11782f = new am(4, this);
        this.f11783g = new aq(7, this);
        this.f11784h = new ao(-1, this);
        this.f11787k = null;
        this.f11788l = "";
        this.f11789m = 0;
        this.f11786j = context;
        m16117a(i);
    }

    public void m16117a(int i) {
        switch (i) {
            case -1:
                this.f11785i = this.f11784h;
                return;
            case 0:
                this.f11785i = this.f11779c;
                return;
            case 1:
                this.f11785i = this.f11781e;
                return;
            case 2:
                this.f11785i = this.f11778b;
                return;
            case 3:
                this.f11785i = this.f11780d;
                return;
            case 4:
                this.f11785i = this.f11782f;
                return;
            case 6:
                this.f11785i = this.f11777a;
                return;
            case 7:
                this.f11785i = this.f11783g;
                return;
            default:
                if (i < 0) {
                    this.f11785i = this.f11784h;
                    return;
                } else {
                    ag.m15456b("this kind stateId is not found !! " + i);
                    return;
                }
        }
    }

    public void m16121a(al alVar) {
        this.f11785i = alVar;
        setState(alVar.m15488b());
    }

    public al m16125c() {
        return this.f11785i;
    }

    public void m16126d() {
        C3328h.m16149a(this.f11786j).m16167b(this);
    }

    public void m16127e() {
        C3328h.m16149a(this.f11786j).m16173d(this);
        m16126d();
    }

    public void m16128f() {
        ag.m15453a("CityOperation current State==>" + m16125c().m15488b());
        if (this.f11785i.equals(this.f11780d)) {
            this.f11785i.mo4012e();
        } else if (this.f11785i.equals(this.f11779c)) {
            this.f11785i.mo4009f();
        } else if (this.f11785i.equals(this.f11783g) || this.f11785i.equals(this.f11784h)) {
            this.f11785i.mo4008d();
        } else {
            m16125c().mo4006c();
        }
    }

    public void m16129g() {
        this.f11785i.mo4010g();
    }

    public void m16130h() {
        this.f11785i.mo4005a();
    }

    public void m16131i() {
        if (!this.f11785i.equals(this.f11782f)) {
            ag.m15456b("state must be COMPLETE_STATE when CheckUpdate ~ hasNewVersion");
        }
        this.f11785i.mo4007h();
    }

    public void m16132j() {
        C3328h.m16149a(this.f11786j).m16162a(this);
    }

    public void m16133k() {
        C3328h.m16149a(this.f11786j).m16170c(this);
    }

    public void mo4058l() {
        this.f11789m = 0;
        setCompleteCode(0);
        if (!this.f11785i.equals(this.f11778b)) {
            Log.e("state", "state must be waiting when download onStart");
        }
        this.f11785i.mo4008d();
    }

    public void mo4054a(long j, long j2) {
        long j3 = (100 * j2) / j;
        ag.m15456b("onProgress " + ((int) j3));
        if (((int) j3) > getcompleteCode()) {
            setCompleteCode((int) j3);
            m16126d();
        }
    }

    public void mo4059m() {
        if (!this.f11785i.equals(this.f11779c)) {
            Log.e("state", "state must be Loading when download onFinish");
        }
        this.f11785i.mo4011i();
    }

    public void mo4055a(C3277a c3277a) {
        if (this.f11785i.equals(this.f11779c) || this.f11785i.equals(this.f11778b)) {
            this.f11785i.mo4010g();
        } else {
            ag.m15456b("state must be loading or waiting  when download onError");
        }
    }

    public void mo4060n() {
        m16127e();
    }

    public void mo4061o() {
        this.f11789m = 0;
        setCompleteCode(0);
        if (!this.f11785i.equals(this.f11781e)) {
            ag.m15456b("state must be UNZIP_STATE when download onUnZipStart");
        }
        this.f11785i.mo4008d();
    }

    public void mo4062p() {
        if (!this.f11785i.equals(this.f11781e)) {
            ag.m15456b("state must be UNZIP_STATE when download onUnZipStart");
        }
        this.f11785i.mo4010g();
    }

    public void mo4053a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11789m > 500) {
            if (((int) j) > getcompleteCode()) {
                setCompleteCode((int) j);
                m16126d();
            }
            ag.m15456b("onUnzipSchedule " + j);
            this.f11789m = currentTimeMillis;
        }
    }

    public void mo4056a(String str) {
        if (!this.f11785i.equals(this.f11781e)) {
            ag.m15456b("state must be UNZIP_STATE when download onUnzipFinish");
        }
        this.f11788l = str;
        Object s = m16141s();
        Object t = m16142t();
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(t)) {
            mo4062p();
            return;
        }
        File file = new File(t + "/");
        File file2 = new File(bk.m15654a(this.f11786j) + "vmap/");
        File file3 = new File(bk.m15654a(this.f11786j));
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        m16115a(file, file2, s);
    }

    public void mo4063q() {
        m16127e();
    }

    protected void m16140r() {
        this.f11787k = bk.m15673b(this.f11786j) + getAdcode() + LightCloudConstants.ZIP_POSTFIX + ".tmp";
    }

    public String m16141s() {
        if (TextUtils.isEmpty(this.f11787k)) {
            return null;
        }
        return this.f11787k.substring(0, this.f11787k.lastIndexOf("."));
    }

    public String m16142t() {
        if (TextUtils.isEmpty(this.f11787k)) {
            return null;
        }
        String s = m16141s();
        return s.substring(0, s.lastIndexOf(46));
    }

    private void m16115a(final File file, File file2, final String str) {
        new ab().m15396a(file, file2, -1, ag.m15450a(file), new C3270a(this) {
            final /* synthetic */ C3323g f11766c;

            public void mo4048a(String str, String str2, float f) {
                int i = (int) (60.0d + (((double) f) * 0.39d));
                if (i - this.f11766c.getcompleteCode() > 0 && System.currentTimeMillis() - this.f11766c.f11789m > 1000) {
                    this.f11766c.setCompleteCode(i);
                    this.f11766c.f11789m = System.currentTimeMillis();
                }
            }

            public void mo4047a(String str, String str2) {
            }

            public void mo4050b(String str, String str2) {
                try {
                    new File(str).delete();
                    ag.m15457b(file);
                    this.f11766c.setCompleteCode(100);
                    this.f11766c.f11785i.mo4011i();
                } catch (Exception e) {
                    this.f11766c.f11785i.mo4010g();
                }
            }

            public void mo4049a(String str, String str2, int i) {
                this.f11766c.f11785i.mo4010g();
            }
        });
    }

    public boolean m16143u() {
        return ((double) ag.m15449a()) < (((double) getSize()) * 2.5d) - ((double) (((long) getcompleteCode()) * getSize())) ? false : false;
    }

    public C3337r m16144v() {
        setState(this.f11785i.m15488b());
        C3337r c3337r = new C3337r((OfflineMapCity) this, this.f11786j);
        c3337r.m16252f(m16116a());
        return c3337r;
    }

    public void m16122a(C3337r c3337r) {
        m16117a(c3337r.f11829a);
        setCity(c3337r.m16244c());
        setSize(c3337r.m16255h());
        setVersion(c3337r.m16247d());
        setCompleteCode(c3337r.m16264o());
        setAdcode(c3337r.m16251f());
        setUrl(c3337r.m16253g());
    }
}
