package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.widget.EditText;
import java.lang.Character.UnicodeBlock;

/* compiled from: AlarmTitleRegexUtil */
public class C1886b {
    public static void m9648a(EditText editText) {
        editText.addTextChangedListener(new C1887c(editText));
    }

    public static boolean m9650a(String str) {
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            if (C1886b.m9649a(str.charAt(i))) {
                z = true;
            }
        }
        if (z) {
            if (str.length() <= 7) {
                return true;
            }
            return false;
        } else if (str.length() > 12) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean m9649a(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        return of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
    }
}
