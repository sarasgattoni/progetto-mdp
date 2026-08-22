package it.unicam.cs.mpgc.rpg125676.model.items;

import it.unicam.cs.mpgc.rpg125676.model.entities.Explorer;
import it.unicam.cs.mpgc.rpg125676.model.entities.Player;
import it.unicam.cs.mpgc.rpg125676.model.entities.Statistics;
import it.unicam.cs.mpgc.rpg125676.model.setting.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealingItemTest {

    @Test
    void healingPotionIncreasesSanity() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(5, 5, 5));
        HealingItem.HEALING_POTION.interact(p);
        assertEquals(6, p.getStats().getSanity());
    }

    @Test
    void energyElixirIncreasesStrength() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(5, 5, 5));
        HealingItem.ENERGY_ELIXIR.interact(p);
        assertEquals(6, p.getStats().getStrength());
    }

    @Test
    void speedAmuletIncreasesSpeed() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(5, 5, 5));
        HealingItem.SPEED_AMULET.interact(p);
        assertEquals(6, p.getStats().getSpeed());
    }

    @Test
    void universalPotionIncreasesAllStats() {
        Player p = new Explorer(new Position(0, 0), 1, new Statistics(5, 5, 5));
        HealingItem.UNIVERSAL_POTION.interact(p);

        assertEquals(6, p.getStats().getSanity());
        assertEquals(6, p.getStats().getStrength());
        assertEquals(6, p.getStats().getSpeed());
    }

    @Test
    void resourcesAreConsumable() {
        assertTrue(HealingItem.HEALING_POTION.isConsumable());
        assertTrue(HealingItem.UNIVERSAL_POTION.isConsumable());
        assertTrue(HealingItem.ENERGY_ELIXIR.isConsumable());
        assertFalse(HealingItem.SPEED_AMULET.isConsumable());
    }
}