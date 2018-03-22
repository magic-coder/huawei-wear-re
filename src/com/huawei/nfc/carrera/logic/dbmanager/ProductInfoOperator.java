package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.huawei.nfc.carrera.storage.db.DataModel.CardProductInfoColumns;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

class ProductInfoOperator extends BaseOperator {
    private static final String TAG = "ProductInfoOperator";

    ProductInfoOperator(ContentResolver contentResolver) {
        super(contentResolver);
    }

    void insertOrUpdateCardProductInfos(List<CardProductInfoItem> list) {
        if (list == null || list.isEmpty()) {
            C2538c.c(TAG, new Object[]{"insertOrUpdateCardProductInfos, info is empty."});
            return;
        }
        for (CardProductInfoItem cardProductInfoItem : list) {
            C2538c.c(TAG, new Object[]{"CardProductInfoItem info : " + cardProductInfoItem.toString()});
            if (StringUtil.isEmpty(cardProductInfoItem.getProductId(), true)) {
                C2538c.e("insertOrUpdateCardProductInfos, ignore this card info.", new Object[0]);
            } else if (isRecordInfoExist(CardProductInfoColumns.CONTENT_URI, CardProductInfoColumns.COLUMN_NAME_PRODUCT_ID, cardProductInfoItem.getProductId())) {
                updateRecordInfo(CardProductInfoColumns.CONTENT_URI, CardProductInfoColumns.COLUMN_NAME_PRODUCT_ID, cardProductInfoItem.getProductId(), cardProductInfoItem.toContentValues());
            } else {
                insertRecordInfo(CardProductInfoColumns.CONTENT_URI, cardProductInfoItem.toContentValues());
            }
        }
    }

    List<CardProductInfoItem> queryCardProductInfo() {
        Cursor query;
        Throwable e;
        try {
            query = this.mContentResolver.query(CardProductInfoColumns.CONTENT_URI, null, null, null, null);
            try {
                List<CardProductInfoItem> iteratorCardProductCursor = iteratorCardProductCursor(query);
                if (query == null) {
                    return iteratorCardProductCursor;
                }
                query.close();
                return iteratorCardProductCursor;
            } catch (SQLException e2) {
                e = e2;
                try {
                    C2538c.e(TAG, new Object[]{"queryCardProductInfo sql exception. " + Log.getStackTraceString(e)});
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
            C2538c.e(TAG, new Object[]{"queryCardProductInfo sql exception. " + Log.getStackTraceString(e)});
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

    CardProductInfoItem queryCardProductInfoById(String str) {
        Throwable e;
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        List iteratorCardProductCursor;
        Cursor query;
        try {
            query = this.mContentResolver.query(CardProductInfoColumns.CONTENT_URI, null, "product_id = ?", new String[]{str}, null);
            try {
                iteratorCardProductCursor = iteratorCardProductCursor(query);
                if (query != null) {
                    query.close();
                }
            } catch (SQLException e2) {
                e = e2;
                try {
                    C2538c.e(TAG, new Object[]{"queryIssuerInfoByIssuerId sql exception. " + Log.getStackTraceString(e)});
                    if (query == null) {
                        iteratorCardProductCursor = null;
                    } else {
                        query.close();
                        iteratorCardProductCursor = null;
                    }
                    if (iteratorCardProductCursor != null) {
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
            C2538c.e(TAG, new Object[]{"queryIssuerInfoByIssuerId sql exception. " + Log.getStackTraceString(e)});
            if (query == null) {
                query.close();
                iteratorCardProductCursor = null;
            } else {
                iteratorCardProductCursor = null;
            }
            if (iteratorCardProductCursor != null) {
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
        if (iteratorCardProductCursor != null || iteratorCardProductCursor.size() <= 0) {
            return null;
        }
        return (CardProductInfoItem) iteratorCardProductCursor.get(0);
    }

    private List<CardProductInfoItem> iteratorCardProductCursor(Cursor cursor) {
        List<CardProductInfoItem> arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0) {
            C2538c.c(TAG, new Object[]{TAG, "iteratorCardProductCursor the cursor is empty"});
        } else {
            try {
                int columnIndex = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_PRODUCT_ID);
                int columnIndex2 = cursor.getColumnIndex("name");
                int columnIndex3 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_PIC_URL);
                int columnIndex4 = cursor.getColumnIndex("description");
                int columnIndex5 = cursor.getColumnIndex("card_type");
                int columnIndex6 = cursor.getColumnIndex("timestamp");
                int columnIndex7 = cursor.getColumnIndex("version");
                int columnIndex8 = cursor.getColumnIndex("issuer_id");
                int columnIndex9 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_MKT_INFO);
                int columnIndex10 = cursor.getColumnIndex("reserved_info");
                int columnIndex11 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_FONT_COLOR);
                int columnIndex12 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_1);
                int columnIndex13 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_2);
                int columnIndex14 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_3);
                int columnIndex15 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_4);
                int columnIndex16 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_5);
                int columnIndex17 = cursor.getColumnIndex(CardProductInfoColumns.COLUMN_NAME_RESERVD_6);
                while (cursor.moveToNext()) {
                    CardProductInfoItem cardProductInfoItem = new CardProductInfoItem();
                    cardProductInfoItem.setProductId(cursor.getString(columnIndex));
                    cardProductInfoItem.setProductName(cursor.getString(columnIndex2));
                    cardProductInfoItem.setPictureUrl(cursor.getString(columnIndex3));
                    cardProductInfoItem.setDescription(cursor.getString(columnIndex4));
                    cardProductInfoItem.setType(cursor.getInt(columnIndex5));
                    cardProductInfoItem.setTimeStamp(cursor.getLong(columnIndex6));
                    cardProductInfoItem.setVersion(cursor.getString(columnIndex7));
                    cardProductInfoItem.setIssuerId(cursor.getString(columnIndex8));
                    cardProductInfoItem.setMktInfo(cursor.getString(columnIndex9));
                    cardProductInfoItem.setReservedInfo(cursor.getString(columnIndex10));
                    cardProductInfoItem.setFontColor(cursor.getString(columnIndex11));
                    cardProductInfoItem.setReserved1(cursor.getString(columnIndex12));
                    cardProductInfoItem.setReserved2(cursor.getString(columnIndex13));
                    cardProductInfoItem.setReserved3(cursor.getString(columnIndex14));
                    cardProductInfoItem.setReserved4(cursor.getString(columnIndex15));
                    cardProductInfoItem.setReserved5(cursor.getString(columnIndex16));
                    cardProductInfoItem.setReserved6(cursor.getString(columnIndex17));
                    cardProductInfoItem.parseMktInfoJson();
                    cardProductInfoItem.parseReservedJson();
                    arrayList.add(cardProductInfoItem);
                }
            } catch (Throwable e) {
                C2538c.e(TAG, new Object[]{"iteratorCardProductCursor sql exception. " + Log.getStackTraceString(e)});
            }
        }
        return arrayList;
    }
}
