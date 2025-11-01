# Snake Game (Java)

Simple Snake game implemented with Java Swing.

## Overview
This repository contains a small Swing-based Snake game. It's intentionally compact so you can read and modify it easily.

Files:
- `SnakeGame.java` — main class that creates the application window and starts the game.
- `board.java` — game logic and rendering (Board class). Note: the file is currently named `board.java` to match your workspace; the Board class in that file is package-visible.

## Requirements
- Java JDK 8 or newer installed and `javac`/`java` available on PATH.

## Build & Run (PowerShell)
Open PowerShell and run:

```powershell
cd "c:\Users\sarik\OneDrive\Desktop\snake game (java)"
javac *.java
java SnakeGame
```

If compilation completes successfully the game window should appear.

## Controls
- Arrow keys: move the snake (Left, Right, Up, Down)

## Gameplay
- Eat the red apple to grow the snake.
- Colliding with the walls or with the snake's own body ends the game and displays "Game Over".

## Notes & Troubleshooting
- If you see warnings about `serialVersionUID`, they are harmless for this small Swing app. You can silence them by adding a `private static final long serialVersionUID = 1L;` to the `JFrame`/`JPanel` classes.
- There is a small compiler warning about accessing an auxiliary class; if you want to remove it, rename `board.java` to `Board.java` (case-sensitive filenames can be tricky on Windows). If you'd like, I can perform this rename safely for you.

## Extensions (suggested)
- Show score on the screen and add a restart button or key.
- Make the game speed up slightly as the snake grows.
- Add levels or obstacles.
- Add sound effects or better graphics for the snake/apple.

## License
Use freely for learning and small projects.

---
For more details about the code structure and how the main classes work, see `CODE_DOC.md`.
