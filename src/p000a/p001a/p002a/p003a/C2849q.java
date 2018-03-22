package p000a.p001a.p002a.p003a;

import android.os.Bundle;
import p000a.p001a.p002a.p003a.C2848p.C2843a;

/* compiled from: RemoteInputCompatJellybean */
class C2849q {
    static Bundle m12940a(C2843a c2843a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c2843a.mo3337a());
        bundle.putCharSequence("label", c2843a.mo3338b());
        bundle.putCharSequenceArray("choices", c2843a.mo3339c());
        bundle.putBoolean("allowFreeFormInput", c2843a.mo3340d());
        bundle.putBundle("extras", c2843a.mo3341e());
        return bundle;
    }

    static Bundle[] m12941a(C2843a[] c2843aArr) {
        if (c2843aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c2843aArr.length];
        for (int i = 0; i < c2843aArr.length; i++) {
            bundleArr[i] = C2849q.m12940a(c2843aArr[i]);
        }
        return bundleArr;
    }
}
