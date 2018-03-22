package com.huawei.nfc.carrera.ui.swipe;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;
import java.util.List;

public class TipFragmentContainer extends FrameLayout {
    private FragmentManager manager;

    public TipFragmentContainer(Context context, FragmentManager fragmentManager) {
        super(context);
        this.manager = fragmentManager;
    }

    public void pauseFragments() {
        List<Fragment> fragments = this.manager.getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.setUserVisibleHint(false);
                    this.manager.beginTransaction().hide(fragment).commitAllowingStateLoss();
                }
            }
        }
    }
}
