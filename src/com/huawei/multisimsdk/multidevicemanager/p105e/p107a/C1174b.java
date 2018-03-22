package com.huawei.multisimsdk.multidevicemanager.p105e.p107a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: EncryptFileUtils */
public class C1174b {
    private static String f2573a = null;

    public static String m5252a(Context context) {
        if (f2573a == null) {
            Object a = C1174b.m5253a(context, "encodehwmultisim");
            if (TextUtils.isEmpty(a)) {
                byte[] a2 = C1173a.m5247a();
                if (a2.length == 0) {
                    return null;
                }
                String a3 = C1173a.m5246a(a2);
                C1174b.m5257a(context, a3, "encodehwmultisim");
                f2573a = a3;
            } else {
                f2573a = a;
            }
        }
        return f2573a;
    }

    public static void m5257a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int[] a = C1174b.m5261a(str, str2);
            C1174b.m5258a(context, a, str2);
            C1174b.m5259a(context, C1174b.m5262a(str, a), str2);
        }
    }

    public static String m5253a(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        int[] b = C1174b.m5265b(context, str);
        if (b.length <= 0) {
            return stringBuffer.toString();
        }
        int length = b.length;
        for (int i = 0; i < length; i++) {
            String a = C1174b.m5254a(C1174b.m5266c(context, C1174b.m5263b(str + i)));
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            if (i == length / 2) {
                stringBuffer.append(String.copyValueOf(C1174b.m5260a(a.toCharArray(), false)));
            } else {
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    private static String[] m5262a(String str, int[] iArr) {
        int i = 0;
        String[] strArr = new String[iArr.length];
        if (!TextUtils.isEmpty(str) && iArr.length > 0) {
            int i2 = 0;
            while (i < iArr.length) {
                try {
                    if (i == iArr.length / 2) {
                        strArr[i] = String.copyValueOf(C1174b.m5260a(str.substring(i2, iArr[i] + i2).toCharArray(), true));
                    } else {
                        strArr[i] = str.substring(i2, iArr[i] + i2);
                    }
                    i2 += iArr[i];
                    i++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        return strArr;
    }

    private static char[] m5260a(char[] cArr, boolean z) {
        int i = 0;
        char[] cArr2 = new char[cArr.length];
        int length;
        int i2;
        if (z) {
            length = cArr.length;
            i2 = 0;
            while (i < length) {
                cArr2[i2] = (char) (cArr[i] + 2);
                i2++;
                i++;
            }
        } else {
            length = cArr.length;
            i2 = 0;
            while (i < length) {
                cArr2[i2] = (char) (cArr[i] - 2);
                i2++;
                i++;
            }
        }
        return cArr2;
    }

    private static void m5258a(Context context, int[] iArr, String str) {
        if (iArr != null && iArr.length > 0 && !TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i : iArr) {
                stringBuffer.append(i + "/");
            }
            try {
                C1174b.m5267c(C1174b.m5266c(context, C1174b.m5263b(str)), stringBuffer.substring(0, stringBuffer.length() - 1));
            } catch (IOException e) {
                C1183h.m5286d("EncryptFileUtils", "saveIndexFile->saveStrs " + e.toString());
            }
        }
    }

    private static int[] m5265b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = C1174b.m5254a(C1174b.m5266c(context, C1174b.m5263b(str))).split("/");
        if (split.length <= 0) {
            return new int[0];
        }
        int[] iArr = new int[split.length];
        int i = 0;
        while (i < split.length) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
                i++;
            } catch (NumberFormatException e) {
                return new int[0];
            }
        }
        return iArr;
    }

    private static String m5254a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return str2;
        }
        return C1174b.m5256a(new File(str)).toString();
    }

    private static void m5259a(Context context, String[] strArr, String str) {
        if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(str) && context != null) {
            for (int i = 0; i < strArr.length; i++) {
                try {
                    C1174b.m5267c(C1174b.m5266c(context, C1174b.m5263b(str + i)), strArr[i]);
                } catch (IOException e) {
                    C1183h.m5286d("EncryptFileUtils", "saveStrsToFile->saveStrs " + e.toString());
                }
            }
        }
    }

    private static String m5266c(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return "";
        }
        return context.getFilesDir() + File.separator + str;
    }

    public static int[] m5261a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.length() < 16 || TextUtils.isEmpty(str2)) {
            return new int[0];
        }
        return new int[]{3, 4, 4, 3, str.length() - 14};
    }

    private static String m5263b(String str) {
        return C1174b.m5264b(str, "SHA-1");
    }

    public static String m5264b(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(str.getBytes(GameManager.DEFAULT_CHARSET));
            return C1174b.m5255a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        } catch (Exception e2) {
            return "";
        }
    }

    private static String m5255a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private static void m5267c(String str, String str2) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str, true), GameManager.DEFAULT_CHARSET);
        try {
            outputStreamWriter.write(str2);
        } finally {
            outputStreamWriter.close();
        }
    }

    private static StringBuffer m5256a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        IOException e;
        FileNotFoundException e2;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream2;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader2 = new InputStreamReader(fileInputStream, GameManager.DEFAULT_CHARSET);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    try {
                        char[] cArr = new char[4096];
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            stringBuffer.append(cArr, 0, read);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        inputStreamReader = inputStreamReader2;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e5) {
                        e322 = e5;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                    }
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    bufferedReader = null;
                    inputStreamReader = inputStreamReader2;
                    fileInputStream2 = fileInputStream;
                    try {
                        C1183h.m5286d("EncryptFileUtils", "getFileContent FileNotFoundException " + e2.toString());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3222) {
                                e3222.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e32222) {
                                e32222.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e322222) {
                                e322222.printStackTrace();
                            }
                        }
                        return stringBuffer;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        inputStreamReader2 = inputStreamReader;
                        bufferedReader2 = bufferedReader;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e72) {
                                e72.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e722) {
                                e722.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e322222 = e8;
                    try {
                        C1183h.m5286d("EncryptFileUtils", "getFileContent IOException " + e322222.toString());
                        if (file.delete()) {
                            C1183h.m5286d("EncryptFileUtils", "IOException in EncryptFileUtils");
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3222222) {
                                e3222222.printStackTrace();
                            }
                        }
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e32222222) {
                                e32222222.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e322222222) {
                                e322222222.printStackTrace();
                            }
                        }
                        return stringBuffer;
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e9) {
                e2 = e9;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                C1183h.m5286d("EncryptFileUtils", "getFileContent FileNotFoundException " + e2.toString());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return stringBuffer;
            } catch (IOException e10) {
                e322222222 = e10;
                inputStreamReader2 = null;
                C1183h.m5286d("EncryptFileUtils", "getFileContent IOException " + e322222222.toString());
                if (file.delete()) {
                    C1183h.m5286d("EncryptFileUtils", "IOException in EncryptFileUtils");
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return stringBuffer;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader2 = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            bufferedReader = null;
            fileInputStream2 = null;
            C1183h.m5286d("EncryptFileUtils", "getFileContent FileNotFoundException " + e2.toString());
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer;
        } catch (IOException e12) {
            e322222222 = e12;
            inputStreamReader2 = null;
            fileInputStream = null;
            C1183h.m5286d("EncryptFileUtils", "getFileContent IOException " + e322222222.toString());
            if (file.delete()) {
                C1183h.m5286d("EncryptFileUtils", "IOException in EncryptFileUtils");
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return stringBuffer;
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader2 = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        return stringBuffer;
    }
}
