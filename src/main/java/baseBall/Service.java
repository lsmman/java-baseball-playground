package baseBall;

import java.util.List;

public class Service {
    Game game;

    public Service() {
        this.game = new Game();
    }

    public void initGame(){
        game.createAnswer();
    }

    public void playGame(List<Integer> balls){
        game.play(balls);
    }
}
