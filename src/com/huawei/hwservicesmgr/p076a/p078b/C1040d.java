package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwdevicedfxmanager.datatype.CommandUnpackage;
import com.huawei.hwdevicedfxmanager.datatype.DataMaintFileInformation;
import com.huawei.hwdevicedfxmanager.datatype.DataMaintParameters;
import com.huawei.hwdevicedfxmanager.datatype.FileTransferActiveReport;
import com.huawei.hwdevicedfxmanager.utils.DetailGPSWorkoutUtil;
import com.huawei.hwdevicedfxmanager.utils.DetailSleepUtil;
import com.huawei.hwdevicedfxmanager.utils.MaintenaceInterface;
import com.huawei.hwdevicedfxmanager.utils.MaintenanceUtil;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.a.b.e;
import com.huawei.hwservicesmgr.a.b.f;
import com.huawei.hwservicesmgr.a.b.g;
import com.huawei.hwservicesmgr.a.b.h;
import com.huawei.hwservicesmgr.a.b.i;
import com.huawei.hwservicesmgr.a.b.j;
import com.huawei.hwservicesmgr.a.b.k;
import com.huawei.hwservicesmgr.a.b.l;
import com.huawei.hwservicesmgr.a.b.m;
import com.huawei.hwservicesmgr.a.b.n;
import com.huawei.hwservicesmgr.a.b.o;
import com.huawei.hwservicesmgr.datetype.d;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: HWFileTransferTaskManager */
public class C1040d implements IParser {
    private static C1040d f1980a;
    private int f1981A = 5000;
    private DataMaintParameters f1982B = null;
    private String f1983C = "";
    private String f1984D = "";
    private int f1985E = -1;
    private int f1986F = 1;
    private int f1987G = 0;
    private List<Integer> f1988H;
    private int f1989I;
    private int f1990J;
    private int f1991K = 244;
    private int f1992L = -1;
    private int f1993M = 0;
    private int f1994N = 0;
    private int f1995O = 0;
    private int f1996P = -1;
    private boolean f1997Q = false;
    private IBaseResponseCallback f1998R = new e(this);
    private IBaseResponseCallback f1999S = new f(this);
    private IBaseResponseCallback f2000T = new m(this);
    private CommandUnpackage f2001b = CommandUnpackage.getInstance(BaseApplication.m2632b());
    private IBaseResponseCallback f2002c;
    private TransferFileInfo f2003d;
    private SparseArray<Handler> f2004e = new SparseArray();
    private Handler f2005f = null;
    private List<d> f2006g = new ArrayList();
    private ArrayList f2007h = null;
    private String f2008i = null;
    private int f2009j;
    private DetailGPSWorkoutUtil f2010k = null;
    private MaintenaceInterface f2011l = null;
    private int f2012m = 0;
    private Map<Integer, Map<Long, double[]>> f2013n = new HashMap();
    private Map<Integer, Integer> f2014o = new HashMap();
    private ArrayList<byte[]> f2015p = new ArrayList();
    private int f2016q = 2440;
    private int f2017r = 732;
    private int f2018s = 0;
    private int f2019t = 0;
    private int f2020u = 0;
    private long f2021v;
    private boolean f2022w = false;
    private String f2023x = "All file:";
    private String f2024y = "Done file:";
    private Date f2025z = new Date();

    public static C1040d m4273a() {
        if (f1980a == null) {
            f1980a = new C1040d();
        }
        return f1980a;
    }

    private C1040d() {
        this.f2004e.put(0, new o(this, null));
        this.f2004e.put(1, new n(this, null));
    }

    private void m4275a(int i) {
        this.f2005f = (Handler) this.f2004e.get(i);
        C2538c.m12677c("HWFileTransferTaskManager", "修改状态机状态为：" + i + " ||STATE_GPS = 0 STATE_SLEEP_DFX = 1");
    }

