package com.huawei.p523y.p524a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4745l;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwcommonmodel.datatypes.HWOTAParameter;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwservicesmgr.C5368p;
import com.huawei.hwservicesmgr.j;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWOTAV1XMgr */
public class C6177f extends C6172a {
    private Context f21654a;
    private C4756w f21655b = new C4756w();
    private j f21656c;
    private String f21657d;
    private String f21658e;
    private int f21659f;
    private IBaseResponseCallback f21660g = new C6178g(this);

    C6177f(Context context) {
        super(context);
        this.f21654a = context;
    }

    public void mo5184a(String str, int i, String str2, j jVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jVar == null) {
            C2538c.e("HWOTAV1XMgr", new Object[]{"OTA V1X transferOtaFile ,parameter is error!!!"});
            return;
        }
        m28598e();
        this.f21656c = jVar;
        this.f21657d = str;
        this.f21659f = i;
        this.f21658e = str2;
    }

    private void m28598e() {
        C6172a.m28560b();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put((byte) 4);
        allocate.put((byte) 1);
        allocate.put(TagName.PAY_CHANNEL);
        allocate.put((byte) 0);
        C6172a.m28559a(this.f21660g);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(2);
        deviceCommand.setDataContent(allocate.array());
        deviceCommand.setDataLen(allocate.array().length);
        com.huawei.n.c.a(this.f21654a).b(deviceCommand);
    }

    private HWOTAParameter m28587a(C4754u c4754u) {
        HWOTAParameter hWOTAParameter = new HWOTAParameter();
        List list = c4754u.f17338b;
        List arrayList = new ArrayList();
        C4745l c4745l = new C4745l();
        for (int i = 0; i < list.size(); i++) {
            List list2 = ((C4754u) list.get(i)).f17337a;
            if (list2 != null && list2.size() > 0) {
                m28592a(hWOTAParameter, arrayList, c4745l, list2);
            }
        }
        hWOTAParameter.setModuleStructs(arrayList);
        m28590a(hWOTAParameter, c4754u.f17337a);
        return hWOTAParameter;
    }

    private void m28590a(HWOTAParameter hWOTAParameter, List<C4752s> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                C4752s c4752s = (C4752s) list.get(i);
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 25:
                        C2538c.c("HWOTAV1XMgr", new Object[]{"ONLINE_MODULE_NUMBER,value=" + Integer.parseInt(c4752s.m22733b(), 16)});
                        hWOTAParameter.setModule_number(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void m28592a(HWOTAParameter hWOTAParameter, List<C4745l> list, C4745l c4745l, List<C4752s> list2) {
        for (C4752s c4752s : list2) {
            m28591a(hWOTAParameter, (List) list, c4745l, c4752s);
            m28594b(hWOTAParameter, list, c4745l, c4752s);
        }
    }

    private void m28591a(HWOTAParameter hWOTAParameter, List<C4745l> list, C4745l c4745l, C4752s c4752s) {
        boolean z = true;
        int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
        String b = c4752s.m22733b();
        switch (parseInt) {
            case 14:
                hWOTAParameter.setOTA_protocol_version(C0973a.c(b));
                return;
            case 15:
                hWOTAParameter.setUpdate_type(Integer.parseInt(b, 16));
                return;
            case 16:
                hWOTAParameter.setTransport_type(Integer.parseInt(b, 16));
                return;
            case 17:
                if (1 != Integer.parseInt(b, 16)) {
                    z = false;
                }
                hWOTAParameter.setBreakPoint_enable(z);
                return;
            default:
                return;
        }
    }

    private void m28594b(HWOTAParameter hWOTAParameter, List<C4745l> list, C4745l c4745l, C4752s c4752s) {
        int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
        String b = c4752s.m22733b();
        switch (parseInt) {
            case 18:
                hWOTAParameter.setPackets_send_num(Integer.parseInt(b, 16));
                return;
            case 19:
                hWOTAParameter.setPacket_send_size(Integer.parseInt(b, 16));
                return;
            case 20:
                hWOTAParameter.setTimeout(Integer.parseInt(b, 16));
                return;
            case 27:
                c4745l.m22705a(Integer.parseInt(c4752s.m22733b(), 16));
                return;
            case 28:
                c4745l.m22706b(Integer.parseInt(c4752s.m22733b(), 16));
                list.add(c4745l);
                return;
            default:
                return;
        }
    }

    public void mo5185a(String str, C5368p c5368p) {
        try {
            c5368p.m25849a(109005, "设备不允许升级");
        } catch (Exception e) {
            C2538c.e("HWOTAV1XMgr", new Object[]{"exception e = " + e.getMessage()});
        }
    }
}
