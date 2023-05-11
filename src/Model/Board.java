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
  //      int wordsAdd = 0;
        int maxWords = (getRowUser() * getColumnUser() / 2);
        chooseRangeOfLines = allLines.subList(0, maxWords);
//        while (wordsAdd < maxWords) {
//            monoWordsList.add(chooseRangeOfLines.get(wordsAdd));
 //           wordsAdd++;
//        }
    }

    public void evenList() {
    for(int i=0;i<2;i++){
        for(int a=0;a<chooseRangeOfLines.size();a++){
            wordsList.add(chooseRangeOfLines.get(a));
        }
    }
    }

}