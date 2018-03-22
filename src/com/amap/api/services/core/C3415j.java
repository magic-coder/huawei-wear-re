package com.amap.api.services.core;

import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Cinema;
import com.amap.api.services.poisearch.Dining;
import com.amap.api.services.poisearch.Discount;
import com.amap.api.services.poisearch.Groupbuy;
import com.amap.api.services.poisearch.Hotel;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiItemDetail.DeepType;
import com.amap.api.services.poisearch.Scenic;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public class C3415j {
    public static ArrayList<SuggestionCity> m16900a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        ArrayList<SuggestionCity> arrayList = new ArrayList();
        if (!jSONObject.has("cities")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(C3415j.m16913b(optJSONObject, "name"), C3415j.m16913b(optJSONObject, "citycode"), C3415j.m16913b(optJSONObject, "adcode"), C3415j.m16936i(C3415j.m16913b(optJSONObject, Constants.FIELD_APPLET_CONFIG_NUM))));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> m16914b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> m16920c(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItem> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16923d(optJSONObject));
            }
        }
        return arrayList;
    }

    public static PoiItemDetail m16923d(JSONObject jSONObject) throws JSONException {
        PoiItemDetail poiItemDetail = new PoiItemDetail(C3415j.m16913b(jSONObject, "id"), C3415j.m16918c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED), C3415j.m16913b(jSONObject, "name"), C3415j.m16913b(jSONObject, UserInfo.ADDRESS));
        poiItemDetail.setAdCode(C3415j.m16913b(jSONObject, "adcode"));
        poiItemDetail.setProvinceName(C3415j.m16913b(jSONObject, "pname"));
        poiItemDetail.setCityName(C3415j.m16913b(jSONObject, "cityname"));
        poiItemDetail.setAdName(C3415j.m16913b(jSONObject, "adname"));
        poiItemDetail.setCityCode(C3415j.m16913b(jSONObject, "citycode"));
        poiItemDetail.setProvinceCode(C3415j.m16913b(jSONObject, "pcode"));
        poiItemDetail.setDirection(C3415j.m16913b(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String b = C3415j.m16913b(jSONObject, "distance");
            if (!C3415j.m16935h(b)) {
                try {
                    poiItemDetail.setDistance((int) Float.parseFloat(b));
                } catch (Throwable e) {
                    C3409d.m16881a(e, "JSONHelper", "parseBasePoi");
                } catch (Throwable e2) {
                    C3409d.m16881a(e2, "JSONHelper", "parseBasePoi");
                }
                if (poiItemDetail.getDistance() == 0) {
                    poiItemDetail.setDistance(-1);
                }
            }
        }
        poiItemDetail.setTel(C3415j.m16913b(jSONObject, "tel"));
        poiItemDetail.setTypeDes(C3415j.m16913b(jSONObject, "type"));
        poiItemDetail.setEnter(C3415j.m16918c(jSONObject, "entr_location"));
        poiItemDetail.setExit(C3415j.m16918c(jSONObject, "exit_location"));
        poiItemDetail.setWebsite(C3415j.m16913b(jSONObject, "website"));
        poiItemDetail.setPostcode(C3415j.m16913b(jSONObject, "citycode"));
        poiItemDetail.setEmail(C3415j.m16913b(jSONObject, "email"));
        if (C3415j.m16933g(C3415j.m16913b(jSONObject, "groupbuy_num"))) {
            poiItemDetail.setGroupbuyInfo(false);
        } else {
            poiItemDetail.setGroupbuyInfo(true);
        }
        if (C3415j.m16933g(C3415j.m16913b(jSONObject, "discount_num"))) {
            poiItemDetail.setDiscountInfo(false);
        } else {
            poiItemDetail.setDiscountInfo(true);
        }
        if (C3415j.m16933g(C3415j.m16913b(jSONObject, "indoor_map"))) {
            poiItemDetail.setIndoorMap(false);
        } else {
            poiItemDetail.setIndoorMap(true);
        }
        return poiItemDetail;
    }

    public static ArrayList<BusStationItem> m16928e(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16930f(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusStationItem m16930f(JSONObject jSONObject) throws JSONException {
        BusStationItem g = C3415j.m16932g(jSONObject);
        if (g == null) {
            return g;
        }
        g.setAdCode(C3415j.m16913b(jSONObject, "adcode"));
        g.setCityCode(C3415j.m16913b(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        List arrayList = new ArrayList();
        if (optJSONArray == null) {
            g.setBusLineItems(arrayList);
            return g;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16934h(optJSONObject));
            }
        }
        g.setBusLineItems(arrayList);
        return g;
    }

    public static BusStationItem m16932g(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(C3415j.m16913b(jSONObject, "id"));
        busStationItem.setLatLonPoint(C3415j.m16918c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        busStationItem.setBusStationName(C3415j.m16913b(jSONObject, "name"));
        return busStationItem;
    }

    public static BusLineItem m16934h(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(C3415j.m16913b(jSONObject, "id"));
        busLineItem.setBusLineType(C3415j.m16913b(jSONObject, "type"));
        busLineItem.setBusLineName(C3415j.m16913b(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(C3415j.m16925d(jSONObject, "polyline"));
        busLineItem.setCityCode(C3415j.m16913b(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(C3415j.m16913b(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(C3415j.m16913b(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> m16937i(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16939j(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusLineItem m16939j(JSONObject jSONObject) throws JSONException {
        BusLineItem h = C3415j.m16934h(jSONObject);
        if (h == null) {
            return h;
        }
        h.setFirstBusTime(C3409d.m16885d(C3415j.m16913b(jSONObject, "start_time")));
        h.setLastBusTime(C3409d.m16885d(C3415j.m16913b(jSONObject, "end_time")));
        h.setBusCompany(C3415j.m16913b(jSONObject, "company"));
        h.setDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "distance")));
        h.setBasicPrice(C3415j.m16938j(C3415j.m16913b(jSONObject, "basic_price")));
        h.setTotalPrice(C3415j.m16938j(C3415j.m16913b(jSONObject, "total_price")));
        h.setBounds(C3415j.m16925d(jSONObject, "bounds"));
        List arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            h.setBusStations(arrayList);
            return h;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16932g(optJSONObject));
            }
        }
        h.setBusStations(arrayList);
        return h;
    }

    public static Scenic m16899a(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Scenic scenic = new Scenic();
        scenic.setIntro(C3415j.m16913b(jSONObject, "intro"));
        scenic.setRating(C3415j.m16913b(jSONObject, "rating"));
        scenic.setDeepsrc(C3415j.m16913b(jSONObject, "deepsrc"));
        scenic.setLevel(C3415j.m16913b(jSONObject, "level"));
        scenic.setPrice(C3415j.m16913b(jSONObject, "price"));
        scenic.setSeason(C3415j.m16913b(jSONObject, "season"));
        scenic.setRecommend(C3415j.m16913b(jSONObject, "recommend"));
        scenic.setTheme(C3415j.m16913b(jSONObject, "theme"));
        scenic.setOrderWapUrl(C3415j.m16913b(jSONObject, "ordering_wap_url"));
        scenic.setOrderWebUrl(C3415j.m16913b(jSONObject, "ordering_web_url"));
        scenic.setOpentimeGDF(C3415j.m16913b(jSONObject, "opentime_GDF"));
        scenic.setOpentime(C3415j.m16913b(jSONObject, "opentime"));
        scenic.setPhotos(C3415j.m16942l(jSONObject));
        poiItemDetail.setDeepType(DeepType.SCENIC);
        poiItemDetail.setScenic(scenic);
        return scenic;
    }

    public static void m16916b(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Cinema cinema = new Cinema();
        cinema.setIntro(C3415j.m16913b(jSONObject, "intro"));
        cinema.setRating(C3415j.m16913b(jSONObject, "rating"));
        cinema.setDeepsrc(C3415j.m16913b(jSONObject, "deepsrc"));
        cinema.setParking(C3415j.m16913b(jSONObject, "parking"));
        cinema.setOpentimeGDF(C3415j.m16913b(jSONObject, "opentime_GDF"));
        cinema.setOpentime(C3415j.m16913b(jSONObject, "opentime"));
        cinema.setPhotos(C3415j.m16942l(jSONObject));
        if (C3415j.m16941k(jSONObject2)) {
            cinema.setSeatOrdering(C3415j.m16911a(jSONObject2, "seat_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.CINEMA);
        poiItemDetail.setCinema(cinema);
    }

    public static void m16922c(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Hotel hotel = new Hotel();
        hotel.setStar(C3415j.m16913b(jSONObject, "star"));
        hotel.setIntro(C3415j.m16913b(jSONObject, "intro"));
        hotel.setRating(C3415j.m16913b(jSONObject, "rating"));
        hotel.setLowestPrice(C3415j.m16913b(jSONObject, "lowest_price"));
        hotel.setDeepsrc(C3415j.m16913b(jSONObject, "deepsrc"));
        hotel.setFaciRating(C3415j.m16913b(jSONObject, "faci_rating"));
        hotel.setHealthRating(C3415j.m16913b(jSONObject, "health_rating"));
        hotel.setEnvironmentRating(C3415j.m16913b(jSONObject, "environment_rating"));
        hotel.setServiceRating(C3415j.m16913b(jSONObject, "service_rating"));
        hotel.setTraffic(C3415j.m16913b(jSONObject, "traffic"));
        hotel.setAddition(C3415j.m16913b(jSONObject, "addition"));
        hotel.setPhotos(C3415j.m16942l(jSONObject));
        poiItemDetail.setDeepType(DeepType.HOTEL);
        poiItemDetail.setHotel(hotel);
    }

    public static void m16926d(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Dining dining = new Dining();
        dining.setCuisines(C3415j.m16913b(jSONObject, "cuisines"));
        dining.setTag(C3415j.m16913b(jSONObject, "tag"));
        dining.setIntro(C3415j.m16913b(jSONObject, "intro"));
        dining.setRating(C3415j.m16913b(jSONObject, "rating"));
        dining.setCpRating(C3415j.m16913b(jSONObject, "cp_rating"));
        dining.setDeepsrc(C3415j.m16913b(jSONObject, "deepsrc"));
        dining.setTasteRating(C3415j.m16913b(jSONObject, "taste_rating"));
        dining.setEnvironmentRating(C3415j.m16913b(jSONObject, "environment_rating"));
        dining.setServiceRating(C3415j.m16913b(jSONObject, "service_rating"));
        dining.setCost(C3415j.m16913b(jSONObject, "cost"));
        dining.setRecommend(C3415j.m16913b(jSONObject, "recommend"));
        dining.setAtmosphere(C3415j.m16913b(jSONObject, "atmosphere"));
        dining.setOrderingWapUrl(C3415j.m16913b(jSONObject, "ordering_wap_url"));
        dining.setOrderingWebUrl(C3415j.m16913b(jSONObject, "ordering_web_url"));
        dining.setOrderinAppUrl(C3415j.m16913b(jSONObject, "ordering_app_url"));
        dining.setOpentimeGDF(C3415j.m16913b(jSONObject, "opentime_GDF"));
        dining.setOpentime(C3415j.m16913b(jSONObject, "opentime"));
        dining.setAddition(C3415j.m16913b(jSONObject, "addition"));
        dining.setPhotos(C3415j.m16942l(jSONObject));
        if (C3415j.m16941k(jSONObject2)) {
            dining.setMealOrdering(C3415j.m16911a(jSONObject2, "meal_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.DINING);
        poiItemDetail.setDining(dining);
    }

    public static void m16929e(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject != null) {
            String b = C3415j.m16913b(jSONObject, "type");
            if (b.equalsIgnoreCase("hotel")) {
                C3415j.m16922c(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("dining")) {
                C3415j.m16926d(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("cinema")) {
                C3415j.m16916b(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("scenic")) {
                C3415j.m16899a(poiItemDetail, jSONObject, jSONObject2);
            }
        }
    }

    public static boolean m16911a(JSONObject jSONObject, String str) throws JSONException {
        return C3415j.m16910a(C3415j.m16913b(jSONObject.optJSONObject("biz_ext"), str));
    }

    public static boolean m16910a(String str) {
        try {
            if (str.equals("")) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt != 0 && parseInt == 1) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C3409d.m16881a(e, "JSONHelper", "ordingStr2Boolean");
            return false;
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "JSONHelper", "ordingStr2BooleanException");
            return false;
        }
    }

    public static boolean m16941k(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("biz_ext")) {
            return true;
        }
        return false;
    }

    public static void m16904a(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (poiItemDetail.isGroupbuyInfo()) {
                C3415j.m16915b(poiItemDetail, jSONObject);
            }
            if (poiItemDetail.isDiscountInfo()) {
                C3415j.m16921c(poiItemDetail, jSONObject);
            }
        }
    }

    public static void m16915b(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("groupbuys");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        Groupbuy groupbuy = new Groupbuy();
                        groupbuy.setTypeCode(C3415j.m16913b(optJSONObject, "typecode"));
                        groupbuy.setTypeDes(C3415j.m16913b(optJSONObject, "type"));
                        groupbuy.setDetail(C3415j.m16913b(optJSONObject, "detail"));
                        groupbuy.setStartTime(C3409d.m16884c(C3415j.m16913b(optJSONObject, "start_time")));
                        groupbuy.setEndTime(C3409d.m16884c(C3415j.m16913b(optJSONObject, "end_time")));
                        groupbuy.setCount(C3415j.m16936i(C3415j.m16913b(optJSONObject, Constants.FIELD_APPLET_CONFIG_NUM)));
                        groupbuy.setSoldCount(C3415j.m16936i(C3415j.m16913b(optJSONObject, "sold_num")));
                        groupbuy.setOriginalPrice(C3415j.m16938j(C3415j.m16913b(optJSONObject, "original_price")));
                        groupbuy.setGroupbuyPrice(C3415j.m16938j(C3415j.m16913b(optJSONObject, "groupbuy_price")));
                        groupbuy.setDiscount(C3415j.m16938j(C3415j.m16913b(optJSONObject, "discount")));
                        groupbuy.setTicketAddress(C3415j.m16913b(optJSONObject, "ticket_address"));
                        groupbuy.setTicketTel(C3415j.m16913b(optJSONObject, "ticket_tel"));
                        groupbuy.setUrl(C3415j.m16913b(optJSONObject, "url"));
                        groupbuy.setProvider(C3415j.m16913b(optJSONObject, "provider"));
                        C3415j.m16903a(groupbuy, optJSONObject);
                        poiItemDetail.addGroupbuy(groupbuy);
                    }
                }
            }
        }
    }

    public static void m16903a(Groupbuy groupbuy, JSONObject jSONObject) throws JSONException {
        groupbuy.initPhotos(C3415j.m16942l(jSONObject));
    }

    public static void m16921c(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("discounts");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    Discount discount = new Discount();
                    discount.setTitle(C3415j.m16913b(optJSONObject, "title"));
                    discount.setDetail(C3415j.m16913b(optJSONObject, "detail"));
                    discount.setStartTime(C3409d.m16884c(C3415j.m16913b(optJSONObject, "start_time")));
                    discount.setEndTime(C3409d.m16884c(C3415j.m16913b(optJSONObject, "end_time")));
                    discount.setSoldCount(C3415j.m16936i(C3415j.m16913b(optJSONObject, "sold_num")));
                    discount.setUrl(C3415j.m16913b(optJSONObject, "url"));
                    discount.setProvider(C3415j.m16913b(optJSONObject, "provider"));
                    C3415j.m16902a(discount, optJSONObject);
                    poiItemDetail.addDiscount(discount);
                }
            }
        }
    }

    public static void m16902a(Discount discount, JSONObject jSONObject) {
        discount.initPhotos(C3415j.m16942l(jSONObject));
    }

    public static List<Photo> m16942l(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("photos");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Photo photo = new Photo();
                    photo.setTitle(C3415j.m16913b(optJSONObject, "title"));
                    photo.setUrl(C3415j.m16913b(optJSONObject, "url"));
                    arrayList.add(photo);
                }
            } catch (Throwable e) {
                C3409d.m16881a(e, "JSONHelper", "getPhotoList");
            }
        }
        return arrayList;
    }

    public static DistrictItem m16944m(JSONObject jSONObject) throws JSONException {
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(C3415j.m16913b(jSONObject, "citycode"));
        districtItem.setAdcode(C3415j.m16913b(jSONObject, "adcode"));
        districtItem.setName(C3415j.m16913b(jSONObject, "name"));
        districtItem.setLevel(C3415j.m16913b(jSONObject, "level"));
        districtItem.setCenter(C3415j.m16918c(jSONObject, "center"));
        if (jSONObject.has("polyline")) {
            String string = jSONObject.getString("polyline");
            if (string != null && string.length() > 0) {
                districtItem.setDistrictBoundary(string.split("\\|"));
            }
        }
        C3415j.m16908a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    public static void m16908a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(C3415j.m16944m(optJSONObject));
                }
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static ArrayList<GeocodeAddress> m16945n(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GeocodeAddress geocodeAddress = new GeocodeAddress();
                geocodeAddress.setFormatAddress(C3415j.m16913b(optJSONObject, "formatted_address"));
                geocodeAddress.setProvince(C3415j.m16913b(optJSONObject, "province"));
                geocodeAddress.setCity(C3415j.m16913b(optJSONObject, "city"));
                geocodeAddress.setDistrict(C3415j.m16913b(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                geocodeAddress.setTownship(C3415j.m16913b(optJSONObject, "township"));
                geocodeAddress.setNeighborhood(C3415j.m16913b(optJSONObject.optJSONObject("neighborhood"), "name"));
                geocodeAddress.setBuilding(C3415j.m16913b(optJSONObject.optJSONObject("building"), "name"));
                geocodeAddress.setAdcode(C3415j.m16913b(optJSONObject, "adcode"));
                geocodeAddress.setLatLonPoint(C3415j.m16918c(optJSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
                geocodeAddress.setLevel(C3415j.m16913b(optJSONObject, "level"));
                arrayList.add(geocodeAddress);
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> m16946o(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(C3415j.m16913b(optJSONObject, "name"));
                tip.setDistrict(C3415j.m16913b(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(C3415j.m16913b(optJSONObject, "adcode"));
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static void m16907a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(C3415j.m16913b(optJSONObject, "id"));
                crossroad.setDirection(C3415j.m16913b(optJSONObject, "direction"));
                crossroad.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "distance")));
                crossroad.setCenterPoint(C3415j.m16918c(optJSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
                crossroad.setFirstRoadId(C3415j.m16913b(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(C3415j.m16913b(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(C3415j.m16913b(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(C3415j.m16913b(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void m16917b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(C3415j.m16913b(optJSONObject, "id"));
                regeocodeRoad.setName(C3415j.m16913b(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(C3415j.m16918c(optJSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
                regeocodeRoad.setDirection(C3415j.m16913b(optJSONObject, "direction"));
                regeocodeRoad.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void m16909a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setProvince(C3415j.m16913b(jSONObject, "province"));
        regeocodeAddress.setCity(C3415j.m16913b(jSONObject, "city"));
        regeocodeAddress.setCityCode(C3415j.m16913b(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(C3415j.m16913b(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(C3415j.m16913b(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(C3415j.m16913b(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(C3415j.m16913b(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(C3415j.m16913b(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(C3415j.m16913b(optJSONObject, "street"));
        streetNumber.setNumber(C3415j.m16913b(optJSONObject, "number"));
        streetNumber.setLatLonPoint(C3415j.m16918c(optJSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        streetNumber.setDirection(C3415j.m16913b(optJSONObject, "direction"));
        streetNumber.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(C3415j.m16947p(jSONObject));
    }

    public static List<BusinessArea> m16947p(JSONObject jSONObject) throws JSONException {
        List<BusinessArea> arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BusinessArea businessArea = new BusinessArea();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                businessArea.setCenterPoint(C3415j.m16918c(optJSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
                businessArea.setName(C3415j.m16913b(optJSONObject, "name"));
                arrayList.add(businessArea);
            }
        }
        return arrayList;
    }

    public static BusRouteResult m16912b(String str) throws AMapException {
        BusRouteResult busRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                busRouteResult = new BusRouteResult();
                jSONObject = jSONObject.optJSONObject("route");
                if (jSONObject != null) {
                    busRouteResult.setStartPos(C3415j.m16918c(jSONObject, "origin"));
                    busRouteResult.setTargetPos(C3415j.m16918c(jSONObject, "destination"));
                    busRouteResult.setTaxiCost(C3415j.m16938j(C3415j.m16913b(jSONObject, "taxi_cost")));
                    if (jSONObject.has("transits")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("transits");
                        if (optJSONArray != null) {
                            busRouteResult.setPaths(C3415j.m16901a(optJSONArray));
                        }
                    }
                }
            }
            return busRouteResult;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static List<BusPath> m16901a(JSONArray jSONArray) throws JSONException {
        List<BusPath> arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(C3415j.m16938j(C3415j.m16913b(optJSONObject, "cost")));
                busPath.setDuration(C3415j.m16940k(C3415j.m16913b(optJSONObject, "duration")));
                busPath.setNightBus(C3415j.m16943l(C3415j.m16913b(optJSONObject, "nightflag")));
                busPath.setWalkDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "walking_distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    List arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            BusStep q = C3415j.m16948q(optJSONObject2);
                            if (q != null) {
                                arrayList2.add(q);
                                if (q.getWalk() != null) {
                                    f += q.getWalk().getDistance();
                                }
                                if (q.getBusLine() != null) {
                                    f2 += q.getBusLine().getDistance();
                                }
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f2);
                    busPath.setWalkDistance(f);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    public static BusStep m16948q(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(C3415j.m16949r(optJSONObject));
        }
        optJSONObject = jSONObject.optJSONObject("bus");
        if (optJSONObject != null) {
            busStep.setBusLines(C3415j.m16950s(optJSONObject));
        }
        optJSONObject = jSONObject.optJSONObject("entrance");
        if (optJSONObject != null) {
            busStep.setEntrance(C3415j.m16951t(optJSONObject));
        }
        optJSONObject = jSONObject.optJSONObject("exit");
        if (optJSONObject == null) {
            return busStep;
        }
        busStep.setExit(C3415j.m16951t(optJSONObject));
        return busStep;
    }

    public static RouteBusWalkItem m16949r(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(C3415j.m16918c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(C3415j.m16918c(jSONObject, "destination"));
        routeBusWalkItem.setDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "distance")));
        routeBusWalkItem.setDuration(C3415j.m16940k(C3415j.m16913b(jSONObject, "duration")));
        if (!jSONObject.has("steps")) {
            return routeBusWalkItem;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("steps");
        if (optJSONArray == null) {
            return routeBusWalkItem;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16952u(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    public static List<RouteBusLineItem> m16950s(JSONObject jSONObject) throws JSONException {
        List<RouteBusLineItem> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16953v(optJSONObject));
            }
        }
        return arrayList;
    }

    public static Doorway m16951t(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(C3415j.m16913b(jSONObject, "name"));
        doorway.setLatLonPoint(C3415j.m16918c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        return doorway;
    }

    public static WalkStep m16952u(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(C3415j.m16913b(jSONObject, "instruction"));
        walkStep.setOrientation(C3415j.m16913b(jSONObject, "orientation"));
        walkStep.setRoad(C3415j.m16913b(jSONObject, "road"));
        walkStep.setDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "distance")));
        walkStep.setDuration(C3415j.m16938j(C3415j.m16913b(jSONObject, "duration")));
        walkStep.setPolyline(C3415j.m16925d(jSONObject, "polyline"));
        walkStep.setAction(C3415j.m16913b(jSONObject, JoinConstants.ACTION));
        walkStep.setAssistantAction(C3415j.m16913b(jSONObject, "assistant_action"));
        return walkStep;
    }

    public static RouteBusLineItem m16953v(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(C3415j.m16955x(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(C3415j.m16955x(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(C3415j.m16913b(jSONObject, "name"));
        routeBusLineItem.setBusLineId(C3415j.m16913b(jSONObject, "id"));
        routeBusLineItem.setBusLineType(C3415j.m16913b(jSONObject, "type"));
        routeBusLineItem.setDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "distance")));
        routeBusLineItem.setDuration(C3415j.m16938j(C3415j.m16913b(jSONObject, "duration")));
        routeBusLineItem.setPolyline(C3415j.m16925d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(C3409d.m16885d(C3415j.m16913b(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(C3409d.m16885d(C3415j.m16913b(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(C3415j.m16936i(C3415j.m16913b(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(C3415j.m16954w(jSONObject));
        return routeBusLineItem;
    }

    public static List<BusStationItem> m16954w(JSONObject jSONObject) throws JSONException {
        List<BusStationItem> arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("via_stops");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C3415j.m16955x(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusStationItem m16955x(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(C3415j.m16913b(jSONObject, "name"));
        busStationItem.setBusStationId(C3415j.m16913b(jSONObject, "id"));
        busStationItem.setLatLonPoint(C3415j.m16918c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        return busStationItem;
    }

    public static DriveRouteResult m16919c(String str) throws AMapException {
        DriveRouteResult driveRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                driveRouteResult = new DriveRouteResult();
                jSONObject = jSONObject.optJSONObject("route");
                if (jSONObject != null) {
                    driveRouteResult.setStartPos(C3415j.m16918c(jSONObject, "origin"));
                    driveRouteResult.setTargetPos(C3415j.m16918c(jSONObject, "destination"));
                    driveRouteResult.setTaxiCost(C3415j.m16938j(C3415j.m16913b(jSONObject, "taxi_cost")));
                    if (jSONObject.has("paths")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("paths");
                        if (optJSONArray != null) {
                            List arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                DrivePath drivePath = new DrivePath();
                                jSONObject = optJSONArray.optJSONObject(i);
                                if (jSONObject != null) {
                                    drivePath.setDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "distance")));
                                    drivePath.setDuration(C3415j.m16940k(C3415j.m16913b(jSONObject, "duration")));
                                    drivePath.setStrategy(C3415j.m16913b(jSONObject, "strategy"));
                                    drivePath.setTolls(C3415j.m16938j(C3415j.m16913b(jSONObject, "tolls")));
                                    drivePath.setTollDistance(C3415j.m16938j(C3415j.m16913b(jSONObject, "toll_distance")));
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("steps");
                                    if (optJSONArray2 != null) {
                                        List arrayList2 = new ArrayList();
                                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                            DriveStep driveStep = new DriveStep();
                                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                                            if (optJSONObject != null) {
                                                driveStep.setInstruction(C3415j.m16913b(optJSONObject, "instruction"));
                                                driveStep.setOrientation(C3415j.m16913b(optJSONObject, "orientation"));
                                                driveStep.setRoad(C3415j.m16913b(optJSONObject, "road"));
                                                driveStep.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "distance")));
                                                driveStep.setTolls(C3415j.m16938j(C3415j.m16913b(optJSONObject, "tolls")));
                                                driveStep.setTollDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "toll_distance")));
                                                driveStep.setTollRoad(C3415j.m16913b(optJSONObject, "toll_road"));
                                                driveStep.setDuration(C3415j.m16938j(C3415j.m16913b(optJSONObject, "duration")));
                                                driveStep.setPolyline(C3415j.m16925d(optJSONObject, "polyline"));
                                                driveStep.setAction(C3415j.m16913b(optJSONObject, JoinConstants.ACTION));
                                                driveStep.setAssistantAction(C3415j.m16913b(optJSONObject, "assistant_action"));
                                                C3415j.m16905a(driveStep, optJSONObject);
                                                arrayList2.add(driveStep);
                                            }
                                        }
                                        drivePath.setSteps(arrayList2);
                                        arrayList.add(drivePath);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            driveRouteResult.setPaths(arrayList);
                        }
                    }
                }
            }
            return driveRouteResult;
        } catch (Throwable e) {
            C3409d.m16881a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "JSONHelper", "parseDriveRouteThrowable");
            AMapException aMapException = new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void m16905a(DriveStep driveStep, JSONObject jSONObject) {
        try {
            List arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(C3415j.m16913b(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(C3415j.m16913b(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(C3415j.m16913b(optJSONObject, "adcode"));
                        C3415j.m16906a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                driveStep.setRouteSearchCityList(arrayList);
            }
        } catch (Throwable e) {
            C3409d.m16881a(e, "JSONHelper", "parseCrossCity");
        }
    }

    public static void m16906a(RouteSearchCity routeSearchCity, JSONObject jSONObject) {
        if (jSONObject.has("districts")) {
            try {
                List arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(C3415j.m16913b(optJSONObject, "name"));
                        district.setDistrictAdcode(C3415j.m16913b(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (Throwable e) {
                C3409d.m16881a(e, "JSONHelper", "parseCrossDistricts");
            }
        }
    }

    public static WalkRouteResult m16924d(String str) {
        Throwable e;
        WalkRouteResult walkRouteResult;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            walkRouteResult = new WalkRouteResult();
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                walkRouteResult.setStartPos(C3415j.m16918c(optJSONObject, "origin"));
                walkRouteResult.setTargetPos(C3415j.m16918c(optJSONObject, "destination"));
                if (!optJSONObject.has("paths")) {
                    return walkRouteResult;
                }
                List arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                if (optJSONArray == null) {
                    walkRouteResult.setPaths(arrayList);
                    return walkRouteResult;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    WalkPath walkPath = new WalkPath();
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        walkPath.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject, "distance")));
                        walkPath.setDuration(C3415j.m16940k(C3415j.m16913b(optJSONObject, "duration")));
                        if (optJSONObject.has("steps")) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("steps");
                            List arrayList2 = new ArrayList();
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    WalkStep walkStep = new WalkStep();
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject2 != null) {
                                        walkStep.setInstruction(C3415j.m16913b(optJSONObject2, "instruction"));
                                        walkStep.setOrientation(C3415j.m16913b(optJSONObject2, "orientation"));
                                        walkStep.setRoad(C3415j.m16913b(optJSONObject2, "road"));
                                        walkStep.setDistance(C3415j.m16938j(C3415j.m16913b(optJSONObject2, "distance")));
                                        walkStep.setDuration(C3415j.m16938j(C3415j.m16913b(optJSONObject2, "duration")));
                                        walkStep.setPolyline(C3415j.m16925d(optJSONObject2, "polyline"));
                                        walkStep.setAction(C3415j.m16913b(optJSONObject2, JoinConstants.ACTION));
                                        walkStep.setAssistantAction(C3415j.m16913b(optJSONObject2, "assistant_action"));
                                        arrayList2.add(walkStep);
                                    }
                                }
                                walkPath.setSteps(arrayList2);
                            }
                        }
                        arrayList.add(walkPath);
                    }
                }
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            walkRouteResult = null;
            e = th;
            C3409d.m16881a(e, "JSONHelper", "parseWalkRoute");
            return walkRouteResult;
        }
    }

    public static String m16913b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) {
            return str2;
        }
        return jSONObject.optString(str);
    }

    public static LatLonPoint m16918c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return C3415j.m16931f(jSONObject.optString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> m16925d(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return C3415j.m16927e(jSONObject.getString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> m16927e(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList();
        String[] split = str.split(";");
        for (String f : split) {
            arrayList.add(C3415j.m16931f(f));
        }
        return arrayList;
    }

    public static LatLonPoint m16931f(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static boolean m16933g(String str) {
        if (str == null || str.equals("") || str.equals("0")) {
            return true;
        }
        return false;
    }

    public static boolean m16935h(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    public static int m16936i(String str) {
        int i = 0;
        if (!(str == null || str.equals("") || str.equals("[]"))) {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable e) {
                C3409d.m16881a(e, "JSONHelper", "str2int");
            }
        }
        return i;
    }

    public static float m16938j(String str) {
        float f = 0.0f;
        if (!(str == null || str.equals("") || str.equals("[]"))) {
            try {
                f = Float.parseFloat(str);
            } catch (Throwable e) {
                C3409d.m16881a(e, "JSONHelper", "str2float");
            }
        }
        return f;
    }

    public static long m16940k(String str) {
        long j = 0;
        if (!(str == null || str.equals("") || str.equals("[]"))) {
            try {
                j = Long.parseLong(str);
            } catch (Throwable e) {
                C3409d.m16881a(e, "JSONHelper", "str2long");
            }
        }
        return j;
    }

    public static boolean m16943l(String str) {
        if (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) {
            return false;
        }
        return true;
    }
}
