package it.unicam.cs.mpgc.rpg125676.model.entities;
import it.unicam.cs.mpgc.rpg125676.model.setting.Position;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    @Test
    void testEqualsSameId() {
        Entity e1 = new Explorer(new Position(0, 0), 1, new Statistics(10, 5, 5));
        Entity e2 = new Explorer(new Position(5, 5), 1, new Statistics(10, 5, 5));
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }
    @Test
    void testEqualsDifferentId() {
        Entity e1 = new Explorer(new Position(0, 0), 1,new Statistics(10, 5, 5));
        Entity e2 = new Explorer(new Position(0, 0), 2, new Statistics(10, 5, 5));
        assertNotEquals(e1, e2);
    }
    @Test
    void constructorThrowsExceptionOnNullPosition() {
        assertThrows(NullPointerException.class, () -> new Entity(null, 1) {
        });
    }
}