package com.huawei.bone.root;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/* compiled from: MainFragmentPagerAdapter */
public class C6796o extends FragmentPagerAdapter {
    ArrayList<Fragment> f23338a;

    public C6796o(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.f23338a = arrayList;
    }

    public int getCount() {
        return this.f23338a.size();
    }

    public Fragment getItem(int i) {
        return (Fragment) this.f23338a.get(i);
    }
}
