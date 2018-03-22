package com.huawei.pluginkidwatch.common.entity.model;

import java.util.ArrayList;
import java.util.List;

public class BindDeviceInfosIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String accessToken = "";
    public List<DeviceProfile> deviceProfiles = new ArrayList();
}
