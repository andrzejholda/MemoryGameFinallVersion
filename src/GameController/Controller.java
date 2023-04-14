package GameController;

import Model.Board;
import View.GameInformations;

import java.util.Scanner;

public class Controller {
    GameInformations gameInformations = new GameInformations();
    public static Scanner userChoice = new Scanner(System.in);
    Board board = new Board();

    public void game() {
        board.setWords();
        board.addWordsToArray();
        board.shuffleCards();
        while (!board.checkIfMatched(board.cards)) {
            gameInformations.printActuallyBoard( board);
            gameInformations.firstCoordinates();
            int row1 = userChoice.nextInt();
            if (row1>board.cards.length || row1<0){
                gameInformations.badCoordinat();
                continue;
            }
            int column1 = userChoice.nextInt();
            if (column1 >board.cards[row1-1].length || column1<0){
                gameInformations.badCoordinat();
                continue;
            }

            board.openCard(row1, column1);
            gameInformations.printActuallyBoard(board);
            gameInformations.secondCoordinates();
            int row2 = userChoice.nextInt();
            int column2 = userChoice.nextInt();
            board.openCard(row2, column2);
            gameInformations.printActuallyBoard(board);
            if (board.checkMatch(board.cards[row1 - 1][column1 - 1], board.cards[row2 - 1][column2 - 1])) {
                gameInformations.correctMatches();
                  if (board.isAllCardsMatched()) {
                            gameInformations.finalInformations();
                        }
            } else {
                gameInformations.wrongMatches();
                board.closeCards(board.cards[row1 - 1][column1 - 1], board.cards[row2 - 1][column2 - 1]);
            }
        }
        gameInformations.gameEnd();

    }

    //  board.setCards();
//        board.setWords();
//        board.shuffleCards();
//        board.printActuallyBoard();
    // gra trwa, dopóki wszystkie karty nie zostaną odkryte


}
