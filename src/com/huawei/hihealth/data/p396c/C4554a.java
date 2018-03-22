package com.huawei.hihealth.data.p396c;

import android.util.SparseArray;

/* compiled from: HiDeviceType */
public class C4554a {
    private static final SparseArray<String> f16769a = new SparseArray();

    static {
        f16769a.put(21, "B1手环");
        f16769a.put(22, "B2手环");
        f16769a.put(23, "color band");
        f16769a.put(28, "糖护士血糖仪");
        f16769a.put(24, "康康血压");
        f16769a.put(29, "乐心血压");
        f16769a.put(31, "乐心体重计");
        f16769a.put(26, "Mio");
        f16769a.put(25, "木木血压");
        f16769a.put(27, "有品体重计");
        f16769a.put(30, "手机记步");
        f16769a.put(1, "手动输入");
        f16769a.put(33, "欧姆龙血压计");
        f16769a.put(34, "强生血糖仪");
        f16769a.put(32, "手机GPS");
        f16769a.put(35, "B0手环");
        f16769a.put(36, "w1手表");
        f16769a.put(37, "W1_INTERNAL");
        f16769a.put(38, "N1");
        f16769a.put(39, "B3");
        f16769a.put(40, "JOHNSON1");
        f16769a.put(41, "METIS");
        f16769a.put(42, "NYX手环");
        f16769a.put(43, "R1耳机");
        f16769a.put(44, "A1_PLUS");
        f16769a.put(45, "GRUS");
        f16769a.put(46, "LEO");
        f16769a.put(47, "ERIS");
        f16769a.put(48, "华为体脂称");
        f16769a.put(50, "JOHNSON2");
        f16769a.put(51, "AW600");
        f16769a.put(52, "jabra耳机");
        f16769a.put(53, "polar心率带");
        f16769a.put(54, "鱼跃设备");
        f16769a.put(55, "S1pro");
        f16769a.put(56, "云康宝智能体脂称");
        f16769a.put(61, "k1手环");
        f16769a.put(62, "K2手环");
    }

    public static String m21803a(int i) {
        String str = (String) f16769a.get(i);
        if (str == null) {
            return "";
        }
        return str;
    }
}
