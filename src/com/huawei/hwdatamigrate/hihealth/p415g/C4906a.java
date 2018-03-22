package com.huawei.hwdatamigrate.hihealth.p415g;

import com.huawei.datatype.MotionPath;
import com.huawei.hwcloudmodel.model.unite.MotionPathHeartRate;
import com.huawei.p190v.C2538c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: OldToNewMotionPath */
public class C4906a implements Serializable {
    private Map<Long, double[]> f17960a;
    private Map<Integer, Float> f17961b;
    private List<MotionPathHeartRate> f17962c;

    public void m23726a(Map<Long, double[]> map) {
        this.f17960a = map;
    }

    public void m23727b(Map<Integer, Float> map) {
        this.f17961b = map;
    }

    public void m23725a(List<MotionPathHeartRate> list) {
        this.f17962c = list;
    }

    public String toString() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.f17960a != null) {
            for (Entry entry : this.f17960a.entrySet()) {
                stringBuffer2.append(MotionPath.LBSDATAMAP_TAG).append(";k=").append(entry.getKey()).append(";").append("lat=").append(((double[]) entry.getValue())[0]).append(";").append("lon=").append(((double[]) entry.getValue())[1]).append(";").append("alt=").append(((double[]) entry.getValue())[2]).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.f17961b != null) {
            for (Entry entry2 : this.f17961b.entrySet()) {
                stringBuffer2.append(MotionPath.PACEMAP_TAG).append(";k=").append(entry2.getKey()).append(";").append("v=").append(entry2.getValue()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.f17962c != null) {
            for (int i = 0; i < this.f17962c.size(); i++) {
                stringBuffer2.append(MotionPath.HEARTRATElIST_TAG).append(";k=").append(((MotionPathHeartRate) this.f17962c.get(i)).getTime()).append(";").append("v=").append(((MotionPathHeartRate) this.f17962c.get(i)).getHeartRate()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        C2538c.b("OldToNewMotionPath", new Object[]{"toString totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return stringBuffer.toString();
    }
}
