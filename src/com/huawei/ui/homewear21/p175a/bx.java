package com.huawei.ui.homewear21.p175a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.main.stories.messagecenter.activity.DispatchSkipEventActivity;
import com.huawei.ui.main.stories.messagecenter.activity.MessageCenterActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeFragment */
class bx implements OnClickListener {
    final /* synthetic */ C2217a f8097a;

    bx(C2217a c2217a) {
        this.f8097a = c2217a;
    }

    public void onClick(View view) {
        int id = view.getId();
        Map hashMap;
        if (id == f.card_notification_layout) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "onClick card_notification_layout !");
            String str = "";
            str = "";
            str = this.f8097a.m11562s();
            String t = this.f8097a.m11563t();
            if (!t.isEmpty() && !t.isEmpty()) {
                C2538c.m12677c("testnftHomeFragment", "onClick card_notification_layout messageId = " + str + " detailUrl = " + t);
                Intent intent = new Intent();
                intent.setClass(this.f8097a.f8041z, DispatchSkipEventActivity.class);
                intent.putExtra("msgId", str);
                intent.putExtra("detailUri", t);
                this.f8097a.f8041z.startActivity(intent);
                hashMap = new HashMap();
                hashMap.put("click", "1");
                hashMap.put("type", "0");
                c.a().a(this.f8097a.f7992A, a.d.a(), hashMap, 0);
                Uri parse = Uri.parse(t);
                if (parse != null) {
                    Map hashMap2;
                    t = parse.getScheme();
                    String host = parse.getHost();
                    if (t.equals("http") || t.equals("https")) {
                        hashMap2 = new HashMap();
                        hashMap2.put("click", "1");
                        hashMap2.put("type", "1");
                        hashMap2.put("from", "1");
                        c.a().a(this.f8097a.f7992A, a.F.a(), hashMap2, 0);
                    } else {
                        hashMap2 = new HashMap();
                        hashMap2.put("click", "1");
                        hashMap2.put("type", "0");
                        hashMap2.put("from", "1");
                        c.a().a(this.f8097a.f7992A, a.F.a(), hashMap2, 0);
                    }
                    if ("sportReport".equals(host)) {
                        hashMap2 = new HashMap();
                        if (Integer.parseInt(parse.getQueryParameter("report_stype")) == 0) {
                            hashMap2.put("report", "1");
                        } else {
                            hashMap2.put("report", "0");
                        }
                        hashMap2.put("from", "1");
                        c.a().a(this.f8097a.f7992A, a.I.a(), hashMap2, 0);
                    } else if ("historyBestMessage".equals(host)) {
                        hashMap = new HashMap();
                        hashMap.put("click", "1");
                        hashMap.put("from", "1");
                        c.a().a(this.f8097a.f7992A, a.H.a(), hashMap, 0);
                    }
                }
            }
        } else if (id == f.btn_notify_message_unread) {
            C2538c.m12677c("testnftHomeFragment", "onClick btn_notify_message_unread !");
            hashMap = new HashMap();
            hashMap.put("click", "1");
            hashMap.put("type", "1");
            c.a().a(this.f8097a.f7992A, a.d.a(), hashMap, 0);
            Intent intent2 = new Intent();
            intent2.setClass(this.f8097a.f8041z, MessageCenterActivity.class);
            this.f8097a.f8041z.startActivity(intent2);
        } else if (id == f.card_download_hihealth_layout) {
            this.f8097a.f7999H.m11999f(true);
            this.f8097a.aR.setVisibility(8);
            this.f8097a.m11446a(0);
            this.f8097a.bw();
        } else if (id == f.btn_download_hihealth_icon) {
            this.f8097a.f7999H.m11999f(true);
            this.f8097a.aR.setVisibility(8);
            this.f8097a.bw();
        } else if (id == f.card_download_hihealth_swim_layout) {
            this.f8097a.aZ.setVisibility(8);
            this.f8097a.f7999H.m12007j(true);
            this.f8097a.bx();
        } else if (id == f.btn_download_hihealth_swim_icon || id == f.btn_download_hihealth_icon_swim_left) {
            this.f8097a.aZ.setVisibility(8);
            this.f8097a.f7999H.m12007j(true);
        } else if (id == f.notification_alert_icon) {
            this.f8097a.m11466a(Boolean.valueOf(false));
        }
    }
}
