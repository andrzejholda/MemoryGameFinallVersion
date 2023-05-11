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
        for(int row=0;row<= board.getRowUser();row++){
            for(int column=0;column<=board.getColumnUser();column++) {
                if (row == 0 && column == 0) {
                    System.out.print("    ");
                } else if (row == 0 && column > 0) {
                    System.out.print(String.format("%-5s"," A" + column) + "|");
                } else if (row > 0 && column == 0) {
                    System.out.print(String.format("%-3s","B" + row)+ " ");
                } else if (row > 0 && column > 0) {
                    System.out.print(String.format("%-5s",board.getCard(row-1,column-1).getValue())+"|");
                }
            }
            System.out.println();
        }
    }
    public void firstCoordinates(){
        System.out.println("Podaj koordynaty pierwszej karty:");
    }
    public void cardRow(){
        System.out.println("Podaj numer wiersza: ");
    }
    public void cardColumn(){
        System.out.println("Podaj numer kolumny: ");
    }
    public void badCoordinat(){System.out.println("Podaj odpowiednie koordynaty!");}
    public void secondCoordinates(){
        System.out.println("Podaj koordynaty drugiej karty:");
    }
    public void sameCoordinat(){
        System.out.println("Podałeś te same koordynaty, wybierz od nowa drugą kartę !");
    }
    public void correctMatches(){
        System.out.println("Gratulacje, udało Ci się odgadnąć dwie takie same karty!");
    }
    public void wrongMatches(){
        System.out.println("Niestety, te karty nie pasują do siebie. Spróbuj jeszcze raz.");
    }
    public void wrongRow(){
        System.out.println("Podałeś błędną wartość wierszy !");
    }
    public void wrongColumn() {
         System.out.print("Podałeś błędną wartość kolumn !");
    }
    public void finalInformations(){
        System.out.println("Gratulacje! Wygrałeś!");
    }
    public void oddBoardSize(){
        System.out.println("Podany rozmiar jest nie parzysty");
    }
    public void informationAboutEven(){
        System.out.println("Parzysty rozmiar tablicy to np: 2x2,4x5,6x6. Natomiast nieparzysty to np: 3x3,5x7,7x9");
    }
    public void informationHowManyMoves(int moves){
        System.out.println("Wykonane ruchy "+moves);
    }

    public void gameEnd(){
        System.out.print("GRATULACJE !!! Ukończyłeś grę");
    }
}
