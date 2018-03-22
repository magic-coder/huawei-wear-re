package com.huawei.hwdevicedfxmanager.utils;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.IOException;
import java.nio.ByteBuffer;

class MaintenanceUtil$LogThread extends Thread {
    private boolean exception;
    final /* synthetic */ MaintenanceUtil this$0;

    private MaintenanceUtil$LogThread(MaintenanceUtil maintenanceUtil) {
        this.this$0 = maintenanceUtil;
        this.exception = false;
    }

    public synchronized void start() {
        if (MaintenanceUtil.access$100(this.this$0) == null) {
            this.this$0.initMaintenanceFile();
        }
        super.start();
    }

    public synchronized void run() {
        C2538c.m12680e("MaintenanceUtil", "run isWrite" + MaintenanceUtil.access$200(this.this$0));
        while (MaintenanceUtil.access$200(this.this$0)) {
            this.exception = false;
            if (MaintenanceUtil.access$300(this.this$0) == null) {
                this.this$0.initMaintenanceFile();
            } else {
                while (true) {
                    byte[] bArr = (byte[]) MaintenanceUtil.access$400(this.this$0).poll();
                    if (bArr == null) {
                        break;
                    }
                    try {
                        MaintenanceUtil.access$502(this.this$0, ByteBuffer.wrap(bArr));
                        if (MaintenanceUtil.access$300(this.this$0) != null) {
                            MaintenanceUtil.access$300(this.this$0).write(MaintenanceUtil.access$500(this.this$0));
                        }
                    } catch (IOException e) {
                        C2538c.m12680e("MaintenanceUtil", "Exception e = " + e.getMessage());
                        this.exception = true;
                        this.this$0.initMaintenanceFile();
                    }
                }
                this.this$0.maintLogs2.clear();
                MaintenanceUtil.access$602(this.this$0, 0);
                if (MaintenanceUtil.access$700(this.this$0) != null) {
                    if (this.exception) {
                        MaintenanceUtil.access$700(this.this$0).onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                    } else {
                        MaintenanceUtil.access$700(this.this$0).onResponse(10001, "Failed");
                    }
                }
                try {
                    wait();
                } catch (InterruptedException e2) {
                    C2538c.m12680e("MaintenanceUtil", "InterruptedException e1 = " + e2.getMessage());
                }
            }
        }
    }

    @Deprecated
    public void destroy() {
        try {
            MaintenanceUtil.access$202(this.this$0, false);
            if (MaintenanceUtil.access$300(this.this$0) != null) {
                MaintenanceUtil.access$300(this.this$0).close();
            }
            if (true == MaintenanceUtil.access$100(this.this$0).getFD().valid()) {
                MaintenanceUtil.access$100(this.this$0).close();
            }
        } catch (IOException e) {
            C2538c.m12680e("MaintenanceUtil", e.getMessage());
        }
        MaintenanceUtil.access$302(this.this$0, null);
        super.destroy();
    }
}
