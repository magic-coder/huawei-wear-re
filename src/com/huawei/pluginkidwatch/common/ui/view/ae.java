package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1488h;
import com.huawei.pluginkidwatch.common.ui.p150a.C1508i;
import com.huawei.pluginkidwatch.common.ui.simplecropimage.C1562y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PhotoCorp */
public class ae {
    private static Uri f3836b;
    private Activity f3837a;
    private Uri f3838c;
    private ag f3839d;
    private af f3840e = af.ADD;

    public void m7239a(ag agVar) {
        this.f3839d = agVar;
    }

    public ae(Activity activity) {
        this.f3837a = activity;
    }

    public void m7238a(af afVar) {
        this.f3840e = afVar;
        m7231c();
        new ah(this.f3837a).m7249a(this.f3837a, this.f3838c, this);
        if (f3836b == null) {
            C2538c.m12674b("PhotoCorp", "============start imageUri == NULL ");
            return;
        }
        C2538c.m12674b("PhotoCorp", "============start imageUri  ", f3836b.toString());
    }

    private void m7231c() {
        m7230b(Uri.parse("file://" + C1488h.m6885b(this.f3837a) + File.separator + String.valueOf(System.currentTimeMillis()) + ".jpg"));
        this.f3838c = Uri.parse("file://" + C1488h.m6885b(this.f3837a) + File.separator + String.valueOf(System.currentTimeMillis()) + "take.jpg");
        C2538c.m12674b("PhotoCorp", "takePicUri = " + this.f3838c.getPath());
    }

    public void m7235a() {
        C2538c.m12674b("PhotoCorp", "============ enter start ");
        m7231c();
        new ah(this.f3837a).m7250b(this.f3837a, this.f3838c, this);
        if (f3836b == null) {
            C2538c.m12674b("PhotoCorp", "============start imageUri == NULL ");
            return;
        }
        C2538c.m12674b("PhotoCorp", "============start imageUri  ", f3836b.toString());
    }

    public Uri m7240b() {
        return f3836b;
    }

    private void m7229a(Uri uri, Uri uri2, int i) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("image-path", uri.getPath());
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 128);
        intent.putExtra("outputY", 128);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("output", uri2);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        this.f3837a.startActivityForResult(intent, i);
    }

    public void m7236a(int i, int i2, Intent intent) {
        C2538c.m12674b("PhotoCorp", "onActivityResult requestCode:" + i + "    resultCode:" + i2);
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m7228a(intent);
                    return;
                case 1:
                    m7234f();
                    return;
                case 3:
                    m7233e();
                    return;
                case 4:
                    m7232d();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7232d() {
        C2538c.m12674b("PhotoCorp", "==========KeyConstants.CHOOSE_DEFAULT_PICTURE");
        if (this.f3839d != null) {
            this.f3839d.mo2616a(true);
        }
    }

    private void m7233e() {
        Bitmap a = C1508i.m6981a(this.f3837a, f3836b);
        if (a != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (this.f3839d != null) {
                this.f3839d.mo2615a(this.f3840e, toByteArray);
            }
        }
    }

    private void m7234f() {
        if (this.f3838c == null) {
            C2538c.m12674b("PhotoCorp", "onActivityResult takePicUri is null");
            return;
        }
        int a = C1562y.m7177a(this.f3838c.getPath());
        C2538c.m12674b("PhotoCorp", "degree = " + a);
        Bitmap a2 = m7226a(this.f3838c);
        if (!(a2 == null || a == 0)) {
            Bitmap a3 = C1562y.m7178a(a2, (float) a);
            m7237a(a3, this.f3838c.getPath());
            C2538c.m12674b("PhotoCorp", "cbitmap = " + a3);
            a3.recycle();
        }
        Uri a4 = m7227a(this.f3837a, new File(this.f3838c.getPath()));
        if (a4 == null) {
            C2538c.m12674b("PhotoCorp", "onActivityResult iMageUri is null");
            return;
        }
        m7229a(a4, f3836b, 3);
    }

    private void m7228a(Intent intent) {
        if (intent != null) {
            Uri data = intent.getData();
            C2538c.m12674b("PhotoCorp", "onActivityResult data.getData(): " + intent.getData());
            C2538c.m12674b("PhotoCorp", "onActivityResult imageUri: " + f3836b);
            if (data == null) {
                C2538c.m12674b("PhotoCorp", "onActivityResult iMageUri is null");
                return;
            }
            m7229a(data, f3836b, 3);
            return;
        }
        C2538c.m12674b("PhotoCorp", "onActivityResult data is null");
    }

    private Uri m7227a(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            if (!file.exists()) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return context.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        Uri parse = Uri.parse("content://media/external/images/media");
        query.close();
        return Uri.withAppendedPath(parse, "" + i);
    }

    public void m7237a(Bitmap bitmap, String str) {
        IOException e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        C2538c.m12680e("PhotoCorp", "copyFile close IOException");
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C2538c.m12680e("PhotoCorp", "e = " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C2538c.m12680e("PhotoCorp", "copyFile close IOException");
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C2538c.m12680e("PhotoCorp", "copyFile close IOException");
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
            C2538c.m12680e("PhotoCorp", "e = " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private Bitmap m7226a(Uri uri) {
        InputStream openInputStream;
        IOException e;
        Throwable th;
        try {
            openInputStream = this.f3837a.getContentResolver().openInputStream(uri);
            try {
                int pow;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(openInputStream, null, options);
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (options.outHeight > 1024 || options.outWidth > 1024) {
                    pow = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(1024.0d / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
                } else {
                    pow = 1;
                }
                C2538c.m12674b("PhotoCorp", "EXCEPTION scale = " + pow);
                Options options2 = new Options();
                options2.inSampleSize = pow;
                openInputStream = this.f3837a.getContentResolver().openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options2);
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (openInputStream == null) {
                    return decodeStream;
                }
                try {
                    openInputStream.close();
                    return decodeStream;
                } catch (IOException e2) {
                    C2538c.m12680e("PhotoCorp", "copyFile close IOException e = " + e2.getMessage());
                    return decodeStream;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C2538c.m12680e("PhotoCorp", "EXCEPTION E = " + e.getMessage());
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e4) {
                            C2538c.m12680e("PhotoCorp", "copyFile close IOException e = " + e4.getMessage());
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e22) {
                            C2538c.m12680e("PhotoCorp", "copyFile close IOException e = " + e22.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e4 = e5;
            openInputStream = null;
            C2538c.m12680e("PhotoCorp", "EXCEPTION E = " + e4.getMessage());
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            openInputStream = null;
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
    }

    private static void m7230b(Uri uri) {
        f3836b = uri;
    }
}
