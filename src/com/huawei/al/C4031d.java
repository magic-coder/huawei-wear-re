package com.huawei.al;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: WordLib */
public class C4031d {
    private C4030c f15323a = null;
    private C4030c f15324b = null;
    private ArrayList<Integer> f15325c = new ArrayList();
    private Context f15326d = null;

    public C4031d(Context context) {
        this.f15326d = context;
        File a = m19832a(context, "common_font.bin");
        if (a == null) {
            C2538c.e("WordLib", new Object[]{"HwWordLib() COMMON_FONT_FILE =null "});
            return;
        }
        C2538c.c("WordLib", new Object[]{"HwWordLib: copyFile(COMMON_FONT_FILE) = " + a});
        this.f15323a = new C4030c(this.f15326d, a);
        a = m19832a(context, "char_font.bin");
        if (a == null) {
            C2538c.e("WordLib", new Object[]{"HwWordLib() CHAR_FONT_FILE =null "});
            return;
        }
        C2538c.c("WordLib", new Object[]{"HwWordLib: copyFile(CHAR_FONT_FILE) = " + a});
        this.f15324b = new C4030c(this.f15326d, a);
    }

    private File m19832a(Context context, String str) {
        FileOutputStream fileOutputStream;
        IOException e;
        Exception e2;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        C2538c.c("WordLib", new Object[]{"copyFile: fileName = " + str});
        InputStream open;
        try {
            File file;
            open = context.getResources().getAssets().open(str);
            try {
                File filesDir = context.getFilesDir();
                if (!filesDir.exists()) {
                    C2538c.e("WordLib", new Object[]{"copyFile: dir = " + filesDir.getPath() + " is not exist..."});
                    if (!filesDir.mkdir()) {
                        C2538c.e("WordLib", new Object[]{"The File create Failed"});
                    }
                }
                file = new File(filesDir, str);
                if (file.exists() && !file.delete()) {
                    C2538c.e("WordLib", new Object[]{"The File Delete Failed"});
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                try {
                    C2538c.e("WordLib", new Object[]{"IOException e = " + e.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C2538c.e("WordLib", new Object[]{"IOException e = " + e4.getMessage()});
                        } catch (Exception e22) {
                            C2538c.e("WordLib", new Object[]{"Exception e = " + e22.getMessage()});
                        }
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e42) {
                            C2538c.e("WordLib", new Object[]{"IOException e = " + e42.getMessage()});
                        } catch (Exception e222) {
                            C2538c.e("WordLib", new Object[]{"Exception e = " + e222.getMessage()});
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            C2538c.e("WordLib", new Object[]{"IOException e = " + e5.getMessage()});
                        } catch (Exception e6) {
                            C2538c.e("WordLib", new Object[]{"Exception e = " + e6.getMessage()});
                        }
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e52) {
                            C2538c.e("WordLib", new Object[]{"IOException e = " + e52.getMessage()});
                        } catch (Exception e62) {
                            C2538c.e("WordLib", new Object[]{"Exception e = " + e62.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e222 = e7;
                fileOutputStream = null;
                C2538c.e("WordLib", new Object[]{"Exception e = " + e222.getMessage()});
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e422) {
                        C2538c.e("WordLib", new Object[]{"IOException e = " + e422.getMessage()});
                    } catch (Exception e2222) {
                        C2538c.e("WordLib", new Object[]{"Exception e = " + e2222.getMessage()});
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e4222) {
                        C2538c.e("WordLib", new Object[]{"IOException e = " + e4222.getMessage()});
                    } catch (Exception e22222) {
                        C2538c.e("WordLib", new Object[]{"Exception e = " + e22222.getMessage()});
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (open != null) {
                    open.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e522) {
                        C2538c.e("WordLib", new Object[]{"IOException e = " + e522.getMessage()});
                    } catch (Exception e622) {
                        C2538c.e("WordLib", new Object[]{"Exception e = " + e622.getMessage()});
                    }
                }
                if (open == null) {
                    return file;
                }
                try {
                    open.close();
                    return file;
                } catch (IOException e5222) {
                    C2538c.e("WordLib", new Object[]{"IOException e = " + e5222.getMessage()});
                    return file;
                } catch (Exception e6222) {
                    C2538c.e("WordLib", new Object[]{"Exception e = " + e6222.getMessage()});
                    return file;
                }
            } catch (IOException e8) {
                e4222 = e8;
                C2538c.e("WordLib", new Object[]{"IOException e = " + e4222.getMessage()});
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (open != null) {
                    open.close();
                }
                return null;
            } catch (Exception e9) {
                e22222 = e9;
                C2538c.e("WordLib", new Object[]{"Exception e = " + e22222.getMessage()});
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (open != null) {
                    open.close();
                }
                return null;
            }
        } catch (IOException e10) {
            e4222 = e10;
            fileOutputStream = null;
            open = null;
            C2538c.e("WordLib", new Object[]{"IOException e = " + e4222.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (open != null) {
                open.close();
            }
            return null;
        } catch (Exception e11) {
            e22222 = e11;
            fileOutputStream = null;
            open = null;
            C2538c.e("WordLib", new Object[]{"Exception e = " + e22222.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (open != null) {
                open.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    private void m19833a(ArrayList<Integer> arrayList, Bitmap bitmap) {
        if (arrayList != null && bitmap != null) {
            int i;
            int i2;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            C2538c.c("WordLib", new Object[]{"fillVerticalCharDot: width = " + width + ", height = " + height});
            ArrayList arrayList2 = new ArrayList(height);
            for (i = 0; i < height; i++) {
                String str = "";
                StringBuffer stringBuffer = new StringBuffer();
                for (i2 = 0; i2 < width; i2++) {
                    C2538c.c("WordLib", new Object[]{"doConvert: pixColor = " + Integer.toHexString(bitmap.getPixel(i2, i)) + ", color = " + ((short) (bitmap.getPixel(i2, i) & 255))});
                    if (((short) (bitmap.getPixel(i2, i) & 255)) <= (short) 127) {
                        stringBuffer.append(0);
                    } else {
                        stringBuffer.append(1);
                    }
                }
                arrayList2.add(stringBuffer.toString());
            }
            C2538c.c("WordLib", new Object[]{arrayList2.toString()});
            height = 0;
            i2 = 0;
            while (i2 < arrayList2.size()) {
                if (m19835b((String) arrayList2.get(i2))) {
                    arrayList2.remove(i2);
                    i = i2 - 1;
                    i2 = height + 1;
                    if (i2 >= 8) {
                        break;
                    }
                } else {
                    i = i2;
                    i2 = height;
                }
                height = i2;
                i2 = i + 1;
            }
            i2 = height;
            C2538c.c("WordLib", new Object[]{"fillVerticalCharDot: removeCount = " + i2 + ", maxRemoveCount = " + 8});
            C2538c.c("WordLib", new Object[]{arrayList2.toString()});
            int min = Math.min(width, 224);
            C2538c.c("WordLib", new Object[]{"fillVerticalCharDot: width = " + min});
            i2 = min % 8;
            if (i2 != 0) {
                i2 = 8 - i2;
            } else {
                i2 = 0;
            }
            C2538c.c("WordLib", new Object[]{"fillVerticalCharDot: column_add = " + i2 + ", isArabic = " + m19834a()});
            for (width = 0; width < min; width++) {
                if (width % 8 == 0) {
                    arrayList.add(Integer.valueOf(m19834a() ? 251 : 253));
                    arrayList.add(Integer.valueOf(16));
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                String str2 = "";
                for (height = 0; height < 16; height++) {
                    stringBuffer2.append(((String) arrayList2.get(height)).charAt(width));
                }
                i = Integer.parseInt(stringBuffer2.toString(), 2);
                height = i >> 8;
                i &= 255;
                arrayList.add(Integer.valueOf(C4030c.m19828a(height) & 255));
                arrayList.add(Integer.valueOf(C4030c.m19828a(i) & 255));
            }
            while (true) {
                i = i2 - 1;
                if (i2 > 0) {
                    arrayList.add(Integer.valueOf(0));
                    arrayList.add(Integer.valueOf(0));
                    i2 = i;
                } else {
                    return;
                }
            }
        }
    }

    private boolean m19835b(String str) {
        C2538c.c("WordLib", new Object[]{"isStringAllZero: str = " + str});
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        C2538c.c("WordLib", new Object[]{"isStringAllZero: value = " + str.replaceAll("0", "")});
        if (str.replaceAll("0", "").length() > 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Integer> m19836a(String str) {
        int i;
        String str2;
        C2538c.c("WordLib", new Object[]{"getNameValues2: userName = " + str});
        this.f15325c.clear();
        Paint paint = new Paint();
        paint.setTextSize(m19834a() ? 15.0f : 16.0f);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        int measureText = (int) paint.measureText(str);
        C2538c.c("WordLib", new Object[]{"getNameValues2: length = " + str.length() + ", textWidth = " + measureText + ", textHeight = " + m19831a(16.0f)});
        if (measureText > NFCBaseActivity.TO_ADD) {
            i = measureText;
            str2 = null;
            for (int i2 = r4 - 1; i2 > 0; i2--) {
                str2 = str.substring(0, i2);
                i = (int) paint.measureText(str2);
                if (i <= NFCBaseActivity.TO_ADD) {
                    break;
                }
            }
        } else {
            i = measureText;
            str2 = str;
        }
        i += 2;
        C2538c.c("WordLib", new Object[]{"getNameValues2: y = " + ((float) r5) + ", userName = " + str2});
        Bitmap createBitmap = Bitmap.createBitmap(i, 24, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawText(str2, 0.0f, r5, paint);
        canvas.save(31);
        canvas.restore();
        m19833a(this.f15325c, createBitmap);
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        return this.f15325c;
    }

    private int m19831a(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
    }

    private boolean m19834a() {
        if ("ar".equalsIgnoreCase(this.f15326d.getResources().getConfiguration().locale.getLanguage())) {
            return true;
        }
        return false;
    }
}
