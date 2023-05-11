package Model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Board extends Level {


    private List<List<Card>> cards = new ArrayList<>();
    private List<String> wordsList = new ArrayList<>();
    private int rowUser;
    private int columnUser;
    private int moves=0;
    Path filePath = Paths.get("C:/Programowanie/Task1/Words.txt");
    //specifies the encoding of the file
    Charset charset = Charset.forName("UTF-8");
    List<String> allLines = Files.readAllLines(filePath, charset);
    List<String> chooseRangeOfLines = new ArrayList<>();
    private boolean isBoardSizeCorrect=false;
    public boolean isBoardSizeCorrect() {
        return this.isBoardSizeCorrect;
    }
    public void setBoardSizeCorrect(boolean boardSizeCorrect) {
        this.isBoardSizeCorrect=boardSizeCorrect;
    }

    public String readIntInput(Scanner scanner, String badChar, String badCharInformation) {
    while (!scanner.hasNextInt()) {
        System.out.println(badChar);
        System.out.println(badCharInformation);
        scanner.next();
    }return null;
}
    public Board() throws IOException {
    }

    public Card getCard(int rowIndex, int columnIndex) {
        return cards.get(rowIndex).get(columnIndex);
    }

    public List<List<Card>> getCards() {
        return cards;
    }

    public List<Card> getCardsColumn(int rowIndex) {
        return cards.get(rowIndex);
    }

    public int getCardRow() {
        return cards.size();
    }

    public void setRowUser(int rowUser) {
        this.rowUser = rowUser;
    }

    public void setColumnUser(int columnUser) {
        this.columnUser = columnUser;
    }

    public int getRowUser() {
        return rowUser;
    }

    public int getColumnUser() {
        return columnUser;
    }

    public int getMoves(){
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves++;
    }

    public int increaseMoves(){
        this.moves++;
        return moves;
    }

    private boolean allCardsMatched = false;

    public boolean isAllCardsMatched() {
        return allCardsMatched;
    }

    //checks if all cards are guessed
    public boolean checkIfMatched() {
        for (int row = 0; row < cards.size(); row++) {
            for (int col = 0; col < cards.get(row).size(); col++) {
                if (cards.get(row).get(col).isMatched() == false) {
                    return false;
                }
            }
        }
        allCardsMatched = true;
        return true;
    }

    //shuffle wordlist
    public void shuffleWords() {
        Collections.shuffle(wordsList);
    }

    //add word to array
    public void addWordsToArray() {
        if (wordsList.isEmpty()) {
            // return info
            System.out.print("Pusto");
            return;
        }
        int index = 1;
        for (int row = 0; row < getRowUser(); row++) {
            cards.add(new ArrayList<>());
            for (int column = 0; column < getColumnUser(); column++) {
                if (index == wordsList.size())
                    index = 0;
                cards.get(row).add(new Card(wordsList.get(index)));
                index++;
            }
        }
    }

    //open the selected card
    public void openCard(int row, int column) {
        cards.get(row - 1).get(column - 1).reveal(true);
    }

    //close the selceted card
    public void closeCards(Card card1, Card card2) {
        card1.reveal(false);
        card2.reveal(false);
    }

    //check match selected card
    public boolean checkMatch(Card card1, Card card2) {
        if (card1.getValue().equals(card2.getValue())) {
            card1.reveal(true);
            card1.setMatch(true);
            card2.reveal(true);
            card2.setMatch(true);
            return true;
        } else
            return false;
    }

    //set words at list
    public void setWords() {
        int maxWords = (getRowUser() * getColumnUser() / 2);
        chooseRangeOfLines = allLines.subList(0, maxWords);
    }
    // duplicate List
    public void evenList() {
    for(int i=0;i<2;i++){
        for(int a=0;a<chooseRangeOfLines.size();a++){
            wordsList.add(chooseRangeOfLines.get(a));
        }
    }
    }

}