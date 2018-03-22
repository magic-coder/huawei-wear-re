package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

final class C6238b extends C6237f {
    C6238b(Context context) {
        super(context);
    }

    protected final void mo5283a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            C6236a.m28666a(Environment.getExternalStorageDirectory() + "/" + C6243h.m28696c("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C6243h.m28696c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
    }

    protected final boolean mo5284a() {
        return C6243h.m28692a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    protected final String mo5285b() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                for (String str2 : C6236a.m28667a(new File(Environment.getExternalStorageDirectory(), C6243h.m28696c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(C6243h.m28696c("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Log.w("MID", e);
                str2 = null;
            }
        }
        return str2;
    }
}
