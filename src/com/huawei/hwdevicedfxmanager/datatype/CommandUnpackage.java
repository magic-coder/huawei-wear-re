package com.huawei.hwdevicedfxmanager.datatype;

import android.content.Context;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwservicesmgr.datetype.C5362d;
import com.huawei.hwservicesmgr.datetype.C5363e;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

public class CommandUnpackage {
    private static final int APPLY_OFFSET = 2;
    private static final int COMMAND_HEAD_LENGTH = 6;
    private static final int COMMAND_ID_MAINT_COMMAND_HEAD_LENGTH = 4;
    private static final int ERROR_CODE = 127;
    private static final int ONLINE_PACKET_SEND_SIZE = 19;
    private static final int OTA_APP_WAIT_TIMEOUT = 1;
    private static final int OTA_BATTERY_THRESHOLD = 4;
    private static final int OTA_DEVICE_RESTART_TIMEOUT = 2;
    private static final int OTA_FILE_LENGTH = 2;
    private static final int OTA_FILE_OFFSET = 1;
    private static final int OTA_INTERVAL = 4;
    private static final int OTA_OTA_UNIT_SIZE = 3;
    private static final int OTA_PACKAGE_VALID_SIZE = 1;
    private static final int OTA_RECEIVED_FILE_SIZE = 2;
    private static final String TAG = "CommandUnpackage";
    private static CommandUnpackage unPackageCommand = null;
    private C4756w tlvUtils = new C4756w();

    private CommandUnpackage(Context context) {
    }

    public static CommandUnpackage getInstance(Context context) {
        if (unPackageCommand == null) {
            unPackageCommand = new CommandUnpackage(context);
        }
        return unPackageCommand;
    }

