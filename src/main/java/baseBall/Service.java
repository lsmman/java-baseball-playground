package baseBall;

import baseBall.Dto.GameResponseDto;
import baseBall.game.Game;
import baseBall.game.GameResult;

import java.util.ArrayList;
import java.util.List;

public class Service {
    Game game;

    public void initGame(){
        game = new Game();
    }

    public GameResponseDto playGame(String ballsStr){
        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < ballsStr.length(); i++) {
            balls.add(ballsStr.charAt(i) - '0');
        }

        GameResult result = game.play(balls);
        return new GameResponseDto(result);
    }
}
