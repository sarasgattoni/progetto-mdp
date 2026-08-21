package it.unicam.cs.mpgc.model.strategies;

import it.unicam.cs.mpgc.model.entities.Enemy;
import it.unicam.cs.mpgc.model.entities.Player;

/**
 * Strategy interface defining how an enemy decides its next move.
 */
public interface EnemyStrategy {
    Position getNextPosition(Enemy enemy, Player player);
}
