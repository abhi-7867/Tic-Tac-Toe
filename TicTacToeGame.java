import java.util.Scanner;

/**
 * Premium Tic-Tac-Toe Game
 */
public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private int movesCount;
    private int player1Wins;
    private int player2Wins;
    private int draws;
    private Scanner scanner;

    public TicTacToeGame() {
        board = new char[3][3];
        scanner = new Scanner(System.in);
        player1Wins = 0;
        player2Wins = 0;
        draws = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
