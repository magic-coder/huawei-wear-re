package com.amap.api.mapcore.util;

/* compiled from: IDownloadListener */
public interface ah {

    /* compiled from: IDownloadListener */
    public enum C3277a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        
        private int f11410f;

        private C3277a(int i) {
            this.f11410f = i;
        }
    }

    void mo4054a(long j, long j2);

    void mo4055a(C3277a c3277a);

    void mo4058l();

    void mo4059m();

    void mo4060n();
}
