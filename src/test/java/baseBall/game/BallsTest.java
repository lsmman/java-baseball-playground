package baseBall.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("play:: 상태가 Nothing 경우")
    void playStatusNOTHING() {
        // given

        // when
        GameStatus status = balls.play(new Ball(4, 0));
        // then
        assertEquals(GameStatus.NOTHING, status);
    }

    @Test
    @DisplayName("play:: 상태가 Ball 경우")
    void playStatusBALL() {
        // given

        // when
        GameStatus status = balls.play(new Ball(3, 0));
        // then
        assertEquals(GameStatus.BALL, status);
    }

    @Test
    @DisplayName("play:: 상태가 Strike 경우")
    void playStatusSTRIKE() {
        // given

        // when
        GameStatus status = balls.play(new Ball(1, 0));
        // then
        assertEquals(GameStatus.STRIKE, status);
    }

    @Test
    @DisplayName("play:: 결과가 Nothing 경우")
    void playResultNOTHING() {
        // given
        Balls balls = new Balls(Arrays.asList(4, 5, 6));
        // when
        GameResult result = this.balls.play(balls);
        // then
        assertEquals(0, result.getBall());
        assertEquals(0, result.getStrike());
        assertFalse(result.isSuccess());
    }

    @Test
    @DisplayName("play:: 결과가 1 Ball 1 Strike 경우")
    void playResult1BALL1STRIKE() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 3, 6));
        // when
        GameResult result = this.balls.play(balls);
        // then
        assertEquals(1, result.getBall());
        assertEquals(1, result.getStrike());
        assertFalse(result.isSuccess());
    }

    @Test
    @DisplayName("play:: 결과가 3 Strike 경우")
    void playResult3STRIKE() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        // when
        GameResult result = this.balls.play(balls);
        // then
        assertEquals(0, result.getBall());
        assertEquals(3, result.getStrike());
        assertTrue(result.isSuccess());
    }
}