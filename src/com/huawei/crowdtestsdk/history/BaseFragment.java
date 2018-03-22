package com.huawei.crowdtestsdk.history;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {
    protected abstract void initView(View view);

    public abstract boolean onBackPressed();

    protected abstract void startWork();
}
