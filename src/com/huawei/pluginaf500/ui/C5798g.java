package com.huawei.pluginaf500.ui;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: AF500IntroduceActivity */
class C5798g extends PagerAdapter {
    final /* synthetic */ AF500IntroduceActivity f19960a;

    C5798g(AF500IntroduceActivity aF500IntroduceActivity) {
        this.f19960a = aF500IntroduceActivity;
    }

    public int getCount() {
        return this.f19960a.f19670d.length;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f19960a.f19671e[i] == null) {
            this.f19960a.f19671e[i] = LayoutInflater.from(this.f19960a).inflate(this.f19960a.f19670d[i], null);
        }
        View view = this.f19960a.f19671e[i];
        viewGroup.addView(view);
        return view;
    }
}
