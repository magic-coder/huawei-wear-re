package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class GetMessagesModel extends BaseEntityModel implements Externalizable {
    private static final long serialVersionUID = 9077384547756030938L;
    public int appId;
    public String appVersion;
    public int deviceType;
    public String lastTime = "";
    public JSONObject response;
    public String url = "";

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public JSONObject getResponse() {
        return this.response;
    }

    public void setResponse(JSONObject jSONObject) {
        this.response = jSONObject;
    }

    public String getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(String str) {
        this.lastTime = str;
    }

    public int getAppId() {
        return this.appId;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String toString() {
        return "GetMessagesModel{url='" + this.url + '\'' + ", deviceType=" + this.deviceType + ", response=" + this.response.toString() + '}';
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
    }

    public void getMsgModelName() {
    }

    public void requestMsgModelHeadUrl() {
    }

    public void downloadMsgModelNameUrl() {
    }

    public void judgeMsgModelWeightBySomeInfo() {
    }

    public void setMsgModelSwitchUpload() {
    }

    public void updataMsgModelLocalTable() {
    }

    public void dealWithMsgModelResetFactory() {
    }

    public void refreshMsgModelInitData() {
    }

    public void queryMsgModelProcessData() {
    }

    public void contrustMsgModelHeadImage() {
    }

    public void changeMsgModelDeviceInfo() {
    }
}
