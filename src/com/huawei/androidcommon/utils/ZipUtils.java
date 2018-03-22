package com.huawei.androidcommon.utils;

import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private final int BUF_SIZE = 1048576;
    private final String TAG = AC.TAG;
    private long mCompressedSize = 0;
    private CompressListener mListener;
    private long mTotalSize = 0;
    private AtomicBoolean stop = new AtomicBoolean(false);

    public interface CompressListener {
        void onCompressedProgress(int i);
    }

    public void setOnCompressListener(CompressListener compressListener) {
        this.mListener = compressListener;
    }

    public void setStop(boolean z) {
        this.stop.set(z);
    }

    public boolean compress(String[] strArr, String str) {
        Throwable e;
        Throwable th;
        boolean z = false;
        Log.i(AC.TAG, "[ZipUtils.compress]Begin to compress");
        for (String str2 : strArr) {
            Log.i(AC.TAG, "[ZipUtils.compress]Zip file/directory path:" + str2);
        }
        setStop(false);
        long currentTimeMillis = System.currentTimeMillis();
        Closeable zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            try {
                for (String dirSize : strArr) {
                    this.mTotalSize = FileUtils.getDirSize(dirSize) + this.mTotalSize;
                }
                for (String dirSize2 : strArr) {
                    if (this.stop.get()) {
                        FileUtils.deleteFile(str);
                        IOUtils.close(zipOutputStream);
                        break;
                    }
                    startCompress(zipOutputStream, dirSize2);
                }
                z = true;
                IOUtils.close(zipOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            zipOutputStream = null;
            try {
                Log.e(AC.TAG, "[ZipUtils.compress]FileNotFoundException:" + str, e);
                IOUtils.close(zipOutputStream);
                Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return z;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.close(zipOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            zipOutputStream = null;
            Log.e(AC.TAG, "[ZipUtils.compress]IOException:" + str, e);
            IOUtils.close(zipOutputStream);
            Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return z;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            IOUtils.close(zipOutputStream);
            throw th;
        }
        Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return z;
    }

    public boolean compress(String str, String str2) {
        Closeable zipOutputStream;
        Throwable e;
        Throwable th;
        boolean z = false;
        if (!StringUtils.isNullOrEmpty(str) && new File(str).exists()) {
            FileUtils.createFile(str2);
            setStop(false);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                try {
                    this.mTotalSize = FileUtils.getDirSize(str);
                    startCompress(zipOutputStream, str);
                    if (this.stop.get()) {
                        FileUtils.deleteFile(str2);
                        IOUtils.close(zipOutputStream);
                    } else {
                        z = true;
                        IOUtils.close(zipOutputStream);
                        Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    try {
                        Log.e(AC.TAG, "[ZipUtils.compress]FileNotFoundException:" + str2, e);
                        IOUtils.close(zipOutputStream);
                        Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.close(zipOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    Log.e(AC.TAG, "[ZipUtils.compress]IOException:" + str2, e);
                    IOUtils.close(zipOutputStream);
                    Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return z;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                zipOutputStream = null;
                Log.e(AC.TAG, "[ZipUtils.compress]FileNotFoundException:" + str2, e);
                IOUtils.close(zipOutputStream);
                Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return z;
            } catch (IOException e5) {
                e = e5;
                zipOutputStream = null;
                Log.e(AC.TAG, "[ZipUtils.compress]IOException:" + str2, e);
                IOUtils.close(zipOutputStream);
                Log.i(AC.TAG, "[ZipUtils.compress]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return z;
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = null;
                IOUtils.close(zipOutputStream);
                throw th;
            }
        }
        return z;
    }

    private void startCompress(ZipOutputStream zipOutputStream, String str) throws IOException {
        startCompress(zipOutputStream, "", str);
    }

    private void startCompress(ZipOutputStream zipOutputStream, String str, String str2) {
        if (!StringUtils.isNullOrEmpty(str2)) {
            File file = new File(str2);
            Log.i(AC.TAG, "[ZipUtils.startCompress]Start compress directory: " + str2);
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        Log.e(AC.TAG, "[ZipUtils.startCompress]StartCompress can't access " + file);
                        return;
                    }
                    String stringBuilder = new StringBuilder(String.valueOf(str)).append(file.getName()).append("/").toString();
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            if (!this.stop.get()) {
                                startCompress(zipOutputStream, stringBuilder, file2.getPath());
                            } else {
                                return;
                            }
                        } else if (!this.stop.get()) {
                            compressFile(zipOutputStream, stringBuilder, file2);
                        } else {
                            return;
                        }
                    }
                } else if (file.isFile()) {
                    compressFile(zipOutputStream, str, file);
                }
                Log.i(AC.TAG, "[ZipUtils.compress]Compress directory " + str2 + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    private void compressFile(ZipOutputStream zipOutputStream, String str, File file) {
        Closeable fileInputStream;
        Throwable e;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(new StringBuilder(String.valueOf(str)).append(file.getName()).toString()));
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1048576);
                    if (read < 0) {
                        zipOutputStream.closeEntry();
                        IOUtils.close(fileInputStream);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                    if (this.mTotalSize != 0) {
                        long j = ((long) read) + this.mCompressedSize;
                        int i = (int) ((j * 100) / this.mTotalSize);
                        if (i > ((int) ((this.mCompressedSize * 100) / this.mTotalSize)) && this.mListener != null) {
                            this.mListener.onCompressedProgress(i);
                        }
                        this.mCompressedSize = j;
                    }
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileInputStream = null;
            try {
                Log.e(AC.TAG, "[ZipUtils.compressFile]FileNotFoundException:" + file.getPath(), e);
                IOUtils.close(fileInputStream);
            } catch (Throwable th) {
                e = th;
                IOUtils.close(fileInputStream);
                throw e;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
            Log.e(AC.TAG, "[ZipUtils.compressFile]IOException:" + file.getPath(), e);
            IOUtils.close(fileInputStream);
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            IOUtils.close(fileInputStream);
            throw e;
        }
    }

    public boolean appendFilesToZip(String str, String[] strArr, String str2) {
        try {
            File file = new File(str);
            File createTempFile = File.createTempFile(file.getName(), null, new File(str2));
            Log.d(AC.TAG, "[ZipUtils.appendFilesToZip]tmpZip:" + createTempFile.getPath());
            if (file.renameTo(createTempFile)) {
                int read;
                byte[] bArr = new byte[1024];
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(createTempFile));
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
                for (String file2 : strArr) {
                    file = new File(file2);
                    InputStream fileInputStream = new FileInputStream(file);
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    for (read = fileInputStream.read(bArr); read > -1; read = fileInputStream.read(bArr)) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                }
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    zipOutputStream.putNextEntry(nextEntry);
                    for (read = zipInputStream.read(bArr); read > -1; read = zipInputStream.read(bArr)) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                }
                zipOutputStream.close();
                createTempFile.delete();
                return true;
            }
            Log.d(AC.TAG, "[ZipUtils.appendFilesToZip]Create temp file failed!");
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
