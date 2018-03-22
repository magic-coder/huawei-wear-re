package org.apache.log4j.pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class NameAbbreviator {
    private static final NameAbbreviator DEFAULT = new NOPAbbreviator();

    class DropElementAbbreviator extends NameAbbreviator {
        private final int count;

        public DropElementAbbreviator(int i) {
            this.count = i;
        }

        public void abbreviate(int i, StringBuffer stringBuffer) {
            int i2 = this.count;
            int indexOf = stringBuffer.indexOf(".", i);
            while (indexOf != -1) {
                i2--;
                if (i2 == 0) {
                    stringBuffer.delete(i, indexOf + 1);
                    return;
                }
                indexOf = stringBuffer.indexOf(".", indexOf + 1);
            }
        }
    }

    class MaxElementAbbreviator extends NameAbbreviator {
        private final int count;

        public MaxElementAbbreviator(int i) {
            this.count = i;
        }

        public void abbreviate(int i, StringBuffer stringBuffer) {
            int length = stringBuffer.length() - 1;
            String stringBuffer2 = stringBuffer.toString();
            int i2 = this.count;
            while (i2 > 0) {
                length = stringBuffer2.lastIndexOf(".", length - 1);
                if (length != -1 && length >= i) {
                    i2--;
                } else {
                    return;
                }
            }
            stringBuffer.delete(i, length + 1);
        }
    }

    class NOPAbbreviator extends NameAbbreviator {
        public void abbreviate(int i, StringBuffer stringBuffer) {
        }
    }

    class PatternAbbreviator extends NameAbbreviator {
        private final PatternAbbreviatorFragment[] fragments;

        public PatternAbbreviator(List list) {
            if (list.size() == 0) {
                throw new IllegalArgumentException("fragments must have at least one element");
            }
            this.fragments = new PatternAbbreviatorFragment[list.size()];
            list.toArray(this.fragments);
        }

        public void abbreviate(int i, StringBuffer stringBuffer) {
            for (int i2 = 0; i2 < this.fragments.length - 1 && i < stringBuffer.length(); i2++) {
                i = this.fragments[i2].abbreviate(stringBuffer, i);
            }
            PatternAbbreviatorFragment patternAbbreviatorFragment = this.fragments[this.fragments.length - 1];
            while (i < stringBuffer.length() && i >= 0) {
                i = patternAbbreviatorFragment.abbreviate(stringBuffer, i);
            }
        }
    }

    class PatternAbbreviatorFragment {
        private final int charCount;
        private final char ellipsis;

        public PatternAbbreviatorFragment(int i, char c) {
            this.charCount = i;
            this.ellipsis = c;
        }

        public int abbreviate(StringBuffer stringBuffer, int i) {
            int indexOf = stringBuffer.toString().indexOf(".", i);
            if (indexOf == -1) {
                return indexOf;
            }
            if (indexOf - i > this.charCount) {
                stringBuffer.delete(this.charCount + i, indexOf);
                indexOf = this.charCount + i;
                if (this.ellipsis != '\u0000') {
                    stringBuffer.insert(indexOf, this.ellipsis);
                    indexOf++;
                }
            }
            return indexOf + 1;
        }
    }

    public abstract void abbreviate(int i, StringBuffer stringBuffer);

    public static NameAbbreviator getAbbreviator(String str) {
        if (str.length() <= 0) {
            return DEFAULT;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return DEFAULT;
        }
        int i;
        if (trim.length() > 0) {
            if (trim.charAt(0) == '-') {
                i = 1;
            } else {
                i = 0;
            }
            while (i < trim.length() && trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                i++;
            }
        } else {
            i = 0;
        }
        if (i == trim.length()) {
            int parseInt = Integer.parseInt(trim);
            if (parseInt >= 0) {
                return new MaxElementAbbreviator(parseInt);
            }
            return new DropElementAbbreviator(-parseInt);
        }
        List arrayList = new ArrayList(5);
        i = 0;
        while (i < trim.length() && i >= 0) {
            int i2;
            int i3;
            char charAt;
            if (trim.charAt(i) == '*') {
                i2 = Integer.MAX_VALUE;
                i3 = i + 1;
            } else if (trim.charAt(i) < '0' || trim.charAt(i) > '9') {
                i3 = i;
                i2 = 0;
            } else {
                i2 = trim.charAt(i) - 48;
                i3 = i + 1;
            }
            if (i3 < trim.length()) {
                charAt = trim.charAt(i3);
                if (charAt == '.') {
                    charAt = '\u0000';
                }
            } else {
                charAt = '\u0000';
            }
            arrayList.add(new PatternAbbreviatorFragment(i2, charAt));
            i = trim.indexOf(".", i);
            if (i == -1) {
                break;
            }
            i++;
        }
        return new PatternAbbreviator(arrayList);
    }

    public static NameAbbreviator getDefaultAbbreviator() {
        return DEFAULT;
    }
}
