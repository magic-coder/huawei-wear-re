package com.amap.api.services.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips.InputtipsListener;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch.OnRouteSearchListener;
import com.amap.api.services.route.WalkRouteResult;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;

/* compiled from: MessageHandler */
public class C3428p extends Handler {
    private static C3428p f12507a;

    /* compiled from: MessageHandler */
    public class C3422a {
        public BusLineResult f12495a;
        public OnBusLineSearchListener f12496b;
    }

    /* compiled from: MessageHandler */
    public class C3423b {
        public BusStationResult f12497a;
        public OnBusStationSearchListener f12498b;
    }

    /* compiled from: MessageHandler */
    public class C3424c {
        public GeocodeResult f12499a;
        public OnGeocodeSearchListener f12500b;
    }

    /* compiled from: MessageHandler */
    public class C3425d {
        public PoiItemDetail f12501a;
        public OnPoiSearchListener f12502b;
    }

    /* compiled from: MessageHandler */
    public class C3426e {
        public PoiResult f12503a;
        public OnPoiSearchListener f12504b;
    }

    /* compiled from: MessageHandler */
    public class C3427f {
        public RegeocodeResult f12505a;
        public OnGeocodeSearchListener f12506b;
    }

    public static synchronized C3428p m16969a() {
        C3428p c3428p;
        synchronized (C3428p.class) {
            if (f12507a == null) {
                if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                    f12507a = new C3428p(Looper.getMainLooper());
                } else {
                    f12507a = new C3428p();
                }
            }
            c3428p = f12507a;
        }
        return c3428p;
    }

    C3428p() {
    }

    C3428p(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            switch (message.arg1) {
                case 1:
                    m16976g(message);
                    return;
                case 2:
                    m16973d(message);
                    return;
                case 3:
                    m16975f(message);
                    return;
                case 4:
                    m16974e(message);
                    return;
                case 5:
                    m16972c(message);
                    return;
                case 6:
                    m16971b(message);
                    return;
                case 7:
                    m16970a(message);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            C3409d.m16881a(th, "MessageHandler", "handleMessage");
        }
        C3409d.m16881a(th, "MessageHandler", "handleMessage");
    }

    private void m16970a(Message message) {
        C3423b c3423b = (C3423b) message.obj;
        if (c3423b != null) {
            OnBusStationSearchListener onBusStationSearchListener = c3423b.f12498b;
            if (onBusStationSearchListener != null) {
                BusStationResult busStationResult;
                if (message.what == 0) {
                    busStationResult = c3423b.f12497a;
                } else {
                    busStationResult = null;
                }
                onBusStationSearchListener.onBusStationSearched(busStationResult, message.what);
            }
        }
    }

    private void m16971b(Message message) {
        OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        if (message.what == 60) {
            C3426e c3426e = (C3426e) message.obj;
            if (c3426e != null) {
                onPoiSearchListener = c3426e.f12504b;
                if (onPoiSearchListener != null) {
                    data = message.getData();
                    if (data != null) {
                        onPoiSearchListener.onPoiSearched(c3426e.f12503a, data.getInt(Constant.KEY_ERROR_CODE));
                    }
                }
            }
        } else if (message.what == 61) {
            C3425d c3425d = (C3425d) message.obj;
            if (c3425d != null) {
                onPoiSearchListener = c3425d.f12502b;
                data = message.getData();
                if (data != null) {
                    onPoiSearchListener.onPoiItemDetailSearched(c3425d.f12501a, data.getInt(Constant.KEY_ERROR_CODE));
                }
            }
        }
    }

    private void m16972c(Message message) {
        InputtipsListener inputtipsListener = (InputtipsListener) message.obj;
        if (inputtipsListener != null) {
            List list = null;
            if (message.what == 0) {
                list = message.getData().getParcelableArrayList("result");
            }
            inputtipsListener.onGetInputtips(list, message.what);
        }
    }

    private void m16973d(Message message) {
        OnGeocodeSearchListener onGeocodeSearchListener;
        if (message.what == 21) {
            C3427f c3427f = (C3427f) message.obj;
            if (c3427f != null) {
                onGeocodeSearchListener = c3427f.f12506b;
                if (onGeocodeSearchListener != null) {
                    onGeocodeSearchListener.onRegeocodeSearched(c3427f.f12505a, message.arg2);
                }
            }
        } else if (message.what == 20) {
            C3424c c3424c = (C3424c) message.obj;
            if (c3424c != null) {
                onGeocodeSearchListener = c3424c.f12500b;
                if (onGeocodeSearchListener != null) {
                    onGeocodeSearchListener.onGeocodeSearched(c3424c.f12499a, message.arg2);
                }
            }
        }
    }

    private void m16974e(Message message) {
        OnDistrictSearchListener onDistrictSearchListener = (OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener != null) {
            onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
        }
    }

    private void m16975f(Message message) {
        C3422a c3422a = (C3422a) message.obj;
        if (c3422a != null) {
            OnBusLineSearchListener onBusLineSearchListener = c3422a.f12496b;
            if (onBusLineSearchListener != null) {
                BusLineResult busLineResult;
                if (message.what == 0) {
                    busLineResult = c3422a.f12495a;
                } else {
                    busLineResult = null;
                }
                onBusLineSearchListener.onBusLineSearched(busLineResult, message.what);
            }
        }
    }

    private void m16976g(Message message) {
        OnRouteSearchListener onRouteSearchListener = (OnRouteSearchListener) message.obj;
        if (onRouteSearchListener != null) {
            Bundle data;
            if (message.what == 10) {
                data = message.getData();
                if (data != null) {
                    onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data.getInt(Constant.KEY_ERROR_CODE));
                }
            } else if (message.what == 11) {
                data = message.getData();
                if (data != null) {
                    onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data.getInt(Constant.KEY_ERROR_CODE));
                }
            } else if (message.what == 12) {
                data = message.getData();
                if (data != null) {
                    onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data.getInt(Constant.KEY_ERROR_CODE));
                }
            }
        }
    }
}
