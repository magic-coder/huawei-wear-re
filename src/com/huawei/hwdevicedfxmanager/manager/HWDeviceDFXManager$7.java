package com.huawei.hwdevicedfxmanager.manager;

import android.os.RemoteException;
import com.huawei.hwservicesmgr.s;
import com.huawei.p190v.C2538c;

class HWDeviceDFXManager$7 extends s {
    final /* synthetic */ HWDeviceDFXManager this$0;

    HWDeviceDFXManager$7(HWDeviceDFXManager hWDeviceDFXManager) {
        this.this$0 = hWDeviceDFXManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(int r18, java.lang.String r19, java.lang.String r20) throws android.os.RemoteException {
        /*
        r17 = this;
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "sleepITransferSleepAndDFXFileCallback() onSuccess ";
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "!!!!mTransferStateContentPath = ";
        r5 = r5.append(r6);
        r0 = r20;
        r5 = r5.append(r0);
        r6 = ", mTransferDataContentPath = ";
        r5 = r5.append(r6);
        r0 = r19;
        r5 = r5.append(r0);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        if (r20 != 0) goto L_0x0073;
    L_0x003c:
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "mTransferStateContentPath is null .callback failure. ";
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        if (r2 == 0) goto L_0x0064;
    L_0x0053:
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        r3 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;
        r4 = "state path is null.";
        r2.onFailure(r3, r4);
    L_0x0063:
        return;
    L_0x0064:
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "sleepITransferSleepAndDFXFileCallback() onFailure maintenanceCallback is null";
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        goto L_0x0063;
    L_0x0073:
        r6 = 0;
        r7 = 0;
        r4 = 0;
        r5 = 0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r0 = r17;
        r2 = r0.this$0;	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r2);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r0 = r20;
        r2 = r2.getFileStreamPath(r0);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r10 = r2.length();	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r2 = "HWDeviceDFXManager";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r12 = 0;
        r13 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r13.<init>();	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r14 = "----------mTransferStateContent stateLength = ";
        r13 = r13.append(r14);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r10 = r13.append(r10);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r10 = r10.toString();	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r8[r12] = r10;	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        com.huawei.v.c.c(r2, r8);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r0 = r17;
        r2 = r0.this$0;	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r2);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r0 = r20;
        r8 = r2.openFileInput(r0);	 Catch:{ FileNotFoundException -> 0x0344, IOException -> 0x0492, ClassNotFoundException -> 0x05da, all -> 0x0722 }
        r6 = new java.io.ObjectInputStream;	 Catch:{ FileNotFoundException -> 0x08d9, IOException -> 0x08c5, ClassNotFoundException -> 0x08b1, all -> 0x089f }
        r6.<init>(r8);	 Catch:{ FileNotFoundException -> 0x08d9, IOException -> 0x08c5, ClassNotFoundException -> 0x08b1, all -> 0x089f }
        r2 = r6.readObject();	 Catch:{ FileNotFoundException -> 0x08e1, IOException -> 0x08c9, ClassNotFoundException -> 0x08b5 }
        r2 = (java.util.ArrayList) r2;	 Catch:{ FileNotFoundException -> 0x08e1, IOException -> 0x08c9, ClassNotFoundException -> 0x08b5 }
        if (r19 == 0) goto L_0x090d;
    L_0x00cc:
        r0 = r17;
        r3 = r0.this$0;	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r3 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r3);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r0 = r19;
        r3 = r3.getFileStreamPath(r0);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r10 = r3.length();	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r12 = 0;
        r13 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r13.<init>();	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r14 = "----------mTransferStateContent dataLength = ";
        r13 = r13.append(r14);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r10 = r13.append(r10);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r10 = r10.toString();	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r4[r12] = r10;	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        com.huawei.v.c.c(r3, r4);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r0 = r17;
        r3 = r0.this$0;	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r3 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r3);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r0 = r19;
        r7 = r3.openFileInput(r0);	 Catch:{ FileNotFoundException -> 0x08e8, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r4 = new java.io.ObjectInputStream;	 Catch:{ FileNotFoundException -> 0x08f2, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r4.<init>(r7);	 Catch:{ FileNotFoundException -> 0x08f2, IOException -> 0x08cc, ClassNotFoundException -> 0x08b8 }
        r3 = r4.readObject();	 Catch:{ FileNotFoundException -> 0x08fc, IOException -> 0x08d2, ClassNotFoundException -> 0x08be, all -> 0x08a6 }
        r3 = (java.util.ArrayList) r3;	 Catch:{ FileNotFoundException -> 0x08fc, IOException -> 0x08d2, ClassNotFoundException -> 0x08be, all -> 0x08a6 }
    L_0x0115:
        if (r8 == 0) goto L_0x0127;
    L_0x0117:
        r8.close();	 Catch:{ IOException -> 0x025c }
        r5 = "HWDeviceDFXManager";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "IOException fileIn1-- ";
        r8[r9] = r10;
        com.huawei.v.c.e(r5, r8);
    L_0x0127:
        if (r7 == 0) goto L_0x0139;
    L_0x0129:
        r7.close();	 Catch:{ IOException -> 0x028f }
        r5 = "HWDeviceDFXManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = "IOException fileIn2-- ";
        r7[r8] = r9;
        com.huawei.v.c.e(r5, r7);
    L_0x0139:
        if (r6 == 0) goto L_0x014b;
    L_0x013b:
        r6.close();	 Catch:{ IOException -> 0x02c2 }
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "IOException inputStream1-- ";
        r6[r7] = r8;
        com.huawei.v.c.e(r5, r6);
    L_0x014b:
        if (r4 == 0) goto L_0x0908;
    L_0x014d:
        r4.close();	 Catch:{ IOException -> 0x0303 }
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "IOException inputStream2-- ";
        r5[r6] = r7;
        com.huawei.v.c.e(r4, r5);
    L_0x015d:
        r15 = r3;
        r3 = r2;
        r2 = r15;
    L_0x0160:
        if (r19 == 0) goto L_0x018e;
    L_0x0162:
        r0 = r17;
        r4 = r0.this$0;
        r4 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r4);
        r0 = r19;
        r4 = r4.deleteFile(r0);
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "isDeleteDataSuc :";
        r8 = r8.append(r9);
        r4 = r8.append(r4);
        r4 = r4.toString();
        r6[r7] = r4;
        com.huawei.v.c.c(r5, r6);
    L_0x018e:
        r0 = r17;
        r4 = r0.this$0;
        r4 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r4);
        r0 = r20;
        r4 = r4.deleteFile(r0);
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "isDeleteStateSuc :";
        r8 = r8.append(r9);
        r4 = r8.append(r4);
        r4 = r4.toString();
        r6[r7] = r4;
        com.huawei.v.c.c(r5, r6);
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "coreSleepData :";
        r7 = r7.append(r8);
        r7 = r7.append(r2);
        r7 = r7.toString();
        r5[r6] = r7;
        com.huawei.v.c.c(r4, r5);
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "coreSleepStatus :";
        r7 = r7.append(r8);
        r7 = r7.append(r3);
        r7 = r7.toString();
        r5[r6] = r7;
        com.huawei.v.c.c(r4, r5);
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "coreSleepData size =  :";
        r7 = r7.append(r8);
        r8 = r2.size();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5[r6] = r7;
        com.huawei.v.c.c(r4, r5);
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "coreSleepStatus size =";
        r7 = r7.append(r8);
        r8 = r3.size();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r5[r6] = r7;
        com.huawei.v.c.c(r4, r5);
        r4 = r3.size();
        if (r4 != 0) goto L_0x0864;
    L_0x0240:
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        if (r2 == 0) goto L_0x0854;
    L_0x024a:
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        r3 = "status file size is 0.";
        r0 = r18;
        r2.onFailure(r0, r3);
        goto L_0x0063;
    L_0x025c:
        r5 = move-exception;
        r8 = "HWDeviceDFXManager";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0280 }
        r10 = 0;
        r11 = "fileIn1.close(),IOException e = ";
        r9[r10] = r11;	 Catch:{ all -> 0x0280 }
        r10 = 1;
        r5 = r5.getMessage();	 Catch:{ all -> 0x0280 }
        r9[r10] = r5;	 Catch:{ all -> 0x0280 }
        com.huawei.v.c.e(r8, r9);	 Catch:{ all -> 0x0280 }
        r5 = "HWDeviceDFXManager";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "IOException fileIn1-- ";
        r8[r9] = r10;
        com.huawei.v.c.e(r5, r8);
        goto L_0x0127;
    L_0x0280:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x028f:
        r5 = move-exception;
        r7 = "HWDeviceDFXManager";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x02b3 }
        r9 = 0;
        r10 = "fileIn2.close(),IOException e = ";
        r8[r9] = r10;	 Catch:{ all -> 0x02b3 }
        r9 = 1;
        r5 = r5.getMessage();	 Catch:{ all -> 0x02b3 }
        r8[r9] = r5;	 Catch:{ all -> 0x02b3 }
        com.huawei.v.c.e(r7, r8);	 Catch:{ all -> 0x02b3 }
        r5 = "HWDeviceDFXManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = "IOException fileIn2-- ";
        r7[r8] = r9;
        com.huawei.v.c.e(r5, r7);
        goto L_0x0139;
    L_0x02b3:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x02c2:
        r5 = move-exception;
        r6 = "HWDeviceDFXManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x02f4 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02f4 }
        r9.<init>();	 Catch:{ all -> 0x02f4 }
        r10 = "IOException inputStream1-- ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x02f4 }
        r5 = r5.getMessage();	 Catch:{ all -> 0x02f4 }
        r5 = r9.append(r5);	 Catch:{ all -> 0x02f4 }
        r5 = r5.toString();	 Catch:{ all -> 0x02f4 }
        r7[r8] = r5;	 Catch:{ all -> 0x02f4 }
        com.huawei.v.c.e(r6, r7);	 Catch:{ all -> 0x02f4 }
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "IOException inputStream1-- ";
        r6[r7] = r8;
        com.huawei.v.c.e(r5, r6);
        goto L_0x014b;
    L_0x02f4:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0303:
        r4 = move-exception;
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0335 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0335 }
        r8.<init>();	 Catch:{ all -> 0x0335 }
        r9 = "IOException inputStream2-- ";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0335 }
        r4 = r4.getMessage();	 Catch:{ all -> 0x0335 }
        r4 = r8.append(r4);	 Catch:{ all -> 0x0335 }
        r4 = r4.toString();	 Catch:{ all -> 0x0335 }
        r6[r7] = r4;	 Catch:{ all -> 0x0335 }
        com.huawei.v.c.e(r5, r6);	 Catch:{ all -> 0x0335 }
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "IOException inputStream2-- ";
        r5[r6] = r7;
        com.huawei.v.c.e(r4, r5);
        goto L_0x015d;
    L_0x0335:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0344:
        r2 = move-exception;
        r15 = r5;
        r5 = r4;
        r4 = r15;
        r16 = r7;
        r7 = r6;
        r6 = r16;
    L_0x034d:
        r8 = "HWDeviceDFXManager";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x08aa }
        r11 = 0;
        r12 = "getFile() FileNotFoundException e = ";
        r10[r11] = r12;	 Catch:{ all -> 0x08aa }
        r11 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x08aa }
        r10[r11] = r2;	 Catch:{ all -> 0x08aa }
        com.huawei.v.c.e(r8, r10);	 Catch:{ all -> 0x08aa }
        if (r7 == 0) goto L_0x0373;
    L_0x0363:
        r7.close();	 Catch:{ IOException -> 0x03ac }
        r2 = "HWDeviceDFXManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r7[r8] = r10;
        com.huawei.v.c.e(r2, r7);
    L_0x0373:
        if (r6 == 0) goto L_0x0385;
    L_0x0375:
        r6.close();	 Catch:{ IOException -> 0x03de }
        r2 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r6[r7] = r8;
        com.huawei.v.c.e(r2, r6);
    L_0x0385:
        if (r5 == 0) goto L_0x0397;
    L_0x0387:
        r5.close();	 Catch:{ IOException -> 0x0410 }
        r2 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r5[r6] = r7;
        com.huawei.v.c.e(r2, r5);
    L_0x0397:
        if (r4 == 0) goto L_0x0905;
    L_0x0399:
        r4.close();	 Catch:{ IOException -> 0x0451 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
    L_0x03a9:
        r2 = r9;
        goto L_0x0160;
    L_0x03ac:
        r2 = move-exception;
        r7 = "HWDeviceDFXManager";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x03cf }
        r10 = 0;
        r11 = "fileIn1.close(),IOException e = ";
        r8[r10] = r11;	 Catch:{ all -> 0x03cf }
        r10 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x03cf }
        r8[r10] = r2;	 Catch:{ all -> 0x03cf }
        com.huawei.v.c.e(r7, r8);	 Catch:{ all -> 0x03cf }
        r2 = "HWDeviceDFXManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r7[r8] = r10;
        com.huawei.v.c.e(r2, r7);
        goto L_0x0373;
    L_0x03cf:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x03de:
        r2 = move-exception;
        r6 = "HWDeviceDFXManager";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0401 }
        r8 = 0;
        r10 = "fileIn2.close(),IOException e = ";
        r7[r8] = r10;	 Catch:{ all -> 0x0401 }
        r8 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x0401 }
        r7[r8] = r2;	 Catch:{ all -> 0x0401 }
        com.huawei.v.c.e(r6, r7);	 Catch:{ all -> 0x0401 }
        r2 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r6[r7] = r8;
        com.huawei.v.c.e(r2, r6);
        goto L_0x0385;
    L_0x0401:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0410:
        r2 = move-exception;
        r5 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0442 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0442 }
        r8.<init>();	 Catch:{ all -> 0x0442 }
        r10 = "IOException inputStream1-- ";
        r8 = r8.append(r10);	 Catch:{ all -> 0x0442 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0442 }
        r2 = r8.append(r2);	 Catch:{ all -> 0x0442 }
        r2 = r2.toString();	 Catch:{ all -> 0x0442 }
        r6[r7] = r2;	 Catch:{ all -> 0x0442 }
        com.huawei.v.c.e(r5, r6);	 Catch:{ all -> 0x0442 }
        r2 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r5[r6] = r7;
        com.huawei.v.c.e(r2, r5);
        goto L_0x0397;
    L_0x0442:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0451:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0483 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0483 }
        r7.<init>();	 Catch:{ all -> 0x0483 }
        r8 = "IOException inputStream2-- ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0483 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0483 }
        r2 = r7.append(r2);	 Catch:{ all -> 0x0483 }
        r2 = r2.toString();	 Catch:{ all -> 0x0483 }
        r5[r6] = r2;	 Catch:{ all -> 0x0483 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x0483 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
        goto L_0x03a9;
    L_0x0483:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0492:
        r2 = move-exception;
        r8 = r6;
        r6 = r4;
    L_0x0495:
        r4 = "HWDeviceDFXManager";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x08a3 }
        r11 = 0;
        r12 = "getFile() IOException e = ";
        r10[r11] = r12;	 Catch:{ all -> 0x08a3 }
        r11 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x08a3 }
        r10[r11] = r2;	 Catch:{ all -> 0x08a3 }
        com.huawei.v.c.e(r4, r10);	 Catch:{ all -> 0x08a3 }
        if (r8 == 0) goto L_0x04bb;
    L_0x04ab:
        r8.close();	 Catch:{ IOException -> 0x04f4 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r4[r8] = r10;
        com.huawei.v.c.e(r2, r4);
    L_0x04bb:
        if (r7 == 0) goto L_0x04cd;
    L_0x04bd:
        r7.close();	 Catch:{ IOException -> 0x0526 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r2, r4);
    L_0x04cd:
        if (r6 == 0) goto L_0x04df;
    L_0x04cf:
        r6.close();	 Catch:{ IOException -> 0x0558 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r2, r4);
    L_0x04df:
        if (r5 == 0) goto L_0x0905;
    L_0x04e1:
        r5.close();	 Catch:{ IOException -> 0x0599 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
    L_0x04f1:
        r2 = r9;
        goto L_0x0160;
    L_0x04f4:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0517 }
        r10 = 0;
        r11 = "fileIn1.close(),IOException e = ";
        r8[r10] = r11;	 Catch:{ all -> 0x0517 }
        r10 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x0517 }
        r8[r10] = r2;	 Catch:{ all -> 0x0517 }
        com.huawei.v.c.e(r4, r8);	 Catch:{ all -> 0x0517 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r4[r8] = r10;
        com.huawei.v.c.e(r2, r4);
        goto L_0x04bb;
    L_0x0517:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0526:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0549 }
        r8 = 0;
        r10 = "fileIn2.close(),IOException e = ";
        r7[r8] = r10;	 Catch:{ all -> 0x0549 }
        r8 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x0549 }
        r7[r8] = r2;	 Catch:{ all -> 0x0549 }
        com.huawei.v.c.e(r4, r7);	 Catch:{ all -> 0x0549 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r2, r4);
        goto L_0x04cd;
    L_0x0549:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0558:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x058a }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x058a }
        r8.<init>();	 Catch:{ all -> 0x058a }
        r10 = "IOException inputStream1-- ";
        r8 = r8.append(r10);	 Catch:{ all -> 0x058a }
        r2 = r2.getMessage();	 Catch:{ all -> 0x058a }
        r2 = r8.append(r2);	 Catch:{ all -> 0x058a }
        r2 = r2.toString();	 Catch:{ all -> 0x058a }
        r6[r7] = r2;	 Catch:{ all -> 0x058a }
        com.huawei.v.c.e(r4, r6);	 Catch:{ all -> 0x058a }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r2, r4);
        goto L_0x04df;
    L_0x058a:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0599:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x05cb }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x05cb }
        r7.<init>();	 Catch:{ all -> 0x05cb }
        r8 = "IOException inputStream2-- ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x05cb }
        r2 = r2.getMessage();	 Catch:{ all -> 0x05cb }
        r2 = r7.append(r2);	 Catch:{ all -> 0x05cb }
        r2 = r2.toString();	 Catch:{ all -> 0x05cb }
        r5[r6] = r2;	 Catch:{ all -> 0x05cb }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x05cb }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
        goto L_0x04f1;
    L_0x05cb:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x05da:
        r2 = move-exception;
        r8 = r6;
        r6 = r4;
    L_0x05dd:
        r4 = "HWDeviceDFXManager";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x08a3 }
        r11 = 0;
        r12 = "getFile() ClassNotFoundException e = ";
        r10[r11] = r12;	 Catch:{ all -> 0x08a3 }
        r11 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x08a3 }
        r10[r11] = r2;	 Catch:{ all -> 0x08a3 }
        com.huawei.v.c.e(r4, r10);	 Catch:{ all -> 0x08a3 }
        if (r8 == 0) goto L_0x0603;
    L_0x05f3:
        r8.close();	 Catch:{ IOException -> 0x063c }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r4[r8] = r10;
        com.huawei.v.c.e(r2, r4);
    L_0x0603:
        if (r7 == 0) goto L_0x0615;
    L_0x0605:
        r7.close();	 Catch:{ IOException -> 0x066e }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r2, r4);
    L_0x0615:
        if (r6 == 0) goto L_0x0627;
    L_0x0617:
        r6.close();	 Catch:{ IOException -> 0x06a0 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r2, r4);
    L_0x0627:
        if (r5 == 0) goto L_0x0905;
    L_0x0629:
        r5.close();	 Catch:{ IOException -> 0x06e1 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
    L_0x0639:
        r2 = r9;
        goto L_0x0160;
    L_0x063c:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x065f }
        r10 = 0;
        r11 = "fileIn1.close(),IOException e = ";
        r8[r10] = r11;	 Catch:{ all -> 0x065f }
        r10 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x065f }
        r8[r10] = r2;	 Catch:{ all -> 0x065f }
        com.huawei.v.c.e(r4, r8);	 Catch:{ all -> 0x065f }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r10 = "IOException fileIn1-- ";
        r4[r8] = r10;
        com.huawei.v.c.e(r2, r4);
        goto L_0x0603;
    L_0x065f:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x066e:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0691 }
        r8 = 0;
        r10 = "fileIn2.close(),IOException e = ";
        r7[r8] = r10;	 Catch:{ all -> 0x0691 }
        r8 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x0691 }
        r7[r8] = r2;	 Catch:{ all -> 0x0691 }
        com.huawei.v.c.e(r4, r7);	 Catch:{ all -> 0x0691 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r2, r4);
        goto L_0x0615;
    L_0x0691:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x06a0:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x06d2 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06d2 }
        r8.<init>();	 Catch:{ all -> 0x06d2 }
        r10 = "IOException inputStream1-- ";
        r8 = r8.append(r10);	 Catch:{ all -> 0x06d2 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x06d2 }
        r2 = r8.append(r2);	 Catch:{ all -> 0x06d2 }
        r2 = r2.toString();	 Catch:{ all -> 0x06d2 }
        r6[r7] = r2;	 Catch:{ all -> 0x06d2 }
        com.huawei.v.c.e(r4, r6);	 Catch:{ all -> 0x06d2 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r2, r4);
        goto L_0x0627;
    L_0x06d2:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x06e1:
        r2 = move-exception;
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0713 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0713 }
        r7.<init>();	 Catch:{ all -> 0x0713 }
        r8 = "IOException inputStream2-- ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0713 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0713 }
        r2 = r7.append(r2);	 Catch:{ all -> 0x0713 }
        r2 = r2.toString();	 Catch:{ all -> 0x0713 }
        r5[r6] = r2;	 Catch:{ all -> 0x0713 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x0713 }
        r2 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r2, r4);
        goto L_0x0639;
    L_0x0713:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0722:
        r2 = move-exception;
        r8 = r6;
        r6 = r4;
    L_0x0725:
        if (r8 == 0) goto L_0x0737;
    L_0x0727:
        r8.close();	 Catch:{ IOException -> 0x076e }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r9 = "IOException fileIn1-- ";
        r4[r8] = r9;
        com.huawei.v.c.e(r3, r4);
    L_0x0737:
        if (r7 == 0) goto L_0x0749;
    L_0x0739:
        r7.close();	 Catch:{ IOException -> 0x07a0 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r3, r4);
    L_0x0749:
        if (r6 == 0) goto L_0x075b;
    L_0x074b:
        r6.close();	 Catch:{ IOException -> 0x07d2 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r3, r4);
    L_0x075b:
        if (r5 == 0) goto L_0x076d;
    L_0x075d:
        r5.close();	 Catch:{ IOException -> 0x0813 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
    L_0x076d:
        throw r2;
    L_0x076e:
        r3 = move-exception;
        r4 = "HWDeviceDFXManager";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0791 }
        r9 = 0;
        r10 = "fileIn1.close(),IOException e = ";
        r8[r9] = r10;	 Catch:{ all -> 0x0791 }
        r9 = 1;
        r3 = r3.getMessage();	 Catch:{ all -> 0x0791 }
        r8[r9] = r3;	 Catch:{ all -> 0x0791 }
        com.huawei.v.c.e(r4, r8);	 Catch:{ all -> 0x0791 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r8 = 0;
        r9 = "IOException fileIn1-- ";
        r4[r8] = r9;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0737;
    L_0x0791:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x07a0:
        r3 = move-exception;
        r4 = "HWDeviceDFXManager";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x07c3 }
        r8 = 0;
        r9 = "fileIn2.close(),IOException e = ";
        r7[r8] = r9;	 Catch:{ all -> 0x07c3 }
        r8 = 1;
        r3 = r3.getMessage();	 Catch:{ all -> 0x07c3 }
        r7[r8] = r3;	 Catch:{ all -> 0x07c3 }
        com.huawei.v.c.e(r4, r7);	 Catch:{ all -> 0x07c3 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = 0;
        r8 = "IOException fileIn2-- ";
        r4[r7] = r8;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0749;
    L_0x07c3:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException fileIn2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x07d2:
        r3 = move-exception;
        r4 = "HWDeviceDFXManager";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0804 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0804 }
        r8.<init>();	 Catch:{ all -> 0x0804 }
        r9 = "IOException inputStream1-- ";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0804 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0804 }
        r3 = r8.append(r3);	 Catch:{ all -> 0x0804 }
        r3 = r3.toString();	 Catch:{ all -> 0x0804 }
        r6[r7] = r3;	 Catch:{ all -> 0x0804 }
        com.huawei.v.c.e(r4, r6);	 Catch:{ all -> 0x0804 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = "IOException inputStream1-- ";
        r4[r6] = r7;
        com.huawei.v.c.e(r3, r4);
        goto L_0x075b;
    L_0x0804:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream1-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0813:
        r3 = move-exception;
        r4 = "HWDeviceDFXManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0845 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0845 }
        r7.<init>();	 Catch:{ all -> 0x0845 }
        r8 = "IOException inputStream2-- ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0845 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0845 }
        r3 = r7.append(r3);	 Catch:{ all -> 0x0845 }
        r3 = r3.toString();	 Catch:{ all -> 0x0845 }
        r5[r6] = r3;	 Catch:{ all -> 0x0845 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ all -> 0x0845 }
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        goto L_0x076d;
    L_0x0845:
        r2 = move-exception;
        r3 = "HWDeviceDFXManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "IOException inputStream2-- ";
        r4[r5] = r6;
        com.huawei.v.c.e(r3, r4);
        throw r2;
    L_0x0854:
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "sleepITransferSleepAndDFXFileCallback() onFailure maintenanceCallback is null";
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        goto L_0x0063;
    L_0x0864:
        r0 = r17;
        r4 = r0.this$0;
        r4 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$700(r4);
        r4 = com.huawei.m.d.a(r4);
        r5 = 0;
        r4.a(r5, r2, r3);
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        if (r2 == 0) goto L_0x088f;
    L_0x087e:
        r0 = r17;
        r2 = r0.this$0;
        r2 = com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager.access$600(r2);
        r3 = "";
        r0 = r18;
        r2.onSuccess(r0, r3);
        goto L_0x0063;
    L_0x088f:
        r2 = "HWDeviceDFXManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "sleepITransferSleepAndDFXFileCallback() onSuccess maintenanceCallback is null";
        r3[r4] = r5;
        com.huawei.v.c.c(r2, r3);
        goto L_0x0063;
    L_0x089f:
        r2 = move-exception;
        r6 = r4;
        goto L_0x0725;
    L_0x08a3:
        r2 = move-exception;
        goto L_0x0725;
    L_0x08a6:
        r2 = move-exception;
        r5 = r4;
        goto L_0x0725;
    L_0x08aa:
        r2 = move-exception;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        goto L_0x0725;
    L_0x08b1:
        r2 = move-exception;
        r6 = r4;
        goto L_0x05dd;
    L_0x08b5:
        r2 = move-exception;
        goto L_0x05dd;
    L_0x08b8:
        r3 = move-exception;
        r15 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x05dd;
    L_0x08be:
        r3 = move-exception;
        r5 = r4;
        r15 = r2;
        r2 = r3;
        r3 = r15;
        goto L_0x05dd;
    L_0x08c5:
        r2 = move-exception;
        r6 = r4;
        goto L_0x0495;
    L_0x08c9:
        r2 = move-exception;
        goto L_0x0495;
    L_0x08cc:
        r3 = move-exception;
        r15 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x0495;
    L_0x08d2:
        r3 = move-exception;
        r5 = r4;
        r15 = r2;
        r2 = r3;
        r3 = r15;
        goto L_0x0495;
    L_0x08d9:
        r2 = move-exception;
        r6 = r7;
        r7 = r8;
        r15 = r5;
        r5 = r4;
        r4 = r15;
        goto L_0x034d;
    L_0x08e1:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        goto L_0x034d;
    L_0x08e8:
        r3 = move-exception;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r15 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x034d;
    L_0x08f2:
        r3 = move-exception;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r15 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x034d;
    L_0x08fc:
        r3 = move-exception;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r15 = r2;
        r2 = r3;
        r3 = r15;
        goto L_0x034d;
    L_0x0905:
        r2 = r9;
        goto L_0x0160;
    L_0x0908:
        r15 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x0160;
    L_0x090d:
        r3 = r9;
        r4 = r5;
        goto L_0x0115;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager$7.onSuccess(int, java.lang.String, java.lang.String):void");
    }

    public void onFailure(int i, String str) throws RemoteException {
        C2538c.c("HWDeviceDFXManager", new Object[]{"sleepITransferSleepAndDFXFileCallback() onFailure err_msg = " + str});
        if (HWDeviceDFXManager.access$600(this.this$0) != null) {
            HWDeviceDFXManager.access$600(this.this$0).onFailure(i, str);
            return;
        }
        C2538c.c("HWDeviceDFXManager", new Object[]{"sleepITransferSleepAndDFXFileCallback() onFailure maintenanceCallback is null"});
    }
}
