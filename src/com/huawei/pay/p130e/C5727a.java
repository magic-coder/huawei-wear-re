package com.huawei.pay.p130e;

import android.widget.EditText;
import android.widget.TextView;
import com.huawei.pay.p473a.p474a.p475a.C5565a;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: EditTextUtil */
public class C5727a {
    public static String m26397a(TextView textView, String str) {
        String charSequence = textView.getText().toString();
        if (C5730c.m26410a(charSequence)) {
            return DateLayout.NULL_DATE_FORMAT;
        }
        if (charSequence.matches(str)) {
            return "YES";
        }
        return "NO";
    }

    public static void m26398a(EditText editText, C5565a c5565a) {
        editText.addTextChangedListener(new C5729b(c5565a));
    }
}
