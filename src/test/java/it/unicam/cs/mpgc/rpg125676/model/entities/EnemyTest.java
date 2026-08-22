package it.unicam.cs.mpgc.rpg125676.model.entities;
import it.unicam.cs.mpgc.rpg125676.model.entities.strategies.ChasePlayer;
import it.unicam.cs.mpgc.rpg125676.model.entities.strategies.EnemyStrategy;
import it.unicam.cs.mpgc.rpg125676.model.setting.Position;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void constructorThrowsExceptionOnNullStrategy() {
        assertThrows(NullPointerException.class,
                () -> new Ghost(new Position(0, 0), 2, null)
        );
    }

    @Test
    void moveTo() {
        Ghost ghost = new Ghost(new Position(0, 0), 2, new ChasePlayer());
        Position newPos = new Position(3, 4);
        ghost.moveTo(newPos);
        assertEquals(newPos, ghost.getPosition());
    }

    @Test
    void setStrategy() {
        Ghost ghost = new Ghost(new Position(0, 0), 2, new ChasePlayer());
        EnemyStrategy newStrategy = (enemy, player) -> new Position(1, 1);
        ghost.setStrategy(newStrategy);
        assertEquals(newStrategy, ghost.getStrategy());
    }

    @Test
    void setStrategyThrowsExceptionOnNull() {
        Ghost ghost = new Ghost(new Position(0, 0), 2, new ChasePlayer());

        assertThrows(NullPointerException.class, () -> ghost.setStrategy(null));
    }
}