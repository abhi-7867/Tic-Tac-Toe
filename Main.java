import java.util.Scanner;

public class Main {
    private static final String RESET = "\033[0m";
    private static final String CYAN = "\033[96m";
    private static final String YELLOW = "\033[93m";
    private static final String GREEN = "\033[92m";
    private static final String RED = "\033[91m";
    private static final String BOLD = "\033[1m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();
        
        // Display welcome screen
        game.displayWelcome();
        
        // Display instructions if requested
        if (showInstructions(scanner)) {
            game.displayInstructions();
        }

        // Main game loop
        boolean continuePlaying = true;
        int totalRounds = 0;

        while (continuePlaying) {
            totalRounds++;
            System.out.println();
            System.out.println(CYAN + "╔═══════════════════════════════════╗" + RESET);
            System.out.println(String.format(CYAN + "║" + RESET + "        " + BOLD + "ROUND %d" + RESET + 
                            CYAN + "              ║" + RESET, totalRounds));
            System.out.println(CYAN + "╚═══════════════════════════════════╝" + RESET);
            System.out.println();
            
            // Play a round
            game.playRound();
            
            // Display current statistics
            game.displayStatistics();
            
            // Ask if players want to play another round
            continuePlaying = askToPlayAgain(scanner);
        }
        
        // Display final statistics
        displayFinalResults(game, totalRounds);
        
        // Closing message
        displayClosingMessage();
        
        scanner.close();
    }
    private static boolean showInstructions(Scanner scanner) {
        System.out.println(YELLOW + "═══════════════════════════════════" + RESET);
        System.out.print(BOLD + "Would you like to see the instructions? (y/n): " + RESET);
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.println(YELLOW + "═══════════════════════════════════" + RESET);
        System.out.print(BOLD + "Would you like to play another round? (y/n): " + RESET);
        
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
    private static double calculatePercentage(int value, int total) {
        if (total == 0) return 0.0;
        return (value * 100.0) / total;
    }
    private static void displayFinalResults(TicTacToeGame game, int totalRounds) {
        System.out.println();
        System.out.println(CYAN + "╔═══════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + BOLD + "                    FINAL RESULTS" + RESET + CYAN + "                    ║" + RESET);
        System.out.println(CYAN + "╠═══════════════════════════════════════════════════════╣" + RESET);
        System.out.println(String.format(CYAN + "║" + RESET + "  Total Rounds Played: " + BOLD + "%d" + RESET + 
                            CYAN + "                            ║" + RESET, totalRounds));
        System.out.println(CYAN + "╠═══════════════════════════════════════════════════════╣" + RESET);
        
        int player1Wins = game.getPlayer1Wins();
        int player2Wins = game.getPlayer2Wins();
        int draws = game.getDraws();
        
        System.out.println(String.format(CYAN + "║" + RESET + "  Player X Wins: " + RED + BOLD + "%d" + RESET + 
                            CYAN + " (" + "%.1f%%" + CYAN + ")" + "               ║" + RESET, 
                            player1Wins, calculatePercentage(player1Wins, totalRounds)));
        System.out.println(String.format(CYAN + "║" + RESET + "  Player O Wins: " + GREEN + BOLD + "%d" + RESET + 
                            CYAN + " (" + "%.1f%%" + CYAN + ")" + "               ║" + RESET, 
                            player2Wins, calculatePercentage(player2Wins, totalRounds)));
        System.out.println(String.format(CYAN + "║" + RESET + "  Draws:         " + YELLOW + BOLD + "%d" + RESET + 
                            CYAN + " (" + "%.1f%%" + CYAN + ")" + "               ║" + RESET, 
                            draws, calculatePercentage(draws, totalRounds)));
        System.out.println(CYAN + "╠═══════════════════════════════════════════════════════╣" + RESET);
        
        // Determine overall winner
        if (player1Wins > player2Wins) {
            System.out.println(String.format(CYAN + "║" + RESET + "  " + RED + BOLD + "🏆 OVERALL WINNER: PLAYER X 🏆" + RESET + 
                                CYAN + "      ║" + RESET));
        } else if (player2Wins > player1Wins) {
            System.out.println(String.format(CYAN + "║" + RESET + "  " + GREEN + BOLD + "🏆 OVERALL WINNER: PLAYER O 🏆" + RESET + 
                                CYAN + "      ║" + RESET));
        } else {
            System.out.println(String.format(CYAN + "║" + RESET + "  " + YELLOW + BOLD + "🤝 TIE GAME! WELL PLAYED! 🤝" + RESET + 
                                CYAN + "      ║" + RESET));
        }
        
        System.out.println(CYAN + "╚═══════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    private static void displayClosingMessage() {
        System.out.println(CYAN + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║                                   ║" + RESET);
        System.out.println(CYAN + "║" + RESET + "  " + BOLD + "Thank you for playing!" + RESET + 
                           CYAN + "                ║" + RESET);
        System.out.println(CYAN + "║" + RESET + "  " + BOLD + "Hope you had fun! 😊" + RESET + 
                           CYAN + "                 ║" + RESET);
        System.out.println(CYAN + "║                                   ║" + RESET);
        System.out.println(CYAN + "╚═══════════════════════════════════╝" + RESET);
        System.out.println();
    }
}
