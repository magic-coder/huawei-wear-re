package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.C3323g;
import com.amap.api.mapcore.util.C3328h;
import com.amap.api.mapcore.util.C3328h.C3326a;
import com.amap.api.mapcore.util.C3332l;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager {
    C3332l f12164a;
    C3328h f12165b;
    private Context f12166c;
    private AMap f12167d;
    private OfflineMapDownloadListener f12168e;
    private Handler f12169f = new Handler();
    private Handler f12170g = new Handler();

    class C33741 implements C3326a {
        final /* synthetic */ OfflineMapManager f12159a;

        C33741(OfflineMapManager offlineMapManager) {
            this.f12159a = offlineMapManager;
        }

        public void mo4088a(final C3323g c3323g) {
            if (!(this.f12159a.f12168e == null || c3323g == null)) {
                this.f12159a.f12169f.post(new Runnable(this) {
                    final /* synthetic */ C33741 f12154b;

                    public void run() {
                        this.f12154b.f12159a.f12168e.onDownload(c3323g.m16125c().m15488b(), c3323g.getcompleteCode(), c3323g.getCity());
                    }
                });
            }
            if (this.f12159a.f12167d != null && c3323g.m16125c().m15487a(c3323g.f11782f)) {
                this.f12159a.f12167d.setLoadOfflineData(false);
                this.f12159a.f12167d.setLoadOfflineData(true);
            }
        }

        public void mo4089b(final C3323g c3323g) {
            if (this.f12159a.f12168e != null && c3323g != null) {
                this.f12159a.f12169f.post(new Runnable(this) {
                    final /* synthetic */ C33741 f12156b;

                    public void run() {
                        if (c3323g.m16125c().equals(c3323g.f11783g)) {
                            this.f12156b.f12159a.f12168e.onCheckUpdate(true, c3323g.getCity());
                        } else {
                            this.f12156b.f12159a.f12168e.onCheckUpdate(false, c3323g.getCity());
                        }
                    }
                });
            }
        }

        public void mo4090c(final C3323g c3323g) {
            if (this.f12159a.f12168e != null && c3323g != null) {
                this.f12159a.f12169f.post(new Runnable(this) {
                    final /* synthetic */ C33741 f12158b;

                    public void run() {
                        if (c3323g.m16125c().equals(c3323g.f11777a)) {
                            this.f12158b.f12159a.f12168e.onRemove(true, c3323g.getCity(), "");
                        } else {
                            this.f12158b.f12159a.f12168e.onRemove(false, c3323g.getCity(), "");
                        }
                    }
                });
            }
        }
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.f12168e = offlineMapDownloadListener;
        m16484a(context);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f12168e = offlineMapDownloadListener;
        this.f12167d = aMap;
        m16484a(context);
    }

    private void m16484a(Context context) {
        this.f12166c = context.getApplicationContext();
        this.f12165b = C3328h.m16149a(context);
        this.f12164a = this.f12165b.f11799d;
        this.f12165b.m16163a(new C33741(this));
    }

    public void downloadByCityCode(String str) throws AMapException {
        this.f12165b.m16176e(str);
    }

    public void downloadByCityName(String str) throws AMapException {
        this.f12165b.m16174d(str);
    }

    public void downloadByProvinceName(String str) throws AMapException {
        try {
            m16483a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            Iterator it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                final String city = ((OfflineMapCity) it.next()).getCity();
                this.f12170g.post(new Runnable(this) {
                    final /* synthetic */ OfflineMapManager f12161b;

                    public void run() {
                        this.f12161b.f12165b.m16174d(city);
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            } else {
                ca.m15831a(th, "OfflineMapManager", "downloadByProvinceName");
            }
        }
    }

    public void remove(String str) {
        if (this.f12165b.m16168b(str)) {
            this.f12165b.m16171c(str);
            return;
        }
        OfflineMapProvince c = this.f12164a.m16204c(str);
        if (c != null && c.getCityList() != null) {
            Iterator it = c.getCityList().iterator();
            while (it.hasNext()) {
                final String city = ((OfflineMapCity) it.next()).getCity();
                this.f12170g.post(new Runnable(this) {
                    final /* synthetic */ OfflineMapManager f12163b;

                    public void run() {
                        this.f12163b.f12165b.m16171c(city);
                    }
                });
            }
        } else if (this.f12168e != null) {
            this.f12168e.onRemove(false, str, "没有该城市");
        }
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f12164a.m16198a();
    }

    public OfflineMapCity getItemByCityCode(String str) {
        return this.f12164a.m16197a(str);
    }

    public OfflineMapCity getItemByCityName(String str) {
        return this.f12164a.m16202b(str);
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        return this.f12164a.m16204c(str);
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f12164a.m16203b();
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f12164a.m16207e();
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f12164a.m16208f();
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f12164a.m16205c();
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f12164a.m16206d();
    }

    private void m16485a(String str, String str2) throws AMapException {
        this.f12165b.m16164a(str);
    }

    public void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        m16485a(itemByCityCode.getCity(), "cityname");
    }

    public void updateOfflineCityByName(String str) throws AMapException {
        m16485a(str, "cityname");
    }

    public void updateOfflineMapProvinceByName(String str) throws AMapException {
        m16485a(str, "cityname");
    }

    private void m16483a() throws AMapException {
        if (!bk.m15679c(this.f12166c)) {
            throw new AMapException("http连接失败 - ConnectionException");
        }
    }

    public void restart() {
    }

    public void stop() {
        this.f12165b.m16166b();
    }

    public void pause() {
        this.f12165b.m16169c();
    }

    public void destroy() {
        this.f12165b.m16172d();
        m16487b();
        this.f12167d = null;
        this.f12169f.removeCallbacksAndMessages(null);
        this.f12169f = null;
        this.f12170g.removeCallbacksAndMessages(null);
        this.f12170g = null;
    }

    private void m16487b() {
        this.f12168e = null;
    }
}
