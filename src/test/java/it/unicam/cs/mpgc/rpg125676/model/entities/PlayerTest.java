package it.unicam.cs.mpgc.rpg125676.model.entities;

import it.unicam.cs.mpgc.rpg125676.model.setting.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void moveTo() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        Position destination = new Position(1, 1);

        p.moveTo(destination);

        assertEquals(destination, p.getPosition());
        assertEquals(1, p.getStepsTaken());
    }

    @Test
    void applyPenalty() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        p.applyPenalty(StatisticType.SANITY, 3);
        p.applyPenalty(StatisticType.STRENGTH, 2);
        p.applyPenalty(StatisticType.SPEED, 1);

        assertEquals(7, p.getStats().getSanity());
        assertEquals(3, p.getStats().getStrength());
        assertEquals(4, p.getStats().getSpeed());

    }

    @Test
    void isDead() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        p.applyPenalty(StatisticType.SANITY, 10);

        assertEquals(0, p.getStats().getSanity());
        assertTrue(p.isDead());
    }

    @Test
    void restoreStat() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(5, 5, 5));
        p.restoreStat(StatisticType.SANITY, 3);
        p.restoreStat(StatisticType.STRENGTH, 2);
        p.restoreStat(StatisticType.SPEED, 1);

        assertEquals(8, p.getStats().getSanity());
        assertEquals(7, p.getStats().getStrength());
        assertEquals(6, p.getStats().getSpeed());

    }

    @Test
    void applyPenaltyNullStatThrowsException() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));

        assertThrows(NullPointerException.class, () -> p.applyPenalty(null, 3));
    }

    @Test
    void restoreStatNullStatThrowsException() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));

        assertThrows(NullPointerException.class, () -> p.restoreStat(null, 3));
    }

    @Test
    void resetStepsTaken() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        p.moveTo(new Position(1, 0));
        p.moveTo(new Position(2, 0));
        assertEquals(2, p.getStepsTaken());

        p.resetStepsTaken();
        assertEquals(0, p.getStepsTaken());
    }
}
