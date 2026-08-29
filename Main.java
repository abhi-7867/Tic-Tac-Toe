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
}
