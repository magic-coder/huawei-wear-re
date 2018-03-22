package com.huawei.crowdtestsdk.feedback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.R;
import java.util.ArrayList;

public abstract class BaseTableWidgetActivity extends FragmentActivity {
    private final OnPageChangeListener PageChangeListener = new C06821();
    protected ArrayList<Fragment> fragmentsList;
    protected ImageView titleBarImage;
    protected TextView titleBarText;
    protected ViewPager viewPager;

    class C06821 implements OnPageChangeListener {
        C06821() {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageSelected(int i) {
            BaseTableWidgetActivity.this.switchTab(i);
        }
    }

    class MultiFragmentAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragmentsList;

        public MultiFragmentAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
            super(fragmentManager);
            this.fragmentsList = arrayList;
        }

        public Fragment getItem(int i) {
            return (Fragment) this.fragmentsList.get(i);
        }

        public int getCount() {
            return this.fragmentsList.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    protected abstract void getFragmentData();

    protected abstract void setTitle();

    public void addFragment(Fragment fragment) {
        if (this.fragmentsList == null) {
            this.fragmentsList = new ArrayList();
        }
        this.fragmentsList.add(fragment);
    }

    public ArrayList<Fragment> getFragmentList() {
        return this.fragmentsList;
    }

    public void setTitleImageAndText(int i, String str) {
        this.titleBarImage.setImageResource(i);
        this.titleBarText.setText(str);
    }

    public void setTitleImageAndText(int i, int i2) {
        this.titleBarImage.setImageResource(i);
        this.titleBarText.setText(i2);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.sdk_crowdtest_activity_tablewidget_base);
        getFragmentData();
        initView();
        setTitle();
    }

    protected void initView() {
        if (this.fragmentsList != null && this.fragmentsList.size() > 0) {
            this.titleBarImage = (ImageView) findViewById(R.id.sdk_crowdtest_title_bar_image);
            this.titleBarText = (TextView) findViewById(R.id.sdk_crowdtest_title_bar_text);
            this.viewPager = (ViewPager) findViewById(R.id.sdk_crowdtest_view_pager_content);
            this.viewPager.setAdapter(new MultiFragmentAdapter(getSupportFragmentManager(), this.fragmentsList));
            this.viewPager.setOnPageChangeListener(this.PageChangeListener);
            this.viewPager.setOffscreenPageLimit(2);
        }
    }

    private void switchTab(int i) {
        if (i >= 0 && i < this.fragmentsList.size()) {
            this.viewPager.setCurrentItem(i);
        }
    }
}
