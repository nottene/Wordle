import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordleWord word = new WordleWord();
        Puzzle puzzle = new Puzzle();

        System.out.println("WELCOME TO MY HOMEMADE WORDLE GAME!!!");

        while (puzzle.isUnsolved() && word.isntDead()) {
            word.show();
            puzzle.show();
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();
            if (!puzzle.makeGuess(guess)) {
                word.dieSomeMore();
            }
            clearScreen();
        }

        if (word.isntDead()) {
            puzzle.show();
            System.out.println("You win!");
        } else {
            puzzle.show();
            System.out.println("You lose! The word was " + puzzle.getWord());
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
