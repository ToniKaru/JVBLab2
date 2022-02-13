package se.iths.jvb.toni;

public class Game {

    private static final int FRAMES_PER_GAME = 10;
    private static final int MAX_ROLLS_PER_FRAME = 2;
    private static final int MAX_STANDARD_ROLLS = FRAMES_PER_GAME * MAX_ROLLS_PER_FRAME;
    private int score;
    private int standardRollCount;


    Game(){
        score = 0;
    }

    public void roll(int pinsDown) {
        if (pinsDown < 0 || pinsDown > 10)
            throw new IllegalArgumentException("Pin count: " + pinsDown + " out of range");
        if (standardRollCount < MAX_STANDARD_ROLLS) {
            standardRollCount++;
            score += pinsDown;
        }
    }

    public int score() {
        return score;
    }
}
