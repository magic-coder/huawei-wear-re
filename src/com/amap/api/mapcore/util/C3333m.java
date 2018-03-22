package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.mapcore.util.ad.C3271a;
import com.amap.api.mapcore.util.ah.C3277a;
import com.amap.api.maps.AMap;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.IOException;

/* compiled from: OfflineMapDownloadTask */
public class C3333m extends dv implements C3271a {
    private ad f11816a;
    private af f11817b;
    private C3323g f11818c;
    private Context f11819e;
    private Bundle f11820f;
    private AMap f11821g;
    private boolean f11822h;

    public C3333m(C3322p c3322p, Context context) {
        this.f11820f = new Bundle();
        this.f11822h = false;
        this.f11818c = (C3323g) c3322p;
        this.f11819e = context;
    }

    public C3333m(C3322p c3322p, Context context, AMap aMap) {
        this(c3322p, context);
        this.f11821g = aMap;
    }

    public void mo4042a() {
        if (this.f11818c.m16143u()) {
            this.f11818c.mo4055a(C3277a.file_io_exception);
            return;
        }
        try {
            m16212g();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void m16214b() {
        this.f11822h = true;
        if (this.f11816a != null) {
            this.f11816a.m15422c();
        } else {
            m16078e();
            ag.m15456b("DownloadTask stopTask filefetch is null !!  Maybe cancal a wating task");
        }
        if (this.f11817b != null) {
            this.f11817b.m15447a();
        }
    }

    private String m16211f() {
        return bk.m15673b(this.f11819e);
    }

    private void m16212g() throws IOException {
        String adcode = this.f11818c.getAdcode();
        this.f11816a = new ad(new ae(this.f11818c.getUrl(), m16211f(), (adcode + LightCloudConstants.ZIP_POSTFIX) + ".tmp", 1, adcode), this.f11818c.getUrl(), this.f11819e, this.f11818c);
        this.f11816a.m15418a((C3271a) this);
        this.f11817b = new af(this.f11818c.m16141s(), this.f11818c.m16142t(), this.f11818c);
        if (!this.f11822h) {
            this.f11816a.m15417a();
        }
    }

    public void m16215c() {
        this.f11821g = null;
        if (this.f11820f != null) {
            this.f11820f.clear();
            this.f11820f = null;
        }
    }

    public void mo4065d() {
        ag.m15456b("onNetfileFetchFinish");
        if (this.f11817b != null) {
            this.f11817b.m15448b();
        } else {
            ag.m15456b("OfflineMapDownloadTask UnZipFile is null!!");
        }
    }
}
