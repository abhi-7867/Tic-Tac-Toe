# 🚀 Quick Start Guide - Premium Tic-Tac-Toe

## ⚡ 30-Second Setup

### Step 1: Compile
```bash
javac Main.java TicTacToeGame.java
```

### Step 2: Run
```bash
java Main
```

**That's it!** The game is ready to play.

---

## 🎮 How to Play (For Beginners)

### Goal
Get 3 of your symbols in a row (horizontal, vertical, or diagonal) before your opponent.

### Controls
- **Enter a number 1-9** to place your symbol
- Look at the board layout:
  ```
  1 | 2 | 3
  ---|---|---
  4 | 5 | 6
  ---|---|---
  7 | 8 | 9
  ```

### Example Game Flow
1. Player X chooses position 5 (center)
2. Player O chooses position 1 (top-left)
3. Player X chooses position 9 (bottom-right)
4. Continue until someone wins or it's a draw!

---

## 🖥️ Platform-Specific Instructions

### Windows
Double-click `run.bat` or run in Command Prompt:
```cmd
javac *.java
java Main
```

### Mac/Linux
```bash
chmod +x run.sh
./run.sh
```

Or manually:
```bash
javac *.java
java Main
```

---

## ❓ Troubleshooting

### "javac: command not found"
**Solution**: Install Java JDK from oracle.com or use `java -version` to check installation.

### "Compilation failed"
**Solution**: Make sure both `Main.java` and `TicTacToeGame.java` are in the same folder.

### Colors not showing
**Solution**: Your terminal may not support ANSI colors. The game will still work, just without colors.

---

## 📋 Game Features Reminder

- ✅ Two players (X and O)
- ✅ Beautiful colored interface
- ✅ Win detection for all 8 patterns
- ✅ Draw detection
- ✅ Statistics tracking
- ✅ Multiple rounds
- ✅ Overall winner determination

---

**Enjoy the game! 🎉**

