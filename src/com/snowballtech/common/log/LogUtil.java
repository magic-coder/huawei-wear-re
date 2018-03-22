package com.snowballtech.common.log;

import android.os.AsyncTask;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.snowballtech.business.BuildConfig;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.ValueUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogUtil {
    public static final String ACCESS_SERVER = " access_server ";
    public static final String CARD_INFO = " CardInfo_";
    public static final String DEFAULT_PROJECT = " WalletService";
    private static final int ERROR = 1;
    private static final int INFO = 0;
    private static boolean IS_PRINT = false;
    public static final String REQUEST_OPERATION = "_call_api_request_operation=";
    public static final String REQUEST_PARAM = "_call_api_request_param=";
    public static final String RESPONSE_RESULT = "_call_api_response=";
    public static String ROOTNAME = " Snowballtech_sdk_";
    public static String VERSIONNAME = "";
    private static String fullPath;
    private static boolean isSaving = false;
    private static StringBuffer msgBuff;
    private static String subPath = "/snowball/fieldlog";

    final class C62331 extends AsyncTask<Void, Void, Void> {
        C62331() {
        }

        protected Void doInBackground(Void... voidArr) {
            Log.i("log_save", "doInBackground");
            String currentDateString = DateTimeUtil.currentDateString("yyyy-MM-dd-HH-mm");
            while (LogUtil.isSaving) {
                String currentDateString2 = DateTimeUtil.currentDateString("yyyy-MM-dd-HH-mm");
                if (!currentDateString.equals(currentDateString2)) {
                    LogUtil.saveToFile(currentDateString);
                    currentDateString = currentDateString2;
                }
                synchronized (this) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            LogUtil.saveToFile(DateTimeUtil.currentDateString("yyyy-MM-dd-HH-mm"));
            LogUtil.operateBuf("");
            return null;
        }

        protected void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            Log.i("log_save", "onPostExecute");
        }
    }

    private static void logContent(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + HwAccountConstants.SPLIIT_UNDERLINE + str2;
        }
        String str3 = ROOTNAME + VERSIONNAME + DEFAULT_PROJECT;
        if (str2.contains("{")) {
            str2 = LogFormatTool.getInstance().formatJson(str2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DateTimeUtil.currentDateTimeString());
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(Process.myUid());
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(Process.myTid());
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(str3);
        stringBuilder.append(": ");
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        operateBuf(stringBuilder.toString());
        switch (i) {
            case 0:
                Log.i(str3, str2);
                return;
            case 1:
                Log.e(str3, str2);
                return;
            default:
                return;
        }
    }

    public static void log(String str) {
        if (IS_PRINT) {
            logContent("", str, 0);
        }
    }

    public static void updateVersion(String str) {
        VERSIONNAME = str;
    }

    public static void updateRootName(String str) {
        ROOTNAME = str;
    }

    public static void internalSwitchLog(String str) {
        if (!ValueUtil.isEmpty(str) && str.equals(BuildConfig.sdk_log_switch)) {
            operateIsPrint(true);
        } else if (!ValueUtil.isEmpty(str) && str.equals("shutdown")) {
            operateIsPrint(false);
        }
    }

    public static void switchLog(String str) {
        if (!ValueUtil.isEmpty(str) && str.equals("shutdown")) {
            operateIsPrint(false);
        } else if (!ValueUtil.isEmpty(str) && str.equals(BuildConfig.sdk_log_switch)) {
            operateIsPrint(true);
        } else if (!ValueUtil.isEmpty(str) && str.equals("open_save")) {
            operateIsPrint(true);
            Log.i("log_save", "get open_save");
            if (!prepareFolder()) {
                Log.i("log_save", "can not prepare /sdcard/snb/log");
            } else if (!isSaving) {
                isSaving = true;
                new C62331().execute(new Void[0]);
            }
        } else if (!ValueUtil.isEmpty(str) && str.equals("shutdown_unsave")) {
            Log.i("log_save", "get shutdown_unsave");
            operateIsPrint(false);
            isSaving = false;
        }
    }

    public static void log(String str, String str2) {
        if (IS_PRINT) {
            logContent(str, str2, 0);
        }
    }

    public static void loge(String str, String str2) {
        logContent(str, str2, 1);
    }

    private static boolean prepareFolder() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        String str = Environment.getExternalStorageDirectory().getPath() + subPath;
        deletefile(str);
        File file = new File(str);
        if (file.exists()) {
            Log.i("log_save", "path exist");
        } else if (file.mkdirs()) {
            Log.i("log_save", "path created");
        } else {
            Log.i("log_save", "path create failed");
            return false;
        }
        fullPath = str;
        return true;
    }

    public static boolean deletefile(String str) {
        File file = new File(str);
        if (!file.isDirectory()) {
            file.delete();
        } else if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                File file2 = new File(str + File.separator + list[i]);
                if (!file2.isDirectory()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    deletefile(str + File.separator + list[i]);
                }
            }
            file.delete();
        }
        return true;
    }

    private static void saveToFile(String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fullPath + "//" + str + ".log", true);
            String operateBuf = operateBuf(null);
            if (operateBuf != null) {
                Log.i("log_save", "saveToFile with buf" + operateBuf);
                fileOutputStream.write(operateBuf.getBytes());
            } else {
                Log.i("log_save", "saveToFile without buf");
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        operateBuf("");
    }

    private static synchronized String operateBuf(String str) {
        String stringBuffer;
        synchronized (LogUtil.class) {
            if (msgBuff == null) {
                msgBuff = new StringBuffer();
            }
            if (str == null) {
                stringBuffer = msgBuff.toString();
            } else {
                if (str.equals("")) {
                    msgBuff.setLength(0);
                } else if (isSaving) {
                    msgBuff.append(str);
                }
                stringBuffer = null;
            }
        }
        return stringBuffer;
    }

    private static synchronized void operateIsPrint(boolean z) {
        synchronized (LogUtil.class) {
            IS_PRINT = z;
        }
    }
}
