package org.apache.log4j.pattern;

public final class FormattingInfo {
    private static final FormattingInfo DEFAULT = new FormattingInfo(false, 0, Integer.MAX_VALUE);
    private static final char[] SPACES = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private final boolean leftAlign;
    private final int maxLength;
    private final int minLength;

    public FormattingInfo(boolean z, int i, int i2) {
        this.leftAlign = z;
        this.minLength = i;
        this.maxLength = i2;
    }

    public static FormattingInfo getDefault() {
        return DEFAULT;
    }

    public boolean isLeftAligned() {
        return this.leftAlign;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void format(int i, StringBuffer stringBuffer) {
        int length = stringBuffer.length() - i;
        if (length > this.maxLength) {
            stringBuffer.delete(i, stringBuffer.length() - this.maxLength);
        } else if (length >= this.minLength) {
        } else {
            if (this.leftAlign) {
                stringBuffer.setLength(this.minLength + i);
                for (length = stringBuffer.length(); length < stringBuffer.length(); length++) {
                    stringBuffer.setCharAt(length, ' ');
                }
                return;
            }
            length = this.minLength - length;
            while (length > 8) {
                stringBuffer.insert(i, SPACES);
                length -= 8;
            }
            stringBuffer.insert(i, SPACES, 0, length);
        }
    }
}
