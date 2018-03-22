package com.huawei.hwid.update.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.leisen.wallet.sdk.http.RequestParams;
import java.io.File;
import java.io.FileNotFoundException;
import net.sqlcipher.database.SQLiteDatabase;

public class UpdateProvider extends ContentProvider {
    private static final String[] f1921a = new String[]{"_display_name", "_size"};
    private static C1034a f1922b = new C1034a();

    public static Uri m4162a(Context context, String str, File file) {
        f1922b.m4174a(context);
        return f1922b.m4171a(file, str);
    }

    public static File m4163a(Context context, String str) {
        f1922b.m4174a(context);
        return f1922b.m4173a(str);
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            f1922b.m4174a(context);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public String getType(Uri uri) {
        String name = f1922b.m4172a(uri).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            Object mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1));
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                return mimeTypeFromExtension;
            }
        }
        return RequestParams.APPLICATION_OCTET_STREAM;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File a = f1922b.m4172a(uri);
        if (strArr == null) {
            strArr = f1921a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            Object obj = strArr[i];
            if ("_display_name".equals(obj)) {
                strArr3[i2] = "_display_name";
                i3 = i2 + 1;
                objArr[i2] = a.getName();
            } else if ("_size".equals(obj)) {
                strArr3[i2] = "_size";
                i3 = i2 + 1;
                objArr[i2] = Long.valueOf(a.length());
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        String[] a2 = m4165a(strArr3, i2);
        Object[] a3 = m4164a(objArr, i2);
        Cursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return f1922b.m4172a(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(f1922b.m4172a(uri), m4161a(str));
    }

    private static int m4161a(String str) {
        if ("r".equals(str)) {
            return SQLiteDatabase.CREATE_IF_NECESSARY;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static String[] m4165a(String[] strArr, int i) {
        Object obj = new String[i];
        System.arraycopy(strArr, 0, obj, 0, i);
        return obj;
    }

    private static Object[] m4164a(Object[] objArr, int i) {
        Object obj = new Object[i];
        System.arraycopy(objArr, 0, obj, 0, i);
        return obj;
    }
}
