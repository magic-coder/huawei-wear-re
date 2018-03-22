package com.huawei.sim.esim.view;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.sim.e;
import com.huawei.sim.i;
import com.huawei.ui.commonui.webview.WebViewActivity;

/* compiled from: WirelessManagerAcitivity */
class al extends ClickableSpan {
    final /* synthetic */ WirelessManagerAcitivity f20433a;

    al(WirelessManagerAcitivity wirelessManagerAcitivity) {
        this.f20433a = wirelessManagerAcitivity;
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f20433a.getResources().getColor(e.IDS_plugin_sim_next_back_color));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f20433a.f20404d, WebViewActivity.class);
        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", this.f20433a.getString(i.IDS_plugin_multi_sim_notice_url));
        intent.putExtra("WebViewActivity.TITLE", this.f20433a.getString(i.IDS_plugin_multi_sim_manager_title));
        this.f20433a.f20404d.startActivity(intent);
    }
}
