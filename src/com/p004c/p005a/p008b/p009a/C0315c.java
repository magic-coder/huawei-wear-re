package com.p004c.p005a.p008b.p009a;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0315c {
    public static SharedPreferences m149a(Context context, String str) {
        return context.getSharedPreferences("hianalytics_" + str + HwAccountConstants.SPLIIT_UNDERLINE + context.getPackageName(), 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m150a(android.content.Context r4, org.json.JSONObject r5, java.lang.String r6) {
        /*
        r1 = com.p004c.p005a.p008b.p009a.C0315c.m153d(r4, r6);
        r0 = 0;
        r2 = 0;
        r0 = r4.openFileOutput(r1, r2);	 Catch:{ FileNotFoundException -> 0x0020, IOException -> 0x002c, all -> 0x0038 }
        r1 = r5.toString();	 Catch:{ FileNotFoundException -> 0x0020, IOException -> 0x002c, all -> 0x004c }
        r2 = "UTF-8";
        r1 = r1.getBytes(r2);	 Catch:{ FileNotFoundException -> 0x0020, IOException -> 0x002c, all -> 0x004c }
        r0.write(r1);	 Catch:{ FileNotFoundException -> 0x0020, IOException -> 0x002c, all -> 0x004c }
        r0.flush();	 Catch:{ FileNotFoundException -> 0x0020, IOException -> 0x002c, all -> 0x004c }
        if (r0 == 0) goto L_0x001f;
    L_0x001c:
        r0.close();	 Catch:{ IOException -> 0x0047 }
    L_0x001f:
        return;
    L_0x0020:
        r1 = move-exception;
        if (r0 == 0) goto L_0x001f;
    L_0x0023:
        r0.close();	 Catch:{ IOException -> 0x0027 }
        goto L_0x001f;
    L_0x0027:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001f;
    L_0x002c:
        r1 = move-exception;
        if (r0 == 0) goto L_0x001f;
    L_0x002f:
        r0.close();	 Catch:{ IOException -> 0x0033 }
        goto L_0x001f;
    L_0x0033:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001f;
    L_0x0038:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();	 Catch:{ IOException -> 0x0042 }
    L_0x0041:
        throw r0;
    L_0x0042:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0041;
    L_0x0047:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001f;
    L_0x004c:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.a.c.a(android.content.Context, org.json.JSONObject, java.lang.String):void");
    }

    public static JSONObject m151b(Context context, String str) {
        FileInputStream openFileInput;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream;
        JSONException e;
        Exception e2;
        Throwable th;
        try {
            openFileInput = context.openFileInput(C0315c.m153d(context, str));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(openFileInput, GameManager.DEFAULT_CHARSET));
                try {
                    StringBuffer stringBuffer = new StringBuffer("");
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    if (stringBuffer.length() == 0) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (openFileInput == null) {
                            return null;
                        }
                        try {
                            openFileInput.close();
                            return null;
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            return null;
                        }
                    }
                    JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e42) {
                            e42.printStackTrace();
                        }
                    }
                    return jSONObject;
                } catch (FileNotFoundException e5) {
                    bufferedReader2 = bufferedReader;
                    fileInputStream = openFileInput;
                } catch (IOException e6) {
                } catch (JSONException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e2 = e8;
                }
            } catch (FileNotFoundException e9) {
                bufferedReader2 = null;
                fileInputStream = openFileInput;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e3222) {
                    e3222.printStackTrace();
                    return null;
                }
            } catch (IOException e10) {
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e32222) {
                        e32222.printStackTrace();
                    }
                }
                if (openFileInput != null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (IOException e322222) {
                    e322222.printStackTrace();
                    return null;
                }
            } catch (JSONException e11) {
                e = e11;
                bufferedReader = null;
                try {
                    e.printStackTrace();
                    C0315c.m152c(context, str);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3222222) {
                            e3222222.printStackTrace();
                        }
                    }
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e32222222) {
                        e32222222.printStackTrace();
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e322222222) {
                            e322222222.printStackTrace();
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3222222222) {
                            e3222222222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e2 = e12;
                bufferedReader = null;
                e2.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e32222222222) {
                        e32222222222.printStackTrace();
                    }
                }
                if (openFileInput != null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (IOException e322222222222) {
                    e322222222222.printStackTrace();
                    return null;
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e13) {
            bufferedReader2 = null;
            fileInputStream = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e14) {
            bufferedReader = null;
            openFileInput = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (JSONException e15) {
            e = e15;
            bufferedReader = null;
            openFileInput = null;
            e.printStackTrace();
            C0315c.m152c(context, str);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Exception e16) {
            e2 = e16;
            bufferedReader = null;
            openFileInput = null;
            e2.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th32) {
            bufferedReader = null;
            openFileInput = null;
            th = th32;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    public static void m152c(Context context, String str) {
        context.deleteFile(C0315c.m153d(context, str));
    }

    private static String m153d(Context context, String str) {
        return "hianalytics_" + str + HwAccountConstants.SPLIIT_UNDERLINE + context.getPackageName();
    }
}
