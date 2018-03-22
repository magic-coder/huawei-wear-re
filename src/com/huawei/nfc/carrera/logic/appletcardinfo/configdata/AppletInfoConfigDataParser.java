package com.huawei.nfc.carrera.logic.appletcardinfo.configdata;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduCommandInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduSet;
import com.huawei.nfc.carrera.logic.appletcardinfo.operation.OperationGenerator;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppletInfoConfigDataParser {
    private static final int QUERY_RECORDS_CNT = 10;
    private static final String TAG = "AppletInfoConfigDataParser";
    private static String[] cardInfoFields = new String[]{Constants.FIELD_APPLET_CONFIG_NUM, "amount", "date", "status", "records"};
    private List<String> appletConfigOriData;
    private Map<String, String> jsonDataForProduct = new HashMap();
    private Context mContext;

    AppletInfoConfigDataParser(Context context, List<String> list) {
        this.mContext = context;
        this.appletConfigOriData = list;
    }

    ApduSet parseJson2ApduSet(String str) throws AppletCardException {
        JSONException e;
        C2538c.c(TAG, new Object[]{"parseJson2ApduSet begin for " + str});
        Map hashMap = new HashMap();
        findTargetJsonData(hashMap);
        if (hashMap.isEmpty()) {
            return null;
        }
        String str2 = "";
        ApduSet apduSet = new ApduSet();
        try {
            String str3 = str2;
            for (Entry entry : hashMap.entrySet()) {
                try {
                    str2 = (String) entry.getValue();
                    if (!StringUtil.isEmpty(str2, true)) {
                        String str4 = (String) entry.getKey();
                        if ("records".equals(str4)) {
                            apduSet.add(str4, parseRecordReadCommands(parseApduInfoJson(str4, new JSONArray(str2))));
                        } else {
                            apduSet.add(str4, parseApduInfoJson(str4, new JSONArray(str2)));
                        }
                    }
                    str3 = str2;
                } catch (JSONException e2) {
                    e = e2;
                    str2 = str3;
                }
            }
            apduSet.compareCardNumAndDateApdus();
            return apduSet;
        } catch (JSONException e3) {
            e = e3;
        }
        throw new AppletCardException(4, "parse apdu json error. json : " + str2 + " msg : " + e.getMessage());
    }

    private void findTargetJsonData(Map<String, String> map) {
        try {
            for (String str : cardInfoFields) {
                String findDataByType = findDataByType(str);
                if (!StringUtil.isEmpty(findDataByType, true)) {
                    JSONObject jSONObject = new JSONObject(findDataByType);
                    if (jSONObject.has(str)) {
                        map.put(str, jSONObject.getString(str));
                    }
                }
            }
        } catch (Throwable e) {
            map.clear();
            LogX.e("findTargetJsonData exception. json : " + null + " msg : " + Log.getStackTraceString(e), true);
        }
    }

    private String findDataByType(String str) {
        if (this.appletConfigOriData == null || this.appletConfigOriData.isEmpty()) {
            return null;
        }
        for (String str2 : this.appletConfigOriData) {
            if (str2 != null && str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    private List<ApduCommand> parseApduInfoJson(String str, JSONArray jSONArray) throws AppletCardException {
        List<ApduCommand> arrayList = new ArrayList();
        int length = jSONArray.length();
        String str2 = "";
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            try {
                String string;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("apdu")) {
                    string = jSONObject.getString("apdu");
                } else {
                    string = null;
                }
                if (StringUtil.isEmpty(string, true)) {
                    throw new AppletCardException(2, "apdu json config error");
                }
                String string2;
                List list;
                if (jSONObject.has(Constants.FIELD_APPLET_CONFIG_CHECKER)) {
                    string2 = jSONObject.getString(Constants.FIELD_APPLET_CONFIG_CHECKER);
                } else {
                    string2 = null;
                }
                if (StringUtil.isEmpty(string2, true)) {
                    string2 = "9000";
                }
                if (string2 != null) {
                    string2 = string2.replace(",", "|");
                }
                if (jSONObject.has("op")) {
                    str2 = jSONObject.getString("op");
                } else {
                    str2 = null;
                }
                if (StringUtil.isEmpty(str2, true)) {
                    list = null;
                } else {
                    list = OperationGenerator.parseOperations(str2);
                }
                arrayList.add(new ApduCommandInfo(i2, string, string2, str, list));
                i++;
            } catch (JSONException e) {
                throw new AppletCardException(4, "parse apdu json error. " + e.getMessage());
            }
        }
        return arrayList;
    }

    private List<ApduCommand> parseRecordReadCommands(List<ApduCommand> list) {
        List<ApduCommand> arrayList = new ArrayList();
        int i = 1;
        for (ApduCommand apduCommand : list) {
            if (apduCommand instanceof ApduCommandInfo) {
                int i2;
                ApduCommandInfo apduCommandInfo = (ApduCommandInfo) apduCommand;
                apduCommandInfo.setIndex(i);
                List operations = apduCommandInfo.getOperations();
                String apdu = apduCommandInfo.getApdu();
                if (operations == null || !apdu.contains("%")) {
                    arrayList.add(apduCommandInfo);
                    i2 = i + 1;
                } else if (apdu.contains("%")) {
                    String[] split = apdu.split(",");
                    int length = split.length;
                    int i3 = 0;
                    i2 = i;
                    while (i3 < length) {
                        String str = split[i3];
                        i = i2;
                        for (int i4 = 1; i4 <= 10; i4++) {
                            arrayList.add(new ApduCommandInfo(i, String.format(str, new Object[]{Integer.valueOf(i4)}), apduCommandInfo.getChecker(), apduCommandInfo.getType(), apduCommandInfo.getOperations()));
                            i++;
                        }
                        i3++;
                        i2 = i;
                    }
                } else {
                    arrayList.add(apduCommandInfo);
                    i2 = i + 1;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    private void fetchApduDataJsonFromLocalAssetInfo(String str, Map<String, String> map) throws AppletCardException {
        String str2 = (String) this.jsonDataForProduct.get(str);
        if (StringUtil.isEmpty(str2, true)) {
            throw new AppletCardException(5, "parseJson2ApduSet does not have local apdu json data for " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            map.clear();
            for (String str3 : cardInfoFields) {
                if (jSONObject.has(str3)) {
                    map.put(str3, jSONObject.getString(str3));
                }
            }
            LogX.i("parseJson2ApduSet fetch apdu data from local asset info end");
        } catch (JSONException e) {
            throw new AppletCardException(4, "fetchApduDataJsonFromLocalAssetInfo failed. parse exception json : " + str2);
        }
    }
}
