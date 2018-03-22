package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

class IssuerInfoOperator extends BaseOperator {
    IssuerInfoOperator(ContentResolver contentResolver) {
        super(contentResolver);
    }

    List<IssuerInfoItem> queryIssuerInfo() {
        Cursor query;
        Throwable e;
        try {
            query = this.mContentResolver.query(IssuerInfoColumns.CONTENT_URI, null, null, null, null);
            try {
                List<IssuerInfoItem> iteratorIssuerInfoCursor = iteratorIssuerInfoCursor(query);
                if (query == null) {
                    return iteratorIssuerInfoCursor;
                }
                query.close();
                return iteratorIssuerInfoCursor;
            } catch (SQLException e2) {
                e = e2;
                try {
                    LogX.e("CardInfoDBManager", "queryIssuerInfo sql exception. " + Log.getStackTraceString(e));
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
            LogX.e("CardInfoDBManager", "queryIssuerInfo sql exception. " + Log.getStackTraceString(e));
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

    IssuerInfoItem queryIssuerInfoById(String str) {
        Cursor query;
        Throwable e;
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        List iteratorIssuerInfoCursor;
        try {
            query = this.mContentResolver.query(IssuerInfoColumns.CONTENT_URI, null, "issuer_id = ?", new String[]{str}, null);
            try {
                iteratorIssuerInfoCursor = iteratorIssuerInfoCursor(query);
                if (query != null) {
                    query.close();
                }
            } catch (SQLException e2) {
                e = e2;
                try {
                    LogX.e("CardInfoDBManager", "queryIssuerInfoByIssuerId sql exception. " + Log.getStackTraceString(e));
                    if (query == null) {
                        iteratorIssuerInfoCursor = null;
                    } else {
                        query.close();
                        iteratorIssuerInfoCursor = null;
                    }
                    if (iteratorIssuerInfoCursor != null) {
                    }
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
            LogX.e("CardInfoDBManager", "queryIssuerInfoByIssuerId sql exception. " + Log.getStackTraceString(e));
            if (query == null) {
                query.close();
                iteratorIssuerInfoCursor = null;
            } else {
                iteratorIssuerInfoCursor = null;
            }
            if (iteratorIssuerInfoCursor != null) {
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        if (iteratorIssuerInfoCursor != null || iteratorIssuerInfoCursor.size() <= 0) {
            return null;
        }
        return (IssuerInfoItem) iteratorIssuerInfoCursor.get(0);
    }

    private List<IssuerInfoItem> iteratorIssuerInfoCursor(Cursor cursor) {
        List<IssuerInfoItem> arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0) {
            LogX.d("CardInfoDBManager", "iteratorIssuerInfoCursor the cursor is empty");
        } else {
            int columnIndex = cursor.getColumnIndex("issuer_id");
            int columnIndex2 = cursor.getColumnIndex("name");
            int columnIndex3 = cursor.getColumnIndex("description");
            int columnIndex4 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_LOGO_URL);
            int columnIndex5 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_ISSUER_TYPE);
            int columnIndex6 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_SUPPORT_CARD_TYPE);
            int columnIndex7 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_MODE);
            int columnIndex8 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_APK_VERSION);
            int columnIndex9 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_CONTACT_NUM);
            int columnIndex10 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_DEBIT_CALL_NUM);
            int columnIndex11 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_CREDIT_CALL_NUM);
            int columnIndex12 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_DEBITTC_URL);
            int columnIndex13 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_CREDITTC_URL);
            int columnIndex14 = cursor.getColumnIndex("timestamp");
            int columnIndex15 = cursor.getColumnIndex("reserved_info");
            int columnIndex16 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_DEBIT_WEBSITE_URL);
            int columnIndex17 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_CREDIT_WEBSITE_URL);
            int columnIndex18 = cursor.getColumnIndex(IssuerInfoColumns.COLUMN_NAME_APPINFO);
            int columnIndex19 = cursor.getColumnIndex("sn");
            while (cursor.moveToNext()) {
                IssuerInfoItem issuerInfoItem = new IssuerInfoItem();
                issuerInfoItem.setIssuerId(cursor.getString(columnIndex));
                issuerInfoItem.setName(cursor.getString(columnIndex2));
                issuerInfoItem.setDescription(cursor.getString(columnIndex3));
                issuerInfoItem.setLogoUrl(cursor.getString(columnIndex4));
                issuerInfoItem.setIssuerType(cursor.getInt(columnIndex5));
                issuerInfoItem.setSupportType(cursor.getInt(columnIndex6));
                issuerInfoItem.setMode(cursor.getInt(columnIndex7));
                issuerInfoItem.setSn(cursor.getInt(columnIndex19));
                try {
                    issuerInfoItem.setWalletVersion(Integer.parseInt(cursor.getString(columnIndex8)));
                } catch (NumberFormatException e) {
                    issuerInfoItem.setWalletVersion(0);
                }
                issuerInfoItem.setContactNumber(cursor.getString(columnIndex9));
                issuerInfoItem.setDebitCallCenterNumber(cursor.getString(columnIndex10));
                issuerInfoItem.setCreditCallCenterNumber(cursor.getString(columnIndex11));
                issuerInfoItem.setDebitTcUrl(cursor.getString(columnIndex12));
                issuerInfoItem.setCreditTcUrl(cursor.getString(columnIndex13));
                issuerInfoItem.setDebitWebsite(cursor.getString(columnIndex16));
                issuerInfoItem.setCreditWebsite(cursor.getString(columnIndex17));
                issuerInfoItem.setTimeStamp(cursor.getLong(columnIndex14));
                issuerInfoItem.setReservedInfo(cursor.getString(columnIndex15));
                issuerInfoItem.parseReservedJson();
                issuerInfoItem.setAppInfo(cursor.getString(columnIndex18));
                issuerInfoItem.parseAppInfoJson();
                arrayList.add(issuerInfoItem);
            }
        }
        return arrayList;
    }

    void insertOrUpdateIssuerInfos(List<IssuerInfoItem> list) {
        if (list == null || list.isEmpty()) {
            LogX.d("insertOrUpdateCardProductInfos, info is empty.");
            return;
        }
        for (IssuerInfoItem issuerInfoItem : list) {
            if (StringUtil.isEmpty(issuerInfoItem.getIssuerId(), true)) {
                LogX.e("insertOrUpdateCardProductInfos, ignore this card info.");
            } else if (isRecordInfoExist(IssuerInfoColumns.CONTENT_URI, "issuer_id", issuerInfoItem.getIssuerId())) {
                updateRecordInfo(IssuerInfoColumns.CONTENT_URI, "issuer_id", issuerInfoItem.getIssuerId(), issuerInfoItem.toContentValues());
            } else {
                insertRecordInfo(IssuerInfoColumns.CONTENT_URI, issuerInfoItem.toContentValues());
            }
        }
    }
}
