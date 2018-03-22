package com.huawei.hwdatamigrate.hihealth.p068d;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.HashMap;

/* compiled from: SequenceCache */
public class C4877i {
    private HashMap<String, String> f17894a;

    private C4877i() {
        this.f17894a = new HashMap();
    }

    public static C4877i m23639a() {
        return C4879k.f17895a;
    }

    public void m23641a(HiHealthData hiHealthData) {
        String c = m23640c(hiHealthData);
        this.f17894a.put(c, ((String) this.f17894a.get(c)) + hiHealthData.getSequenceData());
    }

    public String m23642b(HiHealthData hiHealthData) {
        String c = m23640c(hiHealthData);
        String str = (String) this.f17894a.get(c);
        if (C4539a.m21748a(str)) {
            return hiHealthData.getSequenceData();
        }
        this.f17894a.remove(c);
        return str + hiHealthData.getSequenceData();
    }

    private String m23640c(HiHealthData hiHealthData) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hiHealthData.getStartTime()).append(HwAccountConstants.SPLIIT_UNDERLINE).append(hiHealthData.getEndTime()).append(HwAccountConstants.SPLIIT_UNDERLINE).append(hiHealthData.getType()).append(HwAccountConstants.SPLIIT_UNDERLINE).append(hiHealthData.getClientID());
        return stringBuffer.toString();
    }
}
