package baseBall.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void play() {
        GameResult result = game.play(Arrays.asList(1, 2, 3));
        assertNotNull(result);
    }
}