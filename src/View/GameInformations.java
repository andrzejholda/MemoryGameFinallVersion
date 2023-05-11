package View;
import Model.Board;

public class GameInformations {

    public String badChar="Podałeś nieodpowiedni znak, podaj liczbę !";
    public String badCharInformation="Podaj jeszcze raz : ";
    public  void printMemoryGameTitle() {
        String[] colors = {"\033[31m", "\033[32m", "\033[33m", "\033[34m", "\033[35m", "\033[36m"};
        String[] letters = {"W","I","T","A","J"," ","W"," ","M", "E", "M", "O", "R", "Y", " ", "G", "A", "M", "E"};
        int colorIndex = 0;
        for (String letter : letters) {
            System.out.print("\033[1m\033[3m" +colors[colorIndex % colors.length] + letter);// letter repeat incease size of letter
            colorIndex++;
            try {
                Thread.sleep(200); // pauza for 100 milisekund
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\033[0m"); // reset for basic colors
    }
    public void setBoardSize(){System.out.println("Podaj rozmiar planszy do gry - jej rozmiar musi być parzysty");}
    public void wronInput(){System.out.println("Podałeś nieodpowiedni znak, podaj liczbę !");}
    public void rowSet(){System.out.println("Ilość kolum ? :");}
    public void columnSet(){System.out.println("Ilość wierszy ? : ");}
    public void wrongBoardSize(){System.out.println("Podałeś nieodpowiedni rozmiar planszy, spróbuj ponownie");}
    public void printActuallyBoard(Board board){

        System.out.println();
        for(int row=0;row<5;row++){
            for(int column=0;column<5;column++) {
                if (row == 0 && column == 0) {
                    System.out.print("    ");
                } else if (row == 0 && column > 0) {
                    System.out.print(String.format("%-5s"," A" + column) + "|");
                } else if (row > 0 && column == 0) {
                    System.out.print(String.format("%-3s","B" + row)+ " ");
                } else if (row > 0 && column > 0) {
                    System.out.print(String.format("%-5s",board.cards[row - 1][column - 1].getValue())+"|");
                }
            }
            System.out.println();
        }
    }
    public void firstCoordinates(){
        System.out.println("Podaj koordynaty pierwszej karty (wiersz, kolumna):");
    }
    public void badCoordinat(){System.out.println("Podałeś zły zakres liczbowy, podaj zakres pomiędzy 1-4");}
    public void secondCoordinates(){
        System.out.println("Podaj koordynaty drugiej karty (wiersz, kolumna):");
    }
    public void correctMatches(){
        System.out.println("Gratulacje, udało Ci się odgadnąć dwie takie same karty!");
    }
    public void wrongMatches(){
        System.out.println("Niestety, te karty nie pasują do siebie. Spróbuj jeszcze raz.");//

    }
    public void finalInformations(){
        System.out.println("Gratulacje! Wygrałeś!");
    }

    public void gameEnd(){
        System.out.print("GRATULACJE !!! Ukończyłeś grę");
    }
}
