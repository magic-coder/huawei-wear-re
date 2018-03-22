package com.amap.api.services.poisearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import com.amap.api.services.core.C3428p.C3425d;
import com.amap.api.services.core.C3428p.C3426e;
import com.amap.api.services.core.C3430s;
import com.amap.api.services.core.LatLonPoint;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    private static HashMap<Integer, PoiResult> f12708i;
    private SearchBound f12709a;
    private Query f12710b;
    private Context f12711c;
    private OnPoiSearchListener f12712d;
    private String f12713e = "zh-CN";
    private Query f12714f;
    private SearchBound f12715g;
    private int f12716h;
    private Handler f12717j = null;

    class C34521 extends Thread {
        final /* synthetic */ PoiSearch f12690a;

        C34521(PoiSearch poiSearch) {
            this.f12690a = poiSearch;
        }

        public void run() {
            Message obtainMessage = this.f12690a.f12717j.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 60;
            Bundle bundle = new Bundle();
            PoiResult poiResult = null;
            try {
                poiResult = this.f12690a.searchPOI();
                bundle.putInt(Constant.KEY_ERROR_CODE, 0);
            } catch (Throwable e) {
                C3409d.m16881a(e, "PoiSearch", "searchPOIAsyn");
                bundle.putInt(Constant.KEY_ERROR_CODE, e.getErrorCode());
            } finally {
                C3426e c3426e = new C3426e();
                c3426e.f12504b = this.f12690a.f12712d;
                c3426e.f12503a = poiResult;
                obtainMessage.obj = c3426e;
                obtainMessage.setData(bundle);
                this.f12690a.f12717j.sendMessage(obtainMessage);
            }
        }
    }

    public interface OnPoiSearchListener {
        void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    public class Query implements Cloneable {
        private String f12693a;
        private String f12694b;
        private String f12695c;
        private int f12696d;
        private int f12697e;
        private boolean f12698f;
        private boolean f12699g;
        private String f12700h;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.f12696d = 0;
            this.f12697e = 20;
            this.f12700h = "zh-CN";
            this.f12693a = str;
            this.f12694b = str2;
            this.f12695c = str3;
        }

        public String getQueryString() {
            return this.f12693a;
        }

        protected void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f12700h = "en";
            } else {
                this.f12700h = "zh-CN";
            }
        }

        protected String getQueryLanguage() {
            return this.f12700h;
        }

        public void setLimitGroupbuy(boolean z) {
            this.f12698f = z;
        }

        public boolean hasGroupBuyLimit() {
            return this.f12698f;
        }

        public void setLimitDiscount(boolean z) {
            this.f12699g = z;
        }

        public boolean hasDiscountLimit() {
            return this.f12699g;
        }

        public String getCategory() {
            if (this.f12694b == null || this.f12694b.equals("00") || this.f12694b.equals("00|")) {
                return m17065a();
            }
            return this.f12694b;
        }

        private String m17065a() {
            return "";
        }

        public String getCity() {
            return this.f12695c;
        }

        public int getPageNum() {
            return this.f12696d;
        }

        public void setPageNum(int i) {
            this.f12696d = i;
        }

        public void setPageSize(int i) {
            this.f12697e = i;
        }

        public int getPageSize() {
            return this.f12697e;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            if (PoiSearch.m17079b(query.f12693a, this.f12693a) && PoiSearch.m17079b(query.f12694b, this.f12694b) && PoiSearch.m17079b(query.f12700h, this.f12700h) && PoiSearch.m17079b(query.f12695c, this.f12695c) && query.f12697e == this.f12697e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int i3 = 0;
            int hashCode = ((this.f12695c == null ? 0 : this.f12695c.hashCode()) + (((this.f12694b == null ? 0 : this.f12694b.hashCode()) + 31) * 31)) * 31;
            if (this.f12699g) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (i + hashCode) * 31;
            if (!this.f12698f) {
                i2 = 1237;
            }
            i = ((((((this.f12700h == null ? 0 : this.f12700h.hashCode()) + ((i + i2) * 31)) * 31) + this.f12696d) * 31) + this.f12697e) * 31;
            if (this.f12693a != null) {
                i3 = this.f12693a.hashCode();
            }
            return i + i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            if (this.f12694b == null) {
                if (query.f12694b != null) {
                    return false;
                }
            } else if (!this.f12694b.equals(query.f12694b)) {
                return false;
            }
            if (this.f12695c == null) {
                if (query.f12695c != null) {
                    return false;
                }
            } else if (!this.f12695c.equals(query.f12695c)) {
                return false;
            }
            if (this.f12699g != query.f12699g) {
                return false;
            }
            if (this.f12698f != query.f12698f) {
                return false;
            }
            if (this.f12700h == null) {
                if (query.f12700h != null) {
                    return false;
                }
            } else if (!this.f12700h.equals(query.f12700h)) {
                return false;
            }
            if (this.f12696d != query.f12696d) {
                return false;
            }
            if (this.f12697e != query.f12697e) {
                return false;
            }
            if (this.f12693a == null) {
                if (query.f12693a != null) {
                    return false;
                }
                return true;
            } else if (this.f12693a.equals(query.f12693a)) {
                return true;
            } else {
                return false;
            }
        }

        public Query clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f12693a, this.f12694b, this.f12695c);
            query.setPageNum(this.f12696d);
            query.setPageSize(this.f12697e);
            query.setLimitDiscount(this.f12699g);
            query.setLimitGroupbuy(this.f12698f);
            query.setQueryLanguage(this.f12700h);
            return query;
        }
    }

    public class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint f12701a;
        private LatLonPoint f12702b;
        private int f12703c;
        private LatLonPoint f12704d;
        private String f12705e;
        private boolean f12706f;
        private List<LatLonPoint> f12707g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f12706f = true;
            this.f12705e = BOUND_SHAPE;
            this.f12703c = i;
            this.f12704d = latLonPoint;
            m17070a(latLonPoint, C3409d.m16877a(i), C3409d.m16877a(i));
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f12706f = true;
            this.f12705e = BOUND_SHAPE;
            this.f12703c = i;
            this.f12704d = latLonPoint;
            m17070a(latLonPoint, C3409d.m16877a(i), C3409d.m16877a(i));
            this.f12706f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f12706f = true;
            this.f12705e = RECTANGLE_SHAPE;
            m17071a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f12706f = true;
            this.f12705e = POLYGON_SHAPE;
            this.f12707g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f12706f = true;
            this.f12701a = latLonPoint;
            this.f12702b = latLonPoint2;
            this.f12703c = i;
            this.f12704d = latLonPoint3;
            this.f12705e = str;
            this.f12707g = list;
            this.f12706f = z;
        }

        private void m17071a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f12701a = latLonPoint;
            this.f12702b = latLonPoint2;
            if (this.f12701a.getLatitude() >= this.f12702b.getLatitude() || this.f12701a.getLongitude() >= this.f12702b.getLongitude()) {
                throw new IllegalArgumentException("invalid rect ");
            }
            this.f12704d = new LatLonPoint((this.f12701a.getLatitude() + this.f12702b.getLatitude()) / 2.0d, (this.f12701a.getLongitude() + this.f12702b.getLongitude()) / 2.0d);
        }

        private void m17070a(LatLonPoint latLonPoint, double d, double d2) {
            double d3 = d / 2.0d;
            double d4 = d2 / 2.0d;
            double latitude = latLonPoint.getLatitude();
            double longitude = latLonPoint.getLongitude();
            m17071a(new LatLonPoint(latitude - d3, longitude - d4), new LatLonPoint(d3 + latitude, d4 + longitude));
        }

        public LatLonPoint getLowerLeft() {
            return this.f12701a;
        }

        public LatLonPoint getUpperRight() {
            return this.f12702b;
        }

        public LatLonPoint getCenter() {
            return this.f12704d;
        }

        public double getLonSpanInMeter() {
            if (RECTANGLE_SHAPE.equals(getShape())) {
                return this.f12702b.getLongitude() - this.f12701a.getLongitude();
            }
            return 0.0d;
        }

        public double getLatSpanInMeter() {
            if (RECTANGLE_SHAPE.equals(getShape())) {
                return this.f12702b.getLatitude() - this.f12701a.getLatitude();
            }
            return 0.0d;
        }

        public int getRange() {
            return this.f12703c;
        }

        public String getShape() {
            return this.f12705e;
        }

        public boolean isDistanceSort() {
            return this.f12706f;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f12707g;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f12707g == null ? 0 : this.f12707g.hashCode()) + (((this.f12702b == null ? 0 : this.f12702b.hashCode()) + (((this.f12701a == null ? 0 : this.f12701a.hashCode()) + (((this.f12706f ? 1231 : 1237) + (((this.f12704d == null ? 0 : this.f12704d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + this.f12703c) * 31;
            if (this.f12705e != null) {
                i = this.f12705e.hashCode();
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            if (this.f12704d == null) {
                if (searchBound.f12704d != null) {
                    return false;
                }
            } else if (!this.f12704d.equals(searchBound.f12704d)) {
                return false;
            }
            if (this.f12706f != searchBound.f12706f) {
                return false;
            }
            if (this.f12701a == null) {
                if (searchBound.f12701a != null) {
                    return false;
                }
            } else if (!this.f12701a.equals(searchBound.f12701a)) {
                return false;
            }
            if (this.f12702b == null) {
                if (searchBound.f12702b != null) {
                    return false;
                }
            } else if (!this.f12702b.equals(searchBound.f12702b)) {
                return false;
            }
            if (this.f12707g == null) {
                if (searchBound.f12707g != null) {
                    return false;
                }
            } else if (!this.f12707g.equals(searchBound.f12707g)) {
                return false;
            }
            if (this.f12703c != searchBound.f12703c) {
                return false;
            }
            if (this.f12705e == null) {
                if (searchBound.f12705e != null) {
                    return false;
                }
                return true;
            } else if (this.f12705e.equals(searchBound.f12705e)) {
                return true;
            } else {
                return false;
            }
        }

        public SearchBound clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f12701a, this.f12702b, this.f12703c, this.f12704d, this.f12705e, this.f12707g, this.f12706f);
        }
    }

    public PoiSearch(Context context, Query query) {
        this.f12711c = context.getApplicationContext();
        setQuery(query);
        this.f12717j = C3428p.m16969a();
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        this.f12712d = onPoiSearchListener;
    }

    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f12713e = "en";
        } else {
            this.f12713e = "zh-CN";
        }
    }

    public String getLanguage() {
        return this.f12713e;
    }

    private boolean m17074a() {
        return (C3409d.m16882a(this.f12710b.f12693a) && C3409d.m16882a(this.f12710b.f12694b)) ? false : true;
    }

    private boolean m17078b() {
        SearchBound bound = getBound();
        if (bound != null && bound.getShape().equals(SearchBound.BOUND_SHAPE)) {
            return true;
        }
        return false;
    }

    public PoiResult searchPOI() throws AMapException {
        C3418l.m16960a(this.f12711c);
        if (m17078b() || m17074a()) {
            this.f12710b.setQueryLanguage(this.f12713e);
            if ((!this.f12710b.queryEquals(this.f12714f) && this.f12709a == null) || !(this.f12710b.queryEquals(this.f12714f) || this.f12709a.equals(this.f12715g))) {
                this.f12716h = 0;
                this.f12714f = this.f12710b.clone();
                if (this.f12709a != null) {
                    this.f12715g = this.f12709a.clone();
                }
                if (f12708i != null) {
                    f12708i.clear();
                }
            }
            SearchBound searchBound = null;
            if (this.f12709a != null) {
                searchBound = this.f12709a.clone();
            }
            C3463j c3463j;
            PoiResult a;
            if (this.f12716h == 0) {
                c3463j = new C3463j(this.f12711c, new C3430s(this.f12710b.clone(), searchBound));
                c3463j.m17102a(this.f12710b.f12696d);
                c3463j.m17105b(this.f12710b.f12697e);
                a = PoiResult.m17064a(c3463j, (ArrayList) c3463j.m16577g());
                m17073a(a);
                return a;
            }
            PoiResult pageLocal = getPageLocal(this.f12710b.getPageNum());
            if (pageLocal != null) {
                return pageLocal;
            }
            c3463j = new C3463j(this.f12711c, new C3430s(this.f12710b.clone(), searchBound));
            c3463j.m17102a(this.f12710b.f12696d);
            c3463j.m17105b(this.f12710b.f12697e);
            a = PoiResult.m17064a(c3463j, (ArrayList) c3463j.m16577g());
            f12708i.put(Integer.valueOf(this.f12710b.f12696d), a);
            return a;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public void searchPOIAsyn() {
        new C34521(this).start();
    }

    public PoiItemDetail searchPOIDetail(String str) throws AMapException {
        C3418l.m16960a(this.f12711c);
        return (PoiItemDetail) new C3462i(this.f12711c, str, this.f12713e).m16577g();
    }

    public void searchPOIDetailAsyn(final String str) {
        new Thread(this) {
            final /* synthetic */ PoiSearch f12692b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 61;
                Bundle bundle = new Bundle();
                PoiItemDetail poiItemDetail = null;
                try {
                    poiItemDetail = this.f12692b.searchPOIDetail(str);
                    bundle.putInt(Constant.KEY_ERROR_CODE, 0);
                } catch (Throwable e) {
                    C3409d.m16881a(e, "PoiSearch", "searchPOIDetailAsyn");
                    bundle.putInt(Constant.KEY_ERROR_CODE, e.getErrorCode());
                } finally {
                    C3425d c3425d = new C3425d();
                    c3425d.f12502b = this.f12692b.f12712d;
                    c3425d.f12501a = poiItemDetail;
                    obtainMessage.obj = c3425d;
                    obtainMessage.setData(bundle);
                    this.f12692b.f12717j.sendMessage(obtainMessage);
                }
            }
        }.start();
    }

    public void setQuery(Query query) {
        this.f12710b = query;
    }

    public void setBound(SearchBound searchBound) {
        this.f12709a = searchBound;
    }

    public Query getQuery() {
        return this.f12710b;
    }

    public SearchBound getBound() {
        return this.f12709a;
    }

    private static boolean m17079b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    private void m17073a(PoiResult poiResult) {
        f12708i = new HashMap();
        if (this.f12710b != null && poiResult != null && this.f12716h > 0 && this.f12716h > this.f12710b.getPageNum()) {
            f12708i.put(Integer.valueOf(this.f12710b.getPageNum()), poiResult);
        }
    }

    protected PoiResult getPageLocal(int i) {
        if (m17075a(i)) {
            return (PoiResult) f12708i.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean m17075a(int i) {
        return i <= this.f12716h && i >= 0;
    }
}
