package com.google.zxing.p276a;

import com.google.zxing.C3707k;
import com.google.zxing.C3709a;
import com.google.zxing.C3740c;
import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p276a.p277a.C3701a;
import com.google.zxing.p276a.p279b.C3705a;
import com.google.zxing.p278b.C3720e;
import java.util.List;
import java.util.Map;

/* compiled from: AztecReader */
public final class C3708b implements C3707k {
    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3900f {
        C3704a a;
        C3922o[] e;
        C3720e a2;
        C3932i c3932i;
        C3932i e2;
        C3720e c3720e;
        C3922o[] c3922oArr;
        C3900f e3;
        C3803p c3803p;
        C3934m c3934m;
        List c;
        String d;
        C3900f c3900f;
        C3900f c3900f2 = null;
        C3705a c3705a = new C3705a(c3740c.m18821c());
        try {
            a = c3705a.m18660a(false);
            e = a.m18639e();
            try {
                a2 = new C3701a().m18636a(a);
                c3932i = null;
            } catch (C3932i e4) {
                e2 = e4;
                c3932i = e2;
                a2 = null;
                if (a2 == null) {
                    c3720e = a2;
                    c3922oArr = e;
                } else {
                    try {
                        a = c3705a.m18660a(true);
                        c3720e = new C3701a().m18636a(a);
                        c3922oArr = a.m18639e();
                    } catch (C3932i e22) {
                        if (c3932i != null) {
                            throw c3932i;
                        } else if (c3900f2 != null) {
                            throw c3900f2;
                        } else {
                            throw e22;
                        }
                    } catch (C3900f e32) {
                        if (c3932i != null) {
                            throw c3932i;
                        } else if (c3900f2 != null) {
                            throw c3900f2;
                        } else {
                            throw e32;
                        }
                    }
                }
                if (map != null) {
                    c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
                    if (c3803p != null) {
                        for (C3922o a3 : c3922oArr) {
                            c3803p.mo4312a(a3);
                        }
                    }
                }
                c3934m = new C3934m(c3720e.m18729b(), c3720e.m18728a(), c3922oArr, C3709a.AZTEC);
                c = c3720e.m18731c();
                if (c != null) {
                    c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
                }
                d = c3720e.m18732d();
                if (d != null) {
                    c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
                }
                return c3934m;
            } catch (C3900f e5) {
                e32 = e5;
                c3932i = null;
                c3900f = e32;
                a2 = null;
                c3900f2 = c3900f;
                if (a2 == null) {
                    a = c3705a.m18660a(true);
                    c3720e = new C3701a().m18636a(a);
                    c3922oArr = a.m18639e();
                } else {
                    c3720e = a2;
                    c3922oArr = e;
                }
                if (map != null) {
                    c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
                    if (c3803p != null) {
                        while (r1 < r5) {
                            c3803p.mo4312a(a3);
                        }
                    }
                }
                c3934m = new C3934m(c3720e.m18729b(), c3720e.m18728a(), c3922oArr, C3709a.AZTEC);
                c = c3720e.m18731c();
                if (c != null) {
                    c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
                }
                d = c3720e.m18732d();
                if (d != null) {
                    c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
                }
                return c3934m;
            }
        } catch (C3932i e6) {
            e22 = e6;
            e = null;
            c3932i = e22;
            a2 = null;
            if (a2 == null) {
                c3720e = a2;
                c3922oArr = e;
            } else {
                a = c3705a.m18660a(true);
                c3720e = new C3701a().m18636a(a);
                c3922oArr = a.m18639e();
            }
            if (map != null) {
                c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
                if (c3803p != null) {
                    while (r1 < r5) {
                        c3803p.mo4312a(a3);
                    }
                }
            }
            c3934m = new C3934m(c3720e.m18729b(), c3720e.m18728a(), c3922oArr, C3709a.AZTEC);
            c = c3720e.m18731c();
            if (c != null) {
                c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
            }
            d = c3720e.m18732d();
            if (d != null) {
                c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
            }
            return c3934m;
        } catch (C3900f e7) {
            e32 = e7;
            e = null;
            c3932i = null;
            c3900f = e32;
            a2 = null;
            c3900f2 = c3900f;
            if (a2 == null) {
                a = c3705a.m18660a(true);
                c3720e = new C3701a().m18636a(a);
                c3922oArr = a.m18639e();
            } else {
                c3720e = a2;
                c3922oArr = e;
            }
            if (map != null) {
                c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
                if (c3803p != null) {
                    while (r1 < r5) {
                        c3803p.mo4312a(a3);
                    }
                }
            }
            c3934m = new C3934m(c3720e.m18729b(), c3720e.m18728a(), c3922oArr, C3709a.AZTEC);
            c = c3720e.m18731c();
            if (c != null) {
                c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
            }
            d = c3720e.m18732d();
            if (d != null) {
                c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
            }
            return c3934m;
        }
        if (a2 == null) {
            a = c3705a.m18660a(true);
            c3720e = new C3701a().m18636a(a);
            c3922oArr = a.m18639e();
        } else {
            c3720e = a2;
            c3922oArr = e;
        }
        if (map != null) {
            c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
            if (c3803p != null) {
                while (r1 < r5) {
                    c3803p.mo4312a(a3);
                }
            }
        }
        c3934m = new C3934m(c3720e.m18729b(), c3720e.m18728a(), c3922oArr, C3709a.AZTEC);
        c = c3720e.m18731c();
        if (c != null) {
            c3934m.m19573a(C3935n.BYTE_SEGMENTS, c);
        }
        d = c3720e.m18732d();
        if (d != null) {
            c3934m.m19573a(C3935n.ERROR_CORRECTION_LEVEL, d);
        }
        return c3934m;
    }

    public void mo4302a() {
    }
}
