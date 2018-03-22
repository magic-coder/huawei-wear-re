package com.huawei.crowdtestsdk.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;

public class FeedBackContentProvider extends ContentProvider {
    public static final int ALIAS = 9;
    public static final int ALIAS_ID = 10;
    public static final int DOWNLOAD = 15;
    public static final int DOWNLOAD_ID = 16;
    public static final int ISSUES = 7;
    public static final int ISSUES_ID = 8;
    public static final int LOGS = 1;
    public static final int LOG_ID = 2;
    public static final int LOOKUPS = 5;
    public static final int LOOKUPS_ID = 6;
    public static final int PROJECTS = 3;
    public static final int PROJECTS_ID = 4;
    public static final int RECORDS = 13;
    public static final int RECORDS_ID = 14;
    public static final int RESUMES = 11;
    public static final int RESUMES_ID = 12;
    public static final Object lock = new Object();
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);
    private FeedBackDatabean mFeedBackDBHelper;

    static {
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "logs", 1);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "logs/#", 2);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "projects", 3);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "projects/#", 4);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "lookup", 5);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "lookup/#", 6);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "issues", 7);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "issues/#", 6);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "alias", 9);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "alias/#", 10);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "resumes", 11);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "resumes/#", 12);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "records", 13);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "records/#", 14);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "upgrades", 15);
        sUriMatcher.addURI("com.huawei.crowdtestsdk", "upgrades/#", 16);
    }

    public boolean onCreate() {
        this.mFeedBackDBHelper = new FeedBackDatabean(getContext());
        return false;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mFeedBackDBHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        if (match == 1 || match == 2) {
            return deleteHistory(uri, str, strArr, writableDatabase);
        }
        if (match == 7 || match == 8) {
            return deleteIssue(uri, str, strArr, writableDatabase);
        }
        if (match == 3 || match == 4) {
            return deleteProject(uri, str, strArr, writableDatabase);
        }
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mFeedBackDBHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        if (match == 1 || match == 2) {
            return updateHistory(uri, contentValues, str, strArr, writableDatabase);
        }
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.mFeedBackDBHelper.getWritableDatabase();
        if (sUriMatcher.match(uri) == 1) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedBackContentProvider.insert]sUriMatcher.match(uri) == LOGS");
            return insertHistory(uri, contentValues, writableDatabase);
        } else if (sUriMatcher.match(uri) == 3) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedBackContentProvider.insert]sUriMatcher.match(uri) == PROJECTS");
            return insertProject(uri, contentValues, writableDatabase);
        } else if (sUriMatcher.match(uri) != 7) {
            return null;
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[FeedBackContentProvider.insert]sUriMatcher.match(uri) == ISSUES");
            return insertIssue(uri, contentValues, writableDatabase);
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int match = sUriMatcher.match(uri);
        if (match == 1 || match == 2) {
            return queryHistory(uri, strArr, str, strArr2, str2, sQLiteQueryBuilder);
        }
        if (match == 3 || match == 4) {
            return queryProject(uri, strArr, str, strArr2, str2, sQLiteQueryBuilder);
        }
        if (match == 7 || match == 8) {
            return queryIssue(uri, strArr, str, strArr2, str2, sQLiteQueryBuilder);
        }
        return null;
    }

    public int updateHistory(Uri uri, ContentValues contentValues, String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        int update;
        synchronized (FeedbackHistoryConstants.lock) {
            switch (sUriMatcher.match(uri)) {
                case 1:
                    update = sQLiteDatabase.update(FeedbackHistoryConstants.TABLE_NAME, contentValues, str, strArr);
                    break;
                case 2:
                    String str2 = "_id = " + ((String) uri.getPathSegments().get(1));
                    if (str != null) {
                        str2 = str2 + " AND " + str;
                    }
                    update = sQLiteDatabase.update(FeedbackHistoryConstants.TABLE_NAME, contentValues, str2, strArr);
                    break;
                default:
                    update = 0;
            }
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;
    }

    private Uri insertHistory(Uri uri, ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        Uri uri2 = null;
        synchronized (FeedbackHistoryConstants.lock) {
            ContentValues contentValues2;
            if (contentValues != null) {
                contentValues2 = new ContentValues(contentValues);
            } else {
                contentValues2 = new ContentValues();
            }
            if (!contentValues2.containsKey("date")) {
                contentValues2.put("date", Long.valueOf(System.currentTimeMillis()));
            }
            if (!contentValues2.containsKey("type")) {
                contentValues2.put("type", Integer.valueOf(ResUtil.getResId(getContext(), "sdk_crowdtest_other_log", ResUtil.TYPE_STRING)));
            }
            if (!contentValues2.containsKey("description")) {
                contentValues2.put("description", getContext().getResources().getString(ResUtil.getResId(getContext(), "sdk_crowdtest_describle_hint", ResUtil.TYPE_STRING)));
            }
            if (!contentValues2.containsKey("state")) {
                contentValues2.put("state", getContext().getString(ResUtil.getResId(getContext(), "sdk_crowdtest_feedback_draft", ResUtil.TYPE_STRING)));
            }
            long insert = sQLiteDatabase.insert(FeedbackHistoryConstants.TABLE_NAME, null, contentValues2);
            if (insert > 0) {
                uri2 = ContentUris.withAppendedId(FeedbackHistoryConstants.CONTENT_ID_URI_BASE, insert);
                getContext().getContentResolver().notifyChange(uri2, null);
            }
        }
        return uri2;
    }

    private Uri insertProject(Uri uri, ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        Uri uri2 = null;
        C2511g.m12481b("BETACLUB_SDK", "[FeedBackContentProvider.insertProject] is called! ");
        synchronized (FeedbackProjectConstants.lock) {
            ContentValues contentValues2;
            if (contentValues != null) {
                contentValues2 = new ContentValues(contentValues);
            } else {
                contentValues2 = new ContentValues();
            }
            if (!contentValues2.containsKey("date")) {
                contentValues2.put("date", Long.valueOf(System.currentTimeMillis()));
            }
            if (!contentValues2.containsKey("project_id")) {
            } else if (contentValues2.containsKey(FeedbackProjectConstants.COLUMN_NAME_PROJECT_NAME)) {
                if (!contentValues2.containsKey(FeedbackProjectConstants.COLUMN_NAME_PROJECT_COUNT)) {
                    contentValues2.put(FeedbackProjectConstants.COLUMN_NAME_PROJECT_COUNT, Integer.valueOf(0));
                }
                long insert = sQLiteDatabase.insert(FeedbackProjectConstants.TABLE_NAME, null, contentValues2);
                if (insert > 0) {
                    uri2 = ContentUris.withAppendedId(FeedbackProjectConstants.CONTENT_ID_URI_BASE, insert);
                    getContext().getContentResolver().notifyChange(uri2, null);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedBackContentProvider.insertProject]noteUri: " + uri2.toString());
                }
            }
        }
        return uri2;
    }

    private Uri insertIssue(Uri uri, ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        Uri uri2 = null;
        synchronized (FeedbackIssueConstants.lock) {
            ContentValues contentValues2;
            if (contentValues != null) {
                contentValues2 = new ContentValues(contentValues);
            } else {
                contentValues2 = new ContentValues();
            }
            if (!contentValues2.containsKey("project_id")) {
            } else if (!contentValues2.containsKey(FeedbackIssueConstants.COLUMN_NAME_ISSUE_ID)) {
            } else if (contentValues2.containsKey(FeedbackIssueConstants.COLUMN_NAME_ISSUE_DESC)) {
                long insert = sQLiteDatabase.insert(FeedbackIssueConstants.TABLE_NAME, null, contentValues2);
                if (insert > 0) {
                    uri2 = ContentUris.withAppendedId(FeedbackIssueConstants.CONTENT_ID_URI_BASE, insert);
                    getContext().getContentResolver().notifyChange(uri2, null);
                }
            }
        }
        return uri2;
    }

    private Cursor queryIssue(Uri uri, String[] strArr, String str, String[] strArr2, String str2, SQLiteQueryBuilder sQLiteQueryBuilder) {
        Cursor cursor = null;
        synchronized (FeedbackIssueConstants.lock) {
            String str3;
            sQLiteQueryBuilder.setTables(FeedbackIssueConstants.TABLE_NAME);
            switch (sUriMatcher.match(uri)) {
                case 7:
                    break;
                case 8:
                    sQLiteQueryBuilder.appendWhere("_id=" + ((String) uri.getPathSegments().get(1)));
                    break;
                default:
            }
            if (StringUtils.isNullOrEmpty(str2)) {
                str3 = "_id ASC";
            } else {
                str3 = str2;
            }
            cursor = sQLiteQueryBuilder.query(this.mFeedBackDBHelper.getReadableDatabase(), strArr, str, strArr2, null, null, str3);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    private int deleteHistory(Uri uri, String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        int delete;
        synchronized (FeedbackHistoryConstants.lock) {
            switch (sUriMatcher.match(uri)) {
                case 1:
                    delete = sQLiteDatabase.delete(FeedbackHistoryConstants.TABLE_NAME, str, strArr);
                    break;
                case 2:
                    String str2 = "_id = " + ((String) uri.getPathSegments().get(1));
                    if (str != null) {
                        str2 = str2 + " AND " + str;
                    }
                    delete = sQLiteDatabase.delete(FeedbackHistoryConstants.TABLE_NAME, str2, strArr);
                    break;
                default:
                    delete = 0;
            }
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return delete;
    }

    private int deleteIssue(Uri uri, String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        int delete;
        synchronized (FeedbackIssueConstants.lock) {
            switch (sUriMatcher.match(uri)) {
                case 7:
                    delete = sQLiteDatabase.delete(FeedbackIssueConstants.TABLE_NAME, str, strArr);
                    break;
                case 8:
                    String str2 = "_id = " + ((String) uri.getPathSegments().get(1));
                    if (str != null) {
                        str2 = str2 + " AND " + str;
                    }
                    delete = sQLiteDatabase.delete(FeedbackIssueConstants.TABLE_NAME, str2, strArr);
                    break;
                default:
                    delete = 0;
            }
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return delete;
    }

    private int deleteProject(Uri uri, String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        int delete;
        synchronized (FeedbackProjectConstants.lock) {
            switch (sUriMatcher.match(uri)) {
                case 3:
                    delete = sQLiteDatabase.delete(FeedbackProjectConstants.TABLE_NAME, str, strArr);
                    break;
                case 4:
                    String str2 = "_id = " + ((String) uri.getPathSegments().get(1));
                    if (str != null) {
                        str2 = str2 + " AND " + str;
                    }
                    delete = sQLiteDatabase.delete(FeedbackProjectConstants.TABLE_NAME, str2, strArr);
                    break;
                default:
                    delete = 0;
            }
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return delete;
    }

    private Cursor queryHistory(Uri uri, String[] strArr, String str, String[] strArr2, String str2, SQLiteQueryBuilder sQLiteQueryBuilder) {
        Cursor cursor = null;
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackContentProvider.queryHistory] start!");
        synchronized (FeedbackHistoryConstants.lock) {
            String str3;
            sQLiteQueryBuilder.setTables(FeedbackHistoryConstants.TABLE_NAME);
            switch (sUriMatcher.match(uri)) {
                case 1:
                    break;
                case 2:
                    sQLiteQueryBuilder.appendWhere("_id=" + ((String) uri.getPathSegments().get(1)));
                    break;
                default:
            }
            if (StringUtils.isNullOrEmpty(str2)) {
                str3 = FeedbackHistoryConstants.DEFAULT_SORT_ORDER;
            } else {
                str3 = str2;
            }
            cursor = sQLiteQueryBuilder.query(this.mFeedBackDBHelper.getReadableDatabase(), strArr, str, strArr2, null, null, str3);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackContentProvider.queryHistory] end!");
        }
        return cursor;
    }

    private Cursor queryProject(Uri uri, String[] strArr, String str, String[] strArr2, String str2, SQLiteQueryBuilder sQLiteQueryBuilder) {
        Cursor cursor = null;
        synchronized (FeedbackProjectConstants.lock) {
            String str3;
            sQLiteQueryBuilder.setTables(FeedbackProjectConstants.TABLE_NAME);
            switch (sUriMatcher.match(uri)) {
                case 3:
                    break;
                case 4:
                    sQLiteQueryBuilder.appendWhere("_id=" + ((String) uri.getPathSegments().get(1)));
                    break;
                default:
            }
            if (StringUtils.isNullOrEmpty(str2)) {
                str3 = "_id ASC";
            } else {
                str3 = str2;
            }
            cursor = sQLiteQueryBuilder.query(this.mFeedBackDBHelper.getReadableDatabase(), strArr, str, strArr2, null, null, str3);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }
}
