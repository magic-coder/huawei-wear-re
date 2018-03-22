package com.huawei.pluginkidwatch.common.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public abstract class KidWatchBaseTitleWebActivity extends KidWatchBaseTitleActivity {
    private ImageButton f3528b;

    protected abstract int mo2628j();

    protected int mo2526h() {
        return h.base_title_web_layout;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = (FrameLayout) findViewById(g.baseTitleWebRootView);
        this.f3528b = (ImageButton) findViewById(g.base_cancle_btn);
        frameLayout.addView(LayoutInflater.from(this).inflate(mo2628j(), null), 0);
    }

    public void onWebCancleClick(View view) {
        finish();
    }
}
