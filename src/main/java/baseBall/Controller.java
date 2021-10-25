package baseBall;

import baseBall.Dto.GameResponseDto;

public class Controller {
    Service service;
    UI ui;

    public Controller(UI ui) {
        this.ui = ui;
        service = new Service();
    }

    public void play() {
        boolean reGame = true;
        while (reGame) {
            playGame();
            reGame = ui.reGameQuestionView();
        }
    }

    private void playGame() {
        service.initGame();
        String inputStr;

        while (true) {
            inputStr = ui.inputView();
            GameResponseDto gameResponseDto = service.playGame(inputStr);
            ui.resultView(gameResponseDto);
            if (gameResponseDto.isSuccess()) {
                ui.gameEndView();
                break;
            }
        }
    }
}
