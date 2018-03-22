package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends Activity {
    private final ArrayList<C1559w> f3649a = new ArrayList();

    public void m7070a(C1559w c1559w) {
        if (!this.f3649a.contains(c1559w)) {
            this.f3649a.add(c1559w);
        }
    }

    public void m7071b(C1559w c1559w) {
        this.f3649a.remove(c1559w);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f3649a.iterator();
        while (it.hasNext()) {
            ((C1559w) it.next()).mo2541a(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f3649a.iterator();
        while (it.hasNext()) {
            ((C1559w) it.next()).mo2542b(this);
        }
    }

    protected void onStart() {
        super.onStart();
        Iterator it = this.f3649a.iterator();
        while (it.hasNext()) {
            ((C1559w) it.next()).mo2543c(this);
        }
    }

    protected void onStop() {
        super.onStop();
        Iterator it = this.f3649a.iterator();
        while (it.hasNext()) {
            ((C1559w) it.next()).mo2544d(this);
        }
    }
}
