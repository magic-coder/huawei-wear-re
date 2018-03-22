package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.C0372j;
import java.util.ArrayList;
import java.util.Iterator;

class ao extends as {
    final /* synthetic */ ai f560a;
    private final ArrayList<C0372j> f561c;

    public ao(ai aiVar, ArrayList<C0372j> arrayList) {
        this.f560a = aiVar;
        super(aiVar);
        this.f561c = arrayList;
    }

    @WorkerThread
    public void mo1822a() {
        this.f560a.f529a.f880g.f851d = this.f560a.m952j();
        Iterator it = this.f561c.iterator();
        while (it.hasNext()) {
            ((C0372j) it.next()).m359a(this.f560a.f543o, this.f560a.f529a.f880g.f851d);
        }
    }
}
