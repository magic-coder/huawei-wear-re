package com.amap.api.services.district;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3410e;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import java.util.HashMap;

public class DistrictSearch {
    private static HashMap<Integer, DistrictResult> f12539f;
    private Context f12540a;
    private DistrictSearchQuery f12541b;
    private OnDistrictSearchListener f12542c;
    private DistrictSearchQuery f12543d;
    private int f12544e;
    private Handler f12545g = C3428p.m16969a();

    class C34391 extends Thread {
        final /* synthetic */ DistrictSearch f12538a;

        C34391(DistrictSearch districtSearch) {
            this.f12538a = districtSearch;
        }

        public void run() {
            Bundle bundle;
            Message obtainMessage = C3428p.m16969a().obtainMessage();
            Parcelable districtResult = new DistrictResult();
            districtResult.setQuery(this.f12538a.f12541b);
            try {
                districtResult = this.f12538a.m17036b();
                if (districtResult != null) {
                    districtResult.setAMapException(new AMapException());
                }
                obtainMessage.arg1 = 4;
                obtainMessage.obj = this.f12538a.f12542c;
                bundle = new Bundle();
                bundle.putParcelable("result", districtResult);
                obtainMessage.setData(bundle);
                if (this.f12538a.f12545g != null) {
                    this.f12538a.f12545g.sendMessage(obtainMessage);
                }
            } catch (Throwable e) {
                C3409d.m16881a(e, "DistrictSearch", "searchDistrictAnsy");
                districtResult.setAMapException(e);
                obtainMessage.arg1 = 4;
                obtainMessage.obj = this.f12538a.f12542c;
                bundle = new Bundle();
                bundle.putParcelable("result", districtResult);
                obtainMessage.setData(bundle);
                if (this.f12538a.f12545g != null) {
                    this.f12538a.f12545g.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                obtainMessage.arg1 = 4;
                obtainMessage.obj = this.f12538a.f12542c;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("result", districtResult);
                obtainMessage.setData(bundle2);
                if (this.f12538a.f12545g != null) {
                    this.f12538a.f12545g.sendMessage(obtainMessage);
                }
            }
        }
    }

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        this.f12540a = context.getApplicationContext();
    }

    private void m17033a(DistrictResult districtResult) {
        f12539f = new HashMap();
        if (this.f12541b != null && districtResult != null && this.f12544e > 0 && this.f12544e > this.f12541b.getPageNum()) {
            f12539f.put(Integer.valueOf(this.f12541b.getPageNum()), districtResult);
        }
    }

    public DistrictSearchQuery getQuery() {
        return this.f12541b;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f12541b = districtSearchQuery;
    }

    private boolean m17034a() {
        if (this.f12541b == null) {
            return false;
        }
        return true;
    }

    protected DistrictResult getPageLocal(int i) throws AMapException {
        if (m17035a(i)) {
            return (DistrictResult) f12539f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private boolean m17035a(int i) {
        return i < this.f12544e && i >= 0;
    }

    private DistrictResult m17036b() throws AMapException {
        DistrictResult districtResult = new DistrictResult();
        C3418l.m16960a(this.f12540a);
        if (!m17034a()) {
            this.f12541b = new DistrictSearchQuery();
        }
        districtResult.setQuery(this.f12541b.clone());
        if (!this.f12541b.weakEquals(this.f12543d)) {
            this.f12544e = 0;
            this.f12543d = this.f12541b.clone();
            if (f12539f != null) {
                f12539f.clear();
            }
        }
        if (this.f12544e == 0) {
            districtResult = (DistrictResult) new C3410e(this.f12540a, this.f12541b.clone()).m16577g();
            if (districtResult != null) {
                this.f12544e = districtResult.getPageCount();
                m17033a(districtResult);
            }
        } else {
            districtResult = getPageLocal(this.f12541b.getPageNum());
            if (districtResult == null) {
                districtResult = (DistrictResult) new C3410e(this.f12540a, this.f12541b.clone()).m16577g();
                if (this.f12541b != null && districtResult != null && this.f12544e > 0 && this.f12544e > this.f12541b.getPageNum()) {
                    f12539f.put(Integer.valueOf(this.f12541b.getPageNum()), districtResult);
                }
            }
        }
        return districtResult;
    }

    public void searchDistrictAnsy() {
        new C34391(this).start();
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        this.f12542c = onDistrictSearchListener;
    }
}
