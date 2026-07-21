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
        currentPlayer = 'X';
        movesCount = 0;
    }

    public void displayBoard() {
        System.out.println();
        System.out.println("═══════════════════════════════════");
        System.out.println("        TIC TAC TOE BOARD");
        System.out.println("═══════════════════════════════════");
        System.out.println();
        System.out.println("     |     |     ");
        System.out.println(String.format("  %s  |  %s  |  %s  ", board[0][0], board[0][1], board[0][2]));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println(String.format("  %s  |  %s  |  %s  ", board[1][0], board[1][1], board[1][2]));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println(String.format("  %s  |  %s  |  %s  ", board[2][0], board[2][1], board[2][2]));
        System.out.println("     |     |     ");
        System.out.println();
    }
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    private boolean isValidMove(int row, int col) {
        return board[row][col] == ' ';
    }
    public void playerMove() {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int position = scanner.nextInt();
            scanner.nextLine();

            if (position >= 1 && position <= 9) {
                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    movesCount++;
                    validMove = true;
                } else {
                    System.out.println("Invalid move! Position already taken. Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
            }
        }
    }
}
