package com.huawei.openalliance.ad.utils.db.bean;

public class MaterialRecord extends C1359a {
    private int actionType_;
    private int adType_;
    private String clickMonitorUrl_;
    private int creativeType_ = 2;
    private int displayCount_;
    private String displayDate_;
    private String fcCtrlDate_ = "";
    private int height_;
    private String htmlStr_;
    private String impMonitorUrl_;
    private String intentUri_;
    private int isPriority_;
    private int isSplashPreContent_;
    private long lastShowTime_;
    private String materialId_;
    private String md5_;
    private String metaData_;
    private String paramFromServer_;
    private String sha256_;
    private int showAppLogoFlag_ = 1;
    private String skipText_;
    private String slotId_;
    private long starttime_;
    private String taskId_;
    private long updateTime_;
    private long validTime_;
    private int width_;

    public String m6010a() {
        return this.md5_;
    }

    public void m6011a(int i) {
        this.adType_ = i;
    }

    public void m6012a(long j) {
        this.lastShowTime_ = j;
    }

    public void mo2463a(String str) {
        this.md5_ = str;
    }

    public String m6014b() {
        return this.sha256_;
    }

    public void m6015b(int i) {
        this.isSplashPreContent_ = i;
    }

    public void m6016b(long j) {
        this.validTime_ = j;
    }

    public void m6017b(String str) {
        this.sha256_ = str;
    }

    public String m6018c() {
        return this.skipText_;
    }

    public void m6019c(int i) {
        this.showAppLogoFlag_ = i;
    }

    public void m6020c(long j) {
        this.starttime_ = j;
    }

    public void m6021c(String str) {
        this.skipText_ = str;
    }

    public String m6022d() {
        return this.materialId_;
    }

    public void m6023d(int i) {
        this.width_ = i;
    }

    public void m6024d(long j) {
        this.updateTime_ = j;
    }

    public void m6025d(String str) {
        this.metaData_ = str;
    }

    public String m6026e() {
        return this.taskId_;
    }

    public void m6027e(int i) {
        this.height_ = i;
    }

    public void m6028e(String str) {
        this.slotId_ = str;
    }

    public int m6029f() {
        return this.showAppLogoFlag_;
    }

    public void m6030f(int i) {
        this.displayCount_ = i;
    }

    public void m6031f(String str) {
        this.materialId_ = str;
    }

    public long m6032g() {
        return this.validTime_;
    }

    public void m6033g(int i) {
        this.actionType_ = i;
    }

    public void m6034g(String str) {
        this.taskId_ = str;
    }

    public long m6035h() {
        return this.starttime_;
    }

    public void m6036h(int i) {
        this.isPriority_ = i;
    }

    public void m6037h(String str) {
        this.displayDate_ = str;
    }

    public int m6038i() {
        return this.width_;
    }

    public void m6039i(int i) {
        this.creativeType_ = i;
    }

    public void m6040i(String str) {
        this.htmlStr_ = str;
    }

    public int m6041j() {
        return this.height_;
    }

    public void m6042j(String str) {
        this.clickMonitorUrl_ = str;
    }

    public long m6043k() {
        return this.updateTime_;
    }

    public void m6044k(String str) {
        this.impMonitorUrl_ = str;
    }

    public int m6045l() {
        return this.displayCount_;
    }

    public void m6046l(String str) {
        this.paramFromServer_ = str;
    }

    public String m6047m() {
        return this.htmlStr_;
    }

    public void m6048m(String str) {
        this.intentUri_ = str;
    }

    public int m6049n() {
        return this.actionType_;
    }

    public int m6050o() {
        return this.creativeType_;
    }

    public String m6051p() {
        return this.clickMonitorUrl_;
    }

    public String m6052q() {
        return this.impMonitorUrl_;
    }

    public String mo2464r() {
        return "materialId";
    }

    public String m6054s() {
        return this.paramFromServer_;
    }

    public String m6055t() {
        return this.intentUri_;
    }
}
