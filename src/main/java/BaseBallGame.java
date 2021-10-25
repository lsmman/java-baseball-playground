import baseBall.Controller;
import baseBall.UI;

public class BaseBallGame {
    UI ui;
    Controller controller;

    private void gameStart() {
        if (ui == null){
            ui = new UI();
        }
        if (controller == null){
            controller = new Controller(ui);
        }
        controller.play();
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.gameStart();
    }

}
