package com.github.hannesknutsson.mtd.mechanics.bricks;

public class Domino {

    public final int value1;
    public final int value2;

    public Domino(final int value1, final int value2) {
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

    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Domino otherBrick = (Domino) o;
        // field comparison
        final boolean bricksAreEqual = value1 == otherBrick.value1 && value2 == otherBrick.value2 || value1 == otherBrick.value2 && value2 == otherBrick.value1;
        return bricksAreEqual;
    }

    public String toString() {
        return "[" + value1 + "|" + value2 + "]";
    }
}
