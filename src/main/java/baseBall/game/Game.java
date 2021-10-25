package baseBall.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 베이스볼 게임 클래스입니다.
 * <p>
 * public method: createAnswer
 * 3자리 수 야구게임 정답을 만들어 냅니다.
 * <p>
 * public method: play
 * 야구 게임에서 몇 개 맞추었는 지 도출해줍니다.
 * ex) com / user
 * 123 / 123 -> 3 strike
 * 123 / 456 -> Nothing
 * 123 / 253 -> 1 ball 1 strike
 */
public class Game {
    Balls balls;

    public Game() {
        balls = new Balls(createAnswer());
    }

    private static int pickRandomNumber() {
        int cur = 0;
        boolean valid = false;
        Random random = new Random();

        while (!valid) {
            cur = random.nextInt(10);
            valid = BallNumber.isValid(cur);
        }
        return cur;
    }

    public static List<Integer> createAnswer() {
        int randomNumber;
        List<Integer> answer = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            randomNumber = Game.pickRandomNumber();
            answer.add(randomNumber);
        }
        return answer;
    }

    public GameResult play(List<Integer> other) {
        Balls otherBalls = new Balls(other);
        return this.balls.play(otherBalls);
    }

}
