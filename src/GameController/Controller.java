package GameController;

import Model.Board;
import View.GameInformations;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    GameInformations gameInformations = new GameInformations();
    public static Scanner userChoice = new Scanner(System.in);
    public static Scanner scanner = new Scanner(System.in);
    Board board = new Board();
    public Controller() throws IOException {
    }
    public void game() {
        gameInformations.printMemoryGameTitle();
        gameInformations.setBoardSize();
        gameInformations.rowSet();
        board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
        board.setRowUser(scanner.nextInt());
        gameInformations.columnSet();
        board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
        board.setColumnUser(scanner.nextInt());
        while(!board.isBoardSizeCorrect()) {
        if(board.getRowUser()<=0||board.getColumnUser()<=0){
            gameInformations.wrongBoardSize();
            gameInformations.setBoardSize();
            gameInformations.rowSet();
            board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
            board.setRowUser(scanner.nextInt());
            gameInformations.columnSet();
            board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
            board.setColumnUser(scanner.nextInt());
        }else {
            board.setBoardSizeCorrect(true);
        }
        }
        while(board.getRowUser() * board.getColumnUser() % 2 != 0) {
            gameInformations.oddBoardSize();
            gameInformations.informationAboutEven();
            gameInformations.rowSet();
            board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
            board.setRowUser(scanner.nextInt());
            gameInformations.columnSet();
            board.readIntInput(scanner,gameInformations.badChar,gameInformations.badCharInformation);
            board.setColumnUser(scanner.nextInt());
        }
            board.setWords();
            board.evenList();
            board.shuffleWords();
            board.addWordsToArray();
            gameInformations.printActuallyBoard(board);
            while (!board.checkIfMatched()) {
                gameInformations.firstCoordinates();
                gameInformations.cardRow();
                board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                int row1 = userChoice.nextInt();
                if (row1 > board.getCardRow() || row1 <= 0) {
                    gameInformations.badCoordinat();
                    gameInformations.wrongRow();
                    gameInformations.cardRow();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    row1 = userChoice.nextInt();
                }
                gameInformations.cardColumn();
                board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                int column1 = userChoice.nextInt();
                while (column1 > board.getCardsColumn(row1 - 1).size() || column1 <=0) {
                    gameInformations.badCoordinat();
                    gameInformations.wrongColumn();
                    gameInformations.cardColumn();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    column1 = userChoice.nextInt();

                }
                board.openCard(row1, column1);
                gameInformations.printActuallyBoard(board);
                gameInformations.secondCoordinates();
                gameInformations.cardRow();
                board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                int row2 = userChoice.nextInt();
                if (row2 > board.getCardRow() || row2 <= 0) {
                    gameInformations.badCoordinat();
                    gameInformations.wrongRow();
                    gameInformations.cardRow();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    row2 = userChoice.nextInt();
                }
                gameInformations.cardColumn();
                board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                int column2 = userChoice.nextInt();
                if (column2 > board.getCardsColumn(row2 - 1).size() || column2 <= 0) {
                    gameInformations.badCoordinat();
                    gameInformations.wrongColumn();
                    gameInformations.cardColumn();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    column2 = userChoice.nextInt();
                }
                while (board.getCard(row1 - 1, column1 - 1) == board.getCard(row2 - 1, column2 - 1)) {
                    gameInformations.sameCoordinat();
                    gameInformations.secondCoordinates();
                    gameInformations.cardRow();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    row2 = userChoice.nextInt();
                    gameInformations.cardColumn();
                    board.readIntInput(userChoice,gameInformations.badChar,gameInformations.badCharInformation);
                    column2 = userChoice.nextInt();
                }
                board.openCard(row2, column2);
                gameInformations.printActuallyBoard(board);
                if (board.checkMatch(board.getCard(row1 - 1, column1 - 1), board.getCard(row2 - 1, column2 - 1))) {
                    gameInformations.correctMatches();
                    board.setMoves(board.increaseMoves());
                    if (board.isAllCardsMatched()) {

                        gameInformations.finalInformations();
                    }
                } else {
                    board.setMoves(board.increaseMoves());
                    gameInformations.wrongMatches();
                    board.closeCards(board.getCard(row1 - 1, column1 - 1), board.getCard(row2 - 1, column2 - 1));
                }
            }
            gameInformations.informationHowManyMoves(board.getMoves());
            gameInformations.gameEnd();
        }
    }
