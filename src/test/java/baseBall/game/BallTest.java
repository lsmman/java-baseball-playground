package baseBall.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    Ball ball;

    @BeforeEach
    public void setUp(){
        ball = new Ball(1, 0);
    }

    @Test
    @DisplayName("play Nothing 테스트")
    void playStatusNothing() {
        // given
        // when
        GameStatus status = ball.play(new Ball(4, 1));

        // then
        assertEquals(GameStatus.NOTHING, status);
    }

    @Test
    @DisplayName("play Ball 테스트")
    void playStatusBall() {
        // given
        // when
        GameStatus status = ball.play(new Ball(1, 1));

        // then
        assertEquals(GameStatus.BALL, status);
    }

    @Test
    @DisplayName("play Strike 테스트")
    void playStatusStrike() {
        // given
        // when
        GameStatus status = ball.play(new Ball(1, 0));

        // then
        assertEquals(GameStatus.STRIKE, status);
    }

}