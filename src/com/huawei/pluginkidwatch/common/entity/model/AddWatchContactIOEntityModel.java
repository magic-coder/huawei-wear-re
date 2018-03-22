package com.huawei.pluginkidwatch.common.entity.model;

public class AddWatchContactIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public Contact contact;
    public String deviceCode = "-1";

    public AddWatchContactIOEntityModel(Contact contact) {
        this.contact = contact;
    }
}
