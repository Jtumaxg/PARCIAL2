package model;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", "💧", 100);
        initAttacks();
    }

    @Override
    public void initAttacks() {
        attacks.add(new Attack("Placaje", 95, 10, Type.NORMAL));
        attacks.add(new Attack("Pistola Agua", 85, 20, Type.WATER));
    }
}