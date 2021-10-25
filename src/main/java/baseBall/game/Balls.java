package baseBall.game;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> balls) {
        for (int i = 0; i < balls.size(); i++) {
            this.balls.add(new Ball(balls.get(i), i));
        }
    }

    public GameStatus play(Ball ball) {
        return balls.stream()
                .map(each -> each.play(ball))
                .filter(gameStatus -> gameStatus != GameStatus.NOTHING)
                .findFirst()
                .orElse(GameStatus.NOTHING);
    }

    public GameResult play(Balls other){
        GameResult result = new GameResult();
        for (Ball ball: this.balls) {
            GameStatus status = other.play(ball);
            if(status.equals(GameStatus.STRIKE)){
                result.addStrike(1);
            }
            else if(status.equals(GameStatus.BALL)){
                result.addBall(1);
            }
        }

        return result;
    }
}
