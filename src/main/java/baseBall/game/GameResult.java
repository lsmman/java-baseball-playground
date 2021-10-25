package baseBall.game;


public class GameResult {
    private int strike;
    private int ball;
    private boolean isSuccess;

    public GameResult() {
        strike = 0;
        ball = 0;
    }

    public boolean isSuccess() {
        return this.strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike(int add) {
        this.strike += add;
    }

    public void addBall(int add) {
        this.ball += add;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "strike=" + strike +
                ", ball=" + ball +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
