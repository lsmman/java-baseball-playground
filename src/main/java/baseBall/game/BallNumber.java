package baseBall.game;


public class BallNumber {
    int num;

    public int getNum() {
        return num;
    }

    public BallNumber(int num) {
        if (!isValid(num)){
            throw new IllegalArgumentException("숫자는 1부터 9 사이여야 합니다.");
        }
        this.num = num;
    }

    public static boolean isValid(int num) {
        return num >= 0 && num <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return num == that.num;
    }
}
