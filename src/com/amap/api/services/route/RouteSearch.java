package com.amap.api.services.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3388a;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3411f;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import com.amap.api.services.core.C3432u;
import com.amap.api.services.core.LatLonPoint;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    private OnRouteSearchListener f12818a;
    private Context f12819b;
    private Handler f12820c = C3428p.m16969a();

    public class BusRouteQuery implements Parcelable, Cloneable {
        public static final Creator<BusRouteQuery> CREATOR = new C3482m();
        private FromAndTo f12803a;
        private int f12804b;
        private String f12805c;
        private int f12806d;

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f12803a = fromAndTo;
            this.f12804b = i;
            this.f12805c = str;
            this.f12806d = i2;
        }

        public FromAndTo getFromAndTo() {
            return this.f12803a;
        }

        public int getMode() {
            return this.f12804b;
        }

        public String getCity() {
            return this.f12805c;
        }

        public int getNightFlag() {
            return this.f12806d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f12803a, i);
            parcel.writeInt(this.f12804b);
            parcel.writeString(this.f12805c);
            parcel.writeInt(this.f12806d);
        }

        public BusRouteQuery(Parcel parcel) {
            this.f12803a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f12804b = parcel.readInt();
            this.f12805c = parcel.readString();
            this.f12806d = parcel.readInt();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f12805c == null ? 0 : this.f12805c.hashCode()) + 31) * 31;
            if (this.f12803a != null) {
                i = this.f12803a.hashCode();
            }
            return ((((hashCode + i) * 31) + this.f12804b) * 31) + this.f12806d;
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
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.f12805c == null) {
                if (busRouteQuery.f12805c != null) {
                    return false;
                }
            } else if (!this.f12805c.equals(busRouteQuery.f12805c)) {
                return false;
            }
            if (this.f12803a == null) {
                if (busRouteQuery.f12803a != null) {
                    return false;
                }
            } else if (!this.f12803a.equals(busRouteQuery.f12803a)) {
                return false;
            }
            if (this.f12804b != busRouteQuery.f12804b) {
                return false;
            }
            if (this.f12806d != busRouteQuery.f12806d) {
                return false;
            }
            return true;
        }

        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "RouteSearch", "BusRouteQueryclone");
            }
            return new BusRouteQuery(this.f12803a, this.f12804b, this.f12805c, this.f12806d);
        }
    }

    public class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Creator<DriveRouteQuery> CREATOR = new C3483n();
        private FromAndTo f12807a;
        private int f12808b;
        private List<LatLonPoint> f12809c;
        private List<List<LatLonPoint>> f12810d;
        private String f12811e;

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f12807a = fromAndTo;
            this.f12808b = i;
            this.f12809c = list;
            this.f12810d = list2;
            this.f12811e = str;
        }

        public FromAndTo getFromAndTo() {
            return this.f12807a;
        }

        public int getMode() {
            return this.f12808b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f12809c;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f12810d;
        }

        public String getAvoidRoad() {
            return this.f12811e;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f12809c == null || this.f12809c.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f12809c.size(); i++) {
                LatLonPoint latLonPoint = (LatLonPoint) this.f12809c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.f12809c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasPassPoint() {
            if (C3409d.m16882a(getPassedPointStr())) {
                return false;
            }
            return true;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f12810d == null || this.f12810d.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f12810d.size(); i++) {
                List list = (List) this.f12810d.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LatLonPoint latLonPoint = (LatLonPoint) list.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.f12810d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidpolygons() {
            if (C3409d.m16882a(getAvoidpolygonsStr())) {
                return false;
            }
            return true;
        }

        public boolean hasAvoidRoad() {
            if (C3409d.m16882a(getAvoidRoad())) {
                return false;
            }
            return true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f12807a, i);
            parcel.writeInt(this.f12808b);
            parcel.writeTypedList(this.f12809c);
            if (this.f12810d == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(this.f12810d.size());
                for (List writeTypedList : this.f12810d) {
                    parcel.writeTypedList(writeTypedList);
                }
            }
            parcel.writeString(this.f12811e);
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f12807a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f12808b = parcel.readInt();
            this.f12809c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f12810d = null;
            } else {
                this.f12810d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.f12810d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f12811e = parcel.readString();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f12807a == null ? 0 : this.f12807a.hashCode()) + (((this.f12810d == null ? 0 : this.f12810d.hashCode()) + (((this.f12811e == null ? 0 : this.f12811e.hashCode()) + 31) * 31)) * 31)) * 31) + this.f12808b) * 31;
            if (this.f12809c != null) {
                i = this.f12809c.hashCode();
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
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            if (this.f12811e == null) {
                if (driveRouteQuery.f12811e != null) {
                    return false;
                }
            } else if (!this.f12811e.equals(driveRouteQuery.f12811e)) {
                return false;
            }
            if (this.f12810d == null) {
                if (driveRouteQuery.f12810d != null) {
                    return false;
                }
            } else if (!this.f12810d.equals(driveRouteQuery.f12810d)) {
                return false;
            }
            if (this.f12807a == null) {
                if (driveRouteQuery.f12807a != null) {
                    return false;
                }
            } else if (!this.f12807a.equals(driveRouteQuery.f12807a)) {
                return false;
            }
            if (this.f12808b != driveRouteQuery.f12808b) {
                return false;
            }
            if (this.f12809c == null) {
                if (driveRouteQuery.f12809c != null) {
                    return false;
                }
                return true;
            } else if (this.f12809c.equals(driveRouteQuery.f12809c)) {
                return true;
            } else {
                return false;
            }
        }

        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            return new DriveRouteQuery(this.f12807a, this.f12808b, this.f12809c, this.f12810d, this.f12811e);
        }
    }

    public class FromAndTo implements Parcelable, Cloneable {
        public static final Creator<FromAndTo> CREATOR = new C3484o();
        private LatLonPoint f12812a;
        private LatLonPoint f12813b;
        private String f12814c;
        private String f12815d;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f12812a = latLonPoint;
            this.f12813b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f12812a;
        }

        public LatLonPoint getTo() {
            return this.f12813b;
        }

        public String getStartPoiID() {
            return this.f12814c;
        }

        public void setStartPoiID(String str) {
            this.f12814c = str;
        }

        public String getDestinationPoiID() {
            return this.f12815d;
        }

        public void setDestinationPoiID(String str) {
            this.f12815d = str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f12812a, i);
            parcel.writeParcelable(this.f12813b, i);
            parcel.writeString(this.f12814c);
            parcel.writeString(this.f12815d);
        }

        public FromAndTo(Parcel parcel) {
            this.f12812a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f12813b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f12814c = parcel.readString();
            this.f12815d = parcel.readString();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f12814c == null ? 0 : this.f12814c.hashCode()) + (((this.f12812a == null ? 0 : this.f12812a.hashCode()) + (((this.f12815d == null ? 0 : this.f12815d.hashCode()) + 31) * 31)) * 31)) * 31;
            if (this.f12813b != null) {
                i = this.f12813b.hashCode();
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
            FromAndTo fromAndTo = (FromAndTo) obj;
            if (this.f12815d == null) {
                if (fromAndTo.f12815d != null) {
                    return false;
                }
            } else if (!this.f12815d.equals(fromAndTo.f12815d)) {
                return false;
            }
            if (this.f12812a == null) {
                if (fromAndTo.f12812a != null) {
                    return false;
                }
            } else if (!this.f12812a.equals(fromAndTo.f12812a)) {
                return false;
            }
            if (this.f12814c == null) {
                if (fromAndTo.f12814c != null) {
                    return false;
                }
            } else if (!this.f12814c.equals(fromAndTo.f12814c)) {
                return false;
            }
            if (this.f12813b == null) {
                if (fromAndTo.f12813b != null) {
                    return false;
                }
                return true;
            } else if (this.f12813b.equals(fromAndTo.f12813b)) {
                return true;
            } else {
                return false;
            }
        }

        public FromAndTo clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f12812a, this.f12813b);
            fromAndTo.setStartPoiID(this.f12814c);
            fromAndTo.setDestinationPoiID(this.f12815d);
            return fromAndTo;
        }
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    public class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Creator<WalkRouteQuery> CREATOR = new C3485p();
        private FromAndTo f12816a;
        private int f12817b;

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.f12816a = fromAndTo;
            this.f12817b = i;
        }

        public FromAndTo getFromAndTo() {
            return this.f12816a;
        }

        public int getMode() {
            return this.f12817b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f12816a, i);
            parcel.writeInt(this.f12817b);
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f12816a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f12817b = parcel.readInt();
        }

        public int hashCode() {
            return (((this.f12816a == null ? 0 : this.f12816a.hashCode()) + 31) * 31) + this.f12817b;
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
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.f12816a == null) {
                if (walkRouteQuery.f12816a != null) {
                    return false;
                }
            } else if (!this.f12816a.equals(walkRouteQuery.f12816a)) {
                return false;
            }
            if (this.f12817b != walkRouteQuery.f12817b) {
                return false;
            }
            return true;
        }

        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (Throwable e) {
                C3409d.m16881a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            return new WalkRouteQuery(this.f12816a, this.f12817b);
        }
    }

    public RouteSearch(Context context) {
        this.f12819b = context.getApplicationContext();
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        this.f12818a = onRouteSearchListener;
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        C3418l.m16960a(this.f12819b);
        WalkRouteQuery clone = walkRouteQuery.clone();
        WalkRouteResult walkRouteResult = (WalkRouteResult) new C3432u(this.f12819b, clone).m16577g();
        if (walkRouteResult != null) {
            walkRouteResult.setWalkQuery(clone);
        }
        return walkRouteResult;
    }

    public void calculateWalkRouteAsyn(final WalkRouteQuery walkRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch f12798b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                obtainMessage.what = 12;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                Parcelable parcelable = null;
                try {
                    parcelable = this.f12798b.calculateWalkRoute(walkRouteQuery);
                    bundle.putInt(Constant.KEY_ERROR_CODE, 0);
                    obtainMessage.obj = this.f12798b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12798b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable e) {
                    C3409d.m16881a(e, "RouteSearch", "calculateWalkRouteAsyn");
                    bundle.putInt(Constant.KEY_ERROR_CODE, e.getErrorCode());
                    obtainMessage.obj = this.f12798b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12798b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    obtainMessage.obj = this.f12798b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12798b.f12820c.sendMessage(obtainMessage);
                }
            }
        }.start();
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        C3418l.m16960a(this.f12819b);
        BusRouteQuery clone = busRouteQuery.clone();
        BusRouteResult busRouteResult = (BusRouteResult) new C3388a(this.f12819b, clone).m16577g();
        if (busRouteResult != null) {
            busRouteResult.setBusQuery(clone);
        }
        return busRouteResult;
    }

    public void calculateBusRouteAsyn(final BusRouteQuery busRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch f12800b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                Parcelable parcelable = null;
                try {
                    parcelable = this.f12800b.calculateBusRoute(busRouteQuery);
                    bundle.putInt(Constant.KEY_ERROR_CODE, 0);
                    obtainMessage.obj = this.f12800b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12800b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable e) {
                    C3409d.m16881a(e, "RouteSearch", "calculateBusRouteAsyn");
                    bundle.putInt(Constant.KEY_ERROR_CODE, e.getErrorCode());
                    obtainMessage.obj = this.f12800b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12800b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    obtainMessage.obj = this.f12800b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12800b.f12820c.sendMessage(obtainMessage);
                }
            }
        }.start();
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        C3418l.m16960a(this.f12819b);
        DriveRouteQuery clone = driveRouteQuery.clone();
        DriveRouteResult driveRouteResult = (DriveRouteResult) new C3411f(this.f12819b, clone).m16577g();
        if (driveRouteResult != null) {
            driveRouteResult.setDriveQuery(clone);
        }
        return driveRouteResult;
    }

    public void calculateDriveRouteAsyn(final DriveRouteQuery driveRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch f12802b;

            public void run() {
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                obtainMessage.what = 11;
                obtainMessage.arg1 = 1;
                Bundle bundle = new Bundle();
                Parcelable parcelable = null;
                try {
                    parcelable = this.f12802b.calculateDriveRoute(driveRouteQuery);
                    bundle.putInt(Constant.KEY_ERROR_CODE, 0);
                    obtainMessage.obj = this.f12802b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12802b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable e) {
                    C3409d.m16881a(e, "RouteSearch", "calculateDriveRouteAsyn");
                    bundle.putInt(Constant.KEY_ERROR_CODE, e.getErrorCode());
                    obtainMessage.obj = this.f12802b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12802b.f12820c.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    obtainMessage.obj = this.f12802b.f12818a;
                    bundle.putParcelable("result", parcelable);
                    obtainMessage.setData(bundle);
                    this.f12802b.f12820c.sendMessage(obtainMessage);
                }
            }
        }.start();
    }
}
