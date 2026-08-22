package it.unicam.cs.mpgc.rpg125676.model.items;

import it.unicam.cs.mpgc.rpg125676.model.entities.Player;
import it.unicam.cs.mpgc.rpg125676.model.entities.StatisticType;

/**
 * This class represents any item that can be found in a room that affects the player by
 * increasing one or more of its statistics.
 */
public enum HealingItem implements RoomElement{
    HEALING_POTION{
        @Override
        public void interact(Player p){p.restoreStat(StatisticType.SANITY,1);};
    },
    ENERGY_ELIXIR {
        @Override
        public void interact(Player p) { p.restoreStat(StatisticType.STRENGTH, 1); }
    },
    SPEED_AMULET {
        @Override
        public void interact(Player p) { p.restoreStat(StatisticType.SPEED, 1); }
    },
    UNIVERSAL_POTION {
        @Override
        public void interact(Player p) {
            p.restoreStat(StatisticType.SANITY, 1);
            p.restoreStat(StatisticType.STRENGTH, 1);
            p.restoreStat(StatisticType.SPEED, 1);
        }
    };
    @Override
    public boolean isConsumable() {
        if(this == SPEED_AMULET){return false;}
        return true;
    }


}
