package com.huawei.ui.main.stories.messagecenter.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MessageCenterActivity */
class C2412a implements OnItemClickListener {
    final /* synthetic */ MessageCenterActivity f8691a;

    C2412a(MessageCenterActivity messageCenterActivity) {
        this.f8691a = messageCenterActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g.c("MessageCenterActivity", "start onItemClick position = " + i);
        MessageObject messageObject = (MessageObject) adapterView.getItemAtPosition(i);
        if (messageObject != null) {
            g.c("MessageCenterActivity", "onItemClick position = " + i + "  messageObject = " + messageObject);
            g.c("MessageCenterActivity", "onItemClick position = " + i + "  DetailUri = " + messageObject.getDetailUri());
            Intent intent = new Intent();
            intent.putExtra("msgId", messageObject.getMsgId());
            intent.putExtra("detailUri", messageObject.getDetailUri());
            intent.setClass(this.f8691a, DispatchSkipEventActivity.class);
            this.f8691a.startActivity(intent);
            g.c("MessageCenterActivity", "Leave onItemClick position = " + i);
            Uri parse = Uri.parse(messageObject.getDetailUri());
            if (parse != null) {
                Map hashMap;
                String scheme = parse.getScheme();
                String host = parse.getHost();
                if (scheme.equals("http") || scheme.equals("https")) {
                    hashMap = new HashMap();
                    hashMap.put("click", "1");
                    hashMap.put("type", "1");
                    hashMap.put("from", "2");
                    c.a().a(BaseApplication.m2632b(), a.F.a(), hashMap, 0);
                } else {
                    hashMap = new HashMap();
                    hashMap.put("click", "1");
                    hashMap.put("type", "0");
                    hashMap.put("from", "2");
                    c.a().a(BaseApplication.m2632b(), a.F.a(), hashMap, 0);
                }
                if ("sportReport".equals(host)) {
                    hashMap = new HashMap();
                    if (Integer.parseInt(parse.getQueryParameter("report_stype")) == 0) {
                        hashMap.put("report", "1");
                    } else {
                        hashMap.put("report", "0");
                    }
                    hashMap.put("from", "2");
                    c.a().a(BaseApplication.m2632b(), a.I.a(), hashMap, 0);
                } else if ("historyBestMessage".equals(host)) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("click", "1");
                    hashMap2.put("from", "2");
                    c.a().a(BaseApplication.m2632b(), a.H.a(), hashMap2, 0);
                }
            }
        }
    }
}
