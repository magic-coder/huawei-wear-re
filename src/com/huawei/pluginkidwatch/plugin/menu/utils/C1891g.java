package com.huawei.pluginkidwatch.plugin.menu.utils;

import com.huawei.pluginkidwatch.common.entity.model.Contact;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: ContactSort */
public class C1891g implements Serializable, Comparator<Contact> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9658a((Contact) obj, (Contact) obj2);
    }

    public int m9658a(Contact contact, Contact contact2) {
        if (contact.getSortLetters().equals("@") || contact2.getSortLetters().equals("#")) {
            return -1;
        }
        if (contact.getSortLetters().equals("#") || contact2.getSortLetters().equals("@")) {
            return 1;
        }
        return contact.getSortLetters().compareTo(contact2.getSortLetters());
    }
}
