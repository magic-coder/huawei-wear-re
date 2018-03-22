package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.d;

/* compiled from: AntilossActivity */
class C1793q implements Runnable {
    final /* synthetic */ C1792p f4942a;

    C1793q(C1792p c1792p) {
        this.f4942a = c1792p;
    }

    public void run() {
        if (1 == this.f4942a.f4941a.f4875F) {
            this.f4942a.f4941a.f4889h.setText(this.f4942a.f4941a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_state_search, new Object[]{this.f4942a.f4941a.f4906y}));
            this.f4942a.f4941a.f4889h.setTextColor(this.f4942a.f4941a.getResources().getColor(d.kw_color_white_100alpha));
        } else if (2 == this.f4942a.f4941a.f4875F) {
            this.f4942a.f4941a.f4889h.setText(this.f4942a.f4941a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_state_connect, new Object[]{this.f4942a.f4941a.f4906y}));
            this.f4942a.f4941a.f4889h.setTextColor(this.f4942a.f4941a.getResources().getColor(d.kw_color_white_100alpha));
        } else if (3 == this.f4942a.f4941a.f4875F) {
            this.f4942a.f4941a.f4889h.setText(this.f4942a.f4941a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_state_start));
            this.f4942a.f4941a.f4889h.setTextColor(this.f4942a.f4941a.getResources().getColor(d.kw_color_white_100alpha));
        } else {
            this.f4942a.f4941a.f4889h.setText(this.f4942a.f4941a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_connect_state_create));
            this.f4942a.f4941a.f4889h.setTextColor(this.f4942a.f4941a.getResources().getColor(d.kw_color_white_100alpha));
        }
    }
}
