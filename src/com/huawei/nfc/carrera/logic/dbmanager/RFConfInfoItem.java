package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentValues;
import com.huawei.nfc.carrera.server.card.response.RFConfServerInfo;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;

public class RFConfInfoItem {
    private String issuerId;
    private String model;
    private String rfURL;
    private String romVersion;
    private long timestamp;

    public interface RFConfInfoItemSai1 {
    }

    public interface RFConfInfoItemSai2 {
    }

    public interface RFConfInfoItemSai3 {
    }

    public interface RFConfInfoItemSai4 {
    }

    public interface RFConfInfoItemSai5 {
    }

    public interface RFConfInfoItemSai6 {
    }

    public interface RFConfInfoItemSai7 {
    }

    public RFConfInfoItem(RFConfServerInfo rFConfServerInfo) {
        this.issuerId = rFConfServerInfo.getIssuerId();
        this.model = rFConfServerInfo.getModel();
        this.romVersion = rFConfServerInfo.getRomVersion();
        this.rfURL = rFConfServerInfo.getRfURL();
        this.timestamp = rFConfServerInfo.getTimeStamp();
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getRfURL() {
        return this.rfURL;
    }

    public void setRfURL(String str) {
        this.rfURL = str;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public void setTimeStamp(long j) {
        this.timestamp = j;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("issuer_id", this.issuerId);
        contentValues.put("model", this.model);
        contentValues.put(RFConfInfoColumns.COLUMN_NAME_RFCONF_URL, this.rfURL);
        contentValues.put(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, this.romVersion);
        contentValues.put("timestamp", Long.valueOf(this.timestamp));
        return contentValues;
    }
}