    public void m4337a(TransferFileInfo transferFileInfo, IBaseResponseCallback iBaseResponseCallback) {
        if (this.f2022w) {
            C2538c.m12674b("HWFileTransferTaskManager", "startMainteFile isMainting, so return!");
            return;
        }
        this.f1997Q = false;
        this.f2002c = iBaseResponseCallback;
        this.f2003d = transferFileInfo;
        this.f2022w = true;
        PhoneService.m4195a(1014);
        if (1 == transferFileInfo.getType()) {
            this.f2013n.clear();
            this.f2014o.clear();
            m4275a(0);
            C2538c.m12677c("HWFileTransferTaskManager", "请求GPS");
            this.f2010k = DetailGPSWorkoutUtil.getMainInstance();
            C1023c.m3920a(BaseApplication.m2632b()).m3986a(this.f1998R);
            this.f1988H = transferFileInfo.getRecordId();
            this.f1989I = transferFileInfo.getGpsType();
            this.f1990J = 0;
            if (this.f1988H == null || this.f1988H.size() == 0) {
                C2538c.m12677c("HWFileTransferTaskManager", "recordId.size = 0");
                this.f2005f.sendEmptyMessage(16);
                return;
            }
            m4276a(((Integer) this.f1988H.get(this.f1990J)).intValue(), this.f1989I);
        } else if (transferFileInfo.getType() == 0) {
            m4275a(1);
            C2538c.m12677c("HWFileTransferTaskManager", "请求可维可测 transferFileInfo.getDeviceMac() = " + transferFileInfo.getDeviceMac() + " , transferFileInfo.getDeviceVersion() = " + transferFileInfo.getDeviceVersion());
            this.f1986F = 1;
            this.f1983C = transferFileInfo.getDeviceMac();
            this.f1984D = transferFileInfo.getDeviceVersion();
            this.f1985E = transferFileInfo.getDeviceType();
            if (TextUtils.isEmpty(this.f1983C) || TextUtils.isEmpty(this.f1984D)) {
                C2538c.m12680e("HWFileTransferTaskManager", "请求可维可测 ,parameter is error!!!");
                m4343e();
                this.f2002c.onResponse(10001, " parameter is error");
                return;
            }
            this.f2011l = MaintenanceUtil.getMainInstance();
            C2538c.m12677c("HWFileTransferTaskManager", "手表可维可测  注册回调");
            C1023c.m3920a(BaseApplication.m2632b()).m3986a(this.f1999S);
            m4289b(transferFileInfo.getDfxLogType());
        } else if (2 == transferFileInfo.getType() || 3 == transferFileInfo.getType()) {
            m4275a(1);
            this.f2011l = DetailSleepUtil.getMainInstance();
            C1023c.m3920a(BaseApplication.m2632b()).m3986a(this.f1999S);
            C2538c.m12677c("HWFileTransferTaskManager", "请求精细化睡眠 transferFileInfo.getStartTime() = " + transferFileInfo.getStartTime() + " ,transferFileInfo.getEndTime() = " + transferFileInfo.getEndTime());
            this.f2011l.setMaintRetryResult(true);
            C2538c.m12677c("HWFileTransferTaskManager", "start new transfer, 恢复path和content为null.");
            m4290b(transferFileInfo.getStartTime(), transferFileInfo.getEndTime());
        } else {
            C2538c.m12677c("HWFileTransferTaskManager", "请求类型错误 transferFileInfo.getType() = " + transferFileInfo.getType());
            m4342d();
            m4343e();
            this.f2002c.onResponse(10001, " type not found");
        }
    }

    private void m4276a(int i, int i2) {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(1);
        String str = C0973a.m3506a(2) + C0973a.m3506a(1) + C0973a.m3506a(2);
        String str2 = C0973a.m3506a(7) + C0973a.m3506a(1) + C0973a.m3506a(i2);
        StringBuilder stringBuilder = new StringBuilder();
        String b = C0973a.m3510b(i);
        stringBuilder.append(C0973a.m3506a(9) + C0973a.m3506a(b.length() / 2) + b);
        b = C0973a.m3506a((int) SyslogAppender.LOG_LOCAL1) + C0973a.m3517e(stringBuilder.toString().length() / 2);
        byte[] b2 = C0973a.m3512b(str + (C0973a.m3506a(134) + C0973a.m3517e(((str2.length() + b.length()) + stringBuilder.toString().length()) / 2)) + str2 + b + stringBuilder.toString());
        deviceCommand.setDataLen(b2.length);
        deviceCommand.setDataContent(b2);
        m4279a(deviceCommand);
    }

