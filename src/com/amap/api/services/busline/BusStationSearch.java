package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3394b;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import com.amap.api.services.core.C3428p.C3423b;
import java.util.ArrayList;

public class BusStationSearch {
    private Context f12259a;
    private OnBusStationSearchListener f12260b;
    private BusStationQuery f12261c;
    private BusStationQuery f12262d;
    private ArrayList<BusStationResult> f12263e = new ArrayList();
    private int f12264f;
    private Handler f12265g;

    class C33841 implements Runnable {
        final /* synthetic */ BusStationSearch f12258a;

        C33841(BusStationSearch busStationSearch) {
            this.f12258a = busStationSearch;
        }

        public void run() {
            Message obtainMessage = C3428p.m16969a().obtainMessage();
            try {
                BusStationResult searchBusStation = this.f12258a.searchBusStation();
                obtainMessage.arg1 = 7;
                obtainMessage.what = 0;
                C3423b c3423b = new C3423b();
                c3423b.f12497a = searchBusStation;
                c3423b.f12498b = this.f12258a.f12260b;
                obtainMessage.obj = c3423b;
            } catch (Throwable e) {
                C3409d.m16881a(e, "BusStationSearch", "searchBusStationAsyn");
                obtainMessage.what = e.getErrorCode();
            } finally {
                this.f12258a.f12265g.sendMessage(obtainMessage);
            }
        }
    }

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        this.f12259a = context.getApplicationContext();
        this.f12261c = busStationQuery;
        this.f12265g = C3428p.m16969a();
    }

    public BusStationResult searchBusStation() throws AMapException {
        C3418l.m16960a(this.f12259a);
        if (!this.f12261c.weakEquals(this.f12262d)) {
            this.f12262d = this.f12261c.clone();
            this.f12264f = 0;
            if (this.f12263e != null) {
                this.f12263e.clear();
            }
        }
        if (this.f12264f == 0) {
            C3394b c3394b = new C3394b(this.f12259a, this.f12261c);
            BusStationResult a = BusStationResult.m16552a(c3394b, (ArrayList) c3394b.m16577g());
            this.f12264f = a.getPageCount();
            m16554a(a);
            return a;
        }
        a = m16557b(this.f12261c.getPageNumber());
        if (a != null) {
            return a;
        }
        c3394b = new C3394b(this.f12259a, this.f12261c);
        a = BusStationResult.m16552a(c3394b, (ArrayList) c3394b.m16577g());
        this.f12263e.set(this.f12261c.getPageNumber(), a);
        return a;
    }

    private void m16554a(BusStationResult busStationResult) {
        this.f12263e = new ArrayList();
        for (int i = 0; i <= this.f12264f; i++) {
            this.f12263e.add(null);
        }
        if (this.f12264f > 0) {
            this.f12263e.set(this.f12261c.getPageNumber(), busStationResult);
        }
    }

    private boolean m16555a(int i) {
        return i <= this.f12264f && i >= 0;
    }

    private BusStationResult m16557b(int i) {
        if (m16555a(i)) {
            return (BusStationResult) this.f12263e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        this.f12260b = onBusStationSearchListener;
    }

    public void searchBusStationAsyn() {
        new Thread(new C33841(this)).start();
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.f12261c)) {
            this.f12261c = busStationQuery;
        }
    }

    public BusStationQuery getQuery() {
        return this.f12261c;
    }
}
