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
        System.out.println(CYAN + "═══════════════════════════════════" + RESET);
        System.out.println(BOLD + PURPLE + "        TIC TAC TOE BOARD" + RESET);
        System.out.println(CYAN + "═══════════════════════════════════" + RESET);
        System.out.println();
        System.out.println(BLUE + "     |     |     " + RESET);
        System.out.println(String.format(BLUE + "  %s  |  %s  |  %s  " + RESET,
                colorizePlayer(board[0][0]),
                colorizePlayer(board[0][1]),
                colorizePlayer(board[0][2])));
        System.out.println(BLUE + "_____|_____|_____" + RESET);

        System.out.println(BLUE + "     |     |     " + RESET);
        System.out.println(String.format(BLUE + "  %s  |  %s  |  %s  " + RESET,
                colorizePlayer(board[1][0]),
                colorizePlayer(board[1][1]),
                colorizePlayer(board[1][2])));
        System.out.println(BLUE + "_____|_____|_____" + RESET);

        System.out.println(BLUE + "     |     |     " + RESET);
        System.out.println(String.format(BLUE + "  %s  |  %s  |  %s  " + RESET,
                colorizePlayer(board[2][0]),
                colorizePlayer(board[2][1]),
                colorizePlayer(board[2][2])));
        System.out.println(BLUE + "     |     |     " + RESET);
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
            System.out.println(YELLOW + "═══════════════════════════════════" + RESET);
            System.out.print(BOLD + "Player " + colorizePlayer(currentPlayer) +
                    RESET + BOLD + ", enter your move (1-9): " + RESET);
            try {
                int position = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (position >= 1 && position <= 9) {
                    int row = (position - 1) / 3;
                    int col = (position - 1) % 3;

                    if (isValidMove(row, col)) {
                        board[row][col] = currentPlayer;
                        movesCount++;
                        validMove = true;
                        System.out.println();
                    } else {
                        System.out.println(RED + "⚠ Invalid move! Position already taken. Try again." + RESET);
                        System.out.println();
                    }
                } else {
                    System.out.println(RED + "⚠ Invalid input! Please enter a number between 1 and 9." + RESET);
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println(RED + "⚠ Invalid input! Please enter a valid number." + RESET);
                System.out.println();
                scanner.nextLine(); // Clear the invalid input
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
        System.out.println();
        System.out.println(GREEN + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "║                                   ║" + RESET);
        System.out.println(
                String.format(GREEN + "║  " + BOLD + "🎉 CONGRATULATIONS! 🎉" + RESET + GREEN + "        ║" + RESET));
        System.out.println(
                String.format(GREEN + "║  " + BOLD + "Player %s WINS!" + RESET + GREEN + "           ║" + RESET,
                        colorizePlayer(currentPlayer)));
        System.out.println(GREEN + "║                                   ║" + RESET);
        System.out.println(GREEN + "╚═══════════════════════════════════╝" + RESET);
        System.out.println();

        if (currentPlayer == 'X') {
            player1Wins++;
        } else {
            player2Wins++;
        }
    }
    public void displayDrawMessage() {
        System.out.println();
        System.out.println(YELLOW + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(YELLOW + "║                                   ║" + RESET);
        System.out.println(YELLOW + "║  " + BOLD + "🤝 IT'S A DRAW! 🤝" + RESET + YELLOW + "              ║" + RESET);
        System.out.println(YELLOW + "║                                   ║" + RESET);
        System.out.println(YELLOW + "╚═══════════════════════════════════╝" + RESET);
        System.out.println();

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
    private String colorizePlayer(char player) {
        if (player == 'X') {
            return RED + BOLD + player + RESET;
        } else if (player == 'O') {
            return GREEN + BOLD + player + RESET;
        }
        return " ";
    }
    public void displayStatistics() {
        System.out.println();
        System.out.println(CYAN + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + BOLD + "        GAME STATISTICS" + RESET + CYAN + "          ║" + RESET);
        System.out.println(CYAN + "╠═══════════════════════════════════╣" + RESET);
        System.out.println(String.format(CYAN + "║" + RESET + "  Player X Wins: " + RED + BOLD + "%d" + RESET +
                CYAN + "              ║" + RESET, player1Wins));
        System.out.println(String.format(CYAN + "║" + RESET + "  Player O Wins: " + GREEN + BOLD + "%d" + RESET +
                CYAN + "              ║" + RESET, player2Wins));
        System.out.println(String.format(CYAN + "║" + RESET + "  Draws:         " + YELLOW + BOLD + "%d" + RESET +
                CYAN + "              ║" + RESET, draws));
        System.out.println(CYAN + "╚═══════════════════════════════════╝" + RESET);
        System.out.println();
    }
    public void displayInstructions() {
        System.out.println();
        System.out.println(PURPLE + "╔═══════════════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + "║" + BOLD + "                  GAME INSTRUCTIONS" + RESET + PURPLE
                + "                  ║" + RESET);
        System.out.println(PURPLE + "╠═══════════════════════════════════════════════════════╣" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "  • This is a two-player Tic-Tac-Toe game           " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "  • Players take turns placing their symbol         " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "  • To place your symbol, enter a number (1-9)       " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "  • The board layout is as follows:                  " + PURPLE + "║" + RESET);
        System.out.println(PURPLE + "║                                                        " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "                     1 | 2 | 3                      " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "                    ---|---|---                      " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "                     4 | 5 | 6                      " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "                    ---|---|---                      " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "                     7 | 8 | 9                      " + PURPLE + "║" + RESET);
        System.out.println(PURPLE + "║                                                        " + PURPLE + "║" + RESET);
        System.out.println(
                PURPLE + "║" + RESET + "  • First player to get 3 in a row wins!            " + PURPLE + "║" + RESET);
        System.out.println(PURPLE + "╚═══════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    public void displayWelcome() {
        System.out.println();
        System.out.println(CYAN + "╔═══════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║                                                       ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ╔═══╗  ╔═══════════╗  ╔═══╗  ╔═══╗  ╔═══╗" + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ║   ║  ║           ║  ║   ║  ║   ║  ║   ║" + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ║   ║  ║           ║  ║   ║  ║   ║  ║   ║" + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ║   ║  ║   ╔═══╗   ║  ║   ║  ╚═══╣  ╠═══╝" + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ║   ║  ║   ║   ║   ║  ║   ║      ║  ║    " + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ║   ║  ║   ╚═══╝   ║  ║   ║      ║  ║    " + RESET + CYAN + "     ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "     ╚═══╝  ╚═══════════╝  ╚═══╝  ╚═══╝  ╚═══╝" + RESET + CYAN + "     ║" + RESET);
        System.out.println(CYAN + "║                                                       ║" + RESET);
        System.out.println(
                CYAN + "║" + BOLD + "                  PREMIUM EDITION" + RESET + CYAN + "                  ║" + RESET);
        System.out.println(CYAN + "╚═══════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
}
