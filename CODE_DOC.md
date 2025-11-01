Snake Game — Code Documentation

This document describes the code layout, main classes, and where to change behavior.

Files and responsibilities

- SnakeGame.java
  - Public class `SnakeGame` extends `JFrame`.
  - Responsibilities:
    - Creates the main application window.
    - Adds the `Board` panel to the frame.
    - Calls `pack()` and sets up default close behavior.
  - Main method: `public static void main(String[] args)` — launches the GUI via `SwingUtilities.invokeLater`.

- board.java
  - Contains the `Board` class (package-visible) which extends `JPanel` and implements `ActionListener`.
  - Key responsibilities:
    - Hold game state (snake coordinates, apple position, direction flags).
    - Implement game loop via a Swing `Timer` (fires every `DELAY` ms).
    - Handle keyboard input via an inner `KeyAdapter` (class `TAdapter`).
    - Paint the snake and apple in `paintComponent` -> `doDrawing`.
    - Collision detection and apple relocation.

Board class: important fields
- B_WIDTH, B_HEIGHT: game area size in pixels.
- DOT_SIZE: size of each snake segment and apple (pixels).
- ALL_DOTS: maximum number of dots (snake length).
- DELAY: timer delay (ms) — change to make the game faster/slower.
- x[], y[]: arrays storing pixel coordinates of each snake segment.
- dots: current snake length.
- apple_x, apple_y: apple coordinates.
- Direction booleans: leftDirection, rightDirection, upDirection, downDirection.
- inGame: game running flag.
- Timer timer: Swing timer controlling the game loop.

Board class: important methods
- initBoard(): sets background color, focusability, preferred size, registers key listener, and initializes the game.
- initGame(): sets initial snake size/positions and starts the timer.
- locateApple(): randomly places the apple on the grid (aligned to DOT_SIZE).
- move(): shift snake segment coordinates and update head position according to the current direction.
- checkApple(): checks if head is on apple; if so, increments `dots` and relocates apple.
- checkCollision(): checks self-collision and wall collision; stops timer and sets `inGame=false` on collision.
- paintComponent(Graphics): Swing painting entry-point — calls `doDrawing` which paints apple and snake or the "Game Over" message.
- actionPerformed(ActionEvent): called by the timer; updates game state each tick and repaints.

Key handling
- The `TAdapter` inner class listens for arrow keys and updates direction flags.
- The logic prevents reversing directly into the opposite direction (e.g., you can't go left if moving right).

How to change game behavior
- Grid size and visuals:
  - To change cell size, edit `DOT_SIZE` and adjust `B_WIDTH`/`B_HEIGHT` accordingly.
- Speed:
  - Change `DELAY` in the `Board` class (smaller delay = faster game).
  - Alternatively, change the delay dynamically as the snake grows to increase difficulty.
- Starting length:
  - Modify `dots` in `initGame()`.

Suggested improvements (small code changes)
- Add score display: keep a `score` field, increment when apple is eaten, and draw it in `doDrawing`.
- Add restart: detect a key (e.g., `R` or `SPACE`) when `inGame == false` and call a `reset()` method to reinitialize state and restart the timer.
- Move the Board to its own file named `Board.java` (case-matching the public class) to reduce compiler warnings and align with Java conventions. On Windows this requires deleting `board.java` and creating `Board.java`.
- Add `serialVersionUID` constants to `JFrame`/`JPanel` subclasses to silence serialization warnings.

Edge cases and behavior notes
- Apple placement currently does not check for being placed on top of the snake; you may want to modify `locateApple()` to re-roll positions until it finds one not overlapping the snake.
- The `checkCollision()` scans from `dots` down to 0 and ignores collisions with small `z <= 4` to avoid false positives when snake is short.

If you want, I can:
- Rename `board.java` to `Board.java` to match Java conventions.
- Add a score display and a restart key.
- Implement apple-placement to avoid spawning on the snake.

