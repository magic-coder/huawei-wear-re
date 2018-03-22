package org.apache.log4j.varia;

import org.apache.log4j.Level;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class LevelMatchFilter extends Filter {
    boolean acceptOnMatch = true;
    Level levelToMatch;

    public void setLevelToMatch(String str) {
        this.levelToMatch = OptionConverter.toLevel(str, null);
    }

    public String getLevelToMatch() {
        return this.levelToMatch == null ? null : this.levelToMatch.toString();
    }

    public void setAcceptOnMatch(boolean z) {
        this.acceptOnMatch = z;
    }

    public boolean getAcceptOnMatch() {
        return this.acceptOnMatch;
    }

    public int decide(LoggingEvent loggingEvent) {
        if (this.levelToMatch == null) {
            return 0;
        }
        int i;
        if (this.levelToMatch.equals(loggingEvent.getLevel())) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            return 0;
        }
        if (this.acceptOnMatch) {
            return 1;
        }
        return -1;
    }
}
