package com.huawei.uploadlog;

import android.os.Looper;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;

/* compiled from: LogUploadTask */
public class C2524g implements Runnable {
    private LogUpload f9008a = null;
    private int f9009b = 0;

    public C2524g(LogUpload logUpload, int i) {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask] <> new LogUploadTask instance");
        this.f9008a = logUpload;
        this.f9009b = i;
    }

    public void run() {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] <>");
        if (this.f9008a != null) {
            int b = C2507c.m12460b();
            C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] CommonConstants.getUploadType(): " + b);
            if (b == 0 || b == this.f9009b) {
                b = C2507c.m12466f();
                int flags = this.f9008a.getFlags() & 1;
                int flags2 = this.f9008a.getFlags() & 2;
                int flags3 = this.f9008a.getFlags() & 4;
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] networkType " + b + ", flagWifi=" + flags + ", flag3g=" + flags2 + ", flag2g=" + flags3);
                if (b == 1) {
                    if (flags != 1) {
                        return;
                    }
                } else if (b == 0) {
                    return;
                } else {
                    if (!(flags2 == 2 || flags3 == 4)) {
                        return;
                    }
                }
                b = this.f9008a.getUserType();
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run]userType:" + b);
                if (b == 1) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Beta Log Start Upload******");
                } else if (b == 2) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Fans Log Start Upload******");
                } else if (b == 3) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Dev Log Start Upload******");
                }
                C2517m.m12570a(this.f9008a, 1);
                C2507c.m12457a(this.f9009b);
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] logUploadInfo.getSize() " + this.f9008a.getSize());
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] logUploadInfo.getTaskId() " + this.f9008a.getTaskId());
                if (this.f9008a.getSize() < 1024000) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] 小文件上传 service启动上传线程");
                    C2529l.m12612e(this.f9008a);
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] 大文件上传 service启动上传线程");
                    if (StringUtils.isNullOrEmpty(this.f9008a.getUploadPath())) {
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] 大文件上传 第一次上传");
                        C2529l.m12612e(this.f9008a);
                    } else {
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] 大文件上传  已经请求过日志服务器 path:" + this.f9008a.getUploadPath());
                        this.f9008a.setType(2);
                        C2529l.m12613f(this.f9008a);
                    }
                }
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] 收尾处理，判断是否还有任务在处理中");
                if (!this.f9008a.isSetTime() && !C2529l.m12607a()) {
                    if (this.f9008a.getUserType() == 1) {
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Beta Log End Upload******");
                    } else if (this.f9008a.getUserType() == 2) {
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Fans Log End Upload******");
                    } else if (this.f9008a.getUserType() == 3) {
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadTask.run] *****Dev Log End Upload******");
                    }
                    C2519o c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessageDelayed(c2519o.obtainMessage(0), 3000);
                }
            }
        }
    }
}
