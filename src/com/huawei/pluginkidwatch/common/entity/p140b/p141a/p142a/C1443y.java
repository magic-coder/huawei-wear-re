package com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HealthData;
import com.huawei.pluginkidwatch.common.entity.model.HealthDataIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MovePointData;
import com.huawei.pluginkidwatch.common.entity.model.SegmentMoveData;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HealthDataBuilder */
public class C1443y extends C1418a {
    private String f3321k = "BindDeviceBuilder";
    private HealthDataIOEntityModel f3322l;

    public C1443y(HealthDataIOEntityModel healthDataIOEntityModel) {
        this.f3322l = healthDataIOEntityModel;
    }

    public String mo2512a() {
        StringBuffer stringBuffer = new StringBuffer();
        m6597a(stringBuffer, this.f3322l);
        if (this.f3322l != null) {
            stringBuffer.append("&deviceCode=");
            stringBuffer.append(this.f3322l.deviceCode);
            stringBuffer.append("&dateEnd=");
            stringBuffer.append(this.f3322l.daysEnd);
            stringBuffer.append("&daysCount=");
            stringBuffer.append(this.f3322l.daysCount);
            return stringBuffer.toString();
        }
        C2538c.m12680e(this.f3321k, "model Is Null , Can't Convert It ");
        return "";
    }

    public BaseEntityModel mo2511a(String str) {
        BaseEntityModel healthDataIOEntityModel = new HealthDataIOEntityModel();
        C2538c.m12674b("strResponse", "strResponse = " + str);
        if (str == null || str.length() <= 0) {
            return healthDataIOEntityModel;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            healthDataIOEntityModel.retCode = jSONObject.getInt(XMLMessage.MESSAGE_RET_CODE);
            JSONArray jSONArray = jSONObject.getJSONArray("healthDatas");
            C2538c.m12674b("strResponse", "arrayhealthData = " + jSONArray.toString());
            C2538c.m12674b("strResponse", "arrayhealthData.size = " + jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                HealthData healthData = new HealthData();
                jSONObject = jSONArray.getJSONObject(i);
                healthData.logDate = jSONObject.getString("logDate");
                JSONArray jSONArray2 = jSONObject.getJSONArray("segmentMoveDatas");
                C2538c.m12674b("strResponse", "arraySegmentMoveData.size = " + jSONArray2.length());
                C2538c.m12674b("strResponse", "segmentMoveDatas = " + jSONObject.toString());
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    SegmentMoveData segmentMoveData = new SegmentMoveData();
                    jSONObject = jSONArray2.getJSONObject(i2);
                    C2538c.m12674b("strResponse", "movePointDatas = " + jSONObject.toString());
                    segmentMoveData.startTime = jSONObject.getString("startTime");
                    JSONArray jSONArray3 = jSONObject.getJSONArray("movePointDatas");
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        MovePointData movePointData = new MovePointData();
                        jSONObject = jSONArray3.getJSONObject(i3);
                        C2538c.m12674b("strResponse", "move_points = " + jSONObject.toString());
                        movePointData.move_type = C1492l.m6920d(jSONObject.getString("move_type"));
                        JSONArray jSONArray4 = jSONObject.getJSONArray("move_points");
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            movePointData.move_points.add(Integer.valueOf(jSONArray4.getInt(i4)));
                        }
                        segmentMoveData.movePointDatas.add(movePointData);
                    }
                    healthData.segmentMoveDatas.add(segmentMoveData);
                }
                healthDataIOEntityModel.healthData.add(healthData);
            }
            return healthDataIOEntityModel;
        } catch (JSONException e) {
            C2538c.m12674b("strResponse", "e = " + e.getMessage());
            return null;
        }
    }
}
