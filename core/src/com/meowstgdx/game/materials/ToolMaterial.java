package com.meowstgdx.game.materials;

public enum ToolMaterial {
    WOOD("wood", 1, 0.4f, 4),
    FLINT("flint", 2, 0.8f, 8),
    STONE("stone", 3, 1.6f, 16),
    BRASS("brass", 4, 2.4f, 24),
    IRON("iron", 5, 3.2f, 32),
    TITANIUM("titanium", 8, 6.4f, 64);

    private String displayName;
    private int durability;
    private float miningSpeed;
    private int damage;

    ToolMaterial(String name, int durability, float miningSpeed, int damage) {
        this.displayName = name;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.damage = damage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getDurability() {
        return durability;
    }

    public float getMiningSpeed() {
        return miningSpeed;
    }

    public int getDamage() {
        return damage;
    }
}
