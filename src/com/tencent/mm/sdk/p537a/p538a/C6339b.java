package com.tencent.mm.sdk.p537a.p538a;

import com.tencent.mm.p536a.C6335b;

public final class C6339b {
    public static byte[] m29022a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C6335b.m29020a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
