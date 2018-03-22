package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.common.util.C0457b;
import com.google.android.gms.common.util.C0458c;
import com.google.android.gms.common.util.C0465j;
import com.google.android.gms.common.util.C0466k;
import com.google.android.gms.internal.zzacs.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacz extends zzact {
    public static final Creator<zzacz> CREATOR = new ct();
    private final String mClassName;
    private final zzacw zzaHf;
    private final Parcel zzaHm;
    private final int zzaHn = 2;
    private int zzaHo;
    private int zzaHp;
    private final int zzaiI;

    zzacz(int i, Parcel parcel, zzacw com_google_android_gms_internal_zzacw) {
        this.zzaiI = i;
        this.zzaHm = (Parcel) C0424f.m649a((Object) parcel);
        this.zzaHf = com_google_android_gms_internal_zzacw;
        if (this.zzaHf == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzaHf.zzyF();
        }
        this.zzaHo = 2;
    }

    private static SparseArray<Entry<String, zza<?, ?>>> zzY(Map<String, zza<?, ?>> map) {
        SparseArray<Entry<String, zza<?, ?>>> sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            sparseArray.put(((zza) entry.getValue()).zzyx(), entry);
        }
        return sparseArray;
    }

    private void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(C0465j.m823a(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(C0458c.m810a((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(C0458c.m811b((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                C0466k.m824a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        switch (com_google_android_gms_internal_zzacs_zza___.zzyu()) {
            case 0:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, Integer.valueOf(C0436a.m706e(parcel, i))));
                return;
            case 1:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, C0436a.m709h(parcel, i)));
                return;
            case 2:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, Long.valueOf(C0436a.m708g(parcel, i))));
                return;
            case 3:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, Float.valueOf(C0436a.m710i(parcel, i))));
                return;
            case 4:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, Double.valueOf(C0436a.m711j(parcel, i))));
                return;
            case 5:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, C0436a.m712k(parcel, i)));
                return;
            case 6:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, Boolean.valueOf(C0436a.m704c(parcel, i))));
                return;
            case 7:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, C0436a.m713l(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, C0436a.m716o(parcel, i)));
                return;
            case 10:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, zza(com_google_android_gms_internal_zzacs_zza___, zzr(C0436a.m715n(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + com_google_android_gms_internal_zzacs_zza___.zzyu());
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (com_google_android_gms_internal_zzacs_zza___.zzyA()) {
            zza(stringBuilder, com_google_android_gms_internal_zzacs_zza___, parcel, i);
        } else {
            zzb(stringBuilder, com_google_android_gms_internal_zzacs_zza___, parcel, i);
        }
    }

    private void zza(StringBuilder stringBuilder, Map<String, zza<?, ?>> map, Parcel parcel) {
        SparseArray zzY = zzY(map);
        stringBuilder.append('{');
        int b = C0436a.m700b(parcel);
        Object obj = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            Entry entry = (Entry) zzY.get(C0436a.m694a(a));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, (String) entry.getKey(), (zza) entry.getValue(), parcel, a);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C0437b("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        if (com_google_android_gms_internal_zzacs_zza___.zzyv()) {
            stringBuilder.append("[");
            switch (com_google_android_gms_internal_zzacs_zza___.zzyu()) {
                case 0:
                    C0457b.m805a(stringBuilder, C0436a.m718q(parcel, i));
                    break;
                case 1:
                    C0457b.m807a(stringBuilder, C0436a.m720s(parcel, i));
                    break;
                case 2:
                    C0457b.m806a(stringBuilder, C0436a.m719r(parcel, i));
                    break;
                case 3:
                    C0457b.m804a(stringBuilder, C0436a.m721t(parcel, i));
                    break;
                case 4:
                    C0457b.m803a(stringBuilder, C0436a.m722u(parcel, i));
                    break;
                case 5:
                    C0457b.m807a(stringBuilder, C0436a.m723v(parcel, i));
                    break;
                case 6:
                    C0457b.m809a(stringBuilder, C0436a.m717p(parcel, i));
                    break;
                case 7:
                    C0457b.m808a(stringBuilder, C0436a.m724w(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] z = C0436a.m727z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        z[i2].setDataPosition(0);
                        zza(stringBuilder, com_google_android_gms_internal_zzacs_zza___.zzyC(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (com_google_android_gms_internal_zzacs_zza___.zzyu()) {
            case 0:
                stringBuilder.append(C0436a.m706e(parcel, i));
                return;
            case 1:
                stringBuilder.append(C0436a.m709h(parcel, i));
                return;
            case 2:
                stringBuilder.append(C0436a.m708g(parcel, i));
                return;
            case 3:
                stringBuilder.append(C0436a.m710i(parcel, i));
                return;
            case 4:
                stringBuilder.append(C0436a.m711j(parcel, i));
                return;
            case 5:
                stringBuilder.append(C0436a.m712k(parcel, i));
                return;
            case 6:
                stringBuilder.append(C0436a.m704c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(C0465j.m823a(C0436a.m713l(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(C0458c.m810a(C0436a.m716o(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(C0458c.m811b(C0436a.m716o(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle n = C0436a.m715n(parcel, i);
                Set<String> keySet = n.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(C0465j.m823a(n.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel y = C0436a.m726y(parcel, i);
                y.setDataPosition(0);
                zza(stringBuilder, com_google_android_gms_internal_zzacs_zza___.zzyC(), y);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Object obj) {
        if (com_google_android_gms_internal_zzacs_zza___.zzyt()) {
            zzb(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, (ArrayList) obj);
        } else {
            zza(stringBuilder, com_google_android_gms_internal_zzacs_zza___.zzys(), obj);
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            zza(stringBuilder, com_google_android_gms_internal_zzacs_zza___.zzys(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> zzr(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.zzaiI;
    }

    public String toString() {
        C0424f.m650a(this.zzaHf, (Object) "Cannot convert to JSON on client side.");
        Parcel zzyH = zzyH();
        zzyH.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzaHf.zzdw(this.mClassName), zzyH);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ct.m1174a(this, parcel, i);
    }

    public Object zzds(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzdt(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzyH() {
        switch (this.zzaHo) {
            case 0:
                this.zzaHp = C0438c.m728a(this.zzaHm);
                C0438c.m729a(this.zzaHm, this.zzaHp);
                this.zzaHo = 2;
                break;
            case 1:
                C0438c.m729a(this.zzaHm, this.zzaHp);
                this.zzaHo = 2;
                break;
        }
        return this.zzaHm;
    }

    zzacw zzyI() {
        switch (this.zzaHn) {
            case 0:
                return null;
            case 1:
                return this.zzaHf;
            case 2:
                return this.zzaHf;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzaHn);
        }
    }

    public Map<String, zza<?, ?>> zzyr() {
        return this.zzaHf == null ? null : this.zzaHf.zzdw(this.mClassName);
    }
}
