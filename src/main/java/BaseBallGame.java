import baseBall.Controller;
import baseBall.UI;

public class BaseBallGame {
    UI ui;
    Controller controller;

    public BaseBallGame(){
        ui = new UI();
        controller = new Controller(ui);
    }

    private void gameStart() {
        controller.play();
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.gameStart();
    }

}
