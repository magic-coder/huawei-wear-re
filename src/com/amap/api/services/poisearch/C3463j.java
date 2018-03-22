package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3408c;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3415j;
import com.amap.api.services.core.C3430s;
import com.amap.api.services.core.C3434w;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler */
class C3463j extends C3460g<C3430s, ArrayList<PoiItem>> {
    private int f12732h = 1;
    private int f12733i = 20;
    private int f12734j = 0;
    private List<String> f12735k = new ArrayList();
    private List<SuggestionCity> f12736l = new ArrayList();

    public /* synthetic */ Object mo4102b(String str) throws AMapException {
        return m17106e(str);
    }

    public C3463j(Context context, C3430s c3430s) {
        super(context, c3430s);
    }

    public void m17102a(int i) {
        this.f12732h = i + 1;
    }

    public void m17105b(int i) {
        int i2;
        int i3 = 30;
        if (i > 30) {
            i2 = 30;
        } else {
            i2 = i;
        }
        if (i2 > 0) {
            i3 = i2;
        }
        this.f12733i = i3;
    }

    public int mo4114f() {
        return this.f12733i;
    }

    public int m17108i() {
        return this.f12734j;
    }

    public Query m17109j() {
        return ((C3430s) this.a).f12508a;
    }

    public SearchBound m17110k() {
        return ((C3430s) this.a).f12509b;
    }

    public List<String> m17111l() {
        return this.f12735k;
    }

    public List<SuggestionCity> m17112m() {
        return this.f12736l;
    }

    public String mo4103b() {
        String str = C3408c.m16874a() + "/place";
        if (((C3430s) this.a).f12509b == null) {
            return str + "/text?";
        }
        if (((C3430s) this.a).f12509b.getShape().equals(SearchBound.BOUND_SHAPE)) {
            return str + "/around?";
        }
        return (((C3430s) this.a).f12509b.getShape().equals(SearchBound.RECTANGLE_SHAPE) || ((C3430s) this.a).f12509b.getShape().equals(SearchBound.POLYGON_SHAPE)) ? str + "/polygon?" : str;
    }

    public ArrayList<PoiItem> m17106e(String str) throws AMapException {
        ArrayList<PoiItem> arrayList = new ArrayList();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f12734j = jSONObject.optInt("count");
                arrayList = C3415j.m16920c(jSONObject);
                if (jSONObject.has("suggestion")) {
                    jSONObject = jSONObject.optJSONObject("suggestion");
                    if (jSONObject != null) {
                        this.f12736l = C3415j.m16900a(jSONObject);
                        this.f12735k = C3415j.m16914b(jSONObject);
                    }
                }
            } catch (Throwable e) {
                C3409d.m16881a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            } catch (Throwable e2) {
                C3409d.m16881a(e2, "PoiSearchKeywordHandler", "paseJSONException");
            }
        }
        return arrayList;
    }

    protected String a_() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        if (((C3430s) this.a).f12509b != null) {
            double a;
            if (((C3430s) this.a).f12509b.getShape().equals(SearchBound.BOUND_SHAPE)) {
                a = C3409d.m16876a(((C3430s) this.a).f12509b.getCenter().getLongitude());
                stringBuilder.append("&location=").append(a + "," + C3409d.m16876a(((C3430s) this.a).f12509b.getCenter().getLatitude()));
                stringBuilder.append("&radius=").append(((C3430s) this.a).f12509b.getRange());
                stringBuilder.append("&sortrule=").append(m17100n());
            } else if (((C3430s) this.a).f12509b.getShape().equals(SearchBound.RECTANGLE_SHAPE)) {
                LatLonPoint lowerLeft = ((C3430s) this.a).f12509b.getLowerLeft();
                LatLonPoint upperRight = ((C3430s) this.a).f12509b.getUpperRight();
                double a2 = C3409d.m16876a(lowerLeft.getLatitude());
                a = C3409d.m16876a(lowerLeft.getLongitude());
                stringBuilder.append("&polygon=" + a + "," + a2 + ";" + C3409d.m16876a(upperRight.getLongitude()) + "," + C3409d.m16876a(upperRight.getLatitude()));
            } else if (((C3430s) this.a).f12509b.getShape().equals(SearchBound.POLYGON_SHAPE)) {
                List polyGonList = ((C3430s) this.a).f12509b.getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    stringBuilder.append("&polygon=" + C3409d.m16880a(polyGonList));
                }
            }
        }
        String city = ((C3430s) this.a).f12508a.getCity();
        if (!mo4100a(city)) {
            stringBuilder.append("&city=").append(m16574c(city));
        }
        if (!C3409d.m16882a(m17101o())) {
            stringBuilder.append(m17101o());
        }
        stringBuilder.append("&keywords=" + m16574c(((C3430s) this.a).f12508a.getQueryString()));
        stringBuilder.append("&language=").append(C3408c.m16875b());
        stringBuilder.append("&offset=" + this.f12733i);
        stringBuilder.append("&page=" + this.f12732h);
        stringBuilder.append("&types=" + m16574c(((C3430s) this.a).f12508a.getCategory()));
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&key=" + C3434w.m16993f(this.d));
        return stringBuilder.toString();
    }

    private String m17100n() {
        if (((C3430s) this.a).f12509b.isDistanceSort()) {
            return "distance";
        }
        return "weight";
    }

    private String m17101o() {
        StringBuffer stringBuffer = new StringBuffer();
        if (((C3430s) this.a).f12508a.hasGroupBuyLimit() && ((C3430s) this.a).f12508a.hasDiscountLimit()) {
            stringBuffer.append("&filter=groupbuy:1|discount:1");
            return stringBuffer.toString();
        }
        if (((C3430s) this.a).f12508a.hasGroupBuyLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("groupbuy:1");
        }
        if (((C3430s) this.a).f12508a.hasDiscountLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("discount:1");
        }
        return stringBuffer.toString();
    }
}
