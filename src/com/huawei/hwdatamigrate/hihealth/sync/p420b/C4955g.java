package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.model.HiTrackMetaData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hwcloudmodel.model.unite.Location;
import com.huawei.hwcloudmodel.model.unite.MotionPathDetail;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p415g.C4906a;
import com.huawei.hwdatamigrate.hihealth.p419i.C4941d;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4976k;
import com.huawei.p190v.C2538c;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MotionPathSwitch */
public class C4955g {
    private C4850g f18035a = C4850g.m23559a(this.f18036b);
    private Context f18036b;

    public C4955g(@NonNull Context context) {
        this.f18036b = context.getApplicationContext();
    }

    public List<MotionPathDetail> m23837a(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        g e = this.f18035a.m23567e(((HiHealthData) list.get(0)).getClientID());
        if (e == null) {
            return null;
        }
        List<MotionPathDetail> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            MotionPathDetail motionPathDetail = new MotionPathDetail();
            motionPathDetail.setDeviceCode(Long.valueOf(e.g()));
            motionPathDetail.setStartTime(Long.valueOf(hiHealthData.getStartTime()));
            motionPathDetail.setEndTime(Long.valueOf(hiHealthData.getEndTime()));
            motionPathDetail.setTimeZone(hiHealthData.getTimeZone());
            String metaData = hiHealthData.getMetaData();
            if (C4539a.m21748a(metaData)) {
                C2538c.e("Debug_MotionPathSwitch", new Object[]{"localTrackToCloudByUnite localTrack metaData error ,it is ", hiHealthData});
            } else {
                HiTrackMetaData hiTrackMetaData = (HiTrackMetaData) C4543e.m21777a(metaData, HiTrackMetaData.class);
                motionPathDetail.setSportType(Integer.valueOf(C4941d.m23807c(hiTrackMetaData.getSportType())));
                motionPathDetail.setTotalCalories(Integer.valueOf(hiTrackMetaData.getTotalCalories()));
                motionPathDetail.setTotalDistance(Integer.valueOf(hiTrackMetaData.getTotalDistance()));
                motionPathDetail.setTotalSteps(Integer.valueOf(hiTrackMetaData.getTotalSteps()));
                motionPathDetail.setTotalTime(Long.valueOf(hiTrackMetaData.getTotalTime()));
                motionPathDetail.setPartTimeMap(hiTrackMetaData.getPartTimeMap());
                motionPathDetail.setPaceMap(C4955g.m23836a(hiTrackMetaData.getPaceMap()));
                List arrayList2 = new ArrayList();
                Location location = new Location();
                location.setName("gps point is in attribute HW_EXT_TRACK_DETAIL,not here");
                arrayList2.add(location);
                motionPathDetail.setLocation(arrayList2);
                String sequenceData = hiHealthData.getSequenceData();
                if (C4539a.m21748a(sequenceData)) {
                    C2538c.e("Debug_MotionPathSwitch", new Object[]{"localTrackToCloudByUnite localTrack sequenceData error ,it is ", hiHealthData});
                } else {
                    motionPathDetail.setAttribute("HW_EXT_TRACK_DETAIL@is" + sequenceData + "&&" + "HW_EXT_TRACK_SIMPLIFY" + "@is" + metaData);
                    arrayList.add(motionPathDetail);
                }
            }
        }
        return arrayList;
    }

    public void m23838a(MotionPathDetail motionPathDetail, HiHealthData hiHealthData) {
        float f;
        Object hiTrackMetaData = new HiTrackMetaData();
        long longValue = motionPathDetail.getTotalTime().longValue();
        int intValue = motionPathDetail.getTotalDistance().intValue();
        hiTrackMetaData.setTotalTime(longValue);
        hiTrackMetaData.setTotalDistance(intValue);
        if (intValue == 0) {
            f = 0.0f;
        } else {
            f = ((float) longValue) / ((float) intValue);
        }
        hiTrackMetaData.setAvgPace(f);
        hiTrackMetaData.setTotalSteps(motionPathDetail.getTotalSteps().intValue());
        hiTrackMetaData.setTotalCalories(motionPathDetail.getTotalCalories().intValue());
        hiTrackMetaData.setSportId(motionPathDetail.getRecordId());
        C2538c.c("Debug_MotionPathSwitch", new Object[]{"sportType is ", motionPathDetail.getSportType()});
        hiTrackMetaData.setSportType(C4941d.m23808d(motionPathDetail.getSportType().intValue()));
        Map paceMap = motionPathDetail.getPaceMap();
        C4906a c4906a = new C4906a();
        if (!(paceMap == null || paceMap.isEmpty())) {
            Map hashMap = new HashMap();
            for (Entry entry : paceMap.entrySet()) {
                hashMap.put(Integer.valueOf(Integer.parseInt((String) entry.getKey())), entry.getValue());
            }
            hiTrackMetaData.setPaceMap(hashMap);
            c4906a.m23727b(hashMap);
        }
        hiTrackMetaData.setPartTimeMap(motionPathDetail.getPartTimeMap());
        hiHealthData.setMetaData(C4543e.m21780a(hiTrackMetaData, (Type) HiTrackMetaData.class));
        List<Location> location = motionPathDetail.getLocation();
        Map hashMap2 = new HashMap();
        if (!(location == null || location.isEmpty())) {
            for (Location location2 : location) {
                Object obj = new double[4];
                obj[0] = location2.getLatitude();
                obj[1] = location2.getLongitude();
                obj[2] = location2.getAltitude();
                hashMap2.put(location2.getTimestamp(), obj);
            }
        }
        c4906a.m23726a(hashMap2);
        c4906a.m23725a(motionPathDetail.getHeartRateList());
        hiHealthData.setSequenceData(c4906a.toString());
    }

    private static Map<String, Float> m23836a(Map<Integer, Float> map) {
        Map<String, Float> hashMap = new HashMap();
        if (map == null || map.isEmpty()) {
            return hashMap;
        }
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.toString(((Integer) entry.getKey()).intValue()), entry.getValue());
        }
        return hashMap;
    }

    public List<MotionPathDetail> m23839b(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<MotionPathDetail> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            MotionPathDetail motionPathDetail = new MotionPathDetail();
            long startTime = hiHealthData.getStartTime();
            long endTime = hiHealthData.getEndTime();
            String timeZone = hiHealthData.getTimeZone();
            motionPathDetail.setStartTime(Long.valueOf(startTime));
            motionPathDetail.setEndTime(Long.valueOf(endTime));
            motionPathDetail.setTimeZone(timeZone);
            timeZone = hiHealthData.getMetaData();
            String sequenceData = hiHealthData.getSequenceData();
            HiTrackMetaData hiTrackMetaData = (HiTrackMetaData) C4543e.m21777a(timeZone, HiTrackMetaData.class);
            if (!(hiTrackMetaData == null || sequenceData == null)) {
                g e = this.f18035a.m23567e(hiHealthData.getClientID());
                if (e != null) {
                    motionPathDetail.setDeviceCode(Long.valueOf(e.g()));
                    motionPathDetail.setTotalSteps(Integer.valueOf(hiTrackMetaData.getTotalSteps()));
                    motionPathDetail.setTotalCalories(Integer.valueOf(hiTrackMetaData.getTotalCalories()));
                    motionPathDetail.setTotalDistance(Integer.valueOf(hiTrackMetaData.getTotalDistance()));
                    motionPathDetail.setTotalTime(Long.valueOf(hiTrackMetaData.getTotalTime()));
                    List arrayList2 = new ArrayList();
                    arrayList2.add(C4976k.m23907a("TRACK_METADATA", timeZone, startTime, endTime, null, null));
                    arrayList2.add(C4976k.m23907a("TRACK_SEQUENCE_DATA", sequenceData, startTime, endTime, null, null));
                    motionPathDetail.setSamplePoints(arrayList2);
                    arrayList.add(motionPathDetail);
                }
            }
        }
        return arrayList;
    }
}
