package baseBall.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallNumberTest {
    @Test
    @DisplayName("static isValid(int num):: 테스트입니다.")
    void isValidInt() {
        assertTrue(BallNumber.isValid(0));
        assertTrue(BallNumber.isValid(9));
        assertFalse(BallNumber.isValid(10));
        assertFalse(BallNumber.isValid(-1));
    }
}