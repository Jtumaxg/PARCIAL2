package model;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur", "🌱", 100);
        initAttacks();
    }

    @Override
    public void initAttacks() {
        attacks.add(new Attack("Placaje", 95, 10, Type.NORMAL));
        attacks.add(new Attack("Hoja Afilada", 85, 20, Type.GRASS));
    }
}