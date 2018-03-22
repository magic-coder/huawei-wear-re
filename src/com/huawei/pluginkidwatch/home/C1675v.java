package com.huawei.pluginkidwatch.home;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.plugin.chat.ChatActivity;
import com.huawei.pluginkidwatch.plugin.feature.newsport.NewSportActivity;
import com.huawei.pluginkidwatch.plugin.feature.track.activity.TrackActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeActivity */
class C1675v implements OnClickListener {
    final /* synthetic */ HomeActivity f4375a;

    C1675v(HomeActivity homeActivity) {
        this.f4375a = homeActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============bottom layout is clicked");
        int id = view.getId();
        if (g.main_relative_sport == id) {
            this.f4375a.startActivity(new Intent(this.f4375a, NewSportActivity.class));
        } else if (g.main_relative_call == id) {
            this.f4375a.ag();
        } else if (g.main_relative_Reward == id) {
            this.f4375a.an();
        } else if (g.main_relative_track == id) {
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.V.a(), hashMap, 0);
            this.f4375a.startActivity(new Intent(this.f4375a, TrackActivity.class));
        } else if (g.main_liner_bluetooth == id || g.main_btn_antiloss == id) {
            this.f4375a.m7473J();
        } else if (g.main_relative_chat != id) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "===============can't find the viewId ：", id + "");
        } else if (C1490j.m6888a() == null || C1490j.m6888a().size() <= 0 || !C1490j.m6888a().containsKey("abilityRet")) {
            C1483c.m6832c(this.f4375a.f4109F, this.f4375a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_network_exception_notice));
            if (this.f4375a.bw != null) {
                this.f4375a.bw.m7672a(C1462f.m6746j());
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============not Support chat");
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============Support chat");
            this.f4375a.startActivity(new Intent(this.f4375a.f4109F, ChatActivity.class));
        }
    }
}
