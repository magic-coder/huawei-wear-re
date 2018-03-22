package com.huawei.hwappdfxmgr.p053b;

import com.huawei.hwappdfxmgr.b.a;
import com.huawei.p190v.C2538c;

import java.io.File;

/* compiled from: CrashHandler */
class C4584b implements Runnable {
    final /* synthetic */ File f16791a;
    final /* synthetic */ a f16792b;

    C4584b(a aVar, File file) {
        this.f16792b = aVar;
        this.f16791a = file;
    }

    public void run() {
        if (this.f16791a.isDirectory()) {
            String[] list = this.f16791a.list();
            if (list != null && list.length > 0) {
                for (String str : list) {
                    C2538c.b(a.b(), new Object[]{"fileName=" + list[r0]});
                    File file = new File(a.a(this.f16792b) + "/" + str);
                    String name = file.getName();
                    if (file.isFile() && name.startsWith("app_crashLog_") && name.endsWith(".txt")) {
                        try {
                            if (file.delete()) {
                                C2538c.b(a.b(), new Object[]{"文件删除成功"});
                            }
                        } catch (Exception e) {
                            C2538c.b(a.b(), new Object[]{e.getMessage()});
                        }
                    }
                }
            }
        }
    }
}
