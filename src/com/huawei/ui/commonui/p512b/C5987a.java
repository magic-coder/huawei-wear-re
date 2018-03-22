package com.huawei.ui.commonui.p512b;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C5992b;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.dialog.C6004c;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: PhotoCorp */
public class C5987a {
    private static final String f20592a = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static final String f20593b = (f20592a + File.separator + "hwsports" + File.separator + "photos");
    private static final String f20594c = (f20592a + File.separator + "hwsport" + File.separator + "photo");
    private Activity f20595d;
    private Uri f20596e;
    private C5991e f20597f;
    private C5990d f20598g = C5990d.ADD;
    private CustomAlertDialog f20599h = null;

    public void m27432a(C5991e c5991e) {
        this.f20597f = c5991e;
    }

    public C5987a(Activity activity) {
        this.f20595d = activity;
    }

    public void m27431a(C5990d c5990d) {
        this.f20598g = c5990d;
        this.f20596e = Uri.parse("file://" + C5987a.m27424b(this.f20595d) + File.separator + String.valueOf(System.currentTimeMillis()) + ".jpg");
        C2538c.b("PhotoCorp", new Object[]{"start imageUri= " + this.f20596e.getPath()});
        m27425b();
    }

    private void m27425b() {
        if (this.f20599h == null || !this.f20599h.isShowing()) {
            View inflate = LayoutInflater.from(this.f20595d).inflate(C6031h.userinfo_choose_photo_dialog_layout, null);
            String[] stringArray = this.f20595d.getResources().getStringArray(C5992b.addphoto_type_array);
            TextView textView = (TextView) inflate.findViewById(C6030g.userinfo_take_photo);
            TextView textView2 = (TextView) inflate.findViewById(C6030g.userinfo_photo_from_phone);
            textView.setText(stringArray[0]);
            textView2.setText(stringArray[1]);
            C6004c c6004c = new C6004c(this.f20595d);
            this.f20599h = c6004c.m27535a();
            c6004c.m27538a(inflate);
            textView.setOnClickListener(new C5988b(this));
            textView2.setOnClickListener(new C5989c(this));
            this.f20599h.setCancelable(true);
            if (!this.f20599h.isShowing() && !this.f20595d.isFinishing()) {
                this.f20599h.show();
                return;
            }
            return;
        }
        C2538c.b("PhotoCorp", new Object[]{"showDialogSetlock Already show!"});
    }

    public Uri m27429a() {
        return this.f20596e;
    }

