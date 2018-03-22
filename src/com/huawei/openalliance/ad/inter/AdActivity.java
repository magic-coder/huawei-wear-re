package com.huawei.openalliance.ad.inter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.android.app.ActionBarEx;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p124i.C1302a;
import com.huawei.openalliance.ad.p112a.p124i.C1302a.C1290a;
import com.huawei.openalliance.ad.p112a.p124i.C1302a.C1291b;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public class AdActivity extends Activity implements C1290a, C1291b {
    private static final String TAG = "AdActivity";
    public static final String TAG_DETAIL_URL = "detailUrl";
    public static final String TAG_PARAM_FROM_SERVER = "paramFromServer";
    public static final String TAG_SHOW_ID = "showId";
    private ActionBar actionBar;
    private boolean endReported = false;
    private C1302a mDetailView;
    private int opTimes = 0;
    private C1229o paramFromServer;
    private String showId;
    private boolean startReported = false;

    class C13191 implements OnClickListener {
        C13191() {
        }

        public void onClick(View view) {
            AdActivity.this.onDetailClose();
        }
    }

    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setRequestedOrientation(14);
        String str2 = "";
        try {
            str2 = getIntent().getStringExtra(TAG_DETAIL_URL);
            this.actionBar = getActionBar();
            str = str2;
        } catch (Exception e) {
            C1336d.m5890d(TAG, "get detail url fail");
            str = str2;
        }
        try {
            this.showId = getIntent().getStringExtra(TAG_SHOW_ID);
            this.paramFromServer = (C1229o) getIntent().getSerializableExtra(TAG_PARAM_FROM_SERVER);
        } catch (ClassCastException e2) {
            C1336d.m5888c(TAG, "parameter class cast error");
            this.paramFromServer = null;
        } catch (Exception e3) {
            C1336d.m5888c(TAG, "get show id fail");
            this.paramFromServer = null;
        }
        if (C1287e.m5686b() >= 3 && this.actionBar != null) {
            this.actionBar.setTitle("详情");
            ActionBarEx.setStartIcon(this.actionBar, true, null, new C13191());
            this.mDetailView = new C1302a(this, str, this.paramFromServer, this.showId, this.actionBar);
        } else if (this.actionBar != null) {
            this.actionBar.hide();
            this.mDetailView = new C1302a(this, str, this.paramFromServer, this.showId);
        } else {
            this.mDetailView = new C1302a(this, str, this.paramFromServer, this.showId);
        }
        setContentView(this.mDetailView);
        this.mDetailView.m5793a((C1290a) this);
        this.mDetailView.m5794a((C1291b) this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onDetailClose() {
        finish();
    }

    public void onOperation() {
        this.opTimes++;
    }

    protected void onPause() {
        super.onPause();
        if (!this.endReported) {
            this.endReported = true;
            C1216b c1216b = new C1216b();
            c1216b.setType__("webclose");
            c1216b.setTime__(C1287e.m5689d());
            c1216b.setShowid__(this.showId);
            c1216b.setParamfromserver__(this.paramFromServer);
            c1216b.setOpTimesInLandingPage__(this.opTimes);
            C1249b.m5535a((Context) this, 1, c1216b);
        }
    }

    protected void onResume() {
        super.onResume();
        if (!this.startReported) {
            this.startReported = true;
            C1216b c1216b = new C1216b();
            c1216b.setType__("webopen");
            c1216b.setTime__(C1287e.m5689d());
            c1216b.setShowid__(this.showId);
            c1216b.setParamfromserver__(this.paramFromServer);
            C1249b.m5535a((Context) this, 1, c1216b);
        }
    }
}
