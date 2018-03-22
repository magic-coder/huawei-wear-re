package com.amap.api.maps.model;

import com.amap.api.mapcore.util.bf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int f11173a;
    private final int f11174b;

    public abstract URL getTileUrl(int i, int i2, int i3);

    public UrlTileProvider(int i, int i2) {
        this.f11173a = i;
        this.f11174b = i2;
    }

    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        bf.m15627a("UrlTileProvider", "url: " + tileUrl.toString(), 111);
        try {
            return new Tile(this.f11173a, this.f11174b, m15213a(tileUrl.openStream()));
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    private static byte[] m15213a(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m15212a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static long m15212a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public int getTileWidth() {
        return this.f11173a;
    }

    public int getTileHeight() {
        return this.f11174b;
    }
}
