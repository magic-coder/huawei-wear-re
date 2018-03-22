package com.huawei.nfc.carrera.server.card.impl.http;

import android.content.Context;
import android.util.Log;
import com.huawei.aj.p315a.C4023a;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.WalletSSLSocketFactory;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpConnTask<Result, RequestParams> {
    private static final int DEFAULT_TIMEOUT = 30000;
    protected static final int ERROR_CODE_CONNECTION_FAILED = -2;
    protected static final int ERROR_CODE_NO_NETWORK = -1;
    protected static final int ERROR_CODE_PARAMS_ERROR = -3;
    protected static final int ERROR_CODE_SERVER_OVERLOAD = -4;
    private static final int SERVER_OVERLOAD_ERRORCODE = 503;
    private static final String TAG = "HttpConnTask";
    private int mConnTimeout = 30000;
    protected Context mContext;
    private int mSocketTimeout = 30000;
    private final String mUrl;

    protected abstract String prepareRequestStr(RequestParams requestParams);

    protected abstract Result readErrorResponse(int i);

    protected abstract Result readSuccessResponse(int i, String str, JSONObject jSONObject);

    public HttpConnTask(Context context, String str) {
        this.mContext = context;
        this.mUrl = str;
    }

    public HttpConnTask(Context context, String str, int i, int i2) {
        this.mContext = context;
        this.mUrl = str;
        this.mConnTimeout = i;
        this.mSocketTimeout = i2;
    }

    public Result processTask(RequestParams requestParams) {
        HttpURLConnection openHttpsConnection;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        Result readErrorResponse;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream2;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (C4026a.m19819a(this.mContext)) {
            String prepareRequestStr = prepareRequestStr(requestParams);
            if (prepareRequestStr == null) {
                LogX.d("processTask, invalid request params.");
                return readErrorResponse(-3);
            }
            try {
                URL url = new URL(this.mUrl);
                C2538c.b(TAG, new Object[]{"processTask, check url." + url});
                if ("https".equals(url.getProtocol())) {
                    openHttpsConnection = openHttpsConnection(url);
                } else {
                    openHttpsConnection = openHttpConnection(url);
                }
                try {
                    openHttpsConnection.setConnectTimeout(this.mConnTimeout);
                    openHttpsConnection.setReadTimeout(this.mSocketTimeout);
                    openHttpsConnection.setDoInput(true);
                    openHttpsConnection.setDoOutput(true);
                    openHttpsConnection.setUseCaches(false);
                    openHttpsConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    openHttpsConnection.setRequestProperty("Content-Type", "xml/json");
                    openHttpsConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
                    openHttpsConnection.connect();
                    dataOutputStream = new DataOutputStream(openHttpsConnection.getOutputStream());
                } catch (MalformedURLException e) {
                    inputStream = null;
                    dataOutputStream = null;
                    try {
                        LogX.e("processTask url invalid.");
                        readErrorResponse = readErrorResponse(-3);
                        closeStream(dataOutputStream, inputStream, byteArrayOutputStream2, openHttpsConnection);
                        return readErrorResponse;
                    } catch (Throwable th2) {
                        httpURLConnection = openHttpsConnection;
                        dataOutputStream2 = dataOutputStream;
                        inputStream2 = inputStream;
                        th = th2;
                        closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    th = e2;
                    inputStream2 = null;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = null;
                    try {
                        LogX.e("processTask, NoSuchAlgorithmException : " + Log.getStackTraceString(th), true);
                        readErrorResponse = readErrorResponse(-2);
                        closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                        return readErrorResponse;
                    } catch (Throwable th3) {
                        th = th3;
                        closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                        throw th;
                    }
                } catch (KeyManagementException e3) {
                    th = e3;
                    inputStream2 = null;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = null;
                    LogX.e("processTask, KeyManagementException : " + Log.getStackTraceString(th), true);
                    readErrorResponse = readErrorResponse(-2);
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    return readErrorResponse;
                } catch (IOException e4) {
                    th = e4;
                    inputStream2 = null;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = null;
                    LogX.e("processTask IOException : " + Log.getStackTraceString(th), true);
                    readErrorResponse = readErrorResponse(-2);
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    return readErrorResponse;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = null;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = null;
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    throw th;
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream3;
                    InputStream inputStream3;
                    LogX.d("processTask request string : " + prepareRequestStr, true);
                    dataOutputStream.write(prepareRequestStr.getBytes(GameManager.DEFAULT_CHARSET));
                    dataOutputStream.flush();
                    int responseCode = openHttpsConnection.getResponseCode();
                    LogX.d("processTask connection result code : " + responseCode, true);
                    if (200 == responseCode) {
                        InputStream inputStream4 = openHttpsConnection.getInputStream();
                        try {
                            byteArrayOutputStream3 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream4.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream3.write(bArr, 0, read);
                                }
                                InputStream inputStream5 = inputStream4;
                                readErrorResponse = handleResponse(new String(byteArrayOutputStream3.toByteArray(), GameManager.DEFAULT_CHARSET));
                                inputStream3 = inputStream5;
                            } catch (MalformedURLException e5) {
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                inputStream = inputStream4;
                                LogX.e("processTask url invalid.");
                                readErrorResponse = readErrorResponse(-3);
                                closeStream(dataOutputStream, inputStream, byteArrayOutputStream2, openHttpsConnection);
                                return readErrorResponse;
                            } catch (Throwable e6) {
                                httpURLConnection = openHttpsConnection;
                                dataOutputStream2 = dataOutputStream;
                                inputStream2 = inputStream4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                th = e6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                LogX.e("processTask, NoSuchAlgorithmException : " + Log.getStackTraceString(th), true);
                                readErrorResponse = readErrorResponse(-2);
                                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                                return readErrorResponse;
                            } catch (Throwable e62) {
                                httpURLConnection = openHttpsConnection;
                                dataOutputStream2 = dataOutputStream;
                                inputStream2 = inputStream4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                th = e62;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                LogX.e("processTask, KeyManagementException : " + Log.getStackTraceString(th), true);
                                readErrorResponse = readErrorResponse(-2);
                                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                                return readErrorResponse;
                            } catch (Throwable e622) {
                                httpURLConnection = openHttpsConnection;
                                dataOutputStream2 = dataOutputStream;
                                inputStream2 = inputStream4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                th = e622;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                LogX.e("processTask IOException : " + Log.getStackTraceString(th), true);
                                readErrorResponse = readErrorResponse(-2);
                                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                                return readErrorResponse;
                            } catch (Throwable e6222) {
                                httpURLConnection = openHttpsConnection;
                                dataOutputStream2 = dataOutputStream;
                                inputStream2 = inputStream4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                th = e6222;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                                throw th;
                            }
                        } catch (MalformedURLException e7) {
                            inputStream = inputStream4;
                            LogX.e("processTask url invalid.");
                            readErrorResponse = readErrorResponse(-3);
                            closeStream(dataOutputStream, inputStream, byteArrayOutputStream2, openHttpsConnection);
                            return readErrorResponse;
                        } catch (NoSuchAlgorithmException e8) {
                            th = e8;
                            httpURLConnection = openHttpsConnection;
                            dataOutputStream2 = dataOutputStream;
                            inputStream2 = inputStream4;
                            LogX.e("processTask, NoSuchAlgorithmException : " + Log.getStackTraceString(th), true);
                            readErrorResponse = readErrorResponse(-2);
                            closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                            return readErrorResponse;
                        } catch (KeyManagementException e9) {
                            th = e9;
                            httpURLConnection = openHttpsConnection;
                            dataOutputStream2 = dataOutputStream;
                            inputStream2 = inputStream4;
                            LogX.e("processTask, KeyManagementException : " + Log.getStackTraceString(th), true);
                            readErrorResponse = readErrorResponse(-2);
                            closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                            return readErrorResponse;
                        } catch (IOException e10) {
                            th = e10;
                            httpURLConnection = openHttpsConnection;
                            dataOutputStream2 = dataOutputStream;
                            inputStream2 = inputStream4;
                            LogX.e("processTask IOException : " + Log.getStackTraceString(th), true);
                            readErrorResponse = readErrorResponse(-2);
                            closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                            return readErrorResponse;
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection = openHttpsConnection;
                            dataOutputStream2 = dataOutputStream;
                            inputStream2 = inputStream4;
                            closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                            throw th;
                        }
                    } else if (503 == responseCode) {
                        readErrorResponse = readErrorResponse(-4);
                        byteArrayOutputStream3 = null;
                    } else {
                        readErrorResponse = readErrorResponse(-2);
                        byteArrayOutputStream3 = null;
                    }
                    closeStream(dataOutputStream, inputStream3, byteArrayOutputStream3, openHttpsConnection);
                    return readErrorResponse;
                } catch (MalformedURLException e11) {
                    inputStream = null;
                    LogX.e("processTask url invalid.");
                    readErrorResponse = readErrorResponse(-3);
                    closeStream(dataOutputStream, inputStream, byteArrayOutputStream2, openHttpsConnection);
                    return readErrorResponse;
                } catch (NoSuchAlgorithmException e12) {
                    th = e12;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = dataOutputStream;
                    inputStream2 = null;
                    LogX.e("processTask, NoSuchAlgorithmException : " + Log.getStackTraceString(th), true);
                    readErrorResponse = readErrorResponse(-2);
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    return readErrorResponse;
                } catch (KeyManagementException e13) {
                    th = e13;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = dataOutputStream;
                    inputStream2 = null;
                    LogX.e("processTask, KeyManagementException : " + Log.getStackTraceString(th), true);
                    readErrorResponse = readErrorResponse(-2);
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    return readErrorResponse;
                } catch (IOException e14) {
                    th = e14;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = dataOutputStream;
                    inputStream2 = null;
                    LogX.e("processTask IOException : " + Log.getStackTraceString(th), true);
                    readErrorResponse = readErrorResponse(-2);
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    return readErrorResponse;
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = openHttpsConnection;
                    dataOutputStream2 = dataOutputStream;
                    inputStream2 = null;
                    closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                    throw th;
                }
            } catch (MalformedURLException e15) {
                inputStream = null;
                dataOutputStream = null;
                openHttpsConnection = null;
                LogX.e("processTask url invalid.");
                readErrorResponse = readErrorResponse(-3);
                closeStream(dataOutputStream, inputStream, byteArrayOutputStream2, openHttpsConnection);
                return readErrorResponse;
            } catch (NoSuchAlgorithmException e16) {
                th = e16;
                inputStream2 = null;
                dataOutputStream2 = null;
                httpURLConnection = null;
                LogX.e("processTask, NoSuchAlgorithmException : " + Log.getStackTraceString(th), true);
                readErrorResponse = readErrorResponse(-2);
                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                return readErrorResponse;
            } catch (KeyManagementException e17) {
                th = e17;
                inputStream2 = null;
                dataOutputStream2 = null;
                httpURLConnection = null;
                LogX.e("processTask, KeyManagementException : " + Log.getStackTraceString(th), true);
                readErrorResponse = readErrorResponse(-2);
                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                return readErrorResponse;
            } catch (IOException e18) {
                th = e18;
                inputStream2 = null;
                dataOutputStream2 = null;
                httpURLConnection = null;
                LogX.e("processTask IOException : " + Log.getStackTraceString(th), true);
                readErrorResponse = readErrorResponse(-2);
                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                return readErrorResponse;
            } catch (Throwable th7) {
                th = th7;
                inputStream2 = null;
                dataOutputStream2 = null;
                httpURLConnection = null;
                closeStream(dataOutputStream2, inputStream2, byteArrayOutputStream2, httpURLConnection);
                throw th;
            }
        }
        LogX.d("processTask, no network.");
        return readErrorResponse(-1);
    }

    private void closeStream(DataOutputStream dataOutputStream, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream, HttpURLConnection httpURLConnection) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                LogX.e("processTask close stream error1.");
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                LogX.e("processTask close stream error2.");
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                LogX.e("processTask close stream error3.");
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private HttpsURLConnection openHttpsConnection(URL url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        initHttpsConnection(httpsURLConnection);
        return httpsURLConnection;
    }

    private HttpURLConnection openHttpConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private void initHttpsConnection(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        httpsURLConnection.setSSLSocketFactory(new WalletSSLSocketFactory(new C4023a(this.mContext)));
        httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
    }

    protected Result handleResponse(String str) {
        Throwable e;
        String str2 = null;
        LogX.d("handleResponse response str : " + str, true);
        if (str == null) {
            return readSuccessResponse(-99, null, null);
        }
        JSONObject jSONObject;
        int intValue;
        try {
            jSONObject = new JSONObject(str);
            intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
            String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
            String stringValue2 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
            String stringValue3 = JSONHelper.getStringValue(jSONObject, "errorMsg");
            String stringValue4 = JSONHelper.getStringValue(jSONObject, "response");
            if (stringValue2 != null) {
                LogX.w("handleResponse, error code : " + stringValue2 + "error msg : " + stringValue3);
                return readSuccessResponse(Integer.parseInt(stringValue2), stringValue3, new JSONObject());
            } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue4, true)) {
                LogX.d("handleResponse, responseDataStr : " + stringValue4, true);
                jSONObject = new JSONObject(stringValue4);
                try {
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnCode");
                    if (stringValue5 == null) {
                        LogX.d("handleResponse, returnCode is invalid.");
                        return readSuccessResponse(-99, null, null);
                    }
                    if (isNumber(stringValue5)) {
                        intValue = Integer.parseInt(stringValue5);
                    } else {
                        intValue = -98;
                    }
                    str2 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    return readSuccessResponse(intValue, str2, jSONObject);
                } catch (NumberFormatException e2) {
                    e = e2;
                    LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                    intValue = -99;
                    return readSuccessResponse(intValue, str2, jSONObject);
                } catch (JSONException e3) {
                    e = e3;
                    LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e));
                    intValue = -99;
                    return readSuccessResponse(intValue, str2, jSONObject);
                }
            } else {
                LogX.d("handleResponse, unexpected error from server.");
                return readSuccessResponse(-99, null, null);
            }
        } catch (Throwable e4) {
            e = e4;
            jSONObject = null;
            LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
            intValue = -99;
            return readSuccessResponse(intValue, str2, jSONObject);
        } catch (Throwable e42) {
            e = e42;
            jSONObject = null;
            LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e));
            intValue = -99;
            return readSuccessResponse(intValue, str2, jSONObject);
        }
    }

    public boolean isNumber(String str) {
        if (!(str == null || "".equals(str.trim()) || !Pattern.compile("[0-9]*").matcher(str).matches())) {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            if (valueOf.longValue() <= 2147483647L && valueOf.longValue() >= -2147483648L) {
                return true;
            }
        }
        return false;
    }
}
