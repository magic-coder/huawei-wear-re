package com.huawei.hihealth.data.p395a;

import android.util.SparseArray;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.nfc.carrera.logic.oma.IOmaService;

/* compiled from: HiHealthDataKey */
public class C4548a {
    private static final SparseArray<String> f16768a = new SparseArray();

    public static String[] m21798a() {
        return new String[]{"sport_walk_step_sum", "sport_run_step_sum", "sport_climb_step_sum", "sport_walk_distance_sum", "sport_run_distance_sum", "sport_cycle_distance_sum", "sport_climb_distance_sum", "sport_walk_duration_sum", "sport_run_duration_sum", "sport_cycle_duration_sum", "sport_climb_duration_sum", "sport_walk_calorie_sum", "sport_run_calorie_sum", "sport_cycle_calorie_sum", "sport_climb_calorie_sum", "sport_altitude_offset_sum"};
    }

    public static String[] m21799b() {
        return new String[]{"stat_core_sleep_dream_duration", "stat_core_sleep_deep_duration", "stat_core_sleep_shallow_duration", "stat_core_sleep_wake_duration", "stat_core_sleep_duration_sum", "stat_core_sleep_deep_part_count", "stat_core_sleep_wake_count", "stat_core_sleep_noon_duration", "stat_out_core_sleep_fall_time", "stat_out_core_sleep_wake_up_time", "stat_out_core_sleep_score", "stat_out_core_sleep_latency", "stat_out_core_sleep_go_bed_time", "stat_out_core_sleep_valid_data", "stat_out_core_sleep_efficiency", "stat_out_core_sleep_snore_freq"};
    }

    static {
        f16768a.put(20001, "session_type");
        f16768a.put(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, "bloodpressure_diastolic");
        f16768a.put(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION, "bloodpressure_systolic");
        f16768a.put(2018, "heart_rate");
        f16768a.put(2002, "heart_rate");
        f16768a.put(2004, "weight");
        f16768a.put(2001, "weight_bodyfat");
        f16768a.put(2015, "bloodsugar_before_dawn");
        f16768a.put(2009, "bloodsugar_bf_after");
        f16768a.put(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION, "bloodsugar_bf_before");
        f16768a.put(2013, "bloodsugar_dn_after");
        f16768a.put(2012, "bloodsugar_dn_before");
        f16768a.put(2010, "bloodsugar_lc_before");
        f16768a.put(TradeCode.ALIPAY_ONE_KEY_SIGN, "bloodsugar_lc_after");
        f16768a.put(2014, "bloodsugar_sl_before");
    }

    public static String m21796a(int i) {
        return (String) f16768a.get(i);
    }

    public static String m21797a(String str) {
        return str + "_unit";
    }
}
