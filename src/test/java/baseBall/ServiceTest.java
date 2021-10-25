package baseBall;

import baseBall.Dto.GameResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service service;


    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @Test
    void playGame() {
        GameResponseDto responseDto = service.playGame("123");
        assertEquals(200, responseDto.getResponseStatus());
        assertNotNull(responseDto.getBall());
        assertNotNull(responseDto.getStrike());
        assertNotNull(responseDto.isSuccess());
    }

}