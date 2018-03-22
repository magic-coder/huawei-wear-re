package com.android.huawei.pay.install;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.leisen.wallet.sdk.http.RequestParams;
import java.io.File;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteDatabase;
import org.apache.http.cookie.ClientCookie;

public class OtaFileProvider extends ContentProvider {
    private static final String[] f141a = new String[]{"_display_name", "_size"};
    private static final File f142b = new File("/");
    private static HashMap f143c = new HashMap();
    private C0298a f144d;

    private static int m114a(String str) {
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

    private static C0298a m115a(Context context, String str) {
        C0298a c0298a;
        synchronized (f143c) {
            c0298a = (C0298a) f143c.get(str);
            if (c0298a == null) {
                try {
                    c0298a = m119b(context, str);
                    f143c.put(str, c0298a);
                } catch (Throwable e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (Throwable e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return c0298a;
    }

    private static File m116a(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            i++;
            file2 = str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    private static Object[] m117a(Object[] objArr, int i) {
        Object obj = new Object[i];
        System.arraycopy(objArr, 0, obj, 0, i);
        return obj;
    }

    private static String[] m118a(String[] strArr, int i) {
        Object obj = new String[i];
        System.arraycopy(strArr, 0, obj, 0, i);
        return obj;
    }

    private static C0298a m119b(Context context, String str) {
        C0298a c0299b = new C0299b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return c0299b;
            }
            if (next == 2) {
                File a;
                String name = loadXmlMetaData.getName();
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, ClientCookie.PATH_ATTR);
                if ("root-path".equals(name)) {
                    a = m116a(f142b, attributeValue2);
                } else if ("files-path".equals(name)) {
                    a = m116a(context.getFilesDir(), attributeValue2);
                } else if ("cache-path".equals(name)) {
                    a = m116a(context.getCacheDir(), attributeValue2);
                } else if ("external-path".equals(name)) {
                    a = m116a(Environment.getExternalStorageDirectory(), attributeValue2);
                } else {
                    a = null;
                }
                if (a != null) {
                    c0299b.m122a(attributeValue, a);
                }
            }
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f144d = m115a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f144d.mo1702a(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        File a = this.f144d.mo1702a(uri);
        int lastIndexOf = a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return RequestParams.APPLICATION_OCTET_STREAM;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f144d.mo1702a(uri), m114a(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File a = this.f144d.mo1702a(uri);
        if (strArr == null) {
            strArr = f141a;
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
        String[] a2 = m118a(strArr3, i2);
        Object[] a3 = m117a(objArr, i2);
        Cursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
