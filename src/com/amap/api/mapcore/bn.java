package com.amap.api.mapcore;

import android.content.Context;
import android.view.View;
import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.UrlTileProvider;
import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: TileOverlayView */
public class bn extends View {
    CopyOnWriteArrayList<ao> f11176a = new CopyOnWriteArrayList();
    C3242a f11177b = new C3242a();
    CopyOnWriteArrayList<Integer> f11178c = new CopyOnWriteArrayList();
    bm f11179d = null;
    private aa f11180e;

    /* compiled from: TileOverlayView */
    class C3242a implements Serializable, Comparator<Object> {
        C3242a() {
        }

        public int compare(Object obj, Object obj2) {
            ao aoVar = (ao) obj;
            ao aoVar2 = (ao) obj2;
            if (!(aoVar == null || aoVar2 == null)) {
                try {
                    if (aoVar.mo3947d() > aoVar2.mo3947d()) {
                        return 1;
                    }
                    if (aoVar.mo3947d() < aoVar2.mo3947d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "TileOverlayView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public bn(Context context) {
        super(context);
    }

    public bn(Context context, aa aaVar) {
        super(context);
        this.f11180e = aaVar;
        this.f11179d = new bm(new TileOverlayOptions().tileProvider(new UrlTileProvider(this, 256, 256) {
            final /* synthetic */ bn f11175a;

            public URL getTileUrl(int i, int i2, int i3) {
                try {
                    return new URL(String.format("http://grid.amap.com/grid/%d/%d/%d?dpiType=webrd&lang=zh_cn&pack=%s&version=3.2.0.1", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), C3264r.f11367c}));
                } catch (Throwable th) {
                    return null;
                }
            }
        }), this, true);
    }

    aa m15214a() {
        return this.f11180e;
    }

    public void m15216a(GL10 gl10) {
        try {
            Iterator it = this.f11178c.iterator();
            while (it.hasNext()) {
                bk.m15664a(gl10, ((Integer) it.next()).intValue());
            }
            this.f11178c.clear();
            this.f11179d.mo3940a(gl10);
            it = this.f11176a.iterator();
            while (it.hasNext()) {
                ao aoVar = (ao) it.next();
                if (aoVar.mo3948e()) {
                    aoVar.mo3940a(gl10);
                }
            }
        } catch (Throwable th) {
            bf.m15627a(bf.f11497a, hashCode() + " TileOverLayView draw exception :" + th.getMessage(), 115);
        }
    }

    public void m15218b() {
        Iterator it = this.f11176a.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            if (aoVar != null) {
                aoVar.mo3938a();
            }
        }
        this.f11176a.clear();
    }

    void m15221c() {
        Object[] toArray = this.f11176a.toArray();
        Arrays.sort(toArray, this.f11177b);
        this.f11176a.clear();
        for (Object obj : toArray) {
            this.f11176a.add((ao) obj);
        }
    }

    public void m15215a(ao aoVar) {
        m15220b(aoVar);
        this.f11176a.add(aoVar);
        m15221c();
    }

    public boolean m15220b(ao aoVar) {
        return this.f11176a.remove(aoVar);
    }

    public void m15217a(boolean z) {
        this.f11179d.mo3944b(z);
        Iterator it = this.f11176a.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            if (aoVar != null && aoVar.mo3948e()) {
                aoVar.mo3944b(z);
            }
        }
    }

    public void m15222d() {
        this.f11179d.mo3950g();
        Iterator it = this.f11176a.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            if (aoVar != null) {
                aoVar.mo3950g();
            }
        }
    }

    public void m15223e() {
        this.f11179d.mo3951h();
        Iterator it = this.f11176a.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            if (aoVar != null) {
                aoVar.mo3951h();
            }
        }
    }

    public void m15219b(boolean z) {
        this.f11179d.mo3946c(z);
        Iterator it = this.f11176a.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            if (aoVar != null) {
                aoVar.mo3946c(z);
            }
        }
    }

    public void m15224f() {
        this.f11179d.mo3938a();
        this.f11179d = null;
    }
}
