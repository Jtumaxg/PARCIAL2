package model;

public class Attack {
    private String name;
    private int accuracy;
    private int power;
    private Type type;

    public Attack(String name, int accuracy, int power, Type type) {
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
        this.type = type;
    }

    public String getName() { return name; }
    public int getAccuracy() { return accuracy; }
    public int getPower() { return power; }
    public Type getType() { return type; }
}

