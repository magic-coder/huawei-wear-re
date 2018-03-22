package com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a;

import android.content.Intent;
import java.util.TimerTask;

/* compiled from: AntilossUtils */
public class C1776d extends TimerTask {
    final /* synthetic */ C1773a f4925a;

    public C1776d(C1773a c1773a) {
        this.f4925a = c1773a;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("antiloss.alarm.timeout");
        this.f4925a.f4917c.sendBroadcast(intent, "com.huawei.bone.permission.LOCAL_BROADCAST");
    }
}
