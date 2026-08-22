package it.unicam.cs.mpgc.rpg125676.model.items;

import it.unicam.cs.mpgc.rpg125676.model.entities.Player;

/**
 * This interface represents any item that can be found in a room and that can affect the player in some way.
 */
public interface RoomElement {
    /**
     * Affects the player or its attributes in some way.
     * @param player  the player affected
     */
    void interact(Player player);

    /**
     * @return true if the item disappears after use, false if it stays.
     */
    boolean isConsumable();

}
