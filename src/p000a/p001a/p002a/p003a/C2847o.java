package p000a.p001a.p002a.p003a;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import p000a.p001a.p002a.p003a.C2848p.C2843a;

/* compiled from: RemoteInputCompatApi20 */
class C2847o {
    static RemoteInput[] m12939a(C2843a[] c2843aArr) {
        if (c2843aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c2843aArr.length];
        for (int i = 0; i < c2843aArr.length; i++) {
            C2843a c2843a = c2843aArr[i];
            remoteInputArr[i] = new Builder(c2843a.mo3337a()).setLabel(c2843a.mo3338b()).setChoices(c2843a.mo3339c()).setAllowFreeFormInput(c2843a.mo3340d()).addExtras(c2843a.mo3341e()).build();
        }
        return remoteInputArr;
    }
}
