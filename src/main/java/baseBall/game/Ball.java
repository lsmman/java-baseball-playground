package baseBall.game;


public class Ball {
    BallNumber num;
    int pos;

    public Ball(int num, int pos) {
        this.num = new BallNumber(num);
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return pos == ball.pos && num.equals(ball.num);
    }

    /*
     * public method: play
     *  야구 게임에서 몇 개 맞추었는 지 도출해줍니다.
     *  ex) com / user
     *      1, pos=0 / 4, pos=0 -> Nothing
     *      1, pos=0 / 1, pos=1 -> Ball
     *      1, pos=0 / 1, pos=0 -> Strike
     */
    public GameStatus play(Ball other) {
        if (this.equals(other)){
            return GameStatus.STRIKE;
        }
        if (isSameNumber(other)){
            return GameStatus.BALL;
        }
        return GameStatus.NOTHING;

    }

    private boolean isSameNumber(Ball other) {
        return this.num.equals(other.num);
    }
}
