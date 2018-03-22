package com.huawei.logupload;

import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.logupload.p090c.C1105h;

/* compiled from: LogUploadTask */
public class C1109f implements Runnable {
    private LogUpload f2289a = null;
    private int f2290b = 0;

    public C1109f(LogUpload logUpload, int i) {
        C1103f.m4878b("LogUpload Service", "实例化上传任务");
        this.f2289a = logUpload;
        this.f2290b = i;
    }

    public void run() {
        C1103f.m4878b("LogUpload Service", "执行任务");
        if (this.f2289a != null) {
            C1103f.m4880d("LogUpload Service", "mUploadType:" + this.f2290b + "CommonConstants.getUploadType():" + C1102c.m4865b());
            if (this.f2290b == 0 || C1102c.m4865b() == 0 || C1102c.m4865b() == this.f2290b) {
                int f = C1102c.m4872f();
                int l = this.f2289a.m4806l() & 1;
                int l2 = this.f2289a.m4806l() & 2;
                int l3 = this.f2289a.m4806l() & 4;
                C1103f.m4878b("LogUpload Service", "networkType " + f + "flagWifi " + l + "flag3g " + l2 + "flag2g " + l3);
                if (f == 1) {
                    if (l != 1) {
                        C1105h.m4902b(this.f2289a);
                        return;
                    }
                } else if (f == 0 || !(l2 == 2 || l3 == 4)) {
                    C1105h.m4902b(this.f2289a);
                    return;
                }
                if (this.f2289a.m4763F() == 1) {
                    C1103f.m4878b("LogUpload Service", "*****Beta Log Start Upload******");
                } else if (this.f2289a.m4763F() == 2) {
                    C1103f.m4878b("LogUpload Service", "*****Fans Log Start Upload******");
                } else if (this.f2289a.m4763F() == 3) {
                    C1103f.m4878b("LogUpload Service", "*****Dev Log Start Upload******");
                } else if (this.f2289a.m4763F() == 4) {
                    C1103f.m4878b("LogUpload Service", "*****FEEDBACK Log Start Upload******");
                }
                C1105h.m4894a(new StringBuilder(String.valueOf(this.f2289a.m4791f())).toString(), 1);
                if (this.f2290b != 0) {
                    C1102c.m4862a(this.f2290b);
                }
                C1103f.m4878b("LogUpload Service", "CommonConstants.getTaskList():" + C1102c.m4867c());
                C1103f.m4878b("LogUpload Service", "这个是最新日志上传版本！！！！！");
                if (this.f2289a.m4802j() < 1024000) {
                    C1103f.m4878b("LogUpload Service", "mLogUploadInfo.getSize() " + this.f2289a.m4802j() + "mLogUploadInfo.getTaskId() " + this.f2289a.m4791f());
                    C1103f.m4878b("LogUpload Service", "小文件上传 service启动上传线程");
                    C1110k.m4922a(this.f2289a);
                } else {
                    C1103f.m4878b("LogUpload Service", "大文件上传 service启动上传线程");
                    C1103f.m4878b("LogUpload Service", "mLogUploadInfo.getSize() " + this.f2289a.m4802j() + "mLogUploadInfo.getTaskId() " + this.f2289a.m4791f());
                    if (this.f2289a.m4814p() == null || this.f2289a.m4814p().equals("")) {
                        C1103f.m4878b("LogUpload Service", "大文件上传 第一次上传");
                        C1110k.m4922a(this.f2289a);
                    } else {
                        C1103f.m4878b("LogUpload Service", "大文件上传  已经请求过日志服务器 path:" + this.f2289a.m4814p());
                        this.f2289a.m4773b(2);
                        C1110k.m4926b(this.f2289a);
                    }
                }
                C1103f.m4878b("LogUpload Service", "收尾处理，判断是否还有任务在处理中");
                C1105h.m4902b(this.f2289a);
                return;
            }
            C1105h.m4902b(this.f2289a);
        }
    }
}
