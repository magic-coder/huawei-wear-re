package com.google.android.gms.internal;

import java.util.Comparator;

public class de implements Comparator<zzayz> {
    public int m1193a(zzayz com_google_android_gms_internal_zzayz, zzayz com_google_android_gms_internal_zzayz2) {
        return com_google_android_gms_internal_zzayz.zzbBF == com_google_android_gms_internal_zzayz2.zzbBF ? com_google_android_gms_internal_zzayz.name.compareTo(com_google_android_gms_internal_zzayz2.name) : com_google_android_gms_internal_zzayz.zzbBF - com_google_android_gms_internal_zzayz2.zzbBF;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m1193a((zzayz) obj, (zzayz) obj2);
    }
}
