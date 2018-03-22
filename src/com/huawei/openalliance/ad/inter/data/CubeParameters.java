package com.huawei.openalliance.ad.inter.data;

public class CubeParameters {
    private String mAccoutInfo;
    private String mModel;
    private int mTVHeight;
    private String mTVModel;
    private int mTVWidth;
    private String mVersion;

    public final class Builder {
        private String accoutInfo;
        private String model;
        private int tvHeight;
        private String tvModel;
        private int tvWidth;
        private String version;

        public final CubeParameters build() {
            return new CubeParameters();
        }

        public final Builder withAccountInfo(String str) {
            this.accoutInfo = str;
            return this;
        }

        public final Builder withModel(String str) {
            this.model = str;
            return this;
        }

        public final Builder withTVHeight(int i) {
            this.tvHeight = i;
            return this;
        }

        public final Builder withTVModel(String str) {
            this.tvModel = str;
            return this;
        }

        public final Builder withTVWidth(int i) {
            this.tvWidth = i;
            return this;
        }

        public final Builder withVersion(String str) {
            this.version = str;
            return this;
        }
    }

    private CubeParameters(Builder builder) {
        this.mAccoutInfo = builder.accoutInfo;
        this.mModel = builder.model;
        this.mVersion = builder.version;
        this.mTVModel = builder.tvModel;
        this.mTVWidth = builder.tvWidth;
        this.mTVHeight = builder.tvHeight;
    }

    public String getmAccoutInfo() {
        return this.mAccoutInfo;
    }

    public String getmModel() {
        return this.mModel;
    }

    public int getmTVHeight() {
        return this.mTVHeight;
    }

    public String getmTVModel() {
        return this.mTVModel;
    }

    public int getmTVWidth() {
        return this.mTVWidth;
    }

    public String getmVersion() {
        return this.mVersion;
    }
}
