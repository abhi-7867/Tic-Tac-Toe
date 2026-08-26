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
        }
    }
    private static boolean showInstructions(Scanner scanner) {
        System.out.println(YELLOW + "═══════════════════════════════════" + RESET);
        System.out.print(BOLD + "Would you like to see the instructions? (y/n): " + RESET);
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
}
