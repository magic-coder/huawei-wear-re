package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineQuery.SearchType;
import com.amap.api.services.busline.BusStationQuery;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* compiled from: BusSearchServerHandler */
public class C3394b<T> extends C3387r<T, ArrayList<?>> {
    private int f12390h = 0;
    private List<String> f12391i = new ArrayList();
    private List<SuggestionCity> f12392j = new ArrayList();

    protected /* synthetic */ Object mo4102b(String str) throws AMapException {
        return mo4100a(str);
    }

    public C3394b(Context context, T t) {
        super(context, t);
    }

    public T m16733c() {
        return this.a;
    }

    public int m16734d() {
        return this.f12390h;
    }

    public String mo4103b() {
        String str = this.a instanceof BusLineQuery ? ((BusLineQuery) this.a).getCategory() == SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.a).getCategory() == SearchType.BY_LINE_NAME ? "linename" : "" : "stopname";
        return C3408c.m16874a() + "/bus/" + str + LocationInfo.NA;
    }

    protected ArrayList<?> mo4100a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f12392j = C3415j.m16900a(optJSONObject);
                this.f12391i = C3415j.m16914b(optJSONObject);
            }
            this.f12390h = jSONObject.optInt("count");
            if (this.a instanceof BusLineQuery) {
                return C3415j.m16937i(jSONObject);
            }
            return C3415j.m16928e(jSONObject);
        } catch (Throwable e) {
            C3409d.m16881a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    public List<String> b_() {
        return this.f12391i;
    }

    public List<SuggestionCity> mo4114f() {
        return this.f12392j;
    }

    protected String a_() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        String city;
        if (this.a instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.a;
            stringBuilder.append("&extensions=all");
            if (busLineQuery.getCategory() == SearchType.BY_LINE_ID) {
                stringBuilder.append("&id=").append(m16574c(((BusLineQuery) this.a).getQueryString()));
            } else {
                city = busLineQuery.getCity();
                if (!C3415j.m16935h(city)) {
                    stringBuilder.append("&city=").append(m16574c(city));
                }
                stringBuilder.append("&keywords=" + m16574c(busLineQuery.getQueryString()));
                stringBuilder.append("&offset=" + busLineQuery.getPageSize());
                stringBuilder.append("&page=" + (busLineQuery.getPageNumber() + 1));
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.a;
            city = busStationQuery.getCity();
            if (!C3415j.m16935h(city)) {
                stringBuilder.append("&city=").append(m16574c(city));
            }
            stringBuilder.append("&keywords=" + m16574c(busStationQuery.getQueryString()));
            stringBuilder.append("&offset=" + busStationQuery.getPageSize());
            stringBuilder.append("&page=" + (busStationQuery.getPageNumber() + 1));
        }
        stringBuilder.append("&key=" + C3434w.m16993f(this.d));
        return stringBuilder.toString();
    }
}
