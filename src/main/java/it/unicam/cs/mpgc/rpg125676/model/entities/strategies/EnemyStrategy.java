package it.unicam.cs.mpgc.rpg125676.model.entities.strategies;

import it.unicam.cs.mpgc.rpg125676.model.entities.Enemy;
import it.unicam.cs.mpgc.rpg125676.model.entities.Player;

/**
 * Strategy interface defining how an enemy decides its next move.
 */
public interface EnemyStrategy {
    Position getNextPosition(Enemy enemy, Player player);
}
