package it.unicam.cs.mpgc.rpg125676.model.entities.strategies;

import it.unicam.cs.mpgc.rpg125676.model.entities.Enemy;
import it.unicam.cs.mpgc.rpg125676.model.entities.Player;

/**
 * Represents the behavior that moves the enemy one step closer to the player, calculating the minimun path to the target.
 */
public class ChasePlayer implements EnemyStrategy{
    @Override
    public Position getNextPosition(Enemy enemy, Player player) {
        Position enemyPos = enemy.getPosition();
        Position playerPos = player.getPosition();

        int dx = playerPos.getX() - enemyPos.getX();
        int dy = playerPos.getY() - enemyPos.getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            return new Position(enemyPos.getX() + Integer.signum(dx), enemyPos.getY());
        } else if (dy != 0) {
            return new Position(enemyPos.getX(), enemyPos.getY() + Integer.signum(dy));
        }
        return enemyPos;
    }
}
