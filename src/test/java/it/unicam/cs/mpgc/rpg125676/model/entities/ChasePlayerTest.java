package it.unicam.cs.mpgc.rpg125676.model.entities;


import it.unicam.cs.mpgc.rpg125676.model.entities.Explorer;
import it.unicam.cs.mpgc.rpg125676.model.entities.Ghost;
import it.unicam.cs.mpgc.rpg125676.model.entities.Player;
import it.unicam.cs.mpgc.rpg125676.model.entities.Statistics;
import it.unicam.cs.mpgc.rpg125676.model.entities.strategies.ChasePlayer;
import it.unicam.cs.mpgc.rpg125676.model.setting.Position;
import it.unicam.cs.mpgc.rpg125676.model.entities.strategies.EnemyStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class ChasePlayerTest {

        @Test
        void movesHorizontallyWhenXDistanceBigger() {
            EnemyStrategy strategy = new ChasePlayer();
            Enemy ghost = new Ghost(new Position(0, 0), 2, strategy);
            Player explorer = new Explorer(new Position(5, 1), 1, new Statistics(10, 5, 5));
            Position nextPos = strategy.getNextPosition(ghost, explorer);

            assertEquals(new Position(1, 0), nextPos);
        }

        @Test
        void movesVerticallyWhenYDistanceBigger() {
            EnemyStrategy strategy = new ChasePlayer();
            Enemy ghost= new Ghost(new Position(2, 2), 2, strategy);
            Player explorer = new Explorer(new Position(2, 6), 1, new Statistics(10, 5, 5));
            Position nextPos = strategy.getNextPosition(ghost, explorer);

            assertEquals(new Position(2, 3), nextPos);
        }

        @Test
        void noMovementWhenAlreadyOnPlayer() {
            EnemyStrategy strategy = new ChasePlayer();
            Enemy ghost = new Ghost(new Position(3, 3), 2, strategy);
            Player explorer = new Explorer(new Position(3, 3), 1, new Statistics(10, 5, 5));
            Position nextPos = strategy.getNextPosition(ghost, explorer);

            assertEquals(new Position(3, 3), nextPos);
        }
    }

