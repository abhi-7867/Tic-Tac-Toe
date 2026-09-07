@echo off
title Premium Tic-Tac-Toe Game
color 0A
echo.
echo ================================================================
echo         Compiling Premium Tic-Tac-Toe Game...
echo ================================================================
echo.
javac Main.java TicTacToeGame.java
if %errorlevel% neq 0 (
    echo.
    echo Compilation failed! Please check your Java installation.
    pause
    exit /b 1
)
echo.
echo ================================================================
echo              Compilation successful!
echo ================================================================
echo.
echo ================================================================
echo         Starting Premium Tic-Tac-Toe Game...
echo ================================================================
echo.
java Main
echo.
echo ================================================================
echo                  Game Ended
echo ================================================================
pause

