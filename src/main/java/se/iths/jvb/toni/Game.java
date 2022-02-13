package se.iths.jvb.toni;

public class Game {

    private int score;

    Game(){
        score = 0;
    }

    public void roll(int pinsDown) {
        if (pinsDown < 0 || pinsDown > 10)
            throw new IllegalArgumentException("Pin count: " + pinsDown + " out of range");
        score += pinsDown;
    }

    public int score() {
        return score;
    }
}
