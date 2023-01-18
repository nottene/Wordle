public class WordleWord {

    private int numWrongGuesses;

    //Constructor - intializes numWrongGuesses to zero
    public WordleWord() {
        numWrongGuesses = 0;
    }

    //increments numWrongGuesses by one
    public void dieSomeMore() {
        numWrongGuesses++;
    }

    //returns true if numWrongGuesses is 6, false othewise
    public boolean isntDead() {
        if(numWrongGuesses == 6) {
            return false;
        }
        return true;
    }

    //prints to the console the String stored in the HangmanImage array
    //at the index equal to numWrongGuess
    public void show() {
    }

}

