package it.unicam.cs.mpgc.rpg125676.model.entities;

/**
 * This class represents the three attributes that each player owns throughout the game; each one has a range.
 */
public class Statistics {
    private int sanity;
    private int speed;
    private int strength;

    /**
     * Initializes starting attributes and sets the ranges.
     * @param sanity  current life span of player
     * @param strength current power of player
     * @param speed    current number of rooms a player can cross before the ghost gets closer during haunting phase
     * @throws IllegalArgumentException if sanity value is not whithin range.
     * @throws IllegalArgumentException if speed value is not whithin range.
     * @throws IllegalArgumentException if strength value is not whithin range.
     */
    public Statistics(int sanity, int strength, int speed) {
        if (sanity < 0 || sanity > 10) {
            throw new IllegalArgumentException("Sanity must be between 0 and 10.");
        }
        if (speed < 1 || speed > 10) {
            throw new IllegalArgumentException("Speed must be between 1 and 10.");
        }
        if (strength < 0 || strength > 10) {
            throw new IllegalArgumentException("Strength must be between 0 and 10.");
        }
        this.sanity = clamp(sanity, 0, 10);
        this.strength = clamp(strength, 0, 10);
        this.speed = clamp(speed, 1, 10);
    }

    public int getSanity() {
        return this.sanity;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getStrength() {
        return this.strength;
    }

    /**
     * Modifies sanity and makes sure it stays whithin the range.
     */
    public void modifySanity(int amount) {
        this.sanity = clamp(this.sanity + amount, 0, 10);
    }

    /**
     * Modifies speed and makes sure it stays whithin the range.
     */
    public void modifySpeed(int amount) {
        this.speed = clamp(this.speed + amount, 1, 10);
    }

    /**
     * Modifies strength and makes sure it stays whithin the range.
     */
    public void modifyStrength(int amount) {
        this.strength = clamp(this.strength + amount, 0, 10);
    }

    /**
     * Applies range to a value.
     */
    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

}
