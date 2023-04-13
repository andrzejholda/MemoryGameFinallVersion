package Model;

import View.GameInformations;

import java.util.*;

public class Board extends Level {

    public static String[][] basicBoard = new String[5][5];
    public Card[][] cards = new Card[4][4];
    private List<String> wordsList = new ArrayList<>();

   private boolean allCardsMatched = false;

    public boolean isAllCardsMatched() {
        return allCardsMatched;
    }

    public boolean checkIfMatched(Card[][] card) {

        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[row].length; col++) {
                if (card[row][col].isMatched() == false) {
                    return false;
                }
            }
        }
        allCardsMatched =true;
        return true;
    }
    //shuffle card - row and column
    public void shuffleCards() {
        Collections.shuffle(wordsList);
    }
    //add
    public void addWordsToArray() {
        int index = 0;
        for (int row = 0; row < cards.length; row++) {
            for (int column = 0; column < cards[0].length; column++) {
                if (index == wordsList.size())
                    index = 0;
                cards[row][column] = new Card(wordsList.get(index));
                index++;
            }
        }
    }
    public void openCard(int row, int column) {
        cards[row -1][column -1].reveal(true);
    }

    public void closeCards(Card card1, Card card2) {
        card1.reveal(false);
        card2.reveal(false);
    }

    public boolean checkMatch(Card card1, Card card2) {
        if(card1.getValue().equals(card2.getValue())){
            card1.reveal(true);
            card1.setMatch(true);
            card2.reveal(true);
            card2.setMatch(true);
            return true;
        } else
            return false;
    }

    public void setWords(){
        for(int i=0;i<2;i++) {
            wordsList.add("KOT");
            wordsList.add("BYK");
            wordsList.add("JEŻ");
            wordsList.add("SŁOŃ");
            wordsList.add("MYSZ");
            wordsList.add("SROKA");
            wordsList.add("PIES");
            wordsList.add("KURA");
        }

        }

//    //set value in object of card
//    public void setCards() {
//        this.cards = cards;
//        cards[0]=new Card[]{new Card("KOT"),new Card("BYK"),new Card("JEŻ"),new Card("SŁOŃ")};
//        cards[1]=new Card[]{new Card("MYSZ"),new Card("SROKA"),new Card("PIES"),new Card("KURA")};
//        cards[2]=new Card[]{new Card("KOT"),new Card("BYK"),new Card("JEŻ"),new Card("SŁOŃ")};
//        cards[3]=new Card[]{new Card("MYSZ"),new Card("SROKA"),new Card("PIES"),new Card("KURA")};
//    }
//

}
