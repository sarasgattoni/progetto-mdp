package it.unicam.cs.mpgc.model.entities;

/**
 * Represents any entity that can move throughout the grid.
 */
public interface Movable {
    void moveTo(Position position);
    Position getPosition();
}
