package se.iths.jvb.toni;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void scoreWithoutBonusesShouldBeTotalNumberOfPinsKnockedDown(){
        Game game = new Game();

        game.roll(5);
        game.roll(3);

        assertThat(game.score()).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource (ints = {-1,11})
    void pinsKnockedDownShouldBeLimitedToValidRange(int invalidPinCount){
        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> game.roll(invalidPinCount));
    }

    @Test
    void completeGameShouldBeTenFrames(){
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(2);
        }
        game.roll(1);

        assertThat(game.score()).isEqualTo(40);
    }

}
