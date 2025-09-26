package game;

import model.*;
import exceptions.*;
import java.util.*;
import java.util.stream.Collectors;

public class Battle {
    private Pokemon player;
    private Pokemon cpu;
    private List<String> log = new ArrayList<>();
    private List<Integer> damages = new ArrayList<>();
    private Random random = new Random();

    public Battle(Pokemon p, Pokemon c) {
        this.player = p;
        this.cpu = c;
    }

    public void start(Scanner sc) {
        System.out.println("\n⚔️ ¡Comienza la batalla entre " + player.getEmoji() + player.getName() +
                " y " + cpu.getEmoji() + cpu.getName() + "! ⚔️");

        while (player.isAlive() && cpu.isAlive()) {
            try {
                playerTurn(sc);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (!cpu.isAlive()) break;

            try {
                cpuTurn();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            showHP();
        }
        announceWinner();
        showSummary();
    }

    private void playerTurn(Scanner sc) throws InvalidChoiceException, AttackMissedException {
        System.out.println("\nTus ataques:");
        List<Attack> sorted = player.getAttacks().stream()
                .sorted(Comparator.comparing(Attack::getPower).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i+1) + ". " + sorted.get(i).getName());
        }
        System.out.print("Elige ataque: ");
        int choice;
        try {
            choice = sc.nextInt() - 1;
        } catch (Exception e) {
            sc.nextLine();
            throw new InvalidChoiceException("❌ Entrada inválida.");
        }
        if (choice < 0 || choice >= sorted.size())
            throw new InvalidChoiceException("❌ Opción fuera de rango.");

        Attack atk = sorted.get(choice);
        executeAttack(player, cpu, atk, "Jugador");
    }

    private void cpuTurn() throws AttackMissedException {
        Attack atk = cpu.getAttacks().get(random.nextInt(cpu.getAttacks().size()));
        executeAttack(cpu, player, atk, "CPU");
    }

    private void executeAttack(Pokemon attacker, Pokemon target, Attack atk, String actor)
            throws AttackMissedException {
        if (random.nextInt(100) >= atk.getAccuracy())
            throw new AttackMissedException(actor + " falló con " + atk.getName() + "!");

        DamageRule rule = base -> {
            if ((atk.getType() == Type.FIRE && target instanceof Bulbasaur) ||
                    (atk.getType() == Type.WATER && target instanceof Charmander) ||
                    (atk.getType() == Type.GRASS && target instanceof Squirtle) ||
                    (atk.getType() == Type.ELECTRIC && target instanceof Squirtle)) {
                return base + 10;
            }
            return base;
        };

        int damage = rule.calculate(atk.getPower());
        target.damage(damage);
        damages.add(damage);
        String msg = actor + " usó " + atk.getName() + " e hizo " + damage + " de daño!";
        log.add(msg);
        System.out.println(msg);
    }

    private void showHP() {
        System.out.println(player.getEmoji() + player.getName() + " HP: " + player.getHp() +
                " | " + cpu.getEmoji() + cpu.getName() + " HP: " + cpu.getHp());
    }

    private void announceWinner() {
        if (!player.isAlive() && !cpu.isAlive())
            System.out.println("😮 ¡Empate!");
        else if (player.isAlive())
            System.out.println("🎉 Ganaste la batalla!");
        else
            System.out.println("💀 Perdiste...");
    }

    private void showSummary() {
        System.out.println("\n📊 Resumen de batalla:");
        log.forEach(System.out::println);

        System.out.println("Top 3 golpes más fuertes:");
        damages.stream().sorted(Comparator.reverseOrder()).limit(3)
                .forEach(d -> System.out.println("- " + d));

        double avg = damages.stream().mapToInt(i -> i).average().orElse(0);
        System.out.println("Promedio de daño: " + avg);

        Map<String, Long> byActor = log.stream()
                .collect(Collectors.groupingBy(s -> s.startsWith("Jugador") ? "Jugador" : "CPU", Collectors.counting()));
        System.out.println("Conteo por Jugador: " + byActor);
    }
}
