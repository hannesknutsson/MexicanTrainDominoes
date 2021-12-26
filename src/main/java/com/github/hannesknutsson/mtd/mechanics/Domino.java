package com.github.hannesknutsson.mtd.mechanics;

public class Domino {

    public final int value1;
    public final int value2;

    protected Domino(final int value1, final int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public boolean hasValue(final int value) {
        return value1 == value || value2 == value;
    }

    public int getOtherValue(final int notThisValue) {
        final int requestedValue;
        if (this.value1 == notThisValue) {
            requestedValue = this.value2;
        } else {
            requestedValue = this.value1;
        }
        return requestedValue;
    }

    public boolean isBlocker() {
        return value1 == value2;
    }
}
