package com.squareup.haha.guava.base;

import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.guava.collect.Iterators;
import com.squareup.haha.guava.collect.Lists$RandomAccessReverseList;
import com.squareup.haha.guava.collect.Lists$ReverseList;
import com.squareup.haha.guava.collect.Multiset;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public class Joiner {
    private final String separator;

    public final class MapJoiner {
        private MapJoiner(Joiner joiner, String str) {
            Joiner.checkNotNull(str);
        }
    }

    public Joiner(String str) {
        this.separator = (String) checkNotNull(str);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    @CheckReturnValue
    public Joiner useForNull(final String str) {
        checkNotNull(str);
        return new Joiner(this) {
            final CharSequence toString(@Nullable Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            public final Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    CharSequence toString(Object obj) {
        checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            checkNotNull(stringBuilder);
            if (it.hasNext()) {
                stringBuilder.append(toString(it.next()));
                while (it.hasNext()) {
                    stringBuilder.append(this.separator);
                    stringBuilder.append(toString(it.next()));
                }
            }
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int checkElementIndex(int i, int i2) {
        String str = XMLNode.KEY_INDEX;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            str = format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int checkPositionIndex(int i, int i2) {
        String str = XMLNode.KEY_INDEX;
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i, i2, str));
    }

    static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            String badPositionIndex;
            if (i < 0 || i > i3) {
                badPositionIndex = badPositionIndex(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                badPositionIndex = badPositionIndex(i2, i3, "end index");
            } else {
                badPositionIndex = format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(badPositionIndex);
        }
    }

    static String format(String str, Object... objArr) {
        int i = 0;
        String valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf.substring(i2, indexOf));
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf.substring(i2));
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public static void checkRemove(boolean z) {
        String str = "no calls to next() since the last call to remove()";
        if (!z) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof Lists$ReverseList) {
            return ((Lists$ReverseList) list).forwardList;
        }
        if (list instanceof RandomAccess) {
            return new Lists$RandomAccessReverseList(list);
        }
        return new Lists$ReverseList(list);
    }

    public static boolean equalsImpl(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean removeAllImpl(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return removeAllImpl((Set) set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    public static int hash(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}
