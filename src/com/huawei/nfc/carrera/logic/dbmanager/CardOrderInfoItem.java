package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentValues;
import com.huawei.nfc.carrera.storage.db.DataModel.CardOrderColumns;

public class CardOrderInfoItem {
    private String reference_id;
    private long timestamp;

    public CardOrderInfoItem(String str, long j) {
        this.reference_id = str;
        this.timestamp = j;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CardOrderColumns.COLUMN_NAME_REFENCE_ID, this.reference_id);
        contentValues.put("timestamp", Long.valueOf(this.timestamp));
        return contentValues;
    }

    public void setReference_id(String str) {
        this.reference_id = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String getReference_id() {
        return this.reference_id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
