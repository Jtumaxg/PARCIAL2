package model;

import java.util.List;
import java.util.ArrayList;

public abstract class Pokemon {
    protected String name;
    protected String emoji;
    protected int maxHp;
    protected int hp;
    protected List<Attack> attacks = new ArrayList<>();

    public Pokemon(String name, String emoji, int hp) {
        this.name = name;
        this.emoji = emoji;
        this.maxHp = hp;
        this.hp = hp;
    }

    public String getName() { return name; }
    public String getEmoji() { return emoji; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }

    public void damage(int amount) {
        hp = Math.max(0, hp - amount);
    }

    public boolean isAlive() { return hp > 0; }

    public List<Attack> getAttacks() { return attacks; }

    public abstract void initAttacks();
}
