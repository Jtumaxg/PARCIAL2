package model;

public class Charmander extends Pokemon {
    public Charmander() {
        super("Charmander", "🔥", 100);
        initAttacks();
    }

    @Override
    public void initAttacks() {
        attacks.add(new Attack("Arañazo", 90, 10, Type.NORMAL));
        attacks.add(new Attack("Ascuas", 80, 20, Type.FIRE));
    }
}