package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.C0423e;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.util.C0458c;
import com.google.android.gms.common.util.C0465j;
import com.google.android.gms.common.util.C0466k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class zzacs {

    public class zza<I, O> extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final cp CREATOR = new cp();
        protected final int zzaGX;
        protected final boolean zzaGY;
        protected final int zzaGZ;
        protected final boolean zzaHa;
        protected final String zzaHb;
        protected final int zzaHc;
        protected final Class<? extends zzacs> zzaHd;
        protected final String zzaHe;
        private zzacw zzaHf;
        private co<I, O> zzaHg;
        private final int zzaiI;

        zza(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zzacn com_google_android_gms_internal_zzacn) {
            this.zzaiI = i;
            this.zzaGX = i2;
            this.zzaGY = z;
            this.zzaGZ = i3;
            this.zzaHa = z2;
            this.zzaHb = str;
            this.zzaHc = i4;
            if (str2 == null) {
                this.zzaHd = null;
                this.zzaHe = null;
            } else {
                this.zzaHd = zzacz.class;
                this.zzaHe = str2;
            }
            if (com_google_android_gms_internal_zzacn == null) {
                this.zzaHg = null;
            } else {
                this.zzaHg = com_google_android_gms_internal_zzacn.zzyp();
            }
        }

        protected zza(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends zzacs> cls, co<I, O> coVar) {
            this.zzaiI = 1;
            this.zzaGX = i;
            this.zzaGY = z;
            this.zzaGZ = i2;
            this.zzaHa = z2;
            this.zzaHb = str;
            this.zzaHc = i3;
            this.zzaHd = cls;
            if (cls == null) {
                this.zzaHe = null;
            } else {
                this.zzaHe = cls.getCanonicalName();
            }
            this.zzaHg = coVar;
        }

        public static zza zza(String str, int i, co<?, ?> coVar, boolean z) {
            return new zza(7, z, 0, false, str, i, null, coVar);
        }

        public static <T extends zzacs> zza<T, T> zza(String str, int i, Class<T> cls) {
            return new zza(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends zzacs> zza<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new zza(11, true, 11, true, str, i, cls, null);
        }

        public static zza<Integer, Integer> zzk(String str, int i) {
            return new zza(0, false, 0, false, str, i, null, null);
        }

        public static zza<Boolean, Boolean> zzl(String str, int i) {
            return new zza(6, false, 6, false, str, i, null, null);
        }

        public static zza<String, String> zzm(String str, int i) {
            return new zza(7, false, 7, false, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.zzaHg.convertBack(o);
        }

        public int getVersionCode() {
            return this.zzaiI;
        }

        public String toString() {
            C0423e a = C0421c.m646a((Object) this).m648a("versionCode", Integer.valueOf(this.zzaiI)).m648a("typeIn", Integer.valueOf(this.zzaGX)).m648a("typeInArray", Boolean.valueOf(this.zzaGY)).m648a("typeOut", Integer.valueOf(this.zzaGZ)).m648a("typeOutArray", Boolean.valueOf(this.zzaHa)).m648a("outputFieldName", this.zzaHb).m648a("safeParcelFieldId", Integer.valueOf(this.zzaHc)).m648a("concreteTypeName", zzyz());
            Class zzyy = zzyy();
            if (zzyy != null) {
                a.m648a("concreteType.class", zzyy.getCanonicalName());
            }
            if (this.zzaHg != null) {
                a.m648a("converterName", this.zzaHg.getClass().getCanonicalName());
            }
            return a.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            cp.m1162a(this, parcel, i);
        }

        public void zza(zzacw com_google_android_gms_internal_zzacw) {
            this.zzaHf = com_google_android_gms_internal_zzacw;
        }

        public boolean zzyA() {
            return this.zzaHg != null;
        }

        zzacn zzyB() {
            return this.zzaHg == null ? null : zzacn.zza(this.zzaHg);
        }

        public Map<String, zza<?, ?>> zzyC() {
            C0424f.m649a(this.zzaHe);
            C0424f.m649a(this.zzaHf);
            return this.zzaHf.zzdw(this.zzaHe);
        }

        public int zzys() {
            return this.zzaGX;
        }

        public boolean zzyt() {
            return this.zzaGY;
        }

        public int zzyu() {
            return this.zzaGZ;
        }

        public boolean zzyv() {
            return this.zzaHa;
        }

        public String zzyw() {
            return this.zzaHb;
        }

        public int zzyx() {
            return this.zzaHc;
        }

        public Class<? extends zzacs> zzyy() {
            return this.zzaHd;
        }

        String zzyz() {
            return this.zzaHe == null ? null : this.zzaHe;
        }
    }

    private void zza(StringBuilder stringBuilder, zza com_google_android_gms_internal_zzacs_zza, Object obj) {
        if (com_google_android_gms_internal_zzacs_zza.zzys() == 11) {
            stringBuilder.append(((zzacs) com_google_android_gms_internal_zzacs_zza.zzyy().cast(obj)).toString());
        } else if (com_google_android_gms_internal_zzacs_zza.zzys() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(C0465j.m823a((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void zza(StringBuilder stringBuilder, zza com_google_android_gms_internal_zzacs_zza, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(stringBuilder, com_google_android_gms_internal_zzacs_zza, obj);
            }
        }
        stringBuilder.append("]");
    }

    public String toString() {
        Map zzyr = zzyr();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : zzyr.keySet()) {
            zza com_google_android_gms_internal_zzacs_zza = (zza) zzyr.get(str);
            if (zza(com_google_android_gms_internal_zzacs_zza)) {
                Object zza = zza(com_google_android_gms_internal_zzacs_zza, zzb(com_google_android_gms_internal_zzacs_zza));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (zza != null) {
                    switch (com_google_android_gms_internal_zzacs_zza.zzyu()) {
                        case 8:
                            stringBuilder.append("\"").append(C0458c.m810a((byte[]) zza)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(C0458c.m811b((byte[]) zza)).append("\"");
                            break;
                        case 10:
                            C0466k.m824a(stringBuilder, (HashMap) zza);
                            break;
                        default:
                            if (!com_google_android_gms_internal_zzacs_zza.zzyt()) {
                                zza(stringBuilder, com_google_android_gms_internal_zzacs_zza, zza);
                                break;
                            }
                            zza(stringBuilder, com_google_android_gms_internal_zzacs_zza, (ArrayList) zza);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    protected <O, I> I zza(zza<I, O> com_google_android_gms_internal_zzacs_zza_I__O, Object obj) {
        return com_google_android_gms_internal_zzacs_zza_I__O.zzaHg != null ? com_google_android_gms_internal_zzacs_zza_I__O.convertBack(obj) : obj;
    }

    protected boolean zza(zza com_google_android_gms_internal_zzacs_zza) {
        return com_google_android_gms_internal_zzacs_zza.zzyu() == 11 ? com_google_android_gms_internal_zzacs_zza.zzyv() ? zzdv(com_google_android_gms_internal_zzacs_zza.zzyw()) : zzdu(com_google_android_gms_internal_zzacs_zza.zzyw()) : zzdt(com_google_android_gms_internal_zzacs_zza.zzyw());
    }

    protected Object zzb(zza com_google_android_gms_internal_zzacs_zza) {
        String zzyw = com_google_android_gms_internal_zzacs_zza.zzyw();
        if (com_google_android_gms_internal_zzacs_zza.zzyy() == null) {
            return zzds(com_google_android_gms_internal_zzacs_zza.zzyw());
        }
        zzds(com_google_android_gms_internal_zzacs_zza.zzyw());
        C0424f.m656a(true, "Concrete field shouldn't be value object: %s", com_google_android_gms_internal_zzacs_zza.zzyw());
        com_google_android_gms_internal_zzacs_zza.zzyv();
        try {
            char toUpperCase = Character.toUpperCase(zzyw.charAt(0));
            zzyw = String.valueOf(zzyw.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(zzyw).length() + 4).append("get").append(toUpperCase).append(zzyw).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzds(String str);

    protected abstract boolean zzdt(String str);

    protected boolean zzdu(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzdv(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, zza<?, ?>> zzyr();
}
