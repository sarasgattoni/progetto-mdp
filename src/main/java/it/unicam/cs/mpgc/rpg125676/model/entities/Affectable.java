package it.unicam.cs.mpgc.rpg125676.model.entities;

/**
 * Represents any entity that can be subjected to alterations of its attributes.
 */
public interface Affectable {
    /**
     * Applies a penalty or damage to a specific statistic.
     *
     * @param stat   the statistic to reduce
     * @param amount positive amount to subtract
     */
    void applyPenalty(StatisticType stat, int amount);

    /**
     * Increases or restores a specific statistic.
     *
     * @param stat   the statistic to increase
     * @param amount positive amount to add
     */
    void restoreStat(StatisticType stat, int amount);

    /**
     * Claims the death of the player due to the zeroing of its Sanity.
     *
     * @return true if the entity is considered dead, false otherwise
     */
    boolean isDead();
}

