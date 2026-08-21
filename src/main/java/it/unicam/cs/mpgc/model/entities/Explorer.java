package it.unicam.cs.mpgc.model.entities;

/**
 * This class represents a concrete implementation of the explorer protagonist of the game.
 */
public class Explorer extends Player {
    private static final int BASE_SANITY = 8;
    private static final int BASE_STRENGTH = 5;
    private static final int BASE_SPEED = 2;

    /**
            * Creates a new Explorer instance.
            *
            * @param position starting position on the grid
            * @param id       unique identifier
            * @param stats    initial attributes
     */

    public Explorer(Position position, int id, Statistics stats) {
        super(position, id, new Statistics(BASE_SANITY, BASE_STRENGTH, BASE_SPEED));
    }
}