    public int[] getErrorCode(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"Enter getErrorCode()"});
        String a = a.a(bArr);
        int[] unTLVGetErrorCode = unTLVGetErrorCode(this.tlvUtils.m22743a(a.substring(6, a.length())));
        C2538c.a(TAG, new Object[]{"Error Code:" + unTLVGetErrorCode[0]});
        return unTLVGetErrorCode;
    }

    public static int[] unTLVGetErrorCode(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 19:
                    if (iArr.length <= 1) {
                        break;
                    }
                    iArr[1] = Integer.parseInt(b, 16);
                    break;
                case 127:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        return iArr;
    }

    public static int[] unTLVGetRequestFileResponse(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 2:
                    if (iArr.length <= 1) {
                        break;
                    }
                    iArr[1] = Integer.parseInt(b, 16);
                    break;
                case 127:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        return iArr;
    }

    public ArrayList unGetFileName(byte[] bArr) throws Exception {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        C2538c.a(TAG, new Object[]{"unGetFileName enter..."});
        String a = a.a(bArr);
        String[] unTLVFileName = unTLVFileName(this.tlvUtils.m22743a(a.substring(4, a.length())));
        if (unTLVFileName != null) {
            while (i < unTLVFileName.length) {
                arrayList.add(unTLVFileName[i]);
                i++;
            }
        }
        return arrayList;
    }

    public static String[] unTLVFileName(C4754u c4754u) {
        String[] strArr = null;
        List list = c4754u.f17337a;
        int i = 0;
        while (i < list.size()) {
            String[] split;
            String b = ((C4752s) list.get(i)).m22733b();
            if (b != null) {
                split = C0973a.c(b).split(";");
            } else {
                split = strArr;
            }
            i++;
            strArr = split;
        }
        return strArr;
    }

    public List<C5362d> unGetGPSFileName(byte[] bArr) throws Exception {
        C2538c.c(TAG, new Object[]{"unGetGPSFileName enter..."});
        String a = a.a(bArr);
        C2538c.c(TAG, new Object[]{"unGetGPSFileName info = " + a});
        a = a.substring(4, a.length());
        C2538c.c(TAG, new Object[]{"unGetGPSFileName tlvsString = " + a});
        C4754u a2 = this.tlvUtils.m22743a(a);
        C2538c.c(TAG, new Object[]{"unGetGPSFileName tlvFather = " + a2.f17338b.size()});
        C2538c.c(TAG, new Object[]{"unGetGPSFileName tlv = " + a2.f17337a.size()});
        return unTLVGPSFileName(a2);
    }

    public static List<C5362d> unTLVGPSFileName(C4754u c4754u) {
        List<C5362d> arrayList = new ArrayList();
        List list = c4754u.f17338b;
        C2538c.c(TAG, new Object[]{"unGetGPSFileName tlvFathers = " + list.size()});
        for (int i = 0; i < list.size(); i++) {
            List list2 = ((C4754u) list.get(i)).f17338b;
            C2538c.c(TAG, new Object[]{"unGetGPSFileName tlvFatherss = " + list2.size()});
            for (int i2 = 0; i2 < list2.size(); i2++) {
                List list3 = ((C4754u) list2.get(i2)).f17337a;
                C2538c.c(TAG, new Object[]{"unGetGPSFileName tlvs = " + list3.size()});
                C5362d c5362d = new C5362d();
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    String b = ((C4752s) list3.get(i3)).m22733b();
                    C2538c.c(TAG, new Object[]{"unTLVGPSFileName() value = " + b});
                    C2538c.c(TAG, new Object[]{"unTLVGPSFileName() TAG = " + Integer.parseInt(((C4752s) list3.get(i3)).m22732a(), 16)});
                    switch (Integer.parseInt(((C4752s) list3.get(i3)).m22732a(), 16)) {
                        case 9:
                            c5362d.m25827a(Integer.parseInt(b, 16));
                            break;
                        case 10:
                            c5362d.m25827a(Integer.parseInt(b, 16));
                            break;
                        case 13:
                            if (b == null) {
                                break;
                            }
                            String c = C0973a.c(b);
                            c.c(TAG, new Object[]{"unTLVGPSFileName() nameListsStr = " + c});
                            c5362d.m25828a(c);
                            arrayList.add(c5362d);
                            break;
                        case 14:
                            c5362d.m25830b(Integer.parseInt(b, 16));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return arrayList;
    }

    public DataMaintParameters unGetMaintParameters(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"unGetMaintenanceParameters enter..."});
        String a = a.a(bArr);
        return unGetMaintParameters(this.tlvUtils.m22743a(a.substring(4, a.length())));
    }

    public static DataMaintParameters unGetMaintParameters(C4754u c4754u) {
        DataMaintParameters dataMaintParameters = new DataMaintParameters();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 1:
                        dataMaintParameters.setFile_protocal_version(C0973a.c(b));
                        break;
                    case 2:
                        boolean z = false;
                        if (1 == Integer.parseInt(b, 16)) {
                            z = true;
                        }
                        dataMaintParameters.setTransfer_bitmap_enable(z);
                        break;
                    case 3:
                        dataMaintParameters.setTransfer_unit_size(Integer.parseInt(b, 16));
                        break;
                    case 4:
                        dataMaintParameters.setMax_apply_data_size(Integer.parseInt(b, 16));
                        break;
                    case 5:
                        dataMaintParameters.setTimeout(Integer.parseInt(b, 16));
                        break;
                    default:
                        break;
                }
            }
        }
        return dataMaintParameters;
    }

    public DataMaintFileInformation unQueryFileInformation(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"unQueryFileInformation enter..."});
        String a = a.a(bArr);
        C4754u a2 = this.tlvUtils.m22743a(a.substring(4, a.length()));
        C2538c.a(TAG, new Object[]{"unQueryFileInformation  support_response = "});
        return unQueryFileInformation(a2);
    }

    public static DataMaintFileInformation unQueryFileInformation(C4754u c4754u) {
        DataMaintFileInformation dataMaintFileInformation = new DataMaintFileInformation();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 2:
                        dataMaintFileInformation.setFileSize(Long.parseLong(b, 16));
                        break;
                    case 3:
                        dataMaintFileInformation.setFileCrc(Long.parseLong(b, 16));
                        break;
                    default:
                        break;
                }
            }
        }
        return dataMaintFileInformation;
    }

    public int[] getAckCode(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"Enter getAckCode()"});
        String a = a.a(bArr);
        int[] unTLVGetErrorCode = unTLVGetErrorCode(this.tlvUtils.m22743a(a.substring(4, a.length())));
        C2538c.a(TAG, new Object[]{"Error Code:" + unTLVGetErrorCode[0]});
        return unTLVGetErrorCode;
    }

    public int[] getAckCodeExt(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"Enter getAckCodeExt()"});
        String a = a.a(bArr);
        int[] unTLVGetRequestFileResponse = unTLVGetRequestFileResponse(this.tlvUtils.m22743a(a.substring(4, a.length())));
        if (unTLVGetRequestFileResponse.length > 1) {
            C2538c.a(TAG, new Object[]{"getAckCodeExt Error Code:" + unTLVGetRequestFileResponse[0] + "  apply offset = " + unTLVGetRequestFileResponse[1]});
        }
        return unTLVGetRequestFileResponse;
    }

    public C5363e unGPSApplyDataFromDevice(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"unGPSApplyDataFromDevice enter... data.length = " + bArr.length});
        C5363e c5363e = new C5363e();
        String a = a.a(bArr);
        if (bArr.length >= 4) {
            return unGPSApplyData(a.substring(4, a.length()));
        }
        return c5363e;
    }

    private C5363e unGPSApplyData(String str) {
        C2538c.a(TAG, new Object[]{"unGPSApplyData ,hexString.length() =  " + str.length()});
        C5363e c5363e = new C5363e();
        int parseInt = Integer.parseInt(str.substring(0, 2), 16);
        String substring = str.substring(2, str.length());
        C2538c.a(TAG, new Object[]{"unGPSApplyData ,index = " + parseInt});
        C2538c.a(TAG, new Object[]{"unGPSApplyData ,value = " + substring});
        c5363e.m25833a(parseInt);
        c5363e.m25834a(C0973a.b(substring));
        return c5363e;
    }

    public FileTransferActiveReport unApplyDataFromDevice(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"AckAndFileTransferActiveReport enter... data.length = " + bArr.length});
        FileTransferActiveReport fileTransferActiveReport = new FileTransferActiveReport();
        String a = a.a(bArr);
        if (bArr.length >= 4) {
            return unApplyData(a.substring(4, a.length()));
        }
        return fileTransferActiveReport;
    }

    private FileTransferActiveReport unApplyData(String str) {
        C2538c.a(TAG, new Object[]{"unApplyData ,hexString.length() =  " + str.length()});
        FileTransferActiveReport fileTransferActiveReport = new FileTransferActiveReport();
        int parseInt = Integer.parseInt(str.substring(0, 2), 16);
        String substring = str.substring(2, str.length());
        C2538c.a(TAG, new Object[]{"unApplyData ,index = " + parseInt});
        C2538c.a(TAG, new Object[]{"unApplyData ,value = " + substring});
        fileTransferActiveReport.setIndex(parseInt);
        fileTransferActiveReport.setValue(substring);
        return fileTransferActiveReport;
    }

    public String[] unFileValidityResult(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"Enter unFileValidityResult()"});
        String a = a.a(bArr);
        return unTLVFileValidityResult(this.tlvUtils.m22743a(a.substring(4, a.length())));
    }

    private String[] unTLVFileValidityResult(C4754u c4754u) {
        String[] strArr = new String[2];
        List list = c4754u.f17337a;
        for (int i = 0; i < list.size(); i++) {
            int parseInt = Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16);
            String b = ((C4752s) list.get(i)).m22733b();
            switch (parseInt) {
                case 6:
                    strArr[1] = C0973a.c(b);
                    break;
                case 127:
                    strArr[0] = Integer.parseInt(b, 16) + "";
                    break;
                default:
                    break;
            }
        }
        return strArr;
    }

    public int setMaintLogRule(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"5.10.7 unLogRule Enter ... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return unLogRule(this.tlvUtils.m22743a(a.substring(4, a.length())));
    }

    public int unLogRule(C4754u c4754u) {
        C2538c.a(TAG, new Object[]{"5.9.7 unLogRule enter.. "});
        int parseInt = Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16);
        C2538c.a(TAG, new Object[]{"unLogRule :" + parseInt});
        return parseInt;
    }

    public int setMaintResearchSwitch(byte[] bArr) throws Exception {
        C2538c.a(TAG, new Object[]{"5.10.8unResearchSwitch Enter ... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return unResearchSwitch(this.tlvUtils.m22743a(a.substring(4, a.length())));
    }

    public int unResearchSwitch(C4754u c4754u) {
        C2538c.a(TAG, new Object[]{"5.10.8 unResearchSwitch enter.. "});
        int parseInt = Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16);
        C2538c.a(TAG, new Object[]{"unResearchSwitch :" + parseInt});
        return parseInt;
    }
}
