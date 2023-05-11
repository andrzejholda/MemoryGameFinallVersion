package Model;
public class Card {

    private String value;
    private boolean isMatched;
    private boolean isRevealed;


    public Card(String value){
        this.value=value;
        this.isMatched=false;
        this.isRevealed=false;
    }
    //getting value and chang it to hiden
    public String getValue(){
        if(isRevealed){
            return value;
        }
        else {
            return "*";
        }
    }

    public void reveal(boolean value){
        this.isRevealed=value;
    }

    public boolean isMatched(){
        return this.isMatched;
    }
    public void setMatch(boolean matched){
        this.isMatched=matched;
    }


}
