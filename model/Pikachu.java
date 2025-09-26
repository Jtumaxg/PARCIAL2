package model;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu", "⚡", 100);
        initAttacks();
    }

    @Override
    public void initAttacks() {
        attacks.add(new Attack("Placaje", 95, 10, Type.NORMAL));
        attacks.add(new Attack("Impactrueno", 85, 20, Type.ELECTRIC));
    }
}