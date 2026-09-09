#!/bin/bash

echo ""
echo "================================================================"
echo "         Compiling Premium Tic-Tac-Toe Game..."
echo "================================================================"
echo ""

javac Main.java TicTacToeGame.java

if [ $? -ne 0 ]; then
    echo ""
    echo "Compilation failed! Please check your Java installation."
    exit 1
fi

echo ""
echo "================================================================"
echo "              Compilation successful!"
echo "================================================================"
echo ""
echo "================================================================"
echo "         Starting Premium Tic-Tac-Toe Game..."
echo "================================================================"
echo ""

java Main

echo ""
echo "================================================================"
echo "                  Game Ended"
echo "================================================================"
echo ""

read -p "Press Enter to exit..."

