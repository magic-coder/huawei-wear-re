package com.huawei.whitebox;

class NdkJniUtils {
    public native byte[] decrypt(byte[] bArr);

    public native byte[] encrypt(String str);

    public native void executeAuth(Object obj);

    public native String getD58c0();

    public native boolean isAuthChecked();

    NdkJniUtils() {
    }

    static {
        System.loadLibrary("whiteBoxJniLib");
    }
}
