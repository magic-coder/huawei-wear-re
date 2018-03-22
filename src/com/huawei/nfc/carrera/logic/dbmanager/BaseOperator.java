package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.util.Log;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

class BaseOperator {
    protected static final String TAG = "CardInfoDBManager";
    protected ContentResolver mContentResolver;

    BaseOperator(ContentResolver contentResolver) {
        this.mContentResolver = contentResolver;
    }

    protected boolean isRecordInfoExist(Uri uri, String str, String str2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            boolean z;
            String[] strArr = new String[]{str};
            Cursor query = this.mContentResolver.query(uri, strArr, str + "=?", new String[]{str2}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = true;
                        if (query != null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (SQLException e) {
                    cursor = query;
                    try {
                        LogX.e(TAG, "queryCardListInfo sql exception.");
                        if (cursor != null) {
                            return false;
                        }
                        cursor.close();
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            z = false;
            if (query != null) {
                return z;
            }
            query.close();
            return z;
        } catch (SQLException e2) {
            cursor = null;
            LogX.e(TAG, "queryCardListInfo sql exception.");
            if (cursor != null) {
                return false;
            }
            cursor.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    protected void insertRecordInfo(Uri uri, ContentValues contentValues) {
        if (uri != null && contentValues != null) {
            try {
                this.mContentResolver.insert(uri, contentValues);
            } catch (Throwable e) {
                LogX.e("insertRecordInfo : ", Log.getStackTraceString(e));
            }
        }
    }

    protected void updateRecordInfo(Uri uri, String str, String str2, ContentValues contentValues) {
        if (uri != null && !StringUtil.isEmpty(str, true) && !StringUtil.isEmpty(str2, true) && contentValues != null) {
            try {
                this.mContentResolver.update(uri, contentValues, str + "=?", new String[]{str2});
            } catch (Throwable e) {
                LogX.e(TAG, "updateRecordInfo sql exception: " + Log.getStackTraceString(e));
            }
        }
    }

    protected void deleteRecordInfo(Uri uri, String str, String str2) {
        if (uri != null && !StringUtil.isEmpty(str, true) && !StringUtil.isEmpty(str2, true)) {
            try {
                this.mContentResolver.delete(uri, str + "=?", new String[]{str2});
            } catch (Throwable e) {
                LogX.e(TAG, "deleteRecordInfo sql exception: " + Log.getStackTraceString(e));
            }
        }
    }
}
