package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.p190v.C2538c;

/* compiled from: FileServiceResultUtil */
public class C5327d {
    public static void m25789a(byte[] bArr, int i) {
        C4756w c4756w = new C4756w();
        switch (bArr[1]) {
            case (byte) 1:
                C5327d.m25787a(c4756w, bArr);
                return;
            case (byte) 2:
                C5327d.m25790b(c4756w, bArr);
                return;
            case (byte) 3:
                C5327d.m25788a(c4756w, bArr, i);
                return;
            case (byte) 4:
                C5327d.m25791c(c4756w, bArr);
                return;
            case (byte) 5:
                C5327d.m25792d(c4756w, bArr);
                return;
            case (byte) 6:
                C5327d.m25793e(c4756w, bArr);
                return;
            default:
                return;
        }
    }

    private static void m25787a(C4756w c4756w, byte[] bArr) {
        int i = -1;
        String a = a.a(bArr);
        try {
            String str = "";
            String str2 = "";
            String str3 = "";
            int i2 = -1;
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                int i3;
                String str4;
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        a = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"INFOR_FILE_NAME  filenames = " + a});
                        a = str2;
                        str2 = str;
                        i3 = i;
                        i = i2;
                        break;
                    case 2:
                        C2538c.c("FileServiceResultUtil", new Object[]{"INFOR_FILE_TYPE  file_type = " + Integer.parseInt(c4752s.m22733b())});
                        str4 = str2;
                        str2 = str;
                        i3 = i;
                        i = r0;
                        a = str4;
                        break;
                    case 3:
                        a = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"INFOR_PRODUCTID  productId "});
                        i3 = i;
                        i = i2;
                        str4 = str2;
                        str2 = a;
                        a = str4;
                        break;
                    case 4:
                        a = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"INFOR_ISSUERID  issuerId "});
                        str2 = str;
                        i3 = i;
                        i = i2;
                        break;
                    case 5:
                        C2538c.c("FileServiceResultUtil", new Object[]{"INFOR_CARDGROUPTYPE  cardType = " + Integer.parseInt(c4752s.m22733b())});
                        i = i2;
                        str4 = str;
                        i3 = r0;
                        a = str2;
                        str2 = str4;
                        break;
                    default:
                        a = str2;
                        str2 = str;
                        i3 = i;
                        i = i2;
                        break;
                }
                i2 = i;
                i = i3;
                str = str2;
                str2 = a;
            }
            C5328e.m25797a(i2, i, str, str2);
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_GET_INFOR  error e = " + e});
        }
    }

    private static void m25790b(C4756w c4756w, byte[] bArr) {
        C5326c.m25785m();
        String a = a.a(bArr);
        try {
            String str = "";
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            long j = -1;
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        str = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_FILE_PROTOCAL_VERSION  version = " + str});
                        break;
                    case 2:
                        i = Integer.parseInt(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_TRANSFER_BITMAP_ENABLE  bitmapEnable = " + i});
                        break;
                    case 3:
                        i2 = Integer.parseInt(c4752s.m22733b(), 16);
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_TRANSFER_UNIT_SIZE  transferSize = " + i2});
                        break;
                    case 4:
                        j = Long.parseLong(c4752s.m22733b(), 16);
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_MAX_APPLY_DATA_SIZE  maxDataSize = " + j});
                        break;
                    case 5:
                        i3 = Integer.parseInt(c4752s.m22733b(), 16);
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_TIMEOUT  timeOut = " + i3});
                        break;
                    case 6:
                        i4 = Integer.parseInt(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"CONSULT_FILE_TYPE  fileType = " + i4});
                        break;
                    default:
                        break;
                }
            }
            C5326c.m25761a(str, i, i2, j, i3, i4);
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_CONSULT  error e = " + e});
        }
    }

    private static void m25788a(C4756w c4756w, byte[] bArr, int i) {
        String a = a.a(bArr);
        String str = "";
        try {
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        a = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"SINGLE_FILE_NAME  fileName = " + a});
                        break;
                    default:
                        a = str;
                        break;
                }
                str = a;
            }
            C2538c.c("FileServiceResultUtil", new Object[]{"SINGLE_FILE fileType = " + i});
            if (i == 0) {
                C5326c.m25760a(str);
            } else if (1 == i) {
                C5326c.m25764b(str);
            } else {
                C2538c.c("FileServiceResultUtil", new Object[]{"SINGLE_FILE  fileType Unknown"});
            }
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_GET_INFOR  error e = " + e});
        }
    }

    private static final void m25791c(C4756w c4756w, byte[] bArr) {
        String a = a.a(bArr);
        int i = -1;
        long j = -1;
        String str = "";
        String str2 = "";
        try {
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                String str3;
                long j2;
                int i2;
                long j3;
                long j4;
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        C2538c.c("FileServiceResultUtil", new Object[]{"APPLICATION_APPLY_FILENAME  fileName = " + a.c(c4752s.m22733b())});
                        str3 = str2;
                        str2 = a;
                        a = str3;
                        j2 = j;
                        i2 = i;
                        j3 = j2;
                        break;
                    case 2:
                        C2538c.c("FileServiceResultUtil", new Object[]{"APPLICATION_APPLY_OFFSET  offset = " + Integer.parseInt(c4752s.m22733b(), 16)});
                        str3 = str2;
                        str2 = str;
                        j3 = j;
                        i2 = r0;
                        a = str3;
                        break;
                    case 3:
                        C2538c.c("FileServiceResultUtil", new Object[]{"APPLICATION_APPLY_FILE_LENGTH  fileLength = " + Long.parseLong(c4752s.m22733b(), 16)});
                        a = str2;
                        str2 = str;
                        j4 = j;
                        i2 = i;
                        j3 = j4;
                        break;
                    case 4:
                        a = c4752s.m22733b();
                        C2538c.c("FileServiceResultUtil", new Object[]{"APPLICATION_APPLY_FILE_BITMAP  fileBitmap = " + a});
                        str2 = str;
                        j4 = j;
                        i2 = i;
                        j3 = j4;
                        break;
                    case 127:
                        C2538c.c("FileServiceResultUtil", new Object[]{"APPLICATION_APPLY_FILE_BITMAP  error = " + c4752s.m22733b()});
                        a = str2;
                        str2 = str;
                        j4 = j;
                        i2 = i;
                        j3 = j4;
                        break;
                    default:
                        a = str2;
                        str2 = str;
                        j4 = j;
                        i2 = i;
                        j3 = j4;
                        break;
                }
                str3 = str2;
                str2 = a;
                j2 = j3;
                str = str3;
                i = i2;
                j = j2;
            }
            if (-1 != i && !"".equals(str)) {
                C5324a.m25747a(str, str2, i, j);
            }
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_APPLICATION_DATA_TO_PHONE  error e = " + e});
        }
    }

    private static void m25792d(C4756w c4756w, byte[] bArr) {
        String a = a.a(bArr);
        try {
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        a = a.c(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"TRANSFER_MODULE_CONTENT  object = " + a});
                        break;
                    case 2:
                        a = c4752s.m22733b();
                        C2538c.c("FileServiceResultUtil", new Object[]{"TRANSFER_PSN  object = " + a});
                        break;
                    default:
                        break;
                }
            }
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_GET_INFOR  error e = " + e});
        }
    }

    private static void m25793e(C4756w c4756w, byte[] bArr) {
        String a = a.a(bArr);
        int i = -1;
        try {
            for (C4752s c4752s : c4756w.m22743a(a.substring(4, a.length())).f17337a) {
                int parseInt;
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        parseInt = Integer.parseInt(c4752s.m22733b());
                        C2538c.c("FileServiceResultUtil", new Object[]{"NOTIFICATION_VALIDITY_RESULT  validy = " + parseInt});
                        C5327d.m25786a(parseInt);
                        break;
                    default:
                        parseInt = i;
                        break;
                }
                i = parseInt;
            }
            C5326c.m25784l(i);
        } catch (C4753t e) {
            C2538c.e("FileServiceResultUtil", new Object[]{"getResult() COMMAND_ID_FILE_MANAGER_GET_INFOR  error e = " + e});
        }
    }

    private static void m25786a(int i) {
        Context b = BaseApplication.b();
        String str = "com.huawei.bone.ephemeris.currentState.update.fail";
        if (1 == i) {
            str = "com.huawei.bone.ephemeris.currentState.update.sucess";
        }
        C2538c.c("FileServiceResultUtil", new Object[]{"eph sendBroadcastEphemerisTransferResult  stateCode = " + i + " actionStr = " + str});
        if (b != null) {
            b.sendBroadcast(new Intent(str), com.huawei.hwcommonmodel.b.c.a);
        }
    }
}
