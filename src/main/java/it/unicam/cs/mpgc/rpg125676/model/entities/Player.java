package it.unicam.cs.mpgc.rpg125676.model.entities;


/**
 * This class represents an individual who is characterized by attributes and is capable of moving and taking action on the grid;
 * it keeps track of its attributes, that represent its vital and performance metrics {@link Statistics},
 * as well as the number of found keys and the number of steps taken.
 */

public abstract class Player extends Entity implements Movable, Affectable {
    private final Statistics statistics;
    private int stepsTaken;

    /**
     * Creates a new player given a position, an id and its initial attributes' values
     * @param position      current position on the grid
     * @param id            unique identifier
     * @param stats         starting values of player attributes
     * @throws NullPointerException if {@code position} or {@code statistics} are null.
     */
    public Player(Position position, int id, Statistics stats){
        super(position, id);
        if (stats == null){
            throw new NullPointerException("Statitics can't be null");
        }
        this.statistics = stats;
        this.stepsTaken = 0;
    }

    public Statistics getStats() {
        return this.statistics;
    }


    public int getStepsTaken() {
        return this.stepsTaken;
    }

    /**
     * Moves the player on the grid to a given position and increases the steps counter
     * @param newPos    new position to move to
     * @throws NullPointerException if {@code newPos} is null
     */
    public void moveTo(Position newPos){
        setPosition(newPos);
        this.stepsTaken++;
    }

    /**
     * Applies a penalty or damage to a specific character statistic.
     *
     * @param stat   the statistic to reduce
     * @param amount positive amount to subtract
     */
    public void applyPenalty(StatisticType stat, int amount) {
        if (stat == null) { throw new NullPointerException("Stat can't be null."); }
        if (amount < 0) throw new IllegalArgumentException("Penalty cannot be negative.");

        switch (stat) {
            case SANITY -> this.statistics.modifySanity(-amount);
            case STRENGTH -> this.statistics.modifyStrength(-amount);
            case SPEED -> this.statistics.modifySpeed(-amount);
        }
    }

    /**
     * Claims the death of the player due to the zeroing of its Sanity.
     * @return {@code true} if the player's Sanity is less or equal to 0.
     */
    public boolean isDead() {
        return this.statistics.getSanity() <= 0;
    }

    /**
     * Increases a specific character statistic.
     *
     * @param stat   the statistic to increase
     * @param amount positive amount to add
     */
    public void restoreStat(StatisticType stat, int amount) {
        if (stat == null) { throw new NullPointerException("Stat can't be null."); }
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative.");

        switch (stat) {
            case SANITY -> this.statistics.modifySanity(amount);
            case STRENGTH -> this.statistics.modifyStrength(amount);
            case SPEED -> this.statistics.modifySpeed(amount);
        }
    }

    /**
     * Resets the steps counter after the hauting phase is over.
     */
    public void resetStepsTaken() {
        this.stepsTaken = 0;
    }

}
