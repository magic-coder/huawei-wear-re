package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
    public static final Creator<WalkPath> CREATOR = new C3488s();
    private List<WalkStep> f12794a = new ArrayList();

    public List<WalkStep> getSteps() {
        return this.f12794a;
    }

    public void setSteps(List<WalkStep> list) {
        this.f12794a = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f12794a);
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f12794a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }
}
