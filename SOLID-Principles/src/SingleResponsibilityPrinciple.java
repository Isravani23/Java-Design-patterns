import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityPrinciple {
    //Each class should have only one responsibility.
    //Bad Example: This class tracks both a game result and keeps history—two reasons to change!
    public class GameResult {
        static List<GameResult> history = new ArrayList<>();
        int guesses;
        int magicNumber;
        GameResult(int numberOfGuesses, int theNumber) {
            guesses = numberOfGuesses;
            magicNumber = theNumber;
            history.add(this); // extra responsibility
        }
    }
    //Good Example: Only tracks a single game's result.
    public class GameResult1 {
        int guesses;
        int magicNumber;
        GameResult1(int numberOfGuesses, int theNumber) {
            guesses = numberOfGuesses;
            magicNumber = theNumber;
        }
    }

}
