package baseBall;

import baseBall.Dto.GameResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private static final String GAME_INPUT_MSG = "숫자를 입력해 주세요 :";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_GAME_QUESTION_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ERROR_INPUT_MSG = "0부터 9 사이의 3자리 수를 입력해주세요.";

    Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public String inputView() {
        String inputStr = "";
        boolean result = false;
        print(GAME_INPUT_MSG, " ");
        while (!result) {
            inputStr = input();
            result = gameInputValid(inputStr);
        }
        return inputStr;
    }

    public void resultView(GameResponseDto responseDto) {
        if (responseDto.getResponseStatus() == 400) {
            return;
        }

        int strike = responseDto.getStrike();
        int ball = responseDto.getBall();

        if (ball == 0 && strike == 0) {
            print(NOTHING);
            return;
        }
        String resultStr = "";
        if (ball > 0) {
            resultStr += ball + BALL;
        }
        if (strike > 0) {
            resultStr += strike + STRIKE;
        }
        print(resultStr);

    }

    public void gameEndView() {
        print(GAME_SUCCESS_MSG);
    }

    public boolean reGameQuestionView() {
        String input = "0";
        boolean valid = false;
        while (!valid) {
            print(RE_GAME_QUESTION_MSG);
            input = input();
            valid = input.compareTo("1") == 0 || input.compareTo("2")==0;
        }
        return input.compareTo("1") == 0;
    }

    private void print(String msg){
        print(msg, "\n");
    }

    private void print(String msg, String end) {
        System.out.print(msg + end);
    }

    private String input() {
        return scanner.nextLine();
    }

    private boolean gameInputValid(String inputStr) {
        if (inputStr == null || inputStr.length() != 3) {
            print(ERROR_INPUT_MSG);
            return false;
        }
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (c < '0' || c > '9') {
                print(ERROR_INPUT_MSG);
                return false;
            }
            if (charList.contains(c)) {
                print(ERROR_INPUT_MSG);
                return false;
            }
            charList.add(c);
        }
        return true;

    }
}