    private void m27419a(Uri uri, Uri uri2, int i) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("image-path", uri.getPath());
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 640);
        intent.putExtra("outputY", 640);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("output", uri2);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        this.f20595d.startActivityForResult(intent, i);
    }

    public void m27430a(int i, int i2, Intent intent) {
        C2538c.b("PhotoCorp", new Object[]{"onActivityResult requestCode:" + i + "    resultCode:" + i2});
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m27418a(intent);
                    return;
                case 1:
                    m27427c();
                    return;
                case 3:
                    C2538c.c("PhotoCorp", new Object[]{"CROP_PICTURE Cut Image Ok"});
                    m27428d();
                    return;
                default:
                    return;
            }
        }
    }

    private void m27418a(Intent intent) {
        if (intent != null) {
            Uri data = intent.getData();
            C2538c.b("PhotoCorp", new Object[]{"PICK_GALLERY_RESULT data.getData(): " + intent.getData()});
            C2538c.b("PhotoCorp", new Object[]{"PICK_GALLERY_RESULT imageUri: " + this.f20596e});
            if (data == null) {
                C2538c.b("PhotoCorp", new Object[]{"PICK_GALLERY_RESULT iMageUri is null"});
                return;
            }
            m27419a(data, this.f20596e, 3);
            return;
        }
        C2538c.b("PhotoCorp", new Object[]{"PICK_GALLERY_RESULT data is null"});
    }

    private void m27427c() {
        if (this.f20596e == null) {
            C2538c.b("PhotoCorp", new Object[]{"PICK_CAMERA_RESULT imageUri is null"});
            return;
        }
        Uri a = m27415a(this.f20595d, new File(this.f20596e.getPath()));
        if (a == null) {
            C2538c.b("PhotoCorp", new Object[]{"PICK_CAMERA_RESULT imgUr is null"});
            return;
        }
        C2538c.c("PhotoCorp", new Object[]{"PICK_CAMERA_RESULT open Cut Image"});
        m27419a(a, this.f20596e, 3);
    }

    private void m27428d() {
        Bitmap a = C5987a.m27414a(this.f20595d, this.f20596e);
        C2538c.c("PhotoCorp", new Object[]{"CROP_PICTURE get Cut Image Ok"});
        if (a == null) {
            C2538c.c("PhotoCorp", new Object[]{"CROP_PICTURE bitmap = null"});
            return;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteArrayOutputStream.toByteArray();
        byte[] a2 = C5987a.m27422a(a, 64000);
        if (this.f20597f != null && a2 != null) {
            C2538c.c("PhotoCorp", new Object[]{"isEUVersion, bitmap size=" + a2.length});
            m27421a(a2);
            this.f20597f.m27433a(this.f20598g, null);
        }
    }

    private Uri m27415a(Context context, File file) {
        Uri uri = null;
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null && query.moveToFirst()) {
            uri = Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + query.getInt(query.getColumnIndex("_id")));
        } else if (file.exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            uri = context.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        if (query != null) {
            query.close();
        }
        return uri;
    }

    private void m27421a(byte[] bArr) {
        IOException e;
        Throwable th;
        C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir Photo_IMG_PATH = " + f20593b});
        C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir file.getParent() = " + new File(f20593b).getParent()});
        File file = new File(r0.getParent());
        if (file.exists()) {
            C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir fileParent is exists"});
            m27420a(file);
        }
        this.f20596e = Uri.parse("file://" + C5987a.m27417a(this.f20595d) + File.separator + String.valueOf(System.currentTimeMillis()) + ".jpg");
        C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir imageUri = " + this.f20596e});
        File file2 = new File(this.f20596e.getPath());
        FileOutputStream fileOutputStream = null;
        try {
            if (file2.exists() || file2.createNewFile()) {
                C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir start to get ImageOutputStream"});
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f20596e.getPath());
                try {
                    C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir start to write to avatarByte"});
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    C2538c.c("PhotoCorp", new Object[]{"saveBitmapToDataDir start to write ok"});
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e2) {
                            C2538c.e("PhotoCorp", new Object[]{"Exception e = " + e2.getMessage()});
                            return;
                        }
                    }
                    return;
                } catch (IOException e3) {
                    e2 = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C2538c.e("PhotoCorp", new Object[]{"Exception e1 = " + e2.getMessage()});
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                C2538c.e("PhotoCorp", new Object[]{"Exception e = " + e22.getMessage()});
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                C2538c.e("PhotoCorp", new Object[]{"Exception e = " + e4.getMessage()});
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            C2538c.b("PhotoCorp", new Object[]{"saveBitmapToDataDir createNewFile error"});
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e222) {
                    C2538c.e("PhotoCorp", new Object[]{"Exception e = " + e222.getMessage()});
                }
            }
        } catch (IOException e5) {
            e222 = e5;
            C2538c.e("PhotoCorp", new Object[]{"Exception e1 = " + e222.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private void m27420a(File file) {
        C2538c.c("PhotoCorp", new Object[]{"deleteFile() file.getPath() = " + file.getPath()});
        if (!(file.isFile() && file.delete()) && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File a : listFiles) {
                    C2538c.c("PhotoCorp", new Object[]{"delete childFiles[" + r0 + "] = " + listFiles[r0].getPath()});
                    m27420a(a);
                }
                if (!file.delete()) {
                }
            } else if (file.delete()) {
                C2538c.c("PhotoCorp", new Object[]{"delete success"});
            }
        }
    }

    public static final byte[] m27422a(Bitmap bitmap, long j) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            int i = 90;
            while (((long) byteArrayOutputStream.toByteArray().length) > j) {
                byteArrayOutputStream.reset();
                bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
                i -= 10;
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (IOException e) {
            return null;
        }
    }

    public static String m27417a(Context context) {
        File file;
        C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath()"});
        C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() Environment.getExternalStorageState() = " + Environment.getExternalStorageState()});
        C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() Environment.MEDIA_MOUNTED = mounted"});
        C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() flag = " + Environment.getExternalStorageState().equals("mounted")});
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(f20594c + File.separator + "avaters");
            C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() path = " + file.getPath()});
        } else {
            C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() appPath = " + context.getApplicationContext().getFilesDir().getAbsolutePath()});
            file = new File(r1 + File.separator + "photo" + File.separator + "avaters");
            C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() path = " + file.getPath()});
        }
        if (file.exists()) {
            C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() path exists"});
        } else if (file.mkdirs()) {
            C2538c.c("PhotoCorp", new Object[]{"getAvatarPhotosPath() path.mkdirs return true"});
        } else {
            C2538c.e("PhotoCorp", new Object[]{"path.mkdirs return false"});
        }
        return file.getAbsolutePath();
    }

    public static String m27424b(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(f20593b + File.separator + "avater");
        } else {
            file = new File(context.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "photos" + File.separator + "avater");
        }
        if (!(file.exists() || file.mkdirs())) {
            C2538c.b("PhotoCorp", new Object[]{"getTempAvatarPhotosPath Creat mkdirs failure"});
        }
        return file.getAbsolutePath();
    }

    public static Bitmap m27414a(Context context, Uri uri) {
        C2538c.c("PhotoCorp", new Object[]{"decodeUriAsBitmap context = " + context + " uri = " + uri});
        try {
            return BitmapFactory.decodeFile(uri.getEncodedPath());
        } catch (Exception e) {
            C2538c.e("PhotoCorp", new Object[]{"Exception e = " + e.getMessage()});
            return null;
        }
    }
}
