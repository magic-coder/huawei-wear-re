package com.huawei.pluginkidwatch.plugin.feature.track.p164a;

import com.huawei.pluginkidwatch.common.entity.model.LocationData;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: TimeComparator */
public class C1818a implements Serializable, Comparator<LocationData> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8684a((LocationData) obj, (LocationData) obj2);
    }

    public int m8684a(LocationData locationData, LocationData locationData2) {
        if (locationData.time > locationData2.time) {
            return 1;
        }
        return -1;
    }
}
