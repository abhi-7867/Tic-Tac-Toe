#!/bin/bash
echo "Compiling..."
javac Main.java TicTacToeGame.java
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi
