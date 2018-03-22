package com.squareup.okhttp.internal.spdy;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Huffman {
    private static final int[] CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, SpecialIssueType.BUG_TYPE_ID_CHARGE, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, TagName.ELECTRONIC_USE_COUNT, 120, 121, 122, ReportInfoUtils.FEEDBACK_SUCCESS, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_LENGTHS = new byte[]{TagName.PAY_CHANNEL, TagName.ORDER_TERMINAL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_CHANNEL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.ORDER_CHANNEL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.ORDER_CHANNEL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, TagName.APK_DOWNLOAD_URL, (byte) 6, (byte) 10, (byte) 10, TagName.IDENTIFYING_CODE, TagName.PAY_CHANNEL, (byte) 6, (byte) 8, TagName.IDENTIFYING_TYPE, (byte) 10, (byte) 10, (byte) 8, TagName.IDENTIFYING_TYPE, (byte) 8, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 7, (byte) 8, (byte) 15, (byte) 6, TagName.IDENTIFYING_CODE, (byte) 10, TagName.PAY_CHANNEL, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 8, (byte) 7, (byte) 8, TagName.PAY_CHANNEL, TagName.ORDER_DATE, TagName.PAY_CHANNEL, (byte) 14, (byte) 6, (byte) 15, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 6, (byte) 7, (byte) 6, (byte) 5, (byte) 5, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 15, TagName.IDENTIFYING_TYPE, (byte) 14, TagName.PAY_CHANNEL, TagName.APK_DOWNLOAD_URL, TagName.ORDER_TIME, TagName.ORDER_TRADE_NO, TagName.ORDER_TIME, TagName.ORDER_TIME, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TIME, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TERMINAL, TagName.ORDER_TIME, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER, TagName.ORDER_TIME, TagName.ORDER_DATE, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_QUERY_PARAM, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_QUERY_PARAM, TagName.ORDER_DATE, TagName.ORDER_TRADE_STATUS, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_STATUS, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER, TagName.APK_DOWNLOAD_URL, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.ORDER_TIME, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_TIME, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TERMINAL, TagName.ORDER_TRADE_NO, TagName.ORDER_TRADE_NO, TagName.ORDER_QUERY_PARAM, TagName.ORDER_QUERY_PARAM, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_INVOICE_STATUS, TagName.BUSINESS_ORDER, TagName.ORDER_TERMINAL, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.APK_DOWNLOAD_URL, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER_LIST, TagName.BUSINESS_ORDER};
    private static final Huffman INSTANCE = new Huffman();
    private final Node root = new Node();

    final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBits;

        Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBits = 0;
        }

        Node(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            if (i3 == 0) {
                i3 = 8;
            }
            this.terminalBits = i3;
        }
    }

    public static Huffman get() {
        return INSTANCE;
    }

    private Huffman() {
        buildTree();
    }

    void encode(byte[] bArr, OutputStream outputStream) throws IOException {
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = bArr[i] & 255;
            int i4 = CODES[i3];
            byte b = CODE_LENGTHS[i3];
            j = (j << b) | ((long) i4);
            i2 += b;
            while (i2 >= 8) {
                i2 -= 8;
                outputStream.write((int) (j >> i2));
            }
            i++;
        }
        if (i2 > 0) {
            outputStream.write((int) (((long) (255 >>> i2)) | (j << (8 - i2))));
        }
    }

    int encodedLength(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j += (long) CODE_LENGTHS[b & 255];
        }
        return (int) ((7 + j) >> 3);
    }

    byte[] decode(byte[] bArr) throws IOException {
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        Node node = this.root;
        int i3 = 0;
        while (i < bArr.length) {
            i2 = (i2 << 8) | (bArr[i] & 255);
            i3 += 8;
            while (i3 >= 8) {
                node = node.children[(i2 >>> (i3 - 8)) & 255];
                if (node.children == null) {
                    byteArrayOutputStream.write(node.symbol);
                    i3 -= node.terminalBits;
                    node = this.root;
                } else {
                    i3 -= 8;
                }
            }
            i++;
        }
        while (i3 > 0) {
            Node node2 = node.children[(i2 << (8 - i3)) & 255];
            if (node2.children != null || node2.terminalBits > i3) {
                break;
            }
            byteArrayOutputStream.write(node2.symbol);
            i3 -= node2.terminalBits;
            node = this.root;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void buildTree() {
        for (int i = 0; i < CODE_LENGTHS.length; i++) {
            addCode(i, CODES[i], CODE_LENGTHS[i]);
        }
    }

    private void addCode(int i, int i2, byte b) {
        int i3;
        Node node = new Node(i, b);
        Node node2 = this.root;
        while (b > (byte) 8) {
            b = (byte) (b - 8);
            i3 = (i2 >>> b) & 255;
            if (node2.children == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (node2.children[i3] == null) {
                node2.children[i3] = new Node();
            }
            node2 = node2.children[i3];
        }
        i3 = 8 - b;
        int i4 = (i2 << i3) & 255;
        int i5 = 1 << i3;
        for (i3 = i4; i3 < i4 + i5; i3++) {
            node2.children[i3] = node;
        }
    }
}
