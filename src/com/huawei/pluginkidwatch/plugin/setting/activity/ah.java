package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.GetTpyeRetModel;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: InviteManagerActivity */
class ah implements OnClickListener {
    final /* synthetic */ af f6588a;

    ah(af afVar) {
        this.f6588a = afVar;
    }

    public void onClick(View view) {
        this.f6588a.f6586a.f6357w.cancel();
        this.f6588a.f6586a.f6357w = null;
        C1506g.m6978a(this.f6588a.f6586a, this.f6588a.f6586a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_loading), false);
        GetTpyeRetModel getTpyeRetModel = new GetTpyeRetModel();
        getTpyeRetModel.deviceCode = C1462f.m6746j();
        try {
            getTpyeRetModel.phoneNum = URLEncoder.encode(this.f6588a.f6586a.f6349o.getText().toString(), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("InviteManagerActivity", "UnsupportedEncodingException e = " + e.getMessage());
        }
        getTpyeRetModel.nickname = this.f6588a.f6586a.f6348n.getText().toString();
        getTpyeRetModel.type = this.f6588a.f6586a.f6360z;
        this.f6588a.f6586a.f6356v.mo2485a(getTpyeRetModel, new ai(this));
    }
}
