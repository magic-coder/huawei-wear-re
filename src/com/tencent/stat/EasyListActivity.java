package com.tencent.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    protected void onPause() {
        super.onPause();
        C6474g.m29564f(this);
    }

    protected void onResume() {
        super.onResume();
        C6474g.m29563e(this);
    }
}
