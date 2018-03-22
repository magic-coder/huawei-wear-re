package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HWStressDataProvider {
    private static final String TAG = HWStressDataProvider.class.getSimpleName();
    private static HWStressDataProvider instance;
    private float[] calibrationResultArr = new float[10];
    private int gameScore;
    private float[] mCalibData = new float[18];
    private int mCalibrationScore = 0;
    private IBaseResponseCallback mCallBack;
    private int mMaxDuration = 0;
    private float mRealCalibScore = 0.0f;
    private int mSignalTime;
    private float maxScore = 0.0f;
    private float minScore = 100.0f;
    private int reserve_1;
    private int reserve_2;
    private int reserve_3;
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private int type;

    public static native float[] getGameResultFromAlgorithm(int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2);

    public static native float[] getRelaxResultFromAlgorithm(int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2);

    public static native float[] getStressResultFromAlgorithm(float[] fArr, int i, int i2, int[] iArr, int[] iArr2);

    static {
        try {
            System.loadLibrary("DetailStressJni");
            C2538c.c(TAG, new Object[]{"load .so success"});
        } catch (UnsatisfiedLinkError e) {
            C2538c.e(TAG, new Object[]{"load .so fail" + e.getMessage()});
        }
    }

    private HWStressDataProvider() {
    }

    public static HWStressDataProvider getInstance() {
        if (instance == null) {
            instance = new HWStressDataProvider();
        }
        return instance;
    }

    public void getStressResult(int i, JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c(TAG, new Object[]{"getStressResult(), enter getStressResult()"});
        this.type = i;
        C2538c.c(TAG, new Object[]{"getStressResult(), type: " + i});
        this.mCallBack = iBaseResponseCallback;
        switch (i) {
            case 1:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter STRESS_OPEN"});
                stressOpenPreProcess(jSONObject);
                return;
            case 2:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter STRESS_CLOSE"});
                stressClosePreProcess(jSONObject);
                return;
            case 4:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter STRESS_CALIBRATION_OPEN"});
                stressCalibrationOpenPreProcess(jSONObject);
                return;
            case 5:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter STRESS_CALIBRATION_CLOSE"});
                stressCalibrationClosePreProcess(jSONObject);
                return;
            case 8:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter STRESS_CALIBRATION_RESET"});
                stressCalibrationResetPreProcess();
                return;
            case 9:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter RELAX_OPEN"});
                relaxOpenPreProcess(jSONObject);
                return;
            case 10:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter RELAX_CLOSE"});
                relaxClosePreProcess(jSONObject);
                return;
            case 12:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter GAME_OPEN"});
                gameOpenPreProcess(jSONObject);
                return;
            case 13:
                C2538c.c(TAG, new Object[]{"getStressResult(), enter GAME_CLOSE"});
                gameClosePreProcess(jSONObject);
                return;
            default:
                return;
        }
    }

    public void processRRData(final int[] iArr, final int[] iArr2) {
        C2538c.c(TAG, new Object[]{"processRRData(), enter processRRData()"});
        if (iArr == null || iArr2 == null || iArr.length == 0 || iArr2.length == 0) {
            C2538c.c(TAG, new Object[]{"processRRData(), rrData is null"});
            inValidCallBackProcess(100);
            return;
        }
        C2538c.c(TAG, new Object[]{"processRRData(), enter else"});
        final int length = iArr.length;
        C2538c.c(TAG, new Object[]{"processRRData(), rrLength: " + length});
        C2538c.c(TAG, new Object[]{"processRRData(), rrData[0]:" + iArr[0]});
        C2538c.c(TAG, new Object[]{"processRRData(), rrData[rrLength-1]:" + iArr[length - 1]});
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < length; i++) {
                    C2538c.c(HWStressDataProvider.TAG, new Object[]{"processRRData(), rrData[" + i + "]: " + iArr[i] + ", timeStamp[" + i + "]: " + iArr2[i]});
                }
                switch (HWStressDataProvider.this.type) {
                    case 2:
                        C2538c.c(HWStressDataProvider.TAG, new Object[]{"processRRData(), enter STRESS_CLOSE"});
                        HWStressDataProvider.this.stressCloseProcess(length, iArr, iArr2);
                        return;
                    case 5:
                        C2538c.c(HWStressDataProvider.TAG, new Object[]{"processRRData(), enter STRESS_CALIBRATION_CLOSE"});
                        HWStressDataProvider.this.stressCalibrationCloseProcess(length, iArr, iArr2);
                        return;
                    case 10:
                        C2538c.c(HWStressDataProvider.TAG, new Object[]{"processRRData(), enter RELAX_CLOSE"});
                        HWStressDataProvider.this.relaxCloseProcessNew(length, iArr, iArr2);
                        return;
                    case 13:
                        C2538c.c(HWStressDataProvider.TAG, new Object[]{"processRRData(), enter GAME_CLOSE"});
                        HWStressDataProvider.this.gameCloseProcess(length, iArr, iArr2);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void gameClosePreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mSignalTime = jSONObject.getInt("duration");
                this.gameScore = jSONObject.getInt(WBConstants.GAME_PARAMS_SCORE);
                C2538c.c(TAG, new Object[]{"getStressResult(), mSignalTime: " + this.mSignalTime});
                C2538c.c(TAG, new Object[]{"getStressResult(), gameScore: " + this.gameScore});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult()," + e.getMessage()});
            }
        }
    }

    private void gameOpenPreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mMaxDuration = jSONObject.getInt("max_duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mMaxDuration: " + this.mMaxDuration});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult()," + e.getMessage()});
            }
        }
    }

    private void relaxClosePreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mSignalTime = jSONObject.getInt("duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mSignalTime: " + this.mSignalTime});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult()," + e.getMessage()});
            }
        }
    }

    private void relaxOpenPreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mMaxDuration = jSONObject.getInt("max_duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mMaxDuration: " + this.mMaxDuration});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult(), " + e.getMessage()});
            }
        }
    }

    private void stressCalibrationResetPreProcess() {
        String a = a.a(BaseApplication.b(), String.valueOf(25), "calibration_flag");
        String a2 = a.a(BaseApplication.b(), String.valueOf(25), "calibration_result");
        if (!(a == null || a.isEmpty())) {
            a.b(BaseApplication.b(), String.valueOf(25), "calibration_flag");
        }
        if (!(a2 == null || a2.isEmpty())) {
            a.b(BaseApplication.b(), String.valueOf(25), "calibration_result");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 8);
            jSONObject.put("result_code", 0);
        } catch (JSONException e) {
            C2538c.e(TAG, new Object[]{"getStressResult(), " + e.getMessage()});
        }
        this.mCallBack.onResponse(0, jSONObject.toString());
        C2538c.c(TAG, new Object[]{"stressCalibrationResetPreProcess(), success! "});
    }

    private void stressCalibrationClosePreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mSignalTime = jSONObject.getInt("duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mSignalTime: " + this.mSignalTime});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult(), " + e.getMessage()});
            }
        }
        for (int i = 0; i < 16; i++) {
            this.mCalibData[i] = 0.0f;
        }
        this.mCalibData[16] = (float) this.mCalibrationScore;
        this.mCalibData[17] = 2.0f;
    }

    private void stressCalibrationOpenPreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mCalibrationScore = jSONObject.getInt(WBConstants.GAME_PARAMS_SCORE);
                this.mMaxDuration = jSONObject.getInt("max_duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mCalibrationScore: " + this.mCalibrationScore});
                C2538c.c(TAG, new Object[]{"getStressResult(), mMaxDuration: " + this.mMaxDuration});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult(), " + e.getMessage()});
            }
        }
    }

    private void stressClosePreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mSignalTime = jSONObject.getInt("duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), duration: " + this.mSignalTime});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult()," + e.getMessage()});
            }
        }
        String a = a.a(BaseApplication.b(), String.valueOf(25), "calibration_result");
        int i;
        if (a == null || a.isEmpty()) {
            for (i = 0; i < 14; i++) {
                this.mCalibData[i] = 0.0f;
                C2538c.c(TAG, new Object[]{"getStressResult(), mCalibData: " + String.valueOf(this.mCalibData[i])});
            }
        } else {
            a = a.replace("[", "").replace("]", "");
            C2538c.c(TAG, new Object[]{"getStressResult(), calibrationResultString: " + a});
            String[] split = a.split(",");
            for (i = 0; i < 10; i++) {
                this.mCalibData[i] = Float.parseFloat(split[i]);
                C2538c.c(TAG, new Object[]{"getStressResult(), mCalibData: " + String.valueOf(this.mCalibData[i])});
            }
            for (i = 10; i < 14; i++) {
                this.mCalibData[i] = 0.0f;
            }
        }
        a = a.a(BaseApplication.b(), String.valueOf(25), "real_calib_score");
        String a2 = a.a(BaseApplication.b(), String.valueOf(25), "max_score");
        String a3 = a.a(BaseApplication.b(), String.valueOf(25), "min_score");
        if (a == null || a.isEmpty()) {
            this.mRealCalibScore = 0.0f;
        } else {
            this.mRealCalibScore = Float.parseFloat(a);
        }
        if (a2 == null || a2.isEmpty()) {
            this.maxScore = 0.0f;
        } else {
            this.maxScore = Float.parseFloat(a2);
        }
        if (a3 == null || a3.isEmpty()) {
            this.minScore = 100.0f;
        } else {
            this.minScore = Float.parseFloat(a3);
        }
        this.mCalibData[14] = this.maxScore;
        this.mCalibData[15] = this.minScore;
        this.mCalibData[16] = this.mRealCalibScore;
        this.mCalibData[17] = 0.0f;
    }

    private void stressOpenPreProcess(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mMaxDuration = jSONObject.getInt("max_duration");
                C2538c.c(TAG, new Object[]{"getStressResult(), mMaxDuration: " + this.mMaxDuration});
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"getStressResult()," + e.getMessage()});
            }
        }
    }

    private void gameCloseProcess(int i, int[] iArr, int[] iArr2) {
        if (isValidGameParam(this.reserve_1, this.reserve_2, this.mSignalTime, i, this.gameScore, iArr, iArr2)) {
            float[] gameResultFromAlgorithm = getGameResultFromAlgorithm(this.reserve_1, this.reserve_2, this.mSignalTime, i, this.gameScore, iArr, iArr2);
            JSONObject jSONObject = new JSONObject();
            if (gameResultFromAlgorithm == null || gameResultFromAlgorithm.length != 8) {
                C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm is null!"});
                inValidCallBackProcess(101);
                return;
            }
            C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm.length : " + gameResultFromAlgorithm.length});
            try {
                jSONObject.put("type", 13);
                jSONObject.put("flag", (double) gameResultFromAlgorithm[7]);
                jSONObject.put("final_score", (double) gameResultFromAlgorithm[5]);
                jSONObject.put("p_score", (double) gameResultFromAlgorithm[4]);
                jSONObject.put("d_score", (double) gameResultFromAlgorithm[3]);
                C2538c.c(TAG, new Object[]{"processRRData(), type, flag, final_score, p_score, d_score:13 ," + gameResultFromAlgorithm[7] + " ," + gameResultFromAlgorithm[5] + " ," + gameResultFromAlgorithm[4] + " ," + gameResultFromAlgorithm[3]});
                if (this.mCallBack != null) {
                    this.mCallBack.onResponse(0, jSONObject.toString());
                }
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"processRRData(), " + e.getMessage()});
            }
            for (int i2 = 0; i2 < gameResultFromAlgorithm.length; i2++) {
                C2538c.c(TAG, new Object[]{"processRRData(), gameFromAlgorithm[" + i2 + "]: " + gameResultFromAlgorithm[i2]});
            }
            return;
        }
        C2538c.c(TAG, new Object[]{"invalid gameParam!"});
        inValidCallBackProcess(100);
    }

    private boolean isValidGameParam(int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || iArr.length != iArr2.length) {
            return false;
        }
        return true;
    }

    private void relaxCloseProcessNew(int i, int[] iArr, int[] iArr2) {
        if (isValidRelaxParam(this.reserve_1, this.reserve_2, this.reserve_3, this.mSignalTime, i, iArr, iArr2)) {
            float[] relaxResultFromAlgorithm = getRelaxResultFromAlgorithm(this.reserve_1, this.reserve_2, this.reserve_3, this.mSignalTime, i, iArr, iArr2);
            JSONObject jSONObject = new JSONObject();
            if (relaxResultFromAlgorithm == null || relaxResultFromAlgorithm.length != 23) {
                C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm is null!"});
                inValidCallBackProcess(101);
                return;
            }
            C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm.length : " + relaxResultFromAlgorithm.length});
            try {
                jSONObject.put("type", 10);
                jSONObject.put("flag", (double) relaxResultFromAlgorithm[20]);
                jSONObject.put("grade", (double) relaxResultFromAlgorithm[14]);
                C2538c.c(TAG, new Object[]{"processRRData(), type, flag, grade :10 ," + relaxResultFromAlgorithm[20] + " ," + relaxResultFromAlgorithm[14]});
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("bar_count", (double) relaxResultFromAlgorithm[8]);
                jSONObject2.put("codex_1", (double) relaxResultFromAlgorithm[9]);
                jSONObject2.put("codex_2", (double) relaxResultFromAlgorithm[10]);
                jSONObject2.put("codex_3", (double) relaxResultFromAlgorithm[11]);
                jSONObject2.put("codex_4", (double) relaxResultFromAlgorithm[12]);
                jSONArray.put(jSONObject2);
                jSONObject.put("bar_codex", jSONArray);
                if (this.mCallBack != null) {
                    this.mCallBack.onResponse(0, jSONObject.toString());
                }
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"processRRData(), " + e.getMessage()});
            }
            for (int i2 = 0; i2 < relaxResultFromAlgorithm.length; i2++) {
                C2538c.c(TAG, new Object[]{"processRRData(), relaxResultFromAlgorithm[" + i2 + "]: " + relaxResultFromAlgorithm[i2]});
            }
            return;
        }
        C2538c.c(TAG, new Object[]{"invalid relaxParam!"});
        inValidCallBackProcess(100);
    }

    private boolean isValidRelaxParam(int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || iArr.length != iArr2.length) {
            return false;
        }
        return true;
    }

    private void stressCalibrationCloseProcess(int i, int[] iArr, int[] iArr2) {
        if (isValidStressParam(this.mCalibData, this.mSignalTime, i, iArr, iArr2)) {
            float[] stressResultFromAlgorithm = getStressResultFromAlgorithm(this.mCalibData, this.mSignalTime, i, iArr, iArr2);
            JSONObject jSONObject = new JSONObject();
            if (stressResultFromAlgorithm == null || stressResultFromAlgorithm.length != 19) {
                C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm is null!"});
                inValidCallBackProcess(101);
                return;
            }
            int i2;
            C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm.length : " + stressResultFromAlgorithm.length});
            for (i2 = 0; i2 < 10; i2++) {
                this.calibrationResultArr[i2] = stressResultFromAlgorithm[i2];
            }
            if (1 == ((int) stressResultFromAlgorithm[18])) {
                a.a(BaseApplication.b(), String.valueOf(25), "calibration_flag", String.valueOf(0), new com.huawei.hwdataaccessmodel.a.c(0));
            }
            this.mRealCalibScore = stressResultFromAlgorithm[14];
            a.a(BaseApplication.b(), String.valueOf(25), "calibration_result", Arrays.toString(this.calibrationResultArr), new com.huawei.hwdataaccessmodel.a.c(0));
            a.a(BaseApplication.b(), String.valueOf(25), "real_calib_score", String.valueOf(this.mRealCalibScore), new com.huawei.hwdataaccessmodel.a.c(0));
            try {
                jSONObject.put("type", 5);
                jSONObject.put("flag", (double) stressResultFromAlgorithm[18]);
                jSONObject.put(WBConstants.GAME_PARAMS_SCORE, (double) stressResultFromAlgorithm[15]);
                jSONObject.put("grade", (double) stressResultFromAlgorithm[16]);
                C2538c.c(TAG, new Object[]{"processRRData(), type, flag, score, grade :5 ," + stressResultFromAlgorithm[18] + " ," + stressResultFromAlgorithm[15] + " ," + stressResultFromAlgorithm[16]});
                if (this.mCallBack != null) {
                    this.mCallBack.onResponse(0, jSONObject.toString());
                }
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"processRRData(), " + e.getMessage()});
            }
            for (i2 = 0; i2 < stressResultFromAlgorithm.length; i2++) {
                C2538c.c(TAG, new Object[]{"processRRData(), stressCalibrationResultFromAlgorithm[" + i2 + "]: " + stressResultFromAlgorithm[i2]});
            }
            return;
        }
        C2538c.c(TAG, new Object[]{"invalid stressCalibParam!"});
        inValidCallBackProcess(100);
    }

    private void stressCloseProcess(int i, int[] iArr, int[] iArr2) {
        if (isValidStressParam(this.mCalibData, this.mSignalTime, i, iArr, iArr2)) {
            float[] stressResultFromAlgorithm = getStressResultFromAlgorithm(this.mCalibData, this.mSignalTime, i, iArr, iArr2);
            JSONObject jSONObject = new JSONObject();
            if (stressResultFromAlgorithm == null || stressResultFromAlgorithm.length != 19) {
                C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm is null!"});
                inValidCallBackProcess(101);
                return;
            }
            C2538c.c(TAG, new Object[]{"processRRData(), resultFromAlgorithm.length : " + stressResultFromAlgorithm.length});
            if (1 == ((int) stressResultFromAlgorithm[18])) {
                C2538c.c(TAG, new Object[]{"processRRData(), Stress Algorithm Success!"});
                if (this.maxScore < stressResultFromAlgorithm[14]) {
                    this.maxScore = stressResultFromAlgorithm[14];
                    a.a(BaseApplication.b(), String.valueOf(25), "max_score", String.valueOf(this.maxScore), new com.huawei.hwdataaccessmodel.a.c(0));
                }
                if (this.minScore > stressResultFromAlgorithm[14]) {
                    this.minScore = stressResultFromAlgorithm[14];
                    a.a(BaseApplication.b(), String.valueOf(25), "min_score", String.valueOf(this.minScore), new com.huawei.hwdataaccessmodel.a.c(0));
                }
            }
            try {
                jSONObject.put("type", 2);
                jSONObject.put("flag", (double) stressResultFromAlgorithm[18]);
                jSONObject.put(WBConstants.GAME_PARAMS_SCORE, (double) stressResultFromAlgorithm[15]);
                jSONObject.put("grade", (double) stressResultFromAlgorithm[16]);
                C2538c.c(TAG, new Object[]{"processRRData(), type, flag, score, grade :2 ," + stressResultFromAlgorithm[18] + " ," + stressResultFromAlgorithm[15] + " ," + stressResultFromAlgorithm[16]});
                if (this.mCallBack != null) {
                    this.mCallBack.onResponse(0, jSONObject.toString());
                }
            } catch (JSONException e) {
                C2538c.e(TAG, new Object[]{"processRRData(), " + e.getMessage()});
            }
            for (int i2 = 0; i2 < stressResultFromAlgorithm.length; i2++) {
                C2538c.c(TAG, new Object[]{"processRRData(), StressResultFromAlgorithm[" + i2 + "]: " + stressResultFromAlgorithm[i2]});
            }
            return;
        }
        C2538c.c(TAG, new Object[]{"invalid stressParam!"});
        inValidCallBackProcess(100);
    }

    private void inValidCallBackProcess(int i) {
        C2538c.c(TAG, new Object[]{"inValidCallBackProcess(), errorFlagCode :" + i});
        C2538c.c(TAG, new Object[]{"inValidCallBackProcess(), type:" + this.type});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            switch (this.type) {
                case 2:
                case 5:
                    jSONObject.put("flag", 0);
                    jSONObject.put(WBConstants.GAME_PARAMS_SCORE, 0);
                    jSONObject.put("grade", 0);
                    break;
                case 10:
                    jSONObject.put("flag", 0);
                    jSONObject.put("grade", 0);
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bar_count", 0);
                    jSONObject2.put("codex_1", 0);
                    jSONObject2.put("codex_2", 0);
                    jSONObject2.put("codex_3", 0);
                    jSONObject2.put("codex_4", 0);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("bar_codex", jSONArray);
                    break;
                case 13:
                    jSONObject.put("flag", 0);
                    jSONObject.put("final_score", 0);
                    jSONObject.put("p_score", 0);
                    jSONObject.put("d_score", 0);
                    break;
            }
            if (this.mCallBack != null) {
                this.mCallBack.onResponse(0, jSONObject.toString());
            }
        } catch (JSONException e) {
            C2538c.c(TAG, new Object[]{"inValidCallBackProcess(), " + e.getMessage()});
        }
    }

    private boolean isValidStressParam(float[] fArr, int i, int i2, int[] iArr, int[] iArr2) {
        if (fArr.length != 18 || i < 0 || i2 < 0 || iArr.length != iArr2.length) {
            return false;
        }
        return true;
    }
}
