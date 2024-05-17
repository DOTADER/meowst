package com.meowstgdx.game.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items;
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    public boolean addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }
}
