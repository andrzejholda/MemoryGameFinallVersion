package View;
import Model.Board;

public class GameInformations {



    public void showLvl(int level){
        System.out.print("Your actually level are: "+ level);
    }

    public void printActuallyBoard( Board board){
        showLvl(board.getLevel());
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
