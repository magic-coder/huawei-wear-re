package com.huawei.nfc.carrera.logic.lostmanager.report.dbmanager;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class ReportStatusDBManager {
    private static final String TAG = "ReportCardDBManager";
    private final ContentResolver mContentResolver = this.mContext.getContentResolver();
    private final Context mContext;

    public ReportStatusDBManager(Context context) {
        this.mContext = context;
    }

    public void insertOrUpdateOneCardReportInfo(ReportStatusItem reportStatusItem) {
        if (reportStatusItem == null || StringUtil.isEmpty(reportStatusItem.getAid(), true) || StringUtil.isEmpty(reportStatusItem.getCardStatus(), true)) {
            LogX.e("insertOrUpdateOneCardReportInfo, params illegal.");
            return;
        }
        LogX.i("insertOrUpdateOneCardReportInfo, card aid: " + reportStatusItem.getAid());
        ContentValues contentValues = new ContentValues();
        contentValues.put("aid", reportStatusItem.getAid());
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, reportStatusItem.getUserId());
        contentValues.put("status", reportStatusItem.getCardStatus());
        contentValues.put(ReportCardInfo.COLUMN_NAME_DPANID, reportStatusItem.getDpanId());
        contentValues.put("card_name", reportStatusItem.getCardName());
        contentValues.put("card_number", reportStatusItem.getCardNumber());
        contentValues.put(ReportCardInfo.COLUMN_NAME_ISSUSERID, reportStatusItem.getIssuerID());
        contentValues.put("card_type", Integer.valueOf(reportStatusItem.getCardType()));
        if (isCardStatusInfoExist(reportStatusItem.getAid())) {
            LogX.d("insertOrUpdateOneCardReportInfo, card info existed, update now.");
            this.mContentResolver.update(ReportCardInfo.CONTENT_URI, contentValues, "aid=?", new String[]{reportStatusItem.getAid()});
            return;
        }
        LogX.d("insertOrUpdateOneCardReportInfo, card info not existed, insert now.");
        this.mContentResolver.insert(ReportCardInfo.CONTENT_URI, contentValues);
    }

    private boolean isCardStatusInfoExist(String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            boolean z;
            Cursor query = this.mContentResolver.query(ReportCardInfo.CONTENT_URI, new String[]{"aid"}, "aid=?", new String[]{str}, null);
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
                        LogX.e(TAG, "isCardStatusInfoExist sql exception.");
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
            LogX.e(TAG, "isCardStatusInfoExist sql exception.");
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

    public List<ReportStatusItem> queryReportStatusList() {
        Cursor query;
        List<ReportStatusItem> arrayList;
        Throwable th;
        LogX.i("queryReportStatusList begin.");
        try {
            query = this.mContentResolver.query(ReportCardInfo.CONTENT_URI, new String[]{"aid", ReportCardInfo.COLUMN_NAME_CARD_USERID, "status", ReportCardInfo.COLUMN_NAME_DPANID, "card_name", "card_number", ReportCardInfo.COLUMN_NAME_ISSUSERID, "card_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToFirst()) {
                        arrayList = new ArrayList();
                        try {
                            int columnIndex = query.getColumnIndex("aid");
                            int columnIndex2 = query.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID);
                            int columnIndex3 = query.getColumnIndex("status");
                            int columnIndex4 = query.getColumnIndex(ReportCardInfo.COLUMN_NAME_DPANID);
                            int columnIndex5 = query.getColumnIndex("card_name");
                            int columnIndex6 = query.getColumnIndex("card_number");
                            int columnIndex7 = query.getColumnIndex(ReportCardInfo.COLUMN_NAME_ISSUSERID);
                            int columnIndex8 = query.getColumnIndex("card_type");
                            do {
                                ReportStatusItem reportStatusItem = new ReportStatusItem();
                                reportStatusItem.setAid(query.getString(columnIndex));
                                reportStatusItem.setCardStatus(query.getString(columnIndex3));
                                if (!query.isNull(columnIndex2)) {
                                    reportStatusItem.setUserId(query.getString(columnIndex2));
                                }
                                if (!query.isNull(columnIndex4)) {
                                    reportStatusItem.setDpanId(query.getString(columnIndex4));
                                }
                                if (!query.isNull(columnIndex5)) {
                                    reportStatusItem.setCardName(query.getString(columnIndex5));
                                }
                                if (!query.isNull(columnIndex6)) {
                                    reportStatusItem.setCardNumber(query.getString(columnIndex6));
                                }
                                if (!query.isNull(columnIndex7)) {
                                    reportStatusItem.setIssuerID(query.getString(columnIndex7));
                                }
                                if (!query.isNull(columnIndex8)) {
                                    reportStatusItem.setCardType(query.getInt(columnIndex8));
                                }
                                arrayList.add(reportStatusItem);
                            } while (query.moveToNext());
                            if (query != null) {
                                query.close();
                            }
                        } catch (SQLException e) {
                            try {
                                LogX.e(TAG, "queryReportStatusList sql exception.");
                                if (query != null) {
                                    query.close();
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        return arrayList;
                    }
                } catch (SQLException e2) {
                    arrayList = null;
                    LogX.e(TAG, "queryReportStatusList sql exception.");
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
            }
            arrayList = null;
            if (query != null) {
                query.close();
            }
        } catch (SQLException e3) {
            query = null;
            arrayList = null;
            LogX.e(TAG, "queryReportStatusList sql exception.");
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void removeOneReportStatusInfo(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("removeOneReportStatusInfo, aid is illegal.");
            return;
        }
        this.mContentResolver.delete(ReportCardInfo.CONTENT_URI, "aid=?", new String[]{str});
    }
}
