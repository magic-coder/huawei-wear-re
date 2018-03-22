package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.graphics.BitmapFactory.Options;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: BitmapManager */
class C1544e {
    public C1542c f3698a;
    public Options f3699b;

    private C1544e() {
        this.f3698a = C1542c.ALLOW;
    }

    public String toString() {
        String str;
        if (this.f3698a == C1542c.CANCEL) {
            str = "Cancel";
        } else if (this.f3698a == C1542c.ALLOW) {
            str = "Allow";
        } else {
            str = LocationInfo.NA;
        }
        return "thread state = " + str + ", options = " + this.f3699b;
    }
}
