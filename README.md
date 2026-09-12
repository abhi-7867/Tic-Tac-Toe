# 🎮 Premium Tic-Tac-Toe Game

A beautifully designed, feature-rich Tic-Tac-Toe game built with Java, featuring a modern command-line interface with colors, statistics tracking, and multiple rounds support.

## ✨ Features

### Core Gameplay
- **Two-Player Mode**: Classic X vs O gameplay
- **Interactive Board**: Visual 3x3 grid with numbered positions (1-9)
- **Smart Input Validation**: Prevents invalid moves and handles errors gracefully
- **Real-Time Win Detection**: Checks for wins after each move
  - Horizontal wins (rows)
  - Vertical wins (columns)
  - Diagonal wins (both directions)

### Premium Features
- 🎨 **Beautiful UI**: Colored ASCII art with box-drawing characters
- 📊 **Statistics Tracking**: Win counts and draw statistics
- 🔄 **Multiple Rounds**: Play as many games as you want
- 📈 **Win Percentage**: Calculates winning percentages
- 🏆 **Overall Winner**: Determines the champion at the end
- 📖 **Instructions**: Optional tutorial for new players
- 🎯 **Draw Detection**: Automatically detects tie games

### Technical Highlights
- **OOP Design**: Clean, modular class structure
- **Input Handling**: Robust exception handling
- **User Experience**: Clear prompts and messages
- **Code Quality**: Well-commented and documented

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Command line/terminal access

### Running the Game

#### Method 1: Using javac and java commands

```bash
# Compile the Java files
javac Main.java TicTacToeGame.java

# Run the game
java Main
```

#### Method 2: Using an IDE
1. Open the project in IntelliJ IDEA, Eclipse, or VS Code
2. Run the `Main.java` file
3. Enjoy the game!

## 🎯 How to Play

1. **Start the Game**: Launch the application
2. **View Instructions** (Optional): Say 'y' when prompted for instructions
3. **Make Your Move**: Enter a number from 1-9 to place your symbol
   ```
   1 | 2 | 3
   ---|---|---
   4 | 5 | 6
   ---|---|---
   7 | 8 | 9
   ```
4. **Take Turns**: Players alternate between X and O
5. **Win Conditions**: Get 3 symbols in a row (horizontal, vertical, or diagonal)
6. **Play Again**: After each round, choose to play another game
7. **View Stats**: See your statistics after each round

## 🎨 Game Screenshots

The game features:
- Color-coded player symbols (Red for X, Green for O)
- Beautiful box-drawing menus and borders
- Real-time board display
- Win/loss/draw animations
- Statistical summaries

## 📁 Project Structure

```
Tic-Tac-Toe/
│
├── Main.java              # Main entry point with game loop
├── TicTacToeGame.java     # Core game logic and board management
└── README.md              # Documentation (this file)
```

## 🔧 Code Organization

### `Main.java`
- Entry point of the application
- Manages game rounds and menu system
- Handles user prompts for instructions and replay
- Displays final statistics and overall winner

### `TicTacToeGame.java`
- Game board representation using 2D array
- Move validation and placement
- Win detection (8 possible win conditions)
- Draw detection
- Statistics tracking
- Beautiful UI rendering with ANSI colors

## 🧮 Win Detection Logic

The game checks for wins in:
1. **3 Rows** (top, middle, bottom)
2. **3 Columns** (left, middle, right)
3. **2 Diagonals** (top-left to bottom-right, top-right to bottom-left)

## 📊 Statistics Feature

After each round, the game displays:
- Player X wins
- Player O wins
- Number of draws
- Win percentages
- Overall champion

## 🎓 Educational Value

This project demonstrates:
- **Arrays/Matrices**: 2D array for the game board
- **Loops**: For board display and win checking
- **Conditional Statements**: Move validation and game state checking
- **Object-Oriented Programming**: Clean class separation
- **User Input Handling**: Scanner and exception handling
- **Data Structures**: Efficient game state management

## 🌟 Future Enhancements

Potential improvements:
- AI opponent with difficulty levels
- Network multiplayer support
- GUI version with JavaFX or Swing
- Tournament mode with brackets
- Player names and profiles
- Move history/undo feature
- Different board sizes (4x4, 5x5)

## 📝 License

This project is open source and available for educational purposes.

## 👨‍💻 Author

Created as a premium Java programming project demonstrating core Java concepts with modern design principles.

---

**Enjoy playing and happy coding! 🎉**

