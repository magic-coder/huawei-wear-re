package com.huawei.nfc.carrera.storage.db;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.huawei.nfc.carrera.storage.db.DataModel.CardOrderColumns;
import com.huawei.nfc.carrera.storage.db.DataModel.CardProductInfoColumns;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;

public class NFCContentProvider extends ContentProvider {
    private static final int MAX_TABLES_COUNT = 10;
    private static final String[] TABLE_NAMES = new String[]{CardProductInfoColumns.TABLE_NAME, IssuerInfoColumns.TABLE_NAME, ReportCardInfo.TABLE_NAME, CardOrderColumns.TABLE_NAME, RFConfInfoColumns.TABLE_NAME};
    private static final int URI_MATCH_TABLE_CARDORDERINFO = 3;
    private static final int URI_MATCH_TABLE_CARDORDERINFO_ID = 13;
    private static final int URI_MATCH_TABLE_CARDPRODUCTINFO = 0;
    private static final int URI_MATCH_TABLE_CARDPRODUCTINFO_ID = 10;
    private static final int URI_MATCH_TABLE_ISSUERINFO = 1;
    private static final int URI_MATCH_TABLE_ISSUERINFO_ID = 11;
    private static final int URI_MATCH_TABLE_REPORTCARDINFO = 2;
    private static final int URI_MATCH_TABLE_REPORTCARDINFO_ID = 12;
    private static final int URI_MATCH_TABLE_RFCONFINFO = 4;
    private static final int URI_MATCH_TABLE_RFCONFINFO_ID = 14;
    private static final UriMatcher mUriMatcher = new UriMatcher(-1);
    private SQLiteOpenHelper mDBHelper;

    static {
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[0], 0);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[0] + "/#", 10);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[1], 1);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[1] + "/#", 11);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[2], 2);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[2] + "/#", 12);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[3], 3);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[3] + "/#", 13);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[4], 4);
        mUriMatcher.addURI("com.huawei.bone", TABLE_NAMES[4] + "/#", 14);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        IllegalArgumentException illegalArgumentException;
        int match = mUriMatcher.match(uri);
        if (-1 == match) {
            illegalArgumentException = new IllegalArgumentException("Unknown URL");
        } else {
            illegalArgumentException = null;
        }
        if (illegalArgumentException != null) {
            throw illegalArgumentException;
        }
        SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        ContentResolver contentResolver = getContext().getContentResolver();
        int delete = writableDatabase.delete(TABLE_NAMES[match % 10], str, strArr);
        contentResolver.notifyChange(uri, null);
        return delete;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        IllegalArgumentException illegalArgumentException;
        SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        int match = mUriMatcher.match(uri);
        if (-1 == match) {
            illegalArgumentException = new IllegalArgumentException("Unknown URL");
        } else {
            illegalArgumentException = null;
        }
        if (illegalArgumentException != null) {
            throw illegalArgumentException;
        }
        Uri withAppendedId;
        long insert = writableDatabase.insert(TABLE_NAMES[match % 10], null, contentValues);
        if (insert > 0) {
            withAppendedId = ContentUris.withAppendedId(uri, insert);
        } else {
            withAppendedId = null;
        }
        if (withAppendedId != null) {
            getContext().getContentResolver().notifyChange(withAppendedId, null);
        }
        return withAppendedId;
    }

    public boolean onCreate() {
        this.mDBHelper = new NFCDBHelper(getContext());
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        IllegalArgumentException illegalArgumentException;
        int match = mUriMatcher.match(uri);
        if (-1 == match) {
            illegalArgumentException = new IllegalArgumentException("Unknown URL");
        } else {
            illegalArgumentException = null;
        }
        if (illegalArgumentException != null) {
            throw illegalArgumentException;
        }
        String str3 = TABLE_NAMES[match % 10];
        SQLiteDatabase readableDatabase = this.mDBHelper.getReadableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        if (match >= 10) {
            String str4 = (String) uri.getPathSegments().get(1);
            stringBuilder.append("_id = ");
            stringBuilder.append(str4);
        }
        if (str != null && str.length() > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append('(');
            stringBuilder.append(str);
            stringBuilder.append(')');
        }
        Cursor query = readableDatabase.query(str3, strArr, stringBuilder.toString(), strArr2, null, null, str2, null);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        IllegalArgumentException illegalArgumentException;
        SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        int match = mUriMatcher.match(uri);
        if (-1 == match) {
            illegalArgumentException = new IllegalArgumentException("Unknown URL");
        } else {
            illegalArgumentException = null;
        }
        if (illegalArgumentException != null) {
            throw illegalArgumentException;
        }
        if (match >= 10) {
            StringBuilder stringBuilder = new StringBuilder();
            if (str != null && str.length() > 0) {
                stringBuilder.append("( ");
                stringBuilder.append(str);
                stringBuilder.append(" ) AND ");
            }
            String str2 = (String) uri.getPathSegments().get(1);
            stringBuilder.append("_id = ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
        }
        int update = writableDatabase.update(TABLE_NAMES[match % 10], contentValues, str, strArr);
        if (update > 0) {
            LogX.m5465d("cr.notifyChange");
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
            }
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArr;
        } finally {
            writableDatabase.endTransaction();
        }
    }
}
