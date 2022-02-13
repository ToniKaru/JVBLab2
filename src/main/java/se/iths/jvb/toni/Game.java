package se.iths.jvb.toni;

public class Game {

    private int score;

    Game(){
        score = 0;
    }

    public void roll(int pinsDown) {
        score += pinsDown;
    }

    public int score() {
        return score;
    }
}
