package com.huawei.openalliance.ad.inter.data;

import android.view.ViewGroup;
import com.huawei.openalliance.ad.utils.C1365i;

public class SplashParam {
    private String adId;
    private ViewGroup adView;
    private int defaultSlogan;
    private int deviceType;
    private boolean isTest;
    private ViewGroup logo;
    private int orientation;
    private ViewGroup slogan;

    public final class Builder {
        private String adId;
        private ViewGroup adView;
        private int defaultSlogan;
        private int deviceType;
        private boolean isTest;
        private ViewGroup logo;
        private int orientation;
        private ViewGroup slogan;

        public final SplashParam build() {
            return new SplashParam();
        }

        public final Builder withAdId(String str) {
            this.adId = str;
            return this;
        }

        public final Builder withAdVGroup(ViewGroup viewGroup) {
            this.adView = viewGroup;
            return this;
        }

        public final Builder withDefSloganResId(int i) {
            this.defaultSlogan = i;
            return this;
        }

        public final Builder withDeviceType(int i) {
            this.deviceType = i;
            return this;
        }

        public final Builder withIsTest(boolean z) {
            this.isTest = z;
            return this;
        }

        public final Builder withLogoVGroup(ViewGroup viewGroup) {
            this.logo = viewGroup;
            return this;
        }

        public final Builder withOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public final Builder withSloganVGroup(ViewGroup viewGroup) {
            this.slogan = viewGroup;
            return this;
        }
    }

    private SplashParam(Builder builder) {
        this.slogan = builder.slogan;
        this.logo = builder.logo;
        this.adView = builder.adView;
        this.defaultSlogan = builder.defaultSlogan;
        this.adId = builder.adId;
        this.isTest = builder.isTest;
        this.orientation = builder.orientation;
        this.deviceType = builder.deviceType;
    }

    public boolean checkParam() {
        return (this.slogan == null || this.logo == null || this.adView == null || C1365i.m6081a(this.adId)) ? false : (1 == this.orientation || this.orientation == 0) ? 4 == this.deviceType || 5 == this.deviceType : false;
    }

    public String getAdId() {
        return this.adId;
    }

    public ViewGroup getAdView() {
        return this.adView;
    }

    public int getDefaultSlogan() {
        return this.defaultSlogan;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public ViewGroup getLogo() {
        return this.logo;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public ViewGroup getSlogan() {
        return this.slogan;
    }

    public void hideAdView() {
        if (this.adView != null) {
            this.adView.setVisibility(4);
        }
    }

    public void hideLogo() {
        if (this.logo != null) {
            this.logo.setVisibility(8);
        }
    }

    public void hideSlogan() {
        if (this.slogan != null) {
            this.slogan.setVisibility(4);
        }
    }

    public boolean isTest() {
        return this.isTest;
    }

    public void showAdView() {
        if (this.adView != null) {
            this.adView.setVisibility(0);
        }
    }

    public void showLogo() {
        if (this.logo != null) {
            this.logo.setVisibility(0);
        }
    }

    public void showSlogan() {
        if (this.slogan != null) {
            this.slogan.setVisibility(0);
        }
    }
}
