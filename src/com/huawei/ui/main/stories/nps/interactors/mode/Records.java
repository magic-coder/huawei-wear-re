package com.huawei.ui.main.stories.nps.interactors.mode;

import java.util.HashMap;
import java.util.List;

public class Records {
    private static final HashMap<Integer, List<Integer>> dataCenter = new HashMap();
    private static final HashMap<Integer, String> optionResult = new HashMap();
    private static final HashMap<Integer, String> stringDataCenter = new HashMap();

    public static HashMap<Integer, List<Integer>> getDataCenter() {
        return dataCenter;
    }

    public static HashMap<Integer, String> getOptionResult() {
        return optionResult;
    }

    public static HashMap<Integer, String> getStringDataCenter() {
        return stringDataCenter;
    }

    public static boolean queryInt(Integer num) {
        return getStringDataCenter().containsKey(num);
    }

    public static boolean queryInt(List<Integer> list, Integer num) {
        return list.contains(num);
    }

    public static boolean deleteInt(List<Integer> list, Integer num) {
        return list.remove(num);
    }

    public static boolean addInt(List<Integer> list, Integer num) {
        return list.add(num);
    }

    public static void clearAllResult() {
        if (dataCenter != null) {
            dataCenter.clear();
        }
        if (optionResult != null) {
            optionResult.clear();
        }
        if (stringDataCenter != null) {
            stringDataCenter.clear();
        }
    }
}
