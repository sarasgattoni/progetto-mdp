package it.unicam.cs.mpgc.rpg125676.model.setting;
/**
 * This class represents the four cardinal directions for movement on the grid.
 * Each direction is associated with a specific variation (delta) on the X and Y axes,
 * for calculation of adjacent positions.
 */
public enum Direction {
    /** Movement upwards (decreases the Y-coordinate by 1). */
    UP(0, -1),
    /** Movement downwards (increases the Y-coordinate by 1). */
    DOWN(0, 1),
    /** Movement to the left (decreases the X-coordinate by 1). */
    LEFT(-1, 0),
    /** Movement to the right (increases the X-coordinate by 1). */
    RIGHT(1, 0);

    private final int dirx;
    private final int diry;

    /**
     * Associates a direction with its coordinate variations.
     *
     * @param dirx the variation on the X-axis
     * @param diry the variation on the Y-axis
     */
    Direction(int dirx, int diry) {
        this.dirx = dirx;
        this.diry = diry;
    }

    public int getDirx() {return this.dirx;}
    public int getDiry() {return this.diry;}
}
