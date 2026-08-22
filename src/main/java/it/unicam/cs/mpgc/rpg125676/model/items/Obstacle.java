package it.unicam.cs.mpgc.rpg125676.model.items;

import it.unicam.cs.mpgc.rpg125676.model.entities.Player;
import it.unicam.cs.mpgc.rpg125676.model.entities.StatisticType;

/**
 * This class represents any item that can be found in a room that affects the player by
 * decreasing one or more of its statistics. The application of the penalty is paired with a
 * dice roll to determine whether it will decrease a statistic or not when encountered.
 */
public enum Obstacle implements RoomElement{
    LOCKED_DOOR {
        @Override
        public void interact(Player p) {
            if (rollDice() < 4) p.applyPenalty(StatisticType.STRENGTH, 1);
        }
    },
    POISON_GAS {
        @Override
        public void interact(Player p) {
            if (rollDice() < 4) p.applyPenalty(StatisticType.SANITY, 1);
        }
    },
    FOG {
        @Override
        public void interact(Player p) {
            p.applyPenalty(StatisticType.SPEED, 1);
        }
    };

    @Override
    public boolean isConsumable() {
        return false;
    }

    protected int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
