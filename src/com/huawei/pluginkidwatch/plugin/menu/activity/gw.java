package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: TailorContactActivity */
class gw extends Handler {
    final /* synthetic */ TailorContactActivity f6169a;

    gw(TailorContactActivity tailorContactActivity) {
        this.f6169a = tailorContactActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 11:
                if (!this.f6169a.f5882H) {
                    try {
                        SetWatchContactIOEntityModel setWatchContactIOEntityModel = new SetWatchContactIOEntityModel();
                        setWatchContactIOEntityModel.deviceCode = C1462f.m6746j();
                        setWatchContactIOEntityModel.name = this.f6169a.f5897d.getText().toString();
                        setWatchContactIOEntityModel.phoneNum = URLEncoder.encode(this.f6169a.f5898e.getText().toString(), GameManager.DEFAULT_CHARSET);
                        setWatchContactIOEntityModel.contactId = C1497q.m6948c(this.f6169a, "contactid");
                        setWatchContactIOEntityModel.type = this.f6169a.f5879E;
                        if (this.f6169a.f5879E.equals("7")) {
                            if (!"".equals(this.f6169a.f5875A)) {
                                setWatchContactIOEntityModel.headIcon = this.f6169a.f5875A;
                            }
                            if (!"".equals(this.f6169a.f5876B)) {
                                setWatchContactIOEntityModel.bigHeadIcon = this.f6169a.f5876B;
                            }
                        }
                        C2538c.m12674b("TailorContactActivity", "==ww== tailor model ==" + setWatchContactIOEntityModel.toString());
                        C2538c.m12674b("TailorContactActivity", "==ww== tailor model ==  开始才向云端发数据调接口");
                        this.f6169a.f5903j.mo2495a(setWatchContactIOEntityModel, new gx(this));
                        return;
                    } catch (UnsupportedEncodingException e) {
                        C2538c.m12674b("TailorContactActivity", "==ww== tailor model ==  Exception Exception =" + e.getMessage());
                        return;
                    }
                }
                return;
            case 56:
                this.f6169a.f5877C.removeCallbacks(this.f6169a.f5881G);
                C1506g.m6979b();
                C1483c.m6824a(this.f6169a, C1680l.IDS_plugin_kidwatch_menu_option_failed);
                return;
            default:
                return;
        }
    }
}
