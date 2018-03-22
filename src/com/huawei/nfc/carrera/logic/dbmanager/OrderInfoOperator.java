package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.huawei.nfc.carrera.storage.db.DataModel.CardOrderColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrderInfoOperator extends BaseOperator {
    OrderInfoOperator(ContentResolver contentResolver) {
        super(contentResolver);
    }

    public void insertOrUpdateCardOrderInfos(List<CardOrderInfoItem> list) {
        if (list == null || list.isEmpty()) {
            LogX.d("insertOrUpdateCardOrderInfos, info is empty.");
            return;
        }
        for (CardOrderInfoItem cardOrderInfoItem : list) {
            if (StringUtil.isEmpty(cardOrderInfoItem.getReference_id(), true)) {
                LogX.e("insertOrUpdateCardOrderInfos, ignore this card info.");
            } else if (isRecordInfoExist(CardOrderColumns.CONTENT_URI, CardOrderColumns.COLUMN_NAME_REFENCE_ID, cardOrderInfoItem.getReference_id())) {
                updateRecordInfo(CardOrderColumns.CONTENT_URI, CardOrderColumns.COLUMN_NAME_REFENCE_ID, cardOrderInfoItem.getReference_id(), cardOrderInfoItem.toContentValues());
            } else {
                insertRecordInfo(CardOrderColumns.CONTENT_URI, cardOrderInfoItem.toContentValues());
            }
        }
    }

    public void deleteAllCardOrderInfos() {
        C2538c.c("CardInfoDBManager", new Object[]{"deleteAllCardOrderInfos"});
        List<CardOrderInfoItem> queryCardOrderInfo = queryCardOrderInfo();
        if (queryCardOrderInfo == null || queryCardOrderInfo.isEmpty()) {
            LogX.d("deleteCardOrderInfos, info is empty.");
            return;
        }
        for (CardOrderInfoItem cardOrderInfoItem : queryCardOrderInfo) {
            if (StringUtil.isEmpty(cardOrderInfoItem.getReference_id(), true)) {
                LogX.e("deleteCardOrderInfos, ignore this card info.");
            } else {
                deleteRecordInfo(CardOrderColumns.CONTENT_URI, CardOrderColumns.COLUMN_NAME_REFENCE_ID, cardOrderInfoItem.getReference_id());
            }
        }
    }

    public void deleteCardOrderItem(String str) {
        if (isRecordInfoExist(CardOrderColumns.CONTENT_URI, CardOrderColumns.COLUMN_NAME_REFENCE_ID, str)) {
            deleteRecordInfo(CardOrderColumns.CONTENT_URI, CardOrderColumns.COLUMN_NAME_REFENCE_ID, str);
        }
    }

    public ArrayList<CardOrderInfoItem> queryCardOrderInfo() {
        Throwable e;
        ArrayList<CardOrderInfoItem> arrayList = null;
        Cursor query;
        try {
            query = this.mContentResolver.query(CardOrderColumns.CONTENT_URI, null, null, null, null);
            try {
                arrayList = iteratorCardOrderinfoCursor(query);
                if (query != null) {
                    query.close();
                }
            } catch (SQLException e2) {
                e = e2;
                try {
                    LogX.e("CardInfoDBManager", "queryCardOrderInfo sql exception. " + Log.getStackTraceString(e));
                    if (query != null) {
                        query.close();
                    }
                    if (arrayList != null) {
                        C2538c.c("CardInfoDBManager", new Object[]{"queryCardOrderInfo  items=" + arrayList.size()});
                    }
                    return arrayList;
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
            query = arrayList;
            LogX.e("CardInfoDBManager", "queryCardOrderInfo sql exception. " + Log.getStackTraceString(e));
            if (query != null) {
                query.close();
            }
            if (arrayList != null) {
                C2538c.c("CardInfoDBManager", new Object[]{"queryCardOrderInfo  items=" + arrayList.size()});
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            query = arrayList;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        if (arrayList != null) {
            C2538c.c("CardInfoDBManager", new Object[]{"queryCardOrderInfo  items=" + arrayList.size()});
        }
        return arrayList;
    }

    public CardOrderInfoItem queryCardOrderInfoById(String str) {
        Cursor query;
        List iteratorCardOrderinfoCursor;
        Throwable e;
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        try {
            query = this.mContentResolver.query(CardOrderColumns.CONTENT_URI, null, "reference_id = ?", new String[]{str}, null);
            try {
                iteratorCardOrderinfoCursor = iteratorCardOrderinfoCursor(query);
                if (query != null) {
                    query.close();
                }
            } catch (SQLException e2) {
                e = e2;
                try {
                    LogX.e("CardInfoDBManager", "queryCardOrderInfoById sql exception. " + Log.getStackTraceString(e));
                    if (query == null) {
                        iteratorCardOrderinfoCursor = null;
                    } else {
                        query.close();
                        iteratorCardOrderinfoCursor = null;
                    }
                    if (iteratorCardOrderinfoCursor != null) {
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
            LogX.e("CardInfoDBManager", "queryCardOrderInfoById sql exception. " + Log.getStackTraceString(e));
            if (query == null) {
                query.close();
                iteratorCardOrderinfoCursor = null;
            } else {
                iteratorCardOrderinfoCursor = null;
            }
            if (iteratorCardOrderinfoCursor != null) {
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
        if (iteratorCardOrderinfoCursor != null || iteratorCardOrderinfoCursor.size() <= 0) {
            return null;
        }
        return (CardOrderInfoItem) iteratorCardOrderinfoCursor.get(0);
    }

    private ArrayList<CardOrderInfoItem> iteratorCardOrderinfoCursor(Cursor cursor) {
        ArrayList<CardOrderInfoItem> arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0) {
            LogX.d("CardInfoDBManager", "iteratorCardOrderinfoCursor the cursor is empty");
        } else {
            int columnIndex = cursor.getColumnIndex(CardOrderColumns.COLUMN_NAME_REFENCE_ID);
            int columnIndex2 = cursor.getColumnIndex("timestamp");
            while (cursor.moveToNext()) {
                CardOrderInfoItem cardOrderInfoItem = new CardOrderInfoItem();
                cardOrderInfoItem.setReference_id(cursor.getString(columnIndex));
                cardOrderInfoItem.setTimestamp(cursor.getLong(columnIndex2));
                arrayList.add(cardOrderInfoItem);
            }
        }
        return arrayList;
    }

    public void updateDefalutCardOrderInfo(String str) {
        int i = 0;
        C2538c.c("CardInfoDBManager", new Object[]{"updateDefalutCardOrderInfo  reference_id=" + str});
        ArrayList queryCardOrderInfo = queryCardOrderInfo();
        if (queryCardOrderInfo != null && !queryCardOrderInfo.isEmpty()) {
            Collections.sort(queryCardOrderInfo, new CardOrderItemComparator());
            int size = queryCardOrderInfo.size();
            if (!((CardOrderInfoItem) queryCardOrderInfo.get(size - 1)).getReference_id().equals(str)) {
                List arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < size) {
                    int i3;
                    if (i != 0) {
                        arrayList.add(new CardOrderInfoItem(((CardOrderInfoItem) queryCardOrderInfo.get(i2)).getReference_id(), ((CardOrderInfoItem) queryCardOrderInfo.get(i2 - 1)).getTimestamp()));
                    }
                    if (((CardOrderInfoItem) queryCardOrderInfo.get(i2)).getReference_id().equals(str)) {
                        arrayList.add(new CardOrderInfoItem(((CardOrderInfoItem) queryCardOrderInfo.get(i2)).getReference_id(), ((CardOrderInfoItem) queryCardOrderInfo.get(size - 1)).getTimestamp()));
                        i3 = 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                insertOrUpdateCardOrderInfos(arrayList);
            }
        }
    }
}
