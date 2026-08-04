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

    private static final String RESET = "\033[0m";
    private static final String RED = "\033[91m";
    private static final String GREEN = "\033[92m";
    private static final String YELLOW = "\033[93m";
    private static final String BLUE = "\033[94m";
    private static final String PURPLE = "\033[95m";
    private static final String CYAN = "\033[96m";
    private static final String BOLD = "\033[1m";

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
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
    public boolean checkDraw() {
        return movesCount == 9;
    }
    public void displayWinMessage() {
        System.out.println("Congratulations! Player " + currentPlayer + " WINS!");
        if (currentPlayer == 'X') {
            player1Wins++;
        } else {
            player2Wins++;
        }
    }
    public void displayDrawMessage() {
        System.out.println("It's a draw!");
        draws++;
    }
    public int getPlayer1Wins() {
        return player1Wins;
    }
    public int getPlayer2Wins() {
        return player2Wins;
    }
    public int getDraws() {
        return draws;
    }
    public void close() {
        scanner.close();
    }
    public boolean playRound() {
        initializeBoard();
        displayBoard();
        while (true) {
            playerMove();
            displayBoard();
            if (checkWin()) {
                displayWinMessage();
                return true;
            }
            if (checkDraw()) {
                displayDrawMessage();
                return false;
            }
            switchPlayer();
        }
    }
}
