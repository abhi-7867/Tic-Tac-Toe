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
    }
}
