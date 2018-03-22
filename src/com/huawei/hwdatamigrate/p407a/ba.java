package com.huawei.hwdatamigrate.p407a;

/* compiled from: UserConfigTable */
public class ba extends ay {
    public int f17537i;
    public String f17538j;
    public boolean f17539k;

    public String toString() {
        return "UserConfigTable [id=" + this.f17537i + ", openCloud=" + this.f17539k + ", login_type=" + m22830a(this.c) + ", login_time=" + this.d + ", expire_time=" + this.e + "]";
    }

    private String m22830a(int i) {
        String str = "";
        if (bb.Huawei.ordinal() == i) {
            return "Huawei";
        }
        if (bb.SinaWeibo.ordinal() == i) {
            return "SinaWeibo";
        }
        if (bb.TencentWeibo.ordinal() == i) {
            return "TencentWeibo";
        }
        if (bb.QQ.ordinal() == i) {
            return "QQ";
        }
        if (bb.Baidu.ordinal() == i) {
            return "Baidu";
        }
        if (bb.Weixin.ordinal() == i) {
            return "Weixin";
        }
        if (bb.Facebook.ordinal() == i) {
            return "Facebook";
        }
        if (bb.Twitter.ordinal() == i) {
            return "Twitter";
        }
        if (bb.Line.ordinal() == i) {
            return "Line";
        }
        return str;
    }
}
