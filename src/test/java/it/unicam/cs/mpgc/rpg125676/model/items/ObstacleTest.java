package it.unicam.cs.mpgc.rpg125676.model.items;

import it.unicam.cs.mpgc.rpg125676.model.entities.Explorer;
import it.unicam.cs.mpgc.rpg125676.model.entities.Player;
import it.unicam.cs.mpgc.rpg125676.model.entities.Statistics;
import it.unicam.cs.mpgc.rpg125676.model.setting.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {
    @Test
    void fogDecreasesSpeed() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        Obstacle.FOG.interact(p);
        assertEquals(4, p.getStats().getSpeed());
    }
    @Test
    void isConsumable() {
        assertFalse(Obstacle.LOCKED_DOOR.isConsumable());
        assertFalse(Obstacle.POISON_GAS.isConsumable());
        assertFalse(Obstacle.FOG.isConsumable());
    }

}