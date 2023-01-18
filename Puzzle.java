import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle {
    private String word; //represents the random word the user is supposed to guess
    //stored as all uppercase letters

    private ArrayList<String> guesses; //represents all the letters that the user has guessed.
    //If the user has guessed the letters r, s, t and e, then
    //guesses would refer to the String "RSTE"

    private int MAX_WORDS = 45402; //represents how many words are in words.txt

    ArrayList<String> wordList = new ArrayList<String>();

    public Puzzle() {
        //loading text from a file using the Scanner (not on AP exam)
        word = pickRandomWord("/Users/charles/Study/Hangman/src/words.txt");
        guesses = new ArrayList<String>(6);
    }

    private String pickRandomWord(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.next();
                if(line.length() == 5) {
                    wordList.add(line);
                }
            }
            scanner.close();

            String random = wordList.get((int) (Math.random() * wordList.size()));
            return random.toUpperCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //If the guess String is length one, add it to the list of to guesses and return
    //true or false if that letter is in our word to be guessed.
    //If the guess String is longer than length one, check to see if it is the word
    //to be guessed. If it is, add guess to guesses and return true, else return false
    public boolean makeGuess(String guess) {
        guess = guess.toUpperCase();
        if(wordList.contains(guess.toLowerCase())) {
            if (guess.equals(word)) {
                guesses.add(guess);
            } else {
                guesses.add(guess);
            }
        }else {
                System.out.println("Invalid guess.");
                return true;
        }
        return word.contains(guess);
    }

    //Display the word to be guessed letter by letter using a loop. If the letter has
    //been guessed, print that letter. If not, print and underscore character (_) instead.
    //On a different line, show all the letters that have been guessed so far.
//    public void show() {
//        System.out.println(word);
//        for(int i = 0; i < guesses.size(); i++) {
//            String s = guesses.get(i);
//            for(int j = 0; j < word.length(); j++) {
//                if(word.contains(s.substring(j,j+1)) && word.charAt(j) == s.charAt(j)) {
//                    System.out.print("\033[48:5:28m");//green
//                } else if(!word.contains(s.substring(j,j+1))) {
//                    System.out.print("\033[48:5:7m");//gray
//                } else if(word.contains(s.substring(j,j+1)) && word.charAt(j) != s.charAt(j)) {
//                    System.out.print("\033[48:5:172m");//yellow
//                }
//                System.out.print(" " +s.charAt(j)+ " ");
//                System.out.print("\033[0;1m");
//            }
//            System.out.println("");
//        }
//    }

    public void show() {
        //System.out.println(word);

        for (int o = 0; o < guesses.size(); o++) {
            String typed = guesses.get(o);

        ArrayList<String> guessWord = new ArrayList<String>(5);
        ArrayList<String> typedWord = new ArrayList<String>(5);
        String[] outcome ={
                "\033[48:5:7m",
                "\033[48:5:7m",
                "\033[48:5:7m",
                "\033[48:5:7m",
                "\033[48:5:7m"};

        for (int i = 0; i < 5; i++) {
            guessWord.add(word.substring(i, i + 1));
        }

        for (int i = 0; i < 5; i++) {
            typedWord.add(typed.substring(i, i + 1));
        }

        for (int i = 0; i < 5; i++) {
            String a = guessWord.get(i);
            String b = typedWord.get(i);
            if (a.equals(b)) {
                outcome[i] = ("\033[48:5:28m");//green
                guessWord.set(i, "1");
            }
        }

        for (int i = 0; i < 5; i++) {
            if (guessWord.contains(typedWord.get(i)) && outcome[i] != ("\033[48:5:28m")) {
                outcome[i] = ("\033[48:5:172m");//yellow
                guessWord.set(guessWord.indexOf(typedWord.get(i)), "1");
            }
        }

        for(int i = 0; i < 5; i++) {
            System.out.print(outcome[i]);
            System.out.print(" " +typedWord.get(i)+ " ");
            System.out.print("\033[0;1m");
        }
            System.out.println("");
    }
    }


    //Return true or false if the word has been guessed or not (ie: all of the letters in
    //word are also in guesses.
    public boolean isUnsolved() {
            if(!guesses.contains(word)) {
                return true;
            } else {
                return false;
            }
    }

    //returns word;
    public String getWord() {
        return word;
    }
}
