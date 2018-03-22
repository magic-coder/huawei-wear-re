package cmb.pb.cmbsafe;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.Keyboard.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class C2861a {
    public static void m12957a(Keyboard keyboard) {
        int i;
        List arrayList = new ArrayList();
        List keys = keyboard.getKeys();
        int size = keys.size();
        for (i = 0; i < size; i++) {
            int i2 = ((Key) keys.get(i)).codes[0];
            if (i2 >= 48 && i2 <= 57) {
                arrayList.add((Key) keys.get(i));
            }
        }
        int size2 = arrayList.size();
        Random random = new Random();
        for (size = 0; size < size2; size++) {
            int nextInt = random.nextInt(size2);
            int i3 = ((Key) arrayList.get(size)).codes[0];
            CharSequence charSequence = ((Key) arrayList.get(size)).label;
            ((Key) arrayList.get(size)).codes[0] = ((Key) arrayList.get(nextInt)).codes[0];
            ((Key) arrayList.get(size)).label = ((Key) arrayList.get(nextInt)).label;
            ((Key) arrayList.get(nextInt)).codes[0] = i3;
            ((Key) arrayList.get(nextInt)).label = charSequence;
        }
        size = 0;
        int i4 = 0;
        while (size < size2) {
            i2 = ((Key) keys.get(size)).codes[0];
            if (i2 >= 48 && i2 <= 57) {
                ((Key) keys.get(size)).codes[0] = ((Key) arrayList.get(i4)).codes[0];
                ((Key) keys.get(size)).label = ((Key) arrayList.get(i4)).label;
            }
            i = i4 + 1;
            if (i != arrayList.size()) {
                size++;
                i4 = i;
            } else {
                return;
            }
        }
    }
}
