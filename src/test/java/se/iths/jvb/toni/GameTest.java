package se.iths.jvb.toni;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void scoreOfRollsWithoutBonusesShouldBeTotalNumberOfPinsKnockedDown(){
        Game game = new Game();

        game.roll(5);
        game.roll(3);

        assertThat(game.score()).isEqualTo(8);
    }

}
