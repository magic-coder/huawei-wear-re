package com.amap.api.services.geocoder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3412g;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import com.amap.api.services.core.C3428p.C3424c;
import com.amap.api.services.core.C3428p.C3427f;
import com.amap.api.services.core.C3431t;
import java.util.List;

public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String GPS = "gps";
    private Context f12573a;
    private OnGeocodeSearchListener f12574b;
    private Handler f12575c = C3428p.m16969a();

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        this.f12573a = context.getApplicationContext();
    }

    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        C3418l.m16960a(this.f12573a);
        return (RegeocodeAddress) new C3431t(this.f12573a, regeocodeQuery).m16577g();
    }

    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        C3418l.m16960a(this.f12573a);
        return (List) new C3412g(this.f12573a, geocodeQuery).m16577g();
    }

    public void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f12574b = onGeocodeSearchListener;
    }

    public void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        new Thread(new Runnable(this) {
            final /* synthetic */ GeocodeSearch f12570b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = 21;
                    RegeocodeAddress fromLocation = this.f12570b.getFromLocation(regeocodeQuery);
                    obtainMessage.arg2 = 0;
                    C3427f c3427f = new C3427f();
                    c3427f.f12506b = this.f12570b.f12574b;
                    c3427f.f12505a = new RegeocodeResult(regeocodeQuery, fromLocation);
                    obtainMessage.obj = c3427f;
                } catch (Throwable e) {
                    C3409d.m16881a(e, "GeocodeSearch", "getFromLocationAsyn");
                    obtainMessage.arg2 = e.getErrorCode();
                } finally {
                    this.f12570b.f12575c.sendMessage(obtainMessage);
                }
            }
        }).start();
    }

    public void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        new Thread(new Runnable(this) {
            final /* synthetic */ GeocodeSearch f12572b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                try {
                    obtainMessage.what = 20;
                    obtainMessage.arg1 = 2;
                    List fromLocationName = this.f12572b.getFromLocationName(geocodeQuery);
                    obtainMessage.arg2 = 0;
                    C3424c c3424c = new C3424c();
                    c3424c.f12500b = this.f12572b.f12574b;
                    c3424c.f12499a = new GeocodeResult(geocodeQuery, fromLocationName);
                    obtainMessage.obj = c3424c;
                } catch (Throwable e) {
                    C3409d.m16881a(e, "GeocodeSearch", "getFromLocationNameAsyn");
                    obtainMessage.arg2 = e.getErrorCode();
                } finally {
                    this.f12572b.f12575c.sendMessage(obtainMessage);
                }
            }
        }).start();
    }
}
