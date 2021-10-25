package baseBall.Dto;

import baseBall.game.GameResult;

public class GameResponseDto {
    int responseStatus;
    int ball;
    int strike;
    boolean success;

    public GameResponseDto(){
        responseStatus = 400;
    }

    public GameResponseDto(GameResult result) {
        ball = result.getBall();
        strike = result.getStrike();
        success = result.isSuccess();
        responseStatus = 200;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isSuccess() {
        return success;
    }
}
