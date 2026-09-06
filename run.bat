@echo off
echo Compiling...
javac Main.java TicTacToeGame.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b 1
)
