package com.tencent.wxop.stat;

import android.app.ListActivity;
import android.content.Context;

public class EasyListActivity extends ListActivity {
    protected void onPause() {
        super.onPause();
        C6546x.m29871b((Context) this);
    }

    protected void onResume() {
        super.onResume();
        C6546x.m29862a((Context) this);
    }
}
