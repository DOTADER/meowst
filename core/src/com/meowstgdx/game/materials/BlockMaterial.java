package com.meowstgdx.game.materials;

public enum BlockMaterial {
    WOOD("wood", 1),
    FLINT("flint", 2),
    STONE("stone", 3),
    BRASS("brass", 4),
    IRON("iron", 5),
    TITANIUM("titanium", 8);

    private String displayName;
    private int durability;

    BlockMaterial(String name, int durability) {
        this.displayName = name;
        this.durability = durability;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getDurability() {
        return durability;
    }
}
