package com.huawei.openalliance.ad.p112a.p113a;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1218d;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1219e;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1222h;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1228n;
import java.util.List;

public class C1214a extends C1212b {
    private C1219e app__;
    private List<String> cacheSloganId__;
    private List<String> cachecontentid__;
    private C1222h device__;
    private List<C1218d> multislot__;
    private C1228n network__;
    private List<String> removedContentId__;
    private String sdkversion__ = "3.4.10.301";
    private String version__ = "3.2";

    public C1214a(Context context, List<C1218d> list, List<String> list2, List<String> list3, int i, int i2, int i3) {
        this.multislot__ = list;
        this.app__ = new C1219e(context);
        this.device__ = new C1222h(context, i, i2, i3);
        this.network__ = new C1228n(context);
        this.rspClass = C1235b.class;
        this.cachecontentid__ = list2;
        this.cacheSloganId__ = list3;
    }

    public C1219e getApp__() {
        return this.app__;
    }

    public List<String> getCacheSloganId__() {
        return this.cacheSloganId__;
    }

    public List<String> getCachecontentid__() {
        return this.cachecontentid__;
    }

    public C1222h getDevice__() {
        return this.device__;
    }

    public List<C1218d> getMultislot__() {
        return this.multislot__;
    }

    public C1228n getNetwork__() {
        return this.network__;
    }

    public List<String> getRemovedContentId__() {
        return this.removedContentId__;
    }

    public String getSdkversion__() {
        return this.sdkversion__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public void setApp__(C1219e c1219e) {
        this.app__ = c1219e;
    }

    public void setCacheSloganId__(List<String> list) {
        this.cacheSloganId__ = list;
    }

    public void setCachecontentid__(List<String> list) {
        this.cachecontentid__ = list;
    }

    public void setDevice__(C1222h c1222h) {
        this.device__ = c1222h;
    }

    public void setMultislot__(List<C1218d> list) {
        this.multislot__ = list;
    }

    public void setNetwork__(C1228n c1228n) {
        this.network__ = c1228n;
    }

    public void setRemovedContentId__(List<String> list) {
        this.removedContentId__ = list;
    }

    public void setSdkversion__(String str) {
        this.sdkversion__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }
}
