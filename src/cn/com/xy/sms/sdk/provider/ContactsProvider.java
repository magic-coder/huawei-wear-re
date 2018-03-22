package cn.com.xy.sms.sdk.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import cn.com.xy.sms.sdk.p208d.C2963f;
import cn.com.xy.sms.sdk.p216h.C2996a;
import java.util.Map;

public class ContactsProvider extends ContentProvider {
    private static final UriMatcher f10319a;
    private C2963f f10320b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f10319a = uriMatcher;
        uriMatcher.addURI("cn.com.xy.sms.sdk.provider.contacts", "contacts", 1);
    }

    public static void m13743a(Context context, Map<String, Object> map) {
        C2996a.m13484a(new C3064a(map, context));
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (f10319a.match(uri) == 1) {
            return this.f10320b.getReadableDatabase().delete("contacts", str, strArr);
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (f10319a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        contentValues.put("update_time", String.valueOf(System.currentTimeMillis()));
        String[] strArr = new String[]{contentValues.getAsString("phone")};
        SQLiteDatabase writableDatabase = this.f10320b.getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT name FROM contacts WHERE phone = ? ", strArr);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        long update = moveToFirst ? (long) writableDatabase.update("contacts", contentValues, "phone = ? ", strArr) : writableDatabase.insert("contacts", null, contentValues);
        if (update > 0) {
            Uri withAppendedId = ContentUris.withAppendedId(uri, update);
            getContext().getContentResolver().notifyChange(withAppendedId, null);
            return withAppendedId;
        }
        throw new SQLException("Failed to insert row into" + uri);
    }

    public boolean onCreate() {
        this.f10320b = new C2963f(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (f10319a.match(uri) == 1) {
            return this.f10320b.getReadableDatabase().query("contacts", strArr, str, strArr2, null, null, str2);
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
