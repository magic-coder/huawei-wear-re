package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class GetActivityListModel extends BaseEntityModel implements Externalizable {
    private static final long serialVersionUID = 9077384547756030938L;
    public int deviceType;
    public JSONObject response;
    public String url = "";

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
    }

    public JSONObject getResponse() {
        return this.response;
    }

    public void setResponse(JSONObject jSONObject) {
        this.response = jSONObject;
    }

    public String toString() {
        return "GetActivityListModel { url='" + this.url + '\'' + ", deviceType = " + this.deviceType + ", response = " + this.response.toString() + '}';
    }
}
