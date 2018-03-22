package com.huawei.pluginaf500.p498b;

import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3619b;
import com.fenda.hwbracelet.mode.C3620c;
import com.fenda.hwbracelet.mode.C3621d;
import com.fenda.hwbracelet.mode.C3627j;
import com.fenda.hwbracelet.mode.C3628k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapteManager */
public class C5774a {
    public static C3619b m26500a(Alarm alarm, byte b) {
        if (alarm == null) {
            return null;
        }
        int i;
        byte onOff = (byte) alarm.getOnOff();
        int i2 = ((alarm.getMon() == 1 ? 1 : 0) | (alarm.getSun() == 1 ? 64 : 0)) | (alarm.getTue() == 1 ? 2 : 0);
        if (alarm.getWed() == 1) {
            i = 4;
        } else {
            i = 0;
        }
        i2 = ((i2 | i) | (alarm.getThu() == 1 ? 8 : 0)) | (alarm.getFri() == 1 ? 16 : 0);
        if (alarm.getSta() == 1) {
            i = 32;
        } else {
            i = 0;
        }
        byte b2 = (byte) (i | i2);
        String[] split = alarm.getTime().split(":");
        return new C3619b((byte) (b + 1), onOff, (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]), b2);
    }

    public static C3620c m26501a(List<Alarm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C3619b a = C5774a.m26500a((Alarm) list.get(i), (byte) i);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return new C3620c(arrayList);
    }

    public static C3621d m26502a(C3627j c3627j) {
        if (c3627j == null) {
            return null;
        }
        String[] split = c3627j.m18183g().split(":");
        String[] split2 = c3627j.m18186h().split(":");
        byte parseInt = (byte) Integer.parseInt(split[0]);
        return new C3621d(true, (parseInt * 60) + ((byte) Integer.parseInt(split[1])), ((byte) Integer.parseInt(split2[1])) + (((byte) Integer.parseInt(split2[0])) * 60));
    }

    public static C3628k m26503b(C3627j c3627j) {
        if (c3627j == null) {
            return null;
        }
        boolean z = c3627j.m18165a() == 1;
        byte b = (byte) c3627j.m18168b();
        String[] split = c3627j.m18171c().split(":");
        String[] split2 = c3627j.m18174d().split(":");
        String[] split3 = c3627j.m18177e().split(":");
        String[] split4 = c3627j.m18180f().split(":");
        return new C3628k(z, ((byte) Integer.parseInt(split[1])) + (((byte) Integer.parseInt(split[0])) * 60), ((byte) Integer.parseInt(split2[1])) + (((byte) Integer.parseInt(split2[0])) * 60), ((byte) Integer.parseInt(split3[1])) + (((byte) Integer.parseInt(split3[0])) * 60), (((byte) Integer.parseInt(split4[0])) * 60) + ((byte) Integer.parseInt(split4[1])), b, (byte) c3627j.m18189i());
    }
}
