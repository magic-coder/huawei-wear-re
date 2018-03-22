package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0434r;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0520b;
import com.google.android.gms.wearable.C0521h;
import com.google.android.gms.wearable.C0522l;
import com.google.android.gms.wearable.C0523u;
import com.google.android.gms.wearable.C0525c;
import com.google.android.gms.wearable.C0527e;
import com.google.android.gms.wearable.C0528f;
import com.google.android.gms.wearable.C0535v;
import com.google.android.gms.wearable.C0538z;
import com.google.android.gms.wearable.C0548k;
import com.google.android.gms.wearable.C0550m;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.aa;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ch extends ae<as> {
    private final ExecutorService f979e;
    private final av<Object> f980f;
    private final av<Object> f981g;
    private final av<C0521h> f982h;
    private final av<C0522l> f983i;
    private final av<C0523u> f984j;
    private final av<aa> f985k;
    private final av<Object> f986l;
    private final av<C0520b> f987m;
    private final cs f988n;

    public ch(Context context, Looper looper, C0380r c0380r, C0381s c0381s, C0443x c0443x) {
        this(context, looper, c0380r, c0381s, c0443x, Executors.newCachedThreadPool(), cs.m2090a(context));
    }

    ch(Context context, Looper looper, C0380r c0380r, C0381s c0381s, C0443x c0443x, ExecutorService executorService, cs csVar) {
        super(context, looper, 14, c0443x, c0380r, c0381s);
        this.f980f = new av();
        this.f981g = new av();
        this.f982h = new av();
        this.f983i = new av();
        this.f984j = new av();
        this.f985k = new av();
        this.f986l = new av();
        this.f987m = new av();
        this.f979e = (ExecutorService) C0424f.m649a((Object) executorService);
        this.f988n = csVar;
    }

    public static Intent m2023a(Context context) {
        Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage(NFCBaseActivity.AW_NAME_CN);
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            return intent;
        }
        return new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", NFCBaseActivity.AW_NAME_CN).build());
    }

    private FutureTask<Boolean> m2024a(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        return new FutureTask(new ci(this, parcelFileDescriptor, bArr));
    }

    private Runnable m2025b(C0502h<Status> c0502h, String str, Uri uri, long j, long j2) {
        C0424f.m649a((Object) c0502h);
        C0424f.m649a((Object) str);
        C0424f.m649a((Object) uri);
        C0424f.m659b(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        C0424f.m659b(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        return new ck(this, uri, c0502h, str, j, j2);
    }

    private Runnable m2026b(C0502h<Status> c0502h, String str, Uri uri, boolean z) {
        C0424f.m649a((Object) c0502h);
        C0424f.m649a((Object) str);
        C0424f.m649a((Object) uri);
        return new cj(this, uri, c0502h, z, str);
    }

    protected /* synthetic */ IInterface mo1772a(IBinder iBinder) {
        return m2042b(iBinder);
    }

    protected void mo2009a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.f980f.m1940a(iBinder);
            this.f981g.m1940a(iBinder);
            this.f982h.m1940a(iBinder);
            this.f983i.m1940a(iBinder);
            this.f984j.m1940a(iBinder);
            this.f985k.m1940a(iBinder);
            this.f986l.m1940a(iBinder);
            this.f987m.m1940a(iBinder);
        }
        super.mo2009a(i, iBinder, bundle, i2);
    }

    public void mo2010a(@NonNull C0434r c0434r) {
        int i = 0;
        if (!mo2011e()) {
            try {
                Bundle bundle = m560n().getPackageManager().getApplicationInfo(NFCBaseActivity.AW_NAME_CN, 128).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 0);
                }
                if (i < C0388h.f305b) {
                    Log.w("WearableClient", "Android Wear out of date. Requires API version " + C0388h.f305b + " but found " + i);
                    m547a(c0434r, 6, PendingIntent.getActivity(m560n(), 0, m2023a(m560n()), 0));
                    return;
                }
            } catch (NameNotFoundException e) {
                m547a(c0434r, 16, null);
                return;
            }
        }
        super.mo2010a(c0434r);
    }

    public void m2030a(C0502h<C0538z> c0502h) throws RemoteException {
        ((as) m567u()).mo1985d(new ca(c0502h));
    }

    public void m2031a(C0502h<C0550m> c0502h, Asset asset) throws RemoteException {
        ((as) m567u()).mo1958a(new cb(c0502h), asset);
    }

    public void m2032a(C0502h<C0548k> c0502h, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                String valueOf = String.valueOf(putDataRequest.getUri());
                String valueOf2 = String.valueOf(asset);
                throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 33) + String.valueOf(valueOf2).length()).append("Put for ").append(valueOf).append(" contains invalid asset: ").append(valueOf2).toString());
            }
        }
        PutDataRequest zzy = PutDataRequest.zzy(putDataRequest.getUri());
        zzy.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            zzy.setUrgent();
        }
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf3 = String.valueOf(asset2);
                        String valueOf4 = String.valueOf(createPipe[0]);
                        String valueOf5 = String.valueOf(createPipe[1]);
                        Log.d("WearableClient", new StringBuilder(((String.valueOf(valueOf3).length() + 61) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()).append("processAssets: replacing data with FD in asset: ").append(valueOf3).append(" read:").append(valueOf4).append(" write:").append(valueOf5).toString());
                    }
                    zzy.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable a = m2024a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.f979e.submit(a);
                } catch (Throwable e) {
                    valueOf = String.valueOf(putDataRequest);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 60).append("Unable to create ParcelFileDescriptor for asset in request: ").append(valueOf).toString(), e);
                }
            } else if (asset2.getUri() != null) {
                try {
                    zzy.putAsset((String) value2.getKey(), Asset.createFromFd(m560n().getContentResolver().openFileDescriptor(asset2.getUri(), "r")));
                } catch (FileNotFoundException e2) {
                    new cd(c0502h, arrayList).mo1945a(new zzci(4005, null));
                    String valueOf6 = String.valueOf(asset2.getUri());
                    Log.w("WearableClient", new StringBuilder(String.valueOf(valueOf6).length() + 28).append("Couldn't resolve asset URI: ").append(valueOf6).toString());
                    return;
                }
            } else {
                zzy.putAsset((String) value2.getKey(), asset2);
            }
        }
        ((as) m567u()).mo1960a(new cd(c0502h, arrayList), zzy);
    }

    public void m2033a(C0502h<Status> c0502h, aa aaVar) throws RemoteException {
        this.f985k.m1941a(this, c0502h, aaVar);
    }

    public void m2034a(C0502h<Status> c0502h, aa aaVar, zzabh<aa> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa, IntentFilter[] intentFilterArr) throws RemoteException {
        this.f985k.m1942a(this, c0502h, aaVar, cl.m2051a(com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa, intentFilterArr));
    }

    public void m2035a(C0502h<Status> c0502h, C0521h c0521h, zzabh<C0521h> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.f982h.m1942a(this, c0502h, c0521h, cl.m2057b(com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, intentFilterArr));
            return;
        }
        this.f982h.m1942a(this, c0502h, new bo(str, c0521h), cl.m2050a(com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, str, intentFilterArr));
    }

    public void m2036a(C0502h<Status> c0502h, C0521h c0521h, String str) throws RemoteException {
        if (str == null) {
            this.f982h.m1941a(this, c0502h, c0521h);
            return;
        }
        this.f982h.m1941a(this, c0502h, new bo(str, c0521h));
    }

    public void m2037a(C0502h<Status> c0502h, String str) throws RemoteException {
        ((as) m567u()).mo1990f(new bv(c0502h), str);
    }

    public void m2038a(C0502h<C0525c> c0502h, String str, int i) throws RemoteException {
        ((as) m567u()).mo1966a(new bx(c0502h), str, i);
    }

    public void m2039a(C0502h<Status> c0502h, String str, Uri uri, long j, long j2) {
        try {
            this.f979e.execute(m2025b(c0502h, str, uri, j, j2));
        } catch (RuntimeException e) {
            c0502h.mo1880a(new Status(8));
            throw e;
        }
    }

    public void m2040a(C0502h<Status> c0502h, String str, Uri uri, boolean z) {
        try {
            this.f979e.execute(m2026b(c0502h, str, uri, z));
        } catch (RuntimeException e) {
            c0502h.mo1880a(new Status(8));
            throw e;
        }
    }

    public void m2041a(C0502h<C0535v> c0502h, String str, String str2, byte[] bArr) throws RemoteException {
        ((as) m567u()).mo1970a(new cf(c0502h), str, str2, bArr);
    }

    protected as m2042b(IBinder iBinder) {
        return at.m1891a(iBinder);
    }

    public void m2043b(C0502h<C0527e> c0502h, String str) throws RemoteException {
        aj c0539c = new C0539c();
        ((as) m567u()).mo1961a(new by(c0502h, c0539c), c0539c, str);
    }

    public void m2044b(C0502h<Status> c0502h, String str, int i) throws RemoteException {
        ((as) m567u()).mo1979b(new bw(c0502h), str, i);
    }

    public void m2045c(C0502h<C0528f> c0502h, String str) throws RemoteException {
        aj c0539c = new C0539c();
        ((as) m567u()).mo1977b(new bz(c0502h, c0539c), c0539c, str);
    }

    public boolean mo2011e() {
        return !this.f988n.m2095a(NFCBaseActivity.AW_NAME_CN);
    }

    protected String f_() {
        return this.f988n.m2095a(NFCBaseActivity.AW_NAME_CN) ? NFCBaseActivity.AW_NAME_CN : "com.google.android.gms";
    }

    protected String mo1773i() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String mo1774j() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
