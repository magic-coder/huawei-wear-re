package com.huawei.ui.device.p170a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: OneLevelMenuInteractor */
public class af {
    private static af f6861b;
    private long f6862a = 0;
    private HashMap<Integer, Integer> f6863c = new ag(this);

    public static af m10306a() {
        if (f6861b == null) {
            f6861b = new af();
        }
        return f6861b;
    }

    public String m10308a(Context context, int i) {
        if (!this.f6863c.containsKey(Integer.valueOf(i))) {
            return context.getResources().getString(i.IDS_settings_one_level_menu_settings_item_text_id1);
        }
        return context.getResources().getString(((Integer) this.f6863c.get(Integer.valueOf(i))).intValue());
    }

    public boolean m10310a(int i) {
        if (this.f6863c.containsKey(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> m10309a(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        Map hashMap = new HashMap(arrayList.size() + arrayList2.size());
        ArrayList<Integer> arrayList3 = new ArrayList();
        if (arrayList2.size() <= arrayList.size()) {
            ArrayList<Integer> arrayList4 = arrayList2;
            arrayList2 = arrayList;
            arrayList = arrayList4;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            hashMap.put((Integer) it.next(), Integer.valueOf(1));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            Integer num2 = (Integer) hashMap.get(num);
            if (num2 != null) {
                hashMap.put(num, Integer.valueOf(num2.intValue() + 1));
            } else {
                hashMap.put(num, Integer.valueOf(1));
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                arrayList3.add(entry.getKey());
            }
        }
        return arrayList3;
    }

    public boolean m10311b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (1000 > currentTimeMillis - this.f6862a) {
            C2538c.m12677c("OneLevelMenuInteractor", "onClick", ">_< >_< click too much");
            this.f6862a = currentTimeMillis;
            return true;
        }
        this.f6862a = currentTimeMillis;
        return false;
    }

    public boolean m10312b(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (!((Integer) arrayList.get(i)).equals(arrayList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int m10307a(byte b) {
        if ((b & 128) <= 0) {
            return b;
        }
        b -= 128;
        if (b < (byte) 0) {
            return b + 256;
        }
        return b;
    }
}
