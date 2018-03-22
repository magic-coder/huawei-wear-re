package com.snowballtech.business.util;

import android.content.Context;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.constant.Constant;
import com.snowballtech.business.bean.AppletStatus;
import com.snowballtech.business.bean.CplcCacheForWatch;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ByteHelperUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApduUtil {
    public static Map<Integer, List<Command>> commandsMap = new HashMap();
    private static volatile ApduUtil singleton;
    private String TAG = " ApduUtil ";

    private ApduUtil() {
    }

    public static ApduUtil getInstance() {
        if (singleton == null) {
            synchronized (ApduUtil.class) {
                if (singleton == null) {
                    singleton = new ApduUtil();
                }
            }
        }
        return singleton;
    }

    private String covertMediaType(int i) {
        String str = Constant._ESE_TERMINAL;
        switch (i) {
            case 1:
                return Constant._SD_TERMINAL;
            case 2:
                return Constant._UICC_TERMINAL;
            default:
                return str;
        }
    }

    public synchronized TaskResult<String> removeCplcCache(Context context, int i) throws SnowballException {
        TaskResult<String> taskResult;
        taskResult = new TaskResult();
        getOrSaveCplcFromCache(context, i, 2, null);
        LogUtil.log(this.TAG, " removeCplcCache ");
        taskResult.setResult_code("0");
        taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        return taskResult;
    }

    public synchronized TaskResult<String> getCPLC(Context context, int i) throws SnowballException {
        TaskResult<String> taskResult;
        taskResult = new TaskResult();
        String orSaveCplcFromCache = getOrSaveCplcFromCache(context, i, 0, null);
        if (ValueUtil.isEmpty(orSaveCplcFromCache)) {
            LogUtil.log(this.TAG, " getCPLC start ");
            long currentTimeMillis = System.currentTimeMillis();
            Command command = new Command();
            command.setCommand(SeConstants.COMMAND_CPLC);
            command.setIndex(0);
            Content content = new Content();
            content.setMediaType(i);
            content.setInstance_id("cplc");
            List arrayList = new ArrayList();
            arrayList.add(command);
            content.setCommands(arrayList);
            TaskResult executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
            taskResult.setResult_code(executeApdu.getResult_code());
            taskResult.setResult_msg(executeApdu.getResult_msg());
            if (executeApdu == null || !executeApdu.getResult_code().equals("0")) {
                LogUtil.loge(this.TAG, "fetch cplc connection failure");
            } else {
                Object substring;
                orSaveCplcFromCache = ((Command) ((Content) executeApdu.getData()).getCommands().get(0)).getResult();
                if (orSaveCplcFromCache.endsWith("9000")) {
                    substring = orSaveCplcFromCache.substring(6, orSaveCplcFromCache.lastIndexOf("9000"));
                    getOrSaveCplcFromCache(context, i, 1, substring);
                    LogUtil.log(this.TAG, " channel connection success! cplc=" + substring);
                    LogUtil.log(" save cplc into cache :" + substring);
                } else {
                    LogUtil.loge(this.TAG, "getCPLC  fetch cplc failure cplc = " + orSaveCplcFromCache);
                    substring = "";
                }
                taskResult.setData(substring);
            }
            LogUtil.log(this.TAG, "getCPLC end. costtime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } else {
            LogUtil.log(" cplc from cache :" + orSaveCplcFromCache);
            taskResult.setResult_code("0");
            taskResult.setData(orSaveCplcFromCache);
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        }
        return taskResult;
    }

    public synchronized List<AppletStatus> appletStatusForse(Context context) throws SnowballException {
        List<AppletStatus> arrayList;
        String str = "ApduUtil";
        LogUtil.log(this.TAG, " appletStatusForse start ");
        arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add("8042020200");
        Content buildApdu = buildApdu(SeConstants.appletStatusisInstanceAID, context, arrayList2);
        TaskResult executeApduKeep = ConfigUtil.getInstance().instanceOma().executeApduKeep(context, buildApdu);
        if (executeApduKeep == null || !executeApduKeep.getResult_code().equals("0")) {
            LogUtil.loge(this.TAG, " pull connection failure ");
        } else {
            Content content = (Content) executeApduKeep.getData();
            LogUtil.log(this.TAG, " apdu-aid: " + content.getInstance_id());
            try {
                String result = ((Command) content.getCommands().get(0)).getResult();
                LogUtil.log(this.TAG, " apdu-apdu: " + ((Command) content.getCommands().get(0)).getCommand());
                LogUtil.log(this.TAG, " apdu-result: original--" + result);
                String str2 = "8042020300";
                str = result.substring(result.length() - 4);
                LogUtil.log(this.TAG, " apdu-result: finish--" + result.substring(0, result.length() - 4));
                StringBuilder stringBuilder = new StringBuilder();
                if (str.equals("9000")) {
                    stringBuilder.append(result.substring(0, result.length() - 4));
                    LogUtil.log(this.TAG, " apdu-result:full--" + stringBuilder.toString());
                    arrayList.addAll(parseLvList(stringBuilder.toString()));
                }
                loop1:
                while (true) {
                    String str3 = result;
                    result = str;
                    while (result.equals("6310")) {
                        stringBuilder.append(str3.substring(0, str3.length() - 4));
                        LogUtil.log(this.TAG, " apdu-apdu: " + str2);
                        ((Command) buildApdu.getCommands().get(0)).setCommand(str2);
                        executeApduKeep = ConfigUtil.getInstance().instanceOma().executeApduKeep(context, buildApdu);
                        if (executeApduKeep != null && executeApduKeep.getResult_code().equals("0")) {
                            result = ((Command) ((Content) executeApduKeep.getData()).getCommands().get(0)).getResult();
                            LogUtil.log(this.TAG, " apdu-result: original-- " + result);
                            str = result.substring(result.length() - 4);
                            LogUtil.log(this.TAG, " apdu-result:finish--" + result.substring(0, result.length() - 4));
                            if (str.equals("9000")) {
                                stringBuilder.append(result.substring(0, result.length() - 4));
                                str3 = result;
                                result = str;
                            }
                        }
                    }
                    break loop1;
                }
                LogUtil.log(this.TAG, " apdu-result:full--" + stringBuilder.toString());
                arrayList.addAll(parseLvList(stringBuilder.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.loge(this.TAG, " execute apdu:" + buildApdu + " exception  " + e.getMessage());
            }
        }
        ConfigUtil.getInstance().instanceOma().closeChannlAll();
        LogUtil.log(this.TAG, " appletStatusForse end ");
        return arrayList;
    }

    private static String parseLv(String str) {
        String str2 = "";
        return str.substring(2, (ValueUtil.parseInt(str.substring(0, 2), 16) * 2) + 2);
    }

    private static List<AppletStatus> parseLvList(String str) {
        List<AppletStatus> arrayList = new ArrayList();
        if (!ValueUtil.isEmpty(str)) {
            while (!ValueUtil.isEmpty(str)) {
                String parseLv = parseLv(str);
                AppletStatus appletStatus = new AppletStatus();
                appletStatus.setStatus(parseLv.substring(0, 4));
                appletStatus.setAid(parseLv.substring(4));
                arrayList.add(appletStatus);
                str = str.substring(parseLv.length() + 2);
            }
        }
        return arrayList;
    }

    public static Content buildApdu(String str, Context context, List<String> list) {
        Content content = new Content();
        content.setInstance_id(str);
        if (list != null && list.size() > 0) {
            List arrayList = new ArrayList();
            content.setCommands(arrayList);
            for (String str2 : list) {
                Command command = new Command();
                command.setCommand(str2);
                arrayList.add(command);
            }
        }
        return content;
    }

    public synchronized String[] retriveCardStatusForProxy(Context context, int i) throws SnowballException {
        String[] strArr;
        int i2;
        strArr = new String[2];
        List arrayList = new ArrayList();
        Content content = new Content();
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS);
        content.setMediaType(i);
        Command command = new Command();
        command.setCommand("00CC000000");
        arrayList.add(command);
        content.setCommands(arrayList);
        TaskResult executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
        if (!(executeApdu == null || executeApdu.getData() == null || ((Content) executeApdu.getData()).getCommands() == null || ((Content) executeApdu.getData()).getCommands().size() <= 0)) {
            String result = ((Command) ((Content) executeApdu.getData()).getCommands().get(0)).getResult();
            if (ValueUtil.isEmpty(result) || !result.endsWith("9000")) {
                LogUtil.log("ApduUtil", " response :" + result + ",no active card");
                if (!executeApdu.getResult_code().equals("400907")) {
                    strArr[1] = "noActiveCard";
                }
            } else {
                strArr[1] = result.substring(0, result.length() - 4);
                i2 = 1;
                strArr[0] = i2 + "";
            }
        }
        i2 = 0;
        strArr[0] = i2 + "";
        return strArr;
    }

    public synchronized int retriveCardStatus(Context context, String str, int i) throws SnowballException {
        int i2;
        LogUtil.log("start to retriveCardStatus ");
        List combineSwitchCommand = combineSwitchCommand((List) commandsMap.get(Integer.valueOf(1019)), str, new boolean[0]);
        Content content = new Content();
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        content.setMediaType(i);
        content.setCommands(combineSwitchCommand);
        TaskResult executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
        if (executeApdu.getResult_code().equals("0") && executeApdu.getData() != null && ((Content) executeApdu.getData()).getCommands() != null && ((Content) executeApdu.getData()).getCommands().size() > 0) {
            String result = ((Command) ((Content) executeApdu.getData()).getCommands().get(0)).getResult();
            int indexOf = result.indexOf("9F70");
            int length = "9F70".length();
            if (result.substring((indexOf + length) + 4, (indexOf + length) + 6).equals("01")) {
                i2 = 1;
            }
        }
        i2 = 0;
        return i2;
    }

    private synchronized List<Command> combineSwitchCommand(List<Command> list, String str, boolean... zArr) {
        List<Command> list2;
        Exception exception;
        list2 = null;
        if (list != null) {
            if (list.size() > 0 && !ValueUtil.isEmpty(str)) {
                try {
                    List<Command> arrayList = new ArrayList();
                    try {
                        int length = ByteHelperUtil.hexStringToByteArray(str).length;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Command command : list) {
                            Command command2 = new Command();
                            command2.setIndex(command.getIndex());
                            stringBuilder.setLength(0);
                            stringBuilder.append(String.format("%s%s%s%s%s", new Object[]{command.getCommand(), ValueUtil.toHex(length + 2, 2, "0"), "4F", ValueUtil.toHex(length, 2, "0"), str}));
                            command2.setCommand(stringBuilder.toString());
                            arrayList.add(command2);
                        }
                        list2 = arrayList;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        list2 = arrayList;
                        exception = exception2;
                        exception.printStackTrace();
                        return list2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                    exception.printStackTrace();
                    return list2;
                }
            }
        }
        return list2;
    }

    static {
        Command command = new Command();
        command.setIndex(0);
        command.setCommand("80F00101");
        List arrayList = new ArrayList();
        arrayList.add(command);
        commandsMap.put(Integer.valueOf(1009), arrayList);
        command = new Command();
        command.setIndex(0);
        command.setCommand("80F00100");
        arrayList = new ArrayList();
        arrayList.add(command);
        commandsMap.put(Integer.valueOf(1011), arrayList);
        command = new Command();
        command.setIndex(0);
        command.setCommand(SeConstants.AID_HEAD);
        arrayList = new ArrayList();
        arrayList.add(command);
        commandsMap.put(Integer.valueOf(1019), arrayList);
    }

    private synchronized String getOrSaveCplcFromCache(Context context, int i, int i2, String str) throws SnowballException {
        String str2;
        str2 = null;
        IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
        if (instanceEnv == null) {
            switch (i2) {
                case 0:
                    str2 = PreferencesUtil.getInstance().getField(CacheKey.KEY_CPLC_ID + covertMediaType(i), context);
                    break;
                case 1:
                    PreferencesUtil.getInstance().keepField(CacheKey.KEY_CPLC_ID + covertMediaType(i), str, context);
                    break;
                case 2:
                    PreferencesUtil.getInstance().removeField(CacheKey.KEY_CPLC_ID + covertMediaType(i), context);
                    break;
            }
        }
        Map fetchEnv = instanceEnv.fetchEnv();
        if (fetchEnv == null || fetchEnv.size() <= 0) {
            LogUtil.loge(this.TAG, " envMap is null or size is 0");
        } else {
            String str3 = (String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI);
            if (!ValueUtil.isEmpty(str3)) {
                switch (i2) {
                    case 0:
                        CplcCacheForWatch cplcCache = WatchCacheUtils.getInstance().getCplcCache(str3, context);
                        if (cplcCache != null && cplcCache.getCplc() != null) {
                            str3 = cplcCache.getCplc();
                            break;
                        }
                        LogUtil.log("cplcCache from watch is null");
                        str3 = null;
                        break;
                    case 1:
                        WatchCacheUtils.getInstance().saveCpLcCache(new CplcCacheForWatch(str, str3), context);
                        str3 = null;
                        break;
                    case 2:
                        WatchCacheUtils.getInstance().removeCplcCache(str3, context);
                        str3 = null;
                        break;
                }
            }
            LogUtil.loge(this.TAG, " has envMap but uuid is null");
            str3 = null;
            str2 = str3;
        }
        return str2;
    }
}
