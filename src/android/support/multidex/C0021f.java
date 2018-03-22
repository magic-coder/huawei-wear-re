package android.support.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import cn.com.fmsh.communication.core.MessageHead;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: ZipUtil */
final class C0021f {
    static long m87a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C0021f.m88a(randomAccessFile, C0021f.m89a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static C0022g m89a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C0022g c0022g = new C0022g();
                c0022g.f104b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & MessageHead.SERIAL_MAK;
                c0022g.f103a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & MessageHead.SERIAL_MAK;
                return c0022g;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long m88a(RandomAccessFile randomAccessFile, C0022g c0022g) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = c0022g.f104b;
        randomAccessFile.seek(c0022g.f103a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        }
        return crc32.getValue();
    }
}
