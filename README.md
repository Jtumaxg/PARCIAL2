# 🕹️ Emulador de Batalla "POKEMON"

Bienvenido al **Simulador de batalla Pokemon**, un pequeño emulador del clásico juego de Pokémon, desarrollado como ejercicio práctico para el segundo parcial de programación. En este simulador, el jugador elige un Pokémon inicial y se enfrenta al ordenador en una batalla por turnos.

---

## 📌 Descripción del Juego

Este proyecto simula una batalla Pokémon entre un jugador y la computadora. Al iniciar el juego:

1. El jugador ingresa su nombre.
2. Se le presentan 4 Pokémon iniciales clásicos para elegir: Pikachu, Charmander, Bulbasaur y Squirtle.
3. La computadora elige automáticamente uno de los otros Pokémon disponibles.
4. Ambos combatientes tienen una cantidad de **HP (puntos de vida)** que se reduce con cada ataque.
5. Cada Pokémon posee **dos ataques únicos**, con distintos niveles de daño.
6. La batalla termina cuando:
    - Uno de los dos se queda sin HP (gana el otro).
    - Ambos Pokémon se quedan sin HP al mismo tiempo (empate).
7. Al final de la batalla se muestra un **resumen detallado de los ataques utilizados y el daño causado**.

---

## 📁 Estructura de Carpetas

La estructura del proyecto sigue un diseño modular y organizado en paquetes:

```plaintext
src/
└── main/
    └── java/
        ├── exceptions/        # Excepciones personalizadas del juego
        │   ├── AttackMissedException
        │   └── InvalidChoiceException
        │
        ├── game/              # Lógica principal del juego y el motor de batalla
        │   ├── Battle.java
        │   └── Game.java
        │
        └── model/             # Modelos del juego (Pokémon, ataques, tipos, reglas)
            ├── Attack.java
            ├── Bulbasaur.java
            ├── Charmander.java
            ├── DamageRule.java
            ├── Pikachu.java
            ├── Pokemon.java
            ├── Squirtle.java
            └── Type.java
```

### 🔍 Breve Explicación del Diseño

- **`exceptions/`**: Contiene excepciones personalizadas que controlan errores como ataques fallidos o elecciones inválidas.
- **`game/`**: Aquí se encuentra la lógica central del juego.
- **`model/`**: Contiene clases que representan los Pokémon, ataques, tipos y lógica de daño.


---

## 🛠️ Tecnologías Usadas

- Java 
- Programación orientada a objetos
- Manejo de excepciones

---

## 🚀 Cómo Jugar

1. Ejecuta la clase `Game`.
2. Ingresa tu nombre.
3. Elige tu Pokémon inicial.
4. ¡Comienza la batalla!

El juego te informará en cada turno del estado actual de los HP, los ataques utilizados y los efectos de los mismos.

---

## ✍️ Autor

Desarrollado por **José Alexander Tumax García** como proyecto para el segundo parcial de programación.

---



