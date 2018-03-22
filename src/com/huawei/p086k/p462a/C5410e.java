package com.huawei.p086k.p462a;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: ReadKey */
public class C5410e {
    public static final String f19224a = C5410e.class.getSimpleName();
    private String f19225b;

    public C5410e(String str) {
        this.f19225b = str;
    }

    public String m26000a() {
        return m26001b();
    }

    public String m26001b() {
        BufferedReader bufferedReader;
        Throwable th;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(BaseApplication.b().getResources().getAssets().open(this.f19225b), "utf-8"));
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        C2538c.e(f19224a, new Object[]{e.getMessage()});
                    }
                }
                return stringBuffer.toString();
            } catch (FileNotFoundException e2) {
                try {
                    C2538c.c(f19224a, new Object[]{"the publickey file is not exist"});
                    if (bufferedReader != null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (IOException e3) {
                        C2538c.e(f19224a, new Object[]{e3.getMessage()});
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e32) {
                            C2538c.e(f19224a, new Object[]{e32.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                C2538c.c(f19224a, new Object[]{"read the publickey file has IOException"});
                if (bufferedReader != null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e322) {
                    C2538c.e(f19224a, new Object[]{e322.getMessage()});
                    return null;
                }
            }
        } catch (FileNotFoundException e5) {
            bufferedReader = null;
            C2538c.c(f19224a, new Object[]{"the publickey file is not exist"});
            if (bufferedReader != null) {
                return null;
            }
            bufferedReader.close();
            return null;
        } catch (IOException e6) {
            bufferedReader = null;
            C2538c.c(f19224a, new Object[]{"read the publickey file has IOException"});
            if (bufferedReader != null) {
                return null;
            }
            bufferedReader.close();
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
