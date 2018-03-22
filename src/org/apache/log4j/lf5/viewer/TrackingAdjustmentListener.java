package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class TrackingAdjustmentListener implements AdjustmentListener {
    protected int _lastMaximum = -1;

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        Adjustable adjustable = adjustmentEvent.getAdjustable();
        int maximum = adjustable.getMaximum();
        if (adjustable.getMaximum() != this._lastMaximum) {
            if ((adjustable.getValue() + adjustable.getVisibleAmount()) + adjustable.getUnitIncrement() >= this._lastMaximum) {
                adjustable.setValue(adjustable.getMaximum());
            }
            this._lastMaximum = maximum;
        }
    }
}
