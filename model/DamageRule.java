package model;

@FunctionalInterface
public interface DamageRule {
    int calculate(int basePower);
}

