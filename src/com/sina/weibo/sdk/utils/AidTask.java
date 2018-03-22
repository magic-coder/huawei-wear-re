package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    private static final int MAX_RETRY_NUM = 3;
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_ERR = 1002;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask sInstance;
    private AidInfo mAidInfo;
    private String mAppKey;
    private Context mContext;
    private CallbackHandler mHandler;
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);

    class C62271 implements Runnable {
        C62271() {
        }

        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    AidTask.this.getAidInfoFile(i).delete();
                } catch (Exception e) {
                }
            }
        }
    }

    class C62282 implements Runnable {
        C62282() {
        }

        public void run() {
            if (AidTask.this.mTaskLock.tryLock()) {
                AidInfo access$2 = AidTask.this.loadAidInfoFromCache();
                if (access$2 == null) {
                    int i = 1;
                    do {
                        i++;
                        try {
                            String access$3 = AidTask.this.loadAidFromNet();
                            AidInfo parseJson = AidInfo.parseJson(access$3);
                            AidTask.this.cacheAidInfo(access$3);
                            AidTask.this.mAidInfo = parseJson;
                            break;
                        } catch (WeiboException e) {
                            LogUtil.m28662e(AidTask.TAG, "AidTaskInit WeiboException Msg : " + e.getMessage());
                            if (i >= 3) {
                            }
                        }
                    } while (i >= 3);
                } else {
                    AidTask.this.mAidInfo = access$2;
                }
                AidTask.this.mTaskLock.unlock();
                return;
            }
            LogUtil.m28662e(AidTask.TAG, "tryLock : false, return");
        }
    }

    public final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public String getAid() {
            return this.mAid;
        }

        public String getSubCookie() {
            return this.mSubCookie;
        }

        public static AidInfo parseJson(String str) throws WeiboException {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(HwAccountConstants.EXTRA_OPLOG_ERROR) || jSONObject.has("error_code")) {
                    LogUtil.m28661d(AidTask.TAG, "loadAidFromNet has error !!!");
                    throw new WeiboException("loadAidFromNet has error !!!");
                }
                aidInfo.mAid = jSONObject.optString("aid", "");
                aidInfo.mSubCookie = jSONObject.optString("sub", "");
                return aidInfo;
            } catch (JSONException e) {
                LogUtil.m28661d(AidTask.TAG, "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        AidInfo cloneAidInfo() {
            AidInfo aidInfo = new AidInfo();
            aidInfo.mAid = this.mAid;
            aidInfo.mSubCookie = this.mSubCookie;
            return aidInfo;
        }
    }

    public interface AidResultCallBack {
        void onAidGenFailed(Exception exception);

        void onAidGenSuccessed(AidInfo aidInfo);
    }

    class CallbackHandler extends Handler {
        private WeakReference<AidResultCallBack> callBackReference;

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public void setCallback(AidResultCallBack aidResultCallBack) {
            if (this.callBackReference == null) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            } else if (((AidResultCallBack) this.callBackReference.get()) != aidResultCallBack) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            }
        }

        public void handleMessage(Message message) {
            AidResultCallBack aidResultCallBack = (AidResultCallBack) this.callBackReference.get();
            switch (message.what) {
                case 1001:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenSuccessed(((AidInfo) message.obj).cloneAidInfo());
                        return;
                    }
                    return;
                case 1002:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenFailed((WeiboException) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private AidTask(Context context) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
        new Thread(new C62271()).start();
    }

    public static synchronized AidTask getInstance(Context context) {
        AidTask aidTask;
        synchronized (AidTask.class) {
            if (sInstance == null) {
                sInstance = new AidTask(context);
            }
            aidTask = sInstance;
        }
        return aidTask;
    }

    public void aidTaskInit(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.m28662e(TAG, "aidTaskInit ");
            initAidInfo(str);
        }
    }

    private void initAidInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppKey = str;
            new Thread(new C62282()).start();
        }
    }

    public AidInfo getAidSync(String str) throws WeiboException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.m28662e(TAG, "getAidSync ");
        if (this.mAidInfo == null) {
            aidTaskInit(str);
        }
        return this.mAidInfo;
    }

    public void getAidAsync(String str, AidResultCallBack aidResultCallBack) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mAidInfo == null || aidResultCallBack == null) {
                generateAid(str, aidResultCallBack);
            } else {
                aidResultCallBack.onAidGenSuccessed(this.mAidInfo.cloneAidInfo());
            }
        }
    }

    private void generateAid(String str, final AidResultCallBack aidResultCallBack) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppKey = str;
            new Thread(new Runnable() {
                public void run() {
                    AidTask.this.mTaskLock.lock();
                    Object access$2 = AidTask.this.loadAidInfoFromCache();
                    Object obj = null;
                    if (access$2 == null) {
                        try {
                            String access$3 = AidTask.this.loadAidFromNet();
                            access$2 = AidInfo.parseJson(access$3);
                            AidTask.this.cacheAidInfo(access$3);
                            AidTask.this.mAidInfo = access$2;
                        } catch (WeiboException e) {
                            obj = e;
                            LogUtil.m28662e(AidTask.TAG, "AidTaskInit WeiboException Msg : " + obj.getMessage());
                        }
                    }
                    AidTask.this.mTaskLock.unlock();
                    Message obtain = Message.obtain();
                    if (access$2 != null) {
                        obtain.what = 1001;
                        obtain.obj = access$2;
                    } else {
                        obtain.what = 1002;
                        obtain.obj = obj;
                    }
                    AidTask.this.mHandler.setCallback(aidResultCallBack);
                    AidTask.this.mHandler.sendMessage(obtain);
                }
            }).start();
        }
    }

    private synchronized AidInfo loadAidInfoFromCache() {
        FileInputStream fileInputStream;
        Throwable th;
        AidInfo aidInfo = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(getAidInfoFile(1));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    aidInfo = AidInfo.parseJson(new String(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return aidInfo;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = aidInfo;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return aidInfo;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = aidInfo;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return aidInfo;
    }

    private File getAidInfoFile(int i) {
        return new File(this.mContext.getFilesDir(), new StringBuilder(AID_FILE_NAME).append(i).toString());
    }

    private String loadAidFromNet() throws WeiboException {
        String str = "https://api.weibo.com/oauth2/getaid.json";
        str = this.mContext.getPackageName();
        String sign = Utility.getSign(this.mContext, str);
        String mfp = getMfp(this.mContext);
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put(LogBuilder.KEY_APPKEY, this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put("packagename", str);
        weiboParameters.put("key_hash", sign);
        try {
            str = NetUtils.internalHttpRequest(this.mContext, "https://api.weibo.com/oauth2/getaid.json", HttpGet.METHOD_NAME, weiboParameters);
            LogUtil.m28661d(TAG, "loadAidFromNet response : " + str);
            return str;
        } catch (WeiboException e) {
            LogUtil.m28661d(TAG, "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    private synchronized void cacheAidInfo(String str) {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(getAidInfoFile(1));
                try {
                    fileOutputStream2.write(str.getBytes());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return;
    }

    private static String getMfp(Context context) {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB";
        String str2 = "";
        try {
            str = new String(genMfpString(context).getBytes(), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        LogUtil.m28661d(TAG, "genMfpString() utf-8 string : " + str);
        try {
            str = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            LogUtil.m28661d(TAG, "encryptRsa() string : " + str);
            return str;
        } catch (Exception e2) {
            LogUtil.m28662e(TAG, e2.getMessage());
            return "";
        }
    }

    private static String genMfpString(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("1", os);
            }
            os = getImei(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("2", os);
            }
            os = getMeid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("3", os);
            }
            os = getImsi(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("4", os);
            }
            os = getMac(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("5", os);
            }
            os = getIccid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("6", os);
            }
            os = getSerialNo();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("7", os);
            }
            os = getAndroidId(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, os);
            }
            os = getCpu();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("13", os);
            }
            os = getModel();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("14", os);
            }
            os = getSdSize();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("15", os);
            }
            os = getResolution(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("16", os);
            }
            os = getSsid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("17", os);
            }
            os = getDeviceName();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("18", os);
            }
            os = getConnectType(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("19", os);
            }
            String str = "";
            try {
                os = Utility.generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("20", os);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private static String encryptRsa(String str, String str2) throws Exception {
        Throwable th;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, getPublicKey(str2));
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                int splite = splite(bytes, i, 117);
                if (splite == -1) {
                    break;
                }
                try {
                    byte[] doFinal = instance.doFinal(bytes, i, splite);
                    byteArrayOutputStream.write(doFinal);
                    LogUtil.m28661d(TAG, "encryptRsa offset = " + i + "     len = " + splite + "     enBytes len = " + doFinal.length);
                    i += splite;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byteArrayOutputStream.flush();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            LogUtil.m28661d(TAG, "encryptRsa total enBytes len = " + toByteArray.length);
            toByteArray = Base64.encodebyte(toByteArray);
            LogUtil.m28661d(TAG, "encryptRsa total base64byte len = " + toByteArray.length);
            String str3 = "01";
            String str4 = "01" + new String(toByteArray, GameManager.DEFAULT_CHARSET);
            LogUtil.m28661d(TAG, "encryptRsa total base64string : " + str4);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
            return str4;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private static String getOS() {
        try {
            return "Android " + VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSerialNo() {
        String str = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", "unknown"});
        } catch (Exception e) {
            return str;
        }
    }

    private static String getAndroidId(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception e) {
            return "";
        }
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.widthPixels))).append("*").append(String.valueOf(displayMetrics.heightPixels)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getConnectType(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "none";
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }
}
