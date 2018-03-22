package com.huawei.android.pushagent.p018c.p027c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p019a.C4105g;
import com.huawei.android.pushagent.p018c.p019a.C4106i;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class C4116f {
    public static e m20150a(Context context, String str) {
        HttpsURLConnection httpsURLConnection;
        Throwable e;
        InputStream inputStream;
        Throwable th;
        String a = C4116f.m20151a(context, str, false);
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "queryTrs runing");
        InputStream inputStream2 = null;
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2;
        try {
            HttpsURLConnection a2 = C4116f.m20154a(context, a, str, false, false);
            if (a2 != null) {
                httpsURLConnection = a2;
            } else {
                try {
                    a2 = C4116f.m20154a(context, a, str, true, false);
                    if (a2 != null) {
                        httpsURLConnection = a2;
                    } else {
                        a2 = C4116f.m20154a(context, a, str, false, true);
                        if (a2 != null) {
                            httpsURLConnection = a2;
                        } else {
                            a2 = C4116f.m20154a(context, a, str, true, true);
                            if (a2 != null) {
                                httpsURLConnection = a2;
                            } else {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "after all, trs connect is null");
                                if (null != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e2) {
                                        com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                                    }
                                }
                                if (null != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                                    }
                                }
                                if (a2 == null) {
                                    return null;
                                }
                                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                                a2.disconnect();
                                return null;
                            }
                        }
                    }
                } catch (UnsupportedEncodingException e4) {
                    e = e4;
                    httpsURLConnection = a2;
                    inputStream = null;
                    bufferedReader2 = null;
                    try {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e.toString(), e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                            }
                        }
                        if (httpsURLConnection != null) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                            httpsURLConnection.disconnect();
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (Throwable e7) {
                            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", e7.toString(), e7);
                        }
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e8) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e9) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                            }
                        }
                        if (httpsURLConnection != null) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    e7 = e10;
                    httpsURLConnection = a2;
                    inputStream = null;
                    bufferedReader2 = null;
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e7.toString(), e7);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e12) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                        }
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                } catch (Exception e13) {
                    e7 = e13;
                    httpsURLConnection = a2;
                    inputStream = null;
                    bufferedReader2 = null;
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e7.toString(), e7);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e14) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e15) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                        }
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                } catch (Throwable e72) {
                    httpsURLConnection = a2;
                    inputStream = null;
                    bufferedReader2 = null;
                    th = e72;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            try {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "queryTrs connect() success");
                inputStream = httpsURLConnection.getInputStream();
            } catch (UnsupportedEncodingException e16) {
                e72 = e16;
                bufferedReader2 = null;
                inputStream = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e72.toString(), e72);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (IOException e17) {
                e72 = e17;
                bufferedReader2 = null;
                inputStream = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e72.toString(), e72);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (Exception e18) {
                e72 = e18;
                bufferedReader2 = null;
                inputStream = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e72.toString(), e72);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (Throwable e722) {
                bufferedReader2 = null;
                inputStream = null;
                th = e722;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, GameManager.DEFAULT_CHARSET));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        e eVar = new e(context, readLine);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e19) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e20) {
                                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                            }
                        }
                        if (httpsURLConnection != null) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                            httpsURLConnection.disconnect();
                        }
                        return eVar;
                    }
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "response is null");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e21) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close is err");
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e22) {
                            com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "close br err");
                        }
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                } catch (UnsupportedEncodingException e23) {
                    e722 = e23;
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                } catch (IOException e24) {
                    e722 = e24;
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                } catch (Exception e25) {
                    e722 = e25;
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (httpsURLConnection != null) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                        httpsURLConnection.disconnect();
                    }
                    Thread.sleep(2000);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                    return null;
                }
            } catch (UnsupportedEncodingException e26) {
                e722 = e26;
                bufferedReader2 = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (IOException e27) {
                e722 = e27;
                bufferedReader2 = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (Exception e28) {
                e722 = e28;
                bufferedReader2 = null;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e722.toString(), e722);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                Thread.sleep(2000);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
                return null;
            } catch (Throwable e7222) {
                bufferedReader2 = null;
                th = e7222;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (httpsURLConnection != null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                    httpsURLConnection.disconnect();
                }
                throw th;
            }
        } catch (UnsupportedEncodingException e29) {
            e7222 = e29;
            bufferedReader2 = null;
            httpsURLConnection = null;
            inputStream = null;
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e7222.toString(), e7222);
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (httpsURLConnection != null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                httpsURLConnection.disconnect();
            }
            Thread.sleep(2000);
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
            return null;
        } catch (IOException e30) {
            e7222 = e30;
            bufferedReader2 = null;
            httpsURLConnection = null;
            inputStream = null;
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e7222.toString(), e7222);
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (httpsURLConnection != null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                httpsURLConnection.disconnect();
            }
            Thread.sleep(2000);
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
            return null;
        } catch (Exception e31) {
            e7222 = e31;
            bufferedReader2 = null;
            httpsURLConnection = null;
            inputStream = null;
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "query trs err:" + e7222.toString(), e7222);
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (httpsURLConnection != null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                httpsURLConnection.disconnect();
            }
            Thread.sleep(2000);
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get IP/PORT failed, retry again.");
            return null;
        } catch (Throwable e72222) {
            bufferedReader2 = null;
            httpsURLConnection = null;
            inputStream = null;
            th = e72222;
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (httpsURLConnection != null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "disconnect the socket");
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static String m20151a(Context context, String str, boolean z) {
        String a = C4116f.m20153a("push.hicloud.com", str);
        if (z && a != null && a.length() > 0) {
            a = a.split(":")[0] + ":5222";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://").append(a).append("/TRSServer/TRSRequest3");
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "url:" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private static String m20152a(String str) {
        return str == null ? "" : str;
    }

    private static String m20153a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "belongId is null or trsAddress is null");
        } else if (str.startsWith("push")) {
            try {
                int parseInt = Integer.parseInt(str2.trim());
                if (parseInt <= 0) {
                    com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "belongId is invalid:" + parseInt);
                } else {
                    int indexOf = str.indexOf(".");
                    if (indexOf > -1) {
                        str = new StringBuffer().append(str.substring(0, indexOf)).append(parseInt).append(str.substring(indexOf)).toString();
                    }
                }
            } catch (Throwable e) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "belongId parseInt error: " + str2, e);
            } catch (Throwable e2) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", e2.getMessage(), e2);
            }
        } else {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "trsAddress is invalid:" + str);
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static javax.net.ssl.HttpsURLConnection m20154a(android.content.Context r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
        r0 = 0;
        if (r11 == 0) goto L_0x0007;
    L_0x0003:
        r8 = com.huawei.android.pushagent.p018c.p027c.C4116f.m20151a(r7, r9, r11);
    L_0x0007:
        if (r8 != 0) goto L_0x0011;
    L_0x0009:
        r1 = "PushLogAC2712";
        r2 = "TRSUrl is null, cannot create connection.";
        com.huawei.android.pushagent.c.a.e.a(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = "PushLogAC2712";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "TRS httpUrl = ";
        r2 = r2.append(r3);
        r2 = r2.append(r8);
        r3 = ",useDefaultPort = ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r2 = r2.toString();
        com.huawei.android.pushagent.c.a.e.a(r1, r2);
        r1 = com.huawei.android.pushagent.p018c.p027c.C4116f.m20156b(r7, r8, r10);	 Catch:{ IOException -> 0x00ee, Exception -> 0x00eb }
        r2 = "PushLogAC2712";
        r3 = "get connection success.";
        com.huawei.android.pushagent.c.a.e.a(r2, r3);	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        r1.connect();	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        r3 = r1.getOutputStream();	 Catch:{ Exception -> 0x0095, all -> 0x00d8 }
        r2 = com.huawei.android.pushagent.p018c.p027c.C4116f.m20155b(r7, r9);	 Catch:{ Exception -> 0x00f3 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ Exception -> 0x00f3 }
        r3.write(r2);	 Catch:{ Exception -> 0x00f3 }
        r3.flush();	 Catch:{ Exception -> 0x00f3 }
        if (r3 == 0) goto L_0x005a;
    L_0x0057:
        r3.close();	 Catch:{ Exception -> 0x0063, IOException -> 0x006e }
    L_0x005a:
        r2 = "PushLogAC2712";
        r3 = "call conn.connect() success";
        com.huawei.android.pushagent.c.a.e.a(r2, r3);	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        r0 = r1;
        goto L_0x0010;
    L_0x0063:
        r2 = move-exception;
        r3 = "PushLogAC2712";
        r4 = r2.toString();	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        com.huawei.android.pushagent.c.a.e.c(r3, r4, r2);	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        goto L_0x005a;
    L_0x006e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0072:
        r3 = "PushLogAC2712";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "connect to TRS cause IOException:";
        r4 = r4.append(r5);
        r1 = r1.toString();
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.huawei.android.pushagent.c.a.e.d(r3, r1);
        if (r2 == 0) goto L_0x0010;
    L_0x0090:
        r2.disconnect();
        goto L_0x0010;
    L_0x0095:
        r2 = move-exception;
        r3 = r0;
    L_0x0097:
        r4 = "PushLogAC2712";
        r5 = r2.toString();	 Catch:{ all -> 0x00f1 }
        com.huawei.android.pushagent.c.a.e.c(r4, r5, r2);	 Catch:{ all -> 0x00f1 }
        if (r3 == 0) goto L_0x005a;
    L_0x00a2:
        r3.close();	 Catch:{ Exception -> 0x00a6, IOException -> 0x006e }
        goto L_0x005a;
    L_0x00a6:
        r2 = move-exception;
        r3 = "PushLogAC2712";
        r4 = r2.toString();	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        com.huawei.android.pushagent.c.a.e.c(r3, r4, r2);	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        goto L_0x005a;
    L_0x00b1:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x00b5:
        r3 = "PushLogAC2712";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "connect to TRS cause Exception:";
        r4 = r4.append(r5);
        r5 = r1.toString();
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.huawei.android.pushagent.c.a.e.c(r3, r4, r1);
        if (r2 == 0) goto L_0x0010;
    L_0x00d3:
        r2.disconnect();
        goto L_0x0010;
    L_0x00d8:
        r2 = move-exception;
        r3 = r0;
    L_0x00da:
        if (r3 == 0) goto L_0x00df;
    L_0x00dc:
        r3.close();	 Catch:{ Exception -> 0x00e0, IOException -> 0x006e }
    L_0x00df:
        throw r2;	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
    L_0x00e0:
        r3 = move-exception;
        r4 = "PushLogAC2712";
        r5 = r3.toString();	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        com.huawei.android.pushagent.c.a.e.c(r4, r5, r3);	 Catch:{ IOException -> 0x006e, Exception -> 0x00b1 }
        goto L_0x00df;
    L_0x00eb:
        r1 = move-exception;
        r2 = r0;
        goto L_0x00b5;
    L_0x00ee:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0072;
    L_0x00f1:
        r2 = move-exception;
        goto L_0x00da;
    L_0x00f3:
        r2 = move-exception;
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.f.a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):javax.net.ssl.HttpsURLConnection");
    }

    private static String m20155b(Context context, String str) {
        String h = a.h(context);
        String a = a.a(context);
        String a2 = a.a(context);
        String str2 = "";
        String g = a.g(context);
        String c = a.c();
        String packageName = context.getPackageName();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mccmnc", C4116f.m20152a(h));
            jSONObject.put("PushID", C4116f.m20152a(a));
            jSONObject.put("udid", C4116f.m20152a(a2));
            jSONObject.put("belongid", C4116f.m20152a(str));
            jSONObject.put("version", C4116f.m20152a(g));
            jSONObject.put("protocolversion", "2.0");
            jSONObject.put("info", 0);
            jSONObject.put("channel", C4116f.m20152a(packageName));
            jSONObject.put(IssuerInfoColumns.COLUMN_NAME_MODE, C4116f.m20152a(Build.MODEL));
            jSONObject.put("mac", C4116f.m20152a(str2));
            jSONObject.put("intelligent", 3);
            jSONObject.put("emV", C4116f.m20152a(c));
            jSONObject.put("rV", C4116f.m20152a(Build.DISPLAY));
        } catch (JSONException e) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", e.toString());
        }
        return jSONObject.toString();
    }

    private static HttpsURLConnection m20156b(Context context, String str, boolean z) throws Exception {
        String property;
        int parseInt;
        Exception e;
        HttpsURLConnection httpsURLConnection;
        SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
        instance.init(null, new TrustManager[]{new C4106i(context)}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(new C4105g(instance.getSocketFactory()));
        HttpsURLConnection.setDefaultHostnameVerifier(new C4117g());
        if (z && 1 != C4103b.m20122a(context)) {
            try {
                if (VERSION.SDK_INT >= 11) {
                    property = System.getProperty("http.proxyHost");
                    try {
                        String property2 = System.getProperty("http.proxyPort");
                        if (property2 == null) {
                            property2 = "-1";
                        }
                        parseInt = Integer.parseInt(property2);
                    } catch (Exception e2) {
                        e = e2;
                        com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "get proxy ip or port error:" + e.getMessage());
                        parseInt = -1;
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "use Proxy " + property + ":" + parseInt + " to open:" + str);
                        httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(property, parseInt)));
                        if (httpsURLConnection == null) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "direct to open " + str);
                            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                        }
                        httpsURLConnection.setConnectTimeout(((int) com.huawei.android.pushagent.b.b.a.a(context).u()) * 1000);
                        httpsURLConnection.setReadTimeout((int) (com.huawei.android.pushagent.b.b.a.a(context).v() * 1000));
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                        httpsURLConnection.setRequestProperty("Content-type", "json/text; charset=UTF-8");
                        return httpsURLConnection;
                    }
                    if (!(property == null || property.length() <= 0 || parseInt == -1)) {
                        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "use Proxy " + property + ":" + parseInt + " to open:" + str);
                        httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(property, parseInt)));
                        if (httpsURLConnection == null) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "direct to open " + str);
                            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                        }
                        httpsURLConnection.setConnectTimeout(((int) com.huawei.android.pushagent.b.b.a.a(context).u()) * 1000);
                        httpsURLConnection.setReadTimeout((int) (com.huawei.android.pushagent.b.b.a.a(context).v() * 1000));
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                        httpsURLConnection.setRequestProperty("Content-type", "json/text; charset=UTF-8");
                        return httpsURLConnection;
                    }
                }
                property = android.net.Proxy.getHost(context);
                parseInt = android.net.Proxy.getPort(context);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "use Proxy " + property + ":" + parseInt + " to open:" + str);
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(property, parseInt)));
                if (httpsURLConnection == null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "direct to open " + str);
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                }
                httpsURLConnection.setConnectTimeout(((int) com.huawei.android.pushagent.b.b.a.a(context).u()) * 1000);
                httpsURLConnection.setReadTimeout((int) (com.huawei.android.pushagent.b.b.a.a(context).v() * 1000));
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                httpsURLConnection.setRequestProperty("Content-type", "json/text; charset=UTF-8");
                return httpsURLConnection;
            } catch (Exception e3) {
                e = e3;
                property = null;
                com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "get proxy ip or port error:" + e.getMessage());
                parseInt = -1;
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "use Proxy " + property + ":" + parseInt + " to open:" + str);
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(property, parseInt)));
                if (httpsURLConnection == null) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "direct to open " + str);
                    httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                }
                httpsURLConnection.setConnectTimeout(((int) com.huawei.android.pushagent.b.b.a.a(context).u()) * 1000);
                httpsURLConnection.setReadTimeout((int) (com.huawei.android.pushagent.b.b.a.a(context).v() * 1000));
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                httpsURLConnection.setRequestProperty("Content-type", "json/text; charset=UTF-8");
                return httpsURLConnection;
            }
        }
        httpsURLConnection = null;
        if (httpsURLConnection == null) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "direct to open " + str);
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        }
        httpsURLConnection.setConnectTimeout(((int) com.huawei.android.pushagent.b.b.a.a(context).u()) * 1000);
        httpsURLConnection.setReadTimeout((int) (com.huawei.android.pushagent.b.b.a.a(context).v() * 1000));
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpsURLConnection.setRequestProperty("Content-type", "json/text; charset=UTF-8");
        return httpsURLConnection;
    }
}
