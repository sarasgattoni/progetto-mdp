package it.unicam.cs.mpgc.model.entities;
import java.io.Serializable;

/**
 * This class represents any active element that occupies a position on the grid.
 * An entity is characterized by its position on the grid and a fixed numeric id,
 * which identifies it; an entity is equal to another only if they share the same id.
 */

public abstract class Entity implements Serializable {
    private Position position;
    private final int id;

    protected Entity(Position position, int id){
        if (position == null) {
            throw new NullPointerException("Position can't be null");
        }
        this.position = position;
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public Position getPosition(){
        return this.position;
    }
    protected void setPosition(Position position){
        if (position == null) {
            throw new NullPointerException("Position can't be null");
        }
        this.position = position;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity other = (Entity) o;
        return this.id == other.id;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(this.id);
    }
}
