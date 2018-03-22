package com.google.zxing.client.android.p286a;

import android.hardware.Camera.Size;
import java.util.Comparator;

/* compiled from: CameraConfigurationManager */
class C3774d implements Comparator<Size> {
    final /* synthetic */ C3773c f14694a;

    C3774d(C3773c c3773c) {
        this.f14694a = c3773c;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m18987a((Size) obj, (Size) obj2);
    }

    public int m18987a(Size size, Size size2) {
        int i = size.height * size.width;
        int i2 = size2.height * size2.width;
        if (i2 < i) {
            return -1;
        }
        if (i2 > i) {
            return 1;
        }
        return 0;
    }
}
