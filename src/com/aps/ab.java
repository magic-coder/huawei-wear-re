package com.aps;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.CellLocation;
import java.util.List;

public final class ab {
    private static int f12846c = 10;
    private static int f12847d = 100;
    private static float f12848f = 0.5f;
    protected ak f12849a = new ak(this);
    protected ah f12850b = new ah(this);
    private C3505o f12851e;

    protected ab(C3505o c3505o) {
        this.f12851e = c3505o;
    }

    protected static void m17181a() {
    }

    protected static void m17182a(int i) {
        f12846c = i;
    }

    protected static void m17183b(int i) {
        f12847d = i;
    }

    protected final boolean m17184a(Location location) {
        boolean z = false;
        if (this.f12851e != null) {
            List j = this.f12851e.m17614j();
            if (!(j == null || location == null)) {
                "cell.list.size: " + j.size();
                ai aiVar = null;
                if (j.size() >= 2) {
                    ai aiVar2 = new ai((CellLocation) j.get(1));
                    if (this.f12850b.f12895b == null) {
                        aiVar = aiVar2;
                        z = true;
                    } else {
                        boolean z2 = location.distanceTo(this.f12850b.f12895b) > ((float) f12847d);
                        if (!z2) {
                            int i;
                            aiVar = this.f12850b.f12894a;
                            if (aiVar2.f12900e == aiVar.f12900e && aiVar2.f12899d == aiVar.f12899d && aiVar2.f12898c == aiVar.f12898c && aiVar2.f12897b == aiVar.f12897b && aiVar2.f12896a == aiVar.f12896a) {
                                i = 1;
                            } else {
                                z2 = false;
                            }
                            z2 = i == 0;
                        }
                        "collect cell?: " + z2;
                        z = z2;
                        aiVar = aiVar2;
                    }
                }
                if (z) {
                    this.f12850b.f12894a = aiVar;
                }
            }
        }
        return z;
    }

    protected final boolean m17185b(Location location) {
        int i = 0;
        if (this.f12851e == null) {
            return false;
        }
        boolean z;
        List list;
        List k = this.f12851e.m17615k();
        if (k.size() >= 2) {
            List list2 = (List) k.get(1);
            if (this.f12849a.f12903b == null) {
                z = true;
            } else if (list2 == null || list2.size() <= 0) {
                list = list2;
                z = false;
            } else {
                z = location.distanceTo(this.f12849a.f12903b) > ((float) f12846c);
                if (z) {
                    list = list2;
                } else {
                    int i2;
                    List list3 = this.f12849a.f12902a;
                    float f = f12848f;
                    if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else {
                        int size = list2.size();
                        int size2 = list3.size();
                        float f2 = (float) (size + size2);
                        if (size == 0 && size2 == 0) {
                            i2 = 1;
                        } else if (size == 0 || size2 == 0) {
                            i2 = 0;
                        } else {
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < size) {
                                String str = ((ScanResult) list2.get(i3)).BSSID;
                                if (str != null) {
                                    for (int i5 = 0; i5 < size2; i5++) {
                                        if (str.equals(((aj) list3.get(i5)).f12901a)) {
                                            i2 = i4 + 1;
                                            break;
                                        }
                                    }
                                }
                                i2 = i4;
                                i3++;
                                i4 = i2;
                            }
                            i2 = ((float) (i4 << 1)) >= f2 * f ? 1 : 0;
                        }
                    }
                    z = i2 == 0;
                }
            }
            list = list2;
        } else {
            list = null;
            z = false;
        }
        if (z) {
            this.f12849a.f12902a.clear();
            int size3 = list.size();
            while (i < size3) {
                this.f12849a.f12902a.add(new aj(((ScanResult) list.get(i)).BSSID));
                i++;
            }
        }
        return z;
    }
}
