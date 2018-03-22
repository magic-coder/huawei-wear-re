package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3394b;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import com.amap.api.services.core.C3428p.C3422a;
import java.util.ArrayList;

public class BusLineSearch {
    private Context f12236a;
    private OnBusLineSearchListener f12237b;
    private BusLineQuery f12238c;
    private BusLineQuery f12239d;
    private int f12240e;
    private ArrayList<BusLineResult> f12241f = new ArrayList();
    private Handler f12242g = null;

    class C33831 implements Runnable {
        final /* synthetic */ BusLineSearch f12235a;

        C33831(BusLineSearch busLineSearch) {
            this.f12235a = busLineSearch;
        }

        public void run() {
            Message obtainMessage = C3428p.m16969a().obtainMessage();
            try {
                BusLineResult searchBusLine = this.f12235a.searchBusLine();
                obtainMessage.arg1 = 3;
                obtainMessage.what = 0;
                C3422a c3422a = new C3422a();
                c3422a.f12495a = searchBusLine;
                c3422a.f12496b = this.f12235a.f12237b;
                obtainMessage.obj = c3422a;
            } catch (Throwable e) {
                C3409d.m16881a(e, "BusLineSearch", "searchBusLineAsyn");
                obtainMessage.what = e.getErrorCode();
            } finally {
                this.f12235a.f12242g.sendMessage(obtainMessage);
            }
        }
    }

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        this.f12236a = context.getApplicationContext();
        this.f12238c = busLineQuery;
        this.f12239d = busLineQuery.clone();
        this.f12242g = C3428p.m16969a();
    }

    public BusLineResult searchBusLine() throws AMapException {
        C3418l.m16960a(this.f12236a);
        if (!this.f12238c.weakEquals(this.f12239d)) {
            this.f12239d = this.f12238c.clone();
            this.f12240e = 0;
            if (this.f12241f != null) {
                this.f12241f.clear();
            }
        }
        if (this.f12240e == 0) {
            C3394b c3394b = new C3394b(this.f12236a, this.f12238c.clone());
            BusLineResult a = BusLineResult.m16543a(c3394b, (ArrayList) c3394b.m16577g());
            this.f12240e = a.getPageCount();
            m16545a(a);
            return a;
        }
        a = m16548b(this.f12238c.getPageNumber());
        if (a != null) {
            return a;
        }
        c3394b = new C3394b(this.f12236a, this.f12238c);
        a = BusLineResult.m16543a(c3394b, (ArrayList) c3394b.m16577g());
        this.f12241f.set(this.f12238c.getPageNumber(), a);
        return a;
    }

    private void m16545a(BusLineResult busLineResult) {
        this.f12241f = new ArrayList();
        for (int i = 0; i < this.f12240e; i++) {
            this.f12241f.add(null);
        }
        if (this.f12240e >= 0 && m16546a(this.f12238c.getPageNumber())) {
            this.f12241f.set(this.f12238c.getPageNumber(), busLineResult);
        }
    }

    private boolean m16546a(int i) {
        return i < this.f12240e && i >= 0;
    }

    private BusLineResult m16548b(int i) {
        if (m16546a(i)) {
            return (BusLineResult) this.f12241f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        this.f12237b = onBusLineSearchListener;
    }

    public void searchBusLineAsyn() {
        new Thread(new C33831(this)).start();
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.f12238c.weakEquals(busLineQuery)) {
            this.f12238c = busLineQuery;
            this.f12239d = busLineQuery.clone();
        }
    }

    public BusLineQuery getQuery() {
        return this.f12238c;
    }
}
