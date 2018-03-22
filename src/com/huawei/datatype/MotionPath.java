package com.huawei.datatype;

import com.huawei.hwbasemgr.c;
import com.huawei.hwcommonmodel.p064d.C0978h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MotionPath implements Serializable {
    public static final String BRITISH_PACEMAP_TAG = "tp=b-p-m";
    public static final String HEARTRATElIST_TAG = "tp=h-r";
    public static final String INTERVAL_BRITISH_PACEMAP_TAG = "tp=pm-b";
    public static final String INTERVAL_NORMAL_PACEMAP_TAG = "tp=pm-n";
    public static final String LBSDATAMAP_TAG = "tp=lbs";
    public static final String PACEMAP_TAG = "tp=p-m";
    public static final String STEPRATElIST_TAG = "tp=s-r";
    public static final String VERSION = "version=1001";
    private static final long serialVersionUID = -1773594779542639469L;
    private Map<Integer, Float> britishIntervalPaceMap;
    private Map<Integer, Float> britishPaceMap;
    private ArrayList<HeartRateData> heartRateList;
    private Map<Long, double[]> lbsDataMap;
    private Map<Integer, Float> normalIntervalPaceMap;
    private Map<Integer, Float> paceMap;
    private ArrayList<StepRateData> stepRateList;

    public Map<Long, double[]> getLbsDataMap() {
        return (Map) C0978h.a(this.lbsDataMap);
    }

    public void setLbsDataMap(Map<Long, double[]> map) {
        this.lbsDataMap = (Map) C0978h.a(map);
    }

    public Map<Integer, Float> getPaceMap() {
        return (Map) C0978h.a(this.paceMap);
    }

    public void setPaceMap(Map<Integer, Float> map) {
        this.paceMap = (Map) C0978h.a(map);
    }

    public Map<Integer, Float> getBritishPaceMap() {
        return (Map) C0978h.a(this.britishPaceMap);
    }

    public void setBritishPaceMap(Map<Integer, Float> map) {
        this.britishPaceMap = (Map) C0978h.a(map);
    }

    public ArrayList<HeartRateData> getHeartRateList() {
        return (ArrayList) C0978h.a(this.heartRateList);
    }

    public void setHeartRateList(ArrayList<HeartRateData> arrayList) {
        this.heartRateList = (ArrayList) C0978h.a(arrayList);
    }

    public ArrayList<StepRateData> getStepRateList() {
        return (ArrayList) C0978h.a(this.stepRateList);
    }

    public void setStepRateList(ArrayList<StepRateData> arrayList) {
        this.stepRateList = (ArrayList) C0978h.a(arrayList);
    }

    public Map<Integer, Float> getNormalIntervalPaceMap() {
        return (Map) C0978h.a(this.normalIntervalPaceMap);
    }

    public void setNormalIntervalPaceMap(Map<Integer, Float> map) {
        this.normalIntervalPaceMap = (Map) C0978h.a(map);
    }

    public Map<Integer, Float> getBritishIntervalPaceMap() {
        return (Map) C0978h.a(this.britishIntervalPaceMap);
    }

    public void setBritishIntervalPaceMap(Map<Integer, Float> map) {
        this.britishIntervalPaceMap = (Map) C0978h.a(map);
    }

    public String toString() {
        int i;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.lbsDataMap != null) {
            for (Entry entry : this.lbsDataMap.entrySet()) {
                stringBuffer2.append(LBSDATAMAP_TAG).append(";k=").append(entry.getKey()).append(";").append("lat=").append(((double[]) entry.getValue())[0]).append(";").append("lon=").append(((double[]) entry.getValue())[1]).append(";").append("alt=").append(((double[]) entry.getValue())[2]).append(";").append("t=").append(((double[]) entry.getValue())[3]).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.paceMap != null) {
            for (Entry entry2 : this.paceMap.entrySet()) {
                stringBuffer2.append(PACEMAP_TAG).append(";k=").append(entry2.getKey()).append(";").append("v=").append(entry2.getValue()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.britishPaceMap != null) {
            for (Entry entry22 : this.britishPaceMap.entrySet()) {
                stringBuffer2.append(BRITISH_PACEMAP_TAG).append(";k=").append(entry22.getKey()).append(";").append("v=").append(entry22.getValue()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.heartRateList != null) {
            for (i = 0; i < this.heartRateList.size(); i++) {
                stringBuffer2.append(HEARTRATElIST_TAG).append(";k=").append(((HeartRateData) this.heartRateList.get(i)).getTime()).append(";").append("v=").append(((HeartRateData) this.heartRateList.get(i)).getHeartRate()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.stepRateList != null) {
            stringBuffer2.setLength(0);
            for (i = 0; i < this.stepRateList.size(); i++) {
                stringBuffer2.append(STEPRATElIST_TAG).append(";k=").append(((StepRateData) this.stepRateList.get(i)).getTime()).append(";").append("v=").append(((StepRateData) this.stepRateList.get(i)).getStepRate()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.normalIntervalPaceMap != null) {
            for (Entry entry222 : this.normalIntervalPaceMap.entrySet()) {
                stringBuffer2.append(INTERVAL_NORMAL_PACEMAP_TAG).append(";k=").append(entry222.getKey()).append(";").append("v=").append(entry222.getValue()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        if (this.britishIntervalPaceMap != null) {
            for (Entry entry2222 : this.britishIntervalPaceMap.entrySet()) {
                stringBuffer2.append(INTERVAL_BRITISH_PACEMAP_TAG).append(";k=").append(entry2222.getKey()).append(";").append("v=").append(entry2222.getValue()).append(";").append("\n");
                arrayList.add(stringBuffer2.toString());
                stringBuffer2.setLength(0);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        return stringBuffer.toString();
    }

    public boolean validHeartRateList() {
        if (this.heartRateList != null && this.heartRateList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean validPaceMap() {
        if (this.paceMap != null && this.paceMap.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean validBritishPaceMap() {
        if (this.britishPaceMap != null && this.britishPaceMap.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean validLbsDataMap() {
        if (this.lbsDataMap != null && this.lbsDataMap.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean validStepRateList() {
        if (this.stepRateList != null && this.stepRateList.size() > 0) {
            return true;
        }
        return false;
    }

    public Map<Integer, Float> localePaceMap() {
        if (c.a()) {
            return this.britishPaceMap;
        }
        return this.paceMap;
    }
}
