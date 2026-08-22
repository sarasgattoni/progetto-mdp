package it.unicam.cs.mpgc.rpg125676.model.setting;

import java.io.Serializable;

import static java.util.Objects.hash;

/**
 * This class represents an immutable coordinate on the grid.
 */
public class Position implements Serializable {
    private final int x;
    private final int y;

    /**
     * Constructs a new Position with the specified coordinates.
     *
     * @param x the coordinate on the X-axis (horizontal)
     * @param y the coordinate on the Y-axis (vertical)
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}

    /**
     * Compares this position to the specified object.
     * The result is {@code true} only if the argument is a {@code Position}
     * object that has the exact same X and Y coordinates as this object.
     *
     * @param o the object to compare this position against
     * @return {@code true} if the given object represents a Position equivalent to this one, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position other)) return false;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return hash(this.x, this.y);
    }

}
