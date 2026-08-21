package it.unicam.cs.mpgc.rpg125676.model.entities;

import it.unicam.cs.mpgc.rpg125676.model.entities.strategies.EnemyStrategy;

/**
 * This class represents any type of hostile entity present in the house.
 */
public abstract class Enemy extends Entity implements Movable {
    private EnemyStrategy strategy;
    /**
     * Creates a new hostile entity.
     *
     * @param position starting position on the grid
     * @param id       unique identifier
     * @param strategy initial movement strategy
     * @throws NullPointerException if {@code strategy} is nul
     */
    protected Enemy(Position position, int id, EnemyStrategy strategy) {
        super(position, id);
        if (strategy == null) { throw new IllegalArgumentException("Strategy cannot be null."); }
        this.strategy = strategy;
    }

    public void moveTo(Position pos){
        setPosition(pos);
    }

    public EnemyStrategy getStrategy() {
        return this.strategy;
    }
    public void setStrategy(EnemyStrategy strat) {
        if (strat == null) { throw new IllegalArgumentException("Strategy cannot be null."); }
        this.strategy = strat;
    }

}
