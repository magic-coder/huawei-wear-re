package com.huawei.android.pushagent.p018c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;

public class C4120e {
    public static void m20163a(Context context, String str, long j, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("content", str);
        bundle.putLong(JoinConstants.CYCLE, j);
        bundle.putInt("operType", 1);
        bundle.putInt("plusType", i);
        context.sendBroadcast(new Intent("com.huawei.android.push.PLUGIN").putExtra("plusReport", bundle).setPackage(context.getPackageName()));
    }
}
