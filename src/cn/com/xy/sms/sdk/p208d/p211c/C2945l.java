package cn.com.xy.sms.sdk.p208d.p211c;

public class C2945l {
    public static String m13271a() {
        return "create table  if not exists tb_phone_bubble_cache (  id INTEGER PRIMARY KEY, phone TEXT UNIQUE, minReceiveTime LONG default 0, maxReceiveTime LONG default 0, useBubbleViews TEXT, useBubbleLogoName TEXT, extend TEXT)";
    }
}
