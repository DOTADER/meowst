package com.meowstgdx.game.materials;

public enum ToolMaterial {
    WOOD("wood", "brown", 1, 0.4f, 4),
    FLINT("flint", "black", 2, 0.8f, 8),
    STONE("stone", "darkGray", 3, 1.6f, 16),
    BRASS("brass", "darkGold", 4, 2.4f, 24),
    IRON("iron", "white", 5, 3.2f, 32),
    TITANIUM("titanium", "lightGray", 8, 6.4f, 64);

    private String displayName;
    private String color;
    private int durability;
    private float miningSpeed;
    private int damage;

    ToolMaterial(String name, String color, int durability, float miningSpeed, int damage) {
        this.displayName = name;
        this.color = color;
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
