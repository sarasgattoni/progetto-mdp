package it.unicam.cs.mpgc.rpg125676.model.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    @Test
    void constructorThrowsExceptionForInvalidRanges() {
        assertThrows(IllegalArgumentException.class, () -> new Statistics(10, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Statistics(10, 11, 5));
        assertThrows(IllegalArgumentException.class, () -> new Statistics(-1, 5, 5));
    }

    @Test
    void modifySanity() {
        Statistics stats = new Statistics(5, 5, 5);
        stats.modifySanity(3);
        assertEquals(8, stats.getSanity());
        stats.modifySanity(5);
        assertEquals(10, stats.getSanity());
        stats.modifySanity(-15);
        assertEquals(0, stats.getSanity());
    }

    @Test
    void modifySpeed() {
        Statistics stats = new Statistics(5, 5, 5);
        stats.modifySpeed(3);
        assertEquals(8, stats.getSpeed());
        stats.modifySpeed(5);
        assertEquals(10, stats.getSpeed());
        stats.modifySpeed(-15);
        assertEquals(1, stats.getSpeed());
    }

    @Test
    void modifyStrength() {
        Statistics stats = new Statistics(5, 5, 5);
        stats.modifyStrength(3);
        assertEquals(8, stats.getStrength());
        stats.modifyStrength(5);
        assertEquals(10, stats.getStrength());
        stats.modifyStrength(-15);
        assertEquals(0, stats.getStrength());
    }
}