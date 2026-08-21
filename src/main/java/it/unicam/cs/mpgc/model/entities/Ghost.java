package it.unicam.cs.mpgc.model.entities;

import it.unicam.cs.mpgc.model.strategies.EnemyStrategy;

/**
 * This class represents the spectral presence hunting the player during the haunting phase.
 */
public class Ghost extends Enemy {

    public Ghost(Position position, int id, EnemyStrategy strategy) {
        super(position, id, strategy);
    }
}
