package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.common.entity.model.PositioningFrequency;
import java.util.Comparator;

/* compiled from: CustomLocationActivity */
final class cx implements Comparator<PositioningFrequency> {
    cx() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9594a((PositioningFrequency) obj, (PositioningFrequency) obj2);
    }

    public int m9594a(PositioningFrequency positioningFrequency, PositioningFrequency positioningFrequency2) {
        if (positioningFrequency.startTime == null) {
            return 0;
        }
        return positioningFrequency.startTime.compareTo(positioningFrequency2.startTime);
    }
}
