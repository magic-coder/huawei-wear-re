package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.List;

public class RFConfInfoOperator extends BaseOperator {
    RFConfInfoOperator(ContentResolver contentResolver) {
        super(contentResolver);
    }

    public HashMap<String, RFConfInfoItem> queryRFConfInfo() {
        Throwable e;
        Cursor query;
        try {
            query = this.mContentResolver.query(RFConfInfoColumns.CONTENT_URI, null, null, null, null);
            try {
                HashMap<String, RFConfInfoItem> iteratorRFConfInfoCursor = iteratorRFConfInfoCursor(query);
                if (query == null) {
                    return iteratorRFConfInfoCursor;
                }
                query.close();
                return iteratorRFConfInfoCursor;
            } catch (SQLException e2) {
                e = e2;
                try {
                    LogX.e("CardInfoDBManager", "queryCardProductInfo sql exception. " + Log.getStackTraceString(e));
                    if (query != null) {
                        return null;
                    }
                    query.close();
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (query != null) {
                        query.close();
                    }
                    throw e;
                }
            }
        } catch (SQLException e3) {
            e = e3;
            query = null;
            LogX.e("CardInfoDBManager", "queryCardProductInfo sql exception. " + Log.getStackTraceString(e));
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public void insertOrUpdateRFConfInfos(List<RFConfInfoItem> list) {
        if (list == null || list.isEmpty()) {
            LogX.d("insertOrUpdateRFConfInfos, info is empty.");
            return;
        }
        for (RFConfInfoItem rFConfInfoItem : list) {
            if (StringUtil.isEmpty(rFConfInfoItem.getIssuerId(), true)) {
                LogX.e("insertOrUpdateRFConfInfos, ignore this card info.");
            } else if (isRecordInfoExist(RFConfInfoColumns.CONTENT_URI, "issuer_id", rFConfInfoItem.getIssuerId())) {
                updateRecordInfo(RFConfInfoColumns.CONTENT_URI, "issuer_id", rFConfInfoItem.getIssuerId(), rFConfInfoItem.toContentValues());
            } else {
                insertRecordInfo(RFConfInfoColumns.CONTENT_URI, rFConfInfoItem.toContentValues());
            }
        }
    }

    private HashMap<String, RFConfInfoItem> iteratorRFConfInfoCursor(Cursor cursor) {
        HashMap<String, RFConfInfoItem> hashMap = new HashMap();
        if (cursor == null || cursor.getCount() <= 0) {
            LogX.d("CardInfoDBManager", "iteratorCardProductCursor the cursor is empty");
        } else {
            try {
                int columnIndex = cursor.getColumnIndex("issuer_id");
                int columnIndex2 = cursor.getColumnIndex("model");
                int columnIndex3 = cursor.getColumnIndex(RFConfInfoColumns.COLUMN_NAME_RFCONF_URL);
                int columnIndex4 = cursor.getColumnIndex(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION);
                int columnIndex5 = cursor.getColumnIndex("timestamp");
                while (cursor.moveToNext()) {
                    RFConfInfoItem rFConfInfoItem = new RFConfInfoItem();
                    rFConfInfoItem.setIssuerId(cursor.getString(columnIndex));
                    rFConfInfoItem.setModel(cursor.getString(columnIndex2));
                    rFConfInfoItem.setRfURL(cursor.getString(columnIndex3));
                    rFConfInfoItem.setRomVersion(cursor.getString(columnIndex4));
                    rFConfInfoItem.setTimeStamp(cursor.getLong(columnIndex5));
                    hashMap.put(rFConfInfoItem.getIssuerId(), rFConfInfoItem);
                }
            } catch (Throwable e) {
                LogX.e("CardInfoDBManager", "iteratorCardProductCursor sql exception. " + Log.getStackTraceString(e));
            }
        }
        return hashMap;
    }
}
