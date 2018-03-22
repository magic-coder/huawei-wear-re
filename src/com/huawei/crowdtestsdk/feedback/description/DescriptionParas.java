package com.huawei.crowdtestsdk.feedback.description;

import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DescriptionParas {
    public static final SparseArray<String> level = new SparseArray();
    public static final SparseArray<String> recure = new SparseArray();
    private static final Map<String, Integer> recureIndex = new HashMap();
    public static final Map<String, Integer> recureIndexMap = Collections.unmodifiableMap(recureIndex);
    public static final SparseArray<String> rence = new SparseArray();

    static {
        recure.put(0, "tbdts_flag_view_1");
        recure.put(1, "tbdts_flag_view_2");
        recure.put(2, "tbdts_flag_view_3");
        recure.put(3, "tbdts_flag_view_4");
        recureIndex.put("tbdts_flag_view_1", Integer.valueOf(0));
        recureIndex.put("tbdts_flag_view_2", Integer.valueOf(1));
        recureIndex.put("tbdts_flag_view_3", Integer.valueOf(2));
        recureIndex.put("tbdts_flag_view_4", Integer.valueOf(3));
        level.put(0, "ques_level_4");
        level.put(1, "ques_level_3");
        level.put(2, "ques_level_2");
        level.put(3, "ques_level_1");
        rence.put(0, "tbdts_flag_view_1");
        rence.put(1, "tbdts_flag_view_2");
        rence.put(2, "tbdts_flag_view_3");
        rence.put(3, "tbdts_flag_view_4");
    }
}
