package com.huawei.android.pushselfshow.richpush.p340b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.C4162d;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.C4210c;
import com.huawei.android.pushselfshow.utils.C4211e;
import com.huawei.android.pushselfshow.utils.p345a.C4200b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;

public class C4163a implements C4162d {
    C4210c f15633a = new C4210c(this);
    private Activity f15634b;
    private ImageView f15635c;
    private TextView f15636d;
    private TextView f15637e;
    private C4168f f15638f;
    private ListView f15639g;
    private LinearLayout f15640h;
    private C4165c f15641i;
    private ImageView f15642j;
    private ImageView f15643k;
    private TextView f15644l;
    private boolean f15645m = false;
    private byte[] f15646n = null;
    private byte[] f15647o = null;
    private AlertDialog f15648p = null;

    private ContentValues m20310a(Cursor cursor, String str) {
        ContentValues contentValues = new ContentValues();
        if (cursor == null || TextUtils.isEmpty(str)) {
            e.d("PushSelfShowLog", "getContentValues, cursor or table is null");
        } else if ("notify".equals(str)) {
            r1 = cursor.getString(cursor.getColumnIndex("url"));
            r2 = cursor.getBlob(cursor.getColumnIndex("bmp"));
            contentValues.put("url", r1);
            contentValues.put("bmp", r2);
        } else if ("pushmsg".equals(str)) {
            r1 = cursor.getString(cursor.getColumnIndex("url"));
            r2 = cursor.getBlob(cursor.getColumnIndex("msg"));
            contentValues.put("url", r1);
            try {
                contentValues.put(SNBConstant.FIELD_TOKEN, HwAccountConstants.BLANK.getBytes(GameManager.DEFAULT_CHARSET));
            } catch (Throwable e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
            contentValues.put("msg", r2);
        }
        return contentValues;
    }

    private void m20311a() {
        if (this.f15641i != null && this.f15639g != null && this.f15640h != null) {
            e.a("PushSelfShowLog", "count:" + this.f15641i.getCount());
            if (this.f15641i.getCount() == 0) {
                this.f15639g.setVisibility(8);
                this.f15640h.setVisibility(0);
                return;
            }
            this.f15639g.setVisibility(0);
            this.f15640h.setVisibility(8);
        }
    }

    private synchronized void m20312a(Context context) {
        try {
            e.a("PushSelfShowLog", "enter syncDb");
            String c = C4203a.m20433c(context, "push.db");
            File file = new File(c);
            if (file.exists()) {
                e.b("PushSelfShowLog", "sync db from sdcard");
                m20313a(context, c, "notify");
                m20313a(context, c, "pushmsg");
                if (!file.delete()) {
                    e.d("PushSelfShowLog", "delete sdcard db failed!");
                }
            } else {
                e.b("PushSelfShowLog", "sdcard db is not exist");
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private synchronized void m20313a(Context context, String str, String str2) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th;
        Cursor cursor2;
        SQLiteDatabase readableDatabase;
        e.b("PushSelfShowLog", "enter syncTable:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            e.d("PushSelfShowLog", "syncTable, dbPath or table is null");
        } else {
            SQLiteDatabase sQLiteDatabase3 = null;
            Cursor cursor3 = null;
            Cursor query;
            try {
                SQLiteDatabase writableDatabase = C4200b.m20398a(context).getWritableDatabase();
                int i = 1000;
                try {
                    Cursor query2;
                    query = writableDatabase.query(str2, null, null, null, null, null, null, null);
                    if (query != null) {
                        try {
                            i = 1000 - query.getCount();
                        } catch (Throwable e) {
                            cursor = null;
                            sQLiteDatabase = writableDatabase;
                            sQLiteDatabase2 = null;
                            th = e;
                            cursor2 = query;
                            try {
                                e.c("PushSelfShowLog", th.toString(), th);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Throwable th2) {
                                        e.c("PushSelfShowLog", th2.toString(), th2);
                                    }
                                }
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Throwable th22) {
                                        e.c("PushSelfShowLog", th22.toString(), th22);
                                    }
                                }
                                if (sQLiteDatabase2 != null) {
                                    try {
                                        sQLiteDatabase2.close();
                                    } catch (Throwable th222) {
                                        e.c("PushSelfShowLog", th222.toString(), th222);
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.close();
                                    } catch (Throwable th2222) {
                                        e.c("PushSelfShowLog", th2222.toString(), th2222);
                                    }
                                }
                            } catch (Throwable th3) {
                                th2222 = th3;
                                query = cursor2;
                                cursor3 = cursor;
                                sQLiteDatabase3 = sQLiteDatabase2;
                                if (cursor3 != null) {
                                    try {
                                        cursor3.close();
                                    } catch (Throwable e2) {
                                        e.c("PushSelfShowLog", e2.toString(), e2);
                                    }
                                }
                                if (query != null) {
                                    try {
                                        query.close();
                                    } catch (Throwable e22) {
                                        e.c("PushSelfShowLog", e22.toString(), e22);
                                    }
                                }
                                if (sQLiteDatabase3 != null) {
                                    try {
                                        sQLiteDatabase3.close();
                                    } catch (Throwable e222) {
                                        e.c("PushSelfShowLog", e222.toString(), e222);
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.close();
                                    } catch (Throwable e2222) {
                                        e.c("PushSelfShowLog", e2222.toString(), e2222);
                                    }
                                }
                                throw th2222;
                            }
                        } catch (Throwable e22222) {
                            sQLiteDatabase = writableDatabase;
                            th2222 = e22222;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (sQLiteDatabase3 != null) {
                                sQLiteDatabase3.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th2222;
                        }
                    }
                    e.a("PushSelfShowLog", "canInsertDataNum is:" + i);
                    if (i > 0) {
                        readableDatabase = C4200b.m20399a(context, str).getReadableDatabase();
                        try {
                            query2 = readableDatabase.query(true, str2, null, null, null, null, null, null, null);
                            if (query2 != null) {
                                while (query2.moveToNext() && query2.getPosition() < i) {
                                    try {
                                        writableDatabase.insert(str2, null, m20310a(query2, str2));
                                    } catch (Throwable e3) {
                                        sQLiteDatabase2 = readableDatabase;
                                        cursor2 = query;
                                        Cursor cursor4 = query2;
                                        sQLiteDatabase = writableDatabase;
                                        th2222 = e3;
                                        cursor = cursor4;
                                    } catch (Throwable e32) {
                                        cursor3 = query2;
                                        sQLiteDatabase3 = readableDatabase;
                                        sQLiteDatabase = writableDatabase;
                                        th2222 = e32;
                                    }
                                }
                            }
                        } catch (Throwable e322) {
                            sQLiteDatabase = writableDatabase;
                            sQLiteDatabase2 = readableDatabase;
                            th2222 = e322;
                            cursor2 = query;
                            cursor = null;
                            e.c("PushSelfShowLog", th2222.toString(), th2222);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable e3222) {
                            sQLiteDatabase = writableDatabase;
                            sQLiteDatabase3 = readableDatabase;
                            th2222 = e3222;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (sQLiteDatabase3 != null) {
                                sQLiteDatabase3.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th2222;
                        }
                    }
                    query2 = null;
                    readableDatabase = null;
                    if (query2 != null) {
                        try {
                            query2.close();
                        } catch (Throwable e32222) {
                            e.c("PushSelfShowLog", e32222.toString(), e32222);
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable e322222) {
                            e.c("PushSelfShowLog", e322222.toString(), e322222);
                        }
                    }
                    if (readableDatabase != null) {
                        try {
                            readableDatabase.close();
                        } catch (Throwable e222222) {
                            e.c("PushSelfShowLog", e222222.toString(), e222222);
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                        } catch (Throwable th22222) {
                            e.c("PushSelfShowLog", th22222.toString(), th22222);
                        }
                    }
                } catch (Throwable e2222222) {
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    sQLiteDatabase2 = null;
                    th22222 = e2222222;
                    cursor2 = null;
                    e.c("PushSelfShowLog", th22222.toString(), th22222);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable e22222222) {
                    query = null;
                    sQLiteDatabase = writableDatabase;
                    th22222 = e22222222;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th22222;
                }
            } catch (Exception e4) {
                th22222 = e4;
                cursor = null;
                sQLiteDatabase = null;
                sQLiteDatabase2 = null;
                cursor2 = null;
                e.c("PushSelfShowLog", th22222.toString(), th22222);
                if (cursor != null) {
                    cursor.close();
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th4) {
                th22222 = th4;
                query = null;
                sQLiteDatabase = null;
                if (cursor3 != null) {
                    cursor3.close();
                }
                if (query != null) {
                    query.close();
                }
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th22222;
            }
        }
    }

    private void m20314a(Context context, boolean z) {
        if (z) {
            this.f15644l.setText(C4211e.m20460a(context, "hwpush_unselectall"));
            this.f15644l.setTextColor(context.getResources().getColor(C4211e.m20464d(context, "hwpush_select_color")));
            Drawable drawable = context.getResources().getDrawable(C4211e.m20465e(context, "hwpush_ic_toolbar_multiple1"));
            try {
                int identifier = context.getResources().getIdentifier("colorful_emui", "color", "androidhwext");
                if (identifier != 0) {
                    identifier = context.getResources().getColor(identifier);
                    if (identifier != 0) {
                        drawable.setTint(identifier);
                        this.f15644l.setTextColor(identifier);
                    }
                }
            } catch (NotFoundException e) {
                e.d("PushSelfShowLog", e.toString());
            } catch (Exception e2) {
                e.d("PushSelfShowLog", e2.toString());
            }
            this.f15643k.setBackgroundDrawable(drawable);
            return;
        }
        this.f15643k.setBackgroundDrawable(context.getResources().getDrawable(C4211e.m20465e(context, "hwpush_ic_toolbar_multiple")));
        this.f15644l.setText(C4211e.m20460a(context, "hwpush_selectall"));
        this.f15644l.setTextColor(context.getResources().getColor(C4211e.m20464d(context, "hwpush_text_color_history_url")));
    }

    private void m20319b() {
        this.f15635c.setVisibility(0);
        this.f15636d.setText(C4211e.m20460a(this.f15634b, "hwpush_deltitle"));
        this.f15638f.m20333a();
        this.f15639g.setOnItemClickListener(new C4164b(this, this.f15634b));
        this.f15641i.m20329a(false);
        this.f15639g.setLongClickable(false);
        if (1 == this.f15641i.m20327a().size()) {
            m20314a(this.f15634b, true);
        } else {
            m20314a(this.f15634b, false);
        }
    }

    private void m20321c() {
        Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
        intent.putExtra("type", "html");
        intent.putExtra("selfshow_info", this.f15646n);
        intent.putExtra("selfshow_token", this.f15647o);
        intent.setFlags(268468240);
        intent.setPackage(this.f15634b.getPackageName());
        this.f15634b.finish();
        this.f15634b.startActivity(intent);
    }

    public void mo4386a(Message message) {
        try {
            switch (message.what) {
                case 1000:
                    e.a("PushSelfShowLog", "mHandler MSG_LOAD_DONE");
                    this.f15639g.setAdapter(this.f15641i);
                    m20311a();
                    if (this.f15645m) {
                        m20319b();
                        return;
                    }
                    return;
                case 1001:
                    e.a("PushSelfShowLog", "mHandler MSG_DELETE_DONE");
                    if (this.f15645m) {
                        m20321c();
                        return;
                    }
                    this.f15639g.setAdapter(this.f15641i);
                    this.f15635c.performClick();
                    m20311a();
                    return;
                default:
                    return;
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "handleMessage error:" + message.what + "," + e.toString(), e);
        }
        e.c("PushSelfShowLog", "handleMessage error:" + message.what + "," + e.toString(), e);
    }
}