    private void m4283a(Object obj) {
        try {
            List list = (List) obj;
            C2538c.m12680e("HWFileTransferTaskManager", "getMaintFileNameHandle() getMaintFileNameHandle");
            if (list == null) {
                m4342d();
                if (this.f2002c != null) {
                    this.f2002c.onResponse(10001, "error ,filelist is null");
                    return;
                }
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                this.f2023x += ((d) list.get(i)).b();
                this.f2006g.add(list.get(i));
            }
            C2538c.m12680e("HWFileTransferTaskManager", "getMaintFileNameHandle() allFileListName " + this.f2023x);
            if (list.size() == 0) {
                C2538c.m12680e("HWFileTransferTaskManager", "getMaintFileNameHandle fileList() = 0");
                m4342d();
                if (this.f2002c != null) {
                    this.f2002c.onResponse(10001, m4327k());
                }
            } else if (this.f1990J + 1 < this.f1988H.size()) {
                this.f1990J++;
                m4276a(((Integer) this.f1988H.get(this.f1990J)).intValue(), this.f1989I);
            } else {
                C2538c.m12680e("HWFileTransferTaskManager", "Enter getMaintParameters()");
                m4312g();
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---getMaintFileNameHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4290b(int i, int i2) {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(1);
        String str = C0973a.m3506a(2) + C0973a.m3506a(1) + C0973a.m3506a(1);
        String a = C0973a.m3507a((long) i);
        a = C0973a.m3506a(4) + C0973a.m3506a(a.length() / 2) + a;
        int length = a.length() / 2;
        String a2 = C0973a.m3507a((long) i2);
        a2 = C0973a.m3506a(5) + C0973a.m3506a(a2.length() / 2) + a2;
        a = str + (C0973a.m3506a(131) + C0973a.m3506a(length + (a2.length() / 2))) + a + a2;
        deviceCommand.setDataContent(C0973a.m3512b(a));
        deviceCommand.setDataLen(C0973a.m3512b(a).length);
        C2538c.m12677c("HWFileTransferTaskManager", "getDetailSleepFileName 5.10.1 deviceCommand = " + str);
        m4279a(deviceCommand);
    }

    private void m4294b(Object obj) {
        try {
            this.f2007h = (ArrayList) obj;
            if (this.f2007h != null) {
                C2538c.m12677c("HWFileTransferTaskManager", "getMaintSleepOrDFXFileNameHandle() fileList " + this.f2007h);
                if (this.f1986F != 0) {
                    this.f2007h = this.f2011l.filtertFile(this.f2007h, this.f1986F);
                }
                if (this.f1997Q) {
                    this.f2023x += this.f2007h;
                    C2538c.m12680e("HWFileTransferTaskManager", "getMaintSleepOrDFXFileNameHandle() allFileListName " + this.f2023x);
                } else {
                    this.f2023x += this.f2007h;
                    C2538c.m12680e("HWFileTransferTaskManager", "getMaintSleepOrDFXFileNameHandle() allFileListName " + this.f2023x);
                }
                if (this.f2007h.size() == 0) {
                    C2538c.m12680e("HWFileTransferTaskManager", "getMaintSleepOrDFXFileNameHandle fileList() = 0");
                    m4343e();
                    if (this.f2002c != null) {
                        this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                        this.f2002c.onResponse(10000, m4327k());
                        return;
                    }
                    return;
                }
                C2538c.m12677c("HWFileTransferTaskManager", "getMaintSleepOrDFXFileNameHandle go getMaintSleepOrDFXParameters()");
                m4316h();
            } else if (this.f2002c != null) {
                m4343e();
                this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                if (this.f2011l instanceof DetailSleepUtil) {
                    this.f2011l.setMaintRetryResult(true);
                }
                this.f2002c.onResponse(10001, "error ,filelist is null");
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---getMaintSleepOrDFXFileNameHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4289b(int i) {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(1);
        if (i != 0) {
            String str = C0973a.m3506a(15) + C0973a.m3506a(2) + C0973a.m3506a(i);
            deviceCommand.setDataContent(C0973a.m3512b(str));
            deviceCommand.setDataLen(C0973a.m3512b(str).length);
        }
        C2538c.m12677c("HWFileTransferTaskManager", "getFileName  deviceCommand = " + deviceCommand.toString());
        m4279a(deviceCommand);
    }

    private void m4312g() {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(2);
        String str = C0973a.m3506a(6) + C0973a.m3506a(1) + C0973a.m3506a(2);
        byte[] b = C0973a.m3512b(str + (C0973a.m3506a(7) + C0973a.m3506a(1) + C0973a.m3506a(3)));
        deviceCommand.setDataContent(b);
        deviceCommand.setDataLen(b.length);
        m4279a(deviceCommand);
    }

    private void m4301c(Object obj) {
        try {
            this.f1982B = (DataMaintParameters) obj;
            this.f1981A = this.f1982B.getTimeout();
            if (this.f1981A == 0) {
                this.f1981A = 5000;
            }
            this.f1991K = this.f1982B.getTransfer_unit_size();
            this.f2017r = this.f1982B.getMax_apply_data_size();
            if (this.f2017r == 0) {
                this.f2017r = 732;
            }
            this.f2016q = this.f2017r;
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintenanceParameters() ok, protocalVersion = " + this.f1982B.getFile_protocal_version());
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintenanceParameters() ok, transferUnitSize = " + this.f1991K);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintenanceParameters() ok, maxApplyDataSize" + this.f2017r);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintenanceParameters() ok, waitTimeout= " + this.f1981A);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintenanceParameters() ok, breakPointEnable = " + this.f1982B.getTransfer_bitmap_enable());
            if (this.f2005f != null) {
                this.f2005f.sendEmptyMessage(10);
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---getMaintParametersHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4316h() {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        if (this.f2011l != null) {
            C2538c.m12677c("HWFileTransferTaskManager", "getMaintSleepOrDFXParameters 5.10.2 deviceCommand = " + C0973a.m3509a(this.f2011l.maintParametersCommand().getDataContent()));
            m4279a(r0);
        }
    }

    private void m4304d(Object obj) {
        try {
            this.f1982B = (DataMaintParameters) obj;
            this.f1981A = this.f1982B.getTimeout();
            this.f1991K = this.f1982B.getTransfer_unit_size();
            if (this.f2011l instanceof MaintenanceUtil) {
                this.f2016q = this.f2017r;
            } else {
                this.f2017r = this.f1982B.getMax_apply_data_size();
            }
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintSleepOrDFXParametersHandle() ok, protocalVersion = " + this.f1982B.getFile_protocal_version());
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintSleepOrDFXParametersHandle() ok, transferUnitSize = " + this.f1991K);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintSleepOrDFXParametersHandle() ok, maxApplyDataSize = " + this.f2017r);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintSleepOrDFXParametersHandle() ok, waitTimeout = " + this.f1981A);
            C2538c.m12680e("HWFileTransferTaskManager", " getMaintSleepOrDFXParametersHandle() ok, breakPointEnable = " + this.f1982B.getTransfer_bitmap_enable());
            if (this.f2005f != null) {
                this.f2011l.deleteTenDayFile();
                this.f2011l.initMaintenanceParame(this.f1985E, this.f1983C, this.f1984D);
                this.f2005f.sendEmptyMessage(10);
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---getMaintSleepOrDFXParametersHandle Exception---e = " + e.getMessage());
            m4343e();
            if (this.f2002c != null) {
                this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                this.f2002c.onResponse(10000, m4327k());
            }
        }
    }

    private void m4285a(String str) {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        m4324j();
        this.f1993M = 0;
        String e = C0973a.m3518e(str);
        e = C0973a.m3506a(1) + C0973a.m3506a(e.length() / 2) + e;
        C2538c.m12677c("HWFileTransferTaskManager", "5.10.3 queryFileInformation : " + e);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(3);
        deviceCommand.setDataContent(C0973a.m3512b(e));
        deviceCommand.setDataLen(C0973a.m3512b(e).length);
        m4279a(deviceCommand);
    }

    private void m4307e(Object obj) {
        try {
            DataMaintFileInformation dataMaintFileInformation = (DataMaintFileInformation) obj;
            this.f2018s = (int) dataMaintFileInformation.getFileSize();
            this.f2021v = dataMaintFileInformation.getFileCrc();
            C2538c.m12677c("HWFileTransferTaskManager", " queryFileInformationHandle() ok, fileTotalSize = " + this.f2018s + ", fileCrc = " + this.f2021v);
            if (this.f2018s == 0) {
                if (this.f2006g != null && this.f2006g.size() > 0) {
                    this.f2006g.remove(0);
                }
                if (this.f2005f != null) {
                    this.f2005f.sendEmptyMessage(10);
                    return;
                }
                return;
            }
            this.f2025z = new Date();
            m4339b();
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---queryFileInformationHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4295b(String str) {
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        m4324j();
        this.f1993M = 0;
        String e = C0973a.m3518e(str);
        e = C0973a.m3506a(1) + C0973a.m3506a(e.length() / 2) + e;
        C2538c.m12677c("HWFileTransferTaskManager", "querySleepOrDFXFileInformation 5.10.3  deviceCommand : " + e);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(3);
        deviceCommand.setDataContent(C0973a.m3512b(e));
        deviceCommand.setDataLen(C0973a.m3512b(e).length);
        C2538c.m12677c("HWFileTransferTaskManager", "querySleepOrDFXFileInformation  deviceCommand = " + C0973a.m3509a(deviceCommand.getDataContent()));
        m4279a(deviceCommand);
    }

    private void m4310f(Object obj) {
        try {
            DataMaintFileInformation dataMaintFileInformation = (DataMaintFileInformation) obj;
            this.f2018s = (int) dataMaintFileInformation.getFileSize();
            this.f2021v = dataMaintFileInformation.getFileCrc();
            C2538c.m12677c("HWFileTransferTaskManager", " querySleepOrDFXFileInformationHandle() ok, fileTotalSize = " + this.f2018s + ", fileCrc = " + this.f2021v);
            if (this.f2018s == 0) {
                if (this.f2007h != null && this.f2007h.size() > 0) {
                    this.f2007h.remove(0);
                }
                if (this.f2005f != null) {
                    this.f2005f.sendEmptyMessage(10);
                    return;
                }
                return;
            }
            this.f2025z = new Date();
            m4341c();
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---querySleepOrDFXFileInformationHandle Exception---e = " + e.getMessage());
        }
    }

    public void m4338a(String str, int i, int i2, String str2) {
        this.f1996P = 0;
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        String e = C0973a.m3518e(str);
        e = C0973a.m3506a(1) + C0973a.m3506a(e.length() / 2) + e;
        String str3 = C0973a.m3506a(2) + C0973a.m3506a(4) + C0973a.m3507a((long) i);
        String str4 = C0973a.m3506a(3) + C0973a.m3506a(4) + C0973a.m3507a((long) i2);
        String file_protocal_version = this.f1982B.getFile_protocal_version();
        C2538c.m12677c("HWFileTransferTaskManager", "5.10.4 version : " + file_protocal_version);
        if (file_protocal_version == null) {
            e = e + str3 + str4;
        } else if (!file_protocal_version.contains("AW")) {
            e = e + str3 + str4;
        }
        C2538c.m12677c("HWFileTransferTaskManager", "5.10.4 applyDataFromDevice : " + e);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(4);
        deviceCommand.setDataContent(C0973a.m3512b(e));
        deviceCommand.setDataLen(C0973a.m3512b(e).length);
        m4279a(deviceCommand);
    }

    private void m4314g(Object obj) {
        try {
            C2538c.m12680e("HWFileTransferTaskManager", "---applyDataHandle is[0] = " + ((int[]) obj)[0]);
            if (100000 == ((int[]) obj)[0]) {
                this.f1993M = 0;
                if (this.f2005f != null) {
                    this.f2005f.removeMessages(7);
                    this.f2005f.sendEmptyMessageDelayed(7, (long) this.f1981A);
                    return;
                }
                return;
            }
            m4342d();
            if (this.f2002c != null) {
                this.f2002c.onResponse(10002, m4327k());
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---errorCodeHandle Exception---e = " + e.getMessage());
        }
    }

    public void m4340b(String str, int i, int i2, String str2) {
        this.f1996P = 1;
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
            this.f2005f.sendEmptyMessageDelayed(15, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        this.f1995O = i;
        String e = C0973a.m3518e(str);
        e = C0973a.m3506a(1) + C0973a.m3506a(e.length() / 2) + e;
        String str3 = C0973a.m3506a(2) + C0973a.m3506a(4) + C0973a.m3507a((long) i);
        String str4 = C0973a.m3506a(3) + C0973a.m3506a(4) + C0973a.m3507a((long) i2);
        String file_protocal_version = this.f1982B.getFile_protocal_version();
        if (file_protocal_version != null) {
            C2538c.m12677c("HWFileTransferTaskManager", "applySleepOrDFXDataFromDevice 5.10.4  version : " + file_protocal_version);
            if (!file_protocal_version.contains("AW")) {
                e = e + str3 + str4;
            }
        } else {
            e = e + str3 + str4;
        }
        C2538c.m12677c("HWFileTransferTaskManager", "applySleepOrDFXDataFromDevice 5.10.4  commandHex: " + e);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(4);
        deviceCommand.setDataContent(C0973a.m3512b(e));
        deviceCommand.setDataLen(C0973a.m3512b(e).length);
        C2538c.m12677c("HWFileTransferTaskManager", "applySleepOrDFXDataFromDevice  deviceCommand = " + C0973a.m3509a(deviceCommand.getDataContent()));
        m4279a(deviceCommand);
    }

    private void m4318h(Object obj) {
        try {
            int[] iArr = (int[]) obj;
            int i = -1;
            int i2 = this.f1995O;
            if (iArr.length > 0) {
                i = iArr[0];
            }
            if (iArr.length > 1) {
                i2 = iArr[1];
            }
            if (this.f2011l instanceof MaintenanceUtil) {
                C2538c.m12677c("HWFileTransferTaskManager", "applySleepOrDFXDataHandle maintenanceSleepOrDFXUtil is MaintenanceUtil !");
                i2 = this.f1995O;
            }
            C2538c.m12677c("HWFileTransferTaskManager", "---applySleepOrDFXDataHandle is[0] = " + i + " is[1] = " + i2 + " requestApplyOffset = " + this.f1995O);
            if (100000 != i) {
                m4343e();
                if (this.f2002c != null) {
                    this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                    if (this.f2011l instanceof DetailSleepUtil) {
                        this.f2011l.setMaintRetryResult(true);
                    }
                    this.f2002c.onResponse(10002, m4327k());
                }
            } else if (i2 == this.f1995O) {
                this.f1992L = 0;
                this.f2020u = 0;
                this.f1994N = this.f2019t;
                this.f2015p.clear();
                if (this.f2005f != null) {
                    this.f2005f.removeMessages(15);
                    this.f2005f.removeMessages(7);
                    this.f2005f.sendEmptyMessageDelayed(7, (long) this.f1981A);
                }
            } else {
                C2538c.m12677c("HWFileTransferTaskManager", "applySleepOrDFXDataHandle responseApplyOffset != requestApplyOffset throw error package !!!");
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---applySleepOrDFXDataHandle errorCodeHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4284a(Object obj, int i) {
        try {
            com.huawei.hwservicesmgr.datetype.e eVar = (com.huawei.hwservicesmgr.datetype.e) obj;
            if (eVar != null) {
                C2538c.m12677c("HWFileTransferTaskManager", "applyDataFromDeviceHandle() maintLog" + eVar);
                C2538c.m12674b("HWFileTransferTaskManager", "applyDataFromDeviceHandle() index" + eVar.a());
                if (1 != i) {
                    m4277a(i, eVar);
                    return;
                } else {
                    m4293b(eVar);
                    return;
                }
            }
            C2538c.m12680e("HWFileTransferTaskManager", "null != maintLog");
        } catch (Exception e) {
            m4342d();
            if (this.f2002c != null) {
                this.f2002c.onResponse(10002, m4327k());
            }
            C2538c.m12680e("HWFileTransferTaskManager", "---queryOtaAllowHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4277a(int i, com.huawei.hwservicesmgr.datetype.e eVar) {
        if (8 == eVar.b().length && TagName.ELECTRONIC_PUBLISH_START_TIME == eVar.b()[2] && (byte) 10 == eVar.b()[0] && (byte) 5 == eVar.b()[1] && (byte) 4 == eVar.b()[3]) {
            m4324j();
            this.f2012m = 0;
            this.f2023x = "All file:";
            this.f2024y = "Done file:";
            this.f1987G++;
            C2538c.m12674b("HWFileTransferTaskManager", "applyDataFromDeviceHandle() sendNum = " + this.f1987G);
            if (4 == this.f1987G) {
                m4342d();
                this.f2002c.onResponse(10001, eVar.b());
                this.f1987G = 0;
                return;
            }
            m4276a(((Integer) this.f1988H.get(this.f1990J)).intValue(), i);
            return;
        }
        m4282a(eVar);
    }

    private void m4322i(Object obj) {
        try {
            FileTransferActiveReport fileTransferActiveReport = (FileTransferActiveReport) obj;
            if (fileTransferActiveReport != null) {
                m4278a(fileTransferActiveReport);
                return;
            }
            C2538c.m12680e("HWFileTransferTaskManager", "null != maintLog");
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---queryOtaAllowHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4320i() {
        if (this.f1996P == 0) {
            C2538c.m12677c("HWFileTransferTaskManager", "transfer next file.");
            this.f2005f.sendEmptyMessage(10);
        }
        String str = C0973a.m3506a(1) + C0973a.m3506a(1) + C0973a.m3506a(1);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(6);
        deviceCommand.setDataContent(C0973a.m3512b(str));
        deviceCommand.setDataLen(C0973a.m3512b(str).length);
        m4279a(deviceCommand);
    }

    private void m4282a(com.huawei.hwservicesmgr.datetype.e eVar) {
        int i;
        if (eVar.a() == this.f1993M) {
            byte[] b = eVar.b();
            this.f2020u += b.length;
            C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List() fileType = " + this.f2009j);
            if (1 != this.f2009j) {
                this.f2015p.add(b);
                C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List() valueByte = " + C0973a.m3509a(b));
            } else {
                try {
                    this.f2015p.add(C0973a.m3509a(b).getBytes(GameManager.DEFAULT_CHARSET));
                    C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List() bytes = " + C0973a.m3509a(r0));
                } catch (UnsupportedEncodingException e) {
                    C2538c.m12674b("HWFileTransferTaskManager", "exception  is " + e.getMessage());
                }
            }
            this.f2019t += b.length;
            this.f1993M++;
        } else {
            C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List() lost index = " + eVar.a());
            if (this.f2019t - this.f2020u >= 0 && this.f2020u != 0) {
                this.f2019t -= this.f2020u;
                this.f1993M = 0;
                this.f2015p = (ArrayList) this.f2015p.subList(0, this.f2019t);
            }
        }
        C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List() donePackatgeSize = " + this.f2020u + ",currentFrameNum" + this.f1993M + ",index " + i);
        String file_protocal_version = this.f1982B.getFile_protocal_version();
        boolean z;
        if (file_protocal_version == null) {
            z = false;
        } else {
            z = file_protocal_version.contains("AW");
        }
        if (this.f2005f == null) {
            return;
        }
        if (this.f2016q == this.f2020u || r0) {
            this.f2012m = 0;
            this.f2020u = 0;
            C2538c.m12677c("HWFileTransferTaskManager", "send ok writeLogToFile fileName = " + this.f2008i + "+maintLogs = " + this.f2015p.size() + ",doneTotalSize = " + this.f2019t + ",+fileTotalSize = " + this.f2018s);
            if (this.f2019t >= this.f2018s) {
                this.f2005f.removeMessages(7);
                C2538c.m12677c("HWFileTransferTaskManager", "send ok fileCrc = " + this.f2021v);
                this.f2024y += this.f2008i + ",";
                if (this.f2006g != null && this.f2006g.size() > 0) {
                    int i2 = 0;
                    for (i = 0; i < this.f2015p.size(); i++) {
                        i2 += ((byte[]) this.f2015p.get(i)).length;
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(i2);
                    for (i = 0; i < this.f2015p.size(); i++) {
                        allocate.put((byte[]) this.f2015p.get(i));
                    }
                    C2538c.m12677c("HWFileTransferTaskManager", "addPlayData2List()!,mapType=" + this.f2010k.getGPSMapType(allocate.array()));
                    this.f2014o.put(Integer.valueOf(((d) this.f2006g.get(0)).a()), Integer.valueOf(i));
                    this.f2013n.put(Integer.valueOf(((d) this.f2006g.get(0)).a()), this.f2010k.getGPSMap(allocate.array(), this.f2009j));
                    this.f2015p.clear();
                    this.f2006g.remove(0);
                    this.f1993M = 0;
                }
                m4320i();
                return;
            }
            m4339b();
        }
    }

    private void m4278a(FileTransferActiveReport fileTransferActiveReport) {
        if (fileTransferActiveReport.getIndex() == this.f1992L) {
            byte[] b = C0973a.m3512b(fileTransferActiveReport.getValue());
            this.f2020u += b.length;
            this.f2015p.add(b);
            this.f1994N += b.length;
            this.f1992L++;
            C2538c.m12677c("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List() valueByte = " + C0973a.m3509a(b));
        } else {
            C2538c.m12677c("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List() lost  index = " + fileTransferActiveReport.getIndex());
        }
        C2538c.m12674b("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List() currentApplyDataSize =" + this.f2016q + ",+donePackatgeSize = " + this.f2020u + ",currentSleepOrDFXFrameNum = " + this.f1992L + ",index = " + r0);
        if (this.f2016q == this.f2020u) {
            this.f2012m = 0;
            this.f2020u = 0;
            if (this.f2005f != null) {
                this.f2005f.removeMessages(7);
                this.f2019t = this.f1994N;
                if (this.f2011l != null) {
                    this.f2011l.writeLogToFile(this.f2015p, this.f2008i, this.f2025z);
                }
                C2538c.m12677c("HWFileTransferTaskManager", "***addSleepOrDFXPlayData2List() send ok writeLogToFile fileName = " + this.f2008i + ",maintLogs = " + this.f2015p.size() + ",doneTotalSize = " + this.f2019t + ",+fileTotalSize = " + this.f2018s);
                this.f2015p.clear();
                if (this.f2018s <= 0) {
                    C2538c.m12677c("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List() lost  package error!!!!!!");
                    m4343e();
                    if (this.f2002c != null) {
                        if (this.f2011l != null) {
                            this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                        }
                        if (this.f2011l instanceof DetailSleepUtil) {
                            this.f2011l.setMaintRetryResult(true);
                        }
                        this.f2002c.onResponse(10002, "package error");
                        return;
                    }
                    return;
                }
                C2538c.m12677c("HWFileTransferTaskManager", "***addSleepOrDFXPlayData2List() send ok  doneTotalSize = " + this.f2019t + ",+fileTotalSize = " + this.f2018s);
                if (this.f2019t >= this.f2018s) {
                    C2538c.m12677c("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List() send ok fileCrc = " + this.f2021v);
                    this.f2024y += this.f2008i + ",";
                    if (this.f2007h != null && this.f2007h.size() > 0) {
                        this.f2007h.remove(0);
                    }
                    DeviceCommand deviceCommand = null;
                    if (this.f2011l != null) {
                        deviceCommand = this.f2011l.transferFileEndProcess();
                    }
                    if (deviceCommand != null) {
                        C2538c.m12677c("HWFileTransferTaskManager", "addSleepOrDFXPlayData2List transferFileEndProcess sendDeviceData ...");
                        m4279a(deviceCommand);
                    }
                    if (this.f2011l == null) {
                        return;
                    }
                    if (this.f2011l instanceof DetailSleepUtil) {
                        this.f2011l.save2File(new g(this), true);
                    } else if (this.f2011l instanceof MaintenanceUtil) {
                        this.f2011l.save2File(new h(this), true);
                    } else {
                        this.f2005f.sendEmptyMessage(10);
                    }
                } else if (this.f2011l instanceof MaintenanceUtil) {
                    this.f2011l.save2File(new i(this), false);
                } else {
                    m4341c();
                }
            }
        }
    }

    private void m4293b(com.huawei.hwservicesmgr.datetype.e eVar) {
        if (eVar.a() == this.f1993M) {
            byte[] b = eVar.b();
            this.f2020u += b.length;
            this.f2009j = 0;
            C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() fileType = " + this.f2009j + "  valueByte.length = " + b.length);
            if (1 != this.f2009j) {
                this.f2015p.add(b);
                C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() 0 valueByte = " + C0973a.m3509a(b));
            } else {
                try {
                    this.f2015p.add(C0973a.m3509a(b).getBytes(GameManager.DEFAULT_CHARSET));
                    C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() 1 bytes = " + C0973a.m3509a(r0));
                } catch (UnsupportedEncodingException e) {
                    C2538c.m12674b("HWFileTransferTaskManager", "addSleepDataFromAndroidWear exception  is " + e.getMessage());
                }
            }
            this.f2019t += b.length;
            this.f1993M++;
        } else {
            C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() lost  index = " + eVar.a());
        }
        C2538c.m12674b("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() currentApplyDataSize =" + this.f2016q + ",+donePackatgeSize = " + this.f2020u + ",currentSleepOrDFXFrameNum = " + this.f1992L + ",index = " + r1);
        if (this.f2019t >= this.f2018s) {
            this.f2012m = 0;
            this.f2020u = 0;
            if (this.f2005f != null) {
                this.f2005f.removeMessages(7);
                if (this.f2011l != null) {
                    this.f2011l.writeLogToFile(this.f2015p, this.f2008i, this.f2025z);
                }
                C2538c.m12677c("HWFileTransferTaskManager", "***addSleepDataFromAndroidWear() send ok writeLogToFile fileName = " + this.f2008i + ",maintLogsSize = " + this.f2015p.size() + ",doneTotalSize = " + this.f2019t + ",+fileTotalSize = " + this.f2018s);
                this.f2015p.clear();
                if (this.f2018s <= 0) {
                    C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() lost  package error!!!!!!");
                    m4343e();
                    if (this.f2002c != null) {
                        if (this.f2011l != null) {
                            this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                        }
                        if (this.f2011l instanceof DetailSleepUtil) {
                            this.f2011l.setMaintRetryResult(true);
                        }
                        this.f2002c.onResponse(10002, "package error");
                        return;
                    }
                    return;
                }
                C2538c.m12677c("HWFileTransferTaskManager", "***addSleepDataFromAndroidWear() send ok  doneTotalSize = " + this.f2019t + ",+fileTotalSize = " + this.f2018s);
                if (this.f2019t >= this.f2018s) {
                    C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear() send ok fileCrc = " + this.f2021v);
                    this.f2024y += this.f2008i + ",";
                    if (this.f2007h != null && this.f2007h.size() > 0) {
                        this.f2007h.remove(0);
                    }
                    DeviceCommand deviceCommand = null;
                    if (this.f2011l != null) {
                        deviceCommand = this.f2011l.transferFileEndProcess();
                    }
                    if (deviceCommand != null) {
                        C2538c.m12677c("HWFileTransferTaskManager", "addSleepDataFromAndroidWear transferFileEndProcess 5.10.6 deviceCommand : " + C0973a.m3509a(deviceCommand.getDataContent()));
                        m4279a(deviceCommand);
                    }
                    if (this.f2011l != null) {
                        if (this.f2011l instanceof DetailSleepUtil) {
                            this.f2011l.save2File(new j(this), true);
                        } else if (this.f2011l instanceof MaintenanceUtil) {
                            this.f2011l.save2File(new k(this), true);
                        } else {
                            this.f2005f.sendEmptyMessage(10);
                        }
                    }
                    m4320i();
                } else if (this.f2011l instanceof MaintenanceUtil) {
                    this.f2011l.save2File(new l(this), false);
                } else {
                    m4341c();
                }
            }
        }
    }

    public void m4339b() {
        int i = this.f2018s - this.f2019t;
        C2538c.m12677c("HWFileTransferTaskManager", "getApplyDataFromDevice spareSize = " + i + ",+currentApplyDataSize = " + this.f2016q);
        if (this.f2019t % this.f2017r != 0 && i != this.f2018s) {
            C2538c.m12677c("HWFileTransferTaskManager", "getApplyDataFromDevice fileTotalSize = " + this.f2018s + ", maxApplyDataSize = " + this.f2017r);
        } else if (i < this.f2017r) {
            this.f2016q = i;
            m4338a(this.f2008i, this.f2019t, this.f2016q, "");
        } else {
            this.f2016q = this.f2017r;
            m4338a(this.f2008i, this.f2019t, this.f2016q, "");
        }
    }

    public void m4341c() {
        int i;
        int i2 = this.f2018s - this.f2019t;
        C2538c.m12677c("HWFileTransferTaskManager", "Enter getSleepOrDFXApplyDataFromDevice spareSize = " + i2 + ",+currentApplyDataSize = " + this.f2016q);
        String file_protocal_version = this.f1982B.getFile_protocal_version();
        if (file_protocal_version != null) {
            C2538c.m12677c("HWFileTransferTaskManager", "getSleepOrDFXApplyDataFromDevice version : " + file_protocal_version);
            if (file_protocal_version.contains("AW")) {
                i = 1;
                if (i2 > this.f2016q || r0 != 0) {
                    this.f2016q = i2;
                    C2538c.m12677c("HWFileTransferTaskManager", "getSleepOrDFXApplyDataFromDevice requeset final package currentApplyDataSize = " + this.f2016q);
                    m4340b(this.f2008i, this.f2019t, this.f2016q, "");
                }
                this.f2016q = this.f2017r;
                C2538c.m12677c("HWFileTransferTaskManager", "getSleepOrDFXApplyDataFromDevice requeset next package currentApplyDataSize = " + this.f2016q);
                m4340b(this.f2008i, this.f2019t, this.f2016q, "");
                return;
            }
        }
        i = 0;
        if (i2 > this.f2016q) {
        }
        this.f2016q = i2;
        C2538c.m12677c("HWFileTransferTaskManager", "getSleepOrDFXApplyDataFromDevice requeset final package currentApplyDataSize = " + this.f2016q);
        m4340b(this.f2008i, this.f2019t, this.f2016q, "");
    }

    private void m4326j(Object obj) {
        try {
            int[] iArr = (int[]) obj;
            if (100000 != iArr[0]) {
                m4342d();
                if (this.f2002c != null) {
                    this.f2002c.onResponse(iArr[0], m4297c(iArr[0]));
                }
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---errorCodeHandle Exception---e = " + e.getMessage());
        }
    }

    private void m4330k(Object obj) {
        try {
            int[] iArr = (int[]) obj;
            if (100000 != iArr[0]) {
                m4343e();
                if (this.f2002c != null) {
                    this.f2011l.cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                    this.f2002c.onResponse(iArr[0], m4297c(iArr[0]));
                }
            }
        } catch (Exception e) {
            C2538c.m12680e("HWFileTransferTaskManager", "---errorCodeHandle Exception---e = " + e.getMessage());
        }
    }

    private String m4297c(int i) {
        String str = "";
        switch (i) {
            case 100000:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_OK;
            case 100001:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW;
            case 100002:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_UNSUPPORT;
            case 100003:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_NO_PERMISSION;
            case 100004:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_BUSY;
            case 100005:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_FORMAT_ERROR;
            case 100006:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_PARAMETER_ERROR;
            case 100007:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_MEMORY_INADEQUATE;
            case 100008:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_RESPONSE_TIMEOUT;
            case HWDeviceDFXConstants.ERROR_CODE_NUMBER_HARDWARE_ERROR /*104001*/:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_HARDWARE_ERROR;
            case HWDeviceDFXConstants.ERROR_CODE_NUMBER_BATTERY_LOW_POWE /*104002*/:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_BATTERY_LOW_POWE;
            default:
                return str;
        }
    }

    private void m4324j() {
        this.f2016q = this.f2017r;
        this.f2018s = 0;
        this.f2019t = 0;
        this.f1994N = 0;
        this.f1995O = 0;
        this.f2020u = 0;
        this.f2021v = 0;
        this.f2015p.clear();
    }

    public void m4342d() {
        C2538c.m12677c("HWFileTransferTaskManager", "enter resetMaintenance().");
        m4324j();
        this.f1993M = 0;
        this.f2022w = false;
        this.f2012m = 0;
        this.f2023x = "All file:";
        this.f2024y = "Done file:";
        this.f1988H = null;
        this.f1989I = 0;
        this.f1990J = 0;
        C1023c.m3920a(BaseApplication.m2632b()).m3986a(null);
        PhoneService.m4195a(-1);
        this.f1981A = 5000;
        this.f2017r = 732;
        this.f1991K = 244;
        this.f1997Q = false;
    }

    public void m4343e() {
        C2538c.m12677c("HWFileTransferTaskManager", "enter resetSleepOrDFXMaintenance().");
        m4324j();
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
        }
        this.f1992L = -1;
        this.f2022w = false;
        this.f2012m = 0;
        this.f2023x = "All file:";
        this.f2024y = "Done file:";
        this.f1981A = 5000;
        this.f2017r = 732;
        this.f1991K = 244;
        C1023c.m3920a(BaseApplication.m2632b()).m3986a(null);
        PhoneService.m4195a(-1);
    }

    public void m4344f() {
        C2538c.m12677c("HWFileTransferTaskManager", "enter resetSleepOrDFXMaintenance().");
        m4324j();
        if (this.f2005f != null) {
            this.f2005f.removeMessages(15);
        }
        this.f1992L = -1;
        this.f2022w = false;
        this.f2012m = 0;
        this.f2023x = "All file:";
        this.f2024y = "Done file:";
        this.f1981A = 5000;
        this.f2017r = 732;
        this.f1991K = 244;
        PhoneService.m4195a(-1);
    }

    private String m4327k() {
        C2538c.m12677c("HWFileTransferTaskManager", "reportStatusFileList result = " + (this.f2023x + ";" + this.f2024y));
        return this.f2023x + ";" + this.f2024y;
    }

    private void m4279a(DeviceCommand deviceCommand) {
        C2538c.m12677c("HWFileTransferTaskManager", "sendCommand  deviceCommand = " + C0973a.m3509a(deviceCommand.getDataContent()));
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    public void getResult(byte[] bArr) {
        this.f2000T.onResponse(0, bArr);
    }

    private boolean m4287a(byte[] bArr) {
        String a = C0973a.m3509a(bArr);
        if (HWDeviceDFXConstants.ERROR_CODE_GET_FILE_LEO_NAME_ERROR == Integer.parseInt(a.substring(8, a.length()), 16)) {
            return true;
        }
        return false;
    }
}
