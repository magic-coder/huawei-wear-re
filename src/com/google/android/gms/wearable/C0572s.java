package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import java.util.ArrayList;
import java.util.List;

public class C0572s {
    private final Uri f1078a;
    private final C0571r f1079b;

    private C0572s(C0558p c0558p) {
        this.f1078a = c0558p.getUri();
        this.f1079b = m2256b((C0558p) c0558p.freeze());
    }

    public static C0572s m2255a(C0558p c0558p) {
        if (c0558p != null) {
            return new C0572s(c0558p);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    private C0571r m2256b(C0558p c0558p) {
        Throwable e;
        if (c0558p.getData() == null && c0558p.getAssets().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (c0558p.getData() == null) {
            return new C0571r();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = c0558p.getAssets().size();
                for (int i = 0; i < size; i++) {
                    C0531q c0531q = (C0531q) c0558p.getAssets().get(Integer.toString(i));
                    if (c0531q == null) {
                        String valueOf = String.valueOf(c0558p);
                        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 64).append("Cannot find DataItemAsset referenced in data at ").append(i).append(" for ").append(valueOf).toString());
                    }
                    arrayList.add(Asset.createFromRef(c0531q.getId()));
                }
                return eb.m1274a(new ec(ed.m1294a(c0558p.getData()), arrayList));
            } catch (ep e2) {
                e = e2;
            } catch (NullPointerException e3) {
                e = e3;
            }
        }
        valueOf = String.valueOf(c0558p.getUri());
        String valueOf2 = String.valueOf(Base64.encodeToString(c0558p.getData(), 0));
        Log.w("DataItem", new StringBuilder((String.valueOf(valueOf).length() + 50) + String.valueOf(valueOf2).length()).append("Unable to parse datamap from dataItem. uri=").append(valueOf).append(", data=").append(valueOf2).toString());
        valueOf2 = String.valueOf(c0558p.getUri());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 44).append("Unable to parse datamap from dataItem.  uri=").append(valueOf2).toString(), e);
    }

    public C0571r m2257a() {
        return this.f1079b;
    }
}
