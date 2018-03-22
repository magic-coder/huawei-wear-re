package com.autonavi.amap.mapcore;

/* compiled from: VMapDataCache */
class C3525e {
    String f13284a;
    int f13285b;
    int f13286c;
    int f13287d = 0;

    public C3525e(String str, int i) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    this.f13285b = (int) (System.currentTimeMillis() / 1000);
                    this.f13286c = i;
                    this.f13284a = str;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                this.f13284a = null;
            }
        }
    }
}
