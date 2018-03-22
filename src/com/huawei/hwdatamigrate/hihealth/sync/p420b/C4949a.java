package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwcloudmodel.model.unite.ProfessionalSleep;
import com.huawei.hwcloudmodel.model.unite.ProfessionalSleepTotal;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CoreSleepSwitch */
public class C4949a {
    public C4949a(Context context) {
    }

    public List<ProfessionalSleepTotal> m23817a(List<HiHealthData> list) {
        List<ProfessionalSleepTotal> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            ProfessionalSleepTotal professionalSleepTotal = new ProfessionalSleepTotal();
            professionalSleepTotal.setTimeZone(hiHealthData.getTimeZone());
            professionalSleepTotal.setRecordDay(C4540b.m21750a(hiHealthData.getStartTime()));
            professionalSleepTotal.setDataSource(2);
            professionalSleepTotal.setDeviceCode(0);
            professionalSleepTotal.setGenerateTime(hiHealthData.getLong("modified_time"));
            professionalSleepTotal.setProfessionalSleep(m23816a(hiHealthData));
            arrayList.add(professionalSleepTotal);
        }
        return arrayList;
    }

    private ProfessionalSleep m23816a(HiHealthData hiHealthData) {
        ProfessionalSleep professionalSleep = new ProfessionalSleep();
        professionalSleep.setFallAsleepTime(hiHealthData.getLong("stat_out_core_sleep_fall_time"));
        professionalSleep.setWakeupTime(hiHealthData.getLong("stat_out_core_sleep_wake_up_time"));
        professionalSleep.setSleepScore(hiHealthData.getInt("stat_out_core_sleep_score"));
        professionalSleep.setSleepLatency(hiHealthData.getInt("stat_out_core_sleep_latency"));
        professionalSleep.setGoBedTime(hiHealthData.getLong("stat_out_core_sleep_go_bed_time"));
        professionalSleep.setValidData(hiHealthData.getFloat("stat_out_core_sleep_valid_data"));
        professionalSleep.setSleepEfficiency(hiHealthData.getInt("stat_out_core_sleep_efficiency"));
        professionalSleep.setLightSleepTime(hiHealthData.getInt("stat_core_sleep_shallow_duration"));
        professionalSleep.setDeepSleepTime(hiHealthData.getInt("stat_core_sleep_deep_duration"));
        professionalSleep.setDreamTime(hiHealthData.getInt("stat_core_sleep_dream_duration"));
        professionalSleep.setAwakeTime(hiHealthData.getInt("stat_core_sleep_wake_duration"));
        professionalSleep.setAllSleepTime(hiHealthData.getInt("stat_core_sleep_duration_sum"));
        professionalSleep.setWakeupCnt(hiHealthData.getInt("stat_core_sleep_wake_count"));
        professionalSleep.setDeepSleepPart(hiHealthData.getInt("stat_core_sleep_deep_part_count"));
        professionalSleep.setSnoreFreq(hiHealthData.getInt("stat_out_core_sleep_snore_freq"));
        professionalSleep.setDaySleepTime(hiHealthData.getInt("stat_core_sleep_noon_duration"));
        return professionalSleep;
    }
}
