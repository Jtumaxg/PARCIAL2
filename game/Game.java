package game;

import model.*;
import exceptions.*;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige tu Pokémon inicial, enfréntate a entrenadores y demuestra tu valía.🎮\n" +
                "¡Que comience la batalla ⚔️!");
        System.out.print("Ingresa tu nombre: ");
        String name = sc.nextLine();

        List<Pokemon> options = List.of(new Charmander(), new Squirtle(), new Bulbasaur(), new Pikachu());
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getEmoji() + " " + options.get(i).getName());
        }

        int choice = -1;
        Pokemon player = null;

        // 🔁 Bucle hasta que elija un Pokémon válido
        while (true) {
            try {
                System.out.print("Elige tu Pokémon: ");
                choice = sc.nextInt() - 1;

                if (choice < 0 || choice >= options.size()) {
                    throw new InvalidChoiceException("Selección inválida!");
                }

                player = options.get(choice);
                break; // ✅ Salir del bucle si todo está bien

            } catch (InvalidChoiceException e) {
                System.out.println("Error: " + e.getMessage() + " Intenta de nuevo.");
                sc.nextLine(); // limpiar buffer
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número. Intenta de nuevo.");
                sc.nextLine(); // limpiar buffer
            }
        }

        // 🔁 Selección de la CPU (diferente del jugador)
        Pokemon cpu;
        Random rnd = new Random();
        do {
            cpu = options.get(rnd.nextInt(options.size()));
        } while (cpu.getClass().equals(player.getClass()));

        System.out.println("\n" + name + " eligió " + player.getEmoji() + " " + player.getName());
        System.out.println("CPU eligió " + cpu.getEmoji() + " " + cpu.getName());

        new Battle(player, cpu).start(sc);
    }
}


