package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDownloadList */
public class C3332l {
    public ArrayList<OfflineMapProvince> f11812a = new ArrayList();
    private C3345z f11813b;
    private Context f11814c;
    private Handler f11815d;

    public C3332l(Context context, Handler handler) {
        this.f11814c = context;
        this.f11815d = handler;
        this.f11813b = C3345z.m16317a(context);
    }

    private void m16190a(C3337r c3337r) {
        if (this.f11813b != null && c3337r != null) {
            this.f11813b.m16324a(c3337r);
        }
    }

    private void m16196d(String str) {
        if (this.f11813b != null) {
            this.f11813b.m16329c(str);
        }
    }

    private boolean m16193a(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    private boolean m16195b(int i) {
        if (i == 4) {
            return true;
        }
        return false;
    }

    private boolean m16194a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (((OfflineMapCity) it.next()).getState() != 4) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<OfflineMapProvince> m16198a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.f11812a.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapProvince) it.next());
        }
        return arrayList;
    }

    public OfflineMapCity m16197a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator it = this.f11812a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCode().equals(str)) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapCity m16202b(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator it = this.f11812a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapProvince m16204c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator it = this.f11812a.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        return null;
    }

    public ArrayList<OfflineMapCity> m16203b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.f11812a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                arrayList.add((OfflineMapCity) it2.next());
            }
        }
        return arrayList;
    }

    public void m16200a(List<OfflineMapProvince> list) {
        if (this.f11812a.size() > 0) {
            for (int i = 0; i < this.f11812a.size(); i++) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) this.f11812a.get(i);
                OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) list.get(i);
                m16192a(offlineMapProvince, offlineMapProvince2);
                ArrayList cityList = offlineMapProvince.getCityList();
                ArrayList cityList2 = offlineMapProvince2.getCityList();
                for (int i2 = 0; i2 < cityList.size(); i2++) {
                    m16191a((OfflineMapCity) cityList.get(i2), (OfflineMapCity) cityList2.get(i2));
                }
            }
            return;
        }
        for (OfflineMapProvince offlineMapProvince3 : list) {
            this.f11812a.add(offlineMapProvince3);
        }
    }

    private void m16191a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
    }

    private void m16192a(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
    }

    public ArrayList<OfflineMapCity> m16205c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f11812a) {
            arrayList = new ArrayList();
            Iterator it = this.f11812a.iterator();
            while (it.hasNext()) {
                for (OfflineMapCity offlineMapCity : ((OfflineMapProvince) it.next()).getCityList()) {
                    if (offlineMapCity.getState() == 4) {
                        arrayList.add(offlineMapCity);
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> m16206d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f11812a) {
            arrayList = new ArrayList();
            Iterator it = this.f11812a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince.getState() == 4) {
                    arrayList.add(offlineMapProvince);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> m16207e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f11812a) {
            arrayList = new ArrayList();
            Iterator it = this.f11812a.iterator();
            while (it.hasNext()) {
                for (OfflineMapCity offlineMapCity : ((OfflineMapProvince) it.next()).getCityList()) {
                    if (m16201a(offlineMapCity.getState())) {
                        arrayList.add(offlineMapCity);
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> m16208f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f11812a) {
            arrayList = new ArrayList();
            Iterator it = this.f11812a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (m16201a(offlineMapProvince.getState())) {
                    arrayList.add(offlineMapProvince);
                }
            }
        }
        return arrayList;
    }

    public boolean m16201a(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1;
    }

    public void m16199a(C3323g c3323g) {
        String adcode = c3323g.getAdcode();
        synchronized (this.f11812a) {
            Iterator it = this.f11812a.iterator();
            loop0:
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                    if (offlineMapCity.getAdcode().trim().equals(adcode.trim())) {
                        m16188a(c3323g, offlineMapCity);
                        m16189a(c3323g, offlineMapProvince);
                        break loop0;
                    }
                }
            }
        }
    }

    private void m16188a(C3323g c3323g, OfflineMapCity offlineMapCity) {
        int b = c3323g.m16125c().m15488b();
        if (c3323g.m16125c().equals(c3323g.f11777a)) {
            m16196d(c3323g.getAdcode());
        } else {
            if (c3323g.m16125c().equals(c3323g.f11782f)) {
            }
            if (m16193a(c3323g.getcompleteCode(), c3323g.m16125c().m15488b())) {
                m16190a(c3323g.m16144v());
            }
        }
        offlineMapCity.setState(b);
        offlineMapCity.setCompleteCode(c3323g.getcompleteCode());
    }

    private void m16189a(C3323g c3323g, OfflineMapProvince offlineMapProvince) {
        int b = c3323g.m16125c().m15488b();
        if (b == 6) {
            offlineMapProvince.setState(b);
            m16196d(offlineMapProvince.getProvinceCode());
            try {
                ag.m15454a(offlineMapProvince.getProvinceCode(), this.f11814c);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (m16195b(b) && m16194a(offlineMapProvince)) {
            offlineMapProvince.setState(b);
            C3337r c3337r = new C3337r(offlineMapProvince, this.f11814c);
            c3337r.m16266q();
            m16190a(c3337r);
        }
    }

    public void m16209g() {
        m16210h();
        this.f11815d = null;
        this.f11813b = null;
        this.f11814c = null;
    }

    public void m16210h() {
        this.f11812a.clear();
    }
}
